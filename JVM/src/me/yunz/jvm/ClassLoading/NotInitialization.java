package me.yunz.jvm.ClassLoading;

/**
 * 通过子类引用父类的静态字段，不会导致子类的初始化
 * Created by Administrator on 2017/8/3 0003.
 */
public class NotInitialization {
    public static void main(String[] args) {
        System.out.println(SubClass.value);
    }
}
