package o3;

import O2.l1;
import O2.z0;
import android.util.Pair;
import d3.i;
import d3.j;
import d3.k;
import d3.o;
import d3.t;
import d3.w;
import d4.B;
import d4.M;
import d4.k0;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class b implements i {
    public static final o h = new o3.a();
    public k a;
    public w b;
    public b e;
    public int c = 0;
    public long d = -1;
    public int f = -1;
    public long g = -1;

    public static final class a implements b {
        public static final int[] m = {-1, -1, -1, -1, 2, 4, 6, 8, -1, -1, -1, -1, 2, 4, 6, 8};
        public static final int[] n = {7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 19, 21, 23, 25, 28, 31, 34, 37, 41, 45, 50, 55, 60, 66, 73, 80, 88, 97, 107, 118, 130, 143, 157, 173, 190, 209, 230, 253, 279, 307, 337, 371, 408, 449, 494, 544, 598, 658, 724, 796, 876, 963, 1060, 1166, 1282, 1411, 1552, 1707, 1878, 2066, 2272, 2499, 2749, 3024, 3327, 3660, 4026, 4428, 4871, 5358, 5894, 6484, 7132, 7845, 8630, 9493, 10442, 11487, 12635, 13899, 15289, 16818, 18500, 20350, 22385, 24623, 27086, 29794, 32767};
        public final k a;
        public final w b;
        public final o3.c c;
        public final int d;
        public final byte[] e;
        public final M f;
        public final int g;
        public final z0 h;
        public int i;
        public long j;
        public int k;
        public long l;

        public a(k kVar, w wVar, o3.c cVar) {
            this.a = kVar;
            this.b = wVar;
            this.c = cVar;
            int max = Math.max(1, cVar.c / 10);
            this.g = max;
            M m2 = new M(cVar.g);
            m2.z();
            int z = m2.z();
            this.d = z;
            int i = cVar.b;
            int i2 = (((cVar.e - (i * 4)) * 8) / (cVar.f * i)) + 1;
            if (z == i2) {
                int l = k0.l(max, z);
                this.e = new byte[cVar.e * l];
                this.f = new M(l * h(z, i));
                int i3 = ((cVar.c * cVar.e) * 8) / z;
                this.h = new z0.b().g0("audio/raw").I(i3).b0(i3).Y(h(max, i)).J(cVar.b).h0(cVar.c).a0(2).G();
                return;
            }
            throw l1.a("Expected frames per block: " + i2 + "; got: " + z, null);
        }

        public static int h(int i, int i2) {
            return i * 2 * i2;
        }

        public void a(int i, long j) {
            this.a.n(new e(this.c, this.d, i, j));
            this.b.d(this.h);
        }

        /* JADX WARN: Removed duplicated region for block: B:6:0x0021  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:8:0x0036 -> B:3:0x001c). Please report as a decompilation issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean b(d3.j r7, long r8) {
            /*
                r6 = this;
                int r0 = r6.g
                int r1 = r6.k
                int r1 = r6.f(r1)
                int r0 = r0 - r1
                int r1 = r6.d
                int r0 = d4.k0.l(r0, r1)
                o3.c r1 = r6.c
                int r1 = r1.e
                int r0 = r0 * r1
                r1 = 0
                r3 = 1
                int r4 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
                if (r4 != 0) goto L1e
            L1c:
                r1 = 1
                goto L1f
            L1e:
                r1 = 0
            L1f:
                if (r1 != 0) goto L3f
                int r2 = r6.i
                if (r2 >= r0) goto L3f
                int r2 = r0 - r2
                long r4 = (long) r2
                long r4 = java.lang.Math.min(r4, r8)
                int r2 = (int) r4
                byte[] r4 = r6.e
                int r5 = r6.i
                int r2 = r7.read(r4, r5, r2)
                r4 = -1
                if (r2 != r4) goto L39
                goto L1c
            L39:
                int r4 = r6.i
                int r4 = r4 + r2
                r6.i = r4
                goto L1f
            L3f:
                int r7 = r6.i
                o3.c r8 = r6.c
                int r8 = r8.e
                int r7 = r7 / r8
                if (r7 <= 0) goto L77
                byte[] r8 = r6.e
                d4.M r9 = r6.f
                r6.d(r8, r7, r9)
                int r8 = r6.i
                o3.c r9 = r6.c
                int r9 = r9.e
                int r7 = r7 * r9
                int r8 = r8 - r7
                r6.i = r8
                d4.M r7 = r6.f
                int r7 = r7.g()
                d3.w r8 = r6.b
                d4.M r9 = r6.f
                r8.b(r9, r7)
                int r8 = r6.k
                int r8 = r8 + r7
                r6.k = r8
                int r7 = r6.f(r8)
                int r8 = r6.g
                if (r7 < r8) goto L77
                r6.i(r8)
            L77:
                if (r1 == 0) goto L84
                int r7 = r6.k
                int r7 = r6.f(r7)
                if (r7 <= 0) goto L84
                r6.i(r7)
            L84:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: o3.b.a.b(d3.j, long):boolean");
        }

        public void c(long j) {
            this.i = 0;
            this.j = j;
            this.k = 0;
            this.l = 0L;
        }

        public final void d(byte[] bArr, int i, M m2) {
            for (int i2 = 0; i2 < i; i2++) {
                for (int i3 = 0; i3 < this.c.b; i3++) {
                    e(bArr, i2, i3, m2.e());
                }
            }
            int g = g(this.d * i);
            m2.U(0);
            m2.T(g);
        }

        public final void e(byte[] bArr, int i, int i2, byte[] bArr2) {
            o3.c cVar = this.c;
            int i3 = cVar.e;
            int i4 = cVar.b;
            int i5 = (i * i3) + (i2 * 4);
            int i6 = (i4 * 4) + i5;
            int i7 = (i3 / i4) - 4;
            int i8 = (short) (((bArr[i5 + 1] & 255) << 8) | (bArr[i5] & 255));
            int min = Math.min(bArr[i5 + 2] & 255, 88);
            int i9 = n[min];
            int i10 = ((i * this.d * i4) + i2) * 2;
            bArr2[i10] = (byte) (i8 & 255);
            bArr2[i10 + 1] = (byte) (i8 >> 8);
            for (int i11 = 0; i11 < i7 * 2; i11++) {
                byte b = bArr[((i11 / 8) * i4 * 4) + i6 + ((i11 / 2) % 4)];
                int i12 = i11 % 2 == 0 ? b & 15 : (b & 255) >> 4;
                int i13 = ((((i12 & 7) * 2) + 1) * i9) >> 3;
                if ((i12 & 8) != 0) {
                    i13 = -i13;
                }
                i8 = k0.r(i8 + i13, -32768, 32767);
                i10 += i4 * 2;
                bArr2[i10] = (byte) (i8 & 255);
                bArr2[i10 + 1] = (byte) (i8 >> 8);
                int i14 = min + m[i12];
                int[] iArr = n;
                min = k0.r(i14, 0, iArr.length - 1);
                i9 = iArr[min];
            }
        }

        public final int f(int i) {
            return i / (this.c.b * 2);
        }

        public final int g(int i) {
            return h(i, this.c.b);
        }

        public final void i(int i) {
            long c1 = this.j + k0.c1(this.l, 1000000L, this.c.c);
            int g = g(i);
            this.b.f(c1, 1, g, this.k - g, null);
            this.l += i;
            this.k -= g;
        }
    }

    public interface b {
        void a(int i, long j);

        boolean b(j jVar, long j);

        void c(long j);
    }

    public static final class c implements b {
        public final k a;
        public final w b;
        public final o3.c c;
        public final z0 d;
        public final int e;
        public long f;
        public int g;
        public long h;

        public c(k kVar, w wVar, o3.c cVar, String str, int i) {
            this.a = kVar;
            this.b = wVar;
            this.c = cVar;
            int i2 = (cVar.b * cVar.f) / 8;
            if (cVar.e == i2) {
                int i3 = cVar.c;
                int i4 = i3 * i2 * 8;
                int max = Math.max(i2, (i3 * i2) / 10);
                this.e = max;
                this.d = new z0.b().g0(str).I(i4).b0(i4).Y(max).J(cVar.b).h0(cVar.c).a0(i).G();
                return;
            }
            throw l1.a("Expected block size: " + i2 + "; got: " + cVar.e, null);
        }

        public void a(int i, long j) {
            this.a.n(new e(this.c, 1, i, j));
            this.b.d(this.d);
        }

        public boolean b(j jVar, long j) {
            int i;
            int i2;
            long j2 = j;
            while (j2 > 0 && (i = this.g) < (i2 = this.e)) {
                int a = this.b.a(jVar, (int) Math.min(i2 - i, j2), true);
                if (a == -1) {
                    j2 = 0;
                } else {
                    this.g += a;
                    j2 -= a;
                }
            }
            int i3 = this.c.e;
            int i4 = this.g / i3;
            if (i4 > 0) {
                long c1 = this.f + k0.c1(this.h, 1000000L, r1.c);
                int i5 = i4 * i3;
                int i6 = this.g - i5;
                this.b.f(c1, 1, i5, i6, null);
                this.h += i4;
                this.g = i6;
            }
            return j2 <= 0;
        }

        public void c(long j) {
            this.f = j;
            this.g = 0;
            this.h = 0L;
        }
    }

    public static /* synthetic */ i[] c() {
        return f();
    }

    private void e() {
        d4.a.i(this.b);
        k0.j(this.a);
    }

    private static /* synthetic */ i[] f() {
        return new i[]{new b()};
    }

    public void a(long j, long j2) {
        this.c = j == 0 ? 0 : 4;
        b bVar = this.e;
        if (bVar != null) {
            bVar.c(j2);
        }
    }

    public void b(k kVar) {
        this.a = kVar;
        this.b = kVar.e(0, 1);
        kVar.q();
    }

    public int d(j jVar, t tVar) {
        e();
        int i = this.c;
        if (i == 0) {
            g(jVar);
            return 0;
        }
        if (i == 1) {
            j(jVar);
            return 0;
        }
        if (i == 2) {
            i(jVar);
            return 0;
        }
        if (i == 3) {
            l(jVar);
            return 0;
        }
        if (i == 4) {
            return k(jVar);
        }
        throw new IllegalStateException();
    }

    public final void g(j jVar) {
        d4.a.g(jVar.getPosition() == 0);
        int i = this.f;
        if (i != -1) {
            jVar.q(i);
            this.c = 4;
        } else {
            if (!d.a(jVar)) {
                throw l1.a("Unsupported or unrecognized wav file type.", null);
            }
            jVar.q((int) (jVar.k() - jVar.getPosition()));
            this.c = 1;
        }
    }

    public boolean h(j jVar) {
        return d.a(jVar);
    }

    public final void i(j jVar) {
        b cVar;
        o3.c b2 = d.b(jVar);
        int i = b2.a;
        if (i == 17) {
            cVar = new a(this.a, this.b, b2);
        } else if (i == 6) {
            cVar = new c(this.a, this.b, b2, "audio/g711-alaw", -1);
        } else if (i == 7) {
            cVar = new c(this.a, this.b, b2, "audio/g711-mlaw", -1);
        } else {
            int a2 = Q2.k0.a(i, b2.f);
            if (a2 == 0) {
                throw l1.e("Unsupported WAV format type: " + b2.a);
            }
            cVar = new c(this.a, this.b, b2, "audio/raw", a2);
        }
        this.e = cVar;
        this.c = 3;
    }

    public final void j(j jVar) {
        this.d = d.c(jVar);
        this.c = 2;
    }

    public final int k(j jVar) {
        d4.a.g(this.g != -1);
        return ((b) d4.a.e(this.e)).b(jVar, this.g - jVar.getPosition()) ? -1 : 0;
    }

    public final void l(j jVar) {
        Pair e = d.e(jVar);
        this.f = ((Long) e.first).intValue();
        long longValue = ((Long) e.second).longValue();
        long j = this.d;
        if (j != -1 && longValue == 4294967295L) {
            longValue = j;
        }
        this.g = this.f + longValue;
        long length = jVar.getLength();
        if (length != -1 && this.g > length) {
            B.j("WavExtractor", "Data exceeds input length: " + this.g + ", " + length);
            this.g = length;
        }
        ((b) d4.a.e(this.e)).a(this.f, this.g);
        this.c = 4;
    }

    public void release() {
    }
}
