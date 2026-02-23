package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class lk {
    final uv a;
    public final me b;
    public final lt c;
    public final li d;
    private final long e;
    private final long f;

    public lk(long j, me meVar, lt ltVar, uv uvVar, long j2, li liVar) {
        this.e = j;
        this.b = meVar;
        this.c = ltVar;
        this.f = j2;
        this.a = uvVar;
        this.d = liVar;
    }

    public static /* bridge */ /* synthetic */ long a(lk lkVar) {
        return lkVar.e;
    }

    public final long b(long j) {
        return this.d.c(this.e, j) + this.f;
    }

    public final long c() {
        return this.d.d() + this.f;
    }

    public final long d(long j) {
        return (b(j) + this.d.a(this.e, j)) - 1;
    }

    public final long e() {
        return this.d.f(this.e);
    }

    public final long f(long j) {
        return h(j) + this.d.b(j - this.f, this.e);
    }

    public final long g(long j) {
        return this.d.g(j, this.e) + this.f;
    }

    public final long h(long j) {
        return this.d.h(j - this.f);
    }

    public final lk i(long j, me meVar) throws sb {
        long g;
        li k = this.b.k();
        li k2 = meVar.k();
        if (k == null) {
            return new lk(j, meVar, this.c, this.a, this.f, null);
        }
        if (!k.j()) {
            return new lk(j, meVar, this.c, this.a, this.f, k2);
        }
        long f = k.f(j);
        if (f == 0) {
            return new lk(j, meVar, this.c, this.a, this.f, k2);
        }
        long d = k.d();
        long h = k.h(d);
        long j2 = f + d;
        long j3 = (-1) + j2;
        long h2 = k.h(j3) + k.b(j3, j);
        long d2 = k2.d();
        long h3 = k2.h(d2);
        long j4 = this.f;
        if (h2 == h3) {
            g = j4 + (j2 - d2);
        } else {
            if (h2 < h3) {
                throw new sb();
            }
            g = h3 < h ? j4 - (k2.g(h, j) - d) : j4 + (k.g(h3, j) - d2);
        }
        return new lk(j, meVar, this.c, this.a, g, k2);
    }

    public final lk j(li liVar) {
        return new lk(this.e, this.b, this.c, this.a, this.f, liVar);
    }

    public final lk k(lt ltVar) {
        return new lk(this.e, this.b, ltVar, this.a, this.f, this.d);
    }

    public final mb l(long j) {
        return this.d.i(j - this.f);
    }

    public final boolean m(long j, long j2) {
        return this.d.j() || j2 == -9223372036854775807L || f(j) <= j2;
    }
}
