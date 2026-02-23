package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bog extends bla {
    public final void a(boh bohVar) throws IOException {
        if (bohVar instanceof bmc) {
            ((bmc) bohVar).n();
            return;
        }
        int i = bohVar.a;
        if (i == 0) {
            i = bohVar.s();
        }
        if (i == 13) {
            bohVar.a = 9;
            return;
        }
        if (i == 12) {
            bohVar.a = 8;
            return;
        }
        if (i == 14) {
            bohVar.a = 10;
            return;
        }
        int r = bohVar.r();
        throw new IllegalStateException("Expected a name but was " + boi.a(r) + bohVar.t());
    }
}
