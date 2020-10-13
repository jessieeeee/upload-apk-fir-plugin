package com.demo.plugin


import com.google.gson.Gson

import java.util.concurrent.TimeUnit

import okhttp3.FormBody
import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.Response

public class UploadUtil {

    String access_token
    String message

    public UploadUtil(String access_token,String message){
        this.access_token = access_token
        this.message = message
    }

    class UploadFile{
        String access_token
        String content
        String message

        public UploadFile(String access_token, String content, String message) {
            this.access_token = access_token
            this.content = content
            this.message = message
        }
    }

    public void upload(String apkPath,String fileName){
        FileUtil fileUtil = new FileUtil()
        String content = fileUtil.encryptToBase64(apkPath)
      //  fileUtil.createFile(new File("E:\\upload-apk-fir-plugin\\123.txt"),content)
        RequestBody body = FormBody.create(MediaType.parse("application/json; charset=utf-8")
                ,buildFile(this.access_token,
                        content,
                        this.message ))

        Request request = new Request.Builder().url("https://gitee.com/api/v5/repos/jessiekate/test-apk/contents/${fileName}")
                .post(body).build()
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS).build()
        Response response = null
        println("请求Gitee文件上传...")
        try {
            response = okHttpClient.newCall(request).execute()
            String result = response.body().string()
            println("文件上传结果:" + result)
        } catch (IOException e) {
            e.printStackTrace()
        }
    }

    public String buildFile(String access_token, String content,String message){
         Gson gson = new Gson()
         UploadFile uploadFile = new UploadFile(access_token,content,message)

         return gson.toJson(uploadFile)
    }
}
