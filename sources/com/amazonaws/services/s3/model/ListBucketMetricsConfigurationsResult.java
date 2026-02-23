package com.amazonaws.services.s3.model;

import java.io.Serializable;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class ListBucketMetricsConfigurationsResult implements Serializable {
    private String continuationToken;
    private boolean isTruncated;
    private List metricsConfigurationList;
    private String nextContinuationToken;

    public String getContinuationToken() {
        return this.continuationToken;
    }

    public List getMetricsConfigurationList() {
        return this.metricsConfigurationList;
    }

    public String getNextContinuationToken() {
        return this.nextContinuationToken;
    }

    public boolean isTruncated() {
        return this.isTruncated;
    }

    public void setContinuationToken(String str) {
        this.continuationToken = str;
    }

    public void setMetricsConfigurationList(List list) {
        this.metricsConfigurationList = list;
    }

    public void setNextContinuationToken(String str) {
        this.nextContinuationToken = str;
    }

    public void setTruncated(boolean z) {
        this.isTruncated = z;
    }

    public ListBucketMetricsConfigurationsResult withContinuationToken(String str) {
        setContinuationToken(str);
        return this;
    }

    public ListBucketMetricsConfigurationsResult withMetricsConfigurationList(List list) {
        setMetricsConfigurationList(list);
        return this;
    }

    public ListBucketMetricsConfigurationsResult withNextContinuationToken(String str) {
        setNextContinuationToken(str);
        return this;
    }

    public ListBucketMetricsConfigurationsResult withTruncated(boolean z) {
        setTruncated(z);
        return this;
    }
}
