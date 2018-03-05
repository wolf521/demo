package com.example.demo.genericparadigm;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/3/5.
 * 泛型是一种在编译期间确定类型的机制
 * 泛型使程序具有更好的可读性和安全性。
 * java泛型值存在于编译期间，在编译后泛型信息被擦除
 */
public class Test {
    public static void main(String[] agrs){
        // 限定通配符 类型必须是Fruit子类设定的上界
        ArrayList<? extends Fruit> flist = new ArrayList<Apple>();
        // 限定通配符 类型必须是Apple父类设定的下界
        ArrayList<? super Apple> flist1= new ArrayList<Fruit>();
        // 非限定通配符
        ArrayList<?> flist2 = new ArrayList<Fruit>();
        // 不使用泛型类型不安全，代码可读性差
        ArrayList flist3 = new ArrayList();
        flist3.add(1);
        flist3.add('3');
    }
}
