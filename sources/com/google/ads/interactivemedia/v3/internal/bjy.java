package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.io.StringWriter;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class bjy {
    @Deprecated
    public bjy() {
    }

    public final String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            boj bojVar = new boj(stringWriter);
            bojVar.o(true);
            blo.b(this, bojVar);
            return stringWriter.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
