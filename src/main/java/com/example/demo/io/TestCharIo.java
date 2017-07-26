package com.example.demo.io;

import java.io.CharArrayReader;
import java.io.CharArrayWriter;

/**
 * Created by cuizhixiang on 2017/7/4.
 **/
public class TestCharIo {
    public static void main(String args[]) throws Exception {
        test();
    }

    public static void test() throws Exception {
        CharArrayReader charArrayReader = new CharArrayReader("fdsjfkdsjkl".toCharArray());
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        char[] c = new char[1024];
        int len;
        while ((len = charArrayReader.read(c)) != -1) {
            charArrayWriter.write(c, 0, len);
        }
        System.out.println(charArrayWriter.toString());
        System.out.println(charArrayWriter.toCharArray());
    }
}
