package com.amazonaws.services.s3.model.inventory;

import java.io.Serializable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class InventorySchedule implements Serializable {
    private String frequency;

    public String getFrequency() {
        return this.frequency;
    }

    public void setFrequency(InventoryFrequency inventoryFrequency) {
        setFrequency(inventoryFrequency == null ? null : inventoryFrequency.toString());
    }

    public InventorySchedule withFrequency(InventoryFrequency inventoryFrequency) {
        setFrequency(inventoryFrequency);
        return this;
    }

    public void setFrequency(String str) {
        this.frequency = str;
    }

    public InventorySchedule withFrequency(String str) {
        setFrequency(str);
        return this;
    }
}
