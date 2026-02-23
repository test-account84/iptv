package com.google.ads.interactivemedia.v3.internal;

import java.io.EOFException;
import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zg implements aae {
    private final byte[] a = new byte[4096];

    public final /* synthetic */ int a(k kVar, int i, boolean z) {
        return fz.h(this, kVar, i, z);
    }

    public final void b(s sVar) {
    }

    public final /* synthetic */ void e(cj cjVar, int i) {
        fz.i(this, cjVar, i);
    }

    public final void f(long j, int i, int i2, int i3, aad aadVar) {
    }

    public final int h(k kVar, int i, boolean z) throws IOException {
        int a = kVar.a(this.a, 0, Math.min(4096, i));
        if (a != -1) {
            return a;
        }
        if (z) {
            return -1;
        }
        throw new EOFException();
    }

    public final void i(cj cjVar, int i) {
        cjVar.G(i);
    }
}
