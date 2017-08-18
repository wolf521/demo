package com.example.demo.designpattern.builder;

/**
 * Created by cuizhixiang on 2017/8/15.
 *  牛肉汉堡
 **/
public class BeefBurder extends HamBurder{
    @Override
    public String name() {
        return "牛肉汉堡";
    }

    @Override
    public double price() {
        return 15.0;
    }
}
