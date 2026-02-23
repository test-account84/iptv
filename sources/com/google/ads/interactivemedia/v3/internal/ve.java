package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class ve extends uu {
    public final long o;

    public ve(cy cyVar, dc dcVar, s sVar, int i, long j, long j2, long j3) {
        super(cyVar, dcVar, 1, sVar, i, j, j2);
        af.s(sVar);
        this.o = j3;
    }

    public abstract boolean g();

    public long s() {
        long j = this.o;
        if (j != -1) {
            return j + 1;
        }
        return -1L;
    }
}
