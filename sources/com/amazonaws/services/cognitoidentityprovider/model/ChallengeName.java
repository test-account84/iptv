package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public enum ChallengeName {
    Password("Password"),
    Mfa("Mfa");

    private static final Map enumMap;
    private String value;

    static {
        ChallengeName challengeName = Password;
        ChallengeName challengeName2 = Mfa;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("Password", challengeName);
        hashMap.put("Mfa", challengeName2);
    }

    ChallengeName(String str) {
        this.value = str;
    }

    public static ChallengeName fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map map = enumMap;
        if (map.containsKey(str)) {
            return (ChallengeName) map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }

    public String toString() {
        return this.value;
    }
}
