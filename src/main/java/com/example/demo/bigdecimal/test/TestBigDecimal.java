package com.example.demo.bigdecimal.test;

import java.math.BigDecimal;

/**
 * Created by cuizhixiang on 2017/6/15.
 **/
public class TestBigDecimal {
    public static void main(String args[]){
       new TestBigDecimal().test1();
    }

    public void test(){
        System.out.println(0.05+0.01);
        System.out.println(1.0-0.42);
        System.out.println(4.015*100);
        System.out.println(123.3/100);
    }

    public void test1(){
        BigDecimal b1 = new BigDecimal("4.015");
        BigDecimal b2 = new BigDecimal("100");
        // 加:add
        System.out.println(b1.add(b2));
        // 减:subtract
        System.out.println(b1.subtract(b2));

        // 乘:multiply
        System.out.println(b1.multiply(b2));
        // 除:divide
        System.out.println(b1.divide(b2));
        // 取绝对值:abs
        System.out.println(b1.abs());
        // 比大小:compareTo，小于：-1、等于：-1、大于：1。
        System.out.println(b1.compareTo(b2));
        // 取对数:negate
        System.out.println(b1.negate());
        // 取指数：pow
        System.out.println(b1.pow(2));
    }

    public void test2(){
        System.out.println(BigDecimal.ONE);
        System.out.println(BigDecimal.ZERO);
        System.out.println(BigDecimal.TEN);
        System.out.println(BigDecimal.ROUND_CEILING);
        System.out.println(BigDecimal.ROUND_DOWN);
        System.out.println(BigDecimal.ROUND_FLOOR);
        System.out.println(BigDecimal.ROUND_UP);
    }
}
