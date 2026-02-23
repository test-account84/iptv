package j$.time.zone;

import j$.time.LocalDateTime;
import j$.time.ZoneOffset;
import j$.time.chrono.u;
import j$.time.k;
import j$.time.m;
import j$.time.temporal.q;
import j$.util.Objects;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public final class e implements Serializable {
    private static final long serialVersionUID = 6889046316657758795L;
    private final m a;
    private final byte b;
    private final j$.time.e c;
    private final k d;
    private final boolean e;
    private final d f;
    private final ZoneOffset g;
    private final ZoneOffset h;
    private final ZoneOffset i;

    e(m mVar, int i, j$.time.e eVar, k kVar, boolean z, d dVar, ZoneOffset zoneOffset, ZoneOffset zoneOffset2, ZoneOffset zoneOffset3) {
        this.a = mVar;
        this.b = (byte) i;
        this.c = eVar;
        this.d = kVar;
        this.e = z;
        this.f = dVar;
        this.g = zoneOffset;
        this.h = zoneOffset2;
        this.i = zoneOffset3;
    }

    static e b(DataInput dataInput) {
        int readInt = dataInput.readInt();
        m F = m.F(readInt >>> 28);
        int i = ((264241152 & readInt) >>> 22) - 32;
        int i2 = (3670016 & readInt) >>> 19;
        j$.time.e C = i2 == 0 ? null : j$.time.e.C(i2);
        int i3 = (507904 & readInt) >>> 14;
        d dVar = d.values()[(readInt & 12288) >>> 12];
        int i4 = (readInt & 4080) >>> 4;
        int i5 = (readInt & 12) >>> 2;
        int i6 = readInt & 3;
        k L = i3 == 31 ? k.L(dataInput.readInt()) : k.J(i3 % 24);
        ZoneOffset L2 = ZoneOffset.L(i4 == 255 ? dataInput.readInt() : (i4 - 128) * 900);
        ZoneOffset L3 = i5 == 3 ? ZoneOffset.L(dataInput.readInt()) : ZoneOffset.L((i5 * 1800) + L2.I());
        ZoneOffset L4 = i6 == 3 ? ZoneOffset.L(dataInput.readInt()) : ZoneOffset.L((i6 * 1800) + L2.I());
        boolean z = i3 == 24;
        Objects.a(F, "month");
        Objects.a(L, "time");
        Objects.a(dVar, "timeDefnition");
        if (i < -28 || i > 31 || i == 0) {
            throw new IllegalArgumentException("Day of month indicator must be between -28 and 31 inclusive excluding zero");
        }
        if (z && !L.equals(k.g)) {
            throw new IllegalArgumentException("Time must be midnight when end of day flag is true");
        }
        if (L.H() == 0) {
            return new e(F, i, C, L, z, dVar, L2, L3, L4);
        }
        throw new IllegalArgumentException("Time's nano-of-second must be zero");
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new a((byte) 3, this);
    }

    public final b a(int i) {
        j$.time.h O;
        q qVar;
        int I;
        ZoneOffset zoneOffset;
        j$.time.e eVar = this.c;
        m mVar = this.a;
        byte b = this.b;
        if (b < 0) {
            u.d.getClass();
            O = j$.time.h.O(i, mVar, mVar.D(u.l(i)) + 1 + b);
            if (eVar != null) {
                qVar = new q(eVar.getValue(), 1);
                O = O.W(qVar);
            }
        } else {
            O = j$.time.h.O(i, mVar, b);
            if (eVar != null) {
                qVar = new q(eVar.getValue(), 0);
                O = O.W(qVar);
            }
        }
        if (this.e) {
            O = O.R(1L);
        }
        LocalDateTime K = LocalDateTime.K(O, this.d);
        d dVar = this.f;
        dVar.getClass();
        int i2 = c.a[dVar.ordinal()];
        ZoneOffset zoneOffset2 = this.h;
        if (i2 != 1) {
            if (i2 == 2) {
                I = zoneOffset2.I();
                zoneOffset = this.g;
            }
            return new b(K, zoneOffset2, this.i);
        }
        I = zoneOffset2.I();
        zoneOffset = ZoneOffset.UTC;
        K = K.N(I - zoneOffset.I());
        return new b(K, zoneOffset2, this.i);
    }

    final void c(DataOutput dataOutput) {
        k kVar = this.d;
        boolean z = this.e;
        int T = z ? 86400 : kVar.T();
        int I = this.g.I();
        ZoneOffset zoneOffset = this.h;
        int I2 = zoneOffset.I() - I;
        ZoneOffset zoneOffset2 = this.i;
        int I3 = zoneOffset2.I() - I;
        int G = T % 3600 == 0 ? z ? 24 : kVar.G() : 31;
        int i = I % 900 == 0 ? (I / 900) + 128 : 255;
        int i2 = (I2 == 0 || I2 == 1800 || I2 == 3600) ? I2 / 1800 : 3;
        int i3 = (I3 == 0 || I3 == 1800 || I3 == 3600) ? I3 / 1800 : 3;
        j$.time.e eVar = this.c;
        dataOutput.writeInt((this.a.getValue() << 28) + ((this.b + 32) << 22) + ((eVar == null ? 0 : eVar.getValue()) << 19) + (G << 14) + (this.f.ordinal() << 12) + (i << 4) + (i2 << 2) + i3);
        if (G == 31) {
            dataOutput.writeInt(T);
        }
        if (i == 255) {
            dataOutput.writeInt(I);
        }
        if (i2 == 3) {
            dataOutput.writeInt(zoneOffset.I());
        }
        if (i3 == 3) {
            dataOutput.writeInt(zoneOffset2.I());
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.a == eVar.a && this.b == eVar.b && this.c == eVar.c && this.f == eVar.f && this.d.equals(eVar.d) && this.e == eVar.e && this.g.equals(eVar.g) && this.h.equals(eVar.h) && this.i.equals(eVar.i);
    }

    public final int hashCode() {
        int T = ((this.d.T() + (this.e ? 1 : 0)) << 15) + (this.a.ordinal() << 11) + ((this.b + 32) << 5);
        j$.time.e eVar = this.c;
        return ((this.g.hashCode() ^ (this.f.ordinal() + (T + ((eVar == null ? 7 : eVar.ordinal()) << 2)))) ^ this.h.hashCode()) ^ this.i.hashCode();
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("TransitionRule[");
        ZoneOffset zoneOffset = this.h;
        ZoneOffset zoneOffset2 = this.i;
        sb.append(zoneOffset.compareTo(zoneOffset2) > 0 ? "Gap " : "Overlap ");
        sb.append(zoneOffset);
        sb.append(" to ");
        sb.append(zoneOffset2);
        sb.append(", ");
        m mVar = this.a;
        byte b = this.b;
        j$.time.e eVar = this.c;
        if (eVar == null) {
            sb.append(mVar.name());
            sb.append(' ');
            sb.append(b);
        } else {
            if (b == -1) {
                sb.append(eVar.name());
                str = " on or before last day of ";
            } else if (b < 0) {
                sb.append(eVar.name());
                sb.append(" on or before last day minus ");
                sb.append((-b) - 1);
                str = " of ";
            } else {
                sb.append(eVar.name());
                sb.append(" on or after ");
                sb.append(mVar.name());
                sb.append(' ');
                sb.append(b);
            }
            sb.append(str);
            sb.append(mVar.name());
        }
        sb.append(" at ");
        sb.append(this.e ? "24:00" : this.d.toString());
        sb.append(" ");
        sb.append(this.f);
        sb.append(", standard offset ");
        sb.append(this.g);
        sb.append(']');
        return sb.toString();
    }
}
