package com.example.demo.io;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * Created by cuizhixiang on 2017/7/4.
 **/
public class TestFileIo {
    public static void main(String args[])throws Exception{
        test();
    }
    public static void test()throws Exception{
        File file = new File("e:/data.txt");
        FileReader fileReader = new FileReader(new File("e:/test.txt"));
        FileWriter fileWriter = new FileWriter(file);
        char[] c = new char[1024];
        int len;
        while((len = fileReader.read(c)) != -1){
            fileWriter.write(c,0,len);
        }
        fileReader.close();
        fileWriter.flush();
        fileWriter.close();
    }
}
