package com.amazonaws.services.s3.model.inventory;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public enum InventoryIncludedObjectVersions {
    All("All"),
    Current("Current");

    private final String name;

    InventoryIncludedObjectVersions(String str) {
        this.name = str;
    }

    public String toString() {
        return this.name;
    }
}
