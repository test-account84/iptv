package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.os.Handler;
import java.util.Iterator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class ahe {
    private static ahe a;
    private float b = 0.0f;
    private agy c;
    private agz d;
    private final afe e;
    private final com.google.ads.interactivemedia.v3.impl.data.i f;

    public ahe(com.google.ads.interactivemedia.v3.impl.data.i iVar, afe afeVar, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        this.f = iVar;
        this.e = afeVar;
    }

    public static ahe b() {
        if (a == null) {
            a = new ahe(new com.google.ads.interactivemedia.v3.impl.data.i(), new afe(), null, null, null);
        }
        return a;
    }

    public final float a() {
        return this.b;
    }

    public final void c(Context context) {
        this.c = new agy(new Handler(), context, new afe(), this, null, null);
    }

    public final void d(float f) {
        this.b = f;
        if (this.d == null) {
            this.d = agz.a();
        }
        Iterator it = this.d.b().iterator();
        while (it.hasNext()) {
            ((agt) it.next()).h().h(f);
        }
    }

    public final void e() {
        aha.a().d(this);
        aha.a().b();
        aht.c().h();
        this.c.a();
    }

    public final void f() {
        aht.c().i();
        aha.a().c();
        this.c.b();
    }
}
