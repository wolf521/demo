package com.example.demo.io;

import java.io.*;
import java.util.Enumeration;
import java.util.Properties;

/**
 * Created by cuizhixiang on 2017/7/26.
 **/
public class TestProperties {
    public static void main(String[] args)throws Exception {
        String filePath = "properties.properties";
        String key = "姓名";
        String value = "星宇";
        key = new TestProperties().convert(key);
        value = new TestProperties().convert(value);
        new TestProperties().writeProperties(filePath, key, value);
        new TestProperties().readProperties(filePath, key);
        //new TestProperties().readProperties(filePath);
    }

    /**
     * 读取某一键的值
     *
     * @param filePath 资源文件路径
     * @param key      key
     */
    public void readProperties(String filePath, String key)throws Exception {
        Properties properties = new Properties();
        try {
            properties.load(this.getClass().getClassLoader().getResourceAsStream(filePath));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(unicode(key));
        System.out.println(unicode(properties.getProperty(key)));
    }

    /**
     * 读取资源文件所有的值
     *
     * @param filePath 资源文件路径
     */
    public void readProperties(String filePath) {
        Properties properties = new Properties();
        try {
            properties.load(this.getClass().getClassLoader().getResourceAsStream(filePath));
            Enumeration enumeration = properties.propertyNames();
            while (enumeration.hasMoreElements()) {
                String key = (String) enumeration.nextElement();
                System.out.println("key:" + key);
                System.out.println("value:" + properties.getProperty(key));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 写入资源文件
     *
     * @param fileName 文件名称
     * @param key      key
     * @param value    value
     */
    public void writeProperties(String fileName, String key, String value) {
        Properties properties = new Properties();
        String path = this.getClass().getClassLoader().getResource("").getPath().substring(1);
        path = path + File.separator + fileName;
        File file = new File(path);
        try {
            InputStream inputStream = new FileInputStream(file);
            properties.load(inputStream);
            OutputStream outputStream = new FileOutputStream(file);
            properties.setProperty(key, value);
            properties.store(outputStream, key);
            inputStream.close();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 中文转Unicode
     *
     * @param str 中文字符串
     * @return 编码后
     */
    public String convert(String str) {
        StringBuffer unicode = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            Character character = str.charAt(i);
            unicode.append("\\"+"u"+Integer.toHexString(character));
        }
        return unicode.toString();
    }

    /**
     * 将unicode转为中文
     *
     * @param unicode unicode
     * @return 中文
     * @throws Exception
     */
    public String unicode(String unicode) {
        try {
            return new String(unicode.getBytes("UTF-8"),"UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
