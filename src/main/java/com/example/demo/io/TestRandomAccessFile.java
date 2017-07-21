package com.example.demo.io;

import java.io.File;
import java.io.RandomAccessFile;

/**
 * Created by cuizhixiang on 2017/7/21.
 * model:操作模式
 * "r": 以只读方式打开,调用任何方法的任何write，都将会抛出IOException
 * "rw":打开以便于读取和写入，如果文件不存在，则尝试创建
 * "rws":打开以便于读取和写入，与rw的区别是对于内容与元数据的每个更新都将同步到基础存贮设备
 * "rwd":打开以便于读取和写入，与rw的区别是对于内容的每个更新都将同步到基础存贮设备
 **/
public class TestRandomAccessFile {
    public static void main(String args[])throws Exception{
        test();
        test1();
    }
    public static void test()throws Exception{
        File file = new File("e:\\data.txt");
        RandomAccessFile randomAccessFile = new RandomAccessFile(file,"rw");
        // 指定位置写入
        randomAccessFile.seek(0);
        randomAccessFile.writeUTF("开始\n");
        randomAccessFile.write(0);
        randomAccessFile.writeBoolean(false);
        randomAccessFile.writeChar('d');
        randomAccessFile.writeUTF("结束");
        randomAccessFile.close();
    }
    public static void test1()throws Exception{
        File file = new File("e:\\data.txt");
        RandomAccessFile randomAccessFile = new RandomAccessFile(file,"rw");
        // 指定位置读取
        randomAccessFile.seek(0);
        System.out.println(randomAccessFile.readUTF());
        System.out.println(randomAccessFile.read());
        System.out.println(randomAccessFile.readBoolean());
        System.out.println(randomAccessFile.readChar());
        System.out.println(randomAccessFile.readUTF());
        randomAccessFile.close();
    }
}
