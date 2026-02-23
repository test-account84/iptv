package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public enum UserImportJobStatusType {
    Created("Created"),
    Pending("Pending"),
    InProgress("InProgress"),
    Stopping("Stopping"),
    Expired("Expired"),
    Stopped("Stopped"),
    Failed("Failed"),
    Succeeded("Succeeded");

    private static final Map enumMap;
    private String value;

    static {
        UserImportJobStatusType userImportJobStatusType = Created;
        UserImportJobStatusType userImportJobStatusType2 = Pending;
        UserImportJobStatusType userImportJobStatusType3 = InProgress;
        UserImportJobStatusType userImportJobStatusType4 = Stopping;
        UserImportJobStatusType userImportJobStatusType5 = Expired;
        UserImportJobStatusType userImportJobStatusType6 = Stopped;
        UserImportJobStatusType userImportJobStatusType7 = Failed;
        UserImportJobStatusType userImportJobStatusType8 = Succeeded;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("Created", userImportJobStatusType);
        hashMap.put("Pending", userImportJobStatusType2);
        hashMap.put("InProgress", userImportJobStatusType3);
        hashMap.put("Stopping", userImportJobStatusType4);
        hashMap.put("Expired", userImportJobStatusType5);
        hashMap.put("Stopped", userImportJobStatusType6);
        hashMap.put("Failed", userImportJobStatusType7);
        hashMap.put("Succeeded", userImportJobStatusType8);
    }

    UserImportJobStatusType(String str) {
        this.value = str;
    }

    public static UserImportJobStatusType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map map = enumMap;
        if (map.containsKey(str)) {
            return (UserImportJobStatusType) map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }

    public String toString() {
        return this.value;
    }
}
