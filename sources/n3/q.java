package n3;

import O2.z0;
import d4.G;
import d4.M;
import d4.k0;
import java.util.Collections;
import n3.I;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class q implements m {
    public final D a;
    public String b;
    public d3.w c;
    public a d;
    public boolean e;
    public long l;
    public final boolean[] f = new boolean[3];
    public final u g = new u(32, 128);
    public final u h = new u(33, 128);
    public final u i = new u(34, 128);
    public final u j = new u(39, 128);
    public final u k = new u(40, 128);
    public long m = -9223372036854775807L;
    public final M n = new M();

    public static final class a {
        public final d3.w a;
        public long b;
        public boolean c;
        public int d;
        public long e;
        public boolean f;
        public boolean g;
        public boolean h;
        public boolean i;
        public boolean j;
        public long k;
        public long l;
        public boolean m;

        public a(d3.w wVar) {
            this.a = wVar;
        }

        public static boolean b(int i) {
            return (32 <= i && i <= 35) || i == 39;
        }

        public static boolean c(int i) {
            return i < 32 || i == 40;
        }

        public void a(long j, int i, boolean z) {
            if (this.j && this.g) {
                this.m = this.c;
                this.j = false;
            } else if (this.h || this.g) {
                if (z && this.i) {
                    d(i + ((int) (j - this.b)));
                }
                this.k = this.b;
                this.l = this.e;
                this.m = this.c;
                this.i = true;
            }
        }

        public final void d(int i) {
            long j = this.l;
            if (j == -9223372036854775807L) {
                return;
            }
            boolean z = this.m;
            this.a.f(j, z ? 1 : 0, (int) (this.b - this.k), i, null);
        }

        public void e(byte[] bArr, int i, int i2) {
            if (this.f) {
                int i3 = this.d;
                int i4 = (i + 2) - i3;
                if (i4 >= i2) {
                    this.d = i3 + (i2 - i);
                } else {
                    this.g = (bArr[i4] & 128) != 0;
                    this.f = false;
                }
            }
        }

        public void f() {
            this.f = false;
            this.g = false;
            this.h = false;
            this.i = false;
            this.j = false;
        }

        public void g(long j, int i, int i2, long j2, boolean z) {
            this.g = false;
            this.h = false;
            this.e = j2;
            this.d = 0;
            this.b = j;
            if (!c(i2)) {
                if (this.i && !this.j) {
                    if (z) {
                        d(i);
                    }
                    this.i = false;
                }
                if (b(i2)) {
                    this.h = !this.j;
                    this.j = true;
                }
            }
            boolean z2 = i2 >= 16 && i2 <= 21;
            this.c = z2;
            this.f = z2 || i2 <= 9;
        }
    }

    public q(D d) {
        this.a = d;
    }

    private void a() {
        d4.a.i(this.c);
        k0.j(this.d);
    }

    private void g(long j, int i, int i2, long j2) {
        this.d.a(j, i, this.e);
        if (!this.e) {
            this.g.b(i2);
            this.h.b(i2);
            this.i.b(i2);
            if (this.g.c() && this.h.c() && this.i.c()) {
                this.c.d(i(this.b, this.g, this.h, this.i));
                this.e = true;
            }
        }
        if (this.j.b(i2)) {
            u uVar = this.j;
            this.n.S(this.j.d, d4.G.q(uVar.d, uVar.e));
            this.n.V(5);
            this.a.a(j2, this.n);
        }
        if (this.k.b(i2)) {
            u uVar2 = this.k;
            this.n.S(this.k.d, d4.G.q(uVar2.d, uVar2.e));
            this.n.V(5);
            this.a.a(j2, this.n);
        }
    }

    private void h(byte[] bArr, int i, int i2) {
        this.d.e(bArr, i, i2);
        if (!this.e) {
            this.g.a(bArr, i, i2);
            this.h.a(bArr, i, i2);
            this.i.a(bArr, i, i2);
        }
        this.j.a(bArr, i, i2);
        this.k.a(bArr, i, i2);
    }

    public static z0 i(String str, u uVar, u uVar2, u uVar3) {
        int i = uVar.e;
        byte[] bArr = new byte[uVar2.e + i + uVar3.e];
        System.arraycopy(uVar.d, 0, bArr, 0, i);
        System.arraycopy(uVar2.d, 0, bArr, uVar.e, uVar2.e);
        System.arraycopy(uVar3.d, 0, bArr, uVar.e + uVar2.e, uVar3.e);
        G.a h = d4.G.h(uVar2.d, 3, uVar2.e);
        return new z0.b().U(str).g0("video/hevc").K(d4.f.c(h.a, h.b, h.c, h.d, h.h, h.i)).n0(h.k).S(h.l).c0(h.m).V(Collections.singletonList(bArr)).G();
    }

    public void b(M m) {
        a();
        while (m.a() > 0) {
            int f = m.f();
            int g = m.g();
            byte[] e = m.e();
            this.l += m.a();
            this.c.b(m, m.a());
            while (f < g) {
                int c = d4.G.c(e, f, g, this.f);
                if (c == g) {
                    h(e, f, g);
                    return;
                }
                int e2 = d4.G.e(e, c);
                int i = c - f;
                if (i > 0) {
                    h(e, f, c);
                }
                int i2 = g - c;
                long j = this.l - i2;
                g(j, i2, i < 0 ? -i : 0, this.m);
                j(j, i2, e2, this.m);
                f = c + 3;
            }
        }
    }

    public void c() {
        this.l = 0L;
        this.m = -9223372036854775807L;
        d4.G.a(this.f);
        this.g.d();
        this.h.d();
        this.i.d();
        this.j.d();
        this.k.d();
        a aVar = this.d;
        if (aVar != null) {
            aVar.f();
        }
    }

    public void e(long j, int i) {
        if (j != -9223372036854775807L) {
            this.m = j;
        }
    }

    public void f(d3.k kVar, I.d dVar) {
        dVar.a();
        this.b = dVar.b();
        d3.w e = kVar.e(dVar.c(), 2);
        this.c = e;
        this.d = new a(e);
        this.a.b(kVar, dVar);
    }

    public final void j(long j, int i, int i2, long j2) {
        this.d.g(j, i, i2, j2, this.e);
        if (!this.e) {
            this.g.e(i2);
            this.h.e(i2);
            this.i.e(i2);
        }
        this.j.e(i2);
        this.k.e(i2);
    }

    public void d() {
    }
}
