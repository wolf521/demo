package com.example.demo.io;

import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * Created by cuizhixiang on 2017/7/4.
 **/
public class TestPipedIo {
    public static void main(String args[])throws Exception{
        test();
    }
    public static void test()throws Exception{
        PipedInputStream pin = new PipedInputStream();
        PipedOutputStream pout = new PipedOutputStream();
        //输入流与输出流连接
        pin.connect(pout);

        ReadThread readTh   = new ReadThread(pin);
        WriteThread writeTh = new WriteThread(pout);
        new Thread(readTh).start();
        new Thread(writeTh).start();
    }
}
class ReadThread implements Runnable {
    private PipedInputStream pin;
    ReadThread(PipedInputStream pin) {
        this.pin=pin;
    }
    public void run() {
        try {
            sop("R:读取前没有数据,阻塞中...等待数据传过来再输出到控制台...");
            byte[] buf = new byte[1024];
            int len = pin.read(buf);
            sop("R:读取数据成功,阻塞解除...");
            String s= new String(buf,0,len);
            sop(s);
            pin.close();
        } catch(Exception e) {
            throw new RuntimeException("R:管道读取流失败!");
        }
    }

    public static void sop(Object obj) {
        System.out.println(obj);
    }
}

class WriteThread implements Runnable {
    private PipedOutputStream pout;
    WriteThread(PipedOutputStream pout) {
        this.pout=  pout;
    }
    public void run() {
        try {
            sop("W:开始将数据写入:但等个5秒让我们观察...");
            Thread.sleep(5000);  //释放cpu执行权5秒
            pout.write("W: writePiped 数据...".getBytes());  //管道输出流
            pout.close();
        } catch(Exception e) {
            throw new RuntimeException("W:WriteThread写入失败...");
        }
    }

    public static void sop(Object obj) {
        System.out.println(obj);
    }
}
