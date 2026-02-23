package j$.time;

import j$.time.format.DateTimeFormatter;
import j$.util.Objects;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public final class LocalDateTime implements j$.time.temporal.m, j$.time.temporal.p, j$.time.chrono.e, Serializable {
    public static final LocalDateTime c = K(h.d, k.e);
    public static final LocalDateTime d = K(h.e, k.f);
    private static final long serialVersionUID = 6207766400415563566L;
    private final h a;
    private final k b;

    private LocalDateTime(h hVar, k kVar) {
        this.a = hVar;
        this.b = kVar;
    }

    private int C(LocalDateTime localDateTime) {
        int C = this.a.C(localDateTime.a);
        return C == 0 ? this.b.C(localDateTime.b) : C;
    }

    public static LocalDateTime D(j$.time.temporal.o oVar) {
        if (oVar instanceof LocalDateTime) {
            return (LocalDateTime) oVar;
        }
        if (oVar instanceof z) {
            return ((z) oVar).H();
        }
        if (oVar instanceof OffsetDateTime) {
            return ((OffsetDateTime) oVar).toLocalDateTime();
        }
        try {
            return new LocalDateTime(h.E(oVar), k.E(oVar));
        } catch (c e) {
            throw new c("Unable to obtain LocalDateTime from TemporalAccessor: " + oVar + " of type " + oVar.getClass().getName(), e);
        }
    }

    public static LocalDateTime J(int i) {
        return new LocalDateTime(h.N(i, 12, 31), k.J(0));
    }

    public static LocalDateTime K(h hVar, k kVar) {
        Objects.a(hVar, "date");
        Objects.a(kVar, "time");
        return new LocalDateTime(hVar, kVar);
    }

    public static LocalDateTime L(long j, int i, ZoneOffset zoneOffset) {
        Objects.a(zoneOffset, "offset");
        long j2 = i;
        j$.time.temporal.a.NANO_OF_SECOND.C(j2);
        return new LocalDateTime(h.P(j$.com.android.tools.r8.a.n(j + zoneOffset.I(), 86400)), k.K((((int) j$.com.android.tools.r8.a.m(r5, r7)) * 1000000000) + j2));
    }

    private LocalDateTime O(h hVar, long j, long j2, long j3, long j4) {
        long j5 = j | j2 | j3 | j4;
        k kVar = this.b;
        if (j5 == 0) {
            return S(hVar, kVar);
        }
        long j6 = j / 24;
        long j7 = j6 + (j2 / 1440) + (j3 / 86400) + (j4 / 86400000000000L);
        long j8 = 1;
        long j9 = ((j % 24) * 3600000000000L) + ((j2 % 1440) * 60000000000L) + ((j3 % 86400) * 1000000000) + (j4 % 86400000000000L);
        long S = kVar.S();
        long j10 = (j9 * j8) + S;
        long n = j$.com.android.tools.r8.a.n(j10, 86400000000000L) + (j7 * j8);
        long m = j$.com.android.tools.r8.a.m(j10, 86400000000000L);
        if (m != S) {
            kVar = k.K(m);
        }
        return S(hVar.R(n), kVar);
    }

    private LocalDateTime S(h hVar, k kVar) {
        return (this.a == hVar && this.b == kVar) ? this : new LocalDateTime(hVar, kVar);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new s((byte) 5, this);
    }

    public final int E() {
        return this.b.H();
    }

    public final int F() {
        return this.b.I();
    }

    public final int G() {
        return this.a.J();
    }

    public final boolean H(LocalDateTime localDateTime) {
        if (localDateTime instanceof LocalDateTime) {
            return C(localDateTime) > 0;
        }
        long r = this.a.r();
        long r2 = localDateTime.a.r();
        return r > r2 || (r == r2 && this.b.S() > localDateTime.b.S());
    }

    public final boolean I(LocalDateTime localDateTime) {
        if (localDateTime instanceof LocalDateTime) {
            return C(localDateTime) < 0;
        }
        long r = this.a.r();
        long r2 = localDateTime.a.r();
        return r < r2 || (r == r2 && this.b.S() < localDateTime.b.S());
    }

    /* renamed from: M, reason: merged with bridge method [inline-methods] */
    public final LocalDateTime e(long j, j$.time.temporal.u uVar) {
        if (!(uVar instanceof j$.time.temporal.b)) {
            return (LocalDateTime) uVar.i(this, j);
        }
        int i = i.a[((j$.time.temporal.b) uVar).ordinal()];
        k kVar = this.b;
        h hVar = this.a;
        switch (i) {
            case 1:
                return O(this.a, 0L, 0L, 0L, j);
            case 2:
                LocalDateTime S = S(hVar.R(j / 86400000000L), kVar);
                return S.O(S.a, 0L, 0L, 0L, (j % 86400000000L) * 1000);
            case 3:
                LocalDateTime S2 = S(hVar.R(j / 86400000), kVar);
                return S2.O(S2.a, 0L, 0L, 0L, (j % 86400000) * 1000000);
            case 4:
                return N(j);
            case 5:
                return O(this.a, 0L, j, 0L, 0L);
            case 6:
                return O(this.a, j, 0L, 0L, 0L);
            case 7:
                LocalDateTime S3 = S(hVar.R(j / 256), kVar);
                return S3.O(S3.a, (j % 256) * 12, 0L, 0L, 0L);
            default:
                return S(hVar.Q(j, uVar), kVar);
        }
    }

    public final LocalDateTime N(long j) {
        return O(this.a, 0L, 0L, j, 0L);
    }

    public final h P() {
        return this.a;
    }

    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public final LocalDateTime d(long j, j$.time.temporal.r rVar) {
        if (!(rVar instanceof j$.time.temporal.a)) {
            return (LocalDateTime) rVar.q(this, j);
        }
        boolean D = ((j$.time.temporal.a) rVar).D();
        k kVar = this.b;
        h hVar = this.a;
        return D ? S(hVar, kVar.U(j, rVar)) : S(hVar.V(j, rVar), kVar);
    }

    public final LocalDateTime R(h hVar) {
        return S(hVar, this.b);
    }

    final void T(DataOutput dataOutput) {
        this.a.Z(dataOutput);
        this.b.W(dataOutput);
    }

    public final j$.time.chrono.n a() {
        return ((h) c()).a();
    }

    public final k b() {
        return this.b;
    }

    public final j$.time.chrono.b c() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocalDateTime)) {
            return false;
        }
        LocalDateTime localDateTime = (LocalDateTime) obj;
        return this.a.equals(localDateTime.a) && this.b.equals(localDateTime.b);
    }

    public final boolean f(j$.time.temporal.r rVar) {
        if (!(rVar instanceof j$.time.temporal.a)) {
            return rVar != null && rVar.l(this);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) rVar;
        return aVar.u() || aVar.D();
    }

    public String format(DateTimeFormatter dateTimeFormatter) {
        Objects.a(dateTimeFormatter, "formatter");
        return dateTimeFormatter.a(this);
    }

    public final int hashCode() {
        return this.a.hashCode() ^ this.b.hashCode();
    }

    public final int i(j$.time.temporal.r rVar) {
        return rVar instanceof j$.time.temporal.a ? ((j$.time.temporal.a) rVar).D() ? this.b.i(rVar) : this.a.i(rVar) : j$.time.temporal.n.a(this, rVar);
    }

    public final j$.time.temporal.m k(h hVar) {
        return S(hVar, this.b);
    }

    public final j$.time.temporal.w l(j$.time.temporal.r rVar) {
        if (!(rVar instanceof j$.time.temporal.a)) {
            return rVar.t(this);
        }
        if (!((j$.time.temporal.a) rVar).D()) {
            return this.a.l(rVar);
        }
        k kVar = this.b;
        kVar.getClass();
        return j$.time.temporal.n.d(kVar, rVar);
    }

    public final j$.time.chrono.k n(ZoneOffset zoneOffset) {
        return z.E(this, zoneOffset, null);
    }

    public final long q(j$.time.temporal.r rVar) {
        return rVar instanceof j$.time.temporal.a ? ((j$.time.temporal.a) rVar).D() ? this.b.q(rVar) : this.a.q(rVar) : rVar.k(this);
    }

    public final Object t(j$.time.temporal.t tVar) {
        return tVar == j$.time.temporal.n.f() ? this.a : j$.time.chrono.i.k(this, tVar);
    }

    public final String toString() {
        return this.a.toString() + "T" + this.b.toString();
    }

    public final j$.time.temporal.m u(j$.time.temporal.m mVar) {
        return mVar.d(((h) c()).r(), j$.time.temporal.a.EPOCH_DAY).d(b().S(), j$.time.temporal.a.NANO_OF_DAY);
    }

    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public final int compareTo(j$.time.chrono.e eVar) {
        return eVar instanceof LocalDateTime ? C((LocalDateTime) eVar) : j$.time.chrono.i.c(this, eVar);
    }

    public final j$.time.temporal.m y(long j, j$.time.temporal.u uVar) {
        return j == Long.MIN_VALUE ? e(Long.MAX_VALUE, uVar).e(1L, uVar) : e(-j, uVar);
    }
}
