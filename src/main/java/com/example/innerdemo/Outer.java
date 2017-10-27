package com.example.innerdemo;

/**
 * Created by Administrator on 2017/10/26.
 */
public class Outer {
    private String name = "肖奈";
    private static String you = "肖奈";
    private static Integer oneMonthlySalary = 40000;
    public void print(){
        System.out.print(name);
        System.out.print(new Inner().innerName);
    }
    private class Inner{
        private String innerName = "小红";
        public void innerPrint(){
            System.out.print(name);
            System.out.print(innerName);
        }
    }

    public static void main(String agrs[]){
        if("你是敲代码的".equals(you) && oneMonthlySalary > 30000){
            System.out.print("您是程序员");
        } else {
            System.out.print("一个敲代码的");
        }
    }
}
