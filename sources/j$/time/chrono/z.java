package j$.time.chrono;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public final class z extends d {
    static final j$.time.h d = j$.time.h.N(1873, 1, 1);
    private static final long serialVersionUID = -305327627230580483L;
    private final transient j$.time.h a;
    private transient A b;
    private transient int c;

    z(j$.time.h hVar) {
        if (hVar.K(d)) {
            throw new j$.time.c("JapaneseDate before Meiji 6 is not supported");
        }
        A j = A.j(hVar);
        this.b = j;
        this.c = (hVar.J() - j.p().J()) + 1;
        this.a = hVar;
    }

    private z K(j$.time.h hVar) {
        return hVar.equals(this.a) ? this : new z(hVar);
    }

    private z L(A a, int i) {
        x.d.getClass();
        if (!(a instanceof A)) {
            throw new ClassCastException("Era must be JapaneseEra");
        }
        int J = (a.p().J() + i) - 1;
        if (i != 1 && (J < -999999999 || J > 999999999 || J < a.p().J() || a != A.j(j$.time.h.N(J, 1, 1)))) {
            throw new j$.time.c("Invalid yearOfEra value");
        }
        return K(this.a.Y(J));
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new G((byte) 4, this);
    }

    public final o D() {
        return this.b;
    }

    public final b E(long j, j$.time.temporal.u uVar) {
        return (z) super.y(j, uVar);
    }

    final b F(long j) {
        return K(this.a.R(j));
    }

    final b G(long j) {
        return K(this.a.S(j));
    }

    final b H(long j) {
        return K(this.a.T(j));
    }

    public final b I(j$.time.temporal.p pVar) {
        return (z) super.k(pVar);
    }

    /* renamed from: J, reason: merged with bridge method [inline-methods] */
    public final z d(long j, j$.time.temporal.r rVar) {
        if (!(rVar instanceof j$.time.temporal.a)) {
            return (z) super.d(j, rVar);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) rVar;
        if (q(aVar) == j) {
            return this;
        }
        int[] iArr = y.a;
        int i = iArr[aVar.ordinal()];
        j$.time.h hVar = this.a;
        if (i == 3 || i == 8 || i == 9) {
            int a = x.d.l(aVar).a(j, aVar);
            int i2 = iArr[aVar.ordinal()];
            if (i2 == 3) {
                return L(this.b, a);
            }
            if (i2 == 8) {
                return L(A.A(a), this.c);
            }
            if (i2 == 9) {
                return K(hVar.Y(a));
            }
        }
        return K(hVar.V(j, rVar));
    }

    public final n a() {
        return x.d;
    }

    public final b e(long j, j$.time.temporal.u uVar) {
        return (z) super.e(j, uVar);
    }

    public final j$.time.temporal.m e(long j, j$.time.temporal.u uVar) {
        return (z) super.e(j, uVar);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof z) {
            return this.a.equals(((z) obj).a);
        }
        return false;
    }

    public final boolean f(j$.time.temporal.r rVar) {
        if (rVar == j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_MONTH || rVar == j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_YEAR || rVar == j$.time.temporal.a.ALIGNED_WEEK_OF_MONTH || rVar == j$.time.temporal.a.ALIGNED_WEEK_OF_YEAR) {
            return false;
        }
        return rVar instanceof j$.time.temporal.a ? ((j$.time.temporal.a) rVar).u() : rVar != null && rVar.l(this);
    }

    public final int hashCode() {
        x.d.getClass();
        return this.a.hashCode() ^ (-688086063);
    }

    public final j$.time.temporal.m k(j$.time.h hVar) {
        return (z) super.k(hVar);
    }

    public final j$.time.temporal.w l(j$.time.temporal.r rVar) {
        int M;
        long j;
        if (!(rVar instanceof j$.time.temporal.a)) {
            return rVar.t(this);
        }
        if (!f(rVar)) {
            throw new j$.time.temporal.v(j$.time.d.a("Unsupported field: ", rVar));
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) rVar;
        int i = y.a[aVar.ordinal()];
        j$.time.h hVar = this.a;
        if (i != 1) {
            A a = this.b;
            if (i != 2) {
                if (i != 3) {
                    return x.d.l(aVar);
                }
                int J = a.p().J();
                A x = a.x();
                j = x != null ? (x.p().J() - J) + 1 : 999999999 - J;
                return j$.time.temporal.w.j(1L, j);
            }
            A x2 = a.x();
            M = (x2 == null || x2.p().J() != hVar.J()) ? hVar.L() ? 366 : 365 : x2.p().H() - 1;
            if (this.c == 1) {
                M -= a.p().H() - 1;
            }
        } else {
            M = hVar.M();
        }
        j = M;
        return j$.time.temporal.w.j(1L, j);
    }

    public final long q(j$.time.temporal.r rVar) {
        if (!(rVar instanceof j$.time.temporal.a)) {
            return rVar.k(this);
        }
        int i = y.a[((j$.time.temporal.a) rVar).ordinal()];
        int i2 = this.c;
        A a = this.b;
        j$.time.h hVar = this.a;
        switch (i) {
            case 2:
                return i2 == 1 ? (hVar.H() - a.p().H()) + 1 : hVar.H();
            case 3:
                return i2;
            case 4:
            case 5:
            case 6:
            case 7:
                throw new j$.time.temporal.v(j$.time.d.a("Unsupported field: ", rVar));
            case 8:
                return a.getValue();
            default:
                return hVar.q(rVar);
        }
    }

    public final long r() {
        return this.a.r();
    }

    public final e s(j$.time.k kVar) {
        return g.E(this, kVar);
    }

    public final j$.time.temporal.m y(long j, j$.time.temporal.u uVar) {
        return (z) super.y(j, uVar);
    }
}
