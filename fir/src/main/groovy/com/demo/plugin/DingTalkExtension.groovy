package com.demo.plugin

import javax.inject.Inject

public class DingTalkExtension {
    private String webHook
    private String title
    private String content
    private String qrTitle
    private String qrContent
    private boolean isAtAll
    private List<String> atMobiles
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

    boolean getIsAtAll() {
        return isAtAll
    }

    void setIsAtAll(boolean isAtAll) {
        this.isAtAll = isAtAll
    }

    List<String> getAtMobiles() {
        return atMobiles
    }

    void setAtMobiles(List<String> atMobiles) {
        this.atMobiles = atMobiles
    }

    String getQrTitle() {
        return qrTitle
    }

    void setQrTitle(String qrTitle) {
        this.qrTitle = qrTitle
    }

    String getQrContent() {
        return qrContent
    }

    void setQrContent(String qrContent) {
        this.qrContent = qrContent
    }

    @Override
    public String toString() {
        return "DingTalkExtension{" +
                "webHook='" + webHook + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", isAtAll=" + isAtAll +
                ", atMobiles=" + atMobiles +
                '}';
    }
}