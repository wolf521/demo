package com.example.demo.designpattern.singleton;

/**
 * Created by cuizhixiang on 2017/8/3.
 **/
public class SingletonObjectDemo {
    public static void main(String []args){
        testSingletonObject();
        testSingleton();
    }
    public static void testSingletonObject(){
        System.out.println(SingletonObject.getInstance() == SingletonObject.getInstance());
        System.out.println(SingletonObject.getInstance().hashCode());
        System.out.println(SingletonObject.getInstance().hashCode());
        System.out.println(new SingletonObject().hashCode());
    }
    public static void testSingleton(){
        System.out.println(Singleton.getInstance() == Singleton.getInstance());
        System.out.println(Singleton.getInstance().hashCode());
        System.out.println(Singleton.getInstance().hashCode());
        System.out.println(new Singleton().hashCode());
    }
}
