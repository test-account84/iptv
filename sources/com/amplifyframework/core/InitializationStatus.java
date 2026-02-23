package com.amplifyframework.core;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public enum InitializationStatus {
    SUCCEEDED,
    FAILED;

    public static InitializationStatus fromString(String str) {
        for (InitializationStatus initializationStatus : values()) {
            if (initializationStatus.toString().equals(str)) {
                return initializationStatus;
            }
        }
        throw new IllegalArgumentException("Unknown status = " + str);
    }

    public String toString() {
        return name();
    }
}
