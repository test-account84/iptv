package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.util.ConcurrentModificationException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class xk implements ww {
    private final xj a;

    public xk(xj xjVar) {
        this.a = xjVar;
    }

    public final void bj(wy wyVar, long j, long j2) {
        if (xm.h()) {
            this.a.b();
        } else {
            this.a.a(new IOException(new ConcurrentModificationException()));
        }
    }

    public final wv bk(wy wyVar, long j, long j2, IOException iOException, int i) {
        this.a.a(iOException);
        return xc.b;
    }

    public final void bn(wy wyVar, long j, long j2, boolean z) {
    }
}
