package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bmr extends bkl {
    public final /* bridge */ /* synthetic */ Object read(boh bohVar) throws IOException {
        if (bohVar.r() == 9) {
            bohVar.m();
            return null;
        }
        try {
            return Long.valueOf(bohVar.c());
        } catch (NumberFormatException e) {
            throw new bkf((Throwable) e);
        }
    }

    public final /* bridge */ /* synthetic */ void write(boj bojVar, Object obj) throws IOException {
        Number number = (Number) obj;
        if (number == null) {
            bojVar.g();
        } else {
            bojVar.i(number.longValue());
        }
    }
}
