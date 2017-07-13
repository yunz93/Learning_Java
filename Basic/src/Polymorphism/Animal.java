package Polymorphism;

/**
 * Created by Administrator on 2017/6/20 0020.
 */
public class Animal {
    int num = 10;
    static int age = 20;
    public void eat() {
        System.out.println("动物吃饭");
    }

    public static void sleep() {
        System.out.println("动物在睡觉");
    }

    public void run(){
        System.out.println("动物在奔跑");
    }
}
