package com.example.demo.io;

import java.io.StringReader;
import java.io.StringWriter;

/**
 * Created by cuizhixiang on 2017/7/4.
 **/
public class TestStringReader {
    public static void main(String args[])throws Exception{
        test();
    }
    public static void test()throws Exception{
        StringReader stringReader = new StringReader("djsakldjklas");
        StringWriter stringWriter = new StringWriter();
        char[] c = new char[1024];
        int len;
        while((len = stringReader.read(c)) != -1){
            stringWriter.write(c,0,len);
        }
        System.out.print(stringWriter.getBuffer());
    }

}
