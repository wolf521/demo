package com.example.netdemo;

import java.net.InetAddress;

/**
 * Created by cuizhixiang on 2017/10/16.
 */
public class InetAddressDemo {
    public static void main(String agrs[]){
        try{
            InetAddress inetAddress = InetAddress.getByName("www.baidu.com");
            System.out.println(inetAddress);
            InetAddress inetAddress1 = InetAddress.getByName("196.168.1.121");
            System.out.println(inetAddress1);
            InetAddress inetAddress2 = InetAddress.getLocalHost();
            System.out.println(inetAddress2);
            System.out.println("host:"+inetAddress2.getHostName());
            System.out.println("ip:"+inetAddress2.getHostAddress());
            System.out.println("");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
