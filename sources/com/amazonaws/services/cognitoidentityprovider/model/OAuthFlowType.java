package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public enum OAuthFlowType {
    Code("code"),
    Implicit("implicit"),
    Client_credentials("client_credentials");

    private static final Map enumMap;
    private String value;

    static {
        OAuthFlowType oAuthFlowType = Code;
        OAuthFlowType oAuthFlowType2 = Implicit;
        OAuthFlowType oAuthFlowType3 = Client_credentials;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("code", oAuthFlowType);
        hashMap.put("implicit", oAuthFlowType2);
        hashMap.put("client_credentials", oAuthFlowType3);
    }

    OAuthFlowType(String str) {
        this.value = str;
    }

    public static OAuthFlowType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map map = enumMap;
        if (map.containsKey(str)) {
            return (OAuthFlowType) map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }

    public String toString() {
        return this.value;
    }
}
