package com.amazonaws.services.s3.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class TagSet {
    private Map tags;

    public TagSet() {
        this.tags = new HashMap(1);
    }

    public Map getAllTags() {
        return this.tags;
    }

    public String getTag(String str) {
        return (String) this.tags.get(str);
    }

    public void setTag(String str, String str2) {
        this.tags.put(str, str2);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("{");
        stringBuffer.append("Tags: " + getAllTags());
        stringBuffer.append("}");
        return stringBuffer.toString();
    }

    public TagSet(Map map) {
        HashMap hashMap = new HashMap(1);
        this.tags = hashMap;
        hashMap.putAll(map);
    }
}
