package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.internal.bkl;
import com.google.ads.interactivemedia.v3.internal.boh;
import com.google.ads.interactivemedia.v3.internal.boj;
import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class ca extends bkl {
    public cb read(boh bohVar) throws IOException {
        if (bohVar.r() != 9) {
            return new cb(bohVar.h());
        }
        bohVar.m();
        return null;
    }

    public void write(boj bojVar, cb cbVar) throws IOException {
        if (cbVar == null) {
            bojVar.g();
        } else {
            bojVar.l(cbVar.getName());
        }
    }
}
