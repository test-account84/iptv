package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bjo extends bkl {
    public final /* bridge */ /* synthetic */ Object read(boh bohVar) throws IOException {
        if (bohVar.r() != 9) {
            return Float.valueOf((float) bohVar.a());
        }
        bohVar.m();
        return null;
    }

    public final /* bridge */ /* synthetic */ void write(boj bojVar, Object obj) throws IOException {
        Float f = (Number) obj;
        if (f == null) {
            bojVar.g();
            return;
        }
        float floatValue = f.floatValue();
        bjt.h(floatValue);
        if (!(f instanceof Float)) {
            f = Float.valueOf(floatValue);
        }
        bojVar.k(f);
    }
}
