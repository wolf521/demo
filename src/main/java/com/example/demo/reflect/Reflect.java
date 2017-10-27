package com.example.demo.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by Administrator on 2017/10/27.
 * 反射
 */
public class Reflect {
    public static void main(String agrs[])throws Exception {
        Class person = Person.class;
        Class person1 = new Person().getClass();
        Class person2 = Class.forName("com.example.demo.reflect.Person");
        System.out.println(person.getPackage());
        System.out.println(person1.getPackage());
        System.out.println(person2.getPackage());

        System.out.println(person.getName());
        System.out.println(person.getSuperclass());
        System.out.println(person.getInterfaces());

        Constructor constructor[] = person.getConstructors();
        Constructor constructor2[] = person.getDeclaredConstructors();
        Method method[] = person.getMethods();
        Method method1[] = person.getDeclaredMethods();
        Field field[] = person.getFields();
        Field field1[] = person.getDeclaredFields();
        Class aClass[] = person.getClasses();
        Class aClass1[] = person.getDeclaredClasses();
        Class aClass2 = person.getDeclaringClass();
        int i = constructor[0].getModifiers();
        field1[0].setAccessible(true);
        field1[0].getName();
        field1[0].getType();
        Person person3 = new Person();
        field1[0].set(person3,"小黑");
        field1[0].get(person3);
        method1[0].getName();
        method1[0].getParameterTypes();
        method1[0].getReturnType();
        method1[0].getExceptionTypes();
        method1[0].invoke(new Person(),"是条狗");
    }
}
class Person{
    private String name = "小明";
    private Integer age = 21;
    private boolean isMale = true;

    public Person(String name) {
        this.name = name;
    }

    public Person() {}

    public Person(String name, Integer age, boolean isMale) {
        this.name = name;
        this.age = age;
        this.isMale = isMale;
    }

    private Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public void eat(String str){
        System.out.println("小明爱吃肉"+str);
    }
    private void like(){
        System.out.println("小明喜欢小黑");
    }
}
