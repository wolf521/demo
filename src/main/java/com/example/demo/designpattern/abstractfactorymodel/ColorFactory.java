package com.example.demo.designpattern.abstractfactorymodel;

/**
 * Created by cuizhixiang on 2017/7/31.
 * 颜色工厂
 **/
public class ColorFactory extends AbstractFactory {
    @Override
    Color getColor(String color) {
        if (color == null) return null;
        if (color.equalsIgnoreCase("red")) return new Red();
        if (color.equalsIgnoreCase("black")) return new Black();
        if (color.equalsIgnoreCase("yellow")) return new Yellow();
        return null;
    }

    @Override
    Animal getAnimal(String animal) {
        return null;
    }
}
