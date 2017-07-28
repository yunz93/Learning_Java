package ConcurrentTools;

/**
 * join用于让当前执行线程等待join线程执行结束
 * 其实现原理是不停检查join线程是否存活，如果join线程存活则让当前线程永远wait
 * Created by Administrator on 2017/7/28 0028.
 */
public class JoinCountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread1 finish");
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread2 finish");
            }
        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("main thread finish");
    }

}
