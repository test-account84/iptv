package com.amazonaws.services.s3.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class CompleteMultipartUploadRequest extends AmazonWebServiceRequest implements Serializable {
    private String bucketName;
    private boolean isRequesterPays;
    private String key;
    private List partETags;
    private String uploadId;

    public CompleteMultipartUploadRequest() {
        this.partETags = new ArrayList();
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public String getKey() {
        return this.key;
    }

    public List getPartETags() {
        return this.partETags;
    }

    public String getUploadId() {
        return this.uploadId;
    }

    public boolean isRequesterPays() {
        return this.isRequesterPays;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setPartETags(List list) {
        this.partETags = list;
    }

    public void setRequesterPays(boolean z) {
        this.isRequesterPays = z;
    }

    public void setUploadId(String str) {
        this.uploadId = str;
    }

    public CompleteMultipartUploadRequest withBucketName(String str) {
        this.bucketName = str;
        return this;
    }

    public CompleteMultipartUploadRequest withKey(String str) {
        this.key = str;
        return this;
    }

    public CompleteMultipartUploadRequest withPartETags(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            UploadPartResult uploadPartResult = (UploadPartResult) it.next();
            this.partETags.add(new PartETag(uploadPartResult.getPartNumber(), uploadPartResult.getETag()));
        }
        return this;
    }

    public CompleteMultipartUploadRequest withRequesterPays(boolean z) {
        setRequesterPays(z);
        return this;
    }

    public CompleteMultipartUploadRequest withUploadId(String str) {
        this.uploadId = str;
        return this;
    }

    public CompleteMultipartUploadRequest(String str, String str2, String str3, List list) {
        new ArrayList();
        this.bucketName = str;
        this.key = str2;
        this.uploadId = str3;
        this.partETags = list;
    }

    public CompleteMultipartUploadRequest withPartETags(List list) {
        setPartETags(list);
        return this;
    }

    public CompleteMultipartUploadRequest withPartETags(UploadPartResult... uploadPartResultArr) {
        for (UploadPartResult uploadPartResult : uploadPartResultArr) {
            this.partETags.add(new PartETag(uploadPartResult.getPartNumber(), uploadPartResult.getETag()));
        }
        return this;
    }
}
