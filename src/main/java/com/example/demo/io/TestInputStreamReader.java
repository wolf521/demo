package com.example.demo.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * Created by cuizhixiang on 2017/7/4.
 **/
public class TestInputStreamReader {
    public static void main(String args[])throws Exception{
        test();
    }
    public static void test()throws Exception{
        File file = new File("e:/data.txt");
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file),"utf-8");
        for(int i = 0;i < file.length();i++){
            System.out.print((char)inputStreamReader.read());
        }
    }
}
