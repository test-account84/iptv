package j$.time;

import j$.util.Objects;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public final class o implements j$.time.temporal.o, j$.time.temporal.p, Comparable, Serializable {
    private static final long serialVersionUID = -939150713474957432L;
    private final int a;
    private final int b;

    static {
        j$.time.format.n nVar = new j$.time.format.n();
        nVar.f("--");
        nVar.k(j$.time.temporal.a.MONTH_OF_YEAR, 2);
        nVar.e('-');
        nVar.k(j$.time.temporal.a.DAY_OF_MONTH, 2);
        nVar.v();
    }

    private o(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    static o C(DataInput dataInput) {
        byte readByte = dataInput.readByte();
        byte readByte2 = dataInput.readByte();
        m F = m.F(readByte);
        Objects.a(F, "month");
        j$.time.temporal.a.DAY_OF_MONTH.C(readByte2);
        if (readByte2 <= F.E()) {
            return new o(F.getValue(), readByte2);
        }
        throw new c("Illegal value for DayOfMonth field, value " + readByte2 + " is not valid for month " + F.name());
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new s((byte) 13, this);
    }

    final void D(DataOutput dataOutput) {
        dataOutput.writeByte(this.a);
        dataOutput.writeByte(this.b);
    }

    public final int compareTo(Object obj) {
        o oVar = (o) obj;
        int i = this.a - oVar.a;
        return i == 0 ? this.b - oVar.b : i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return this.a == oVar.a && this.b == oVar.b;
    }

    public final boolean f(j$.time.temporal.r rVar) {
        return rVar instanceof j$.time.temporal.a ? rVar == j$.time.temporal.a.MONTH_OF_YEAR || rVar == j$.time.temporal.a.DAY_OF_MONTH : rVar != null && rVar.l(this);
    }

    public final int hashCode() {
        return (this.a << 6) + this.b;
    }

    public final int i(j$.time.temporal.r rVar) {
        return l(rVar).a(q(rVar), rVar);
    }

    public final j$.time.temporal.w l(j$.time.temporal.r rVar) {
        if (rVar == j$.time.temporal.a.MONTH_OF_YEAR) {
            return rVar.i();
        }
        if (rVar != j$.time.temporal.a.DAY_OF_MONTH) {
            return j$.time.temporal.n.d(this, rVar);
        }
        m F = m.F(this.a);
        F.getClass();
        int i = l.a[F.ordinal()];
        return j$.time.temporal.w.k(i != 1 ? (i == 2 || i == 3 || i == 4 || i == 5) ? 30 : 31 : 28, m.F(r5).E());
    }

    public final long q(j$.time.temporal.r rVar) {
        int i;
        if (!(rVar instanceof j$.time.temporal.a)) {
            return rVar.k(this);
        }
        int i2 = n.a[((j$.time.temporal.a) rVar).ordinal()];
        if (i2 == 1) {
            i = this.b;
        } else {
            if (i2 != 2) {
                throw new j$.time.temporal.v(d.a("Unsupported field: ", rVar));
            }
            i = this.a;
        }
        return i;
    }

    public final Object t(j$.time.temporal.t tVar) {
        return tVar == j$.time.temporal.n.e() ? j$.time.chrono.u.d : j$.time.temporal.n.c(this, tVar);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(10);
        sb.append("--");
        int i = this.a;
        sb.append(i < 10 ? "0" : "");
        sb.append(i);
        int i2 = this.b;
        sb.append(i2 < 10 ? "-0" : "-");
        sb.append(i2);
        return sb.toString();
    }

    public final j$.time.temporal.m u(j$.time.temporal.m mVar) {
        if (!((j$.time.chrono.a) j$.time.chrono.i.p(mVar)).equals(j$.time.chrono.u.d)) {
            throw new c("Adjustment only supported on ISO date-time");
        }
        j$.time.temporal.m d = mVar.d(this.a, j$.time.temporal.a.MONTH_OF_YEAR);
        j$.time.temporal.a aVar = j$.time.temporal.a.DAY_OF_MONTH;
        return d.d(Math.min(d.l(aVar).d(), this.b), aVar);
    }
}
