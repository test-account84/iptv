package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public enum UserPoolMfaType {
    OFF("OFF"),
    ON("ON"),
    OPTIONAL("OPTIONAL");

    private static final Map enumMap;
    private String value;

    static {
        UserPoolMfaType userPoolMfaType = OFF;
        UserPoolMfaType userPoolMfaType2 = ON;
        UserPoolMfaType userPoolMfaType3 = OPTIONAL;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("OFF", userPoolMfaType);
        hashMap.put("ON", userPoolMfaType2);
        hashMap.put("OPTIONAL", userPoolMfaType3);
    }

    UserPoolMfaType(String str) {
        this.value = str;
    }

    public static UserPoolMfaType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map map = enumMap;
        if (map.containsKey(str)) {
            return (UserPoolMfaType) map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }

    public String toString() {
        return this.value;
    }
}
