package com.example.demo.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * Created by cuizhixiang on 2017/6/26.
 **/
public class TestInputStream {
    public static void main(String args[])throws Exception{
        TestInputStream.test2();
    }
    public static void test()throws Exception{
        File file = new File("e:/test.txt");
        File file1 = new File("e:/test.mp4");
        FileInputStream inputStream = new FileInputStream(file);
        FileOutputStream outputStream = new FileOutputStream(file1);
        byte[] b = new byte[inputStream.available()];
        int len = -1;
        while((len = inputStream.read(b)) != -1){
            outputStream.write(b,0,len);
        }
        inputStream.close();
        outputStream.flush();
        outputStream.close();
    }

    public static void test2()throws Exception{
        System.out.println(System.in.read());
    }
    public static byte[] readStream(InputStream inStream) throws Exception {
        int count = 0;
        while (count == 0) {
            count = inStream.available();
        }
        byte[] b = new byte[count];
        inStream.read(b);
        return b;
    }
}
