package com.amazonaws.services.s3.model;

import com.amazonaws.AmazonWebServiceRequest;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class GetBucketAclRequest extends AmazonWebServiceRequest {
    private String bucketName;

    public GetBucketAclRequest(String str) {
        this.bucketName = str;
    }

    public String getBucketName() {
        return this.bucketName;
    }
}
