package com.example.demo.encryp;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * 对字符串做加解密
 * 如：
 * EncrypAES de1 = new EncrypAES();
 * String msg = "你好";
 * String encontent = de1.Encrytor(msg);
 * String decontent = de1.Decryptor(encontent);
 * System.out.println("明文是:" + msg);
 * System.out.println("加密后:" + encontent);
 * System.out.println("解密后:" + decontent);
 *
 * @author Jie
 *
 */
public class EncrypAES {
    /**
     *
     */
// SecretKey 负责保存对称密钥
    private SecretKey deskey;
    // Cipher负责完成加密或解密工作
    private static Cipher c;
    // 密码
    private String key = "yt";

    public EncrypAES() {
        //Security.addProvider(new com.sun.crypto.provider.SunJCE());
        // 生成密钥
        deskey = new SecretKeySpec(new byte[] { -95, 77, 107, -125, -92, 88, 12, 74, -12, 13, 97, 29, -105, -47, 5, -117 },
                "AES");

        // 生成Cipher对象,指定其支持的DES算法
        try {
//			KeyGenerator kgen = KeyGenerator.getInstance("AES");
//			kgen.init(128, new SecureRandom(key.getBytes()));
//			deskey = kgen.generateKey();
            c = Cipher.getInstance("AES");
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
            e.printStackTrace();
        }
    }

    /**
     * 对字符串加密
     *
     * @param str
     *            未加密的字符串
     * @return 加密的字符串
     */
    public String Encrytor(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        String r = null;
        try {
            // 根据密钥，对Cipher对象进行初始化，ENCRYPT_MODE表示加密模式
            c.init(Cipher.ENCRYPT_MODE, deskey);
            byte[] src = str.getBytes("UTF-8");
            // 加密，结果保存进cipherByte
            byte[] cipherByte = c.doFinal(src);

//			r = new String(cipherByte, "UTF-8");
            r = parseByte2HexStr(cipherByte);
        } catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException
                | UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return r;
    }

    /**
     * 对字符串解密
     *
     * @param str
     *            加密的字符串
     * @return 解密后的字符串
     */
    public String Decryptor(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        String r = "";
        try {
            // 根据密钥，对Cipher对象进行初始化，DECRYPT_MODE表示加密模式

            byte[] buff = parseHexStr2Byte(str);
            c.init(Cipher.DECRYPT_MODE, deskey);
            byte[] cipherByte = c.doFinal(buff);
            r = new String(cipherByte, "UTF-8");
        } catch (InvalidKeyException | UnsupportedEncodingException | IllegalBlockSizeException
                | BadPaddingException e) {
            e.printStackTrace();
        }
        return r;
    }

    public static void main(String[] args) {
        EncrypAES de1 = new EncrypAES();
        String msg = "邢攸吉";
        String encontent = de1.Encrytor(msg);
        String decontent = de1.Decryptor(encontent);
        System.out.println("明文是:" + msg);
        System.out.println("加密后:" + encontent);
        System.out.println("长度："+encontent.length());
        System.out.println("解密后:" + decontent);
    }

    /**将二进制转换成16进制
     * @param buf
     * @return
     */
    private String parseByte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }

    /**将16进制转换为二进制
     * @param hexStr
     * @return
     */
    private byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1)
            return null;
        byte[] result = new byte[hexStr.length()/2];
        for (int i = 0;i< hexStr.length()/2; i++) {
            int high = Integer.parseInt(hexStr.substring(i*2, i*2+1), 16);
            int low = Integer.parseInt(hexStr.substring(i*2+1, i*2+2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }



}
