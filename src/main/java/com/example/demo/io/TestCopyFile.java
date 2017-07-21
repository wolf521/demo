package com.example.demo.io;

import java.io.*;

/**
 * Created by cuizhixiang on 2017/7/20.
 **/
public class TestCopyFile {
    public static void main(String args[]) {

        //copyFile("e:/data.txt","f:/data.txt");
        copyFolder("E:\\简历范文", "f:\\简历范文");
    }

    /**
     * 文件复制
     *
     * @param oldPath 原地址
     * @param newPath 新地址
     */
    public static void copyFile(String oldPath, String newPath) {
        File file = new File(oldPath);
        try {
            if (file.exists()) {
                InputStream inputStream = new FileInputStream(file);
                OutputStream outputStream = new FileOutputStream(newPath);
                byte[] b = new byte[1024];
                int len = 0;
                while ((len = inputStream.read(b)) != -1) {
                    outputStream.write(b, 0, len);
                }
                inputStream.close();
                outputStream.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 文件夹复制
     *
     * @param oldPath 原地址
     * @param newPath 新地址
     */
    public static void copyFolder(String oldPath, String newPath) {
        try {
            new File(newPath).mkdirs();
            String[] strings = new File(oldPath).list();
            File tem;
            for (int i = 0; i < strings.length; i++) {
                if (oldPath.endsWith(File.separator)) {
                    tem = new File(oldPath + strings[i]);
                } else {
                    tem = new File(oldPath + File.separator + strings[i]);
                }
                if (tem.isFile()) {
                    InputStream inputStream = new FileInputStream(tem);
                    OutputStream outputStream = new FileOutputStream(newPath + "/" + tem.getName());
                    byte[] b = new byte[1024];
                    int len = 0;
                    while ((len = inputStream.read(b)) != -1) {
                        outputStream.write(b, 0, len);
                    }
                    inputStream.close();
                    outputStream.close();
                }
                if (tem.isDirectory()) {
                    copyFolder(oldPath + "/" + strings[i], newPath + "/" + strings[i]);
                }
            }
        } catch (Exception e) {
            System.out.println("复制失败");
            e.printStackTrace();
        }
    }
}
