package com.amazonaws.services.cognitoidentity.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public enum RoleMappingType {
    Token("Token"),
    Rules("Rules");

    private static final Map enumMap;
    private String value;

    static {
        RoleMappingType roleMappingType = Token;
        RoleMappingType roleMappingType2 = Rules;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("Token", roleMappingType);
        hashMap.put("Rules", roleMappingType2);
    }

    RoleMappingType(String str) {
        this.value = str;
    }

    public static RoleMappingType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map map = enumMap;
        if (map.containsKey(str)) {
            return (RoleMappingType) map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }

    public String toString() {
        return this.value;
    }
}
