package F3;

import O2.z0;
import d4.k0;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class k {
    public final i a;
    public final long b;
    public final long c;

    public static abstract class a extends k {
        public final long d;
        public final long e;
        public final List f;
        public final long g;
        public final long h;
        public final long i;

        public a(i iVar, long j, long j2, long j3, long j4, List list, long j5, long j6, long j7) {
            super(iVar, j, j2);
            this.d = j3;
            this.e = j4;
            this.f = list;
            this.i = j5;
            this.g = j6;
            this.h = j7;
        }

        public long c(long j, long j2) {
            long g = g(j);
            return g != -1 ? g : (int) (i((j2 - this.h) + this.i, j) - d(j, j2));
        }

        public long d(long j, long j2) {
            if (g(j) == -1) {
                long j3 = this.g;
                if (j3 != -9223372036854775807L) {
                    return Math.max(e(), i((j2 - this.h) - j3, j));
                }
            }
            return e();
        }

        public long e() {
            return this.d;
        }

        public long f(long j, long j2) {
            if (this.f != null) {
                return -9223372036854775807L;
            }
            long d = d(j, j2) + c(j, j2);
            return (j(d) + h(d, j)) - this.i;
        }

        public abstract long g(long j);

        public final long h(long j, long j2) {
            List list = this.f;
            if (list != null) {
                return (((d) list.get((int) (j - this.d))).b * 1000000) / this.b;
            }
            long g = g(j2);
            return (g == -1 || j != (e() + g) - 1) ? (this.e * 1000000) / this.b : j2 - j(j);
        }

        public long i(long j, long j2) {
            long e = e();
            long g = g(j2);
            if (g == 0) {
                return e;
            }
            if (this.f == null) {
                long j3 = this.d + (j / ((this.e * 1000000) / this.b));
                return j3 < e ? e : g == -1 ? j3 : Math.min(j3, (e + g) - 1);
            }
            long j4 = (g + e) - 1;
            long j5 = e;
            while (j5 <= j4) {
                long j6 = ((j4 - j5) / 2) + j5;
                long j7 = j(j6);
                if (j7 < j) {
                    j5 = j6 + 1;
                } else {
                    if (j7 <= j) {
                        return j6;
                    }
                    j4 = j6 - 1;
                }
            }
            return j5 == e ? j5 : j4;
        }

        public final long j(long j) {
            List list = this.f;
            return k0.c1(list != null ? ((d) list.get((int) (j - this.d))).a - this.c : (j - this.d) * this.e, 1000000L, this.b);
        }

        public abstract i k(j jVar, long j);

        public boolean l() {
            return this.f != null;
        }
    }

    public static final class b extends a {
        public final List j;

        public b(i iVar, long j, long j2, long j3, long j4, List list, long j5, List list2, long j6, long j7) {
            super(iVar, j, j2, j3, j4, list, j5, j6, j7);
            this.j = list2;
        }

        public long g(long j) {
            return this.j.size();
        }

        public i k(j jVar, long j) {
            return (i) this.j.get((int) (j - this.d));
        }

        public boolean l() {
            return true;
        }
    }

    public static final class c extends a {
        public final n j;
        public final n k;
        public final long l;

        public c(i iVar, long j, long j2, long j3, long j4, long j5, List list, long j6, n nVar, n nVar2, long j7, long j8) {
            super(iVar, j, j2, j3, j5, list, j6, j7, j8);
            this.j = nVar;
            this.k = nVar2;
            this.l = j4;
        }

        public i a(j jVar) {
            n nVar = this.j;
            if (nVar == null) {
                return super.a(jVar);
            }
            z0 z0Var = jVar.b;
            return new i(nVar.a(z0Var.a, 0L, z0Var.i, 0L), 0L, -1L);
        }

        public long g(long j) {
            if (this.f != null) {
                return r0.size();
            }
            long j2 = this.l;
            if (j2 != -1) {
                return (j2 - this.d) + 1;
            }
            if (j != -9223372036854775807L) {
                return v5.a.a(BigInteger.valueOf(j).multiply(BigInteger.valueOf(this.b)), BigInteger.valueOf(this.e).multiply(BigInteger.valueOf(1000000L)), RoundingMode.CEILING).longValue();
            }
            return -1L;
        }

        public i k(j jVar, long j) {
            List list = this.f;
            long j2 = list != null ? ((d) list.get((int) (j - this.d))).a : (j - this.d) * this.e;
            n nVar = this.k;
            z0 z0Var = jVar.b;
            return new i(nVar.a(z0Var.a, j, z0Var.i, j2), 0L, -1L);
        }
    }

    public static final class d {
        public final long a;
        public final long b;

        public d(long j, long j2) {
            this.a = j;
            this.b = j2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || d.class != obj.getClass()) {
                return false;
            }
            d dVar = (d) obj;
            return this.a == dVar.a && this.b == dVar.b;
        }

        public int hashCode() {
            return (((int) this.a) * 31) + ((int) this.b);
        }
    }

    public static class e extends k {
        public final long d;
        public final long e;

        public e() {
            this(null, 1L, 0L, 0L, 0L);
        }

        public i c() {
            long j = this.e;
            if (j <= 0) {
                return null;
            }
            return new i(null, this.d, j);
        }

        public e(i iVar, long j, long j2, long j3, long j4) {
            super(iVar, j, j2);
            this.d = j3;
            this.e = j4;
        }
    }

    public k(i iVar, long j, long j2) {
        this.a = iVar;
        this.b = j;
        this.c = j2;
    }

    public i a(j jVar) {
        return this.a;
    }

    public long b() {
        return k0.c1(this.c, 1000000L, this.b);
    }
}
