package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public enum FeedbackValueType {
    Valid("Valid"),
    Invalid("Invalid");

    private static final Map enumMap;
    private String value;

    static {
        FeedbackValueType feedbackValueType = Valid;
        FeedbackValueType feedbackValueType2 = Invalid;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("Valid", feedbackValueType);
        hashMap.put("Invalid", feedbackValueType2);
    }

    FeedbackValueType(String str) {
        this.value = str;
    }

    public static FeedbackValueType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map map = enumMap;
        if (map.containsKey(str)) {
            return (FeedbackValueType) map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }

    public String toString() {
        return this.value;
    }
}
