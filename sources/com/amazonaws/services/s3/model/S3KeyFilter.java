package com.amazonaws.services.s3.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class S3KeyFilter implements Serializable {
    private List filterRules = new ArrayList();

    public enum FilterRuleName {
        Prefix,
        Suffix;

        public FilterRule newRule() {
            return new FilterRule().withName(toString());
        }

        public FilterRule newRule(String str) {
            return newRule().withValue(str);
        }
    }

    public void addFilterRule(FilterRule filterRule) {
        this.filterRules.add(filterRule);
    }

    public List getFilterRules() {
        return Collections.unmodifiableList(this.filterRules);
    }

    public void setFilterRules(List list) {
        this.filterRules = new ArrayList(list);
    }

    public S3KeyFilter withFilterRules(List list) {
        setFilterRules(list);
        return this;
    }

    public S3KeyFilter withFilterRules(FilterRule... filterRuleArr) {
        setFilterRules(Arrays.asList(filterRuleArr));
        return this;
    }
}
