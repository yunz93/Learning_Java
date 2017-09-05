package com.yunz.Singleton;

/**
 * 单例模式测试类
 */
public class Test {
    public static void main(String[] args) {
        // 懒汉线程不安全
        LazySingleton singleton1 = LazySingleton.getInstance();
        LazySingleton singleton2 = LazySingleton.getInstance();
        System.out.println(singleton1.equals(singleton2));

        // 懒汉线程安全
        LazySynSingleton singleton3 = LazySynSingleton.getInstance();
        LazySynSingleton singleton4 = LazySynSingleton.getInstance();
        System.out.println(singleton3.equals(singleton4));

        // 双重校验锁
        DoubleSynSingleton singleton5 = DoubleSynSingleton.getInstance();
        DoubleSynSingleton singleton6 = DoubleSynSingleton.getInstance();
        System.out.println(singleton3.equals(singleton4));

        // 静态内部类
        StaticSingleton singleton7 = StaticSingleton.getInstance();
        StaticSingleton singleton8 = StaticSingleton.getInstance();
        System.out.println(singleton7.equals(singleton8));

        // 枚举方式
        EnumSingleton singleton9 = EnumSingleton.getInstance();
        EnumSingleton singleton10 = EnumSingleton.getInstance();
        System.out.println(singleton9.equals(singleton10));
    }
}
