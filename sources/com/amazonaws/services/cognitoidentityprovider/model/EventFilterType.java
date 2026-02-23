package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public enum EventFilterType {
    SIGN_IN("SIGN_IN"),
    PASSWORD_CHANGE("PASSWORD_CHANGE"),
    SIGN_UP("SIGN_UP");

    private static final Map enumMap;
    private String value;

    static {
        EventFilterType eventFilterType = SIGN_IN;
        EventFilterType eventFilterType2 = PASSWORD_CHANGE;
        EventFilterType eventFilterType3 = SIGN_UP;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("SIGN_IN", eventFilterType);
        hashMap.put("PASSWORD_CHANGE", eventFilterType2);
        hashMap.put("SIGN_UP", eventFilterType3);
    }

    EventFilterType(String str) {
        this.value = str;
    }

    public static EventFilterType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map map = enumMap;
        if (map.containsKey(str)) {
            return (EventFilterType) map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }

    public String toString() {
        return this.value;
    }
}
