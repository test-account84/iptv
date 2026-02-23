package j$.time;

import j$.util.Objects;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.Serializable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public final class q implements j$.time.temporal.m, j$.time.temporal.p, Comparable, Serializable {
    private static final long serialVersionUID = 7264499704384272492L;
    private final k a;
    private final ZoneOffset b;

    static {
        k kVar = k.e;
        ZoneOffset zoneOffset = ZoneOffset.g;
        kVar.getClass();
        C(kVar, zoneOffset);
        k kVar2 = k.f;
        ZoneOffset zoneOffset2 = ZoneOffset.f;
        kVar2.getClass();
        C(kVar2, zoneOffset2);
    }

    private q(k kVar, ZoneOffset zoneOffset) {
        Objects.a(kVar, "time");
        this.a = kVar;
        Objects.a(zoneOffset, "offset");
        this.b = zoneOffset;
    }

    public static q C(k kVar, ZoneOffset zoneOffset) {
        return new q(kVar, zoneOffset);
    }

    static q E(ObjectInput objectInput) {
        return new q(k.R(objectInput), ZoneOffset.N(objectInput));
    }

    private q F(k kVar, ZoneOffset zoneOffset) {
        return (this.a == kVar && this.b.equals(zoneOffset)) ? this : new q(kVar, zoneOffset);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new s((byte) 9, this);
    }

    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public final q e(long j, j$.time.temporal.u uVar) {
        return uVar instanceof j$.time.temporal.b ? F(this.a.e(j, uVar), this.b) : (q) uVar.i(this, j);
    }

    public final int compareTo(Object obj) {
        int compare;
        q qVar = (q) obj;
        ZoneOffset zoneOffset = qVar.b;
        ZoneOffset zoneOffset2 = this.b;
        boolean equals = zoneOffset2.equals(zoneOffset);
        k kVar = qVar.a;
        k kVar2 = this.a;
        return (equals || (compare = Long.compare(kVar2.S() - (((long) zoneOffset2.I()) * 1000000000), kVar.S() - (((long) qVar.b.I()) * 1000000000))) == 0) ? kVar2.compareTo(kVar) : compare;
    }

    public final j$.time.temporal.m d(long j, j$.time.temporal.r rVar) {
        if (!(rVar instanceof j$.time.temporal.a)) {
            return (q) rVar.q(this, j);
        }
        j$.time.temporal.a aVar = j$.time.temporal.a.OFFSET_SECONDS;
        k kVar = this.a;
        return rVar == aVar ? F(kVar, ZoneOffset.L(((j$.time.temporal.a) rVar).y(j))) : F(kVar.d(j, rVar), this.b);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        return this.a.equals(qVar.a) && this.b.equals(qVar.b);
    }

    public final boolean f(j$.time.temporal.r rVar) {
        return rVar instanceof j$.time.temporal.a ? ((j$.time.temporal.a) rVar).D() || rVar == j$.time.temporal.a.OFFSET_SECONDS : rVar != null && rVar.l(this);
    }

    public final int hashCode() {
        return this.a.hashCode() ^ this.b.hashCode();
    }

    public final int i(j$.time.temporal.r rVar) {
        return j$.time.temporal.n.a(this, rVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final j$.time.temporal.m k(h hVar) {
        if (hVar instanceof k) {
            return F((k) hVar, this.b);
        }
        if (hVar instanceof ZoneOffset) {
            return F(this.a, (ZoneOffset) hVar);
        }
        boolean z = hVar instanceof q;
        j$.time.temporal.m mVar = hVar;
        if (!z) {
            mVar = j$.time.chrono.i.a(hVar, this);
        }
        return (q) mVar;
    }

    public final j$.time.temporal.w l(j$.time.temporal.r rVar) {
        if (!(rVar instanceof j$.time.temporal.a)) {
            return rVar.t(this);
        }
        if (rVar == j$.time.temporal.a.OFFSET_SECONDS) {
            return ((j$.time.temporal.a) rVar).i();
        }
        k kVar = this.a;
        kVar.getClass();
        return j$.time.temporal.n.d(kVar, rVar);
    }

    public final long q(j$.time.temporal.r rVar) {
        return rVar instanceof j$.time.temporal.a ? rVar == j$.time.temporal.a.OFFSET_SECONDS ? this.b.I() : this.a.q(rVar) : rVar.k(this);
    }

    public final Object t(j$.time.temporal.t tVar) {
        if (tVar == j$.time.temporal.n.h() || tVar == j$.time.temporal.n.j()) {
            return this.b;
        }
        if (((tVar == j$.time.temporal.n.k()) || (tVar == j$.time.temporal.n.e())) || tVar == j$.time.temporal.n.f()) {
            return null;
        }
        return tVar == j$.time.temporal.n.g() ? this.a : tVar == j$.time.temporal.n.i() ? j$.time.temporal.b.NANOS : tVar.a(this);
    }

    public final String toString() {
        return this.a.toString() + this.b.toString();
    }

    public final j$.time.temporal.m u(j$.time.temporal.m mVar) {
        return mVar.d(this.a.S(), j$.time.temporal.a.NANO_OF_DAY).d(this.b.I(), j$.time.temporal.a.OFFSET_SECONDS);
    }

    final void writeExternal(ObjectOutput objectOutput) {
        this.a.W(objectOutput);
        this.b.O(objectOutput);
    }

    public final j$.time.temporal.m y(long j, j$.time.temporal.u uVar) {
        return j == Long.MIN_VALUE ? e(Long.MAX_VALUE, uVar).e(1L, uVar) : e(-j, uVar);
    }
}
