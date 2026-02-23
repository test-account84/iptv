package j$.time.temporal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
enum g extends h {
    g() {
        super("WEEK_BASED_YEAR", 3);
    }

    public final w i() {
        return a.YEAR.i();
    }

    public final long k(o oVar) {
        if (l(oVar)) {
            return h.D(j$.time.h.E(oVar));
        }
        throw new v("Unsupported field: WeekBasedYear");
    }

    public final boolean l(o oVar) {
        if (oVar.f(a.EPOCH_DAY)) {
            r rVar = j.a;
            if (((j$.time.chrono.a) j$.time.chrono.i.p(oVar)).equals(j$.time.chrono.u.d)) {
                return true;
            }
        }
        return false;
    }

    public final m q(m mVar, long j) {
        if (!l(mVar)) {
            throw new v("Unsupported field: WeekBasedYear");
        }
        int a = a.YEAR.i().a(j, h.WEEK_BASED_YEAR);
        j$.time.h E = j$.time.h.E(mVar);
        int i = E.i(a.DAY_OF_WEEK);
        int C = h.C(E);
        if (C == 53 && h.E(a) == 52) {
            C = 52;
        }
        return mVar.k(j$.time.h.N(a, 1, 4).R(((C - 1) * 7) + (i - r6.i(r0))));
    }

    public final w t(o oVar) {
        if (l(oVar)) {
            return i();
        }
        throw new v("Unsupported field: WeekBasedYear");
    }

    public final String toString() {
        return "WeekBasedYear";
    }
}
