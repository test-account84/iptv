package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class us implements aae {
    public s a;
    private final int b;
    private final int c;
    private final s d;
    private final zg e = new zg();
    private aae f;
    private long g;

    public us(int i, int i2, s sVar) {
        this.b = i;
        this.c = i2;
        this.d = sVar;
    }

    public final /* synthetic */ int a(k kVar, int i, boolean z) {
        return fz.h(this, kVar, i, z);
    }

    public final void b(s sVar) {
        s sVar2 = this.d;
        if (sVar2 != null) {
            sVar = sVar.d(sVar2);
        }
        this.a = sVar;
        aae aaeVar = this.f;
        int i = cq.a;
        aaeVar.b(sVar);
    }

    public final void c(zo zoVar, long j) {
        if (zoVar == null) {
            this.f = this.e;
            return;
        }
        this.g = j;
        aae c = zoVar.c(this.c);
        this.f = c;
        s sVar = this.a;
        if (sVar != null) {
            c.b(sVar);
        }
    }

    public final /* synthetic */ void e(cj cjVar, int i) {
        fz.i(this, cjVar, i);
    }

    public final void f(long j, int i, int i2, int i3, aad aadVar) {
        long j2 = this.g;
        if (j2 != -9223372036854775807L && j >= j2) {
            this.f = this.e;
        }
        aae aaeVar = this.f;
        int i4 = cq.a;
        aaeVar.f(j, i, i2, i3, aadVar);
    }

    public final int h(k kVar, int i, boolean z) throws IOException {
        aae aaeVar = this.f;
        int i2 = cq.a;
        return aaeVar.a(kVar, i, z);
    }

    public final void i(cj cjVar, int i) {
        aae aaeVar = this.f;
        int i2 = cq.a;
        aaeVar.e(cjVar, i);
    }
}
