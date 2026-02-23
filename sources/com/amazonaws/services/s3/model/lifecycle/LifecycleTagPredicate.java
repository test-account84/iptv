package com.amazonaws.services.s3.model.lifecycle;

import com.amazonaws.services.s3.model.Tag;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class LifecycleTagPredicate extends LifecycleFilterPredicate {
    private final Tag tag;

    public LifecycleTagPredicate(Tag tag) {
        this.tag = tag;
    }

    public void accept(LifecyclePredicateVisitor lifecyclePredicateVisitor) {
        lifecyclePredicateVisitor.visit(this);
    }

    public Tag getTag() {
        return this.tag;
    }
}
