package com.example.demo.JDK7new_characteristics;

/**
 * Created by Administrator on 2018/3/5.
 * JDK1.7新特性
 */
public class Test {
    public static void main(String[] agrs) {
        //1.switch中可以使用字符串
        //2.运用List<String> tempList = new ArrayList<>(); 即泛型实例化类型自动推断
        //3.语法上支持集合，而不一定是数组
//        List<String> list = ["item","te"];
//        Set<String> set = {"item"};
        //4.新增一些取环境信息的工具方法
            /*File System.getJavaIoTempDir() // IO临时文件夹
            File System.getJavaHomeDir() // JRE的安装目录
            File System.getUserHomeDir() // 当前用户目录
            File System.getUserDir() // 启动java进程时所在的目录*/
        //5.Boolean类型反转，空指针安全,参与位运算

//        Boolean Booleans.negate(Boolean booleanObj)
//        True => False , False => True, Null => Null
//        boolean Booleans.and(boolean[] array)
//        boolean Booleans.or(boolean[] array)
//        boolean Booleans.xor(boolean[] array)
//        boolean Booleans.and(Boolean[] array)
//        boolean Booleans.or(Boolean[] array)
//        boolean Booleans.xor(Boolean[] array)
//        6.两个char间的equals
//        boolean Character.equalsIgnoreCase(char ch1, char ch2)
//        7.安全的加减乘除
//
//        int Math.safeToInt(long value)
//        int Math.safeNegate(int value)
//        long Math.safeSubtract(long value1, int value2)
//        long Math.safeSubtract(long value1, long value2)
//        int Math.safeMultiply(int value1, int value2)
//        long Math.safeMultiply(long value1, int value2)
//        long Math.safeMultiply(long value1, long value2)
//        long Math.safeNegate(long value)
//        int Math.safeAdd(int value1, int value2)
//        long Math.safeAdd(long value1, int value2)
//        long Math.safeAdd(long value1, long value2)
//        int Math.safeSubtract(int value1, int value2)

    }
}
