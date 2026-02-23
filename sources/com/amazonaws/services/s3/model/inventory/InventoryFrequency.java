package com.amazonaws.services.s3.model.inventory;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public enum InventoryFrequency {
    Daily("Daily"),
    Weekly("Weekly");

    private final String frequency;

    InventoryFrequency(String str) {
        this.frequency = str;
    }

    public String toString() {
        return this.frequency;
    }
}
