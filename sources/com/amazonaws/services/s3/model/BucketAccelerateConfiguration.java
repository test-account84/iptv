package com.amazonaws.services.s3.model;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class BucketAccelerateConfiguration {
    private String status;

    public BucketAccelerateConfiguration(BucketAccelerateStatus bucketAccelerateStatus) {
        setStatus(bucketAccelerateStatus);
    }

    public String getStatus() {
        return this.status;
    }

    public boolean isAccelerateEnabled() {
        return BucketAccelerateStatus.Enabled.toString().equals(getStatus());
    }

    public void setStatus(BucketAccelerateStatus bucketAccelerateStatus) {
        setStatus(bucketAccelerateStatus.toString());
    }

    public BucketAccelerateConfiguration withStatus(BucketAccelerateStatus bucketAccelerateStatus) {
        setStatus(bucketAccelerateStatus);
        return this;
    }

    public BucketAccelerateConfiguration(String str) {
        setStatus(str);
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public BucketAccelerateConfiguration withStatus(String str) {
        setStatus(str);
        return this;
    }
}
