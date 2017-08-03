package me.yunz.jvm.ClassLoading;

/**
 * 常量在编译阶段会存入调用类的常量池中，本质上并没有直接饮用到定义常量的类
 * 因此不会处罚定义常量的类的初始化
 * Created by Administrator on 2017/8/3 0003.
 */
public class NotInitializationIII {
    public static void main(String[] args) {
        System.out.println(ConstClass.HELLOWORLD);
    }
}
