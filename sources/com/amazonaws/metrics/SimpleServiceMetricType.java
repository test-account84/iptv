package com.amazonaws.metrics;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class SimpleServiceMetricType extends SimpleMetricType implements ServiceMetricType {
    private final String name;
    private final String serviceName;

    public SimpleServiceMetricType(String str, String str2) {
        this.name = str;
        this.serviceName = str2;
    }

    public String getServiceName() {
        return this.serviceName;
    }

    public String name() {
        return this.name;
    }
}
