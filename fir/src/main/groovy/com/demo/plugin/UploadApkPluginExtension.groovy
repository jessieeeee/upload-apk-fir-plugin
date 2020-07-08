package com.demo.plugin

import org.gradle.api.Action
import org.gradle.api.model.ObjectFactory

class UploadApkPluginExtension {
    FirExtension firExtension
    DingTalkExtension dingTalkExtension
    public UploadApkPluginExtension(ObjectFactory objectFactory) {
        firExtension = objectFactory.newInstance(FirExtension.class)
        dingTalkExtension = objectFactory.newInstance(DingTalkExtension.class)
    }

    public void fir(Action<FirExtension> action) {
        action.execute(firExtension)
    }

    public void dingTalk(Action<DingTalkExtension> action){
        action.execute(dingTalkExtension)
    }

}