package com.demo.plugin

import org.gradle.api.Action
import org.gradle.api.model.ObjectFactory

class UploadApkPluginExtension {
    FirExtension firExtension
    DingTalkExtension dingTalkExtension
    PgyerExtension pgyerExtension
    SftpExtension sftpExtension
    public UploadApkPluginExtension(ObjectFactory objectFactory) {
        firExtension = objectFactory.newInstance(FirExtension.class)
        dingTalkExtension = objectFactory.newInstance(DingTalkExtension.class)
        pgyerExtension = objectFactory.newInstance(PgyerExtension.class)
        sftpExtension = objectFactory.newInstance(SftpExtension.class)
    }

    public void pgyer(Action<PgyerExtension> action) {
        action.execute(pgyerExtension)
    }

    public void fir(Action<FirExtension> action) {
        action.execute(firExtension)
    }

    public void sftp(Action<FirExtension> action){
        action.execute(sftpExtension)
    }

    public void dingTalk(Action<DingTalkExtension> action){
        action.execute(dingTalkExtension)
    }

}