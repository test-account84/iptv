package com.amazonaws.services.kms.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public enum MessageType {
    RAW("RAW"),
    DIGEST("DIGEST");

    private static final Map enumMap;
    private String value;

    static {
        MessageType messageType = RAW;
        MessageType messageType2 = DIGEST;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("RAW", messageType);
        hashMap.put("DIGEST", messageType2);
    }

    MessageType(String str) {
        this.value = str;
    }

    public static MessageType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map map = enumMap;
        if (map.containsKey(str)) {
            return (MessageType) map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }

    public String toString() {
        return this.value;
    }
}
