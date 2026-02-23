package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bnp extends bkl {
    public final /* bridge */ /* synthetic */ Object read(boh bohVar) throws IOException {
        if (bohVar.r() == 9) {
            bohVar.m();
            return null;
        }
        try {
            int b = bohVar.b();
            if (b <= 255 && b >= -128) {
                return Byte.valueOf((byte) b);
            }
            throw new bkf("Lossy conversion from " + b + " to byte; at path " + bohVar.f());
        } catch (NumberFormatException e) {
            throw new bkf((Throwable) e);
        }
    }

    public final /* bridge */ /* synthetic */ void write(boj bojVar, Object obj) throws IOException {
        if (((Number) obj) == null) {
            bojVar.g();
        } else {
            bojVar.i(r4.byteValue());
        }
    }
}
