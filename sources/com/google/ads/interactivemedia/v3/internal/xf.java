package com.google.ads.interactivemedia.v3.internal;

import android.net.Uri;
import java.io.IOException;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class xf implements wy {
    public final long a;
    public final dc b;
    public final int c;
    private final dv d;
    private final xe e;
    private volatile Object f;

    public xf(cy cyVar, Uri uri, int i, xe xeVar) {
        db dbVar = new db();
        dbVar.i(uri);
        dbVar.b(1);
        dc a = dbVar.a();
        this.d = new dv(cyVar);
        this.b = a;
        this.c = i;
        this.e = xeVar;
        this.a = sw.a();
    }

    public final long a() {
        return this.d.g();
    }

    public final Uri c() {
        return this.d.h();
    }

    public final Object d() {
        return this.f;
    }

    public final void e() throws IOException {
        this.d.j();
        da daVar = new da(this.d, this.b);
        try {
            daVar.a();
            Uri c = this.d.c();
            af.s(c);
            this.f = this.e.a(c, daVar);
        } finally {
            cq.S(daVar);
        }
    }

    public final Map f() {
        return this.d.i();
    }

    public final void r() {
    }
}
