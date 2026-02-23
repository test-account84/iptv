package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class sx implements td, tc {
    public final te a;
    private final long b;
    private tg c;
    private td d;
    private tc e;
    private long f = -9223372036854775807L;
    private final wr g;

    public sx(te teVar, wr wrVar, long j) {
        this.a = teVar;
        this.g = wrVar;
        this.b = j;
    }

    private final long u(long j) {
        long j2 = this.f;
        return j2 != -9223372036854775807L ? j2 : j;
    }

    public final long a(long j, hl hlVar) {
        td tdVar = this.d;
        int i = cq.a;
        return tdVar.a(j, hlVar);
    }

    public final void bl(td tdVar) {
        tc tcVar = this.e;
        int i = cq.a;
        tcVar.bl(this);
    }

    public final void bm() throws IOException {
        td tdVar = this.d;
        if (tdVar != null) {
            tdVar.bm();
            return;
        }
        tg tgVar = this.c;
        if (tgVar != null) {
            tgVar.h();
        }
    }

    public final long bo() {
        td tdVar = this.d;
        int i = cq.a;
        return tdVar.bo();
    }

    public final long c() {
        td tdVar = this.d;
        int i = cq.a;
        return tdVar.c();
    }

    public final long d() {
        td tdVar = this.d;
        int i = cq.a;
        return tdVar.d();
    }

    public final long e(long j) {
        td tdVar = this.d;
        int i = cq.a;
        return tdVar.e(j);
    }

    public final long f(we[] weVarArr, boolean[] zArr, uf[] ufVarArr, boolean[] zArr2, long j) {
        long j2;
        long j3 = this.f;
        if (j3 == -9223372036854775807L || j != this.b) {
            j2 = j;
        } else {
            this.f = -9223372036854775807L;
            j2 = j3;
        }
        td tdVar = this.d;
        int i = cq.a;
        return tdVar.f(weVarArr, zArr, ufVarArr, zArr2, j2);
    }

    public final /* bridge */ /* synthetic */ void g(uh uhVar) {
        tc tcVar = this.e;
        int i = cq.a;
        tcVar.g(this);
    }

    public final um h() {
        td tdVar = this.d;
        int i = cq.a;
        return tdVar.h();
    }

    public final long j() {
        return this.f;
    }

    public final void k(tc tcVar, long j) {
        this.e = tcVar;
        td tdVar = this.d;
        if (tdVar != null) {
            tdVar.k(this, u(this.b));
        }
    }

    public final void l(long j) {
        td tdVar = this.d;
        int i = cq.a;
        tdVar.l(j);
    }

    public final long m() {
        return this.b;
    }

    public final void n(te teVar) {
        long u = u(this.b);
        tg tgVar = this.c;
        af.s(tgVar);
        td q = tgVar.q(teVar, this.g, u);
        this.d = q;
        if (this.e != null) {
            q.k(this, u);
        }
    }

    public final boolean o(long j) {
        td tdVar = this.d;
        return tdVar != null && tdVar.o(j);
    }

    public final boolean p() {
        td tdVar = this.d;
        return tdVar != null && tdVar.p();
    }

    public final void q(long j) {
        td tdVar = this.d;
        int i = cq.a;
        tdVar.q(j);
    }

    public final void r(long j) {
        this.f = j;
    }

    public final void s() {
        if (this.d != null) {
            tg tgVar = this.c;
            af.s(tgVar);
            tgVar.o(this.d);
        }
    }

    public final void t(tg tgVar) {
        af.w(this.c == null);
        this.c = tgVar;
    }
}
