package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public enum DeletionProtectionType {
    ACTIVE("ACTIVE"),
    INACTIVE("INACTIVE");

    private static final Map enumMap;
    private String value;

    static {
        DeletionProtectionType deletionProtectionType = ACTIVE;
        DeletionProtectionType deletionProtectionType2 = INACTIVE;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("ACTIVE", deletionProtectionType);
        hashMap.put("INACTIVE", deletionProtectionType2);
    }

    DeletionProtectionType(String str) {
        this.value = str;
    }

    public static DeletionProtectionType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map map = enumMap;
        if (map.containsKey(str)) {
            return (DeletionProtectionType) map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }

    public String toString() {
        return this.value;
    }
}
