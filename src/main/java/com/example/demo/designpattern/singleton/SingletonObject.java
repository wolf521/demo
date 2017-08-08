package com.example.demo.designpattern.singleton;

/**
 * Created by cuizhixiang on 2017/8/3.
 * 单例模式
 **/
public class SingletonObject {
    private static SingletonObject singletonObject = new SingletonObject();

    public static SingletonObject getInstance() {
        return singletonObject;
    }
}
