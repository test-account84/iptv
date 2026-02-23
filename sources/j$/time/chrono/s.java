package j$.time.chrono;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public final class s extends d {
    private static final long serialVersionUID = -5207853542612002020L;
    private final transient q a;
    private final transient int b;
    private final transient int c;
    private final transient int d;

    private s(q qVar, int i, int i2, int i3) {
        qVar.y(i, i2, i3);
        this.a = qVar;
        this.b = i;
        this.c = i2;
        this.d = i3;
    }

    private s(q qVar, long j) {
        int[] C = qVar.C((int) j);
        this.a = qVar;
        this.b = C[0];
        this.c = C[1];
        this.d = C[2];
    }

    private int J() {
        return this.a.u(this.b, this.c) + this.d;
    }

    static s K(q qVar, int i, int i2, int i3) {
        return new s(qVar, i, i2, i3);
    }

    static s L(q qVar, long j) {
        return new s(qVar, j);
    }

    private s O(int i, int i2, int i3) {
        q qVar = this.a;
        int D = qVar.D(i, i2);
        if (i3 > D) {
            i3 = D;
        }
        return new s(qVar, i, i2, i3);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new G((byte) 6, this);
    }

    public final o D() {
        return t.AH;
    }

    public final b E(long j, j$.time.temporal.u uVar) {
        return (s) super.y(j, uVar);
    }

    final b H(long j) {
        if (j == 0) {
            return this;
        }
        long j2 = this.b + ((int) j);
        int i = (int) j2;
        if (j2 == i) {
            return O(i, this.c, this.d);
        }
        throw new ArithmeticException();
    }

    public final b I(j$.time.temporal.p pVar) {
        return (s) super.k(pVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: M, reason: merged with bridge method [inline-methods] */
    public final s F(long j) {
        return new s(this.a, r() + j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public final s G(long j) {
        if (j == 0) {
            return this;
        }
        long j2 = (this.b * 12) + (this.c - 1) + j;
        return O(this.a.q(j$.com.android.tools.r8.a.n(j2, 12L)), ((int) j$.com.android.tools.r8.a.m(j2, 12L)) + 1, this.d);
    }

    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public final s d(long j, j$.time.temporal.r rVar) {
        if (!(rVar instanceof j$.time.temporal.a)) {
            return (s) super.d(j, rVar);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) rVar;
        q qVar = this.a;
        qVar.G(aVar).b(j, aVar);
        int i = (int) j;
        int i2 = r.a[aVar.ordinal()];
        int i3 = this.d;
        int i4 = this.c;
        int i5 = this.b;
        switch (i2) {
            case 1:
                return O(i5, i4, i);
            case 2:
                return F(Math.min(i, qVar.E(i5)) - J());
            case 3:
                return F((j - q(j$.time.temporal.a.ALIGNED_WEEK_OF_MONTH)) * 7);
            case 4:
                return F(j - (((int) j$.com.android.tools.r8.a.m(r() + 3, 7)) + 1));
            case 5:
                return F(j - q(j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_MONTH));
            case 6:
                return F(j - q(j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_YEAR));
            case 7:
                return new s(qVar, j);
            case 8:
                return F((j - q(j$.time.temporal.a.ALIGNED_WEEK_OF_YEAR)) * 7);
            case 9:
                return O(i5, i, i3);
            case 10:
                return G(j - (((i5 * 12) + i4) - 1));
            case 11:
                if (i5 < 1) {
                    i = 1 - i;
                }
                return O(i, i4, i3);
            case 12:
                return O(i, i4, i3);
            case 13:
                return O(1 - i5, i4, i3);
            default:
                throw new j$.time.temporal.v(j$.time.d.a("Unsupported field: ", rVar));
        }
    }

    public final n a() {
        return this.a;
    }

    public final b e(long j, j$.time.temporal.u uVar) {
        return (s) super.e(j, uVar);
    }

    public final j$.time.temporal.m e(long j, j$.time.temporal.u uVar) {
        return (s) super.e(j, uVar);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return this.b == sVar.b && this.c == sVar.c && this.d == sVar.d && this.a.equals(sVar.a);
    }

    public final int hashCode() {
        int hashCode = this.a.getId().hashCode();
        int i = this.b;
        return (hashCode ^ (i & (-2048))) ^ (((i << 11) + (this.c << 6)) + this.d);
    }

    public final j$.time.temporal.m k(j$.time.h hVar) {
        return (s) super.k(hVar);
    }

    public final j$.time.temporal.w l(j$.time.temporal.r rVar) {
        int D;
        long j;
        if (!(rVar instanceof j$.time.temporal.a)) {
            return rVar.t(this);
        }
        if (!i.h(this, rVar)) {
            throw new j$.time.temporal.v(j$.time.d.a("Unsupported field: ", rVar));
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) rVar;
        int i = r.a[aVar.ordinal()];
        int i2 = this.b;
        q qVar = this.a;
        if (i == 1) {
            D = qVar.D(i2, this.c);
        } else {
            if (i != 2) {
                if (i != 3) {
                    return qVar.G(aVar);
                }
                j = 5;
                return j$.time.temporal.w.j(1L, j);
            }
            D = qVar.E(i2);
        }
        j = D;
        return j$.time.temporal.w.j(1L, j);
    }

    public final long q(j$.time.temporal.r rVar) {
        if (!(rVar instanceof j$.time.temporal.a)) {
            return rVar.k(this);
        }
        int i = r.a[((j$.time.temporal.a) rVar).ordinal()];
        int i2 = this.c;
        int i3 = this.d;
        int i4 = this.b;
        switch (i) {
            case 1:
                return i3;
            case 2:
                return J();
            case 3:
                return ((i3 - 1) / 7) + 1;
            case 4:
                return ((int) j$.com.android.tools.r8.a.m(r() + 3, 7)) + 1;
            case 5:
                return ((i3 - 1) % 7) + 1;
            case 6:
                return ((J() - 1) % 7) + 1;
            case 7:
                return r();
            case 8:
                return ((J() - 1) / 7) + 1;
            case 9:
                return i2;
            case 10:
                return ((i4 * 12) + i2) - 1;
            case 11:
                return i4;
            case 12:
                return i4;
            case 13:
                return i4 <= 1 ? 0 : 1;
            default:
                throw new j$.time.temporal.v(j$.time.d.a("Unsupported field: ", rVar));
        }
    }

    public final long r() {
        return this.a.y(this.b, this.c, this.d);
    }

    public final e s(j$.time.k kVar) {
        return g.E(this, kVar);
    }

    final void writeExternal(ObjectOutput objectOutput) {
        objectOutput.writeObject(this.a);
        objectOutput.writeInt(j$.time.temporal.n.a(this, j$.time.temporal.a.YEAR));
        objectOutput.writeByte(j$.time.temporal.n.a(this, j$.time.temporal.a.MONTH_OF_YEAR));
        objectOutput.writeByte(j$.time.temporal.n.a(this, j$.time.temporal.a.DAY_OF_MONTH));
    }

    public final j$.time.temporal.m y(long j, j$.time.temporal.u uVar) {
        return (s) super.y(j, uVar);
    }
}
