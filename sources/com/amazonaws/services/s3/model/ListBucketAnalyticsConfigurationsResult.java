package com.amazonaws.services.s3.model;

import java.io.Serializable;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class ListBucketAnalyticsConfigurationsResult implements Serializable {
    private List analyticsConfigurationList;
    private String continuationToken;
    private boolean isTruncated;
    private String nextContinuationToken;

    public List getAnalyticsConfigurationList() {
        return this.analyticsConfigurationList;
    }

    public String getContinuationToken() {
        return this.continuationToken;
    }

    public String getNextContinuationToken() {
        return this.nextContinuationToken;
    }

    public boolean isTruncated() {
        return this.isTruncated;
    }

    public void setAnalyticsConfigurationList(List list) {
        this.analyticsConfigurationList = list;
    }

    public void setContinuationToken(String str) {
        this.continuationToken = str;
    }

    public void setNextContinuationToken(String str) {
        this.nextContinuationToken = str;
    }

    public void setTruncated(boolean z) {
        this.isTruncated = z;
    }

    public ListBucketAnalyticsConfigurationsResult withAnalyticsConfigurationList(List list) {
        setAnalyticsConfigurationList(list);
        return this;
    }

    public ListBucketAnalyticsConfigurationsResult withContinuationToken(String str) {
        setContinuationToken(str);
        return this;
    }

    public ListBucketAnalyticsConfigurationsResult withNextContinuationToken(String str) {
        setNextContinuationToken(str);
        return this;
    }

    public ListBucketAnalyticsConfigurationsResult withTruncated(boolean z) {
        setTruncated(z);
        return this;
    }
}
