package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public enum UsernameAttributeType {
    Phone_number("phone_number"),
    Email("email");

    private static final Map enumMap;
    private String value;

    static {
        UsernameAttributeType usernameAttributeType = Phone_number;
        UsernameAttributeType usernameAttributeType2 = Email;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("phone_number", usernameAttributeType);
        hashMap.put("email", usernameAttributeType2);
    }

    UsernameAttributeType(String str) {
        this.value = str;
    }

    public static UsernameAttributeType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map map = enumMap;
        if (map.containsKey(str)) {
            return (UsernameAttributeType) map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }

    public String toString() {
        return this.value;
    }
}
