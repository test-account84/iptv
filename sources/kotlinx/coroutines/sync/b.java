package kotlinx.coroutines.sync;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public interface b {

    public static final class a {
        public static /* synthetic */ void a(b bVar, Object obj, int i, Object obj2) {
            if (obj2 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: unlock");
            }
            if ((i & 1) != 0) {
                obj = null;
            }
            bVar.c(obj);
        }
    }

    Object a(Object obj, o8.d dVar);

    boolean b();

    void c(Object obj);
}
