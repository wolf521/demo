package com.example.demo.encryp;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * aes加密解密
 */
public class EncrypAES {
	// 16秘钥字符串
	private String key = "A14D6B83A4580C4A";
	// SecretKey 负责保存对称密钥
	private SecretKey deskey = new SecretKeySpec(key.getBytes(),"AES");
	// Cipher负责完成加密或解密工作
	private static Cipher c;
	static{
		try{
			c = Cipher.getInstance("AES");
		} catch (NoSuchAlgorithmException e){
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 加密
	 *
	 * @param str
	 * @return
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
			r = parseByte2HexStr(cipherByte);
		} catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException
				| UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return r;
	}

	/**
	 * 解密
	 *
	 * @param str
	 * @return
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
		String msg = "加密";
		String encontent = de1.Encrytor(msg);
		String decontent = de1.Decryptor(encontent);
		System.out.println("明文是:" + msg);
		System.out.println("加密后:" + encontent);
		System.out.println("解密后:" + decontent);
	}

	/**
	 * 2进制转16进制
	 *
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

	/**
	 * 16进制转2进制
	 *
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
