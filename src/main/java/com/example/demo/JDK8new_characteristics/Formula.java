package com.example.demo.JDK8new_characteristics;

/**
 * Created by Administrator on 2018/3/5.
 */
public interface Formula {
    double calculate(int a);
    default double sqrt(int a) {
        return Math.sqrt(a);
    }
}
