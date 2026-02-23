package com.amazonaws.auth.policy;

import java.util.Arrays;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class Condition {
    protected String conditionKey;
    protected String type;
    protected List values;

    public String getConditionKey() {
        return this.conditionKey;
    }

    public String getType() {
        return this.type;
    }

    public List getValues() {
        return this.values;
    }

    public void setConditionKey(String str) {
        this.conditionKey = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setValues(List list) {
        this.values = list;
    }

    public Condition withConditionKey(String str) {
        setConditionKey(str);
        return this;
    }

    public Condition withType(String str) {
        setType(str);
        return this;
    }

    public Condition withValues(List list) {
        setValues(list);
        return this;
    }

    public Condition withValues(String... strArr) {
        setValues(Arrays.asList(strArr));
        return this;
    }
}
