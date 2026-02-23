package com.amazonaws.services.s3.model.inventory;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public enum InventoryFormat {
    CSV("CSV");

    private final String format;

    InventoryFormat(String str) {
        this.format = str;
    }

    public String toString() {
        return this.format;
    }
}
