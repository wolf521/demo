package com.example.demo.designpattern.singleton;

/**
 * Created by cuizhixiang on 2017/8/3.
 * 单例模式
 **/
public class Singleton {
    private static SingletonObject singletonObject;

    public static SingletonObject getInstance() {
        if(singletonObject == null){
            singletonObject = new SingletonObject();
        }
        return singletonObject;
    }
}
