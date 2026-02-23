package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bjs extends bkl {
    private bkl a;

    public final void a(bkl bklVar) {
        if (this.a != null) {
            throw new AssertionError();
        }
        this.a = bklVar;
    }

    public final Object read(boh bohVar) throws IOException {
        bkl bklVar = this.a;
        if (bklVar != null) {
            return bklVar.read(bohVar);
        }
        throw new IllegalStateException();
    }

    public final void write(boj bojVar, Object obj) throws IOException {
        bkl bklVar = this.a;
        if (bklVar == null) {
            throw new IllegalStateException();
        }
        bklVar.write(bojVar, obj);
    }
}
