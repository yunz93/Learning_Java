package com.yunz.Singleton;

/**
 * 懒汉式
 * 线程不安全写法
 */
public class LazySingleton {
    // 静态实例
    private static LazySingleton instance;
    // 私有构造方法
    private LazySingleton (){}
    // get方法
    public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
