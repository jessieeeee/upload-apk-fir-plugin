package com.demo.plugin
import javax.inject.Inject

public class GiteeExtension {
    private String accessToken
    private String message
    private String owner
    private String repo
    private String qrApiUrl
    @Inject
    public GiteeExtension() {
    }

    String getAccessToken() {
        return accessToken
    }

    void setAccessToken(String accessToken) {
        this.accessToken = accessToken
    }

    String getMessage() {
        return message
    }

    void setMessage(String message) {
        this.message = message
    }

    String getOwner() {
        return owner
    }

    void setOwner(String owner) {
        this.owner = owner
    }

    String getRepo() {
        return repo
    }

    void setRepo(String repo) {
        this.repo = repo
    }

    String getQrApiUrl() {
        return qrApiUrl
    }

    void setQrApiUrl(String qrApiUrl) {
        this.qrApiUrl = qrApiUrl
    }
}