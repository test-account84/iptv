package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public enum ChallengeNameType {
    SMS_MFA("SMS_MFA"),
    SOFTWARE_TOKEN_MFA("SOFTWARE_TOKEN_MFA"),
    SELECT_MFA_TYPE("SELECT_MFA_TYPE"),
    MFA_SETUP("MFA_SETUP"),
    PASSWORD_VERIFIER("PASSWORD_VERIFIER"),
    CUSTOM_CHALLENGE("CUSTOM_CHALLENGE"),
    DEVICE_SRP_AUTH("DEVICE_SRP_AUTH"),
    DEVICE_PASSWORD_VERIFIER("DEVICE_PASSWORD_VERIFIER"),
    ADMIN_NO_SRP_AUTH("ADMIN_NO_SRP_AUTH"),
    NEW_PASSWORD_REQUIRED("NEW_PASSWORD_REQUIRED");

    private static final Map enumMap;
    private String value;

    static {
        ChallengeNameType challengeNameType = SMS_MFA;
        ChallengeNameType challengeNameType2 = SOFTWARE_TOKEN_MFA;
        ChallengeNameType challengeNameType3 = SELECT_MFA_TYPE;
        ChallengeNameType challengeNameType4 = MFA_SETUP;
        ChallengeNameType challengeNameType5 = PASSWORD_VERIFIER;
        ChallengeNameType challengeNameType6 = CUSTOM_CHALLENGE;
        ChallengeNameType challengeNameType7 = DEVICE_SRP_AUTH;
        ChallengeNameType challengeNameType8 = DEVICE_PASSWORD_VERIFIER;
        ChallengeNameType challengeNameType9 = ADMIN_NO_SRP_AUTH;
        ChallengeNameType challengeNameType10 = NEW_PASSWORD_REQUIRED;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("SMS_MFA", challengeNameType);
        hashMap.put("SOFTWARE_TOKEN_MFA", challengeNameType2);
        hashMap.put("SELECT_MFA_TYPE", challengeNameType3);
        hashMap.put("MFA_SETUP", challengeNameType4);
        hashMap.put("PASSWORD_VERIFIER", challengeNameType5);
        hashMap.put("CUSTOM_CHALLENGE", challengeNameType6);
        hashMap.put("DEVICE_SRP_AUTH", challengeNameType7);
        hashMap.put("DEVICE_PASSWORD_VERIFIER", challengeNameType8);
        hashMap.put("ADMIN_NO_SRP_AUTH", challengeNameType9);
        hashMap.put("NEW_PASSWORD_REQUIRED", challengeNameType10);
    }

    ChallengeNameType(String str) {
        this.value = str;
    }

    public static ChallengeNameType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map map = enumMap;
        if (map.containsKey(str)) {
            return (ChallengeNameType) map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }

    public String toString() {
        return this.value;
    }
}
