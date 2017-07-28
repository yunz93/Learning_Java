package ConcurrentTools;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch 允许一个或多个线程等待其他线程完成操作
 * 当我们调用一次CountDownLatch的countDown方法时，N就会减1
 * CountDownLatch的await会阻塞当前线程，直到N变成零
 * Created by Administrator on 2017/7/28 0028.
 */
public class CountDownLatchTest {
    static CountDownLatch c = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
                c.countDown();
                System.out.println(2);
                c.countDown();
            }
        }).start();

        c.await();
        System.out.println(3);
    }
}
