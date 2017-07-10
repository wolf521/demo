package com.example.demo.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * Created by cuizhixiang on 2017/7/4.
 **/
public class TestPrintStream {
    public static void main(String args[])throws Exception{
        test();
    }
    public static void test()throws Exception{
        FileOutputStream outputStream = new FileOutputStream(new File("e:/终身受益的记忆法——效果超帅.rmvb"));
        PrintStream printStream = new PrintStream(outputStream);
        printStream.println();
    }
}
