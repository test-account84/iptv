package com.amazonaws.services.s3.model.lifecycle;

import java.io.Serializable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class LifecycleFilter implements Serializable {
    private LifecycleFilterPredicate predicate;

    public LifecycleFilter() {
    }

    public LifecycleFilterPredicate getPredicate() {
        return this.predicate;
    }

    public void setPredicate(LifecycleFilterPredicate lifecycleFilterPredicate) {
        this.predicate = lifecycleFilterPredicate;
    }

    public LifecycleFilter withPredicate(LifecycleFilterPredicate lifecycleFilterPredicate) {
        setPredicate(lifecycleFilterPredicate);
        return this;
    }

    public LifecycleFilter(LifecycleFilterPredicate lifecycleFilterPredicate) {
        this.predicate = lifecycleFilterPredicate;
    }
}
