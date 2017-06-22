package com.example.demo.collection;



import com.example.model.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by cuizhixiang on 2017/6/22.
 **/
public class TestCollection {
    public static void main(String agrs[]){
        TestCollection.test1();
    }
    public static void test(){
        Collection<String> collection = new ArrayList<String>();
        collection.add("testAdd");
        collection.add("test1Add");
        collection.add("test2Add");
        collection.add("test3Add");
        Collection<String> collection1 = new ArrayList<String>();
        collection1.add("addAll");
        collection1.addAll(collection);
        Iterator<String> iterator = collection1.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println(collection.contains("test"));
        System.out.println(collection.contains("testAdd"));
        System.out.println(collection1.containsAll(collection));
        collection1.clear();
    }

    public static void test1(){
        Collection<User> users = new ArrayList<User>();
        User user = new User("尖峰","15656929569",30);
        users.add(user);
        users.add(new User("小明","15956898989",18));
        users.add(new User("小华","15956543989",20));
        users.add(new User("小黑","15954898989",17));
        users.add(new User("小白","15955433989",19));
        System.out.println(users.remove(user));
        Iterator<User> iterator = users.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        Collection<User> users1 = new ArrayList<User>();
        users1.add(new User("赖明","1545654898",56));
        users1.addAll(users);
        //users1.removeAll(users);
        users1.retainAll(users);
        System.out.println(users1.size());
        Iterator<User> iterator1 = users1.iterator();
        while(iterator1.hasNext()){
            System.out.println(iterator1.next());
        }
        user.setTel("15652348956");
        System.out.println(users.contains(new User("小明","15956898989",18)));
        System.out.println(users.contains(user));
        System.out.println(users.containsAll(users1));
        System.out.println(users1.containsAll(users));
        System.out.println(users1.equals(users));
        System.out.println(users1.hashCode());
        System.out.println(users1.isEmpty());
        //users1.clear();
        System.out.println(users1.isEmpty());
        System.out.println("****************************************");
        Object o[] = users1.toArray();
        for(Object o1:o){
            System.out.println(o1);
        }
        System.out.println("****************************************");
        User[] users2 = {};
        users2 = users1.toArray(users2);
        for(User user1:users2){
            System.out.println(user1);
        }
    }
}
