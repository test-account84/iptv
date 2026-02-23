package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public enum EventResponseType {
    Pass("Pass"),
    Fail("Fail"),
    InProgress("InProgress");

    private static final Map enumMap;
    private String value;

    static {
        EventResponseType eventResponseType = Pass;
        EventResponseType eventResponseType2 = Fail;
        EventResponseType eventResponseType3 = InProgress;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("Pass", eventResponseType);
        hashMap.put("Fail", eventResponseType2);
        hashMap.put("InProgress", eventResponseType3);
    }

    EventResponseType(String str) {
        this.value = str;
    }

    public static EventResponseType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map map = enumMap;
        if (map.containsKey(str)) {
            return (EventResponseType) map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }

    public String toString() {
        return this.value;
    }
}
