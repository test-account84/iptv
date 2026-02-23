package j$.time.temporal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
enum k implements r {
    JULIAN_DAY("JulianDay", 2440588),
    MODIFIED_JULIAN_DAY("ModifiedJulianDay", 40587),
    RATA_DIE("RataDie", 719163);

    private static final long serialVersionUID = -7501623920830201812L;
    private final transient String a;
    private final transient w b;
    private final transient long c;

    static {
        b bVar = b.NANOS;
    }

    k(String str, long j) {
        this.a = str;
        this.b = w.j((-365243219162L) + j, 365241780471L + j);
        this.c = j;
    }

    public final w i() {
        return this.b;
    }

    public final long k(o oVar) {
        return oVar.q(a.EPOCH_DAY) + this.c;
    }

    public final boolean l(o oVar) {
        return oVar.f(a.EPOCH_DAY);
    }

    public final m q(m mVar, long j) {
        if (this.b.i(j)) {
            return mVar.d(j$.com.android.tools.r8.a.p(j, this.c), a.EPOCH_DAY);
        }
        throw new j$.time.c("Invalid value: " + this.a + " " + j);
    }

    public final w t(o oVar) {
        if (oVar.f(a.EPOCH_DAY)) {
            return this.b;
        }
        throw new j$.time.c("Unsupported field: " + this);
    }

    public final String toString() {
        return this.a;
    }

    public final boolean u() {
        return true;
    }
}
