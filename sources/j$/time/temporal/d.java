package j$.time.temporal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
enum d extends h {
    d() {
        super("DAY_OF_QUARTER", 0);
    }

    public final w i() {
        return w.k(90L, 92L);
    }

    public final long k(o oVar) {
        if (!l(oVar)) {
            throw new v("Unsupported field: DayOfQuarter");
        }
        int i = oVar.i(a.DAY_OF_YEAR);
        int i2 = oVar.i(a.MONTH_OF_YEAR);
        long q = oVar.q(a.YEAR);
        int[] y = h.y();
        int i3 = (i2 - 1) / 3;
        j$.time.chrono.u.d.getClass();
        return i - y[i3 + (j$.time.chrono.u.l(q) ? 4 : 0)];
    }

    public final boolean l(o oVar) {
        if (oVar.f(a.DAY_OF_YEAR) && oVar.f(a.MONTH_OF_YEAR) && oVar.f(a.YEAR)) {
            r rVar = j.a;
            if (((j$.time.chrono.a) j$.time.chrono.i.p(oVar)).equals(j$.time.chrono.u.d)) {
                return true;
            }
        }
        return false;
    }

    public final m q(m mVar, long j) {
        long k = k(mVar);
        i().b(j, this);
        a aVar = a.DAY_OF_YEAR;
        return mVar.d((j - k) + mVar.q(aVar), aVar);
    }

    public final w t(o oVar) {
        if (!l(oVar)) {
            throw new v("Unsupported field: DayOfQuarter");
        }
        long q = oVar.q(h.QUARTER_OF_YEAR);
        if (q != 1) {
            return q == 2 ? w.j(1L, 91L) : (q == 3 || q == 4) ? w.j(1L, 92L) : i();
        }
        long q2 = oVar.q(a.YEAR);
        j$.time.chrono.u.d.getClass();
        return j$.time.chrono.u.l(q2) ? w.j(1L, 91L) : w.j(1L, 90L);
    }

    public final String toString() {
        return "DayOfQuarter";
    }
}
