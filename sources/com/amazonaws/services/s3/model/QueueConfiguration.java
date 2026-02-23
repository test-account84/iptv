package com.amazonaws.services.s3.model;

import java.io.Serializable;
import java.util.EnumSet;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class QueueConfiguration extends NotificationConfiguration implements Serializable {
    private String queueARN;

    public QueueConfiguration() {
    }

    public String getQueueARN() {
        return this.queueARN;
    }

    public void setQueueARN(String str) {
        this.queueARN = str;
    }

    public QueueConfiguration withQueueARN(String str) {
        setQueueARN(str);
        return this;
    }

    public QueueConfiguration(String str, EnumSet enumSet) {
        super(enumSet);
        this.queueARN = str;
    }

    public QueueConfiguration(String str, String... strArr) {
        super(strArr);
        this.queueARN = str;
    }
}
