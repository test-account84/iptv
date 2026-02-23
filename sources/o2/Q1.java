package O2;

import B3.C;
import android.os.SystemClock;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class q1 {
    public static final C.b t = new C.b(new Object());
    public final Q1 a;
    public final C.b b;
    public final long c;
    public final long d;
    public final int e;
    public final w f;
    public final boolean g;
    public final B3.i0 h;
    public final Z3.D i;
    public final List j;
    public final C.b k;
    public final boolean l;
    public final int m;
    public final s1 n;
    public final boolean o;
    public volatile long p;
    public volatile long q;
    public volatile long r;
    public volatile long s;

    public q1(Q1 q1, C.b bVar, long j, long j2, int i, w wVar, boolean z, B3.i0 i0Var, Z3.D d, List list, C.b bVar2, boolean z2, int i2, s1 s1Var, long j3, long j4, long j5, long j6, boolean z3) {
        this.a = q1;
        this.b = bVar;
        this.c = j;
        this.d = j2;
        this.e = i;
        this.f = wVar;
        this.g = z;
        this.h = i0Var;
        this.i = d;
        this.j = list;
        this.k = bVar2;
        this.l = z2;
        this.m = i2;
        this.n = s1Var;
        this.p = j3;
        this.q = j4;
        this.r = j5;
        this.s = j6;
        this.o = z3;
    }

    public static q1 k(Z3.D d) {
        Q1 q1 = Q1.a;
        C.b bVar = t;
        return new q1(q1, bVar, -9223372036854775807L, 0L, 1, null, false, B3.i0.e, d, s5.y.z(), bVar, false, 0, s1.e, 0L, 0L, 0L, 0L, false);
    }

    public static C.b l() {
        return t;
    }

    public q1 a() {
        return new q1(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.p, this.q, m(), SystemClock.elapsedRealtime(), this.o);
    }

    public q1 b(boolean z) {
        return new q1(this.a, this.b, this.c, this.d, this.e, this.f, z, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.p, this.q, this.r, this.s, this.o);
    }

    public q1 c(C.b bVar) {
        return new q1(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, bVar, this.l, this.m, this.n, this.p, this.q, this.r, this.s, this.o);
    }

    public q1 d(C.b bVar, long j, long j2, long j3, long j4, B3.i0 i0Var, Z3.D d, List list) {
        return new q1(this.a, bVar, j2, j3, this.e, this.f, this.g, i0Var, d, list, this.k, this.l, this.m, this.n, this.p, j4, j, SystemClock.elapsedRealtime(), this.o);
    }

    public q1 e(boolean z, int i) {
        return new q1(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, z, i, this.n, this.p, this.q, this.r, this.s, this.o);
    }

    public q1 f(w wVar) {
        return new q1(this.a, this.b, this.c, this.d, this.e, wVar, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.p, this.q, this.r, this.s, this.o);
    }

    public q1 g(s1 s1Var) {
        return new q1(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, s1Var, this.p, this.q, this.r, this.s, this.o);
    }

    public q1 h(int i) {
        return new q1(this.a, this.b, this.c, this.d, i, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.p, this.q, this.r, this.s, this.o);
    }

    public q1 i(boolean z) {
        return new q1(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.p, this.q, this.r, this.s, z);
    }

    public q1 j(Q1 q1) {
        return new q1(q1, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.p, this.q, this.r, this.s, this.o);
    }

    public long m() {
        long j;
        long j2;
        if (!n()) {
            return this.r;
        }
        do {
            j = this.s;
            j2 = this.r;
        } while (j != this.s);
        return d4.k0.P0(d4.k0.x1(j2) + ((long) ((SystemClock.elapsedRealtime() - j) * this.n.a)));
    }

    public boolean n() {
        return this.e == 3 && this.l && this.m == 0;
    }

    public void o(long j) {
        this.r = j;
        this.s = SystemClock.elapsedRealtime();
    }
}
