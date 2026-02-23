package com.amazonaws.services.kms.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public enum KeyState {
    Creating("Creating"),
    Enabled("Enabled"),
    Disabled("Disabled"),
    PendingDeletion("PendingDeletion"),
    PendingImport("PendingImport"),
    PendingReplicaDeletion("PendingReplicaDeletion"),
    Unavailable("Unavailable"),
    Updating("Updating");

    private static final Map enumMap;
    private String value;

    static {
        KeyState keyState = Creating;
        KeyState keyState2 = Enabled;
        KeyState keyState3 = Disabled;
        KeyState keyState4 = PendingDeletion;
        KeyState keyState5 = PendingImport;
        KeyState keyState6 = PendingReplicaDeletion;
        KeyState keyState7 = Unavailable;
        KeyState keyState8 = Updating;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("Creating", keyState);
        hashMap.put("Enabled", keyState2);
        hashMap.put("Disabled", keyState3);
        hashMap.put("PendingDeletion", keyState4);
        hashMap.put("PendingImport", keyState5);
        hashMap.put("PendingReplicaDeletion", keyState6);
        hashMap.put("Unavailable", keyState7);
        hashMap.put("Updating", keyState8);
    }

    KeyState(String str) {
        this.value = str;
    }

    public static KeyState fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map map = enumMap;
        if (map.containsKey(str)) {
            return (KeyState) map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }

    public String toString() {
        return this.value;
    }
}
