package com.amazonaws.services.kms.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public enum WrappingKeySpec {
    RSA_2048("RSA_2048");

    private static final Map enumMap;
    private String value;

    static {
        WrappingKeySpec wrappingKeySpec = RSA_2048;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("RSA_2048", wrappingKeySpec);
    }

    WrappingKeySpec(String str) {
        this.value = str;
    }

    public static WrappingKeySpec fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map map = enumMap;
        if (map.containsKey(str)) {
            return (WrappingKeySpec) map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }

    public String toString() {
        return this.value;
    }
}
