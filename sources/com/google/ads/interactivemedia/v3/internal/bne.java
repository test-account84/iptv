package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.util.Currency;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bne extends bkl {
    public final /* bridge */ /* synthetic */ Object read(boh bohVar) throws IOException {
        String h = bohVar.h();
        try {
            return Currency.getInstance(h);
        } catch (IllegalArgumentException e) {
            throw new bkf("Failed parsing '" + h + "' as Currency; at path " + bohVar.f(), e);
        }
    }

    public final /* bridge */ /* synthetic */ void write(boj bojVar, Object obj) throws IOException {
        bojVar.l(((Currency) obj).getCurrencyCode());
    }
}
