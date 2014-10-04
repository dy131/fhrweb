package com.fhrweb.util;


import org.apache.log4j.Logger;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

public class EncryptUtil {
	private static Logger log = Logger.getLogger(EncryptUtil.class);

	public static String Md5(String str) {
		if(str==null || str.length()==0) return "";
		try {
			return toHex(Md5(str.getBytes("utf-8")));
		} catch(UnsupportedEncodingException e) {
			log.error(e);
		}
		return null;
	}

	public static byte[] Md5(byte[] data) {
		if(data==null) return null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(data);
			return md.digest();
		} catch (Exception e) {
			log.error(e);
			return null;
		}
	}

	public static String toHex(byte[] buf) {
		if(buf==null || buf.length==0) return "";
		StringBuilder sb = new StringBuilder();
		int i, n;
		for(i=0; i<buf.length; i++) {
			n = buf[i] & 0xff;
			if(n<16) sb.append("0");
			sb.append(Integer.toHexString(n));
		}
		return sb.toString();
	}

	public static byte[] encAes(byte[] data, byte[] key) {
		if(data==null) return null;
		try {
			SecretKey secretKey = new SecretKeySpec(key, "AES");
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			return cipher.doFinal(data);
		} catch (Exception e) {
			log.error(e);
			return null;
		}
	}

	public static byte[] decAes(byte[] data, byte[] key) {
		if(data==null) return null;
		try {
			SecretKey secretKey = new SecretKeySpec(key, "AES");
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			return cipher.doFinal(data);
		} catch (Exception e) {
			log.error(e);
			return null;
		}
	}

}
