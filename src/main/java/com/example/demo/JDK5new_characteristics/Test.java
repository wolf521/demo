package com.example.demo.JDK5new_characteristics;

/**
 * Created by Administrator on 2018/3/5.
 * JDK1.5新特性
 */
public class Test {
    public static void main(String[] agrs) {
        //1. 泛型
        //ArrayList list=new ArrayList()------>ArrayList<Integer>list=new ArrayList<Integer>();
        //2. 自动装箱/拆箱
        //int i=list.get(0).parseInt();-------->int i=list.get(0);原始类型与对应的包装类不用显式转换
        //3. for-each(优化循环语句for(int n:numbers))
        //i=0;i<a.length;i++------------>for(int i:a){......}
        //4. static import(静态导入)
        //Math.sqrt();--------------->sqrt();
        //5. 可变参数
        //int sum(int ...intlist)有任意个参数,把他看作数组
        //6. 枚举Enumeration
        //7. Annotations
    }
}
