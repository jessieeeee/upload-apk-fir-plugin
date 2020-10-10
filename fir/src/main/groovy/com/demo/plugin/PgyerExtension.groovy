package com.demo.plugin
import javax.inject.Inject

public class PgyerExtension {
    private String apiKey

    @Inject
    public PgyerExtension() {
    }

    String getApiKey() {
        return apiKey
    }

    void setApiKey(String apiKey) {
        this.apiKey = apiKey
    }
}