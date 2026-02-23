package j$.time;

import j$.util.Objects;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public final class z implements j$.time.temporal.m, j$.time.chrono.k, Serializable {
    private static final long serialVersionUID = -6260982410461394882L;
    private final LocalDateTime a;
    private final ZoneOffset b;
    private final ZoneId c;

    private z(LocalDateTime localDateTime, ZoneId zoneId, ZoneOffset zoneOffset) {
        this.a = localDateTime;
        this.b = zoneOffset;
        this.c = zoneId;
    }

    private static z C(long j, int i, ZoneId zoneId) {
        ZoneOffset d = zoneId.C().d(Instant.F(j, i));
        return new z(LocalDateTime.L(j, i, d), zoneId, d);
    }

    public static z D(Instant instant, ZoneId zoneId) {
        Objects.a(instant, "instant");
        return C(instant.getEpochSecond(), instant.D(), zoneId);
    }

    public static z E(LocalDateTime localDateTime, ZoneId zoneId, ZoneOffset zoneOffset) {
        Objects.a(localDateTime, "localDateTime");
        Objects.a(zoneId, "zone");
        if (zoneId instanceof ZoneOffset) {
            return new z(localDateTime, zoneId, (ZoneOffset) zoneId);
        }
        j$.time.zone.f C = zoneId.C();
        List g = C.g(localDateTime);
        if (g.size() == 1) {
            zoneOffset = (ZoneOffset) g.get(0);
        } else if (g.size() == 0) {
            j$.time.zone.b f = C.f(localDateTime);
            localDateTime = localDateTime.N(f.l().k());
            zoneOffset = f.q();
        } else if (zoneOffset == null || !g.contains(zoneOffset)) {
            zoneOffset = (ZoneOffset) g.get(0);
            Objects.a(zoneOffset, "offset");
        }
        return new z(localDateTime, zoneId, zoneOffset);
    }

    static z G(ObjectInput objectInput) {
        LocalDateTime localDateTime = LocalDateTime.c;
        h hVar = h.d;
        LocalDateTime K = LocalDateTime.K(h.N(objectInput.readInt(), objectInput.readByte(), objectInput.readByte()), k.R(objectInput));
        ZoneOffset N = ZoneOffset.N(objectInput);
        ZoneId zoneId = (ZoneId) s.a(objectInput);
        Objects.a(zoneId, "zone");
        if (!(zoneId instanceof ZoneOffset) || N.equals(zoneId)) {
            return new z(K, zoneId, N);
        }
        throw new IllegalArgumentException("ZoneId must match ZoneOffset");
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new s((byte) 6, this);
    }

    public final /* synthetic */ long B() {
        return j$.time.chrono.i.o(this);
    }

    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public final z e(long j, j$.time.temporal.u uVar) {
        if (!(uVar instanceof j$.time.temporal.b)) {
            return (z) uVar.i(this, j);
        }
        j$.time.temporal.b bVar = (j$.time.temporal.b) uVar;
        int compareTo = bVar.compareTo(j$.time.temporal.b.DAYS);
        ZoneOffset zoneOffset = this.b;
        ZoneId zoneId = this.c;
        LocalDateTime localDateTime = this.a;
        if (compareTo >= 0 && bVar != j$.time.temporal.b.FOREVER) {
            return E(localDateTime.e(j, uVar), zoneId, zoneOffset);
        }
        LocalDateTime e = localDateTime.e(j, uVar);
        Objects.a(e, "localDateTime");
        Objects.a(zoneOffset, "offset");
        Objects.a(zoneId, "zone");
        return zoneId.C().g(e).contains(zoneOffset) ? new z(e, zoneId, zoneOffset) : C(j$.time.chrono.i.n(e, zoneOffset), e.E(), zoneId);
    }

    public final LocalDateTime H() {
        return this.a;
    }

    /* renamed from: I, reason: merged with bridge method [inline-methods] */
    public final z k(h hVar) {
        return E(LocalDateTime.K(hVar, this.a.b()), this.c, this.b);
    }

    final void J(DataOutput dataOutput) {
        this.a.T(dataOutput);
        this.b.O(dataOutput);
        this.c.G(dataOutput);
    }

    public final j$.time.chrono.n a() {
        return ((h) c()).a();
    }

    public final k b() {
        return this.a.b();
    }

    public final j$.time.chrono.b c() {
        return this.a.P();
    }

    public final j$.time.temporal.m d(long j, j$.time.temporal.r rVar) {
        if (!(rVar instanceof j$.time.temporal.a)) {
            return (z) rVar.q(this, j);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) rVar;
        int i = y.a[aVar.ordinal()];
        LocalDateTime localDateTime = this.a;
        ZoneId zoneId = this.c;
        if (i == 1) {
            return C(j, localDateTime.E(), zoneId);
        }
        ZoneOffset zoneOffset = this.b;
        if (i != 2) {
            return E(localDateTime.d(j, rVar), zoneId, zoneOffset);
        }
        ZoneOffset L = ZoneOffset.L(aVar.y(j));
        return (L.equals(zoneOffset) || !zoneId.C().g(localDateTime).contains(L)) ? this : new z(localDateTime, zoneId, L);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof z)) {
            return false;
        }
        z zVar = (z) obj;
        return this.a.equals(zVar.a) && this.b.equals(zVar.b) && this.c.equals(zVar.c);
    }

    public final boolean f(j$.time.temporal.r rVar) {
        return (rVar instanceof j$.time.temporal.a) || (rVar != null && rVar.l(this));
    }

    public final ZoneOffset g() {
        return this.b;
    }

    public final j$.time.chrono.k h(ZoneId zoneId) {
        Objects.a(zoneId, "zone");
        return this.c.equals(zoneId) ? this : E(this.a, zoneId, this.b);
    }

    public final int hashCode() {
        return (this.a.hashCode() ^ this.b.hashCode()) ^ Integer.rotateLeft(this.c.hashCode(), 3);
    }

    public final int i(j$.time.temporal.r rVar) {
        if (!(rVar instanceof j$.time.temporal.a)) {
            return j$.time.chrono.i.e(this, rVar);
        }
        int i = y.a[((j$.time.temporal.a) rVar).ordinal()];
        if (i != 1) {
            return i != 2 ? this.a.i(rVar) : this.b.I();
        }
        throw new j$.time.temporal.v("Invalid field 'InstantSeconds' for get() method, use getLong() instead");
    }

    public final j$.time.temporal.w l(j$.time.temporal.r rVar) {
        return rVar instanceof j$.time.temporal.a ? (rVar == j$.time.temporal.a.INSTANT_SECONDS || rVar == j$.time.temporal.a.OFFSET_SECONDS) ? ((j$.time.temporal.a) rVar).i() : this.a.l(rVar) : rVar.t(this);
    }

    public final ZoneId o() {
        return this.c;
    }

    public final long q(j$.time.temporal.r rVar) {
        if (!(rVar instanceof j$.time.temporal.a)) {
            return rVar.k(this);
        }
        int i = y.a[((j$.time.temporal.a) rVar).ordinal()];
        return i != 1 ? i != 2 ? this.a.q(rVar) : this.b.I() : j$.time.chrono.i.o(this);
    }

    public final Object t(j$.time.temporal.t tVar) {
        return tVar == j$.time.temporal.n.f() ? this.a.P() : j$.time.chrono.i.l(this, tVar);
    }

    public final String toString() {
        String localDateTime = this.a.toString();
        ZoneOffset zoneOffset = this.b;
        String str = localDateTime + zoneOffset.toString();
        ZoneId zoneId = this.c;
        if (zoneOffset == zoneId) {
            return str;
        }
        return str + "[" + zoneId.toString() + "]";
    }

    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public final /* synthetic */ int compareTo(j$.time.chrono.k kVar) {
        return j$.time.chrono.i.d(this, kVar);
    }

    public final j$.time.chrono.e w() {
        return this.a;
    }

    public final j$.time.temporal.m y(long j, j$.time.temporal.u uVar) {
        return j == Long.MIN_VALUE ? e(Long.MAX_VALUE, uVar).e(1L, uVar) : e(-j, uVar);
    }
}
