package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class up extends ve {
    public final long a;
    public final long b;
    private int[] c;
    private zo d;

    public up(cy cyVar, dc dcVar, s sVar, int i, long j, long j2, long j3, long j4, long j5) {
        super(cyVar, dcVar, sVar, i, j, j2, j5);
        this.a = j3;
        this.b = j4;
    }

    public final int a(int i) {
        return ((int[]) af.t(this.c))[i];
    }

    public final zo c() {
        zo zoVar = this.d;
        af.t(zoVar);
        return zoVar;
    }

    public final void d(zo zoVar) {
        this.d = zoVar;
        this.c = zoVar.b();
    }
}
