package ConcurrentTools;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CyclicBarrier 的字面意思是可循环使用（Cyclic）的屏障（Barrier）
 * 让一组线程到达一个屏障（也可以叫同步点）时被阻塞，直到最后一个线程到达屏障时，屏障才会开门
 * 所有被屏障拦截的线程才会继续干活
 * Created by Administrator on 2017/7/28 0028.
 */
public class CyclicBarrierTest {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        final CyclicBarrier barrier = new CyclicBarrier(4, new Runnable() {

            @Override
            public void run() {
                System.out.println("好了，大家可以去吃饭了……"  );
            }
        });

        System.out.println("要吃饭，必须所有人都到终点，oK?");
        System.out.println("不放弃不抛弃！");

        for (int i = 0; i < 4; i++) {
            exec.execute(new Runnable() {

                @Override
                public void run() {
                    System.out
                            .println(Thread.currentThread().getName() + ":Go");
                    try {
                        Thread.sleep((long) (2000 * Math.random()));
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()
                            + ":我到终点了");
                    try {
                        barrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName()
                            + ":终于可以吃饭啦！");

                }
            });
        }
        exec.shutdown();

    }
}