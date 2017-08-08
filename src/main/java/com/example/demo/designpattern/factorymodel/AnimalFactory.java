package com.example.demo.designpattern.factorymodel;

/**
 * Created by cuizhixiang on 2017/7/31.
 * 工厂模式：调用方法，创建对象
 **/
public class AnimalFactory {
    public static Animal getAnimal(String animalType) {
        if (animalType == null) return null;
        if (animalType.equalsIgnoreCase("dog")) return new Dog();
        if (animalType.equalsIgnoreCase("cat")) return new Cat();
        if (animalType.equalsIgnoreCase("tiger")) return new Tiger();
        return null;
    }
}
