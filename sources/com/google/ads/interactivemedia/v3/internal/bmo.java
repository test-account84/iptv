package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bmo extends bkl {
    final bjt a;
    private final bke b;
    private final bjx c;
    private final bof d;
    private final bkm e;
    private final bmm f = new bmm();
    private final boolean g;
    private volatile bkl h;

    public bmo(bke bkeVar, bjx bjxVar, bjt bjtVar, bof bofVar, bkm bkmVar, boolean z) {
        this.b = bkeVar;
        this.c = bjxVar;
        this.a = bjtVar;
        this.d = bofVar;
        this.e = bkmVar;
        this.g = z;
    }

    public static bkm a(bof bofVar, Object obj) {
        return new bmn(obj, bofVar, bofVar.d() == bofVar.c());
    }

    private final bkl b() {
        bkl bklVar = this.h;
        if (bklVar != null) {
            return bklVar;
        }
        bkl c = this.a.c(this.e, this.d);
        this.h = c;
        return c;
    }

    public final Object read(boh bohVar) throws IOException {
        if (this.c == null) {
            return b().read(bohVar);
        }
        bjy a = blo.a(bohVar);
        if (this.g && (a instanceof bka)) {
            return null;
        }
        return this.c.a();
    }

    public final void write(boj bojVar, Object obj) throws IOException {
        bke bkeVar = this.b;
        if (bkeVar == null) {
            b().write(bojVar, obj);
        } else if (this.g && obj == null) {
            bojVar.g();
        } else {
            blo.b(bkeVar.a(obj), bojVar);
        }
    }
}
