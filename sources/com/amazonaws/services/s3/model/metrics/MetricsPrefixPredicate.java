package com.amazonaws.services.s3.model.metrics;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class MetricsPrefixPredicate extends MetricsFilterPredicate {
    private final String prefix;

    public MetricsPrefixPredicate(String str) {
        this.prefix = str;
    }

    public void accept(MetricsPredicateVisitor metricsPredicateVisitor) {
        metricsPredicateVisitor.visit(this);
    }

    public String getPrefix() {
        return this.prefix;
    }
}
