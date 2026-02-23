package com.amazonaws.services.s3.model;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class HeadBucketResult {
    private String bucketRegion;

    public String getBucketRegion() {
        return this.bucketRegion;
    }

    public void setBucketRegion(String str) {
        this.bucketRegion = str;
    }

    public HeadBucketResult withBucketRegion(String str) {
        setBucketRegion(str);
        return this;
    }
}
