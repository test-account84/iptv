package com.amazonaws.services.s3.model.inventory;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class InventoryPrefixPredicate extends InventoryFilterPredicate {
    private final String prefix;

    public InventoryPrefixPredicate(String str) {
        this.prefix = str;
    }

    public void accept(InventoryPredicateVisitor inventoryPredicateVisitor) {
        inventoryPredicateVisitor.visit(this);
    }

    public String getPrefix() {
        return this.prefix;
    }
}
