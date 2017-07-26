package com.example.demo.io;

import java.io.*;

/**
 * Created by cuizhixiang on 2017/7/3.
 **/
public class TestDataIo {
    public static void main(String args[])throws Exception{
        test();
    }
    public static void test()throws Exception{
        File file = new File("e:/data.txt");
        FileInputStream inputStream = new FileInputStream(file);
        FileOutputStream outputStream = new FileOutputStream(file);
        byte[] b = "1234587".getBytes();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.write(b);
        //dataOutputStream.writeBoolean(true);
        //dataOutputStream.writeChar('d');
        dataOutputStream.writeUTF("肯建电视");
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        System.out.println(dataInputStream.readShort());
        //System.out.println(dataInputStream.readUTF());
        inputStream.close();
        outputStream.flush();
        outputStream.close();
        dataInputStream.close();
        dataOutputStream.close();
    }
}
