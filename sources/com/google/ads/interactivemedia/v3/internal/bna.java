package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.net.URL;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bna extends bkl {
    public final /* bridge */ /* synthetic */ Object read(boh bohVar) throws IOException {
        if (bohVar.r() == 9) {
            bohVar.m();
            return null;
        }
        String h = bohVar.h();
        if ("null".equals(h)) {
            return null;
        }
        return new URL(h);
    }

    public final /* bridge */ /* synthetic */ void write(boj bojVar, Object obj) throws IOException {
        URL url = (URL) obj;
        bojVar.l(url == null ? null : url.toExternalForm());
    }
}
