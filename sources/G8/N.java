package G8;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public interface n extends o8.d {

    public static final class a {
        public static /* synthetic */ boolean a(n nVar, Throwable th, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if ((i & 1) != 0) {
                th = null;
            }
            return nVar.b(th);
        }
    }

    boolean b(Throwable th);

    Object f(Object obj, Object obj2, w8.l lVar);

    void u(Object obj, w8.l lVar);

    void x(w8.l lVar);

    void y(Object obj);
}
