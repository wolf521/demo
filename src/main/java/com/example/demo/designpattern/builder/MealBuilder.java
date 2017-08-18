package com.example.demo.designpattern.builder;

/**
 * Created by cuizhixiang on 2017/8/15.
 **/
public class MealBuilder {
    private static Meal ourInstance = new Meal();

    public static Meal getInstance() {
        return ourInstance;
    }

    private MealBuilder() {}
}
