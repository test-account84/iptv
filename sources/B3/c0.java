package B3;

import B3.J;
import B3.z;
import O2.A0;
import O2.H1;
import O2.z0;
import b4.F;
import b4.G;
import b4.o;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class c0 implements z, G.b {
    public final b4.s a;
    public final o.a c;
    public final b4.S d;
    public final b4.F e;
    public final J.a f;
    public final i0 g;
    public final long i;
    public final z0 k;
    public final boolean l;
    public boolean m;
    public byte[] n;
    public int o;
    public final ArrayList h = new ArrayList();
    public final b4.G j = new b4.G("SingleSampleMediaPeriod");

    public final class b implements Y {
        public int a;
        public boolean c;

        public b() {
        }

        public void a() {
            c0 c0Var = c0.this;
            if (c0Var.l) {
                return;
            }
            c0Var.j.a();
        }

        public final void b() {
            if (this.c) {
                return;
            }
            c0.a(c0.this).h(d4.F.k(c0.this.k.m), c0.this.k, 0, null, 0L);
            this.c = true;
        }

        public void c() {
            if (this.a == 2) {
                this.a = 1;
            }
        }

        public boolean e() {
            return c0.this.m;
        }

        public int n(long j) {
            b();
            if (j <= 0 || this.a == 2) {
                return 0;
            }
            this.a = 2;
            return 1;
        }

        public int q(A0 a0, U2.g gVar, int i) {
            b();
            c0 c0Var = c0.this;
            boolean z = c0Var.m;
            if (z && c0Var.n == null) {
                this.a = 2;
            }
            int i2 = this.a;
            if (i2 == 2) {
                gVar.addFlag(4);
                return -4;
            }
            if ((i & 2) != 0 || i2 == 0) {
                a0.b = c0Var.k;
                this.a = 1;
                return -5;
            }
            if (!z) {
                return -3;
            }
            d4.a.e(c0Var.n);
            gVar.addFlag(1);
            gVar.f = 0L;
            if ((i & 4) == 0) {
                gVar.e(c0.this.o);
                ByteBuffer byteBuffer = gVar.d;
                c0 c0Var2 = c0.this;
                byteBuffer.put(c0Var2.n, 0, c0Var2.o);
            }
            if ((i & 1) == 0) {
                this.a = 2;
            }
            return -4;
        }

        public /* synthetic */ b(c0 c0Var, a aVar) {
            this();
        }
    }

    public c0(b4.s sVar, o.a aVar, b4.S s, z0 z0Var, long j, b4.F f, J.a aVar2, boolean z) {
        this.a = sVar;
        this.c = aVar;
        this.d = s;
        this.k = z0Var;
        this.i = j;
        this.e = f;
        this.f = aVar2;
        this.l = z;
        this.g = new i0(new g0(z0Var));
    }

    public static /* synthetic */ J.a a(c0 c0Var) {
        return c0Var.f;
    }

    public boolean b() {
        return this.j.j();
    }

    public long c() {
        return (this.m || this.j.j()) ? Long.MIN_VALUE : 0L;
    }

    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void t(c cVar, long j, long j2, boolean z) {
        b4.P b2 = c.b(cVar);
        u uVar = new u(cVar.a, cVar.c, b2.t(), b2.u(), j, j2, b2.j());
        this.e.d(cVar.a);
        this.f.q(uVar, 1, -1, null, 0, null, 0L, this.i);
    }

    public boolean f(long j) {
        if (this.m || this.j.j() || this.j.i()) {
            return false;
        }
        b4.o a2 = this.c.a();
        b4.S s = this.d;
        if (s != null) {
            a2.g(s);
        }
        c cVar = new c(this.a, a2);
        this.f.z(new u(cVar.a, this.a, this.j.n(cVar, this, this.e.b(1))), 1, -1, this.k, 0, null, 0L, this.i);
        return true;
    }

    public long g() {
        return this.m ? Long.MIN_VALUE : 0L;
    }

    public long i(Z3.s[] sVarArr, boolean[] zArr, Y[] yArr, boolean[] zArr2, long j) {
        for (int i = 0; i < sVarArr.length; i++) {
            Y y = yArr[i];
            if (y != null && (sVarArr[i] == null || !zArr[i])) {
                this.h.remove(y);
                yArr[i] = null;
            }
            if (yArr[i] == null && sVarArr[i] != null) {
                b bVar = new b(this, null);
                this.h.add(bVar);
                yArr[i] = bVar;
                zArr2[i] = true;
            }
        }
        return j;
    }

    public /* synthetic */ List k(List list) {
        return y.a(this, list);
    }

    public long l(long j) {
        for (int i = 0; i < this.h.size(); i++) {
            ((b) this.h.get(i)).c();
        }
        return j;
    }

    public long m() {
        return -9223372036854775807L;
    }

    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public void W(c cVar, long j, long j2) {
        this.o = (int) c.b(cVar).j();
        this.n = (byte[]) d4.a.e(c.d(cVar));
        this.m = true;
        b4.P b2 = c.b(cVar);
        u uVar = new u(cVar.a, cVar.c, b2.t(), b2.u(), j, j2, this.o);
        this.e.d(cVar.a);
        this.f.t(uVar, 1, -1, this.k, 0, null, 0L, this.i);
    }

    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public G.c j(c cVar, long j, long j2, IOException iOException, int i) {
        G.c h;
        b4.P b2 = c.b(cVar);
        u uVar = new u(cVar.a, cVar.c, b2.t(), b2.u(), j, j2, b2.j());
        long c2 = this.e.c(new F.c(uVar, new x(1, -1, this.k, 0, null, 0L, d4.k0.x1(this.i)), iOException, i));
        boolean z = c2 == -9223372036854775807L || i >= this.e.b(1);
        if (this.l && z) {
            d4.B.k("SingleSampleMediaPeriod", "Loading failed, treating as end-of-stream.", iOException);
            this.m = true;
            h = b4.G.f;
        } else {
            h = c2 != -9223372036854775807L ? b4.G.h(false, c2) : b4.G.g;
        }
        G.c cVar2 = h;
        boolean z2 = !cVar2.c();
        this.f.v(uVar, 1, -1, this.k, 0, null, 0L, this.i, iOException, z2);
        if (z2) {
            this.e.d(cVar.a);
        }
        return cVar2;
    }

    public void q() {
        this.j.l();
    }

    public void s(z.a aVar, long j) {
        aVar.e(this);
    }

    public i0 u() {
        return this.g;
    }

    public static final class c implements G.e {
        public final long a = u.a();
        public final b4.s c;
        public final b4.P d;
        public byte[] e;

        public c(b4.s sVar, b4.o oVar) {
            this.c = sVar;
            this.d = new b4.P(oVar);
        }

        public static /* synthetic */ b4.P b(c cVar) {
            return cVar.d;
        }

        public static /* synthetic */ byte[] d(c cVar) {
            return cVar.e;
        }

        public void a() {
            this.d.v();
            try {
                this.d.a(this.c);
                int i = 0;
                while (i != -1) {
                    int j = (int) this.d.j();
                    byte[] bArr = this.e;
                    if (bArr == null) {
                        this.e = new byte[1024];
                    } else if (j == bArr.length) {
                        this.e = Arrays.copyOf(bArr, bArr.length * 2);
                    }
                    b4.P p = this.d;
                    byte[] bArr2 = this.e;
                    i = p.read(bArr2, j, bArr2.length - j);
                }
                b4.r.a(this.d);
            } catch (Throwable th) {
                b4.r.a(this.d);
                throw th;
            }
        }

        public void c() {
        }
    }

    public void p() {
    }

    public void h(long j) {
    }

    public long d(long j, H1 h1) {
        return j;
    }

    public void v(long j, boolean z) {
    }
}
