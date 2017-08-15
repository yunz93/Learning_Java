package ConcurrentTools;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * CountDownLatch ����������ʾ��demo
 */

public class CountDownLatchTest2 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        CountDownLatch latch = new CountDownLatch(3);    // ͬ��������������

        Worker w1 = new Worker(latch, "����");
        Worker w2 = new Worker(latch, "����");
        Worker w3 = new Worker(latch, "����");
        Boss boss = new Boss(latch);

        executor.execute(w3);    // ���˹�����
        executor.execute(w2);
        executor.execute(w1);
        executor.execute(boss);    // �ϰ幤����

        executor.shutdown();
    }
}

class Worker implements Runnable {
    private CountDownLatch downLatch;
    private String name;

    public Worker(CountDownLatch downLatch, String name) {
        this.downLatch = downLatch;
        this.name = name;
    }

    @Override
    public void run() {
        this.doWork();
        try {
            TimeUnit.SECONDS.sleep(new Random().nextInt(10));  // ����ʱ����
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(this.name + "������ˣ�");
        this.downLatch.countDown();  // ������1��
    }

    private void doWork() {
        System.out.println(this.name + "���ڹ���");
    }
}

class Boss implements Runnable {
    private CountDownLatch downLatch;

    public Boss(CountDownLatch downLatch) {
        this.downLatch = downLatch;
    }

    public void run() {
        System.out.println("�ϰ����ڵ����еĹ��˸����......");
        try {
            this.downLatch.await();    // ��������Ϊ0ʱ���߳���Զ������Ϊ0�����ִ�С�
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("���˻�����ˣ��ϰ忪ʼ����ˣ�");
    }

}