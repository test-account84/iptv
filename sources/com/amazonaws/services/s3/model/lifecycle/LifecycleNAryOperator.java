package com.amazonaws.services.s3.model.lifecycle;

import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
abstract class LifecycleNAryOperator extends LifecycleFilterPredicate {
    private final List operands;

    public LifecycleNAryOperator(List list) {
        this.operands = list;
    }

    public List getOperands() {
        return this.operands;
    }
}
