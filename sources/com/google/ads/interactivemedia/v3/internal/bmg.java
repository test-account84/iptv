package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bmg extends bkl {
    private static final bkm a = b(bki.LAZILY_PARSED_NUMBER);
    private final bkj b;

    private bmg(bkj bkjVar) {
        this.b = bkjVar;
    }

    public static bkm a(bkj bkjVar) {
        return bkjVar == bki.LAZILY_PARSED_NUMBER ? a : b(bkjVar);
    }

    private static bkm b(bkj bkjVar) {
        return new bmh(new bmg(bkjVar), 1);
    }

    public final /* bridge */ /* synthetic */ Object read(boh bohVar) throws IOException {
        int r = bohVar.r();
        int i = r - 1;
        if (i == 5 || i == 6) {
            return this.b.a(bohVar);
        }
        if (i == 8) {
            bohVar.m();
            return null;
        }
        throw new bkf("Expecting number, got: " + boi.a(r) + "; at path " + bohVar.e());
    }

    public final /* synthetic */ void write(boj bojVar, Object obj) throws IOException {
        bojVar.k((Number) obj);
    }
}
