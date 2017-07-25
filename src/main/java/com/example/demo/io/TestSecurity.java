package com.example.demo.io;

import com.sun.crypto.provider.SunJCE;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.Key;
import java.security.Security;

/**
 * Created by cuizhixiang on 2017/7/24.
 * DES加密算法
 **/
public class TestSecurity {
    private static String setDefaultKey = "zkdjciurjgnm";
    private Cipher encryptCipher = null;
    private Cipher decryptCipher = null;

    public TestSecurity() throws Exception {
        this(setDefaultKey);
    }

    public TestSecurity(String key) throws Exception {
        Security.addProvider(new SunJCE());
        Key key1 = getKey(key.getBytes());
        encryptCipher = Cipher.getInstance("DES");
        encryptCipher.init(Cipher.ENCRYPT_MODE, key1);
        decryptCipher = Cipher.getInstance("DES");
        decryptCipher.init(Cipher.DECRYPT_MODE, key1);
    }

    /**
     * 得到秘钥接口
     *
     * @param bytes
     * @return
     * @throws Exception
     */
    public static Key getKey(byte[] bytes) throws Exception {
        byte[] b = new byte[8];
        for (int i = 0; i < bytes.length && i < b.length; i++) {
            b[i] = bytes[i];
        }
        Key key = new SecretKeySpec(b, "DES");
        return key;
    }

    /**
     * 字符串加密
     *
     * @param s
     * @return
     * @throws Exception
     */
    public String encryptCipher(String s) throws Exception {
        return encrypt(encryptCipher(s.getBytes()));
    }

    /**
     * 加密
     *
     * @param b 加密密码
     * @return 加密后
     */
    public static String encrypt(byte[] b) {
        int len = b.length;
        StringBuffer buffer = new StringBuffer(len * 2);
        for (int i = 0; i < len; i++) {
            int tmp = b[i];
            if (tmp < 0) {
                tmp += 256;
            }
            if (tmp < 16) {
                buffer.append("0");
            }
            buffer.append(Integer.toString(tmp, 16));
        }
        return buffer.toString();
    }

    /**
     * 加密
     *
     * @param b
     * @return
     * @throws Exception
     */
    public byte[] encryptCipher(byte[] b) throws Exception {
        return encryptCipher.doFinal(b);
    }

    /**
     * 字符串解密
     *
     * @param s 解密字符串
     * @return
     * @throws Exception
     */
    public String decryptCipher(String s) throws Exception {
        return new String(decryptCipher(decrypt(s)));
    }

    /**
     * 解密
     *
     * @param s 字符串
     * @return 解密结果
     */
    public byte[] decrypt(String s) {
        byte b[] = s.getBytes();
        int len = b.length;
        byte[] bytes = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            String tmp = new String(b, i, 2);
            bytes[i / 2] = (byte) Integer.parseInt(tmp, 16);
        }
        return bytes;
    }

    /**
     * 解密
     *
     * @param b
     * @return
     * @throws Exception
     */
    public byte[] decryptCipher(byte[] b) throws Exception {
        return decryptCipher.doFinal(b);
    }

    /**
     * 文件加密
     *
     * @param srcPath  加密前路径
     * @param destPath 加密后路径
     * @throws Exception
     */
    public void encryptFile(String srcPath, String destPath) throws Exception {
        File file = new File(srcPath);
        byte[] bytes = getByteFile(file);
        writeByteToFile(encryptCipher(bytes), destPath);
    }

    /**
     * 文件解密
     *
     * @param srcPath  解密前路径
     * @param destPath 解密后路径
     * @throws Exception
     */
    public void decryptFile(String srcPath, String destPath) throws Exception {
        File file = new File(srcPath);
        byte[] bytes = getByteFile(file);
        writeByteToFile(decryptCipher(bytes), destPath);
    }

    /**
     * 读取文件
     *
     * @param file
     * @return
     * @throws IOException
     */
    public static byte[] getByteFile(File file) throws IOException {
        // 获取输入流对象
        InputStream inputStream = new FileInputStream(file);
        long len = file.length();
        if (len > Integer.MAX_VALUE) {
            return null;
        }
        byte[] b = new byte[(int) len];
        int offSet = 0;
        int numRead = 0;
        while (offSet < b.length && (numRead = inputStream.read(b, offSet, b.length - offSet)) >= 0) {
            offSet += numRead;
        }
        if (offSet < b.length) {
            throw new IOException("不能完整读取文件" + file.getName());
        }
        inputStream.close();
        return b;
    }

    /**
     * 加密后写入文件
     *
     * @param bytes
     * @param filePath
     * @return
     * @throws IOException
     */
    public static File writeByteToFile(byte[] bytes, String filePath) throws IOException {
        File file = null;
        try {
            file = new File(filePath);
            file.createNewFile();
            FileOutputStream outputStream = new FileOutputStream(file);
            outputStream.write(bytes);
            outputStream.close();
        } catch (FileNotFoundException ef) {
            throw new FileNotFoundException("不能完整读取文件" + file.getName());
        }
        return file;
    }

    public static void main(String args[]) throws Exception {
        //String encrypt = new TestSecurity().encryptCipher(setDefaultKey);
        //String decrypt = new TestSecurity().decryptCipher(encrypt);
        new TestSecurity().encryptFile("e:/10分钟音乐.mp4", "e:/encrypt.ff");
        new TestSecurity().decryptFile("e:/encrypt.ff", "e:/decrypt.mp4");
    }
}
