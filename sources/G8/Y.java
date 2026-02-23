package G8;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class y {
    public static final w a(x0 x0Var) {
        return new x(x0Var);
    }

    public static /* synthetic */ w b(x0 x0Var, int i, Object obj) {
        if ((i & 1) != 0) {
            x0Var = null;
        }
        return a(x0Var);
    }

    public static final boolean c(w wVar, Object obj) {
        Throwable d = k8.j.d(obj);
        return d == null ? wVar.p(obj) : wVar.n(d);
    }
}
