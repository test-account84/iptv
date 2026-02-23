package com.amazonaws.services.s3.model;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class BucketWebsiteConfiguration implements Serializable {
    private String errorDocument;
    private String indexDocumentSuffix;
    private RedirectRule redirectAllRequestsTo;
    private List routingRules = new LinkedList();

    public BucketWebsiteConfiguration() {
    }

    public String getErrorDocument() {
        return this.errorDocument;
    }

    public String getIndexDocumentSuffix() {
        return this.indexDocumentSuffix;
    }

    public RedirectRule getRedirectAllRequestsTo() {
        return this.redirectAllRequestsTo;
    }

    public List getRoutingRules() {
        return this.routingRules;
    }

    public void setErrorDocument(String str) {
        this.errorDocument = str;
    }

    public void setIndexDocumentSuffix(String str) {
        this.indexDocumentSuffix = str;
    }

    public void setRedirectAllRequestsTo(RedirectRule redirectRule) {
        this.redirectAllRequestsTo = redirectRule;
    }

    public void setRoutingRules(List list) {
        this.routingRules = list;
    }

    public BucketWebsiteConfiguration withRedirectAllRequestsTo(RedirectRule redirectRule) {
        this.redirectAllRequestsTo = redirectRule;
        return this;
    }

    public BucketWebsiteConfiguration withRoutingRules(List list) {
        this.routingRules = list;
        return this;
    }

    public BucketWebsiteConfiguration(String str) {
        this.indexDocumentSuffix = str;
    }

    public BucketWebsiteConfiguration(String str, String str2) {
        this.indexDocumentSuffix = str;
        this.errorDocument = str2;
    }
}
