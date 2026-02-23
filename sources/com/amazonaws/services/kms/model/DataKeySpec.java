package com.amazonaws.services.kms.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public enum DataKeySpec {
    AES_256("AES_256"),
    AES_128("AES_128");

    private static final Map enumMap;
    private String value;

    static {
        DataKeySpec dataKeySpec = AES_256;
        DataKeySpec dataKeySpec2 = AES_128;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("AES_256", dataKeySpec);
        hashMap.put("AES_128", dataKeySpec2);
    }

    DataKeySpec(String str) {
        this.value = str;
    }

    public static DataKeySpec fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map map = enumMap;
        if (map.containsKey(str)) {
            return (DataKeySpec) map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }

    public String toString() {
        return this.value;
    }
}
