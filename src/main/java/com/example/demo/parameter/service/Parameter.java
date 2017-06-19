package com.example.demo.parameter.service;

import com.example.demo.parameter.model.User;

/**
 * Created by cuizhixiang on 2017/6/16.
 * java中的参数传递机制
 **/
public class Parameter {
    public static void main(String agrs[]){
        new Parameter().test();
    }
    public void test(){
        int a = 1;
        int b = 2;
        String str = "山东";
        String s = new String("济南");
        User user = new User();
        user.setName("小明");
        user.setTel("15953584689");
        test2(a,b,user,s);
        System.out.println("str:"+s);
        System.out.println("user:"+user);
        System.out.println("a:"+a);
        System.out.println("b:"+b);
    }
    public void test2(int a,int b,User user,String str){
        a = 3;
        b = 4;
        str = "青岛";
        user.setName("小华");
        user.setTel("15689489875");
        System.out.println("user:"+user);
        System.out.println("str:"+str);
        System.out.println("a:"+a);
        System.out.println("b:"+b);
    }
}
