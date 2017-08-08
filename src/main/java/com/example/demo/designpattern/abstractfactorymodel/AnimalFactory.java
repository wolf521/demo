package com.example.demo.designpattern.abstractfactorymodel;

/**
 * Created by cuizhixiang on 2017/7/31.
 **/
public class AnimalFactory extends AbstractFactory {
    @Override
    Color getColor(String color) {
        return null;
    }

    @Override
    Animal getAnimal(String animal) {
        if (animal == null) return null;
        if (animal.equalsIgnoreCase("dog")) return new Dog();
        if (animal.equalsIgnoreCase("cat")) return new Cat();
        if (animal.equalsIgnoreCase("tiger")) return new Tiger();
        return null;
    }
}
