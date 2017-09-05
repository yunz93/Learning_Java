package com.yunz.Singleton;

/**
 * 静态内部类方式
 * 不会在类加载的时候就生成实例
 */
public class StaticSingleton {
    private static class SingletonHolder {
        private static final StaticSingleton INSTANCE = new StaticSingleton();
    }
    private StaticSingleton (){}

    public static final StaticSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
