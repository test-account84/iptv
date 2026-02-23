package com.amazonaws.services.s3.model.analytics;

import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class AnalyticsAndOperator extends AnalyticsNAryOperator {
    public AnalyticsAndOperator(List list) {
        super(list);
    }

    public void accept(AnalyticsPredicateVisitor analyticsPredicateVisitor) {
        analyticsPredicateVisitor.visit(this);
    }

    public /* bridge */ /* synthetic */ List getOperands() {
        return super.getOperands();
    }
}
