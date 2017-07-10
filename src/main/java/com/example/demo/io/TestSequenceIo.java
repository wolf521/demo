package com.example.demo.io;

import java.io.*;

/**
 * Created by cuizhixiang on 2017/7/4.
 **/
public class TestSequenceIo {
    public static void main(String argsp[])throws Exception{
        test();
    }
    public static void test()throws Exception{
        File file = new File("E:/test.txt");
        File file1 = new File("E:/data.txt");
        FileOutputStream outputStream = new FileOutputStream(file);
        outputStream.write("abcdefg".getBytes());
        FileInputStream inputStream = new FileInputStream(file);
        SequenceInputStream sequenceInputStream = new SequenceInputStream(inputStream,new FileInputStream(file1));
        for(int i = 0;i < file.length()+file1.length();i++){
            System.out.print((char)sequenceInputStream.read());
        }
        sequenceInputStream.close();
        inputStream.close();
        outputStream.flush();
        outputStream.close();
    }
}
