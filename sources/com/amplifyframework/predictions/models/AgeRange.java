package com.amplifyframework.predictions.models;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class AgeRange {
    private final int high;
    private final int low;

    public AgeRange(int i, int i2) {
        if (i2 < i) {
            throw new IllegalArgumentException("Low cannot be higher than High.");
        }
        this.low = i;
        this.high = i2;
    }

    public boolean contains(int i) {
        return i >= this.low && i <= this.high;
    }

    public int getHigh() {
        return this.high;
    }

    public int getLow() {
        return this.low;
    }
}
