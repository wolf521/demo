package com.example.demo.io;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.URI;

/**
 * Created by cuizhixiang on 2017/6/26.
 **/
public class TestFile {
    public static void main(String agrs[])throws Exception{
        TestFile.test4();
    }
    public static void test()throws Exception{
        File file1 = new File("e:/txt");
        File file2 = new File("e:/txt","test.txt");
        File file3 = new File(file1,"text.txt");
        File file4 = new File(file1.toURI());
        file1.mkdir();
        file2.createNewFile();
        file3.createNewFile();
        System.out.println(file1.canExecute());
        System.out.println(file2.canExecute());
        System.out.println(file3.canExecute());
        System.out.println(file4.canExecute());
    }
    public static void tes()throws Exception{
        File file1 = new File("e:/file/test");
        File file2 = new File(file1,"test.txt");
        System.out.println("目录是否存在："+file1.exists());
        if(!file1.exists()){
            System.out.println("创建目录");
            file1.mkdirs();
        }
        System.out.println("目录是否存在："+file1.exists());
        System.out.println("文件是否存在："+file2.exists());
        if(!file2.exists()){
            System.out.println("创建文件");
            file2.createNewFile();
        }
        System.out.println("文件是否存在："+file2.exists());
        System.out.println("删除文件");
        file2.delete();
        System.out.println("文件是否存在："+file2.exists());
        System.out.println("删除目录");
        file1.delete();
        System.out.println("目录是否存在："+file1.exists());
    }
    public static void test1()throws IOException{
        File file = new File("e:/io/file");
        if(!file.exists()){
            file.mkdirs();
        }
        File file1 = new File("e:/io/file/test.txt");
        System.out.println(file1.createNewFile());
        System.out.println(file1.canExecute());
        System.out.println(file1.canRead());
        System.out.println(file1.canWrite());
        System.out.println(file.compareTo(file));
        System.out.println(file1.compareTo(file));
        System.out.println(file.compareTo(file1));
        File file2 = file1.getAbsoluteFile();
        String path = file1.getCanonicalPath();
        File file3 = new File("/update");
        System.out.println(file3.getAbsolutePath());
        File file4 = file3.getCanonicalFile();
        System.out.println(file4);
        String path1 = file3.getCanonicalPath();
        System.out.println(path1);
        System.out.println(file3.getFreeSpace());
        System.out.println(file3.getTotalSpace());
        System.out.println(file3.getUsableSpace());
        System.out.println("******************");
        System.out.println(file3.getName());
        System.out.println(file3.getParent());
        System.out.println(file3.getParentFile());
        System.out.println(file3.getPath());
        System.out.println(file3.isAbsolute());
        System.out.println(file1.isAbsolute());
        System.out.println(file2.isDirectory());
        System.out.println(file.isDirectory());
        System.out.println(file4.isFile());
        System.out.println(file.isHidden());
        System.out.println(file.lastModified());
        System.out.println(file1.length());
        System.out.println("********************");
        File file5 = new File("e:/io/file/rename.doc");
        file1.renameTo(file5);
        System.out.println(file1.getAbsoluteFile());
        System.out.println(file5.exists());
    }
    public static void test2()throws IOException{
        File file = new File("e:/io");
        if(!file.exists()){
            System.out.println(file.mkdirs());
        }
        File file1 = new File("e:/io/file");
        if(!file1.exists()){
            System.out.println(file1.mkdirs());
        }
        File.createTempFile("map",".jpg",file1);
        File.createTempFile("introduce",".doc",file1);
        File.createTempFile("resume",".pdf",file1);
        File.createTempFile("word",".txt",file1);
        String[] str = file1.list();
        System.out.println(str);
        for(String str1:str){
            System.out.println(str1);
        }
        String[] str2 = file1.list(new ImageFilter());
        for(String str1:str2){
            System.out.println(str1);
        }
        String[] str3 = file1.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".txt");
            }
        });
        for(String str1:str3){
            System.out.println(str1);
        }
        System.out.println("************************");
        File[] files = file.listFiles();
        for(File file2:files){
            System.out.println(file2);
        }
        File[] listFiles = file.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return !dir.isDirectory();
            }
        });
        for(File file2:listFiles){
            System.out.println(file2);
        }
        File[] lisFiles1 = file1.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if(pathname.isDirectory()){
                    return true ;
                } else {
                    System.out.println(pathname);
                    return false;
                }
            }
        });
        for(File file2:lisFiles1){
            System.out.println(file2);
        }
    }
    public static void test3(){
        File file3 = new File("e:/io/file/test.txt");
        File file4 = new File("e:/io/file/华西.txt");
        File file = new File("e:/io/file");
        File[] file1 = File.listRoots();
        for(File file2:file1){
            System.out.println(file2);
        }
        file4.renameTo(new File("e:/io/file/test.txt"));
        file3.setExecutable(false);
        System.out.println(file3.lastModified());
        file3.setLastModified(System.currentTimeMillis());
        System.out.println(file3.lastModified());
        file3.setReadable(false);
        file3.setReadOnly();
    }
    public static void test4(){
        File file = new File("c:/");
        test5(file);
    }
    public static void test5(File file){
        File[] files = file.listFiles();
        if(files != null) {
            for (File file1 : files) {
                if (file1.isDirectory()) {
                    test5(file1);
                } else {
                    System.out.println(file1.getAbsolutePath()+"隐藏："+file1.isHidden());
                }
            }
        }
    }
}
class ImageFilter implements FilenameFilter{

    @Override
    public boolean accept(File dir,String name){
        return (isGif(name) || isJpg(name) || isPng(name));
    }

    private boolean isGif(String file) {
        return file.toLowerCase().endsWith(".gif");
    }
    private boolean isJpg(String file){
        return file.toLowerCase().endsWith(".jpg");
    }

    private boolean isPng(String file){
        return file.toLowerCase().endsWith(".png");
    }
}