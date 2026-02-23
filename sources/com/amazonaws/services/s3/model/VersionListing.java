package com.amazonaws.services.s3.model;

import java.util.ArrayList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class VersionListing {
    private String bucketName;
    private String delimiter;
    private String encodingType;
    private boolean isTruncated;
    private String keyMarker;
    private int maxKeys;
    private String nextKeyMarker;
    private String nextVersionIdMarker;
    private String prefix;
    private String versionIdMarker;
    private List versionSummaries = new ArrayList();
    private List commonPrefixes = new ArrayList();

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

    public int getMaxKeys() {
        return this.maxKeys;
    }

    public String getNextKeyMarker() {
        return this.nextKeyMarker;
    }

    public String getNextVersionIdMarker() {
        return this.nextVersionIdMarker;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public String getVersionIdMarker() {
        return this.versionIdMarker;
    }

    public List getVersionSummaries() {
        return this.versionSummaries;
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

    public void setMaxKeys(int i) {
        this.maxKeys = i;
    }

    public void setNextKeyMarker(String str) {
        this.nextKeyMarker = str;
    }

    public void setNextVersionIdMarker(String str) {
        this.nextVersionIdMarker = str;
    }

    public void setPrefix(String str) {
        this.prefix = str;
    }

    public void setTruncated(boolean z) {
        this.isTruncated = z;
    }

    public void setVersionIdMarker(String str) {
        this.versionIdMarker = str;
    }

    public void setVersionSummaries(List list) {
        this.versionSummaries = list;
    }
}
