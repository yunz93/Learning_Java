package me.yunz.jvm.ClassLoading;

/**
 * 通过数组定义来引用类，不会触发此类的初始化
 * Created by Administrator on 2017/8/3 0003.
 */
public class NotInitializationII {
    public static void main(String[] args) {
        SuperClass[] sca = new SuperClass[10];
    }
}
