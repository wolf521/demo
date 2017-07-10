package com.example.demo.io;

import com.example.model.User;

import java.io.*;

/**
 * Created by cuizhixiang on 2017/7/4.
 **/
public class TestObjectIo {
    public static void main(String args[])throws Exception{
        test();
    }
    public static void test()throws Exception{
        File file = new File("e:/user.txt");
        User user1 = new User("莲藕","4324",33);
        User user2 = new User("荷叶","434234",4);
        User user3 = new User("荷花","434234",4);
        User user4 = new User("莲子","434234",4);
        FileOutputStream outputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(user1);
        objectOutputStream.writeObject(user2);
        objectOutputStream.writeObject(user3);
        objectOutputStream.writeObject(user4);
        FileInputStream inputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        System.out.println((User)objectInputStream.readObject());
        System.out.println((User)objectInputStream.readObject());
        System.out.println((User)objectInputStream.readObject());
        System.out.println((User)objectInputStream.readObject());
    }
}
