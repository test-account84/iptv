package com.amazonaws.services.s3.model;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public enum StorageClass {
    Standard("STANDARD"),
    ReducedRedundancy("REDUCED_REDUNDANCY"),
    Glacier("GLACIER"),
    StandardInfrequentAccess("STANDARD_IA"),
    OneZoneInfrequentAccess("ONEZONE_IA"),
    IntelligentTiering("INTELLIGENT_TIERING");

    private final String storageClassId;

    StorageClass(String str) {
        this.storageClassId = str;
    }

    public static StorageClass fromValue(String str) throws IllegalArgumentException {
        for (StorageClass storageClass : values()) {
            if (storageClass.toString().equals(str)) {
                return storageClass;
            }
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }

    public String toString() {
        return this.storageClassId;
    }
}
