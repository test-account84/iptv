package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bnb extends bkl {
    public static final URI a(boh bohVar) throws IOException {
        if (bohVar.r() == 9) {
            bohVar.m();
            return null;
        }
        try {
            String h = bohVar.h();
            if ("null".equals(h)) {
                return null;
            }
            return new URI(h);
        } catch (URISyntaxException e) {
            throw new bjz((Throwable) e);
        }
    }

    public final /* bridge */ /* synthetic */ Object read(boh bohVar) throws IOException {
        return a(bohVar);
    }

    public final /* bridge */ /* synthetic */ void write(boj bojVar, Object obj) throws IOException {
        URI uri = (URI) obj;
        bojVar.l(uri == null ? null : uri.toASCIIString());
    }
}
