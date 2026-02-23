package j$.time.temporal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
enum f extends h {
    f() {
        super("WEEK_OF_WEEK_BASED_YEAR", 2);
    }

    public final w i() {
        return w.k(52L, 53L);
    }

    public final long k(o oVar) {
        if (l(oVar)) {
            return h.C(j$.time.h.E(oVar));
        }
        throw new v("Unsupported field: WeekOfWeekBasedYear");
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
        i().b(j, this);
        return mVar.e(j$.com.android.tools.r8.a.p(j, k(mVar)), b.WEEKS);
    }

    public final w t(o oVar) {
        if (l(oVar)) {
            return h.F(j$.time.h.E(oVar));
        }
        throw new v("Unsupported field: WeekOfWeekBasedYear");
    }

    public final String toString() {
        return "WeekOfWeekBasedYear";
    }
}
