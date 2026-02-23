package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bkk extends bkl {
    final /* synthetic */ bkl a;

    public bkk(bkl bklVar) {
        this.a = bklVar;
    }

    public final Object read(boh bohVar) throws IOException {
        if (bohVar.r() != 9) {
            return this.a.read(bohVar);
        }
        bohVar.m();
        return null;
    }

    public final void write(boj bojVar, Object obj) throws IOException {
        if (obj == null) {
            bojVar.g();
        } else {
            this.a.write(bojVar, obj);
        }
    }
}
