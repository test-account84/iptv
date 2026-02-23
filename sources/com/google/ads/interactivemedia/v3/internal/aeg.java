package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class aeg implements aei {
    private s a;
    private co b;
    private aae c;

    public aeg(String str) {
        r rVar = new r();
        rVar.ae(str);
        this.a = rVar.v();
    }

    public final void a(cj cjVar) {
        af.t(this.b);
        int i = cq.a;
        long d = this.b.d();
        long e = this.b.e();
        if (d == -9223372036854775807L || e == -9223372036854775807L) {
            return;
        }
        s sVar = this.a;
        if (e != sVar.p) {
            r b = sVar.b();
            b.ai(e);
            s v = b.v();
            this.a = v;
            this.c.b(v);
        }
        int a = cjVar.a();
        this.c.e(cjVar, a);
        this.c.f(d, 1, a, 0, null);
    }

    public final void b(co coVar, zk zkVar, aet aetVar) {
        this.b = coVar;
        aetVar.c();
        aae i = zkVar.i(aetVar.a(), 5);
        this.c = i;
        i.b(this.a);
    }
}
