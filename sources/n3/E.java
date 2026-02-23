package n3;

import com.google.android.exoplayer2.extractor.g;
import d4.M;
import n3.I;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class e implements d3.i {
    public static final d3.o d = new d();
    public final f a = new f();
    public final M b = new M(16384);
    public boolean c;

    public static /* synthetic */ d3.i[] c() {
        return e();
    }

    private static /* synthetic */ d3.i[] e() {
        return new d3.i[]{new e()};
    }

    public void a(long j, long j2) {
        this.c = false;
        this.a.c();
    }

    public void b(d3.k kVar) {
        this.a.f(kVar, new I.d(0, 1));
        kVar.q();
        kVar.n(new g.b(-9223372036854775807L));
    }

    public int d(d3.j jVar, d3.t tVar) {
        int read = jVar.read(this.b.e(), 0, 16384);
        if (read == -1) {
            return -1;
        }
        this.b.U(0);
        this.b.T(read);
        if (!this.c) {
            this.a.e(0L, 4);
            this.c = true;
        }
        this.a.b(this.b);
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x003d, code lost:
    
        r9.f();
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0046, code lost:
    
        if ((r4 - r3) < 8192) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0048, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean h(d3.j r9) {
        /*
            r8 = this;
            d4.M r0 = new d4.M
            r1 = 10
            r0.<init>(r1)
            r2 = 0
            r3 = 0
        L9:
            byte[] r4 = r0.e()
            r9.s(r4, r2, r1)
            r0.U(r2)
            int r4 = r0.K()
            r5 = 4801587(0x494433, float:6.728456E-39)
            if (r4 == r5) goto L65
            r9.f()
            r9.n(r3)
            r4 = r3
        L23:
            r1 = 0
        L24:
            byte[] r5 = r0.e()
            r6 = 7
            r9.s(r5, r2, r6)
            r0.U(r2)
            int r5 = r0.N()
            r6 = 44096(0xac40, float:6.1792E-41)
            if (r5 == r6) goto L4d
            r6 = 44097(0xac41, float:6.1793E-41)
            if (r5 == r6) goto L4d
            r9.f()
            int r4 = r4 + 1
            int r1 = r4 - r3
            r5 = 8192(0x2000, float:1.14794E-41)
            if (r1 < r5) goto L49
            return r2
        L49:
            r9.n(r4)
            goto L23
        L4d:
            r6 = 1
            int r1 = r1 + r6
            r7 = 4
            if (r1 < r7) goto L53
            return r6
        L53:
            byte[] r6 = r0.e()
            int r5 = Q2.c.e(r6, r5)
            r6 = -1
            if (r5 != r6) goto L5f
            return r2
        L5f:
            int r5 = r5 + (-7)
            r9.n(r5)
            goto L24
        L65:
            r4 = 3
            r0.V(r4)
            int r4 = r0.G()
            int r5 = r4 + 10
            int r3 = r3 + r5
            r9.n(r4)
            goto L9
        */
        throw new UnsupportedOperationException("Method not decompiled: n3.e.h(d3.j):boolean");
    }

    public void release() {
    }
}
