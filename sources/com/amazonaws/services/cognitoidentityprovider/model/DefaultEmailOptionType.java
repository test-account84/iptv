package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public enum DefaultEmailOptionType {
    CONFIRM_WITH_LINK("CONFIRM_WITH_LINK"),
    CONFIRM_WITH_CODE("CONFIRM_WITH_CODE");

    private static final Map enumMap;
    private String value;

    static {
        DefaultEmailOptionType defaultEmailOptionType = CONFIRM_WITH_LINK;
        DefaultEmailOptionType defaultEmailOptionType2 = CONFIRM_WITH_CODE;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("CONFIRM_WITH_LINK", defaultEmailOptionType);
        hashMap.put("CONFIRM_WITH_CODE", defaultEmailOptionType2);
    }

    DefaultEmailOptionType(String str) {
        this.value = str;
    }

    public static DefaultEmailOptionType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map map = enumMap;
        if (map.containsKey(str)) {
            return (DefaultEmailOptionType) map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }

    public String toString() {
        return this.value;
    }
}
