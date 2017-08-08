package com.example.demo.designpattern.factorymodel;

/**
 * Created by cuizhixiang on 2017/7/31.
 * 测试
 **/
public class AnimalDemo {
    public static void main(String agrs[]){
        testDog();
        testCat();
        testTiger();
    }
    public static void testDog(){
        Animal animal = AnimalFactory.getAnimal("dog");
        animal.eat();
    }
    public static void testCat(){
        Animal animal = AnimalFactory.getAnimal("cat");
        animal.eat();
    }
    public static void testTiger(){
        Animal animal = AnimalFactory.getAnimal("tiger");
        animal.eat();
    }
}
