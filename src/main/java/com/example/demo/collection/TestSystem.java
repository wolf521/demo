package com.example.demo.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by cuizhixiang on 2017/6/23.
 **/
public class TestSystem {
    public static void main(String agrs[]){
        TestSystem.test2();
    }
    public static void test(){
        Integer i[] = {1,2,3,4,5};
        Integer j[] = {6,7,8,9,10};
        System.arraycopy(i,2,j,1,3);
        for(int k:i){
            System.out.println(k);
        }
        for(int k:j){
            System.out.println(k);
        }
    }
    public static void test1(){

        LinkedList<String> list1 = new LinkedList<String>();
        for(int i=0;i<1000000;i++){
            list1.add("s"+i);
        }
        long l = System.currentTimeMillis();
        Iterator<String> iterator = list1.iterator();
        while(iterator.hasNext()){
            iterator.next();
        }
        long l1 = System.currentTimeMillis();
        System.out.println("LinkedList："+(l1 - l));
        ArrayList<String> list = new ArrayList<String>();
        for(int i=0;i<1000000;i++){
            list.add("s"+i);
        }
        long l2 = System.currentTimeMillis();
        long l4 = System.nanoTime();
        Iterator<String> iterator1 = list.iterator();
        while(iterator1.hasNext()){
            iterator1.next();
        }
        long l3 = System.currentTimeMillis();
        long l5 = System.nanoTime();
        System.out.println("ArrayList："+(l3 - l2));
        System.out.println("ArrayList："+(l5 - l4));
    }
    public static void test2(){
        System.out.println("Java 运行时环境版本:"+System.getProperty("java.version"));
        System.out.println("Java 安装目录:"+System.getProperty("java.home"));
        System.out.println("操作系统的名称:"+System.getProperty("os.name"));
        System.out.println("操作系统的版本:"+System.getProperty("os.version"));
        System.out.println("用户的账户名称:"+System.getProperty("user.name"));
        System.out.println("用户的主目录:"+System.getProperty("user.home"));
        System.out.println("用户的当前工作目录:"+System.getProperty("user.dir"));
        System.out.println(System.getenv("JAVA_HOME"));
        System.out.println(System.getenv("CLASSPATH"));

    }
    public static void test3(){
        System.out.println(Runtime.getRuntime().availableProcessors());
        System.out.println(Runtime.getRuntime().freeMemory());
        System.out.println(Runtime.getRuntime().maxMemory());
        System.out.println(Runtime.getRuntime().totalMemory());
    }
}
