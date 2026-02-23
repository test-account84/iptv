package com.amazonaws.services.s3.model.analytics;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class AnalyticsPrefixPredicate extends AnalyticsFilterPredicate {
    private final String prefix;

    public AnalyticsPrefixPredicate(String str) {
        this.prefix = str;
    }

    public void accept(AnalyticsPredicateVisitor analyticsPredicateVisitor) {
        analyticsPredicateVisitor.visit(this);
    }

    public String getPrefix() {
        return this.prefix;
    }
}
