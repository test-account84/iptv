package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class lf implements ww {
    final /* synthetic */ lh a;
    private final /* synthetic */ int b;

    public /* synthetic */ lf(lh lhVar, int i) {
        this.b = i;
        this.a = lhVar;
    }

    public final /* synthetic */ void bj(wy wyVar, long j, long j2) {
        if (this.b != 0) {
            this.a.l((xf) wyVar, j, j2);
        } else {
            this.a.m((xf) wyVar, j, j2);
        }
    }

    public final /* synthetic */ wv bk(wy wyVar, long j, long j2, IOException iOException, int i) {
        int i2 = this.b;
        xf xfVar = (xf) wyVar;
        lh lhVar = this.a;
        return i2 != 0 ? lhVar.r(xfVar, j, j2, iOException, i) : lhVar.s(xfVar, j, j2, iOException);
    }

    public final /* synthetic */ void bn(wy wyVar, long j, long j2, boolean z) {
        if (this.b != 0) {
            this.a.k((xf) wyVar, j, j2);
        } else {
            this.a.k((xf) wyVar, j, j2);
        }
    }
}
