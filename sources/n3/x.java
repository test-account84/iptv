package n3;

import com.google.android.exoplayer2.extractor.a;
import d4.M;
import d4.Z;
import d4.k0;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class x extends com.google.android.exoplayer2.extractor.a {

    public static final class b implements a.f {
        public final Z a;
        public final M b;

        public b(Z z) {
            this.a = z;
            this.b = new M();
        }

        public static void d(M m) {
            int j;
            int g = m.g();
            if (m.a() < 10) {
                m.U(g);
                return;
            }
            m.V(9);
            int H = m.H() & 7;
            if (m.a() < H) {
                m.U(g);
                return;
            }
            m.V(H);
            if (m.a() < 4) {
                m.U(g);
                return;
            }
            if (x.j(m.e(), m.f()) == 443) {
                m.V(4);
                int N = m.N();
                if (m.a() < N) {
                    m.U(g);
                    return;
                }
                m.V(N);
            }
            while (m.a() >= 4 && (j = x.j(m.e(), m.f())) != 442 && j != 441 && (j >>> 8) == 1) {
                m.V(4);
                if (m.a() < 2) {
                    m.U(g);
                    return;
                }
                m.U(Math.min(m.g(), m.f() + m.N()));
            }
        }

        public a.e a(d3.j jVar, long j) {
            long position = jVar.getPosition();
            int min = (int) Math.min(20000L, jVar.getLength() - position);
            this.b.Q(min);
            jVar.s(this.b.e(), 0, min);
            return c(this.b, j, position);
        }

        public void b() {
            this.b.R(k0.f);
        }

        public final a.e c(M m, long j, long j2) {
            int i = -1;
            long j3 = -9223372036854775807L;
            int i2 = -1;
            while (m.a() >= 4) {
                if (x.j(m.e(), m.f()) != 442) {
                    m.V(1);
                } else {
                    m.V(4);
                    long l = y.l(m);
                    if (l != -9223372036854775807L) {
                        long b = this.a.b(l);
                        if (b > j) {
                            return j3 == -9223372036854775807L ? a.e.d(b, j2) : a.e.e(j2 + i2);
                        }
                        if (100000 + b > j) {
                            return a.e.e(j2 + m.f());
                        }
                        i2 = m.f();
                        j3 = b;
                    }
                    d(m);
                    i = m.f();
                }
            }
            return j3 != -9223372036854775807L ? a.e.f(j3, j2 + i) : a.e.d;
        }

        public /* synthetic */ b(Z z, a aVar) {
            this(z);
        }
    }

    public x(Z z, long j, long j2) {
        super(new a.b(), new b(z, null), j, 0L, j + 1, 0L, j2, 188L, 1000);
    }

    public static /* synthetic */ int j(byte[] bArr, int i) {
        return k(bArr, i);
    }

    public static int k(byte[] bArr, int i) {
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }
}
