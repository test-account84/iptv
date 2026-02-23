package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.util.Locale;
import java.util.StringTokenizer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bng extends bkl {
    public final /* bridge */ /* synthetic */ Object read(boh bohVar) throws IOException {
        if (bohVar.r() == 9) {
            bohVar.m();
            return null;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(bohVar.h(), "_");
        String nextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
        String nextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
        String nextToken3 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
        return (nextToken2 == null && nextToken3 == null) ? new Locale(nextToken) : nextToken3 == null ? new Locale(nextToken, nextToken2) : new Locale(nextToken, nextToken2, nextToken3);
    }

    public final /* bridge */ /* synthetic */ void write(boj bojVar, Object obj) throws IOException {
        Locale locale = (Locale) obj;
        bojVar.l(locale == null ? null : locale.toString());
    }
}
