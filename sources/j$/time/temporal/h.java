package j$.time.temporal;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
abstract class h implements r {
    public static final h DAY_OF_QUARTER;
    public static final h QUARTER_OF_YEAR;
    public static final h WEEK_BASED_YEAR;
    public static final h WEEK_OF_WEEK_BASED_YEAR;
    private static final int[] a;
    private static final /* synthetic */ h[] b;

    static {
        d dVar = new d();
        DAY_OF_QUARTER = dVar;
        e eVar = new e();
        QUARTER_OF_YEAR = eVar;
        f fVar = new f();
        WEEK_OF_WEEK_BASED_YEAR = fVar;
        g gVar = new g();
        WEEK_BASED_YEAR = gVar;
        b = new h[]{dVar, eVar, fVar, gVar};
        a = new int[]{0, 90, 181, 273, 0, 91, 182, 274};
    }

    static int C(j$.time.h hVar) {
        int ordinal = hVar.G().ordinal();
        int i = 1;
        int H = hVar.H() - 1;
        int i2 = (3 - ordinal) + H;
        int i3 = i2 - ((i2 / 7) * 7);
        int i4 = i3 - 3;
        if (i4 < -3) {
            i4 = i3 + 4;
        }
        if (H < i4) {
            return (int) w.j(1L, H(G(hVar.X(180).T(-1L)))).d();
        }
        int i5 = ((H - i4) / 7) + 1;
        if (i5 != 53 || i4 == -3 || (i4 == -2 && hVar.L())) {
            i = i5;
        }
        return i;
    }

    static /* bridge */ /* synthetic */ int D(j$.time.h hVar) {
        return G(hVar);
    }

    static /* bridge */ /* synthetic */ int E(int i) {
        return H(i);
    }

    static w F(j$.time.h hVar) {
        return w.j(1L, H(G(hVar)));
    }

    private static int G(j$.time.h hVar) {
        int J = hVar.J();
        int H = hVar.H();
        if (H <= 3) {
            return H - hVar.G().ordinal() < -2 ? J - 1 : J;
        }
        if (H >= 363) {
            return ((H - 363) - (hVar.L() ? 1 : 0)) - hVar.G().ordinal() >= 0 ? J + 1 : J;
        }
        return J;
    }

    private static int H(int i) {
        j$.time.h N = j$.time.h.N(i, 1, 1);
        if (N.G() != j$.time.e.THURSDAY) {
            return (N.G() == j$.time.e.WEDNESDAY && N.L()) ? 53 : 52;
        }
        return 53;
    }

    public static h valueOf(String str) {
        return (h) Enum.valueOf(h.class, str);
    }

    public static h[] values() {
        return (h[]) b.clone();
    }

    static /* bridge */ /* synthetic */ int[] y() {
        return a;
    }

    public final boolean u() {
        return true;
    }
}
