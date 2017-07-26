package com.example.demo.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * Created by cuizhixiang on 2017/7/4.
 **/
public class TestByteArrayIo {
    public static void main(String args[])throws Exception{
        test();
    }
    public static void test()throws Exception{
        ByteArrayOutputStream bOutput = new ByteArrayOutputStream(60);
        while( bOutput.size()!= 30 ) {
            // 获取用户输入值
            bOutput.write(System.in.read());
        }
        System.out.println(bOutput.toString());
        System.out.println("*********************************");
        System.out.println(bOutput.toString("utf-8"));
        System.out.println("*********************************");
        byte b [] = bOutput.toByteArray();
        for(int i= 0 ; i < b.length; i++) {
            System.out.print((char)b[i]  + "   ");
        }
        System.out.println();
        System.out.println("*********************************");
        int c;
        ByteArrayInputStream bInput = new ByteArrayInputStream(b);
        for(int k = 0 ; k < 1; k++ ) {
            while(( c= bInput.read())!= -1) {
                System.out.print(Character.toUpperCase((char)c));
            }
            bInput.reset();
        }
    }
}
