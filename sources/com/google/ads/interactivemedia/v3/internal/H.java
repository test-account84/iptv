package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class h implements az {
    protected final bd a = new bd();

    private final void v() {
        s();
    }

    public final int a() {
        be o = o();
        if (o.p()) {
            return -1;
        }
        int h = h();
        v();
        t();
        return o.j(h, 0, false);
    }

    public final int b() {
        be o = o();
        if (o.p()) {
            return -1;
        }
        int h = h();
        v();
        t();
        return o.q(h);
    }

    public final boolean c() {
        be o = o();
        return !o.p() && o.o(h(), this.a).i;
    }

    public final boolean d() {
        be o = o();
        return !o.p() && o.o(h(), this.a).c();
    }

    public final boolean e() {
        be o = o();
        return !o.p() && o.o(h(), this.a).h;
    }
}
