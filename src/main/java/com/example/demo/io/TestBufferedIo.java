package com.example.demo.io;

import java.io.*;

/**
 * Created by cuizhixiang on 2017/7/3.
 **/
public class TestBufferedIo {
    public static void main(String args[])throws Exception{
        //test();
        //test1();
        test2();
    }
    public static void test()throws Exception{
        File file = new File("e:/1.mp4");
        InputStream inputStream = new FileInputStream(file);
        OutputStream outputStream = new FileOutputStream(new File("e:/test1.txt"));
        byte b[] = new byte[inputStream.available()];
        long l1 = System.currentTimeMillis();
        while(inputStream.read(b) != -1){
            outputStream.write(b);
        }
        long l2 = System.currentTimeMillis();
        System.out.println(l2-l1);
        inputStream.close();
        outputStream.flush();
        outputStream.close();
    }
    public static void test1()throws Exception{
        File file = new File("e:/2.mp4");
        InputStream inputStream = new FileInputStream(file);
        OutputStream outputStream = new FileOutputStream(new File("e:/test2.txt"));
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
        byte[] b = new byte[1024];
        while(bufferedInputStream.read(b) != -1){
            bufferedOutputStream.write(b);
        }
    }
    public static void test2()throws Exception{
        File file1 = new File("e:/秘密--吸引力法则.f4v");
        File file = new File("e:/data.f4v");
        Reader reader = new FileReader(file);
        Writer writer = new FileWriter(file1);
        BufferedReader bufferedReader = new BufferedReader(reader);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        char[] c = new char[1024];
        int len;
        long l = System.currentTimeMillis();
        while((len = bufferedReader.read(c)) != -1){
            bufferedWriter.write(c,0,len);
        }
        long l1 = System.currentTimeMillis();
        System.out.print(l1 - l);
    }
}
