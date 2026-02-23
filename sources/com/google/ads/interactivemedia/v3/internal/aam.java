package com.google.ads.interactivemedia.v3.internal;

import java.nio.ByteBuffer;
import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class aam extends aaj {
    public static final aal c(cj cjVar) {
        String s = cjVar.s();
        af.s(s);
        String s2 = cjVar.s();
        af.s(s2);
        return new aal(s, s2, cjVar.o(), cjVar.o(), Arrays.copyOfRange(cjVar.H(), cjVar.c(), cjVar.d()));
    }

    public final ao b(ByteBuffer byteBuffer) {
        return new ao(c(new cj(byteBuffer.array(), byteBuffer.limit())));
    }
}
