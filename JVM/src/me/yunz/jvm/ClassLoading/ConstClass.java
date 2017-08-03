package me.yunz.jvm.ClassLoading;

/**
 * Created by Administrator on 2017/8/3 0003.
 */
public class ConstClass {
    static {
        System.out.println("ConstClass init!");
    }

    public static final String HELLOWORLD = "hello world!";
}
