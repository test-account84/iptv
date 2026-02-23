package com.amazonaws.services.s3.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class BucketCrossOriginConfiguration implements Serializable {
    private List rules;

    public BucketCrossOriginConfiguration() {
    }

    public List getRules() {
        return this.rules;
    }

    public void setRules(List list) {
        this.rules = list;
    }

    public BucketCrossOriginConfiguration withRules(List list) {
        setRules(list);
        return this;
    }

    public BucketCrossOriginConfiguration(List list) {
        this.rules = list;
    }

    public BucketCrossOriginConfiguration withRules(CORSRule... cORSRuleArr) {
        setRules(Arrays.asList(cORSRuleArr));
        return this;
    }
}
