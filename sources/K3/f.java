package k3;

import O2.z0;
import Q2.b0;
import d3.j;
import d3.k;
import d3.o;
import d3.r;
import d3.s;
import d3.t;
import d3.w;
import d4.M;
import d4.k0;
import java.io.EOFException;
import k3.g;
import q3.a;
import v3.h;
import v3.m;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class f implements d3.i {
    public static final o u = new d();
    public static final h.a v = new e();
    public final int a;
    public final long b;
    public final M c;
    public final b0.a d;
    public final r e;
    public final s f;
    public final w g;
    public k h;
    public w i;
    public w j;
    public int k;
    public q3.a l;
    public long m;
    public long n;
    public long o;
    public int p;
    public g q;
    public boolean r;
    public boolean s;
    public long t;

    public f() {
        this(0);
    }

    public static /* synthetic */ d3.i[] c() {
        return o();
    }

    public static /* synthetic */ boolean e(int i, int i2, int i3, int i4, int i5) {
        return p(i, i2, i3, i4, i5);
    }

    private void f() {
        d4.a.i(this.i);
        k0.j(this.h);
    }

    public static long l(q3.a aVar) {
        if (aVar == null) {
            return -9223372036854775807L;
        }
        int f = aVar.f();
        for (int i = 0; i < f; i++) {
            a.b e = aVar.e(i);
            if (e instanceof m) {
                m mVar = (m) e;
                if (mVar.a.equals("TLEN")) {
                    return k0.P0(Long.parseLong((String) mVar.e.get(0)));
                }
            }
        }
        return -9223372036854775807L;
    }

    public static int m(M m, int i) {
        if (m.g() >= i + 4) {
            m.U(i);
            int q = m.q();
            if (q == 1483304551 || q == 1231971951) {
                return q;
            }
        }
        if (m.g() < 40) {
            return 0;
        }
        m.U(36);
        return m.q() == 1447187017 ? 1447187017 : 0;
    }

    public static boolean n(int i, long j) {
        return ((long) (i & (-128000))) == (j & (-128000));
    }

    private static /* synthetic */ d3.i[] o() {
        return new d3.i[]{new f()};
    }

    public static /* synthetic */ boolean p(int i, int i2, int i3, int i4, int i5) {
        return (i2 == 67 && i3 == 79 && i4 == 77 && (i5 == 77 || i == 2)) || (i2 == 77 && i3 == 76 && i4 == 76 && (i5 == 84 || i == 2));
    }

    public static c q(q3.a aVar, long j) {
        if (aVar == null) {
            return null;
        }
        int f = aVar.f();
        for (int i = 0; i < f; i++) {
            a.b e = aVar.e(i);
            if (e instanceof v3.k) {
                return c.a(j, (v3.k) e, l(aVar));
            }
        }
        return null;
    }

    private int u(j jVar) {
        if (this.p == 0) {
            jVar.f();
            if (s(jVar)) {
                return -1;
            }
            this.c.U(0);
            int q = this.c.q();
            if (!n(q, this.k) || b0.j(q) == -1) {
                jVar.q(1);
                this.k = 0;
                return 0;
            }
            this.d.a(q);
            if (this.m == -9223372036854775807L) {
                this.m = this.q.c(jVar.getPosition());
                if (this.b != -9223372036854775807L) {
                    this.m += this.b - this.q.c(0L);
                }
            }
            this.p = this.d.c;
            g gVar = this.q;
            if (gVar instanceof b) {
                b bVar = (b) gVar;
                bVar.b(i(this.n + r0.g), jVar.getPosition() + this.d.c);
                if (this.s && bVar.a(this.t)) {
                    this.s = false;
                    this.j = this.i;
                }
            }
        }
        int a = this.j.a(jVar, this.p, true);
        if (a == -1) {
            return -1;
        }
        int i = this.p - a;
        this.p = i;
        if (i > 0) {
            return 0;
        }
        this.j.f(i(this.n), 1, this.d.c, 0, null);
        this.n += this.d.g;
        this.p = 0;
        return 0;
    }

    public void a(long j, long j2) {
        this.k = 0;
        this.m = -9223372036854775807L;
        this.n = 0L;
        this.p = 0;
        this.t = j2;
        g gVar = this.q;
        if (!(gVar instanceof b) || ((b) gVar).a(j2)) {
            return;
        }
        this.s = true;
        this.j = this.g;
    }

    public void b(k kVar) {
        this.h = kVar;
        w e = kVar.e(0, 1);
        this.i = e;
        this.j = e;
        this.h.q();
    }

    public int d(j jVar, t tVar) {
        f();
        int t = t(jVar);
        if (t == -1 && (this.q instanceof b)) {
            long i = i(this.n);
            if (this.q.i() != i) {
                ((b) this.q).d(i);
                this.h.n(this.q);
            }
        }
        return t;
    }

    public final g g(j jVar) {
        long l;
        long j;
        g r = r(jVar);
        c q = q(this.l, jVar.getPosition());
        if (this.r) {
            return new g.a();
        }
        if ((this.a & 4) != 0) {
            if (q != null) {
                l = q.i();
                j = q.f();
            } else if (r != null) {
                l = r.i();
                j = r.f();
            } else {
                l = l(this.l);
                j = -1;
            }
            r = new b(l, jVar.getPosition(), j);
        } else if (q != null) {
            r = q;
        } else if (r == null) {
            r = null;
        }
        if (r == null || !(r.g() || (this.a & 1) == 0)) {
            return k(jVar, (this.a & 2) != 0);
        }
        return r;
    }

    public boolean h(j jVar) {
        return v(jVar, true);
    }

    public final long i(long j) {
        return this.m + ((j * 1000000) / this.d.d);
    }

    public void j() {
        this.r = true;
    }

    public final g k(j jVar, boolean z) {
        jVar.s(this.c.e(), 0, 4);
        this.c.U(0);
        this.d.a(this.c.q());
        return new a(jVar.getLength(), jVar.getPosition(), this.d, z);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final k3.g r(d3.j r11) {
        /*
            r10 = this;
            d4.M r5 = new d4.M
            Q2.b0$a r0 = r10.d
            int r0 = r0.c
            r5.<init>(r0)
            byte[] r0 = r5.e()
            Q2.b0$a r1 = r10.d
            int r1 = r1.c
            r6 = 0
            r11.s(r0, r6, r1)
            Q2.b0$a r0 = r10.d
            int r1 = r0.a
            r2 = 1
            r1 = r1 & r2
            r3 = 21
            int r0 = r0.e
            if (r1 == 0) goto L2b
            if (r0 == r2) goto L28
            r3 = 36
            r7 = 36
            goto L32
        L28:
            r7 = 21
            goto L32
        L2b:
            if (r0 == r2) goto L2e
            goto L28
        L2e:
            r3 = 13
            r7 = 13
        L32:
            int r8 = m(r5, r7)
            r0 = 1483304551(0x58696e67, float:1.02664153E15)
            r9 = 1231971951(0x496e666f, float:976486.94)
            if (r8 == r0) goto L61
            if (r8 != r9) goto L41
            goto L61
        L41:
            r0 = 1447187017(0x56425249, float:5.3414667E13)
            if (r8 != r0) goto L5c
            long r0 = r11.getLength()
            long r2 = r11.getPosition()
            Q2.b0$a r4 = r10.d
            k3.h r0 = k3.h.a(r0, r2, r4, r5)
            Q2.b0$a r1 = r10.d
            int r1 = r1.c
            r11.q(r1)
            goto Lb1
        L5c:
            r11.f()
            r0 = 0
            goto Lb1
        L61:
            long r0 = r11.getLength()
            long r2 = r11.getPosition()
            Q2.b0$a r4 = r10.d
            k3.i r0 = k3.i.a(r0, r2, r4, r5)
            if (r0 == 0) goto L9b
            d3.r r1 = r10.e
            boolean r1 = r1.a()
            if (r1 != 0) goto L9b
            r11.f()
            int r7 = r7 + 141
            r11.n(r7)
            d4.M r1 = r10.c
            byte[] r1 = r1.e()
            r2 = 3
            r11.s(r1, r6, r2)
            d4.M r1 = r10.c
            r1.U(r6)
            d3.r r1 = r10.e
            d4.M r2 = r10.c
            int r2 = r2.K()
            r1.d(r2)
        L9b:
            Q2.b0$a r1 = r10.d
            int r1 = r1.c
            r11.q(r1)
            if (r0 == 0) goto Lb1
            boolean r1 = r0.g()
            if (r1 != 0) goto Lb1
            if (r8 != r9) goto Lb1
            k3.g r11 = r10.k(r11, r6)
            return r11
        Lb1:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: k3.f.r(d3.j):k3.g");
    }

    public final boolean s(j jVar) {
        g gVar = this.q;
        if (gVar != null) {
            long f = gVar.f();
            if (f != -1 && jVar.k() > f - 4) {
                return true;
            }
        }
        try {
            return !jVar.d(this.c.e(), 0, 4, true);
        } catch (EOFException unused) {
            return true;
        }
    }

    public final int t(j jVar) {
        if (this.k == 0) {
            try {
                v(jVar, false);
            } catch (EOFException unused) {
                return -1;
            }
        }
        if (this.q == null) {
            g g = g(jVar);
            this.q = g;
            this.h.n(g);
            this.j.d(new z0.b().g0(this.d.b).Y(4096).J(this.d.e).h0(this.d.d).P(this.e.a).Q(this.e.b).Z((this.a & 8) != 0 ? null : this.l).G());
            this.o = jVar.getPosition();
        } else if (this.o != 0) {
            long position = jVar.getPosition();
            long j = this.o;
            if (position < j) {
                jVar.q((int) (j - position));
            }
        }
        return u(jVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x009a, code lost:
    
        if (r13 == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x009c, code lost:
    
        r12.q(r2 + r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00a4, code lost:
    
        r11.k = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00a6, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00a1, code lost:
    
        r12.f();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean v(d3.j r12, boolean r13) {
        /*
            r11 = this;
            if (r13 == 0) goto L6
            r0 = 32768(0x8000, float:4.5918E-41)
            goto L8
        L6:
            r0 = 131072(0x20000, float:1.83671E-40)
        L8:
            r12.f()
            long r1 = r12.getPosition()
            r3 = 0
            r5 = 0
            r6 = 0
            int r7 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r7 != 0) goto L3e
            int r1 = r11.a
            r1 = r1 & 8
            if (r1 != 0) goto L1f
            r1 = r5
            goto L21
        L1f:
            v3.h$a r1 = k3.f.v
        L21:
            d3.s r2 = r11.f
            q3.a r1 = r2.a(r12, r1)
            r11.l = r1
            if (r1 == 0) goto L30
            d3.r r2 = r11.e
            r2.c(r1)
        L30:
            long r1 = r12.k()
            int r2 = (int) r1
            if (r13 != 0) goto L3a
            r12.q(r2)
        L3a:
            r1 = 0
        L3b:
            r3 = 0
            r4 = 0
            goto L41
        L3e:
            r1 = 0
            r2 = 0
            goto L3b
        L41:
            boolean r7 = r11.s(r12)
            r8 = 1
            if (r7 == 0) goto L51
            if (r3 <= 0) goto L4b
            goto L9a
        L4b:
            java.io.EOFException r12 = new java.io.EOFException
            r12.<init>()
            throw r12
        L51:
            d4.M r7 = r11.c
            r7.U(r6)
            d4.M r7 = r11.c
            int r7 = r7.q()
            if (r1 == 0) goto L65
            long r9 = (long) r1
            boolean r9 = n(r7, r9)
            if (r9 == 0) goto L6c
        L65:
            int r9 = Q2.b0.j(r7)
            r10 = -1
            if (r9 != r10) goto L8c
        L6c:
            int r1 = r4 + 1
            if (r4 != r0) goto L7a
            if (r13 == 0) goto L73
            return r6
        L73:
            java.lang.String r12 = "Searched too many bytes."
            O2.l1 r12 = O2.l1.a(r12, r5)
            throw r12
        L7a:
            if (r13 == 0) goto L85
            r12.f()
            int r3 = r2 + r1
            r12.n(r3)
            goto L88
        L85:
            r12.q(r8)
        L88:
            r4 = r1
            r1 = 0
            r3 = 0
            goto L41
        L8c:
            int r3 = r3 + 1
            if (r3 != r8) goto L97
            Q2.b0$a r1 = r11.d
            r1.a(r7)
            r1 = r7
            goto La7
        L97:
            r7 = 4
            if (r3 != r7) goto La7
        L9a:
            if (r13 == 0) goto La1
            int r2 = r2 + r4
            r12.q(r2)
            goto La4
        La1:
            r12.f()
        La4:
            r11.k = r1
            return r8
        La7:
            int r9 = r9 + (-4)
            r12.n(r9)
            goto L41
        */
        throw new UnsupportedOperationException("Method not decompiled: k3.f.v(d3.j, boolean):boolean");
    }

    public f(int i) {
        this(i, -9223372036854775807L);
    }

    public f(int i, long j) {
        this.a = (i & 2) != 0 ? i | 1 : i;
        this.b = j;
        this.c = new M(10);
        this.d = new b0.a();
        this.e = new r();
        this.m = -9223372036854775807L;
        this.f = new s();
        d3.h hVar = new d3.h();
        this.g = hVar;
        this.j = hVar;
    }

    public void release() {
    }
}
