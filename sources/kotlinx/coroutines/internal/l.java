package kotlinx.coroutines.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class l {
    public static final Object a = new y("CONDITION_FALSE");
    public static final Object b = new y("LIST_EMPTY");

    public static final Object a() {
        return a;
    }

    public static final m b(Object obj) {
        m mVar;
        v vVar = obj instanceof v ? (v) obj : null;
        return (vVar == null || (mVar = vVar.a) == null) ? (m) obj : mVar;
    }
}
