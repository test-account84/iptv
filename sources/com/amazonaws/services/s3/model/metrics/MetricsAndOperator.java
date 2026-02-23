package com.amazonaws.services.s3.model.metrics;

import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class MetricsAndOperator extends MetricsNAryOperator {
    public MetricsAndOperator(List list) {
        super(list);
    }

    public void accept(MetricsPredicateVisitor metricsPredicateVisitor) {
        metricsPredicateVisitor.visit(this);
    }

    public /* bridge */ /* synthetic */ List getOperands() {
        return super.getOperands();
    }
}
