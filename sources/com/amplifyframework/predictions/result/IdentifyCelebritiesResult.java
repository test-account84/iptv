package com.amplifyframework.predictions.result;

import com.amplifyframework.util.Immutable;
import j$.util.Objects;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class IdentifyCelebritiesResult implements IdentifyResult {
    private final List celebrities;

    private IdentifyCelebritiesResult(List list) {
        this.celebrities = list;
    }

    public static IdentifyCelebritiesResult fromCelebrities(List list) {
        Objects.requireNonNull(list);
        return new IdentifyCelebritiesResult(list);
    }

    public List getCelebrities() {
        return Immutable.of(this.celebrities);
    }
}
