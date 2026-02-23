package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public enum DomainStatusType {
    CREATING("CREATING"),
    DELETING("DELETING"),
    UPDATING("UPDATING"),
    ACTIVE("ACTIVE"),
    FAILED("FAILED");

    private static final Map enumMap;
    private String value;

    static {
        DomainStatusType domainStatusType = CREATING;
        DomainStatusType domainStatusType2 = DELETING;
        DomainStatusType domainStatusType3 = UPDATING;
        DomainStatusType domainStatusType4 = ACTIVE;
        DomainStatusType domainStatusType5 = FAILED;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("CREATING", domainStatusType);
        hashMap.put("DELETING", domainStatusType2);
        hashMap.put("UPDATING", domainStatusType3);
        hashMap.put("ACTIVE", domainStatusType4);
        hashMap.put("FAILED", domainStatusType5);
    }

    DomainStatusType(String str) {
        this.value = str;
    }

    public static DomainStatusType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map map = enumMap;
        if (map.containsKey(str)) {
            return (DomainStatusType) map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }

    public String toString() {
        return this.value;
    }
}
