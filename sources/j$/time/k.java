package j$.time;

import j$.util.Objects;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public final class k implements j$.time.temporal.m, j$.time.temporal.p, Comparable, Serializable {
    public static final k e;
    public static final k f;
    public static final k g;
    private static final k[] h = new k[24];
    private static final long serialVersionUID = 6414437269572265201L;
    private final byte a;
    private final byte b;
    private final byte c;
    private final int d;

    static {
        int i = 0;
        while (true) {
            k[] kVarArr = h;
            if (i >= kVarArr.length) {
                k kVar = kVarArr[0];
                g = kVar;
                k kVar2 = kVarArr[12];
                e = kVar;
                f = new k(23, 59, 59, 999999999);
                return;
            }
            kVarArr[i] = new k(i, 0, 0, 0);
            i++;
        }
    }

    private k(int i, int i2, int i3, int i4) {
        this.a = (byte) i;
        this.b = (byte) i2;
        this.c = (byte) i3;
        this.d = i4;
    }

    private static k D(int i, int i2, int i3, int i4) {
        return ((i2 | i3) | i4) == 0 ? h[i] : new k(i, i2, i3, i4);
    }

    public static k E(j$.time.temporal.o oVar) {
        Objects.a(oVar, "temporal");
        k kVar = (k) oVar.t(j$.time.temporal.n.g());
        if (kVar != null) {
            return kVar;
        }
        throw new c("Unable to obtain LocalTime from TemporalAccessor: " + oVar + " of type " + oVar.getClass().getName());
    }

    private int F(j$.time.temporal.r rVar) {
        int i = j.a[((j$.time.temporal.a) rVar).ordinal()];
        byte b = this.b;
        int i2 = this.d;
        byte b2 = this.a;
        switch (i) {
            case 1:
                return i2;
            case 2:
                throw new j$.time.temporal.v("Invalid field 'NanoOfDay' for get() method, use getLong() instead");
            case 3:
                return i2 / 1000;
            case 4:
                throw new j$.time.temporal.v("Invalid field 'MicroOfDay' for get() method, use getLong() instead");
            case 5:
                return i2 / 1000000;
            case 6:
                return (int) (S() / 1000000);
            case 7:
                return this.c;
            case 8:
                return T();
            case 9:
                return b;
            case 10:
                return (b2 * 60) + b;
            case 11:
                return b2 % 12;
            case 12:
                int i3 = b2 % 12;
                if (i3 % 12 == 0) {
                    return 12;
                }
                return i3;
            case 13:
                return b2;
            case 14:
                if (b2 == 0) {
                    return 24;
                }
                return b2;
            case 15:
                return b2 / 12;
            default:
                throw new j$.time.temporal.v(d.a("Unsupported field: ", rVar));
        }
    }

    public static k J(int i) {
        j$.time.temporal.a.HOUR_OF_DAY.C(i);
        return h[i];
    }

    public static k K(long j) {
        j$.time.temporal.a.NANO_OF_DAY.C(j);
        int i = (int) (j / 3600000000000L);
        long j2 = j - (i * 3600000000000L);
        int i2 = (int) (j2 / 60000000000L);
        long j3 = j2 - (i2 * 60000000000L);
        int i3 = (int) (j3 / 1000000000);
        return D(i, i2, i3, (int) (j3 - (i3 * 1000000000)));
    }

    public static k L(long j) {
        j$.time.temporal.a.SECOND_OF_DAY.C(j);
        int i = (int) (j / 3600);
        long j2 = j - (i * 3600);
        return D(i, (int) (j2 / 60), (int) (j2 - (r0 * 60)), 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v3, types: [int] */
    static k R(DataInput dataInput) {
        int i;
        int i2;
        int readByte = dataInput.readByte();
        byte b = 0;
        if (readByte >= 0) {
            byte readByte2 = dataInput.readByte();
            if (readByte2 < 0) {
                ?? r7 = ~readByte2;
                i2 = 0;
                b = r7;
                i = 0;
            } else {
                byte readByte3 = dataInput.readByte();
                if (readByte3 < 0) {
                    i = ~readByte3;
                    b = readByte2;
                } else {
                    int readInt = dataInput.readInt();
                    i = readByte3;
                    i2 = readInt;
                    b = readByte2;
                }
            }
            j$.time.temporal.a.HOUR_OF_DAY.C(readByte);
            j$.time.temporal.a.MINUTE_OF_HOUR.C(b);
            j$.time.temporal.a.SECOND_OF_MINUTE.C(i);
            j$.time.temporal.a.NANO_OF_SECOND.C(i2);
            return D(readByte, b, i, i2);
        }
        readByte = ~readByte;
        i = 0;
        i2 = 0;
        j$.time.temporal.a.HOUR_OF_DAY.C(readByte);
        j$.time.temporal.a.MINUTE_OF_HOUR.C(b);
        j$.time.temporal.a.SECOND_OF_MINUTE.C(i);
        j$.time.temporal.a.NANO_OF_SECOND.C(i2);
        return D(readByte, b, i, i2);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new s((byte) 4, this);
    }

    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public final int compareTo(k kVar) {
        int compare = Integer.compare(this.a, kVar.a);
        if (compare != 0) {
            return compare;
        }
        int compare2 = Integer.compare(this.b, kVar.b);
        if (compare2 != 0) {
            return compare2;
        }
        int compare3 = Integer.compare(this.c, kVar.c);
        return compare3 == 0 ? Integer.compare(this.d, kVar.d) : compare3;
    }

    public final int G() {
        return this.a;
    }

    public final int H() {
        return this.d;
    }

    public final int I() {
        return this.c;
    }

    /* renamed from: M, reason: merged with bridge method [inline-methods] */
    public final k e(long j, j$.time.temporal.u uVar) {
        if (!(uVar instanceof j$.time.temporal.b)) {
            return (k) uVar.i(this, j);
        }
        switch (j.b[((j$.time.temporal.b) uVar).ordinal()]) {
            case 1:
                return P(j);
            case 2:
                return P((j % 86400000000L) * 1000);
            case 3:
                return P((j % 86400000) * 1000000);
            case 4:
                return Q(j);
            case 5:
                return O(j);
            case 6:
                return N(j);
            case 7:
                return N((j % 2) * 12);
            default:
                throw new j$.time.temporal.v("Unsupported unit: " + uVar);
        }
    }

    public final k N(long j) {
        if (j == 0) {
            return this;
        }
        return D(((((int) (j % 24)) + this.a) + 24) % 24, this.b, this.c, this.d);
    }

    public final k O(long j) {
        if (j == 0) {
            return this;
        }
        int i = (this.a * 60) + this.b;
        int i2 = ((((int) (j % 1440)) + i) + 1440) % 1440;
        return i == i2 ? this : D(i2 / 60, i2 % 60, this.c, this.d);
    }

    public final k P(long j) {
        if (j == 0) {
            return this;
        }
        long S = S();
        long j2 = (((j % 86400000000000L) + S) + 86400000000000L) % 86400000000000L;
        return S == j2 ? this : D((int) (j2 / 3600000000000L), (int) ((j2 / 60000000000L) % 60), (int) ((j2 / 1000000000) % 60), (int) (j2 % 1000000000));
    }

    public final k Q(long j) {
        if (j == 0) {
            return this;
        }
        int i = (this.b * 60) + (this.a * 3600) + this.c;
        int i2 = ((((int) (j % 86400)) + i) + 86400) % 86400;
        return i == i2 ? this : D(i2 / 3600, (i2 / 60) % 60, i2 % 60, this.d);
    }

    public final long S() {
        return (this.c * 1000000000) + (this.b * 60000000000L) + (this.a * 3600000000000L) + this.d;
    }

    public final int T() {
        return (this.b * 60) + (this.a * 3600) + this.c;
    }

    /* renamed from: U, reason: merged with bridge method [inline-methods] */
    public final k d(long j, j$.time.temporal.r rVar) {
        if (!(rVar instanceof j$.time.temporal.a)) {
            return (k) rVar.q(this, j);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) rVar;
        aVar.C(j);
        int i = j.a[aVar.ordinal()];
        byte b = this.b;
        byte b2 = this.c;
        int i2 = this.d;
        byte b3 = this.a;
        switch (i) {
            case 1:
                return V((int) j);
            case 2:
                return K(j);
            case 3:
                return V(((int) j) * 1000);
            case 4:
                return K(j * 1000);
            case 5:
                return V(((int) j) * 1000000);
            case 6:
                return K(j * 1000000);
            case 7:
                int i3 = (int) j;
                if (b2 == i3) {
                    return this;
                }
                j$.time.temporal.a.SECOND_OF_MINUTE.C(i3);
                return D(b3, b, i3, i2);
            case 8:
                return Q(j - T());
            case 9:
                int i4 = (int) j;
                if (b == i4) {
                    return this;
                }
                j$.time.temporal.a.MINUTE_OF_HOUR.C(i4);
                return D(b3, i4, b2, i2);
            case 10:
                return O(j - ((b3 * 60) + b));
            case 11:
                return N(j - (b3 % 12));
            case 12:
                if (j == 12) {
                    j = 0;
                }
                return N(j - (b3 % 12));
            case 13:
                int i5 = (int) j;
                if (b3 == i5) {
                    return this;
                }
                j$.time.temporal.a.HOUR_OF_DAY.C(i5);
                return D(i5, b, b2, i2);
            case 14:
                if (j == 24) {
                    j = 0;
                }
                int i6 = (int) j;
                if (b3 == i6) {
                    return this;
                }
                j$.time.temporal.a.HOUR_OF_DAY.C(i6);
                return D(i6, b, b2, i2);
            case 15:
                return N((j - (b3 / 12)) * 12);
            default:
                throw new j$.time.temporal.v(d.a("Unsupported field: ", rVar));
        }
    }

    public final k V(int i) {
        if (this.d == i) {
            return this;
        }
        j$.time.temporal.a.NANO_OF_SECOND.C(i);
        return D(this.a, this.b, this.c, i);
    }

    final void W(DataOutput dataOutput) {
        int i;
        byte b = this.c;
        byte b2 = this.a;
        byte b3 = this.b;
        int i2 = this.d;
        if (i2 != 0) {
            dataOutput.writeByte(b2);
            dataOutput.writeByte(b3);
            dataOutput.writeByte(b);
            dataOutput.writeInt(i2);
            return;
        }
        if (b != 0) {
            dataOutput.writeByte(b2);
            dataOutput.writeByte(b3);
            i = ~b;
        } else if (b3 == 0) {
            i = ~b2;
        } else {
            dataOutput.writeByte(b2);
            i = ~b3;
        }
        dataOutput.writeByte(i);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return this.a == kVar.a && this.b == kVar.b && this.c == kVar.c && this.d == kVar.d;
    }

    public final boolean f(j$.time.temporal.r rVar) {
        return rVar instanceof j$.time.temporal.a ? ((j$.time.temporal.a) rVar).D() : rVar != null && rVar.l(this);
    }

    public final int hashCode() {
        long S = S();
        return (int) (S ^ (S >>> 32));
    }

    public final int i(j$.time.temporal.r rVar) {
        return rVar instanceof j$.time.temporal.a ? F(rVar) : j$.time.temporal.n.a(this, rVar);
    }

    public final j$.time.temporal.m k(h hVar) {
        boolean z = hVar instanceof k;
        j$.time.temporal.m mVar = hVar;
        if (!z) {
            mVar = j$.time.chrono.i.a(hVar, this);
        }
        return (k) mVar;
    }

    public final j$.time.temporal.w l(j$.time.temporal.r rVar) {
        return j$.time.temporal.n.d(this, rVar);
    }

    public final long q(j$.time.temporal.r rVar) {
        return rVar instanceof j$.time.temporal.a ? rVar == j$.time.temporal.a.NANO_OF_DAY ? S() : rVar == j$.time.temporal.a.MICRO_OF_DAY ? S() / 1000 : F(rVar) : rVar.k(this);
    }

    public final Object t(j$.time.temporal.t tVar) {
        if (tVar == j$.time.temporal.n.e() || tVar == j$.time.temporal.n.k() || tVar == j$.time.temporal.n.j() || tVar == j$.time.temporal.n.h()) {
            return null;
        }
        if (tVar == j$.time.temporal.n.g()) {
            return this;
        }
        if (tVar == j$.time.temporal.n.f()) {
            return null;
        }
        return tVar == j$.time.temporal.n.i() ? j$.time.temporal.b.NANOS : tVar.a(this);
    }

    public final String toString() {
        int i;
        StringBuilder sb = new StringBuilder(18);
        byte b = this.a;
        sb.append(b < 10 ? "0" : "");
        sb.append(b);
        byte b2 = this.b;
        sb.append(b2 < 10 ? ":0" : ":");
        sb.append(b2);
        byte b3 = this.c;
        int i2 = this.d;
        if (b3 > 0 || i2 > 0) {
            sb.append(b3 < 10 ? ":0" : ":");
            sb.append(b3);
            if (i2 > 0) {
                sb.append('.');
                int i3 = 1000000;
                if (i2 % 1000000 == 0) {
                    i = (i2 / 1000000) + 1000;
                } else {
                    if (i2 % 1000 == 0) {
                        i2 /= 1000;
                    } else {
                        i3 = 1000000000;
                    }
                    i = i2 + i3;
                }
                sb.append(Integer.toString(i).substring(1));
            }
        }
        return sb.toString();
    }

    public final j$.time.temporal.m u(j$.time.temporal.m mVar) {
        return mVar.d(S(), j$.time.temporal.a.NANO_OF_DAY);
    }

    public final j$.time.temporal.m y(long j, j$.time.temporal.u uVar) {
        return j == Long.MIN_VALUE ? e(Long.MAX_VALUE, uVar).e(1L, uVar) : e(-j, uVar);
    }
}
