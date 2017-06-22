package com.example.demo.collection;

import com.example.model.User;

import java.util.*;

/**
 * Created by cuizhixiang on 2017/6/22.
 **/
public class TestSet {
    public static void main(String agrs[]){
        TestSet.test2();
    }
    public static void test(){
        Set<User> set = new HashSet<User>();
        User user = new User("狮子","15456489",56);
        set.add(user);
        set.add(user);
        set.add(user);
        set.add(new User("老虎","154648",58));
        set.add(new User("老虎","154648",58));
        set.add(new User("猎豹","154648",58));
        set.add(new User("大象","154648",58));
        set.add(new User("袋鼠","154648",58));
        set.add(new User("企鹅","154648",58));
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    public static void test1(){
        TreeSet<String> set = new TreeSet<String>();
        set.add("a");
        set.add("d");
        set.add("c");
        set.add("t");
        set.add("h");
        set.add("k");
        set.add("o");
        set.add("e");
        System.out.println(set.ceiling("h"));
        Iterator<String> iterator = set.descendingIterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("*********************");
        System.out.println(set.first());
        System.out.println(set.last());
        System.out.println(set.lower("e"));
        System.out.println(set.higher("a"));
    }
    public static void test2(){
        TreeSet<User> set = new TreeSet<User>();
        set.add(new User("华山","1546548",56));
        set.add(new User("衡山","1546548",56));
        set.add(new User("嵩山","1546548",96));
        set.add(new User("恒山","55",56));
        set.add(new User("泰山","1546548",56));
        System.out.println(set);
        Iterator<User> iterator = set.descendingIterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    public static void test3(){
        EnumSet<Number> enumSet = EnumSet.allOf(Number.class);
        enumSet.add(Number.ONE);
        System.out.println(enumSet.size());
        Collection<Number> collection = new HashSet<Number>();
        collection.add(Number.SEVEN);
        EnumSet<Number> set1 = EnumSet.copyOf(collection);
        System.out.println(set1.size());
        EnumSet<Number> set2 = EnumSet.noneOf(Number.class);
        System.out.println(set2.size());
        EnumSet<Number> set3 = EnumSet.range(Number.FIVE, Number.TEN);
        System.out.println(set3.size());
    }
}
