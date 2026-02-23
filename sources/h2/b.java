package H2;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class b {
    public static Object a(int i, Object obj, a aVar, c cVar) {
        Object apply;
        if (i < 1) {
            return aVar.apply(obj);
        }
        do {
            apply = aVar.apply(obj);
            obj = cVar.a(obj, apply);
            if (obj == null) {
                break;
            }
            i--;
        } while (i >= 1);
        return apply;
    }
}
