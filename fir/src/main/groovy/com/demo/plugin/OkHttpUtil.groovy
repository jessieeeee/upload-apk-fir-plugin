package com.demo.plugin

import com.google.gson.Gson
import okhttp3.*

import java.util.concurrent.TimeUnit

public class OkHttpUtil{
    OkHttpClient okHttpClient
    Gson gson
    DingTalk dingTalk
    public OkHttpUtil(){
        okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS).build()
        gson = new Gson()
        dingTalk = new DingTalk()
    }

    BundleApp getCert(String appPackage, String apiTokenFir){

        FormBody.Builder build = new FormBody.Builder()
        build.add("bundle_id", appPackage)
        build.add("api_token", apiTokenFir)
        build.add("type", "android")
        Request request = new Request.Builder().url("http://api.bq04.com/apps").post(build.build()).build()
        Response response = okHttpClient.newCall(request).execute()
        String result = response.body.string()
        return gson.fromJson(result, BundleApp.class)
    }


    String uploadApk(String apkPath,String key,String token,String appName,String appVersion,String appBuild,String fileName,String upload_url) {
        RequestBody fileBody = RequestBody.create(MediaType.parse("application/octet-stream"), new File(apkPath))
        MultipartBody body = new MultipartBody.Builder()
                .setType(MediaType.parse("multipart/form-data"))
                .addFormDataPart("key", key)
                .addFormDataPart("token", token)
                .addFormDataPart("x:name", appName)
                .addFormDataPart("x:version", appVersion)
                .addFormDataPart("x:build", appBuild)
                .addFormDataPart("file", fileName, fileBody)
                .build()
        Request requestApk = new Request.Builder().url(upload_url).post(body).build()

        Response responseApk = okHttpClient.newCall(requestApk).execute()
        return responseApk.body.string()
    }


    String uploadIcon(String apkIconPath,String keyIcon,String tokenIcon,String upload_urlIcon){
        RequestBody fileBodyIcon = RequestBody.create(MediaType.parse("application/octet-stream"),new File(apkIconPath))
        MultipartBody bodyIcon = new MultipartBody.Builder()
                .setType(MediaType.parse("multipart/form-data"))
                .addFormDataPart("key", keyIcon)
                .addFormDataPart("token", tokenIcon)
                .addFormDataPart("file", "icon.png", fileBodyIcon)
                .build()
        Request requestIcon = new Request.Builder().url(upload_urlIcon).post(bodyIcon).build()
        Response responseIcon = okHttpClient.newCall(requestIcon).execute()
        return responseIcon.body.string()
    }

    ApkInfo getApkUrl(String appPackage, String apiTokenFir) {
        // 获取成功连接
        String queryurl =
                "http://api.bq04.com/apps/latest/$appPackage?api_token=$apiTokenFir&type=android"
        Request requestUrl = new Request.Builder().url(queryurl).get().build()
        Response responseUrl = okHttpClient.newCall(requestUrl).execute()
        String result = responseUrl.body.string()
        return gson.fromJson(result,ApkInfo.class)
    }

    void sendDingTalkLink(String text,String title,String url,String webHook){
        RequestBody linkBody = FormBody.create(MediaType.parse("application/json; charset=utf-8")
                , dingTalk.createLinkMsg(text,title,url))
        Request linkDingTalk = new Request.Builder().url(webHook)
                .post(linkBody).build()
        Response responseLink = okHttpClient.newCall(linkDingTalk).execute()
        String result = responseLink.body.string()
        println("已发送钉钉链接:$result")
    }

    void sendDingTalkMsg(String url,String webHook){
        RequestBody textBody = FormBody.create(MediaType.parse("application/json; charset=utf-8")
                , dingTalk.createTextMsg("gilos下载链接:$url"))
        Request textDingTalk = new Request.Builder().url(webHook)
                .post(textBody).build()
        Response responseText = okHttpClient.newCall(textDingTalk).execute()
        String result = responseText.body.string()
        println("已发送钉钉消息:$result")
    }
}