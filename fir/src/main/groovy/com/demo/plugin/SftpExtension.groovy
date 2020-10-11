package com.demo.plugin
import javax.inject.Inject

public class SftpExtension {
    private String username
    private String password
    private String host
    private String port
    private String remotePath
    private String installUrl
    private String qrApiUrl
    @Inject
    public SftpExtension() {
    }

    String getUsername() {
        return username
    }

    void setUsername(String username) {
        this.username = username
    }

    String getPassword() {
        return password
    }

    void setPassword(String password) {
        this.password = password
    }

    String getHost() {
        return host
    }

    void setHost(String host) {
        this.host = host
    }

    String getPort() {
        return port
    }

    void setPort(String port) {
        this.port = port
    }

    String getRemotePath() {
        return remotePath
    }

    void setRemotePath(String remotePath) {
        this.remotePath = remotePath
    }

    String getInstallUrl() {
        return installUrl
    }

    void setInstallUrl(String installUrl) {
        this.installUrl = installUrl
    }

    String getQrApiUrl() {
        return qrApiUrl
    }

    void setQrApiUrl(String qrApiUrl) {
        this.qrApiUrl = qrApiUrl
    }
}