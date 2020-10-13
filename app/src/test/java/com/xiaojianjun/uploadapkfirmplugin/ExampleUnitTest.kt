package com.xiaojianjun.uploadapkfirmplugin

import org.junit.Test
import java.io.File
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Paths
import java.util.*


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
//        val sftp = SftpUtil("root", "heWEI1218", "8.210.208.205", 22)
//        sftp.login()
//        sftp.upload("/root/data/nginx/html/new_gilos", "../123.txt")
//        sftp.logout()
//        appendText(File("E:\\upload-apk-fir-plugin\\123.txt"),encryptToBase64("E:\\upload-apk-fir-plugin\\app\\build\\outputs\\apk\\release\\gilos_v2.3.0-alpha4_enterprise_20200926.apk")?:"")
    }


    /**
     * 创建文件
     * filePath 文件路径
     */
    fun creatFile(filePath: File) {
        if (!filePath.exists()) {
            filePath.createNewFile()
        }
    }

    /**
     * 追加数据
     */
    fun appendText(filePath: File, content: String) {
        creatFile(filePath)
        filePath.appendText(content)
    }

    fun encryptToBase64(filePath: String?): String? {
        if (filePath == null) {
            return null
        }
        try {
            val b: ByteArray = Files.readAllBytes(Paths.get(filePath))
            return Base64.getEncoder().encodeToString(b)
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return null
    }
}