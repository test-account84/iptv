package com.amazonaws.services.s3.model.inventory;

import java.io.Serializable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class InventoryFilterPredicate implements Serializable {
    public abstract void accept(InventoryPredicateVisitor inventoryPredicateVisitor);
}
