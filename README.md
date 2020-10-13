# Android APK打包后自动上传并发送钉钉消息的Gradle插件
自定义gradle插件实现自动化打包上传/fir/蒲公英/自己服务器sftp/码云Gitee仓库发送钉钉消息流程，解放你的双手，喝杯咖啡放松一下吧～欢迎使用/star/issue
- 已打包上传JitPack，接入插件只需要两步：
## 修改根目录的gradle文件
增加两行代码
```groovy
buildscript {
    repositories {
        maven { url 'https://jitpack.io' } //Jitpack仓库引用（增加这行代码）
        
        ...
    }
    dependencies {
        classpath 'com.github.jessieeeee:upload-apk-fir-plugin:1.0' //Jitpack插件引用（增加这行代码）
    }
}
```
## 在app的gradle文件中增加以下代码
引入插件fir和钉钉消息的相关配置
```groovy
apply plugin: 'com.demo.plugin'
// 上传fir平台配置
uploadApk {
    fir {
        appName = "你的app名称"
        iconPath = "src/main/res/mipmap-xxxhdpi/ic_launcher.png" // 你的app图标路径
        token = "fir平台的token"
    }
    dingTalk{
        webHook = "钉钉机器人的webhook"
        title = "Android：xxx打包完成"//消息标题
        content = "带关键字的消息内容" //这个关键字跟自定义钉钉机器人的安全设置有关
        isAtAll = false  // 是否at所有人
        atMobiles = ["手机号1","手机号2"]   //at某些人
    }
}

// 上传蒲公英平台配置
uploadApk {
    pgyer {
        apiKey = "蒲公英平台的apiKey"
    }
    dingTalk{
        webHook = "钉钉机器人的webhook"
        title = "Android：xxx打包完成"
        content = "带关键字的消息内容" //更新内容
        qrTitle = "Android：xxx二维码下载地址" // （蒲公英支持二维码获取）二维码标题
        qrContent = "带关键字的二维码下载消息内容" // （蒲公英支持二维码获取）二维码内容
        isAtAll = false  // 是否at所有人
        atMobiles = ["手机号1","手机号2"]   //at某些人
    }
}
// sftp上传自己的服务器配置
uploadApk{
    sftp {
        username = "sftp用户名"
        password = "sftp密码"
        host = "sftp服务器地址"
        port = 22 // sftp协议默认端口号
        remotePath = "/xxx/xxx" // 上传到服务器的路径
        installUrl = "http://xxx.xxx.xxx.xxx/" // 安装地址前缀
        qrApiUrl = "生成二维码api地址"
    }
    dingTalk{
        webHook = "钉钉机器人的webhook"
        title = "Android：xxx打包完成"
        content = "带关键字的消息内容" //更新内容
        qrTitle = "Android：xxx二维码下载地址" // 二维码标题
        qrContent = "带关键字的二维码下载消息内容" // 二维码内容
        isAtAll = false  // 是否at所有人
        atMobiles = ["手机号1","手机号2"]   //at某些人
    }
}

// 上传gitee配置
uploadApk{
    gitee {
        accessToken = "私有token"
        message = "提交信息 commit message"
        owner = "用户名"
        repo = "公有仓库名称"
        qrApiUrl = "生成二维码api地址"
    }
    dingTalk{
        webHook = "钉钉机器人的webhook"
        title = "Android：xxx打包完成"
        content = "带关键字的消息内容" //更新内容
        qrTitle = "Android：xxx二维码下载地址" // 二维码标题
        qrContent = "带关键字的二维码下载消息内容" // 二维码内容
        isAtAll = false  // 是否at所有人
        atMobiles = ["手机号1","手机号2"]   //at某些人
    }
}
```
## 查看插件可执行命令
- 兼容所有flavor下的debug/release打包
- gradle的打包任务名为flavor和debug/release模式组合而成
- 插件的执行命令为"assemble" + 打包任务名首字母大写 +"Fir"
- 如果不清楚当前项目中有哪些打包任务名，在app的gradle文件中最外层任意位置增加以下代码，sync一下，打印插件所有的可执行命令
```groovy
  // 上传Fir
  project.android.applicationVariants.all { variant ->
     println("assemble${variant.name.capitalize()}Fir")
  }

  // 上传蒲公英
  project.android.applicationVariants.all { variant ->
     println("assemble${variant.name.capitalize()}Pgyer")
  }

  // sftp上传自己的服务器
  project.android.applicationVariants.all { variant ->
     println("assemble${variant.name.capitalize()}Ftp")
  }

  // sftp上传Gitee
  project.android.applicationVariants.all { variant ->
     println("assemble${variant.name.capitalize()}Gitee")
  }
```
## 执行插件命令
在工程根目录下输入以下命令：
1. 如果项目未配置flavor
- debug包
`gradle assembleDebugFir` `gradle assembleDebugPgyer` `gradle assembleDebugFtp` `gradle assembleDebugGitee`
- release包
`gradle assembleReleaseFir` `gradle assembleReleasePgyer` `gradle assembleReleaseFtp` `gradle assembleReleaseGitee`
2. 配置了flavor，如flavor为googlePlay
- debug包
`gradle assembleGooglePlayDebugFir` `gradle assembleGooglePlayDebugPgyer` `gradle assembleGooglePlayDebugFtp` `gradle assembleGooglePlayDebugGitee`
- release包
`gradle assembleGooglePlayReleaseFir` `gradle assembleGooglePlayReleasePgyer` `gradle assembleGooglePlayReleaseFtp` `gradle assembleGooglePlayReleaseGitee`
## 钉钉机器人查看webHook
![钉钉机器人][1]
![钉钉机器人][2]
![钉钉机器人][3]
![钉钉机器人][4]
![钉钉机器人][5]



## fir查看token
![fir][6]
![fir][7]


[1]: https://github.com/jessieeeee/upload-apk-fir-plugin/blob/master/screenshot/robot1.png
[2]: https://github.com/jessieeeee/upload-apk-fir-plugin/blob/master/screenshot/robot2.png
[3]: https://github.com/jessieeeee/upload-apk-fir-plugin/blob/master/screenshot/robot3.png
[4]: https://github.com/jessieeeee/upload-apk-fir-plugin/blob/master/screenshot/robot4.png
[5]: https://github.com/jessieeeee/upload-apk-fir-plugin/blob/master/screenshot/robot5.png
[6]: https://github.com/jessieeeee/upload-apk-fir-plugin/blob/master/screenshot/fir1.png
[7]: https://github.com/jessieeeee/upload-apk-fir-plugin/blob/master/screenshot/fir2.png