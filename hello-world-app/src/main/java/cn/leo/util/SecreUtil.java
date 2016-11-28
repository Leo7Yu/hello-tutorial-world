package cn.leo.util;

import java.security.GeneralSecurityException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/** 
 * @author LeoYu 
 * @date 2016年11月18日 下午4:07:44 
 * 
 */
public class SecreUtil {

    
    public static byte[] encryptAES(String content,String password){
        System.out.println("password length:"+password.length());
        
        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            //初始化此密钥生成器，使其具有确定的密钥大小  
            //AES 要求密钥长度为 128  
            kgen.init(128, new SecureRandom(password.getBytes()));  
            SecretKey secretKey = kgen.generateKey();  
            
            SecretKeySpec key = new SecretKeySpec(secretKey.getEncoded(), "AES"); 
            Cipher cipher = Cipher.getInstance("AES");// 创建密码器   
            cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化   
            return cipher.doFinal(content.getBytes("utf-8")); 
        } catch (Exception e) {
            e.printStackTrace();
        }  
        
        
        return null;
    }
    
    static byte[] aes(byte[] input, byte[] key, int mode) {
        try {
            SecretKey secretKey = new SecretKeySpec(key, "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(mode, secretKey);
            return cipher.doFinal(input);
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static void main(String[] args) {
        String clientSecret = "hOzjvr5r@rMQMrAcZtfJ0doQRh4P6n9^";
        byte[] result=SecreUtil.encryptAES("1478278099999116",clientSecret.substring(0,16));
        for(byte b:result){
            System.out.print(b);
        }
        System.out.println();
        
        result=SecreUtil.aes("1478278099999116".getBytes(),clientSecret.substring(0,16).getBytes(),Cipher.ENCRYPT_MODE);
        for(byte b:result){
            System.out.print(b);
        }
        //101-45-5358-760-2-39-117-84109-91776963111-76-83-10-56117-16-71125-4862-100-703062-61-124
        //101-45-5358-760-2-39-117-84109-91776963111-76-83-10-56117-16-71125-4862-100-703062-61-124
        //101-45-5358-760-2-39-117-84109-91776963111-76-83-10-56117-16-71125-4862-100-703062-61-124
        //5476-114116-9467-8-230562810872114-90-19-12265791097237-10962510442-21-125
    }
}
