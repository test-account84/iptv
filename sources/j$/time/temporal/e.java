package j$.time.temporal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
enum e extends h {
    e() {
        super("QUARTER_OF_YEAR", 1);
    }

    public final w i() {
        return w.j(1L, 4L);
    }

    public final long k(o oVar) {
        if (l(oVar)) {
            return (oVar.q(a.MONTH_OF_YEAR) + 2) / 3;
        }
        throw new v("Unsupported field: QuarterOfYear");
    }

    public final boolean l(o oVar) {
        if (oVar.f(a.MONTH_OF_YEAR)) {
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
        a aVar = a.MONTH_OF_YEAR;
        return mVar.d(((j - k) * 3) + mVar.q(aVar), aVar);
    }

    public final w t(o oVar) {
        if (l(oVar)) {
            return i();
        }
        throw new v("Unsupported field: QuarterOfYear");
    }

    public final String toString() {
        return "QuarterOfYear";
    }
}
