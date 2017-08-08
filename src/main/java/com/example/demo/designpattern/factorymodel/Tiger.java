package com.example.demo.designpattern.factorymodel;

/**
 * Created by cuizhixiang on 2017/7/31.
 * 接口实现类
 **/
public class Tiger implements Animal{
    @Override
    public void eat() {
        System.out.println("老虎吃肉");
    }
}
