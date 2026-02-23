package j$.time.chrono;

import j$.time.ZoneOffset;
import j$.util.Objects;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public abstract /* synthetic */ class i {
    public static j$.time.temporal.m a(b bVar, j$.time.temporal.m mVar) {
        return mVar.d(bVar.r(), j$.time.temporal.a.EPOCH_DAY);
    }

    public static int b(b bVar, b bVar2) {
        int compare = Long.compare(bVar.r(), bVar2.r());
        if (compare != 0) {
            return compare;
        }
        return ((a) bVar.a()).getId().compareTo(bVar2.a().getId());
    }

    public static int c(e eVar, e eVar2) {
        int z = eVar.c().z(eVar2.c());
        if (z != 0) {
            return z;
        }
        int C = eVar.b().C(eVar2.b());
        if (C != 0) {
            return C;
        }
        return ((a) eVar.a()).getId().compareTo(eVar2.a().getId());
    }

    public static int d(k kVar, k kVar2) {
        int compare = Long.compare(kVar.B(), kVar2.B());
        if (compare != 0) {
            return compare;
        }
        int H = kVar.b().H() - kVar2.b().H();
        if (H != 0) {
            return H;
        }
        int v = kVar.w().v(kVar2.w());
        if (v != 0) {
            return v;
        }
        int compareTo = kVar.o().getId().compareTo(kVar2.o().getId());
        if (compareTo != 0) {
            return compareTo;
        }
        return ((a) kVar.a()).getId().compareTo(kVar2.a().getId());
    }

    public static int e(k kVar, j$.time.temporal.r rVar) {
        if (!(rVar instanceof j$.time.temporal.a)) {
            return j$.time.temporal.n.a(kVar, rVar);
        }
        int i = j.a[((j$.time.temporal.a) rVar).ordinal()];
        if (i != 1) {
            return i != 2 ? kVar.w().i(rVar) : kVar.g().I();
        }
        throw new j$.time.temporal.v("Invalid field 'InstantSeconds' for get() method, use getLong() instead");
    }

    public static int f(o oVar, j$.time.temporal.r rVar) {
        return rVar == j$.time.temporal.a.ERA ? oVar.getValue() : j$.time.temporal.n.a(oVar, rVar);
    }

    public static long g(o oVar, j$.time.temporal.r rVar) {
        if (rVar == j$.time.temporal.a.ERA) {
            return oVar.getValue();
        }
        if (rVar instanceof j$.time.temporal.a) {
            throw new j$.time.temporal.v(j$.time.d.a("Unsupported field: ", rVar));
        }
        return rVar.k(oVar);
    }

    public static boolean h(b bVar, j$.time.temporal.r rVar) {
        return rVar instanceof j$.time.temporal.a ? ((j$.time.temporal.a) rVar).u() : rVar != null && rVar.l(bVar);
    }

    public static boolean i(o oVar, j$.time.temporal.r rVar) {
        return rVar instanceof j$.time.temporal.a ? rVar == j$.time.temporal.a.ERA : rVar != null && rVar.l(oVar);
    }

    public static Object j(b bVar, j$.time.temporal.t tVar) {
        if (tVar == j$.time.temporal.n.k() || tVar == j$.time.temporal.n.j() || tVar == j$.time.temporal.n.h() || tVar == j$.time.temporal.n.g()) {
            return null;
        }
        return tVar == j$.time.temporal.n.e() ? bVar.a() : tVar == j$.time.temporal.n.i() ? j$.time.temporal.b.DAYS : tVar.a(bVar);
    }

    public static Object k(e eVar, j$.time.temporal.t tVar) {
        if (tVar == j$.time.temporal.n.k() || tVar == j$.time.temporal.n.j() || tVar == j$.time.temporal.n.h()) {
            return null;
        }
        return tVar == j$.time.temporal.n.g() ? eVar.b() : tVar == j$.time.temporal.n.e() ? eVar.a() : tVar == j$.time.temporal.n.i() ? j$.time.temporal.b.NANOS : tVar.a(eVar);
    }

    public static Object l(k kVar, j$.time.temporal.t tVar) {
        return (tVar == j$.time.temporal.n.j() || tVar == j$.time.temporal.n.k()) ? kVar.o() : tVar == j$.time.temporal.n.h() ? kVar.g() : tVar == j$.time.temporal.n.g() ? kVar.b() : tVar == j$.time.temporal.n.e() ? kVar.a() : tVar == j$.time.temporal.n.i() ? j$.time.temporal.b.NANOS : tVar.a(kVar);
    }

    public static Object m(o oVar, j$.time.temporal.t tVar) {
        return tVar == j$.time.temporal.n.i() ? j$.time.temporal.b.ERAS : j$.time.temporal.n.c(oVar, tVar);
    }

    public static long n(e eVar, ZoneOffset zoneOffset) {
        Objects.a(zoneOffset, "offset");
        return ((eVar.c().r() * 86400) + eVar.b().T()) - zoneOffset.I();
    }

    public static long o(k kVar) {
        return ((kVar.c().r() * 86400) + kVar.b().T()) - kVar.g().I();
    }

    public static n p(j$.time.temporal.o oVar) {
        Objects.a(oVar, "temporal");
        n nVar = (n) oVar.t(j$.time.temporal.n.e());
        u uVar = u.d;
        if (nVar != null) {
            return nVar;
        }
        Objects.a(uVar, "defaultObj");
        return uVar;
    }
}
