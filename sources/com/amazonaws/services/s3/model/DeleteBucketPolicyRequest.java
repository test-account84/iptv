package com.amazonaws.services.s3.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class DeleteBucketPolicyRequest extends AmazonWebServiceRequest implements Serializable {
    private String bucketName;

    public DeleteBucketPolicyRequest(String str) {
        this.bucketName = str;
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public DeleteBucketPolicyRequest withBucketName(String str) {
        setBucketName(str);
        return this;
    }
}
