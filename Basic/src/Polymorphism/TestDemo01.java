package Polymorphism;

/**
 * Created by Administrator on 2017/6/20 0020.
 */
public class TestDemo01 {
    public static void main(String[] args) {

        Animal am = new Cat();
        am.eat();
        am.sleep();
        am.run();
//	am.catchMouse();
//	System.out.println(am.name);
        System.out.println(am.num);
        System.out.println(am.age);

        System.out.println("------------------------------");
        Cat ct = (Cat)am;
        ct.eat();
        ct.sleep();
        ct.run();
        ct.catchMouse();
    }
}
