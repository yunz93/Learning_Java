package me.yunz.jvm.ClassLoading;

/**
 * Created by Administrator on 2017/8/3 0003.
 */
public class SuperClass {
    static {
        System.out.println("SuperClass init!");
    }

    public static int value = 123;
}
