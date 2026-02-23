package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public enum AuthFlowType {
    USER_SRP_AUTH("USER_SRP_AUTH"),
    REFRESH_TOKEN_AUTH("REFRESH_TOKEN_AUTH"),
    REFRESH_TOKEN("REFRESH_TOKEN"),
    CUSTOM_AUTH("CUSTOM_AUTH"),
    ADMIN_NO_SRP_AUTH("ADMIN_NO_SRP_AUTH"),
    USER_PASSWORD_AUTH("USER_PASSWORD_AUTH"),
    ADMIN_USER_PASSWORD_AUTH("ADMIN_USER_PASSWORD_AUTH");

    private static final Map enumMap;
    private String value;

    static {
        AuthFlowType authFlowType = USER_SRP_AUTH;
        AuthFlowType authFlowType2 = REFRESH_TOKEN_AUTH;
        AuthFlowType authFlowType3 = REFRESH_TOKEN;
        AuthFlowType authFlowType4 = CUSTOM_AUTH;
        AuthFlowType authFlowType5 = ADMIN_NO_SRP_AUTH;
        AuthFlowType authFlowType6 = USER_PASSWORD_AUTH;
        AuthFlowType authFlowType7 = ADMIN_USER_PASSWORD_AUTH;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("USER_SRP_AUTH", authFlowType);
        hashMap.put("REFRESH_TOKEN_AUTH", authFlowType2);
        hashMap.put("REFRESH_TOKEN", authFlowType3);
        hashMap.put("CUSTOM_AUTH", authFlowType4);
        hashMap.put("ADMIN_NO_SRP_AUTH", authFlowType5);
        hashMap.put("USER_PASSWORD_AUTH", authFlowType6);
        hashMap.put("ADMIN_USER_PASSWORD_AUTH", authFlowType7);
    }

    AuthFlowType(String str) {
        this.value = str;
    }

    public static AuthFlowType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map map = enumMap;
        if (map.containsKey(str)) {
            return (AuthFlowType) map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }

    public String toString() {
        return this.value;
    }
}
