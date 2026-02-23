package com.amazonaws.services.s3.model.lifecycle;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class LifecyclePrefixPredicate extends LifecycleFilterPredicate {
    private final String prefix;

    public LifecyclePrefixPredicate(String str) {
        this.prefix = str;
    }

    public void accept(LifecyclePredicateVisitor lifecyclePredicateVisitor) {
        lifecyclePredicateVisitor.visit(this);
    }

    public String getPrefix() {
        return this.prefix;
    }
}
