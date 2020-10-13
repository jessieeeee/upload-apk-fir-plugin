package com.demo.plugin

import java.nio.file.Files
import java.nio.file.Paths
import kotlin.text.Charsets

public class FileUtil {

    public String encryptToBase64(String filePath) {
        if (filePath == null) {
            println("该路径文件路径为空")
            return null
        }
        try {
            println("文件转换base64...")
            byte[] b = Files.readAllBytes(Paths.get(filePath))
            return Base64.getEncoder().encodeToString(b)
        } catch (IOException e) {
            println("base64转换异常:${ e.stackTrace}")
        }

        return null
    }

    public void createFile(File filePath,String text) {
        if (!filePath.exists()) {
            try {
                filePath.createNewFile()
                FileOutputStream fileOutputStream = new FileOutputStream(filePath,true)
                fileOutputStream.write(text.getBytes(Charsets.UTF_8))
            } catch (IOException e) {
                e.printStackTrace()
            }
        }
    }

}
