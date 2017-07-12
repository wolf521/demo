package com.example.demo.testenum.test;

/**
 * Created by cuizhixiang on 2017/7/12.
 **/
public class Test {
    public static void main(String args[]){
        test();
    }
    public static void test(){
        for(Enum e:Colors.values()){
            System.out.print(e);
        }
    }
    public static void test1(){
        Colors color = Colors.RED;
        switch (color){
            case BLUE: System.out.print(color);break;
            case GREEN:System.out.print(color);break;
            case RED:System.out.print(color);break;
            case YELLOW: System.out.print(color);break;
            default:System.out.print(color);
        }
    }
}
enum Colors{
    RED,BLUE,GREEN,YELLOW
}

