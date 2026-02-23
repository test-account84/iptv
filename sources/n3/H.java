package n3;

import O2.l1;
import com.google.android.exoplayer2.extractor.g;
import d4.L;
import d4.M;
import java.io.EOFException;
import n3.I;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class h implements d3.i {
    public static final d3.o m = new g();
    public final int a;
    public final i b;
    public final M c;
    public final M d;
    public final L e;
    public d3.k f;
    public long g;
    public long h;
    public int i;
    public boolean j;
    public boolean k;
    public boolean l;

    public h() {
        this(0);
    }

    public static /* synthetic */ d3.i[] c() {
        return i();
    }

    private static int f(int i, long j) {
        return (int) ((i * 8000000) / j);
    }

    private com.google.android.exoplayer2.extractor.g g(long j, boolean z) {
        return new com.google.android.exoplayer2.extractor.c(j, this.h, f(this.i, this.b.k()), this.i, z);
    }

    private static /* synthetic */ d3.i[] i() {
        return new d3.i[]{new h()};
    }

    public void a(long j, long j2) {
        this.k = false;
        this.b.c();
        this.g = j2;
    }

    public void b(d3.k kVar) {
        this.f = kVar;
        this.b.f(kVar, new I.d(0, 1));
        kVar.q();
    }

    public int d(d3.j jVar, d3.t tVar) {
        d4.a.i(this.f);
        long length = jVar.getLength();
        int i = this.a;
        if ((i & 2) != 0 || ((i & 1) != 0 && length != -1)) {
            e(jVar);
        }
        int read = jVar.read(this.c.e(), 0, 2048);
        boolean z = read == -1;
        j(length, z);
        if (z) {
            return -1;
        }
        this.c.U(0);
        this.c.T(read);
        if (!this.k) {
            this.b.e(this.g, 4);
            this.k = true;
        }
        this.b.b(this.c);
        return 0;
    }

    public final void e(d3.j jVar) {
        if (this.j) {
            return;
        }
        this.i = -1;
        jVar.f();
        long j = 0;
        if (jVar.getPosition() == 0) {
            k(jVar);
        }
        int i = 0;
        int i2 = 0;
        while (jVar.d(this.d.e(), 0, 2, true)) {
            try {
                this.d.U(0);
                if (!i.m(this.d.N())) {
                    break;
                }
                if (!jVar.d(this.d.e(), 0, 4, true)) {
                    break;
                }
                this.e.p(14);
                int h = this.e.h(13);
                if (h <= 6) {
                    this.j = true;
                    throw l1.a("Malformed ADTS stream", null);
                }
                j += h;
                i2++;
                if (i2 != 1000 && jVar.r(h - 6, true)) {
                }
                break;
            } catch (EOFException unused) {
            }
        }
        i = i2;
        jVar.f();
        if (i > 0) {
            this.i = (int) (j / i);
        } else {
            this.i = -1;
        }
        this.j = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean h(d3.j r9) {
        /*
            r8 = this;
            int r0 = r8.k(r9)
            r1 = 0
            r3 = r0
            r2 = 0
            r4 = 0
        L8:
            d4.M r5 = r8.d
            byte[] r5 = r5.e()
            r6 = 2
            r9.s(r5, r1, r6)
            d4.M r5 = r8.d
            r5.U(r1)
            d4.M r5 = r8.d
            int r5 = r5.N()
            boolean r5 = n3.i.m(r5)
            if (r5 != 0) goto L2e
        L23:
            int r3 = r3 + 1
            r9.f()
            r9.n(r3)
            r2 = 0
            r4 = 0
            goto L5a
        L2e:
            r5 = 1
            int r2 = r2 + r5
            r6 = 4
            if (r2 < r6) goto L38
            r7 = 188(0xbc, float:2.63E-43)
            if (r4 <= r7) goto L38
            return r5
        L38:
            d4.M r5 = r8.d
            byte[] r5 = r5.e()
            r9.s(r5, r1, r6)
            d4.L r5 = r8.e
            r6 = 14
            r5.p(r6)
            d4.L r5 = r8.e
            r6 = 13
            int r5 = r5.h(r6)
            r6 = 6
            if (r5 > r6) goto L54
            goto L23
        L54:
            int r6 = r5 + (-6)
            r9.n(r6)
            int r4 = r4 + r5
        L5a:
            int r5 = r3 - r0
            r6 = 8192(0x2000, float:1.14794E-41)
            if (r5 < r6) goto L8
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: n3.h.h(d3.j):boolean");
    }

    public final void j(long j, boolean z) {
        if (this.l) {
            return;
        }
        boolean z2 = (this.a & 1) != 0 && this.i > 0;
        if (z2 && this.b.k() == -9223372036854775807L && !z) {
            return;
        }
        if (!z2 || this.b.k() == -9223372036854775807L) {
            this.f.n(new g.b(-9223372036854775807L));
        } else {
            this.f.n(g(j, (this.a & 2) != 0));
        }
        this.l = true;
    }

    public final int k(d3.j jVar) {
        int i = 0;
        while (true) {
            jVar.s(this.d.e(), 0, 10);
            this.d.U(0);
            if (this.d.K() != 4801587) {
                break;
            }
            this.d.V(3);
            int G = this.d.G();
            i += G + 10;
            jVar.n(G);
        }
        jVar.f();
        jVar.n(i);
        if (this.h == -1) {
            this.h = i;
        }
        return i;
    }

    public h(int i) {
        this.a = (i & 2) != 0 ? i | 1 : i;
        this.b = new i(true);
        this.c = new M(2048);
        this.i = -1;
        this.h = -1L;
        M m2 = new M(10);
        this.d = m2;
        this.e = new L(m2.e());
    }

    public void release() {
    }
}
