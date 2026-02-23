package j$.time;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public final class w implements j$.time.temporal.m, j$.time.temporal.p, Comparable, Serializable {
    private static final long serialVersionUID = 4183400860270640070L;
    private final int a;
    private final int b;

    static {
        j$.time.format.n nVar = new j$.time.format.n();
        nVar.l(j$.time.temporal.a.YEAR, 4, 10, j$.time.format.u.EXCEEDS_PAD);
        nVar.e('-');
        nVar.k(j$.time.temporal.a.MONTH_OF_YEAR, 2);
        nVar.v();
    }

    private w(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    private long C() {
        return ((this.a * 12) + this.b) - 1;
    }

    static w G(DataInput dataInput) {
        int readInt = dataInput.readInt();
        byte readByte = dataInput.readByte();
        j$.time.temporal.a.YEAR.C(readInt);
        j$.time.temporal.a.MONTH_OF_YEAR.C(readByte);
        return new w(readInt, readByte);
    }

    private w H(int i, int i2) {
        return (this.a == i && this.b == i2) ? this : new w(i, i2);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new s((byte) 12, this);
    }

    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public final w e(long j, j$.time.temporal.u uVar) {
        if (!(uVar instanceof j$.time.temporal.b)) {
            return (w) uVar.i(this, j);
        }
        switch (v.b[((j$.time.temporal.b) uVar).ordinal()]) {
            case 1:
                return E(j);
            case 2:
                return F(j);
            case 3:
                return F(j$.com.android.tools.r8.a.o(j, 10));
            case 4:
                return F(j$.com.android.tools.r8.a.o(j, 100));
            case 5:
                return F(j$.com.android.tools.r8.a.o(j, 1000));
            case 6:
                j$.time.temporal.a aVar = j$.time.temporal.a.ERA;
                return d(j$.com.android.tools.r8.a.i(q(aVar), j), aVar);
            default:
                throw new j$.time.temporal.v("Unsupported unit: " + uVar);
        }
    }

    public final w E(long j) {
        if (j == 0) {
            return this;
        }
        long j2 = (this.a * 12) + (this.b - 1) + j;
        long j3 = 12;
        return H(j$.time.temporal.a.YEAR.y(j$.com.android.tools.r8.a.n(j2, j3)), ((int) j$.com.android.tools.r8.a.m(j2, j3)) + 1);
    }

    public final w F(long j) {
        return j == 0 ? this : H(j$.time.temporal.a.YEAR.y(this.a + j), this.b);
    }

    /* renamed from: I, reason: merged with bridge method [inline-methods] */
    public final w d(long j, j$.time.temporal.r rVar) {
        if (!(rVar instanceof j$.time.temporal.a)) {
            return (w) rVar.q(this, j);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) rVar;
        aVar.C(j);
        int i = v.a[aVar.ordinal()];
        int i2 = this.a;
        if (i == 1) {
            int i3 = (int) j;
            j$.time.temporal.a.MONTH_OF_YEAR.C(i3);
            return H(i2, i3);
        }
        if (i == 2) {
            return E(j - C());
        }
        int i4 = this.b;
        if (i == 3) {
            if (i2 < 1) {
                j = 1 - j;
            }
            int i5 = (int) j;
            j$.time.temporal.a.YEAR.C(i5);
            return H(i5, i4);
        }
        if (i == 4) {
            int i6 = (int) j;
            j$.time.temporal.a.YEAR.C(i6);
            return H(i6, i4);
        }
        if (i != 5) {
            throw new j$.time.temporal.v(d.a("Unsupported field: ", rVar));
        }
        if (q(j$.time.temporal.a.ERA) == j) {
            return this;
        }
        int i7 = 1 - i2;
        j$.time.temporal.a.YEAR.C(i7);
        return H(i7, i4);
    }

    final void J(DataOutput dataOutput) {
        dataOutput.writeInt(this.a);
        dataOutput.writeByte(this.b);
    }

    public final int compareTo(Object obj) {
        w wVar = (w) obj;
        int i = this.a - wVar.a;
        return i == 0 ? this.b - wVar.b : i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof w)) {
            return false;
        }
        w wVar = (w) obj;
        return this.a == wVar.a && this.b == wVar.b;
    }

    public final boolean f(j$.time.temporal.r rVar) {
        return rVar instanceof j$.time.temporal.a ? rVar == j$.time.temporal.a.YEAR || rVar == j$.time.temporal.a.MONTH_OF_YEAR || rVar == j$.time.temporal.a.PROLEPTIC_MONTH || rVar == j$.time.temporal.a.YEAR_OF_ERA || rVar == j$.time.temporal.a.ERA : rVar != null && rVar.l(this);
    }

    public final int hashCode() {
        return (this.b << 27) ^ this.a;
    }

    public final int i(j$.time.temporal.r rVar) {
        return l(rVar).a(q(rVar), rVar);
    }

    public final j$.time.temporal.m k(h hVar) {
        return (w) j$.time.chrono.i.a(hVar, this);
    }

    public final j$.time.temporal.w l(j$.time.temporal.r rVar) {
        if (rVar == j$.time.temporal.a.YEAR_OF_ERA) {
            return j$.time.temporal.w.j(1L, this.a <= 0 ? 1000000000L : 999999999L);
        }
        return j$.time.temporal.n.d(this, rVar);
    }

    public final long q(j$.time.temporal.r rVar) {
        if (!(rVar instanceof j$.time.temporal.a)) {
            return rVar.k(this);
        }
        int i = v.a[((j$.time.temporal.a) rVar).ordinal()];
        if (i == 1) {
            return this.b;
        }
        if (i == 2) {
            return C();
        }
        int i2 = this.a;
        if (i == 3) {
            if (i2 < 1) {
                i2 = 1 - i2;
            }
            return i2;
        }
        if (i == 4) {
            return i2;
        }
        if (i == 5) {
            return i2 < 1 ? 0 : 1;
        }
        throw new j$.time.temporal.v(d.a("Unsupported field: ", rVar));
    }

    public final Object t(j$.time.temporal.t tVar) {
        return tVar == j$.time.temporal.n.e() ? j$.time.chrono.u.d : tVar == j$.time.temporal.n.i() ? j$.time.temporal.b.MONTHS : j$.time.temporal.n.c(this, tVar);
    }

    public final String toString() {
        int i;
        int i2 = this.a;
        int abs = Math.abs(i2);
        StringBuilder sb = new StringBuilder(9);
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
            sb.append(i2);
        }
        int i3 = this.b;
        sb.append(i3 < 10 ? "-0" : "-");
        sb.append(i3);
        return sb.toString();
    }

    public final j$.time.temporal.m u(j$.time.temporal.m mVar) {
        if (!((j$.time.chrono.a) j$.time.chrono.i.p(mVar)).equals(j$.time.chrono.u.d)) {
            throw new c("Adjustment only supported on ISO date-time");
        }
        return mVar.d(C(), j$.time.temporal.a.PROLEPTIC_MONTH);
    }

    public final j$.time.temporal.m y(long j, j$.time.temporal.u uVar) {
        return j == Long.MIN_VALUE ? e(Long.MAX_VALUE, uVar).e(1L, uVar) : e(-j, uVar);
    }
}
