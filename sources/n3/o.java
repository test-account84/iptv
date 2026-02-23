package n3;

import d4.M;
import d4.k0;
import java.util.Arrays;
import n3.I;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class o implements m {
    public static final float[] l = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 1.0f};
    public final K a;
    public final M b;
    public final u e;
    public b f;
    public long g;
    public String h;
    public d3.w i;
    public boolean j;
    public final boolean[] c = new boolean[4];
    public final a d = new a(128);
    public long k = -9223372036854775807L;

    public static final class a {
        public static final byte[] f = {0, 0, 1};
        public boolean a;
        public int b;
        public int c;
        public int d;
        public byte[] e;

        public a(int i) {
            this.e = new byte[i];
        }

        public void a(byte[] bArr, int i, int i2) {
            if (this.a) {
                int i3 = i2 - i;
                byte[] bArr2 = this.e;
                int length = bArr2.length;
                int i4 = this.c;
                if (length < i4 + i3) {
                    this.e = Arrays.copyOf(bArr2, (i4 + i3) * 2);
                }
                System.arraycopy(bArr, i, this.e, this.c, i3);
                this.c += i3;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0031  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean b(int r9, int r10) {
            /*
                r8 = this;
                int r0 = r8.b
                r1 = 0
                r2 = 1
                if (r0 == 0) goto L4a
                r3 = 181(0xb5, float:2.54E-43)
                r4 = 2
                java.lang.String r5 = "Unexpected start code value"
                java.lang.String r6 = "H263Reader"
                if (r0 == r2) goto L47
                r7 = 3
                if (r0 == r4) goto L3f
                r4 = 4
                if (r0 == r7) goto L2b
                if (r0 != r4) goto L25
                r0 = 179(0xb3, float:2.51E-43)
                if (r9 == r0) goto L1d
                if (r9 != r3) goto L52
            L1d:
                int r9 = r8.c
                int r9 = r9 - r10
                r8.c = r9
                r8.a = r1
                return r2
            L25:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                r9.<init>()
                throw r9
            L2b:
                r9 = r9 & 240(0xf0, float:3.36E-43)
                r10 = 32
                if (r9 == r10) goto L38
            L31:
                d4.B.j(r6, r5)
                r8.c()
                goto L52
            L38:
                int r9 = r8.c
                r8.d = r9
            L3c:
                r8.b = r4
                goto L52
            L3f:
                r10 = 31
                if (r9 <= r10) goto L44
                goto L31
            L44:
                r8.b = r7
                goto L52
            L47:
                if (r9 == r3) goto L3c
                goto L31
            L4a:
                r10 = 176(0xb0, float:2.47E-43)
                if (r9 != r10) goto L52
                r8.b = r2
                r8.a = r2
            L52:
                byte[] r9 = n3.o.a.f
                int r10 = r9.length
                r8.a(r9, r1, r10)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: n3.o.a.b(int, int):boolean");
        }

        public void c() {
            this.a = false;
            this.c = 0;
            this.b = 0;
        }
    }

    public static final class b {
        public final d3.w a;
        public boolean b;
        public boolean c;
        public boolean d;
        public int e;
        public int f;
        public long g;
        public long h;

        public b(d3.w wVar) {
            this.a = wVar;
        }

        public void a(byte[] bArr, int i, int i2) {
            if (this.c) {
                int i3 = this.f;
                int i4 = (i + 1) - i3;
                if (i4 >= i2) {
                    this.f = i3 + (i2 - i);
                } else {
                    this.d = ((bArr[i4] & 192) >> 6) == 0;
                    this.c = false;
                }
            }
        }

        public void b(long j, int i, boolean z) {
            if (this.e == 182 && z && this.b) {
                long j2 = this.h;
                if (j2 != -9223372036854775807L) {
                    this.a.f(j2, this.d ? 1 : 0, (int) (j - this.g), i, null);
                }
            }
            if (this.e != 179) {
                this.g = j;
            }
        }

        public void c(int i, long j) {
            this.e = i;
            this.d = false;
            this.b = i == 182 || i == 179;
            this.c = i == 182;
            this.f = 0;
            this.h = j;
        }

        public void d() {
            this.b = false;
            this.c = false;
            this.d = false;
            this.e = -1;
        }
    }

    public o(K k) {
        M m;
        this.a = k;
        if (k != null) {
            this.e = new u(178, 128);
            m = new M();
        } else {
            m = null;
            this.e = null;
        }
        this.b = m;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static O2.z0 a(n3.o.a r8, int r9, java.lang.String r10) {
        /*
            byte[] r0 = r8.e
            int r8 = r8.c
            byte[] r8 = java.util.Arrays.copyOf(r0, r8)
            d4.L r0 = new d4.L
            r0.<init>(r8)
            r0.s(r9)
            r9 = 4
            r0.s(r9)
            r0.q()
            r1 = 8
            r0.r(r1)
            boolean r2 = r0.g()
            r3 = 3
            if (r2 == 0) goto L29
            r0.r(r9)
            r0.r(r3)
        L29:
            int r9 = r0.h(r9)
            r2 = 1065353216(0x3f800000, float:1.0)
            java.lang.String r4 = "Invalid aspect ratio"
            java.lang.String r5 = "H263Reader"
            r6 = 15
            if (r9 != r6) goto L47
            int r9 = r0.h(r1)
            int r1 = r0.h(r1)
            if (r1 != 0) goto L42
            goto L4f
        L42:
            float r9 = (float) r9
            float r1 = (float) r1
            float r2 = r9 / r1
            goto L52
        L47:
            float[] r1 = n3.o.l
            int r7 = r1.length
            if (r9 >= r7) goto L4f
            r2 = r1[r9]
            goto L52
        L4f:
            d4.B.j(r5, r4)
        L52:
            boolean r9 = r0.g()
            r1 = 2
            if (r9 == 0) goto L89
            r0.r(r1)
            r9 = 1
            r0.r(r9)
            boolean r9 = r0.g()
            if (r9 == 0) goto L89
            r0.r(r6)
            r0.q()
            r0.r(r6)
            r0.q()
            r0.r(r6)
            r0.q()
            r0.r(r3)
            r9 = 11
            r0.r(r9)
            r0.q()
            r0.r(r6)
            r0.q()
        L89:
            int r9 = r0.h(r1)
            if (r9 == 0) goto L94
            java.lang.String r9 = "Unhandled video object layer shape"
            d4.B.j(r5, r9)
        L94:
            r0.q()
            r9 = 16
            int r9 = r0.h(r9)
            r0.q()
            boolean r1 = r0.g()
            if (r1 == 0) goto Lbb
            if (r9 != 0) goto Lae
            java.lang.String r9 = "Invalid vop_increment_time_resolution"
            d4.B.j(r5, r9)
            goto Lbb
        Lae:
            int r9 = r9 + (-1)
            r1 = 0
        Lb1:
            if (r9 <= 0) goto Lb8
            int r1 = r1 + 1
            int r9 = r9 >> 1
            goto Lb1
        Lb8:
            r0.r(r1)
        Lbb:
            r0.q()
            r9 = 13
            int r1 = r0.h(r9)
            r0.q()
            int r9 = r0.h(r9)
            r0.q()
            r0.q()
            O2.z0$b r0 = new O2.z0$b
            r0.<init>()
            O2.z0$b r10 = r0.U(r10)
            java.lang.String r0 = "video/mp4v-es"
            O2.z0$b r10 = r10.g0(r0)
            O2.z0$b r10 = r10.n0(r1)
            O2.z0$b r9 = r10.S(r9)
            O2.z0$b r9 = r9.c0(r2)
            java.util.List r8 = java.util.Collections.singletonList(r8)
            O2.z0$b r8 = r9.V(r8)
            O2.z0 r8 = r8.G()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: n3.o.a(n3.o$a, int, java.lang.String):O2.z0");
    }

    public void b(M m) {
        d4.a.i(this.f);
        d4.a.i(this.i);
        int f = m.f();
        int g = m.g();
        byte[] e = m.e();
        this.g += m.a();
        this.i.b(m, m.a());
        while (true) {
            int c = d4.G.c(e, f, g, this.c);
            if (c == g) {
                break;
            }
            int i = c + 3;
            int i2 = m.e()[i] & 255;
            int i3 = c - f;
            int i4 = 0;
            if (!this.j) {
                if (i3 > 0) {
                    this.d.a(e, f, c);
                }
                if (this.d.b(i2, i3 < 0 ? -i3 : 0)) {
                    d3.w wVar = this.i;
                    a aVar = this.d;
                    wVar.d(a(aVar, aVar.d, (String) d4.a.e(this.h)));
                    this.j = true;
                }
            }
            this.f.a(e, f, c);
            u uVar = this.e;
            if (uVar != null) {
                if (i3 > 0) {
                    uVar.a(e, f, c);
                } else {
                    i4 = -i3;
                }
                if (this.e.b(i4)) {
                    u uVar2 = this.e;
                    ((M) k0.j(this.b)).S(this.e.d, d4.G.q(uVar2.d, uVar2.e));
                    ((K) k0.j(this.a)).a(this.k, this.b);
                }
                if (i2 == 178 && m.e()[c + 2] == 1) {
                    this.e.e(i2);
                }
            }
            int i5 = g - c;
            this.f.b(this.g - i5, i5, this.j);
            this.f.c(i2, this.k);
            f = i;
        }
        if (!this.j) {
            this.d.a(e, f, g);
        }
        this.f.a(e, f, g);
        u uVar3 = this.e;
        if (uVar3 != null) {
            uVar3.a(e, f, g);
        }
    }

    public void c() {
        d4.G.a(this.c);
        this.d.c();
        b bVar = this.f;
        if (bVar != null) {
            bVar.d();
        }
        u uVar = this.e;
        if (uVar != null) {
            uVar.d();
        }
        this.g = 0L;
        this.k = -9223372036854775807L;
    }

    public void e(long j, int i) {
        if (j != -9223372036854775807L) {
            this.k = j;
        }
    }

    public void f(d3.k kVar, I.d dVar) {
        dVar.a();
        this.h = dVar.b();
        d3.w e = kVar.e(dVar.c(), 2);
        this.i = e;
        this.f = new b(e);
        K k = this.a;
        if (k != null) {
            k.b(kVar, dVar);
        }
    }

    public void d() {
    }
}
