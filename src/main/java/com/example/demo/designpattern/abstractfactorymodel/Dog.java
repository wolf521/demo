package com.example.demo.designpattern.abstractfactorymodel;

/**
 * Created by cuizhixiang on 2017/7/31.
 * 接口实现类
 **/
public class Dog implements Animal {
    @Override
    public void eat() {
        System.out.println("狗吃骨头");
    }
}
