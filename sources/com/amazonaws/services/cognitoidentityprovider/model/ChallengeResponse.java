package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public enum ChallengeResponse {
    Success("Success"),
    Failure("Failure");

    private static final Map enumMap;
    private String value;

    static {
        ChallengeResponse challengeResponse = Success;
        ChallengeResponse challengeResponse2 = Failure;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("Success", challengeResponse);
        hashMap.put("Failure", challengeResponse2);
    }

    ChallengeResponse(String str) {
        this.value = str;
    }

    public static ChallengeResponse fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map map = enumMap;
        if (map.containsKey(str)) {
            return (ChallengeResponse) map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }

    public String toString() {
        return this.value;
    }
}
