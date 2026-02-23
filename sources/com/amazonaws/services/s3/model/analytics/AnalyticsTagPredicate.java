package com.amazonaws.services.s3.model.analytics;

import com.amazonaws.services.s3.model.Tag;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class AnalyticsTagPredicate extends AnalyticsFilterPredicate {
    private final Tag tag;

    public AnalyticsTagPredicate(Tag tag) {
        this.tag = tag;
    }

    public void accept(AnalyticsPredicateVisitor analyticsPredicateVisitor) {
        analyticsPredicateVisitor.visit(this);
    }

    public Tag getTag() {
        return this.tag;
    }
}
