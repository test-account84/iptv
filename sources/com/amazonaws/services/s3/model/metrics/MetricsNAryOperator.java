package com.amazonaws.services.s3.model.metrics;

import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
abstract class MetricsNAryOperator extends MetricsFilterPredicate {
    private final List operands;

    public MetricsNAryOperator(List list) {
        this.operands = list;
    }

    public List getOperands() {
        return this.operands;
    }
}
