package com.example.demo.designpattern.builder;

/**
 * Created by cuizhixiang on 2017/8/15.
 * 鸡肉汉堡
 **/
public class ChickenBurder extends HamBurder{
    @Override
    public String name() {
        return "鸡肉汉堡";
    }

    @Override
    public double price() {
        return 12.0;
    }
}
