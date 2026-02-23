package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bkx extends bkl {
    final /* synthetic */ boolean a;
    final /* synthetic */ boolean b;
    final /* synthetic */ bjt c;
    final /* synthetic */ bof d;
    final /* synthetic */ bky e;
    private bkl f;

    public bkx(bky bkyVar, boolean z, boolean z2, bjt bjtVar, bof bofVar) {
        this.e = bkyVar;
        this.a = z;
        this.b = z2;
        this.c = bjtVar;
        this.d = bofVar;
    }

    private final bkl a() {
        bkl bklVar = this.f;
        if (bklVar != null) {
            return bklVar;
        }
        bkl c = this.c.c(this.e, this.d);
        this.f = c;
        return c;
    }

    public final Object read(boh bohVar) throws IOException {
        if (!this.a) {
            return a().read(bohVar);
        }
        bohVar.o();
        return null;
    }

    public final void write(boj bojVar, Object obj) throws IOException {
        if (this.b) {
            bojVar.g();
        } else {
            a().write(bojVar, obj);
        }
    }
}
