package com.example.demo.io;

import java.io.*;

/**
 * Created by cuizhixiang on 2017/7/4.
 **/
public class TestOutputStreamWriter {
    public static void main(String args[])throws Exception{
        test();
    }
    public static void test()throws Exception{
        File file = new File("e:/data.txt");
        OutputStream outputStream = new FileOutputStream(file);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream,"utf-8");
        System.out.println(outputStreamWriter.getEncoding());
        outputStreamWriter.write("abcdefg",0,5);
        outputStreamWriter.flush();
        outputStreamWriter.close();
    }
}
