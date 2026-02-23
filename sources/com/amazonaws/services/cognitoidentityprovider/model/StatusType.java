package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public enum StatusType {
    Enabled("Enabled"),
    Disabled("Disabled");

    private static final Map enumMap;
    private String value;

    static {
        StatusType statusType = Enabled;
        StatusType statusType2 = Disabled;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("Enabled", statusType);
        hashMap.put("Disabled", statusType2);
    }

    StatusType(String str) {
        this.value = str;
    }

    public static StatusType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map map = enumMap;
        if (map.containsKey(str)) {
            return (StatusType) map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }

    public String toString() {
        return this.value;
    }
}
