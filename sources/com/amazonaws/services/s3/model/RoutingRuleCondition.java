package com.amazonaws.services.s3.model;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class RoutingRuleCondition {
    String httpErrorCodeReturnedEquals;
    String keyPrefixEquals;

    public String getHttpErrorCodeReturnedEquals() {
        return this.httpErrorCodeReturnedEquals;
    }

    public String getKeyPrefixEquals() {
        return this.keyPrefixEquals;
    }

    public void setHttpErrorCodeReturnedEquals(String str) {
        this.httpErrorCodeReturnedEquals = str;
    }

    public void setKeyPrefixEquals(String str) {
        this.keyPrefixEquals = str;
    }

    public RoutingRuleCondition withHttpErrorCodeReturnedEquals(String str) {
        setHttpErrorCodeReturnedEquals(str);
        return this;
    }

    public RoutingRuleCondition withKeyPrefixEquals(String str) {
        setKeyPrefixEquals(str);
        return this;
    }
}
