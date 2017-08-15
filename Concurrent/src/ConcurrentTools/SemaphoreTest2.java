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
            parkingSlot.acquire();    // 车尝试获取"车位"
            parking();
            sleep(300);
            leaving();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            parkingSlot.release();    // 释放"车位"
        }
    }

    private void parking() {
        System.out.println(String.format("%d号车泊车", carNo));
    }

    private void leaving() {
        System.out.println(String.format("%d号车离开车位", carNo));
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
        Semaphore parkingSlot = new Semaphore(NUMBER_OF_PARKING_SLOT, true);    // "车位",采用FIFO,设置true。


        ExecutorService service = Executors.newCachedThreadPool();    // 创建线程池。模拟10辆车"停车"。
        for (int carNo = 1; carNo <= NUMBER_OF_CARS; carNo++) {
            service.execute(new Car(parkingSlot, carNo));
        }

        sleep(3000);
        service.shutdown();    // 关闭线程池。

        // 输出剩余可以用的资源数。
        System.out.println(parkingSlot.availablePermits() + " 个停车位可以用!");
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
