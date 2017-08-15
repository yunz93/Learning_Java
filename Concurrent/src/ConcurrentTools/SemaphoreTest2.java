package ConcurrentTools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

class Car implements Runnable {
    private final Semaphore parkingSlot;
    private int carNo;

    public Car(Semaphore parkingSlot, int carNo) {
        this.parkingSlot = parkingSlot;
        this.carNo = carNo;
    }

    public void run() {
        try {
            parkingSlot.acquire();    // �����Ի�ȡ"��λ"
            parking();
            sleep(300);
            leaving();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            parkingSlot.release();    // �ͷ�"��λ"
        }
    }

    private void parking() {
        System.out.println(String.format("%d�ų�����", carNo));
    }

    private void leaving() {
        System.out.println(String.format("%d�ų��뿪��λ", carNo));
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}


public class SemaphoreTest2 {
    private static final int NUMBER_OF_CARS = 10;
    private static final int NUMBER_OF_PARKING_SLOT = 5;

    public static void main(String[] args) {
        Semaphore parkingSlot = new Semaphore(NUMBER_OF_PARKING_SLOT, true);    // "��λ",����FIFO,����true��


        ExecutorService service = Executors.newCachedThreadPool();    // �����̳߳ء�ģ��10����"ͣ��"��
        for (int carNo = 1; carNo <= NUMBER_OF_CARS; carNo++) {
            service.execute(new Car(parkingSlot, carNo));
        }

        sleep(3000);
        service.shutdown();    // �ر��̳߳ء�

        // ���ʣ������õ���Դ����
        System.out.println(parkingSlot.availablePermits() + " ��ͣ��λ������!");
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
