package n3;

import d4.M;
import d4.Z;
import d4.k0;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class y {
    public boolean c;
    public boolean d;
    public boolean e;
    public final Z a = new Z(0);
    public long f = -9223372036854775807L;
    public long g = -9223372036854775807L;
    public long h = -9223372036854775807L;
    public final M b = new M();

    public static boolean a(byte[] bArr) {
        return (bArr[0] & 196) == 68 && (bArr[2] & 4) == 4 && (bArr[4] & 4) == 4 && (bArr[5] & 1) == 1 && (bArr[8] & 3) == 3;
    }

    public static long l(M m) {
        int f = m.f();
        if (m.a() < 9) {
            return -9223372036854775807L;
        }
        byte[] bArr = new byte[9];
        m.l(bArr, 0, 9);
        m.U(f);
        if (a(bArr)) {
            return m(bArr);
        }
        return -9223372036854775807L;
    }

    public static long m(byte[] bArr) {
        byte b = bArr[0];
        long j = (((b & 56) >> 3) << 30) | ((b & 3) << 28) | ((bArr[1] & 255) << 20);
        byte b2 = bArr[2];
        return j | (((b2 & 248) >> 3) << 15) | ((b2 & 3) << 13) | ((bArr[3] & 255) << 5) | ((bArr[4] & 248) >> 3);
    }

    public final int b(d3.j jVar) {
        this.b.R(k0.f);
        this.c = true;
        jVar.f();
        return 0;
    }

    public long c() {
        return this.h;
    }

    public Z d() {
        return this.a;
    }

    public boolean e() {
        return this.c;
    }

    public final int f(byte[] bArr, int i) {
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }

    public int g(d3.j jVar, d3.t tVar) {
        if (!this.e) {
            return j(jVar, tVar);
        }
        if (this.g == -9223372036854775807L) {
            return b(jVar);
        }
        if (!this.d) {
            return h(jVar, tVar);
        }
        long j = this.f;
        if (j == -9223372036854775807L) {
            return b(jVar);
        }
        long b = this.a.b(this.g) - this.a.b(j);
        this.h = b;
        if (b < 0) {
            d4.B.j("PsDurationReader", "Invalid duration: " + this.h + ". Using TIME_UNSET instead.");
            this.h = -9223372036854775807L;
        }
        return b(jVar);
    }

    public final int h(d3.j jVar, d3.t tVar) {
        int min = (int) Math.min(20000L, jVar.getLength());
        long j = 0;
        if (jVar.getPosition() != j) {
            tVar.a = j;
            return 1;
        }
        this.b.Q(min);
        jVar.f();
        jVar.s(this.b.e(), 0, min);
        this.f = i(this.b);
        this.d = true;
        return 0;
    }

    public final long i(M m) {
        int g = m.g();
        for (int f = m.f(); f < g - 3; f++) {
            if (f(m.e(), f) == 442) {
                m.U(f + 4);
                long l = l(m);
                if (l != -9223372036854775807L) {
                    return l;
                }
            }
        }
        return -9223372036854775807L;
    }

    public final int j(d3.j jVar, d3.t tVar) {
        long length = jVar.getLength();
        int min = (int) Math.min(20000L, length);
        long j = length - min;
        if (jVar.getPosition() != j) {
            tVar.a = j;
            return 1;
        }
        this.b.Q(min);
        jVar.f();
        jVar.s(this.b.e(), 0, min);
        this.g = k(this.b);
        this.e = true;
        return 0;
    }

    public final long k(M m) {
        int f = m.f();
        for (int g = m.g() - 4; g >= f; g--) {
            if (f(m.e(), g) == 442) {
                m.U(g + 4);
                long l = l(m);
                if (l != -9223372036854775807L) {
                    return l;
                }
            }
        }
        return -9223372036854775807L;
    }
}
