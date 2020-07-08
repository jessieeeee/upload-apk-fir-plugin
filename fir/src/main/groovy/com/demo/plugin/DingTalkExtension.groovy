package com.demo.plugin

import javax.inject.Inject

public class DingTalkExtension {
    private String webHook
    private String title
    private String content

    @Inject
    public DingTalkExtension() {
    }

    String getWebHook() {
        return webHook
    }

    void setWebHook(String webHook) {
        this.webHook = webHook
    }

    String getTitle() {
        return title
    }

    void setTitle(String title) {
        this.title = title
    }

    String getContent() {
        return content
    }

    void setContent(String content) {
        this.content = content
    }


    @Override
    public String toString() {
        return "DingTalkExtension{" +
                "webHook='" + webHook + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}