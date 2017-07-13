package Polymorphism;

/**
 * Created by Administrator on 2017/6/20 0020.
 */
public class Cat extends Animal {
    int num = 80;
    static int age = 90;
    String name = "tomCat";
    public void eat() {
        System.out.println("猫吃饭");
    }
    public static void sleep() {
        System.out.println("猫在睡觉");
    }
    public void catchMouse() {
        System.out.println("猫在抓老鼠");
    }
}
