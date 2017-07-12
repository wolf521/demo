package com.example.demo.testenum.test;

/**
 * Created by cuizhixiang on 2017/7/12.
 **/
public class Test1 {
    public static void main(String args[]){
        test1();
    }
    public static void test(){
        Color color = Color.RED;
        switch (color){
            case BLUE: System.out.print(color.getName()+"："+color.getIndex());break;
            case GREEN:System.out.print(color.getName()+"："+color.getIndex());break;
            case RED:System.out.print(color.getName()+"："+color.getIndex());break;
            case YELLOW: System.out.print(color.getName()+"："+color.getIndex());break;
            default:System.out.print(color.getName()+"："+color.getIndex());
        }
    }
    public static void test1(){
        for(Enum e:Color.values()){
            System.out.println(e);
        }
    }
    public static void test2(){
        Color.BLUE.print();
    }
}
interface Print{
   void print();
}
enum Color implements Print{

    RED("红色",1),BLUE("蓝色",2),GREEN("绿色",3),YELLOW("黄色",4);

    private String name;
    private int index;

    Color(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "Color{" +
                "name='" + name + '\'' +
                ", index=" + index +
                '}';
    }

    @Override
    public void print() {
        System.out.println(this.name+":"+this.index);
    }
}

