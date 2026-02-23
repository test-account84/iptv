package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class ux implements uf {
    public final uz a;
    final /* synthetic */ uz b;
    private final ue c;
    private final int d;
    private boolean e;

    public ux(uz uzVar, uz uzVar2, ue ueVar, int i) {
        this.b = uzVar;
        this.a = uzVar2;
        this.c = ueVar;
        this.d = i;
    }

    private final void e() {
        if (this.e) {
            return;
        }
        uz uzVar = this.b;
        tj h = uz.h(uzVar);
        int[] q = uz.q(uzVar);
        int i = this.d;
        h.o(q[i], uz.r(uzVar)[i], 0, uz.e(uzVar));
        this.e = true;
    }

    public final int a(go goVar, ef efVar, int i) {
        if (this.b.n()) {
            return -3;
        }
        e();
        return this.c.o(goVar, efVar, i, this.b.b);
    }

    public final int b(long j) {
        uz uzVar = this.b;
        if (uzVar.n()) {
            return 0;
        }
        int l = this.c.l(j, uzVar.b);
        this.c.G(l);
        if (l > 0) {
            e();
        }
        return l;
    }

    public final void c() {
        af.w(uz.s(this.b)[this.d]);
        uz.s(this.b)[this.d] = false;
    }

    public final void d() {
    }

    public final boolean g() {
        uz uzVar = this.b;
        return !uzVar.n() && this.c.K(uzVar.b);
    }
}
