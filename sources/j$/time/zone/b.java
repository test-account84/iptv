package j$.time.zone;

import j$.time.Duration;
import j$.time.LocalDateTime;
import j$.time.ZoneOffset;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public final class b implements Comparable, Serializable {
    private static final long serialVersionUID = -6946044323557704546L;
    private final long a;
    private final LocalDateTime b;
    private final ZoneOffset c;
    private final ZoneOffset d;

    b(long j, ZoneOffset zoneOffset, ZoneOffset zoneOffset2) {
        this.a = j;
        this.b = LocalDateTime.L(j, 0, zoneOffset);
        this.c = zoneOffset;
        this.d = zoneOffset2;
    }

    b(LocalDateTime localDateTime, ZoneOffset zoneOffset, ZoneOffset zoneOffset2) {
        localDateTime.getClass();
        this.a = j$.time.chrono.i.n(localDateTime, zoneOffset);
        this.b = localDateTime;
        this.c = zoneOffset;
        this.d = zoneOffset2;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new a((byte) 2, this);
    }

    public final long B() {
        return this.a;
    }

    final void C(DataOutput dataOutput) {
        a.c(this.a, dataOutput);
        a.d(this.c, dataOutput);
        a.d(this.d, dataOutput);
    }

    public final int compareTo(Object obj) {
        return Long.compare(this.a, ((b) obj).a);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.a == bVar.a && this.c.equals(bVar.c) && this.d.equals(bVar.d);
    }

    public final int hashCode() {
        return (this.b.hashCode() ^ this.c.hashCode()) ^ Integer.rotateLeft(this.d.hashCode(), 16);
    }

    public final LocalDateTime i() {
        return this.b.N(this.d.I() - this.c.I());
    }

    public final LocalDateTime k() {
        return this.b;
    }

    public final Duration l() {
        return Duration.l(this.d.I() - this.c.I());
    }

    public final ZoneOffset q() {
        return this.d;
    }

    public final ZoneOffset t() {
        return this.c;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Transition[");
        sb.append(y() ? "Gap" : "Overlap");
        sb.append(" at ");
        sb.append(this.b);
        sb.append(this.c);
        sb.append(" to ");
        sb.append(this.d);
        sb.append(']');
        return sb.toString();
    }

    final List u() {
        return y() ? Collections.emptyList() : j$.com.android.tools.r8.a.k(new Object[]{this.c, this.d});
    }

    public final boolean y() {
        return this.d.I() > this.c.I();
    }
}
