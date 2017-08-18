package com.example.demo.designpattern.builder;

/**
 * Created by cuizhixiang on 2017/8/15.
 * 塑料瓶
 **/
public class Bottle implements Packing {
    @Override
    public String pack() {
        return "塑料瓶";
    }
}
