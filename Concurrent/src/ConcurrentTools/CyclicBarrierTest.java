package ConcurrentTools;

import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier 的字面意思是可循环使用（Cyclic）的屏障（Barrier）
 * 让一组线程到达一个屏障（也可以叫同步点）时被阻塞，直到最后一个线程到达屏障时，屏障才会开门
 * 所有被屏障拦截的线程才会继续干活
 * Created by Administrator on 2017/7/28 0028.
 */
public class CyclicBarrierTest {

    static CyclicBarrier c = new CyclicBarrier(3);

    public static void main(String[] args) {
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    c.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(1);
            }
        }).start();

        try {
            c.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(2);
    }
}