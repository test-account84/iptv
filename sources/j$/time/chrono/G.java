package j$.time.chrono;

import j$.time.ZoneOffset;
import j$.util.Objects;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.Serializable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
final class g implements e, j$.time.temporal.m, j$.time.temporal.p, Serializable {
    private static final long serialVersionUID = 4556003607393004514L;
    private final transient b a;
    private final transient j$.time.k b;

    private g(b bVar, j$.time.k kVar) {
        Objects.a(bVar, "date");
        Objects.a(kVar, "time");
        this.a = bVar;
        this.b = kVar;
    }

    static g C(n nVar, j$.time.temporal.m mVar) {
        g gVar = (g) mVar;
        a aVar = (a) nVar;
        if (aVar.equals(gVar.a.a())) {
            return gVar;
        }
        throw new ClassCastException("Chronology mismatch, required: " + aVar.getId() + ", actual: " + gVar.a.a().getId());
    }

    static g E(b bVar, j$.time.k kVar) {
        return new g(bVar, kVar);
    }

    private g H(b bVar, long j, long j2, long j3, long j4) {
        long j5 = j | j2 | j3 | j4;
        j$.time.k kVar = this.b;
        if (j5 == 0) {
            return J(bVar, kVar);
        }
        long j6 = j2 / 1440;
        long j7 = j / 24;
        long j8 = (j2 % 1440) * 60000000000L;
        long j9 = ((j % 24) * 3600000000000L) + j8 + ((j3 % 86400) * 1000000000) + (j4 % 86400000000000L);
        long S = kVar.S();
        long j10 = j9 + S;
        long n = j$.com.android.tools.r8.a.n(j10, 86400000000000L) + j7 + j6 + (j3 / 86400) + (j4 / 86400000000000L);
        long m = j$.com.android.tools.r8.a.m(j10, 86400000000000L);
        if (m != S) {
            kVar = j$.time.k.K(m);
        }
        return J(bVar.e(n, (j$.time.temporal.u) j$.time.temporal.b.DAYS), kVar);
    }

    private g J(j$.time.temporal.m mVar, j$.time.k kVar) {
        b bVar = this.a;
        return (bVar == mVar && this.b == kVar) ? this : new g(d.C(bVar.a(), mVar), kVar);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new G((byte) 2, this);
    }

    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public final e y(long j, j$.time.temporal.u uVar) {
        return C(a(), j$.time.temporal.n.b(this, j, uVar));
    }

    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public final g e(long j, j$.time.temporal.u uVar) {
        boolean z = uVar instanceof j$.time.temporal.b;
        b bVar = this.a;
        if (!z) {
            return C(bVar.a(), uVar.i(this, j));
        }
        int i = f.a[((j$.time.temporal.b) uVar).ordinal()];
        j$.time.k kVar = this.b;
        switch (i) {
            case 1:
                return H(this.a, 0L, 0L, 0L, j);
            case 2:
                g J = J(bVar.e(j / 86400000000L, (j$.time.temporal.u) j$.time.temporal.b.DAYS), kVar);
                return J.H(J.a, 0L, 0L, 0L, (j % 86400000000L) * 1000);
            case 3:
                g J2 = J(bVar.e(j / 86400000, (j$.time.temporal.u) j$.time.temporal.b.DAYS), kVar);
                return J2.H(J2.a, 0L, 0L, 0L, (j % 86400000) * 1000000);
            case 4:
                return G(j);
            case 5:
                return H(this.a, 0L, j, 0L, 0L);
            case 6:
                return H(this.a, j, 0L, 0L, 0L);
            case 7:
                g J3 = J(bVar.e(j / 256, (j$.time.temporal.u) j$.time.temporal.b.DAYS), kVar);
                return J3.H(J3.a, (j % 256) * 12, 0L, 0L, 0L);
            default:
                return J(bVar.e(j, uVar), kVar);
        }
    }

    final g G(long j) {
        return H(this.a, 0L, 0L, j, 0L);
    }

    /* renamed from: I, reason: merged with bridge method [inline-methods] */
    public final g d(long j, j$.time.temporal.r rVar) {
        boolean z = rVar instanceof j$.time.temporal.a;
        b bVar = this.a;
        if (!z) {
            return C(bVar.a(), rVar.q(this, j));
        }
        boolean D = ((j$.time.temporal.a) rVar).D();
        j$.time.k kVar = this.b;
        return D ? J(bVar, kVar.U(j, rVar)) : J(bVar.d(j, rVar), kVar);
    }

    public final n a() {
        return this.a.a();
    }

    public final j$.time.k b() {
        return this.b;
    }

    public final b c() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof e) && i.c(this, (e) obj) == 0;
    }

    public final boolean f(j$.time.temporal.r rVar) {
        if (!(rVar instanceof j$.time.temporal.a)) {
            return rVar != null && rVar.l(this);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) rVar;
        return aVar.u() || aVar.D();
    }

    public final int hashCode() {
        return this.a.hashCode() ^ this.b.hashCode();
    }

    public final int i(j$.time.temporal.r rVar) {
        return rVar instanceof j$.time.temporal.a ? ((j$.time.temporal.a) rVar).D() ? this.b.i(rVar) : this.a.i(rVar) : l(rVar).a(q(rVar), rVar);
    }

    public final j$.time.temporal.m k(j$.time.h hVar) {
        return J(hVar, this.b);
    }

    public final j$.time.temporal.w l(j$.time.temporal.r rVar) {
        if (!(rVar instanceof j$.time.temporal.a)) {
            return rVar.t(this);
        }
        if (!((j$.time.temporal.a) rVar).D()) {
            return this.a.l(rVar);
        }
        j$.time.k kVar = this.b;
        kVar.getClass();
        return j$.time.temporal.n.d(kVar, rVar);
    }

    public final k n(ZoneOffset zoneOffset) {
        return m.E(zoneOffset, null, this);
    }

    public final long q(j$.time.temporal.r rVar) {
        return rVar instanceof j$.time.temporal.a ? ((j$.time.temporal.a) rVar).D() ? this.b.q(rVar) : this.a.q(rVar) : rVar.k(this);
    }

    public final /* synthetic */ Object t(j$.time.temporal.t tVar) {
        return i.k(this, tVar);
    }

    public final String toString() {
        return this.a.toString() + "T" + this.b.toString();
    }

    public final j$.time.temporal.m u(j$.time.temporal.m mVar) {
        return mVar.d(c().r(), j$.time.temporal.a.EPOCH_DAY).d(b().S(), j$.time.temporal.a.NANO_OF_DAY);
    }

    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public final /* synthetic */ int compareTo(e eVar) {
        return i.c(this, eVar);
    }

    final void writeExternal(ObjectOutput objectOutput) {
        objectOutput.writeObject(this.a);
        objectOutput.writeObject(this.b);
    }
}
