package j$.time.chrono;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public final class t implements o {
    public static final t AH;
    private static final /* synthetic */ t[] a;

    static {
        t tVar = new t("AH", 0);
        AH = tVar;
        a = new t[]{tVar};
    }

    public static t valueOf(String str) {
        return (t) Enum.valueOf(t.class, str);
    }

    public static t[] values() {
        return (t[]) a.clone();
    }

    public final /* synthetic */ boolean f(j$.time.temporal.r rVar) {
        return i.i(this, rVar);
    }

    public final int getValue() {
        return 1;
    }

    public final /* synthetic */ int i(j$.time.temporal.r rVar) {
        return i.f(this, rVar);
    }

    public final j$.time.temporal.w l(j$.time.temporal.r rVar) {
        return rVar == j$.time.temporal.a.ERA ? j$.time.temporal.w.j(1L, 1L) : j$.time.temporal.n.d(this, rVar);
    }

    public final /* synthetic */ long q(j$.time.temporal.r rVar) {
        return i.g(this, rVar);
    }

    public final /* synthetic */ Object t(j$.time.temporal.t tVar) {
        return i.m(this, tVar);
    }

    public final j$.time.temporal.m u(j$.time.temporal.m mVar) {
        return mVar.d(1, j$.time.temporal.a.ERA);
    }
}
