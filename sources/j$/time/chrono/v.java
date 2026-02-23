package j$.time.chrono;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public final class v implements o {
    public static final v BCE;
    public static final v CE;
    private static final /* synthetic */ v[] a;

    static {
        v vVar = new v("BCE", 0);
        BCE = vVar;
        v vVar2 = new v("CE", 1);
        CE = vVar2;
        a = new v[]{vVar, vVar2};
    }

    public static v valueOf(String str) {
        return (v) Enum.valueOf(v.class, str);
    }

    public static v[] values() {
        return (v[]) a.clone();
    }

    public final /* synthetic */ boolean f(j$.time.temporal.r rVar) {
        return i.i(this, rVar);
    }

    public final int getValue() {
        return ordinal();
    }

    public final /* synthetic */ int i(j$.time.temporal.r rVar) {
        return i.f(this, rVar);
    }

    public final j$.time.temporal.w l(j$.time.temporal.r rVar) {
        return j$.time.temporal.n.d(this, rVar);
    }

    public final /* synthetic */ long q(j$.time.temporal.r rVar) {
        return i.g(this, rVar);
    }

    public final /* synthetic */ Object t(j$.time.temporal.t tVar) {
        return i.m(this, tVar);
    }

    public final j$.time.temporal.m u(j$.time.temporal.m mVar) {
        return mVar.d(getValue(), j$.time.temporal.a.ERA);
    }
}
