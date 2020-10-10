package com.demo.plugin
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
public class MD5Util{


    public static calcMD5(filePath) {
        MessageDigest md = null
        try {
            md = MessageDigest.getInstance("MD5")
        } catch (NoSuchAlgorithmException e) {
            return ""
        }
        new File(filePath).eachByte 4096, {
            bytes, size -> md.update(bytes, 0, size)
        }
        String result = md.digest().collect { String.format "%02x", it }.join()
        System.out.println(String.format("The md5 of File %s is:\n%s", filePath, result))
        return result
    }
}