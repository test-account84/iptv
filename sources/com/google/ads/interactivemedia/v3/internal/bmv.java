package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.math.BigInteger;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bmv extends bkl {
    public final /* bridge */ /* synthetic */ Object read(boh bohVar) throws IOException {
        if (bohVar.r() == 9) {
            bohVar.m();
            return null;
        }
        String h = bohVar.h();
        try {
            return new BigInteger(h);
        } catch (NumberFormatException e) {
            throw new bkf("Failed parsing '" + h + "' as BigInteger; at path " + bohVar.f(), e);
        }
    }

    public final /* synthetic */ void write(boj bojVar, Object obj) throws IOException {
        bojVar.k((BigInteger) obj);
    }
}
