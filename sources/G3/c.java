package g3;

import com.google.android.exoplayer2.extractor.FlacStreamMetadata;
import com.google.android.exoplayer2.extractor.d;
import com.google.android.exoplayer2.extractor.e;
import com.google.android.exoplayer2.extractor.g;
import d3.i;
import d3.j;
import d3.k;
import d3.o;
import d3.p;
import d3.t;
import d3.w;
import d4.M;
import d4.k0;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class c implements i {
    public static final o o = new b();
    public final byte[] a;
    public final M b;
    public final boolean c;
    public final p.a d;
    public k e;
    public w f;
    public int g;
    public q3.a h;
    public FlacStreamMetadata i;
    public int j;
    public int k;
    public a l;
    public int m;
    public long n;

    public c() {
        this(0);
    }

    public static /* synthetic */ i[] c() {
        return j();
    }

    private static /* synthetic */ i[] j() {
        return new i[]{new c()};
    }

    public void a(long j, long j2) {
        if (j == 0) {
            this.g = 0;
        } else {
            a aVar = this.l;
            if (aVar != null) {
                aVar.h(j2);
            }
        }
        this.n = j2 != 0 ? -1L : 0L;
        this.m = 0;
        this.b.Q(0);
    }

    public void b(k kVar) {
        this.e = kVar;
        this.f = kVar.e(0, 1);
        kVar.q();
    }

    public int d(j jVar, t tVar) {
        int i = this.g;
        if (i == 0) {
            m(jVar);
            return 0;
        }
        if (i == 1) {
            i(jVar);
            return 0;
        }
        if (i == 2) {
            o(jVar);
            return 0;
        }
        if (i == 3) {
            n(jVar);
            return 0;
        }
        if (i == 4) {
            f(jVar);
            return 0;
        }
        if (i == 5) {
            return l(jVar, tVar);
        }
        throw new IllegalStateException();
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0020, code lost:
    
        r5.U(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0027, code lost:
    
        return r4.d.a;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long e(d4.M r5, boolean r6) {
        /*
            r4 = this;
            com.google.android.exoplayer2.extractor.FlacStreamMetadata r0 = r4.i
            d4.a.e(r0)
            int r0 = r5.f()
        L9:
            int r1 = r5.g()
            int r1 = r1 + (-16)
            if (r0 > r1) goto L2b
            r5.U(r0)
            com.google.android.exoplayer2.extractor.FlacStreamMetadata r1 = r4.i
            int r2 = r4.k
            d3.p$a r3 = r4.d
            boolean r1 = d3.p.d(r5, r1, r2, r3)
            if (r1 == 0) goto L28
        L20:
            r5.U(r0)
            d3.p$a r5 = r4.d
            long r5 = r5.a
            return r5
        L28:
            int r0 = r0 + 1
            goto L9
        L2b:
            if (r6 == 0) goto L61
        L2d:
            int r6 = r5.g()
            int r1 = r4.j
            int r6 = r6 - r1
            if (r0 > r6) goto L59
            r5.U(r0)
            r6 = 0
            com.google.android.exoplayer2.extractor.FlacStreamMetadata r1 = r4.i     // Catch: java.lang.IndexOutOfBoundsException -> L45
            int r2 = r4.k     // Catch: java.lang.IndexOutOfBoundsException -> L45
            d3.p$a r3 = r4.d     // Catch: java.lang.IndexOutOfBoundsException -> L45
            boolean r1 = d3.p.d(r5, r1, r2, r3)     // Catch: java.lang.IndexOutOfBoundsException -> L45
            goto L47
        L45:
            r1 = 0
        L47:
            int r2 = r5.f()
            int r3 = r5.g()
            if (r2 <= r3) goto L52
            goto L53
        L52:
            r6 = r1
        L53:
            if (r6 == 0) goto L56
            goto L20
        L56:
            int r0 = r0 + 1
            goto L2d
        L59:
            int r6 = r5.g()
            r5.U(r6)
            goto L64
        L61:
            r5.U(r0)
        L64:
            r5 = -1
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: g3.c.e(d4.M, boolean):long");
    }

    public final void f(j jVar) {
        this.k = d.b(jVar);
        ((k) k0.j(this.e)).n(g(jVar.getPosition(), jVar.getLength()));
        this.g = 5;
    }

    public final g g(long j, long j2) {
        d4.a.e(this.i);
        FlacStreamMetadata flacStreamMetadata = this.i;
        if (flacStreamMetadata.seekTable != null) {
            return new e(flacStreamMetadata, j);
        }
        if (j2 == -1 || flacStreamMetadata.totalSamples <= 0) {
            return new g.b(flacStreamMetadata.getDurationUs());
        }
        a aVar = new a(flacStreamMetadata, this.k, j, j2);
        this.l = aVar;
        return aVar.b();
    }

    public boolean h(j jVar) {
        d.c(jVar, false);
        return d.a(jVar);
    }

    public final void i(j jVar) {
        byte[] bArr = this.a;
        jVar.s(bArr, 0, bArr.length);
        jVar.f();
        this.g = 2;
    }

    public final void k() {
        ((w) k0.j(this.f)).f((this.n * 1000000) / ((FlacStreamMetadata) k0.j(this.i)).sampleRate, 1, this.m, 0, null);
    }

    public final int l(j jVar, t tVar) {
        boolean z;
        d4.a.e(this.f);
        d4.a.e(this.i);
        a aVar = this.l;
        if (aVar != null && aVar.d()) {
            return this.l.c(jVar, tVar);
        }
        if (this.n == -1) {
            this.n = p.i(jVar, this.i);
            return 0;
        }
        int g = this.b.g();
        if (g < 32768) {
            int read = jVar.read(this.b.e(), g, 32768 - g);
            z = read == -1;
            if (!z) {
                this.b.T(g + read);
            } else if (this.b.a() == 0) {
                k();
                return -1;
            }
        } else {
            z = false;
        }
        int f = this.b.f();
        int i = this.m;
        int i2 = this.j;
        if (i < i2) {
            M m = this.b;
            m.V(Math.min(i2 - i, m.a()));
        }
        long e = e(this.b, z);
        int f2 = this.b.f() - f;
        this.b.U(f);
        this.f.b(this.b, f2);
        this.m += f2;
        if (e != -1) {
            k();
            this.m = 0;
            this.n = e;
        }
        if (this.b.a() < 16) {
            int a = this.b.a();
            System.arraycopy(this.b.e(), this.b.f(), this.b.e(), 0, a);
            this.b.U(0);
            this.b.T(a);
        }
        return 0;
    }

    public final void m(j jVar) {
        this.h = d.d(jVar, !this.c);
        this.g = 1;
    }

    public final void n(j jVar) {
        d.a aVar = new d.a(this.i);
        boolean z = false;
        while (!z) {
            z = d.e(jVar, aVar);
            this.i = (FlacStreamMetadata) k0.j(aVar.a);
        }
        d4.a.e(this.i);
        this.j = Math.max(this.i.minFrameSize, 6);
        ((w) k0.j(this.f)).d(this.i.getFormat(this.a, this.h));
        this.g = 4;
    }

    public final void o(j jVar) {
        d.i(jVar);
        this.g = 3;
    }

    public c(int i) {
        this.a = new byte[42];
        this.b = new M(new byte[32768], 0);
        this.c = (i & 1) != 0;
        this.d = new p.a();
        this.g = 0;
    }

    public void release() {
    }
}
