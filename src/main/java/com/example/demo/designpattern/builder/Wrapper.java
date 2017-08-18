package com.example.demo.designpattern.builder;

/**
 * Created by cuizhixiang on 2017/8/15.
 *  纸袋
 **/
public class Wrapper implements Packing{
    @Override
    public String pack() {
        return "纸袋";
    }
}
