package com.yunz.Singleton;

/**
 * 饿汉式
 * 一旦类被加载就会生成实例
 */
public class HungrySingleton {

    private static HungrySingleton instance = new HungrySingleton();

    private HungrySingleton (){}

    public static HungrySingleton getInstance() {
        return instance;
    }
}
