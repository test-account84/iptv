package com.amplifyframework.predictions.result;

import com.amplifyframework.util.Immutable;
import j$.util.Objects;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class IdentifyEntitiesResult implements IdentifyResult {
    private final List entities;

    private IdentifyEntitiesResult(List list) {
        this.entities = list;
    }

    public static IdentifyEntitiesResult fromEntityDetails(List list) {
        Objects.requireNonNull(list);
        return new IdentifyEntitiesResult(list);
    }

    public List getEntities() {
        return Immutable.of(this.entities);
    }
}
