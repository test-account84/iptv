package j$.time;

import j$.util.Objects;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.Serializable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public final class OffsetDateTime implements j$.time.temporal.m, j$.time.temporal.p, Comparable, Serializable {
    private static final long serialVersionUID = 2287754244819255394L;
    private final LocalDateTime a;
    private final ZoneOffset b;

    static {
        LocalDateTime localDateTime = LocalDateTime.c;
        ZoneOffset zoneOffset = ZoneOffset.g;
        localDateTime.getClass();
        C(localDateTime, zoneOffset);
        LocalDateTime localDateTime2 = LocalDateTime.d;
        ZoneOffset zoneOffset2 = ZoneOffset.f;
        localDateTime2.getClass();
        C(localDateTime2, zoneOffset2);
    }

    private OffsetDateTime(LocalDateTime localDateTime, ZoneOffset zoneOffset) {
        Objects.a(localDateTime, "dateTime");
        this.a = localDateTime;
        Objects.a(zoneOffset, "offset");
        this.b = zoneOffset;
    }

    public static OffsetDateTime C(LocalDateTime localDateTime, ZoneOffset zoneOffset) {
        return new OffsetDateTime(localDateTime, zoneOffset);
    }

    public static OffsetDateTime D(Instant instant, ZoneId zoneId) {
        Objects.a(instant, "instant");
        Objects.a(zoneId, "zone");
        ZoneOffset d = zoneId.C().d(instant);
        return new OffsetDateTime(LocalDateTime.L(instant.getEpochSecond(), instant.D(), d), d);
    }

    static OffsetDateTime F(ObjectInput objectInput) {
        LocalDateTime localDateTime = LocalDateTime.c;
        h hVar = h.d;
        return new OffsetDateTime(LocalDateTime.K(h.N(objectInput.readInt(), objectInput.readByte(), objectInput.readByte()), k.R(objectInput)), ZoneOffset.N(objectInput));
    }

    private OffsetDateTime G(LocalDateTime localDateTime, ZoneOffset zoneOffset) {
        return (this.a == localDateTime && this.b.equals(zoneOffset)) ? this : new OffsetDateTime(localDateTime, zoneOffset);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new s((byte) 10, this);
    }

    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public final OffsetDateTime e(long j, j$.time.temporal.u uVar) {
        return uVar instanceof j$.time.temporal.b ? G(this.a.e(j, uVar), this.b) : (OffsetDateTime) uVar.i(this, j);
    }

    public final int compareTo(Object obj) {
        int H;
        OffsetDateTime offsetDateTime = (OffsetDateTime) obj;
        ZoneOffset zoneOffset = offsetDateTime.b;
        ZoneOffset zoneOffset2 = this.b;
        if (zoneOffset2.equals(zoneOffset)) {
            H = toLocalDateTime().compareTo(offsetDateTime.toLocalDateTime());
        } else {
            LocalDateTime localDateTime = this.a;
            localDateTime.getClass();
            long n = j$.time.chrono.i.n(localDateTime, zoneOffset2);
            LocalDateTime localDateTime2 = offsetDateTime.a;
            localDateTime2.getClass();
            int compare = Long.compare(n, j$.time.chrono.i.n(localDateTime2, offsetDateTime.b));
            H = compare == 0 ? localDateTime.b().H() - localDateTime2.b().H() : compare;
        }
        return H == 0 ? toLocalDateTime().compareTo(offsetDateTime.toLocalDateTime()) : H;
    }

    public final j$.time.temporal.m d(long j, j$.time.temporal.r rVar) {
        if (!(rVar instanceof j$.time.temporal.a)) {
            return (OffsetDateTime) rVar.q(this, j);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) rVar;
        int i = p.a[aVar.ordinal()];
        ZoneOffset zoneOffset = this.b;
        LocalDateTime localDateTime = this.a;
        return i != 1 ? i != 2 ? G(localDateTime.d(j, rVar), zoneOffset) : G(localDateTime, ZoneOffset.L(aVar.y(j))) : D(Instant.F(j, localDateTime.E()), zoneOffset);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OffsetDateTime)) {
            return false;
        }
        OffsetDateTime offsetDateTime = (OffsetDateTime) obj;
        return this.a.equals(offsetDateTime.a) && this.b.equals(offsetDateTime.b);
    }

    public final boolean f(j$.time.temporal.r rVar) {
        return (rVar instanceof j$.time.temporal.a) || (rVar != null && rVar.l(this));
    }

    public final int hashCode() {
        return this.a.hashCode() ^ this.b.hashCode();
    }

    public final int i(j$.time.temporal.r rVar) {
        if (!(rVar instanceof j$.time.temporal.a)) {
            return j$.time.temporal.n.a(this, rVar);
        }
        int i = p.a[((j$.time.temporal.a) rVar).ordinal()];
        if (i != 1) {
            return i != 2 ? this.a.i(rVar) : this.b.I();
        }
        throw new j$.time.temporal.v("Invalid field 'InstantSeconds' for get() method, use getLong() instead");
    }

    public final j$.time.temporal.m k(h hVar) {
        return G(this.a.R(hVar), this.b);
    }

    public final j$.time.temporal.w l(j$.time.temporal.r rVar) {
        return rVar instanceof j$.time.temporal.a ? (rVar == j$.time.temporal.a.INSTANT_SECONDS || rVar == j$.time.temporal.a.OFFSET_SECONDS) ? ((j$.time.temporal.a) rVar).i() : this.a.l(rVar) : rVar.t(this);
    }

    public final long q(j$.time.temporal.r rVar) {
        if (!(rVar instanceof j$.time.temporal.a)) {
            return rVar.k(this);
        }
        int i = p.a[((j$.time.temporal.a) rVar).ordinal()];
        ZoneOffset zoneOffset = this.b;
        LocalDateTime localDateTime = this.a;
        if (i != 1) {
            return i != 2 ? localDateTime.q(rVar) : zoneOffset.I();
        }
        localDateTime.getClass();
        return j$.time.chrono.i.n(localDateTime, zoneOffset);
    }

    public final Object t(j$.time.temporal.t tVar) {
        if (tVar == j$.time.temporal.n.h() || tVar == j$.time.temporal.n.j()) {
            return this.b;
        }
        if (tVar == j$.time.temporal.n.k()) {
            return null;
        }
        j$.time.temporal.t f = j$.time.temporal.n.f();
        LocalDateTime localDateTime = this.a;
        return tVar == f ? localDateTime.P() : tVar == j$.time.temporal.n.g() ? localDateTime.b() : tVar == j$.time.temporal.n.e() ? j$.time.chrono.u.d : tVar == j$.time.temporal.n.i() ? j$.time.temporal.b.NANOS : tVar.a(this);
    }

    public LocalDateTime toLocalDateTime() {
        return this.a;
    }

    public final String toString() {
        return this.a.toString() + this.b.toString();
    }

    public final j$.time.temporal.m u(j$.time.temporal.m mVar) {
        j$.time.temporal.a aVar = j$.time.temporal.a.EPOCH_DAY;
        LocalDateTime localDateTime = this.a;
        return mVar.d(localDateTime.P().r(), aVar).d(localDateTime.b().S(), j$.time.temporal.a.NANO_OF_DAY).d(this.b.I(), j$.time.temporal.a.OFFSET_SECONDS);
    }

    final void writeExternal(ObjectOutput objectOutput) {
        this.a.T(objectOutput);
        this.b.O(objectOutput);
    }

    public final j$.time.temporal.m y(long j, j$.time.temporal.u uVar) {
        return j == Long.MIN_VALUE ? e(Long.MAX_VALUE, uVar).e(1L, uVar) : e(-j, uVar);
    }
}
