package com.example.demo.designpattern.builder;

/**
 * Created by cuizhixiang on 2017/8/15.
 *  百事可乐
 **/
public class Pepsi extends ColdDrink{
    @Override
    public String name() {
        return "百事可乐";
    }

    @Override
    public double price() {
        return 4.9;
    }
}
