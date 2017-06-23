package com.example.demo.collection;

import com.example.model.User;

import java.util.*;

/**
 * Created by cuizhixiang on 2017/6/23.
 **/
public class TestMap {
    public static void main(String args[]){
        TestMap.test3();
    }
    public static void test(){
        Map<String,User> map = new HashMap<String,User>();
        map.put("tiger",new User("老虎","1564548",59));
        map.put("dog",new User("狗","15648885",59));
        map.put("cat",new User("猫","156488964",59));
        map.put("chicken",new User("鸡","4564688",59));
        map.put("duck",new User("鸭","456465",59));
        map.put("fish",new User("鱼","45648586",59));
        map.put("pig",new User("猪","212155",59));
        System.out.println(map);
        System.out.println(map.size());
        System.out.println(map.isEmpty());
        System.out.println(map.hashCode());
        System.out.println("*************************************");
        Map<String,User> map1 = new HashMap<String,User>();
        map1.put("person",new User("人类","456896565",45));
        map1.putAll(map);
        map1.remove("duck");
        System.out.println(map1);
        System.out.println(map1.containsKey("duck"));
        System.out.println(map1.containsKey("pig"));
        System.out.println(map1.containsValue(new User("人类","456896565",45)));
    }
    public static void test1(){
        Map<String,User> map = new HashMap<String,User>();
        map.put("tiger",new User("老虎","1564548",59));
        map.put("dog",new User("狗","15648885",59));
        map.put("cat",new User("猫","156488964",59));
        map.put("chicken",new User("鸡","4564688",59));
        map.put("duck",new User("鸭","456465",59));
        map.put("fish",new User("鱼","45648586",59));
        map.put("pig",new User("猪","212155",59));
        System.out.println("forEach便利值************************");
        Collection<User> collection = map.values();
        for(User user:collection){
            System.out.println(user);
        }
        System.out.println("forEach便利keySet()************************");
        Set<String> set = map.keySet();
        for(String s:set){
            System.out.println(s);
            System.out.println(map.get(s));
        }
        System.out.println("forEach便利keySet()的迭代器************************");
        Iterator<String> iterator = map.keySet().iterator();
        while(iterator.hasNext()){
            String key = iterator.next();
            System.out.println(key);
            System.out.println(map.get(key));
        }
        System.out.println("forEach便利map.entrySet()************************");
        Set<Map.Entry<String,User>> entries = map.entrySet();
        for(Map.Entry<String,User> entry:entries){
            System.out.println(entry.getKey());
            if("pig".equals(entry.getKey())){
                System.out.println(entry.setValue(new User("肉","46546565",45)));
            }
            System.out.println(entry.getValue());
        }
        System.out.println("forEach便利map.entrySet()的迭代器************************");
        Iterator<Map.Entry<String,User>> iterator1 = map.entrySet().iterator();
        while(iterator1.hasNext()){
            Map.Entry<String,User> entry = iterator1.next();
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }
    public static void test2(){
        Hashtable<String,User> map = new Hashtable<String,User>();
        map.put("tiger",new User("老虎","1564548",59));
        map.put("dog",new User("狗","15648885",59));
        map.put("cat",new User("猫","156488964",59));
        map.put("chicken",new User("鸡","4564688",59));
        map.put("duck",new User("鸭","456465",59));
        map.put("fish",new User("鱼","45648586",59));
        map.put("pig",new User("猪","212155",59));
        Enumeration<String> enumeration = map.keys();
        while(enumeration.hasMoreElements()){
            System.out.println(enumeration.nextElement());
        }
        Enumeration<User> enumeration1 = map.elements();
        while(enumeration1.hasMoreElements()){
            System.out.println(enumeration1.nextElement());
        }
    }
    public static void test3(){
        TreeMap<String,User> treeMap = new TreeMap<String,User>();
        treeMap.put("tiger",new User("老虎","1564548",59));
        treeMap.put("dog",new User("狗","15648885",59));
        treeMap.put("cat",new User("猫","156488964",59));
        treeMap.put("chicken",new User("鸡","4564688",59));
        treeMap.put("duck",new User("鸭","456465",59));
        treeMap.put("fish",new User("鱼","45648586",59));
        treeMap.put("pig",new User("猪","212155",59));
        Map.Entry<String,User> entry = treeMap.firstEntry();
        System.out.println(entry.getKey());
        System.out.println(entry.getValue());
        Map.Entry<String,User> entry1 = treeMap.lastEntry();
        System.out.println(entry1.getKey());
        System.out.println(entry1.getValue());
        System.out.println(treeMap);
    }
}
