package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bnq extends bkl {
    public final /* bridge */ /* synthetic */ Object read(boh bohVar) throws IOException {
        if (bohVar.r() == 9) {
            bohVar.m();
            return null;
        }
        try {
            int b = bohVar.b();
            if (b <= 65535 && b >= -32768) {
                return Short.valueOf((short) b);
            }
            throw new bkf("Lossy conversion from " + b + " to short; at path " + bohVar.f());
        } catch (NumberFormatException e) {
            throw new bkf((Throwable) e);
        }
    }

    public final /* bridge */ /* synthetic */ void write(boj bojVar, Object obj) throws IOException {
        if (((Number) obj) == null) {
            bojVar.g();
        } else {
            bojVar.i(r4.shortValue());
        }
    }
}
