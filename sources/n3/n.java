package n3;

import d4.M;
import java.util.Arrays;
import n3.I;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class n implements m {
    public static final double[] q = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};
    public String a;
    public d3.w b;
    public final K c;
    public final M d;
    public final u e;
    public final boolean[] f;
    public final a g;
    public long h;
    public boolean i;
    public boolean j;
    public long k;
    public long l;
    public long m;
    public long n;
    public boolean o;
    public boolean p;

    public static final class a {
        public static final byte[] e = {0, 0, 1};
        public boolean a;
        public int b;
        public int c;
        public byte[] d;

        public a(int i) {
            this.d = new byte[i];
        }

        public void a(byte[] bArr, int i, int i2) {
            if (this.a) {
                int i3 = i2 - i;
                byte[] bArr2 = this.d;
                int length = bArr2.length;
                int i4 = this.b;
                if (length < i4 + i3) {
                    this.d = Arrays.copyOf(bArr2, (i4 + i3) * 2);
                }
                System.arraycopy(bArr, i, this.d, this.b, i3);
                this.b += i3;
            }
        }

        public boolean b(int i, int i2) {
            if (this.a) {
                int i3 = this.b - i2;
                this.b = i3;
                if (this.c != 0 || i != 181) {
                    this.a = false;
                    return true;
                }
                this.c = i3;
            } else if (i == 179) {
                this.a = true;
            }
            byte[] bArr = e;
            a(bArr, 0, bArr.length);
            return false;
        }

        public void c() {
            this.a = false;
            this.b = 0;
            this.c = 0;
        }
    }

    public n() {
        this(null);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0073  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.util.Pair a(n3.n.a r8, java.lang.String r9) {
        /*
            byte[] r0 = r8.d
            int r1 = r8.b
            byte[] r0 = java.util.Arrays.copyOf(r0, r1)
            r1 = 4
            r2 = r0[r1]
            r2 = r2 & 255(0xff, float:3.57E-43)
            r3 = 5
            r4 = r0[r3]
            r5 = r4 & 255(0xff, float:3.57E-43)
            r6 = 6
            r6 = r0[r6]
            r6 = r6 & 255(0xff, float:3.57E-43)
            int r2 = r2 << r1
            int r5 = r5 >> r1
            r2 = r2 | r5
            r4 = r4 & 15
            int r4 = r4 << 8
            r4 = r4 | r6
            r5 = 7
            r6 = r0[r5]
            r6 = r6 & 240(0xf0, float:3.36E-43)
            int r6 = r6 >> r1
            r7 = 2
            if (r6 == r7) goto L3e
            r7 = 3
            if (r6 == r7) goto L38
            if (r6 == r1) goto L30
            r1 = 1065353216(0x3f800000, float:1.0)
            goto L44
        L30:
            int r1 = r4 * 121
            float r1 = (float) r1
            int r6 = r2 * 100
        L35:
            float r6 = (float) r6
            float r1 = r1 / r6
            goto L44
        L38:
            int r1 = r4 * 16
            float r1 = (float) r1
            int r6 = r2 * 9
            goto L35
        L3e:
            int r1 = r4 * 4
            float r1 = (float) r1
            int r6 = r2 * 3
            goto L35
        L44:
            O2.z0$b r6 = new O2.z0$b
            r6.<init>()
            O2.z0$b r9 = r6.U(r9)
            java.lang.String r6 = "video/mpeg2"
            O2.z0$b r9 = r9.g0(r6)
            O2.z0$b r9 = r9.n0(r2)
            O2.z0$b r9 = r9.S(r4)
            O2.z0$b r9 = r9.c0(r1)
            java.util.List r1 = java.util.Collections.singletonList(r0)
            O2.z0$b r9 = r9.V(r1)
            O2.z0 r9 = r9.G()
            r1 = r0[r5]
            r1 = r1 & 15
            int r1 = r1 + (-1)
            if (r1 < 0) goto L99
            double[] r2 = n3.n.q
            int r4 = r2.length
            if (r1 >= r4) goto L99
            r1 = r2[r1]
            int r8 = r8.c
            int r8 = r8 + 9
            r8 = r0[r8]
            r0 = r8 & 96
            int r0 = r0 >> r3
            r8 = r8 & 31
            if (r0 == r8) goto L91
            double r3 = (double) r0
            r5 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r3 = r3 + r5
            int r8 = r8 + 1
            double r5 = (double) r8
            double r3 = r3 / r5
            double r1 = r1 * r3
        L91:
            r3 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            double r3 = r3 / r1
            long r0 = (long) r3
            goto L9b
        L99:
            r0 = 0
        L9b:
            java.lang.Long r8 = java.lang.Long.valueOf(r0)
            android.util.Pair r8 = android.util.Pair.create(r9, r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: n3.n.a(n3.n$a, java.lang.String):android.util.Pair");
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0112  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b(d4.M r21) {
        /*
            Method dump skipped, instructions count: 328
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: n3.n.b(d4.M):void");
    }

    public void c() {
        d4.G.a(this.f);
        this.g.c();
        u uVar = this.e;
        if (uVar != null) {
            uVar.d();
        }
        this.h = 0L;
        this.i = false;
        this.l = -9223372036854775807L;
        this.n = -9223372036854775807L;
    }

    public void e(long j, int i) {
        this.l = j;
    }

    public void f(d3.k kVar, I.d dVar) {
        dVar.a();
        this.a = dVar.b();
        this.b = kVar.e(dVar.c(), 2);
        K k = this.c;
        if (k != null) {
            k.b(kVar, dVar);
        }
    }

    public n(K k) {
        M m;
        this.c = k;
        this.f = new boolean[4];
        this.g = new a(128);
        if (k != null) {
            this.e = new u(178, 128);
            m = new M();
        } else {
            m = null;
            this.e = null;
        }
        this.d = m;
        this.l = -9223372036854775807L;
        this.n = -9223372036854775807L;
    }

    public void d() {
    }
}
