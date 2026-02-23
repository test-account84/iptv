package com.amplifyframework.predictions.result;

import com.amplifyframework.util.Immutable;
import j$.util.Objects;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class IdentifyEntityMatchesResult implements IdentifyResult {
    private final List entityMatches;

    private IdentifyEntityMatchesResult(List list) {
        this.entityMatches = list;
    }

    public static IdentifyEntityMatchesResult fromEntityMatches(List list) {
        Objects.requireNonNull(list);
        return new IdentifyEntityMatchesResult(list);
    }

    public List getEntityMatches() {
        return Immutable.of(this.entityMatches);
    }
}
