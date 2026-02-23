package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bjn extends bkl {
    public final /* bridge */ /* synthetic */ Object read(boh bohVar) throws IOException {
        if (bohVar.r() != 9) {
            return Double.valueOf(bohVar.a());
        }
        bohVar.m();
        return null;
    }

    public final /* bridge */ /* synthetic */ void write(boj bojVar, Object obj) throws IOException {
        Number number = (Number) obj;
        if (number == null) {
            bojVar.g();
            return;
        }
        double doubleValue = number.doubleValue();
        bjt.h(doubleValue);
        bojVar.h(doubleValue);
    }
}
