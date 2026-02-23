package com.amazonaws.services.cognitoidentity.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public enum ErrorCode {
    AccessDenied("AccessDenied"),
    InternalServerError("InternalServerError");

    private static final Map enumMap;
    private String value;

    static {
        ErrorCode errorCode = AccessDenied;
        ErrorCode errorCode2 = InternalServerError;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("AccessDenied", errorCode);
        hashMap.put("InternalServerError", errorCode2);
    }

    ErrorCode(String str) {
        this.value = str;
    }

    public static ErrorCode fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map map = enumMap;
        if (map.containsKey(str)) {
            return (ErrorCode) map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }

    public String toString() {
        return this.value;
    }
}
