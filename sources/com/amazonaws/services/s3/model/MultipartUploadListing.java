package com.amazonaws.services.s3.model;

import java.util.ArrayList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class MultipartUploadListing {
    private String bucketName;
    private List commonPrefixes = new ArrayList();
    private String delimiter;
    private String encodingType;
    private boolean isTruncated;
    private String keyMarker;
    private int maxUploads;
    private List multipartUploads;
    private String nextKeyMarker;
    private String nextUploadIdMarker;
    private String prefix;
    private String uploadIdMarker;

    public String getBucketName() {
        return this.bucketName;
    }

    public List getCommonPrefixes() {
        return this.commonPrefixes;
    }

    public String getDelimiter() {
        return this.delimiter;
    }

    public String getEncodingType() {
        return this.encodingType;
    }

    public String getKeyMarker() {
        return this.keyMarker;
    }

    public int getMaxUploads() {
        return this.maxUploads;
    }

    public List getMultipartUploads() {
        if (this.multipartUploads == null) {
            this.multipartUploads = new ArrayList();
        }
        return this.multipartUploads;
    }

    public String getNextKeyMarker() {
        return this.nextKeyMarker;
    }

    public String getNextUploadIdMarker() {
        return this.nextUploadIdMarker;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public String getUploadIdMarker() {
        return this.uploadIdMarker;
    }

    public boolean isTruncated() {
        return this.isTruncated;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public void setCommonPrefixes(List list) {
        this.commonPrefixes = list;
    }

    public void setDelimiter(String str) {
        this.delimiter = str;
    }

    public void setEncodingType(String str) {
        this.encodingType = str;
    }

    public void setKeyMarker(String str) {
        this.keyMarker = str;
    }

    public void setMaxUploads(int i) {
        this.maxUploads = i;
    }

    public void setMultipartUploads(List list) {
        this.multipartUploads = list;
    }

    public void setNextKeyMarker(String str) {
        this.nextKeyMarker = str;
    }

    public void setNextUploadIdMarker(String str) {
        this.nextUploadIdMarker = str;
    }

    public void setPrefix(String str) {
        this.prefix = str;
    }

    public void setTruncated(boolean z) {
        this.isTruncated = z;
    }

    public void setUploadIdMarker(String str) {
        this.uploadIdMarker = str;
    }
}
