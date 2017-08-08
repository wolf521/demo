package com.example.demo.designpattern.abstractfactorymodel;

/**
 * Created by cuizhixiang on 2017/8/2.
 **/
public class AbstractFactoryDemo {
    public static void main(String agrs[]){
        testColor();testAnimal();
    }
    public static void testColor(){
        AbstractFactory abstractFactory = new ColorFactory();
        abstractFactory.getColor("red").color();
        abstractFactory.getColor("yellow").color();
        abstractFactory.getColor("black").color();
    }
    public static void testAnimal(){
        AbstractFactory abstractFactory = new AnimalFactory();
        abstractFactory.getAnimal("dog").eat();
        abstractFactory.getAnimal("cat").eat();
        abstractFactory.getAnimal("tiger").eat();
    }
}
