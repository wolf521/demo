package com.example.demo.io;

import java.io.File;
import java.io.FilenameFilter;
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
    public static void main(String args[]) throws Exception {
//        test();
//        test1();
        cutFile("E:\\深度睡眠冥想音乐.mp4", "e:/分割", 300);
        unite("E:\\合并.mp4", "e:/分割", "tem");
    }

    public static void test() throws Exception {
        File file = new File("e:\\data.txt");
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        // 指定位置写入
        randomAccessFile.seek(0);
        randomAccessFile.writeUTF("开始\n");
        randomAccessFile.write(0);
        randomAccessFile.writeBoolean(false);
        randomAccessFile.writeChar('d');
        randomAccessFile.writeUTF("结束");
        randomAccessFile.close();
    }

    public static void test1() throws Exception {
        File file = new File("e:\\data.txt");
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        // 指定位置读取
        randomAccessFile.seek(0);
        System.out.println(randomAccessFile.readUTF());
        System.out.println(randomAccessFile.read());
        System.out.println(randomAccessFile.readBoolean());
        System.out.println(randomAccessFile.readChar());
        System.out.println(randomAccessFile.readUTF());
        randomAccessFile.close();
    }

    /**
     * 分割文件
     *
     * @param fileName   分割文件名
     * @param folderName 分割文件保存目录
     * @param size       每一份大小 kb
     * @throws Exception
     */
    public static void cutFile(String fileName, String folderName, int size) throws Exception {
        size *= 1024;
        File inFile = new File(fileName);
        int fileLength = (int) inFile.length();
        int value = fileLength / size;
        File file = new File(folderName);
        if (!file.exists()) file.mkdirs();
        RandomAccessFile randomAccessFile = new RandomAccessFile(fileName, "rw");
        int i = 0;
        for (; i < value; i++) {
            File outFile = new File(folderName + File.separator + inFile.getName() + i + "tem");
            RandomAccessFile randomAccessFile1 = new RandomAccessFile(outFile, "rw");
            for (int j = 0; j < size; j++) {
                randomAccessFile1.write(randomAccessFile.read());
            }
            randomAccessFile1.close();
        }
//        File outFile = new File(folderName+File.separator+inFile.getName()+i+"tem");
//        RandomAccessFile randomAccessFile1 = new RandomAccessFile(outFile,"rw");
//        for(int j = 0;j < fileLength;j++){
//            randomAccessFile1.write(randomAccessFile.read());
//        }
//        randomAccessFile1.close();
        randomAccessFile.close();
        System.out.println("分割完成");
    }

    /**
     * 合并文件
     *
     * @param fileName   合并后的文件
     * @param folderName 分割文件所在目录
     * @param filterName 分割文件后缀
     * @throws Exception
     */
    public static void unite(String fileName, String folderName, String filterName) throws Exception {
        File inFile = new File(folderName);
        File outFile = new File(fileName);
        RandomAccessFile out = new RandomAccessFile(outFile, "rw");
        File[] files = inFile.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                String fileName = new File(name).toString();
                return fileName.endsWith(filterName);
            }
        });
        for (int i = 0; i < files.length; i++) {
            RandomAccessFile in = new RandomAccessFile(files[i], "r");
            int len = 0;
            while ((len = in.read()) != -1) {
                out.write(len);
            }
            in.close();
        }
        out.close();
        System.out.println("合并完成");
        for (int i = 0; i < files.length; i++) {
            System.out.println(files[i] + "删除：" + files[i].delete());
        }
    }
}
