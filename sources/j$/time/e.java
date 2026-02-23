package j$.time;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public final class e implements j$.time.temporal.o, j$.time.temporal.p {
    public static final e FRIDAY;
    public static final e MONDAY;
    public static final e SATURDAY;
    public static final e SUNDAY;
    public static final e THURSDAY;
    public static final e TUESDAY;
    public static final e WEDNESDAY;
    private static final e[] a;
    private static final /* synthetic */ e[] b;

    static {
        e eVar = new e("MONDAY", 0);
        MONDAY = eVar;
        e eVar2 = new e("TUESDAY", 1);
        TUESDAY = eVar2;
        e eVar3 = new e("WEDNESDAY", 2);
        WEDNESDAY = eVar3;
        e eVar4 = new e("THURSDAY", 3);
        THURSDAY = eVar4;
        e eVar5 = new e("FRIDAY", 4);
        FRIDAY = eVar5;
        e eVar6 = new e("SATURDAY", 5);
        SATURDAY = eVar6;
        e eVar7 = new e("SUNDAY", 6);
        SUNDAY = eVar7;
        b = new e[]{eVar, eVar2, eVar3, eVar4, eVar5, eVar6, eVar7};
        a = values();
    }

    public static e C(int i) {
        if (i >= 1 && i <= 7) {
            return a[i - 1];
        }
        throw new c("Invalid value for DayOfWeek: " + i);
    }

    public static e valueOf(String str) {
        return (e) Enum.valueOf(e.class, str);
    }

    public static e[] values() {
        return (e[]) b.clone();
    }

    public final boolean f(j$.time.temporal.r rVar) {
        return rVar instanceof j$.time.temporal.a ? rVar == j$.time.temporal.a.DAY_OF_WEEK : rVar != null && rVar.l(this);
    }

    public final int getValue() {
        return ordinal() + 1;
    }

    public final int i(j$.time.temporal.r rVar) {
        return rVar == j$.time.temporal.a.DAY_OF_WEEK ? getValue() : j$.time.temporal.n.a(this, rVar);
    }

    public final j$.time.temporal.w l(j$.time.temporal.r rVar) {
        return rVar == j$.time.temporal.a.DAY_OF_WEEK ? rVar.i() : j$.time.temporal.n.d(this, rVar);
    }

    public final long q(j$.time.temporal.r rVar) {
        if (rVar == j$.time.temporal.a.DAY_OF_WEEK) {
            return getValue();
        }
        if (rVar instanceof j$.time.temporal.a) {
            throw new j$.time.temporal.v(d.a("Unsupported field: ", rVar));
        }
        return rVar.k(this);
    }

    public final Object t(j$.time.temporal.t tVar) {
        return tVar == j$.time.temporal.n.i() ? j$.time.temporal.b.DAYS : j$.time.temporal.n.c(this, tVar);
    }

    public final j$.time.temporal.m u(j$.time.temporal.m mVar) {
        return mVar.d(getValue(), j$.time.temporal.a.DAY_OF_WEEK);
    }
}
