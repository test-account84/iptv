package com.amazonaws.services.s3.model.lifecycle;

import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class LifecycleAndOperator extends LifecycleNAryOperator {
    public LifecycleAndOperator(List list) {
        super(list);
    }

    public void accept(LifecyclePredicateVisitor lifecyclePredicateVisitor) {
        lifecyclePredicateVisitor.visit(this);
    }

    public /* bridge */ /* synthetic */ List getOperands() {
        return super.getOperands();
    }
}
