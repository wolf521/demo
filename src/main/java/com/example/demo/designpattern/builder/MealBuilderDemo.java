package com.example.demo.designpattern.builder;

/**
 * Created by cuizhixiang on 2017/8/15.
 * 见着这点餐
 **/
public class MealBuilderDemo {

    public static void main(String agrs[]) {
        getFood();
    }

    public static void getFood() {
        Meal meal = MealBuilder.getInstance();
        meal.addFood(new Coca());
        meal.addFood(new BeefBurder());
        meal.addFood(new Coca());
        meal.addFood(new BeefBurder());
        meal.showMeal();
    }
}
