package com.example.demo.io;

import java.io.*;

/**
 * Created by cuizhixiang on 2017/7/4.
 **/
public class TestPushBackIo {
    public static void main(String args[])throws Exception{
        test();
    }
    public static void test()throws Exception{
        byte[] b = "abcdefggfdgert".getBytes();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(b);
        PushbackInputStream pushbackInputStream = new PushbackInputStream(byteArrayInputStream);
        int n;
        while((n = pushbackInputStream.read()) != -1){
            System.out.println((char)n);
            if(n == 'c'){
                pushbackInputStream.unread('5');
            }
            if(n == '5'){
                pushbackInputStream.unread('7');
            }
        }
        byteArrayInputStream.close();
        pushbackInputStream.close();
    }
}
