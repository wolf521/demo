package com.example.demo.io;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * Created by cuizhixiang on 2017/7/25.
 * 文件及文件夹压缩及解压缩：zip
 **/
public class TestZip {
    public static void main(String agrs[]) throws Exception {
        new TestZip().zipFolder("e:/mywork", "e:/work.zip");
        new TestZip().unZipFolder("e:/work.zip","e:/zip");
    }

    /**
     * 文件压缩
     *
     * @param filePath   压缩文件
     * @param folderPath 压缩后文件存放目录
     */
    public void zipFile(String filePath, String folderPath) throws Exception {
        File file = new File(filePath);
        FileOutputStream outputStream = new FileOutputStream(folderPath);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
        ZipOutputStream zipOutputStream = new ZipOutputStream(bufferedOutputStream);
        FileInputStream inputStream = new FileInputStream(file);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        ZipEntry zipEntry = new ZipEntry(file.getName());
        zipOutputStream.putNextEntry(zipEntry);
        int tmp;
        while ((tmp = bufferedInputStream.read()) != -1) {
            zipOutputStream.write(tmp);
        }
        inputStream.close();
        bufferedInputStream.close();
        zipOutputStream.close();
        bufferedOutputStream.close();
        outputStream.close();
    }

    /**
     * 文件解压缩
     *
     * @param zipPath  压缩文件路径
     * @param destPath 解压缩后存放目录
     */
    public void unZip(String zipPath, String destPath) throws Exception {
        FileInputStream inputStream = new FileInputStream(zipPath);
        ZipInputStream zipInputStream = new ZipInputStream(inputStream);
        ZipEntry zipEntry;
        while ((zipEntry = zipInputStream.getNextEntry()) != null) {
            if (zipEntry.isDirectory()) {
                File file = new File(destPath);
                file.mkdirs();
            } else {
                File file = new File(destPath+File.separator+zipEntry.getName());
                FileOutputStream outputStream = new FileOutputStream(file);
                int tmp = 0;
                while ((tmp = zipInputStream.read()) != -1) {
                    outputStream.write(tmp);
                }
                zipInputStream.closeEntry();
                outputStream.close();
            }
        }
        inputStream.close();
        zipInputStream.close();
    }

    /**
     * 压缩
     *
     * @param filePath 需要压缩的
     * @param zipPath  压缩后存贮目录
     */
    public void zipFolder(String filePath, String zipPath) throws Exception {
        File file = new File(filePath);
        FileOutputStream outputStream = new FileOutputStream(zipPath);
        ZipOutputStream zipOutputStream = new ZipOutputStream(outputStream);
        zipFolder(zipOutputStream, file, file.getName());
        zipOutputStream.close();
    }

    public void zipFolder(ZipOutputStream zipOutputStream, File file, String base) throws Exception {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            zipOutputStream.putNextEntry(new ZipEntry(base + "/"));
            base = base.length() == 0 ? "" : base + "/";
            for (int i = 0; i < files.length; i++) {
                zipFolder(zipOutputStream, files[i], base + files[i].getName());
            }
        } else {
            zipOutputStream.putNextEntry(new ZipEntry(base));
            FileInputStream inputStream = new FileInputStream(file);
            int tmp;
            while ((tmp = inputStream.read()) != -1) {
                zipOutputStream.write(tmp);
            }
            inputStream.close();
        }
    }

    /**
     * 解压缩
     *
     * @param zipName 压缩文件
     * @param folder  解压后存放路径
     */
    public void unZipFolder(String zipName, String folder) throws Exception {
        File file = new File(zipName);
        File f = new File(folder);
        if (!f.exists()) {
            f.mkdirs();
        }
        FileInputStream inputStream = new FileInputStream(file);
        ZipInputStream zipInputStream = new ZipInputStream(inputStream);
        ZipEntry zipEntry = null;
        while ((zipEntry = zipInputStream.getNextEntry()) != null) {
            if (zipEntry.isDirectory()) {
                String name = zipEntry.getName();
                name = name.substring(0, name.length() - 1);
                File file1 = new File(folder + File.separator + name);
                file1.mkdir();
            } else {
                File file1 = new File(folder + File.separator + zipEntry.getName());
                file1.createNewFile();
                FileOutputStream outputStream = new FileOutputStream(file1);
                int tmp;
                while ((tmp = zipInputStream.read()) != -1) {
                    outputStream.write(tmp);
                }
                outputStream.close();
            }
        }
        inputStream.close();
        zipInputStream.closeEntry();
        zipInputStream.close();
    }
}
