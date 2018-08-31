package com.crm.md5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
    // MD5加码。32位
    public static String MD5(String inStr,String hashType) {
        StringBuilder sb = new StringBuilder();
        MessageDigest md5;
        try {
            md5 = MessageDigest.getInstance(hashType);
            md5.update(inStr.getBytes());
            for (byte b : md5.digest()) {
                sb.append(String.format("%02X", b)); // 10进制转16进制，X 表示以十六进制形式输出，02 表示不足两位前面补0输出
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    // 可逆的加密算法
    public static String KL(String inStr) {
        // String s = newString(inStr);
        char[] a = inStr.toCharArray();
        for (int i = 0; i < a.length; i++) {
            a[i] = (char) (a[i] ^ 't');
        }
        String s = new String(a);
        return s;
    }

    // 加密后解密
    public static String JM(String inStr) {
        char[] a = inStr.toCharArray();
        for (int i = 0; i < a.length; i++) {
            a[i] = (char) (a[i] ^ 't');
        }
        String k = new String(a);
        return k;
    }

    /**
     * 为密码加密
     * @param pwd
     * @return
     */
    public static String  MD5Util(String pwd){
        String md5 = MD5.MD5(pwd, "md5");   //第一次加密密码为md5格式
        String kl = MD5.KL(md5);  //再次加密，防止他人解密
        String jm = MD5.JM(kl);   // 解密MD  这样子就无法轻易被解密
        return jm;
    }
}
