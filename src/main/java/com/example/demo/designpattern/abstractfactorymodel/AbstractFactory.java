package com.example.demo.designpattern.abstractfactorymodel;

/**
 * Created by cuizhixiang on 2017/7/31.
 * 抽象工厂模式：调用方法，创建工厂
 **/
public abstract class AbstractFactory {
    abstract Color getColor(String color);

    abstract Animal getAnimal(String animal);
}
