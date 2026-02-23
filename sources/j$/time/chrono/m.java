package j$.time.chrono;

import j$.time.Instant;
import j$.time.LocalDateTime;
import j$.time.ZoneId;
import j$.time.ZoneOffset;
import j$.util.Objects;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.Serializable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
final class m implements k, Serializable {
    private static final long serialVersionUID = -5261813987200935591L;
    private final transient g a;
    private final transient ZoneOffset b;
    private final transient ZoneId c;

    private m(ZoneId zoneId, ZoneOffset zoneOffset, g gVar) {
        Objects.a(gVar, "dateTime");
        this.a = gVar;
        Objects.a(zoneOffset, "offset");
        this.b = zoneOffset;
        Objects.a(zoneId, "zone");
        this.c = zoneId;
    }

    static m C(n nVar, j$.time.temporal.m mVar) {
        m mVar2 = (m) mVar;
        a aVar = (a) nVar;
        if (aVar.equals(mVar2.a())) {
            return mVar2;
        }
        throw new ClassCastException("Chronology mismatch, required: " + aVar.getId() + ", actual: " + mVar2.a().getId());
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static j$.time.chrono.k E(j$.time.ZoneId r6, j$.time.ZoneOffset r7, j$.time.chrono.g r8) {
        /*
            java.lang.String r0 = "localDateTime"
            j$.util.Objects.a(r8, r0)
            java.lang.String r0 = "zone"
            j$.util.Objects.a(r6, r0)
            boolean r0 = r6 instanceof j$.time.ZoneOffset
            if (r0 == 0) goto L17
            j$.time.chrono.m r7 = new j$.time.chrono.m
            r0 = r6
            j$.time.ZoneOffset r0 = (j$.time.ZoneOffset) r0
            r7.<init>(r6, r0, r8)
            return r7
        L17:
            j$.time.zone.f r0 = r6.C()
            j$.time.LocalDateTime r1 = j$.time.LocalDateTime.D(r8)
            java.util.List r2 = r0.g(r1)
            int r3 = r2.size()
            r4 = 1
            r5 = 0
            if (r3 != r4) goto L32
        L2b:
            java.lang.Object r7 = r2.get(r5)
            j$.time.ZoneOffset r7 = (j$.time.ZoneOffset) r7
            goto L55
        L32:
            int r3 = r2.size()
            if (r3 != 0) goto L4d
            j$.time.zone.b r7 = r0.f(r1)
            j$.time.Duration r0 = r7.l()
            long r0 = r0.k()
            j$.time.chrono.g r8 = r8.G(r0)
            j$.time.ZoneOffset r7 = r7.q()
            goto L55
        L4d:
            if (r7 == 0) goto L2b
            boolean r0 = r2.contains(r7)
            if (r0 == 0) goto L2b
        L55:
            java.lang.String r0 = "offset"
            j$.util.Objects.a(r7, r0)
            j$.time.chrono.m r0 = new j$.time.chrono.m
            r0.<init>(r6, r7, r8)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.chrono.m.E(j$.time.ZoneId, j$.time.ZoneOffset, j$.time.chrono.g):j$.time.chrono.k");
    }

    static m F(n nVar, Instant instant, ZoneId zoneId) {
        ZoneOffset d = zoneId.C().d(instant);
        Objects.a(d, "offset");
        return new m(zoneId, d, (g) nVar.m(LocalDateTime.L(instant.getEpochSecond(), instant.D(), d)));
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new G((byte) 3, this);
    }

    public final /* synthetic */ long B() {
        return i.o(this);
    }

    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public final k y(long j, j$.time.temporal.u uVar) {
        return C(a(), j$.time.temporal.n.b(this, j, uVar));
    }

    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public final k e(long j, j$.time.temporal.u uVar) {
        if (!(uVar instanceof j$.time.temporal.b)) {
            return C(a(), uVar.i(this, j));
        }
        return C(a(), this.a.e(j, uVar).u(this));
    }

    public final n a() {
        return c().a();
    }

    public final j$.time.k b() {
        return ((g) w()).b();
    }

    public final b c() {
        return ((g) w()).c();
    }

    public final j$.time.temporal.m d(long j, j$.time.temporal.r rVar) {
        if (!(rVar instanceof j$.time.temporal.a)) {
            return C(a(), rVar.q(this, j));
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) rVar;
        int i = l.a[aVar.ordinal()];
        if (i == 1) {
            return e(j - i.o(this), j$.time.temporal.b.SECONDS);
        }
        ZoneId zoneId = this.c;
        g gVar = this.a;
        if (i != 2) {
            return E(zoneId, this.b, gVar.d(j, rVar));
        }
        ZoneOffset L = ZoneOffset.L(aVar.y(j));
        gVar.getClass();
        return F(a(), Instant.F(i.n(gVar, L), gVar.b().H()), zoneId);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof k) && i.d(this, (k) obj) == 0;
    }

    public final boolean f(j$.time.temporal.r rVar) {
        return (rVar instanceof j$.time.temporal.a) || (rVar != null && rVar.l(this));
    }

    public final ZoneOffset g() {
        return this.b;
    }

    public final k h(ZoneId zoneId) {
        return E(zoneId, this.b, this.a);
    }

    public final int hashCode() {
        return (this.a.hashCode() ^ this.b.hashCode()) ^ Integer.rotateLeft(this.c.hashCode(), 3);
    }

    public final /* synthetic */ int i(j$.time.temporal.r rVar) {
        return i.e(this, rVar);
    }

    public final j$.time.temporal.m k(j$.time.h hVar) {
        return C(a(), hVar.u(this));
    }

    public final j$.time.temporal.w l(j$.time.temporal.r rVar) {
        return rVar instanceof j$.time.temporal.a ? (rVar == j$.time.temporal.a.INSTANT_SECONDS || rVar == j$.time.temporal.a.OFFSET_SECONDS) ? ((j$.time.temporal.a) rVar).i() : ((g) w()).l(rVar) : rVar.t(this);
    }

    public final ZoneId o() {
        return this.c;
    }

    public final long q(j$.time.temporal.r rVar) {
        if (!(rVar instanceof j$.time.temporal.a)) {
            return rVar.k(this);
        }
        int i = j.a[((j$.time.temporal.a) rVar).ordinal()];
        return i != 1 ? i != 2 ? ((g) w()).q(rVar) : g().I() : B();
    }

    public final /* synthetic */ Object t(j$.time.temporal.t tVar) {
        return i.l(this, tVar);
    }

    public final String toString() {
        String gVar = this.a.toString();
        ZoneOffset zoneOffset = this.b;
        String str = gVar + zoneOffset.toString();
        ZoneId zoneId = this.c;
        if (zoneOffset == zoneId) {
            return str;
        }
        return str + "[" + zoneId.toString() + "]";
    }

    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public final /* synthetic */ int compareTo(k kVar) {
        return i.d(this, kVar);
    }

    public final e w() {
        return this.a;
    }

    final void writeExternal(ObjectOutput objectOutput) {
        objectOutput.writeObject(this.a);
        objectOutput.writeObject(this.b);
        objectOutput.writeObject(this.c);
    }
}
