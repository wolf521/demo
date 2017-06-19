package com.example.demo.object.test;

/**
 * Created by cuizhixiang on 2017/6/19.
 **/
public class TestString {
    public static void main(String agrs[]){
        new TestString().test1();
    }
    public void test(){
        String str = "hello world,";
        String str1 = "hello world,";
        char chars[] = {'s','d','f',',',',','f','f','g'};
        System.out.println(str.charAt(4));
        System.out.println(str.compareTo(str1));
        System.out.println(str.concat(str1));
        System.out.println(str.contains("a"));
        System.out.println(str.contentEquals(str1));
        System.out.println(str.copyValueOf(chars));
        System.out.println(str.copyValueOf(chars,3,2));
        System.out.println(str.endsWith("str"));
        System.out.println(str.equals(str1));
        str1 = "HELLO WORLD,";
        System.out.println(str.equalsIgnoreCase(str1));
        byte aByte[] = str.getBytes();
        for(byte b : aByte){
            System.out.print(b+",");
        }
        System.out.println(str.indexOf("o"));
        char c[] = str.toCharArray();
        for(char ch : c){
            System.out.print(ch+",");
        }
        System.out.println(str.indexOf(1));
        System.out.println(str.lastIndexOf("o"));
        System.out.println(str.length());
        System.out.println(str.replace("o","a"));
        System.out.println(str.toUpperCase());
        System.out.println(str1.toLowerCase());
        str = "h,e,l,l,o,w,o,r,l,d";
        String strings[] = str.split(",");
        for(String s:strings){
            System.out.println(s);
        }
        System.out.println(str.substring(3));
        System.out.println(str.substring(3,5));
    }
    public void test1(){
        StringBuffer buffer = new StringBuffer();
        buffer.append("ab");
        buffer.append(true);
        buffer.append('e');
        buffer.append(3.33);
        buffer.append(34.5f);
        buffer.append(556l);
        buffer.append(32);
        buffer.append(buffer);
        System.out.println(buffer);
        buffer.insert(4,"asdfghj");
        buffer.insert(2,222l);
        System.out.println(buffer);
        System.out.println(buffer.reverse());
        buffer.setCharAt(0,'a');
        System.out.println(buffer);
        buffer.setLength(3);
        System.out.println(buffer);
    }
}
