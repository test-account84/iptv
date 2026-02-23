package com.amplifyframework.util;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class Range {
    private final Comparable high;
    private final Comparable low;

    public Range(Comparable comparable, Comparable comparable2) throws IllegalArgumentException {
        if (comparable.compareTo(comparable2) > 0) {
            throw new IllegalArgumentException("Low value should be lower than high");
        }
        this.low = comparable;
        this.high = comparable2;
    }

    public boolean contains(Comparable comparable) {
        return comparable.compareTo(this.low) >= 0 && comparable.compareTo(this.high) <= 0;
    }
}
