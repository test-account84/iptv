package com.google.android.exoplayer2.source.smoothstreaming;

import D3.e;
import D3.f;
import D3.g;
import D3.k;
import D3.n;
import N3.a;
import O2.H1;
import O2.z0;
import Z3.s;
import android.net.Uri;
import b4.F;
import b4.H;
import b4.S;
import b4.h;
import b4.i;
import b4.o;
import b4.s;
import com.google.android.exoplayer2.source.smoothstreaming.b;
import java.io.IOException;
import java.util.List;
import l3.p;
import s5.A;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class a implements com.google.android.exoplayer2.source.smoothstreaming.b {
    public final H a;
    public final int b;
    public final g[] c;
    public final o d;
    public s e;
    public N3.a f;
    public int g;
    public IOException h;

    public static final class a implements b.a {
        public final o.a a;

        public a(o.a aVar) {
            this.a = aVar;
        }

        public com.google.android.exoplayer2.source.smoothstreaming.b a(H h, N3.a aVar, int i, s sVar, S s, h hVar) {
            o a = this.a.a();
            if (s != null) {
                a.g(s);
            }
            return new a(h, aVar, i, sVar, a, hVar);
        }
    }

    public static final class b extends D3.b {
        public final a.b e;
        public final int f;

        public b(a.b bVar, int i, int i2) {
            super(i2, bVar.k - 1);
            this.e = bVar;
            this.f = i;
        }

        public long a() {
            c();
            return this.e.e((int) d());
        }

        public long b() {
            return a() + this.e.c((int) d());
        }
    }

    public a(H h, N3.a aVar, int i, s sVar, o oVar, h hVar) {
        this.a = h;
        this.f = aVar;
        this.b = i;
        this.e = sVar;
        this.d = oVar;
        a.b bVar = aVar.f[i];
        this.c = new g[sVar.length()];
        for (int i2 = 0; i2 < this.c.length; i2++) {
            int d = sVar.d(i2);
            z0 z0Var = bVar.j[d];
            p[] pVarArr = z0Var.p != null ? ((a.a) d4.a.e(aVar.e)).c : null;
            int i3 = bVar.a;
            this.c[i2] = new e(new l3.g(3, null, new l3.o(d, i3, bVar.c, -9223372036854775807L, aVar.g, z0Var, 0, pVarArr, i3 == 2 ? 4 : 0, null, null)), bVar.a, z0Var);
        }
    }

    public static n k(z0 z0Var, o oVar, Uri uri, int i, long j, long j2, long j3, int i2, Object obj, g gVar, i iVar) {
        return new k(oVar, new s.b().i(uri).e(A.k()).a(), z0Var, i2, obj, j, j2, j3, -9223372036854775807L, i, 1, j, gVar);
    }

    public void a() {
        IOException iOException = this.h;
        if (iOException != null) {
            throw iOException;
        }
        this.a.a();
    }

    public void b(Z3.s sVar) {
        this.e = sVar;
    }

    public long d(long j, H1 h1) {
        a.b bVar = this.f.f[this.b];
        int d = bVar.d(j);
        long e = bVar.e(d);
        return h1.a(j, e, (e >= j || d >= bVar.k + (-1)) ? e : bVar.e(d + 1));
    }

    public boolean e(long j, f fVar, List list) {
        if (this.h != null) {
            return false;
        }
        return this.e.j(j, fVar, list);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void f(N3.a r9) {
        /*
            r8 = this;
            N3.a r0 = r8.f
            N3.a$b[] r0 = r0.f
            int r1 = r8.b
            r0 = r0[r1]
            int r2 = r0.k
            N3.a$b[] r3 = r9.f
            r1 = r3[r1]
            if (r2 == 0) goto L29
            int r3 = r1.k
            if (r3 != 0) goto L15
            goto L29
        L15:
            int r3 = r2 + (-1)
            long r4 = r0.e(r3)
            long r6 = r0.c(r3)
            long r4 = r4 + r6
            r3 = 0
            long r6 = r1.e(r3)
            int r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r1 > 0) goto L2f
        L29:
            int r0 = r8.g
            int r0 = r0 + r2
            r8.g = r0
            goto L38
        L2f:
            int r1 = r8.g
            int r0 = r0.d(r6)
            int r1 = r1 + r0
            r8.g = r1
        L38:
            r8.f = r9
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.smoothstreaming.a.f(N3.a):void");
    }

    public boolean g(f fVar, boolean z, F.c cVar, F f) {
        F.b a2 = f.a(Z3.A.c(this.e), cVar);
        if (z && a2 != null && a2.a == 2) {
            Z3.s sVar = this.e;
            if (sVar.e(sVar.l(fVar.e), a2.b)) {
                return true;
            }
        }
        return false;
    }

    public final void h(long j, long j2, List list, D3.h hVar) {
        int g;
        long j3 = j2;
        if (this.h != null) {
            return;
        }
        a.b bVar = this.f.f[this.b];
        if (bVar.k == 0) {
            hVar.b = !r4.d;
            return;
        }
        if (list.isEmpty()) {
            g = bVar.d(j3);
        } else {
            g = (int) (((n) list.get(list.size() - 1)).g() - this.g);
            if (g < 0) {
                this.h = new B3.b();
                return;
            }
        }
        if (g >= bVar.k) {
            hVar.b = !this.f.d;
            return;
        }
        long j4 = j3 - j;
        long l = l(j);
        int length = this.e.length();
        D3.o[] oVarArr = new D3.o[length];
        for (int i = 0; i < length; i++) {
            oVarArr[i] = new b(bVar, this.e.d(i), g);
        }
        this.e.r(j, j4, l, list, oVarArr);
        long e = bVar.e(g);
        long c = e + bVar.c(g);
        if (!list.isEmpty()) {
            j3 = -9223372036854775807L;
        }
        long j5 = j3;
        int i2 = g + this.g;
        int b2 = this.e.b();
        hVar.a = k(this.e.p(), this.d, bVar.a(this.e.d(b2), g), i2, e, c, j5, this.e.q(), this.e.g(), this.c[b2], null);
    }

    public int j(long j, List list) {
        return (this.h != null || this.e.length() < 2) ? list.size() : this.e.n(j, list);
    }

    public final long l(long j) {
        N3.a aVar = this.f;
        if (!aVar.d) {
            return -9223372036854775807L;
        }
        a.b bVar = aVar.f[this.b];
        int i = bVar.k - 1;
        return (bVar.e(i) + bVar.c(i)) - j;
    }

    public void release() {
        for (g gVar : this.c) {
            gVar.release();
        }
    }

    public void c(f fVar) {
    }
}
