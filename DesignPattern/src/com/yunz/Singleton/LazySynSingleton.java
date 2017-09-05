package com.yunz.Singleton;

/**
 * 懒汉式
 * 线程安全写法
 */

public class LazySynSingleton {
    // 静态实例
    private static LazySynSingleton instance;
    // 私有构造方法
    private LazySynSingleton(){}
    // 同步
    public static synchronized LazySynSingleton getInstance() {
        if (instance == null) {
            instance = new LazySynSingleton();
        }
        return instance;
    }

}
