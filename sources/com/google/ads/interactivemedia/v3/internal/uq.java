package com.google.ads.interactivemedia.v3.internal;

import java.util.NoSuchElementException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class uq implements vg {
    private final long b;
    private final long c;
    private long d;

    public uq(long j, long j2) {
        this.b = j;
        this.c = j2;
        this.d = j - 1;
    }

    public final long c() {
        return this.d;
    }

    public final void d() {
        long j = this.d;
        if (j < this.b || j > this.c) {
            throw new NoSuchElementException();
        }
    }

    public final boolean e() {
        long j = this.d + 1;
        this.d = j;
        return j <= this.c;
    }
}
