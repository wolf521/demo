package com.example.demo.designpattern.factorymodel;

/**
 * Created by cuizhixiang on 2017/7/31.
 * 接口实现类
 **/
public class Cat implements Animal {
    @Override
    public void eat() {
        System.out.println("猫吃鱼");
    }
}
