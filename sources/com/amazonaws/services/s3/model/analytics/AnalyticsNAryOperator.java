package com.amazonaws.services.s3.model.analytics;

import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
abstract class AnalyticsNAryOperator extends AnalyticsFilterPredicate {
    private final List operands;

    public AnalyticsNAryOperator(List list) {
        this.operands = list;
    }

    public List getOperands() {
        return this.operands;
    }
}
