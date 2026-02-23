package j$.time;

import j$.util.Objects;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public final class h implements j$.time.temporal.m, j$.time.temporal.p, j$.time.chrono.b, Serializable {
    public static final h d = N(-999999999, 1, 1);
    public static final h e = N(999999999, 12, 31);
    private static final long serialVersionUID = 2942565459149668126L;
    private final int a;
    private final short b;
    private final short c;

    static {
        N(1970, 1, 1);
    }

    private h(int i, int i2, int i3) {
        this.a = i;
        this.b = (short) i2;
        this.c = (short) i3;
    }

    private static h D(int i, int i2, int i3) {
        int i4 = 28;
        if (i3 > 28) {
            if (i2 != 2) {
                i4 = (i2 == 4 || i2 == 6 || i2 == 9 || i2 == 11) ? 30 : 31;
            } else {
                j$.time.chrono.u.d.getClass();
                if (j$.time.chrono.u.l(i)) {
                    i4 = 29;
                }
            }
            if (i3 > i4) {
                if (i3 == 29) {
                    throw new c("Invalid date 'February 29' as '" + i + "' is not a leap year");
                }
                throw new c("Invalid date '" + m.F(i2).name() + " " + i3 + "'");
            }
        }
        return new h(i, i2, i3);
    }

    public static h E(j$.time.temporal.o oVar) {
        Objects.a(oVar, "temporal");
        h hVar = (h) oVar.t(j$.time.temporal.n.f());
        if (hVar != null) {
            return hVar;
        }
        throw new c("Unable to obtain LocalDate from TemporalAccessor: " + oVar + " of type " + oVar.getClass().getName());
    }

    private int F(j$.time.temporal.r rVar) {
        int i;
        int i2 = g.a[((j$.time.temporal.a) rVar).ordinal()];
        short s = this.c;
        int i3 = this.a;
        switch (i2) {
            case 1:
                return s;
            case 2:
                return H();
            case 3:
                i = (s - 1) / 7;
                break;
            case 4:
                return i3 >= 1 ? i3 : 1 - i3;
            case 5:
                return G().getValue();
            case 6:
                i = (s - 1) % 7;
                break;
            case 7:
                return ((H() - 1) % 7) + 1;
            case 8:
                throw new j$.time.temporal.v("Invalid field 'EpochDay' for get() method, use getLong() instead");
            case 9:
                return ((H() - 1) / 7) + 1;
            case 10:
                return this.b;
            case 11:
                throw new j$.time.temporal.v("Invalid field 'ProlepticMonth' for get() method, use getLong() instead");
            case 12:
                return i3;
            case 13:
                return i3 >= 1 ? 1 : 0;
            default:
                throw new j$.time.temporal.v(d.a("Unsupported field: ", rVar));
        }
        return i + 1;
    }

    public static h N(int i, int i2, int i3) {
        j$.time.temporal.a.YEAR.C(i);
        j$.time.temporal.a.MONTH_OF_YEAR.C(i2);
        j$.time.temporal.a.DAY_OF_MONTH.C(i3);
        return D(i, i2, i3);
    }

    public static h O(int i, m mVar, int i2) {
        j$.time.temporal.a.YEAR.C(i);
        Objects.a(mVar, "month");
        j$.time.temporal.a.DAY_OF_MONTH.C(i2);
        return D(i, mVar.getValue(), i2);
    }

    public static h P(long j) {
        long j2;
        j$.time.temporal.a.EPOCH_DAY.C(j);
        long j3 = 719468 + j;
        if (j3 < 0) {
            long j4 = ((j + 719469) / 146097) - 1;
            j2 = j4 * 400;
            j3 += (-j4) * 146097;
        } else {
            j2 = 0;
        }
        long j5 = ((j3 * 400) + 591) / 146097;
        long j6 = j3 - ((j5 / 400) + (((j5 / 4) + (j5 * 365)) - (j5 / 100)));
        if (j6 < 0) {
            j5--;
            j6 = j3 - ((j5 / 400) + (((j5 / 4) + (365 * j5)) - (j5 / 100)));
        }
        int i = (int) j6;
        int i2 = ((i * 5) + 2) / 153;
        return new h(j$.time.temporal.a.YEAR.y(j5 + j2 + (i2 / 10)), ((i2 + 2) % 12) + 1, (i - (((i2 * 306) + 5) / 10)) + 1);
    }

    private static h U(int i, int i2, int i3) {
        int i4;
        if (i2 != 2) {
            if (i2 == 4 || i2 == 6 || i2 == 9 || i2 == 11) {
                i4 = 30;
            }
            return new h(i, i2, i3);
        }
        j$.time.chrono.u.d.getClass();
        i4 = j$.time.chrono.u.l((long) i) ? 29 : 28;
        i3 = Math.min(i3, i4);
        return new h(i, i2, i3);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new s((byte) 3, this);
    }

    final int C(h hVar) {
        int i = this.a - hVar.a;
        if (i != 0) {
            return i;
        }
        int i2 = this.b - hVar.b;
        return i2 == 0 ? this.c - hVar.c : i2;
    }

    public final e G() {
        return e.C(((int) j$.com.android.tools.r8.a.m(r() + 3, 7)) + 1);
    }

    public final int H() {
        return (m.F(this.b).C(L()) + this.c) - 1;
    }

    public final int I() {
        return this.b;
    }

    public final int J() {
        return this.a;
    }

    public final boolean K(j$.time.chrono.b bVar) {
        return bVar instanceof h ? C((h) bVar) < 0 : r() < bVar.r();
    }

    public final boolean L() {
        j$.time.chrono.u uVar = j$.time.chrono.u.d;
        long j = this.a;
        uVar.getClass();
        return j$.time.chrono.u.l(j);
    }

    public final int M() {
        short s = this.b;
        return s != 2 ? (s == 4 || s == 6 || s == 9 || s == 11) ? 30 : 31 : L() ? 29 : 28;
    }

    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public final h e(long j, j$.time.temporal.u uVar) {
        if (!(uVar instanceof j$.time.temporal.b)) {
            return (h) uVar.i(this, j);
        }
        switch (g.b[((j$.time.temporal.b) uVar).ordinal()]) {
            case 1:
                return R(j);
            case 2:
                return R(j$.com.android.tools.r8.a.o(j, 7));
            case 3:
                return S(j);
            case 4:
                return T(j);
            case 5:
                return T(j$.com.android.tools.r8.a.o(j, 10));
            case 6:
                return T(j$.com.android.tools.r8.a.o(j, 100));
            case 7:
                return T(j$.com.android.tools.r8.a.o(j, 1000));
            case 8:
                j$.time.temporal.a aVar = j$.time.temporal.a.ERA;
                return d(j$.com.android.tools.r8.a.i(q(aVar), j), aVar);
            default:
                throw new j$.time.temporal.v("Unsupported unit: " + uVar);
        }
    }

    public final h R(long j) {
        if (j == 0) {
            return this;
        }
        long j2 = this.c + j;
        if (j2 > 0) {
            short s = this.b;
            int i = this.a;
            if (j2 <= 28) {
                return new h(i, s, (int) j2);
            }
            if (j2 <= 59) {
                long M = M();
                if (j2 <= M) {
                    return new h(i, s, (int) j2);
                }
                if (s < 12) {
                    return new h(i, s + 1, (int) (j2 - M));
                }
                int i2 = i + 1;
                j$.time.temporal.a.YEAR.C(i2);
                return new h(i2, 1, (int) (j2 - M));
            }
        }
        return P(j$.com.android.tools.r8.a.i(r(), j));
    }

    public final h S(long j) {
        if (j == 0) {
            return this;
        }
        long j2 = (this.a * 12) + (this.b - 1) + j;
        long j3 = 12;
        return U(j$.time.temporal.a.YEAR.y(j$.com.android.tools.r8.a.n(j2, j3)), ((int) j$.com.android.tools.r8.a.m(j2, j3)) + 1, this.c);
    }

    public final h T(long j) {
        return j == 0 ? this : U(j$.time.temporal.a.YEAR.y(this.a + j), this.b, this.c);
    }

    /* renamed from: V, reason: merged with bridge method [inline-methods] */
    public final h d(long j, j$.time.temporal.r rVar) {
        if (!(rVar instanceof j$.time.temporal.a)) {
            return (h) rVar.q(this, j);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) rVar;
        aVar.C(j);
        int i = g.a[aVar.ordinal()];
        short s = this.c;
        short s2 = this.b;
        int i2 = this.a;
        switch (i) {
            case 1:
                int i3 = (int) j;
                return s == i3 ? this : N(i2, s2, i3);
            case 2:
                return X((int) j);
            case 3:
                return R(j$.com.android.tools.r8.a.o(j - q(j$.time.temporal.a.ALIGNED_WEEK_OF_MONTH), 7));
            case 4:
                if (i2 < 1) {
                    j = 1 - j;
                }
                return Y((int) j);
            case 5:
                return R(j - G().getValue());
            case 6:
                return R(j - q(j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_MONTH));
            case 7:
                return R(j - q(j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_YEAR));
            case 8:
                return P(j);
            case 9:
                return R(j$.com.android.tools.r8.a.o(j - q(j$.time.temporal.a.ALIGNED_WEEK_OF_YEAR), 7));
            case 10:
                int i4 = (int) j;
                if (s2 == i4) {
                    return this;
                }
                j$.time.temporal.a.MONTH_OF_YEAR.C(i4);
                return U(i2, i4, s);
            case 11:
                return S(j - (((i2 * 12) + s2) - 1));
            case 12:
                return Y((int) j);
            case 13:
                return q(j$.time.temporal.a.ERA) == j ? this : Y(1 - i2);
            default:
                throw new j$.time.temporal.v(d.a("Unsupported field: ", rVar));
        }
    }

    /* renamed from: W, reason: merged with bridge method [inline-methods] */
    public final h k(j$.time.temporal.p pVar) {
        return pVar instanceof h ? (h) pVar : (h) pVar.u(this);
    }

    public final h X(int i) {
        if (H() == i) {
            return this;
        }
        j$.time.temporal.a aVar = j$.time.temporal.a.YEAR;
        int i2 = this.a;
        long j = i2;
        aVar.C(j);
        j$.time.temporal.a.DAY_OF_YEAR.C(i);
        j$.time.chrono.u.d.getClass();
        boolean l = j$.time.chrono.u.l(j);
        if (i == 366 && !l) {
            throw new c("Invalid date 'DayOfYear 366' as '" + i2 + "' is not a leap year");
        }
        m F = m.F(((i - 1) / 31) + 1);
        if (i > (F.D(l) + F.C(l)) - 1) {
            F = F.G();
        }
        return new h(i2, F.getValue(), (i - F.C(l)) + 1);
    }

    public final h Y(int i) {
        if (this.a == i) {
            return this;
        }
        j$.time.temporal.a.YEAR.C(i);
        return U(i, this.b, this.c);
    }

    final void Z(DataOutput dataOutput) {
        dataOutput.writeInt(this.a);
        dataOutput.writeByte(this.b);
        dataOutput.writeByte(this.c);
    }

    public final j$.time.chrono.n a() {
        return j$.time.chrono.u.d;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof h) && C((h) obj) == 0;
    }

    public final boolean f(j$.time.temporal.r rVar) {
        return j$.time.chrono.i.h(this, rVar);
    }

    public final int hashCode() {
        int i = this.a;
        return (((i << 11) + (this.b << 6)) + this.c) ^ (i & (-2048));
    }

    public final int i(j$.time.temporal.r rVar) {
        return rVar instanceof j$.time.temporal.a ? F(rVar) : j$.time.temporal.n.a(this, rVar);
    }

    public final j$.time.temporal.w l(j$.time.temporal.r rVar) {
        if (!(rVar instanceof j$.time.temporal.a)) {
            return rVar.t(this);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) rVar;
        if (!aVar.u()) {
            throw new j$.time.temporal.v(d.a("Unsupported field: ", rVar));
        }
        int i = g.a[aVar.ordinal()];
        if (i == 1) {
            return j$.time.temporal.w.j(1L, M());
        }
        if (i == 2) {
            return j$.time.temporal.w.j(1L, L() ? 366 : 365);
        }
        if (i == 3) {
            return j$.time.temporal.w.j(1L, (m.F(this.b) != m.FEBRUARY || L()) ? 5L : 4L);
        }
        if (i != 4) {
            return ((j$.time.temporal.a) rVar).i();
        }
        return j$.time.temporal.w.j(1L, this.a <= 0 ? 1000000000L : 999999999L);
    }

    public final long q(j$.time.temporal.r rVar) {
        return rVar instanceof j$.time.temporal.a ? rVar == j$.time.temporal.a.EPOCH_DAY ? r() : rVar == j$.time.temporal.a.PROLEPTIC_MONTH ? ((this.a * 12) + this.b) - 1 : F(rVar) : rVar.k(this);
    }

    public final long r() {
        long j = this.a;
        long j2 = this.b;
        long j3 = 365 * j;
        long j4 = (((367 * j2) - 362) / 12) + (j >= 0 ? ((j + 399) / 400) + (((3 + j) / 4) - ((99 + j) / 100)) + j3 : j3 - ((j / (-400)) + ((j / (-4)) - (j / (-100))))) + (this.c - 1);
        if (j2 > 2) {
            j4 = !L() ? j4 - 2 : j4 - 1;
        }
        return j4 - 719528;
    }

    public final j$.time.chrono.e s(k kVar) {
        return LocalDateTime.K(this, kVar);
    }

    public final Object t(j$.time.temporal.t tVar) {
        return tVar == j$.time.temporal.n.f() ? this : j$.time.chrono.i.j(this, tVar);
    }

    public final String toString() {
        int i;
        int i2 = this.a;
        int abs = Math.abs(i2);
        StringBuilder sb = new StringBuilder(10);
        if (abs < 1000) {
            if (i2 < 0) {
                sb.append(i2 - 10000);
                i = 1;
            } else {
                sb.append(i2 + 10000);
                i = 0;
            }
            sb.deleteCharAt(i);
        } else {
            if (i2 > 9999) {
                sb.append('+');
            }
            sb.append(i2);
        }
        short s = this.b;
        sb.append(s < 10 ? "-0" : "-");
        sb.append(s);
        short s2 = this.c;
        sb.append(s2 < 10 ? "-0" : "-");
        sb.append(s2);
        return sb.toString();
    }

    public final j$.time.temporal.m u(j$.time.temporal.m mVar) {
        return j$.time.chrono.i.a(this, mVar);
    }

    public final j$.time.temporal.m y(long j, j$.time.temporal.u uVar) {
        return j == Long.MIN_VALUE ? e(Long.MAX_VALUE, uVar).e(1L, uVar) : e(-j, uVar);
    }

    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public final int compareTo(j$.time.chrono.b bVar) {
        return bVar instanceof h ? C((h) bVar) : j$.time.chrono.i.b(this, bVar);
    }
}
