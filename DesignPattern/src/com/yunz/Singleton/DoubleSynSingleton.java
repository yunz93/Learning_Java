package com.yunz.Singleton;

/**
 * 双重检验锁方式
 * LazySynSingleton升级版
 */
public class DoubleSynSingleton {
    private volatile static DoubleSynSingleton instance;

    private DoubleSynSingleton (){}

    public static DoubleSynSingleton getInstance() {
        if (instance == null) {
            synchronized (DoubleSynSingleton.class) {
                if (instance == null) {
                    instance = new DoubleSynSingleton();
                }
            }
        }
        return instance;
    }
}
