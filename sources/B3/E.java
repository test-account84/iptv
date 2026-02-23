package B3;

import B3.C;
import O2.Q1;
import java.io.IOException;
import java.util.ArrayList;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class e extends k0 {
    public final long n;
    public final long o;
    public final boolean p;
    public final boolean q;
    public final boolean r;
    public final ArrayList s;
    public final Q1.d t;
    public a u;
    public b v;
    public long w;
    public long x;

    public static final class a extends s {
        public final long h;
        public final long i;
        public final long j;
        public final boolean k;

        public a(Q1 q1, long j, long j2) {
            super(q1);
            boolean z = false;
            if (q1.n() != 1) {
                throw new b(0);
            }
            Q1.d s = q1.s(0, new Q1.d());
            long max = Math.max(0L, j);
            if (!s.m && max != 0 && !s.i) {
                throw new b(1);
            }
            long max2 = j2 == Long.MIN_VALUE ? s.o : Math.max(0L, j2);
            long j3 = s.o;
            if (j3 != -9223372036854775807L) {
                max2 = max2 > j3 ? j3 : max2;
                if (max > max2) {
                    throw new b(2);
                }
            }
            this.h = max;
            this.i = max2;
            this.j = max2 == -9223372036854775807L ? -9223372036854775807L : max2 - max;
            if (s.j && (max2 == -9223372036854775807L || (j3 != -9223372036854775807L && max2 == j3))) {
                z = true;
            }
            this.k = z;
        }

        public Q1.b l(int i, Q1.b bVar, boolean z) {
            this.g.l(0, bVar, z);
            long t = bVar.t() - this.h;
            long j = this.j;
            return bVar.y(bVar.a, bVar.c, 0, j == -9223372036854775807L ? -9223372036854775807L : j - t, t);
        }

        public Q1.d t(int i, Q1.d dVar, long j) {
            this.g.t(0, dVar, 0L);
            long j2 = dVar.r;
            long j3 = this.h;
            dVar.r = j2 + j3;
            dVar.o = this.j;
            dVar.j = this.k;
            long j4 = dVar.n;
            if (j4 != -9223372036854775807L) {
                long max = Math.max(j4, j3);
                dVar.n = max;
                long j5 = this.i;
                if (j5 != -9223372036854775807L) {
                    max = Math.min(max, j5);
                }
                dVar.n = max - this.h;
            }
            long x1 = d4.k0.x1(this.h);
            long j6 = dVar.f;
            if (j6 != -9223372036854775807L) {
                dVar.f = j6 + x1;
            }
            long j7 = dVar.g;
            if (j7 != -9223372036854775807L) {
                dVar.g = j7 + x1;
            }
            return dVar;
        }
    }

    public static final class b extends IOException {
        public final int a;

        public b(int i) {
            super("Illegal clipping: " + a(i));
            this.a = i;
        }

        public static String a(int i) {
            return i != 0 ? i != 1 ? i != 2 ? "unknown" : "start exceeds end" : "not seekable to start" : "invalid period count";
        }
    }

    public e(C c, long j, long j2, boolean z, boolean z2, boolean z3) {
        super((C) d4.a.e(c));
        d4.a.a(j >= 0);
        this.n = j;
        this.o = j2;
        this.p = z;
        this.q = z2;
        this.r = z3;
        this.s = new ArrayList();
        this.t = new Q1.d();
    }

    public void C0(Q1 q1) {
        if (this.v != null) {
            return;
        }
        G0(q1);
    }

    public z E(C.b bVar, b4.b bVar2, long j) {
        d dVar = new d(this.l.E(bVar, bVar2, j), this.p, this.w, this.x);
        this.s.add(dVar);
        return dVar;
    }

    public final void G0(Q1 q1) {
        long j;
        long j2;
        q1.s(0, this.t);
        long g = this.t.g();
        if (this.u == null || this.s.isEmpty() || this.q) {
            long j3 = this.n;
            long j4 = this.o;
            if (this.r) {
                long e = this.t.e();
                j3 += e;
                j4 += e;
            }
            this.w = g + j3;
            this.x = this.o != Long.MIN_VALUE ? g + j4 : Long.MIN_VALUE;
            int size = this.s.size();
            for (int i = 0; i < size; i++) {
                ((d) this.s.get(i)).w(this.w, this.x);
            }
            j = j3;
            j2 = j4;
        } else {
            long j5 = this.w - g;
            j2 = this.o != Long.MIN_VALUE ? this.x - g : Long.MIN_VALUE;
            j = j5;
        }
        try {
            a aVar = new a(q1, j, j2);
            this.u = aVar;
            m0(aVar);
        } catch (b e2) {
            this.v = e2;
            for (int i2 = 0; i2 < this.s.size(); i2++) {
                ((d) this.s.get(i2)).r(this.v);
            }
        }
    }

    public void P() {
        b bVar = this.v;
        if (bVar != null) {
            throw bVar;
        }
        super.P();
    }

    public void Y(z zVar) {
        d4.a.g(this.s.remove(zVar));
        this.l.Y(((d) zVar).a);
        if (!this.s.isEmpty() || this.q) {
            return;
        }
        G0(((a) d4.a.e(this.u)).g);
    }

    public void n0() {
        super.n0();
        this.v = null;
        this.u = null;
    }
}
