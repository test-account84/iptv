package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public enum CustomEmailSenderLambdaVersionType {
    V1_0("V1_0");

    private static final Map enumMap;
    private String value;

    static {
        CustomEmailSenderLambdaVersionType customEmailSenderLambdaVersionType = V1_0;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("V1_0", customEmailSenderLambdaVersionType);
    }

    CustomEmailSenderLambdaVersionType(String str) {
        this.value = str;
    }

    public static CustomEmailSenderLambdaVersionType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map map = enumMap;
        if (map.containsKey(str)) {
            return (CustomEmailSenderLambdaVersionType) map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }

    public String toString() {
        return this.value;
    }
}
