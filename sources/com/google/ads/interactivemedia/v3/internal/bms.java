package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bms extends bkl {
    public final /* bridge */ /* synthetic */ Object read(boh bohVar) throws IOException {
        if (bohVar.r() == 9) {
            bohVar.m();
            return null;
        }
        String h = bohVar.h();
        if (h.length() == 1) {
            return Character.valueOf(h.charAt(0));
        }
        throw new bkf("Expecting character, got: " + h + "; at " + bohVar.f());
    }

    public final /* bridge */ /* synthetic */ void write(boj bojVar, Object obj) throws IOException {
        Character ch = (Character) obj;
        bojVar.l(ch == null ? null : ch.toString());
    }
}
