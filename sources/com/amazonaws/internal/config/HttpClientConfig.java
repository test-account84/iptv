package com.amazonaws.internal.config;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class HttpClientConfig {
    private final String serviceName;

    public HttpClientConfig(String str) {
        this.serviceName = str;
    }

    public String getServiceName() {
        return this.serviceName;
    }

    public String toString() {
        return "serviceName: " + this.serviceName;
    }
}
