package com.amazonaws.services.s3.model.analytics;

import java.io.Serializable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class AnalyticsFilterPredicate implements Serializable {
    public abstract void accept(AnalyticsPredicateVisitor analyticsPredicateVisitor);
}
