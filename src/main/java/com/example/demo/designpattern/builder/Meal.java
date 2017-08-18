package com.example.demo.designpattern.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cuizhixiang on 2017/8/15.
 *  食品套餐
 **/
public class Meal {
    List<Food> foods = new ArrayList<Food>();

    /**
     * 添加食物
     *
     * @param food
     */
    public void addFood(Food food){
        foods.add(food);
    }

    /**
     * 结算账单
     */
    public double getCost(){
        double d = 0.0;
        for(Food food:foods){
            d += food.price();
        }
        return d;
    }

    /**
     * 展示套餐
     */
    public void showMeal(){
        for(Food food:foods){
            System.out.println("名称："+food.name()+"，价格："+food.price()+"，包装："+food.packing());
        }
        System.out.println("总计："+getCost());
    }
}
