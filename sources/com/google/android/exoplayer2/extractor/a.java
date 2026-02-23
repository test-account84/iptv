package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.extractor.g;
import d3.j;
import d3.t;
import d3.u;
import d4.k0;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class a {
    public final a a;
    public final f b;
    public c c;
    public final int d;

    public static class a implements g {
        public final d a;
        public final long b;
        public final long c;
        public final long d;
        public final long e;
        public final long f;
        public final long g;

        public a(d dVar, long j, long j2, long j3, long j4, long j5, long j6) {
            this.a = dVar;
            this.b = j;
            this.c = j2;
            this.d = j3;
            this.e = j4;
            this.f = j5;
            this.g = j6;
        }

        public static /* synthetic */ long a(a aVar) {
            return aVar.c;
        }

        public static /* synthetic */ long b(a aVar) {
            return aVar.d;
        }

        public static /* synthetic */ long d(a aVar) {
            return aVar.e;
        }

        public static /* synthetic */ long h(a aVar) {
            return aVar.f;
        }

        public static /* synthetic */ long j(a aVar) {
            return aVar.g;
        }

        public g.a e(long j) {
            return new g.a(new u(j, c.h(this.a.a(j), this.c, this.d, this.e, this.f, this.g)));
        }

        public boolean g() {
            return true;
        }

        public long i() {
            return this.b;
        }

        public long k(long j) {
            return this.a.a(j);
        }
    }

    public static final class b implements d {
        public long a(long j) {
            return j;
        }
    }

    public static class c {
        public final long a;
        public final long b;
        public final long c;
        public long d;
        public long e;
        public long f;
        public long g;
        public long h;

        public c(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
            this.a = j;
            this.b = j2;
            this.d = j3;
            this.e = j4;
            this.f = j5;
            this.g = j6;
            this.c = j7;
            this.h = h(j2, j3, j4, j5, j6, j7);
        }

        public static /* synthetic */ long a(c cVar) {
            return cVar.l();
        }

        public static /* synthetic */ long b(c cVar) {
            return cVar.j();
        }

        public static /* synthetic */ long c(c cVar) {
            return cVar.i();
        }

        public static /* synthetic */ long d(c cVar) {
            return cVar.k();
        }

        public static /* synthetic */ long e(c cVar) {
            return cVar.m();
        }

        public static /* synthetic */ void f(c cVar, long j, long j2) {
            cVar.o(j, j2);
        }

        public static /* synthetic */ void g(c cVar, long j, long j2) {
            cVar.p(j, j2);
        }

        public static long h(long j, long j2, long j3, long j4, long j5, long j6) {
            if (j4 + 1 >= j5 || j2 + 1 >= j3) {
                return j4;
            }
            long j7 = (long) ((j - j2) * ((j5 - j4) / (j3 - j2)));
            return k0.s(((j7 + j4) - j6) - (j7 / 20), j4, j5 - 1);
        }

        public final long i() {
            return this.g;
        }

        public final long j() {
            return this.f;
        }

        public final long k() {
            return this.h;
        }

        public final long l() {
            return this.a;
        }

        public final long m() {
            return this.b;
        }

        public final void n() {
            this.h = h(this.b, this.d, this.e, this.f, this.g, this.c);
        }

        public final void o(long j, long j2) {
            this.e = j;
            this.g = j2;
            n();
        }

        public final void p(long j, long j2) {
            this.d = j;
            this.f = j2;
            n();
        }
    }

    public interface d {
        long a(long j);
    }

    public static final class e {
        public static final e d = new e(-3, -9223372036854775807L, -1);
        public final int a;
        public final long b;
        public final long c;

        public e(int i, long j, long j2) {
            this.a = i;
            this.b = j;
            this.c = j2;
        }

        public static /* synthetic */ int a(e eVar) {
            return eVar.a;
        }

        public static /* synthetic */ long b(e eVar) {
            return eVar.b;
        }

        public static /* synthetic */ long c(e eVar) {
            return eVar.c;
        }

        public static e d(long j, long j2) {
            return new e(-1, j, j2);
        }

        public static e e(long j) {
            return new e(0, -9223372036854775807L, j);
        }

        public static e f(long j, long j2) {
            return new e(-2, j, j2);
        }
    }

    public interface f {
        e a(j jVar, long j);

        void b();
    }

    public a(d dVar, f fVar, long j, long j2, long j3, long j4, long j5, long j6, int i) {
        this.b = fVar;
        this.d = i;
        this.a = new a(dVar, j, j2, j3, j4, j5, j6);
    }

    public c a(long j) {
        return new c(j, this.a.k(j), a.a(this.a), a.b(this.a), a.d(this.a), a.h(this.a), a.j(this.a));
    }

    public final g b() {
        return this.a;
    }

    public int c(j jVar, t tVar) {
        while (true) {
            c cVar = (c) d4.a.i(this.c);
            long b2 = c.b(cVar);
            long c2 = c.c(cVar);
            long d2 = c.d(cVar);
            if (c2 - b2 <= this.d) {
                e(false, b2);
                return g(jVar, b2, tVar);
            }
            if (!i(jVar, d2)) {
                return g(jVar, d2, tVar);
            }
            jVar.f();
            e a2 = this.b.a(jVar, c.e(cVar));
            int a3 = e.a(a2);
            if (a3 == -3) {
                e(false, d2);
                return g(jVar, d2, tVar);
            }
            if (a3 == -2) {
                c.g(cVar, e.b(a2), e.c(a2));
            } else {
                if (a3 != -1) {
                    if (a3 != 0) {
                        throw new IllegalStateException("Invalid case");
                    }
                    i(jVar, e.c(a2));
                    e(true, e.c(a2));
                    return g(jVar, e.c(a2), tVar);
                }
                c.f(cVar, e.b(a2), e.c(a2));
            }
        }
    }

    public final boolean d() {
        return this.c != null;
    }

    public final void e(boolean z, long j) {
        this.c = null;
        this.b.b();
        f(z, j);
    }

    public void f(boolean z, long j) {
    }

    public final int g(j jVar, long j, t tVar) {
        if (j == jVar.getPosition()) {
            return 0;
        }
        tVar.a = j;
        return 1;
    }

    public final void h(long j) {
        c cVar = this.c;
        if (cVar == null || c.a(cVar) != j) {
            this.c = a(j);
        }
    }

    public final boolean i(j jVar, long j) {
        long position = j - jVar.getPosition();
        if (position < 0 || position > 262144) {
            return false;
        }
        jVar.q((int) position);
        return true;
    }
}
