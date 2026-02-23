package j$.time;

import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public final class u implements j$.time.temporal.m, j$.time.temporal.p, Comparable, Serializable {
    public static final /* synthetic */ int b = 0;
    private static final long serialVersionUID = -23038383694477807L;
    private final int a;

    static {
        j$.time.format.n nVar = new j$.time.format.n();
        nVar.l(j$.time.temporal.a.YEAR, 4, 10, j$.time.format.u.EXCEEDS_PAD);
        nVar.v();
    }

    private u(int i) {
        this.a = i;
    }

    public static u C(int i) {
        j$.time.temporal.a.YEAR.C(i);
        return new u(i);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new s((byte) 11, this);
    }

    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public final u e(long j, j$.time.temporal.u uVar) {
        if (!(uVar instanceof j$.time.temporal.b)) {
            return (u) uVar.i(this, j);
        }
        int i = t.b[((j$.time.temporal.b) uVar).ordinal()];
        if (i == 1) {
            return E(j);
        }
        if (i == 2) {
            return E(j$.com.android.tools.r8.a.o(j, 10));
        }
        if (i == 3) {
            return E(j$.com.android.tools.r8.a.o(j, 100));
        }
        if (i == 4) {
            return E(j$.com.android.tools.r8.a.o(j, 1000));
        }
        if (i == 5) {
            j$.time.temporal.a aVar = j$.time.temporal.a.ERA;
            return d(j$.com.android.tools.r8.a.i(q(aVar), j), aVar);
        }
        throw new j$.time.temporal.v("Unsupported unit: " + uVar);
    }

    public final u E(long j) {
        return j == 0 ? this : C(j$.time.temporal.a.YEAR.y(this.a + j));
    }

    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public final u d(long j, j$.time.temporal.r rVar) {
        if (!(rVar instanceof j$.time.temporal.a)) {
            return (u) rVar.q(this, j);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) rVar;
        aVar.C(j);
        int i = t.a[aVar.ordinal()];
        int i2 = this.a;
        if (i == 1) {
            if (i2 < 1) {
                j = 1 - j;
            }
            return C((int) j);
        }
        if (i == 2) {
            return C((int) j);
        }
        if (i == 3) {
            return q(j$.time.temporal.a.ERA) == j ? this : C(1 - i2);
        }
        throw new j$.time.temporal.v(d.a("Unsupported field: ", rVar));
    }

    final void G(DataOutput dataOutput) {
        dataOutput.writeInt(this.a);
    }

    public final int compareTo(Object obj) {
        return this.a - ((u) obj).a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof u) {
            return this.a == ((u) obj).a;
        }
        return false;
    }

    public final boolean f(j$.time.temporal.r rVar) {
        return rVar instanceof j$.time.temporal.a ? rVar == j$.time.temporal.a.YEAR || rVar == j$.time.temporal.a.YEAR_OF_ERA || rVar == j$.time.temporal.a.ERA : rVar != null && rVar.l(this);
    }

    public final int hashCode() {
        return this.a;
    }

    public final int i(j$.time.temporal.r rVar) {
        return l(rVar).a(q(rVar), rVar);
    }

    public final j$.time.temporal.m k(h hVar) {
        return (u) j$.time.chrono.i.a(hVar, this);
    }

    public final j$.time.temporal.w l(j$.time.temporal.r rVar) {
        if (rVar == j$.time.temporal.a.YEAR_OF_ERA) {
            return j$.time.temporal.w.j(1L, this.a <= 0 ? 1000000000L : 999999999L);
        }
        return j$.time.temporal.n.d(this, rVar);
    }

    public final long q(j$.time.temporal.r rVar) {
        if (!(rVar instanceof j$.time.temporal.a)) {
            return rVar.k(this);
        }
        int i = t.a[((j$.time.temporal.a) rVar).ordinal()];
        int i2 = this.a;
        if (i == 1) {
            if (i2 < 1) {
                i2 = 1 - i2;
            }
            return i2;
        }
        if (i == 2) {
            return i2;
        }
        if (i == 3) {
            return i2 < 1 ? 0 : 1;
        }
        throw new j$.time.temporal.v(d.a("Unsupported field: ", rVar));
    }

    public final Object t(j$.time.temporal.t tVar) {
        return tVar == j$.time.temporal.n.e() ? j$.time.chrono.u.d : tVar == j$.time.temporal.n.i() ? j$.time.temporal.b.YEARS : j$.time.temporal.n.c(this, tVar);
    }

    public final String toString() {
        return Integer.toString(this.a);
    }

    public final j$.time.temporal.m u(j$.time.temporal.m mVar) {
        if (!((j$.time.chrono.a) j$.time.chrono.i.p(mVar)).equals(j$.time.chrono.u.d)) {
            throw new c("Adjustment only supported on ISO date-time");
        }
        return mVar.d(this.a, j$.time.temporal.a.YEAR);
    }

    public final j$.time.temporal.m y(long j, j$.time.temporal.u uVar) {
        return j == Long.MIN_VALUE ? e(Long.MAX_VALUE, uVar).e(1L, uVar) : e(-j, uVar);
    }
}
