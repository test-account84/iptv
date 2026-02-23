package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public enum MessageActionType {
    RESEND("RESEND"),
    SUPPRESS("SUPPRESS");

    private static final Map enumMap;
    private String value;

    static {
        MessageActionType messageActionType = RESEND;
        MessageActionType messageActionType2 = SUPPRESS;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("RESEND", messageActionType);
        hashMap.put("SUPPRESS", messageActionType2);
    }

    MessageActionType(String str) {
        this.value = str;
    }

    public static MessageActionType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map map = enumMap;
        if (map.containsKey(str)) {
            return (MessageActionType) map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }

    public String toString() {
        return this.value;
    }
}
