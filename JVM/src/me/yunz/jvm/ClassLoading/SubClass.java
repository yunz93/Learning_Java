package me.yunz.jvm.ClassLoading;

/**
 * Created by Administrator on 2017/8/3 0003.
 */
public class SubClass extends SuperClass {
    static {
        System.out.println("SubClass init!");
    }
}
