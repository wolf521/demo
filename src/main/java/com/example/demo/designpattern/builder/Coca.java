package com.example.demo.designpattern.builder;

/**
 * Created by cuizhixiang on 2017/8/15.
 * 可口可乐
 **/
public class Coca extends ColdDrink{
    @Override
    public String name() {
        return "可口可乐";
    }

    @Override
    public double price() {
        return 5.0;
    }
}
