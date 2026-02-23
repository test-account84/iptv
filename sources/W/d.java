package w;

import java.util.Arrays;
import java.util.HashMap;
import w.i;
import x.d;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class d {
    public static int q = 1000;
    public static boolean r = true;
    public static long s;
    public static long t;
    public a c;
    public w.b[] f;
    public final c m;
    public a p;
    public int a = 0;
    public HashMap b = null;
    public int d = 32;
    public int e = 32;
    public boolean g = false;
    public boolean h = false;
    public boolean[] i = new boolean[32];
    public int j = 1;
    public int k = 0;
    public int l = 32;
    public i[] n = new i[q];
    public int o = 0;

    public interface a {
        i a(d dVar, boolean[] zArr);

        void b(a aVar);

        void c(i iVar);

        void clear();

        i getKey();
    }

    public class b extends w.b {
        public b(c cVar) {
            this.e = new j(this, cVar);
        }
    }

    public d() {
        this.f = null;
        this.f = new w.b[32];
        C();
        c cVar = new c();
        this.m = cVar;
        this.c = new h(cVar);
        this.p = r ? new b(cVar) : new w.b(cVar);
    }

    public static w.b s(d dVar, i iVar, i iVar2, float f) {
        return dVar.r().j(iVar, iVar2, f);
    }

    public static e w() {
        return null;
    }

    public void A(a aVar) {
        u(aVar);
        B(aVar, false);
        n();
    }

    public final int B(a aVar, boolean z) {
        for (int i = 0; i < this.j; i++) {
            this.i[i] = false;
        }
        boolean z2 = false;
        int i2 = 0;
        while (!z2) {
            i2++;
            if (i2 >= this.j * 2) {
                return i2;
            }
            if (aVar.getKey() != null) {
                this.i[aVar.getKey().c] = true;
            }
            i a2 = aVar.a(this, this.i);
            if (a2 != null) {
                boolean[] zArr = this.i;
                int i3 = a2.c;
                if (zArr[i3]) {
                    return i2;
                }
                zArr[i3] = true;
            }
            if (a2 != null) {
                float f = Float.MAX_VALUE;
                int i4 = -1;
                for (int i5 = 0; i5 < this.k; i5++) {
                    w.b bVar = this.f[i5];
                    if (bVar.a.j != i.a.UNRESTRICTED && !bVar.f && bVar.t(a2)) {
                        float f2 = bVar.e.f(a2);
                        if (f2 < 0.0f) {
                            float f3 = (-bVar.b) / f2;
                            if (f3 < f) {
                                i4 = i5;
                                f = f3;
                            }
                        }
                    }
                }
                if (i4 > -1) {
                    w.b bVar2 = this.f[i4];
                    bVar2.a.d = -1;
                    bVar2.y(a2);
                    i iVar = bVar2.a;
                    iVar.d = i4;
                    iVar.g(bVar2);
                }
            } else {
                z2 = true;
            }
        }
        return i2;
    }

    public final void C() {
        int i = 0;
        if (r) {
            while (true) {
                w.b[] bVarArr = this.f;
                if (i >= bVarArr.length) {
                    return;
                }
                w.b bVar = bVarArr[i];
                if (bVar != null) {
                    this.m.a.a(bVar);
                }
                this.f[i] = null;
                i++;
            }
        } else {
            while (true) {
                w.b[] bVarArr2 = this.f;
                if (i >= bVarArr2.length) {
                    return;
                }
                w.b bVar2 = bVarArr2[i];
                if (bVar2 != null) {
                    this.m.b.a(bVar2);
                }
                this.f[i] = null;
                i++;
            }
        }
    }

    public void D() {
        c cVar;
        int i = 0;
        while (true) {
            cVar = this.m;
            i[] iVarArr = cVar.d;
            if (i >= iVarArr.length) {
                break;
            }
            i iVar = iVarArr[i];
            if (iVar != null) {
                iVar.d();
            }
            i++;
        }
        cVar.c.c(this.n, this.o);
        this.o = 0;
        Arrays.fill(this.m.d, (Object) null);
        HashMap hashMap = this.b;
        if (hashMap != null) {
            hashMap.clear();
        }
        this.a = 0;
        this.c.clear();
        this.j = 1;
        for (int i2 = 0; i2 < this.k; i2++) {
            this.f[i2].c = false;
        }
        C();
        this.k = 0;
        this.p = r ? new b(this.m) : new w.b(this.m);
    }

    public final i a(i.a aVar, String str) {
        i iVar = (i) this.m.c.b();
        if (iVar == null) {
            iVar = new i(aVar, str);
        } else {
            iVar.d();
        }
        iVar.f(aVar, str);
        int i = this.o;
        int i2 = q;
        if (i >= i2) {
            int i3 = i2 * 2;
            q = i3;
            this.n = (i[]) Arrays.copyOf(this.n, i3);
        }
        i[] iVarArr = this.n;
        int i4 = this.o;
        this.o = i4 + 1;
        iVarArr[i4] = iVar;
        return iVar;
    }

    public void b(x.e eVar, x.e eVar2, float f, int i) {
        d.b bVar = d.b.LEFT;
        i q2 = q(eVar.k(bVar));
        d.b bVar2 = d.b.TOP;
        i q3 = q(eVar.k(bVar2));
        d.b bVar3 = d.b.RIGHT;
        i q4 = q(eVar.k(bVar3));
        d.b bVar4 = d.b.BOTTOM;
        i q5 = q(eVar.k(bVar4));
        i q6 = q(eVar2.k(bVar));
        i q7 = q(eVar2.k(bVar2));
        i q8 = q(eVar2.k(bVar3));
        i q9 = q(eVar2.k(bVar4));
        w.b r2 = r();
        double d = f;
        double d2 = i;
        r2.q(q3, q5, q7, q9, (float) (Math.sin(d) * d2));
        d(r2);
        w.b r3 = r();
        r3.q(q2, q4, q6, q8, (float) (Math.cos(d) * d2));
        d(r3);
    }

    public void c(i iVar, i iVar2, int i, float f, i iVar3, i iVar4, int i2, int i3) {
        w.b r2 = r();
        r2.h(iVar, iVar2, i, f, iVar3, iVar4, i2);
        if (i3 != 8) {
            r2.d(this, i3);
        }
        d(r2);
    }

    public void d(w.b bVar) {
        i w;
        if (bVar == null) {
            return;
        }
        boolean z = true;
        if (this.k + 1 >= this.l || this.j + 1 >= this.e) {
            y();
        }
        boolean z2 = false;
        if (!bVar.f) {
            bVar.D(this);
            if (bVar.u()) {
                return;
            }
            bVar.r();
            if (bVar.f(this)) {
                i p = p();
                bVar.a = p;
                l(bVar);
                this.p.b(bVar);
                B(this.p, true);
                if (p.d == -1) {
                    if (bVar.a == p && (w = bVar.w(p)) != null) {
                        bVar.y(w);
                    }
                    if (!bVar.f) {
                        bVar.a.g(bVar);
                    }
                    this.k--;
                }
            } else {
                z = false;
            }
            if (!bVar.s()) {
                return;
            } else {
                z2 = z;
            }
        }
        if (z2) {
            return;
        }
        l(bVar);
    }

    public w.b e(i iVar, i iVar2, int i, int i2) {
        if (i2 == 8 && iVar2.g && iVar.d == -1) {
            iVar.e(this, iVar2.f + i);
            return null;
        }
        w.b r2 = r();
        r2.n(iVar, iVar2, i);
        if (i2 != 8) {
            r2.d(this, i2);
        }
        d(r2);
        return r2;
    }

    public void f(i iVar, int i) {
        w.b r2;
        int i2 = iVar.d;
        if (i2 == -1) {
            iVar.e(this, i);
            return;
        }
        if (i2 != -1) {
            w.b bVar = this.f[i2];
            if (!bVar.f) {
                if (bVar.e.i() == 0) {
                    bVar.f = true;
                } else {
                    r2 = r();
                    r2.m(iVar, i);
                }
            }
            bVar.b = i;
            return;
        }
        r2 = r();
        r2.i(iVar, i);
        d(r2);
    }

    public void g(i iVar, i iVar2, int i, boolean z) {
        w.b r2 = r();
        i t2 = t();
        t2.e = 0;
        r2.o(iVar, iVar2, t2, i);
        d(r2);
    }

    public void h(i iVar, i iVar2, int i, int i2) {
        w.b r2 = r();
        i t2 = t();
        t2.e = 0;
        r2.o(iVar, iVar2, t2, i);
        if (i2 != 8) {
            m(r2, (int) (r2.e.f(t2) * (-1.0f)), i2);
        }
        d(r2);
    }

    public void i(i iVar, i iVar2, int i, boolean z) {
        w.b r2 = r();
        i t2 = t();
        t2.e = 0;
        r2.p(iVar, iVar2, t2, i);
        d(r2);
    }

    public void j(i iVar, i iVar2, int i, int i2) {
        w.b r2 = r();
        i t2 = t();
        t2.e = 0;
        r2.p(iVar, iVar2, t2, i);
        if (i2 != 8) {
            m(r2, (int) (r2.e.f(t2) * (-1.0f)), i2);
        }
        d(r2);
    }

    public void k(i iVar, i iVar2, i iVar3, i iVar4, float f, int i) {
        w.b r2 = r();
        r2.k(iVar, iVar2, iVar3, iVar4, f);
        if (i != 8) {
            r2.d(this, i);
        }
        d(r2);
    }

    public final void l(w.b bVar) {
        w.b bVar2;
        f fVar;
        if (r) {
            bVar2 = this.f[this.k];
            if (bVar2 != null) {
                fVar = this.m.a;
                fVar.a(bVar2);
            }
        } else {
            bVar2 = this.f[this.k];
            if (bVar2 != null) {
                fVar = this.m.b;
                fVar.a(bVar2);
            }
        }
        w.b[] bVarArr = this.f;
        int i = this.k;
        bVarArr[i] = bVar;
        i iVar = bVar.a;
        iVar.d = i;
        this.k = i + 1;
        iVar.g(bVar);
    }

    public void m(w.b bVar, int i, int i2) {
        bVar.e(o(i2, null), i);
    }

    public final void n() {
        for (int i = 0; i < this.k; i++) {
            w.b bVar = this.f[i];
            bVar.a.f = bVar.b;
        }
    }

    public i o(int i, String str) {
        if (this.j + 1 >= this.e) {
            y();
        }
        i a2 = a(i.a.ERROR, str);
        int i2 = this.a + 1;
        this.a = i2;
        this.j++;
        a2.c = i2;
        a2.e = i;
        this.m.d[i2] = a2;
        this.c.c(a2);
        return a2;
    }

    public i p() {
        if (this.j + 1 >= this.e) {
            y();
        }
        i a2 = a(i.a.SLACK, null);
        int i = this.a + 1;
        this.a = i;
        this.j++;
        a2.c = i;
        this.m.d[i] = a2;
        return a2;
    }

    public i q(Object obj) {
        i iVar = null;
        if (obj == null) {
            return null;
        }
        if (this.j + 1 >= this.e) {
            y();
        }
        if (obj instanceof x.d) {
            x.d dVar = (x.d) obj;
            iVar = dVar.e();
            if (iVar == null) {
                dVar.l(this.m);
                iVar = dVar.e();
            }
            int i = iVar.c;
            if (i == -1 || i > this.a || this.m.d[i] == null) {
                if (i != -1) {
                    iVar.d();
                }
                int i2 = this.a + 1;
                this.a = i2;
                this.j++;
                iVar.c = i2;
                iVar.j = i.a.UNRESTRICTED;
                this.m.d[i2] = iVar;
            }
        }
        return iVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x001f A[PHI: r0
      0x001f: PHI (r0v6 w.b) = (r0v4 w.b), (r0v11 w.b) binds: [B:11:0x002d, B:4:0x0010] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public w.b r() {
        /*
            r5 = this;
            boolean r0 = w.d.r
            r1 = 1
            if (r0 == 0) goto L23
            w.c r0 = r5.m
            w.f r0 = r0.a
            java.lang.Object r0 = r0.b()
            w.b r0 = (w.b) r0
            if (r0 != 0) goto L1f
            w.d$b r0 = new w.d$b
            w.c r3 = r5.m
            r0.<init>(r3)
            long r3 = w.d.t
            long r3 = r3 + r1
            w.d.t = r3
            goto L3b
        L1f:
            r0.z()
            goto L3b
        L23:
            w.c r0 = r5.m
            w.f r0 = r0.b
            java.lang.Object r0 = r0.b()
            w.b r0 = (w.b) r0
            if (r0 != 0) goto L1f
            w.b r0 = new w.b
            w.c r3 = r5.m
            r0.<init>(r3)
            long r3 = w.d.s
            long r3 = r3 + r1
            w.d.s = r3
        L3b:
            w.i.b()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: w.d.r():w.b");
    }

    public i t() {
        if (this.j + 1 >= this.e) {
            y();
        }
        i a2 = a(i.a.SLACK, null);
        int i = this.a + 1;
        this.a = i;
        this.j++;
        a2.c = i;
        this.m.d[i] = a2;
        return a2;
    }

    public final int u(a aVar) {
        for (int i = 0; i < this.k; i++) {
            w.b bVar = this.f[i];
            if (bVar.a.j != i.a.UNRESTRICTED && bVar.b < 0.0f) {
                boolean z = false;
                int i2 = 0;
                while (!z) {
                    i2++;
                    float f = Float.MAX_VALUE;
                    int i3 = 0;
                    int i4 = -1;
                    int i5 = -1;
                    int i6 = 0;
                    while (true) {
                        if (i3 >= this.k) {
                            break;
                        }
                        w.b bVar2 = this.f[i3];
                        if (bVar2.a.j != i.a.UNRESTRICTED && !bVar2.f && bVar2.b < 0.0f) {
                            for (int i7 = 1; i7 < this.j; i7++) {
                                i iVar = this.m.d[i7];
                                float f2 = bVar2.e.f(iVar);
                                if (f2 > 0.0f) {
                                    for (int i8 = 0; i8 < 9; i8++) {
                                        float f3 = iVar.h[i8] / f2;
                                        if ((f3 < f && i8 == i6) || i8 > i6) {
                                            f = f3;
                                            i4 = i3;
                                            i5 = i7;
                                            i6 = i8;
                                        }
                                    }
                                }
                            }
                        }
                        i3++;
                    }
                    if (i4 != -1) {
                        w.b bVar3 = this.f[i4];
                        bVar3.a.d = -1;
                        bVar3.y(this.m.d[i5]);
                        i iVar2 = bVar3.a;
                        iVar2.d = i4;
                        iVar2.g(bVar3);
                    } else {
                        z = true;
                    }
                    if (i2 > this.j / 2) {
                        z = true;
                    }
                }
                return i2;
            }
        }
        return 0;
    }

    public c v() {
        return this.m;
    }

    public int x(Object obj) {
        i e = ((x.d) obj).e();
        if (e != null) {
            return (int) (e.f + 0.5f);
        }
        return 0;
    }

    public final void y() {
        int i = this.d * 2;
        this.d = i;
        this.f = (w.b[]) Arrays.copyOf(this.f, i);
        c cVar = this.m;
        cVar.d = (i[]) Arrays.copyOf(cVar.d, this.d);
        int i2 = this.d;
        this.i = new boolean[i2];
        this.e = i2;
        this.l = i2;
    }

    public void z() {
        if (this.g || this.h) {
            for (int i = 0; i < this.k; i++) {
                if (this.f[i].f) {
                }
            }
            n();
            return;
        }
        A(this.c);
    }
}
