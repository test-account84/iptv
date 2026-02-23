package com.google.ads.interactivemedia.v3.internal;

import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class mc extends me implements li {
    final mf a;

    public mc(s sVar, List list, mf mfVar, List list2, List list3, List list4) {
        super(sVar, list, mfVar, list2);
        this.a = mfVar;
    }

    public final long a(long j, long j2) {
        return this.a.a(j, j2);
    }

    public final long b(long j, long j2) {
        return this.a.d(j, j2);
    }

    public final long c(long j, long j2) {
        return this.a.b(j, j2);
    }

    public final long d() {
        return this.a.a;
    }

    public final long e(long j, long j2) {
        mf mfVar = this.a;
        if (mfVar.c != null) {
            return -9223372036854775807L;
        }
        long b = mfVar.b(j, j2) + mfVar.a(j, j2);
        return (mfVar.f(b) + mfVar.d(b, j)) - mfVar.d;
    }

    public final long f(long j) {
        return this.a.c(j);
    }

    public final long g(long j, long j2) {
        return this.a.e(j, j2);
    }

    public final long h(long j) {
        return this.a.f(j);
    }

    public final mb i(long j) {
        return this.a.g(this, j);
    }

    public final boolean j() {
        return this.a.h();
    }

    public final li k() {
        return this;
    }

    public final mb l() {
        return null;
    }

    public final void m() {
    }
}
