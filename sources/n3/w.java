package n3;

import d4.L;
import d4.M;
import d4.Z;
import n3.I;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class w implements I {
    public final m a;
    public final L b = new L(new byte[10]);
    public int c = 0;
    public int d;
    public Z e;
    public boolean f;
    public boolean g;
    public boolean h;
    public int i;
    public int j;
    public boolean k;
    public long l;

    public w(m mVar) {
        this.a = mVar;
    }

    public void a(Z z, d3.k kVar, I.d dVar) {
        this.e = z;
        this.a.f(kVar, dVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x007a -> B:12:0x007c). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b(d4.M r8, int r9) {
        /*
            r7 = this;
            d4.Z r0 = r7.e
            d4.a.i(r0)
            r0 = r9 & 1
            r1 = -1
            r2 = 3
            r3 = 2
            r4 = 1
            if (r0 == 0) goto L47
            int r0 = r7.c
            if (r0 == 0) goto L44
            if (r0 == r4) goto L44
            java.lang.String r5 = "PesReader"
            if (r0 == r3) goto L3f
            if (r0 != r2) goto L39
            int r0 = r7.j
            if (r0 == r1) goto L7c
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r6 = "Unexpected start indicator: expected "
            r0.append(r6)
            int r6 = r7.j
            r0.append(r6)
            java.lang.String r6 = " more bytes"
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            d4.B.j(r5, r0)
            goto L7c
        L39:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            r8.<init>()
            throw r8
        L3f:
            java.lang.String r0 = "Unexpected start indicator reading extended header"
            d4.B.j(r5, r0)
        L44:
            r7.g(r4)
        L47:
            int r0 = r8.a()
            if (r0 <= 0) goto Ld8
            int r0 = r7.c
            if (r0 == 0) goto Lcf
            r5 = 0
            if (r0 == r4) goto Lb7
            if (r0 == r3) goto L88
            if (r0 != r2) goto L82
            int r0 = r8.a()
            int r6 = r7.j
            if (r6 != r1) goto L61
            goto L63
        L61:
            int r5 = r0 - r6
        L63:
            if (r5 <= 0) goto L6e
            int r0 = r0 - r5
            int r5 = r8.f()
            int r5 = r5 + r0
            r8.T(r5)
        L6e:
            n3.m r5 = r7.a
            r5.b(r8)
            int r5 = r7.j
            if (r5 == r1) goto L47
            int r5 = r5 - r0
            r7.j = r5
            if (r5 != 0) goto L47
        L7c:
            n3.m r0 = r7.a
            r0.d()
            goto L44
        L82:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            r8.<init>()
            throw r8
        L88:
            r0 = 10
            int r6 = r7.i
            int r0 = java.lang.Math.min(r0, r6)
            d4.L r6 = r7.b
            byte[] r6 = r6.a
            boolean r0 = r7.d(r8, r6, r0)
            if (r0 == 0) goto L47
            r0 = 0
            int r6 = r7.i
            boolean r0 = r7.d(r8, r0, r6)
            if (r0 == 0) goto L47
            r7.f()
            boolean r0 = r7.k
            if (r0 == 0) goto Lab
            r5 = 4
        Lab:
            r9 = r9 | r5
            n3.m r0 = r7.a
            long r5 = r7.l
            r0.e(r5, r9)
            r7.g(r2)
            goto L47
        Lb7:
            d4.L r0 = r7.b
            byte[] r0 = r0.a
            r6 = 9
            boolean r0 = r7.d(r8, r0, r6)
            if (r0 == 0) goto L47
            boolean r0 = r7.e()
            if (r0 == 0) goto Lca
            r5 = 2
        Lca:
            r7.g(r5)
            goto L47
        Lcf:
            int r0 = r8.a()
            r8.V(r0)
            goto L47
        Ld8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: n3.w.b(d4.M, int):void");
    }

    public final void c() {
        this.c = 0;
        this.d = 0;
        this.h = false;
        this.a.c();
    }

    public final boolean d(M m, byte[] bArr, int i) {
        int min = Math.min(m.a(), i - this.d);
        if (min <= 0) {
            return true;
        }
        if (bArr == null) {
            m.V(min);
        } else {
            m.l(bArr, this.d, min);
        }
        int i2 = this.d + min;
        this.d = i2;
        return i2 == i;
    }

    public final boolean e() {
        this.b.p(0);
        int h = this.b.h(24);
        if (h != 1) {
            d4.B.j("PesReader", "Unexpected start code prefix: " + h);
            this.j = -1;
            return false;
        }
        this.b.r(8);
        int h2 = this.b.h(16);
        this.b.r(5);
        this.k = this.b.g();
        this.b.r(2);
        this.f = this.b.g();
        this.g = this.b.g();
        this.b.r(6);
        int h3 = this.b.h(8);
        this.i = h3;
        if (h2 == 0) {
            this.j = -1;
        } else {
            int i = (h2 - 3) - h3;
            this.j = i;
            if (i < 0) {
                d4.B.j("PesReader", "Found negative packet payload size: " + this.j);
                this.j = -1;
            }
        }
        return true;
    }

    public final void f() {
        this.b.p(0);
        this.l = -9223372036854775807L;
        if (this.f) {
            this.b.r(4);
            this.b.r(1);
            this.b.r(1);
            long h = (this.b.h(3) << 30) | (this.b.h(15) << 15) | this.b.h(15);
            this.b.r(1);
            if (!this.h && this.g) {
                this.b.r(4);
                this.b.r(1);
                this.b.r(1);
                this.b.r(1);
                this.e.b((this.b.h(3) << 30) | (this.b.h(15) << 15) | this.b.h(15));
                this.h = true;
            }
            this.l = this.e.b(h);
        }
    }

    public final void g(int i) {
        this.c = i;
        this.d = 0;
    }
}
