package j$.time.chrono;

import java.io.Serializable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
abstract class d implements b, j$.time.temporal.m, j$.time.temporal.p, Serializable {
    private static final long serialVersionUID = 6282433883239719096L;

    d() {
    }

    static b C(n nVar, j$.time.temporal.m mVar) {
        b bVar = (b) mVar;
        a aVar = (a) nVar;
        if (aVar.equals(bVar.a())) {
            return bVar;
        }
        throw new ClassCastException("Chronology mismatch, expected: " + aVar.getId() + ", actual: " + bVar.a().getId());
    }

    public o D() {
        return a().A(j$.time.temporal.n.a(this, j$.time.temporal.a.ERA));
    }

    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public b y(long j, j$.time.temporal.u uVar) {
        return C(a(), j$.time.temporal.n.b(this, j, uVar));
    }

    abstract b F(long j);

    abstract b G(long j);

    abstract b H(long j);

    /* renamed from: I, reason: merged with bridge method [inline-methods] */
    public b k(j$.time.temporal.p pVar) {
        return C(a(), pVar.u(this));
    }

    public b d(long j, j$.time.temporal.r rVar) {
        if (rVar instanceof j$.time.temporal.a) {
            throw new j$.time.temporal.v(j$.time.d.a("Unsupported field: ", rVar));
        }
        return C(a(), rVar.q(this, j));
    }

    public b e(long j, j$.time.temporal.u uVar) {
        boolean z = uVar instanceof j$.time.temporal.b;
        if (!z) {
            if (!z) {
                return C(a(), uVar.i(this, j));
            }
            throw new j$.time.temporal.v("Unsupported unit: " + uVar);
        }
        switch (c.a[((j$.time.temporal.b) uVar).ordinal()]) {
            case 1:
                return F(j);
            case 2:
                return F(j$.com.android.tools.r8.a.o(j, 7));
            case 3:
                return G(j);
            case 4:
                return H(j);
            case 5:
                return H(j$.com.android.tools.r8.a.o(j, 10));
            case 6:
                return H(j$.com.android.tools.r8.a.o(j, 100));
            case 7:
                return H(j$.com.android.tools.r8.a.o(j, 1000));
            case 8:
                j$.time.temporal.a aVar = j$.time.temporal.a.ERA;
                return d(j$.com.android.tools.r8.a.i(q(aVar), j), (j$.time.temporal.r) aVar);
            default:
                throw new j$.time.temporal.v("Unsupported unit: " + uVar);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof b) && i.b(this, (b) obj) == 0;
    }

    public /* synthetic */ boolean f(j$.time.temporal.r rVar) {
        return i.h(this, rVar);
    }

    public int hashCode() {
        long r = r();
        return ((a) a()).hashCode() ^ ((int) (r ^ (r >>> 32)));
    }

    public final /* synthetic */ int i(j$.time.temporal.r rVar) {
        return j$.time.temporal.n.a(this, rVar);
    }

    public /* synthetic */ j$.time.temporal.w l(j$.time.temporal.r rVar) {
        return j$.time.temporal.n.d(this, rVar);
    }

    public long r() {
        return q(j$.time.temporal.a.EPOCH_DAY);
    }

    public e s(j$.time.k kVar) {
        return g.E(this, kVar);
    }

    public final /* synthetic */ Object t(j$.time.temporal.t tVar) {
        return i.j(this, tVar);
    }

    public String toString() {
        long q = q(j$.time.temporal.a.YEAR_OF_ERA);
        long q2 = q(j$.time.temporal.a.MONTH_OF_YEAR);
        long q3 = q(j$.time.temporal.a.DAY_OF_MONTH);
        StringBuilder sb = new StringBuilder(30);
        sb.append(((a) a()).getId());
        sb.append(" ");
        sb.append(D());
        sb.append(" ");
        sb.append(q);
        sb.append(q2 < 10 ? "-0" : "-");
        sb.append(q2);
        sb.append(q3 < 10 ? "-0" : "-");
        sb.append(q3);
        return sb.toString();
    }

    public final /* synthetic */ j$.time.temporal.m u(j$.time.temporal.m mVar) {
        return i.a(this, mVar);
    }

    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public final /* synthetic */ int compareTo(b bVar) {
        return i.b(this, bVar);
    }
}
