package com.amazonaws.services.s3.model.metrics;

import com.amazonaws.services.s3.model.Tag;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class MetricsTagPredicate extends MetricsFilterPredicate {
    private final Tag tag;

    public MetricsTagPredicate(Tag tag) {
        this.tag = tag;
    }

    public void accept(MetricsPredicateVisitor metricsPredicateVisitor) {
        metricsPredicateVisitor.visit(this);
    }

    public Tag getTag() {
        return this.tag;
    }
}
