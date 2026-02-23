package G8;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class q {
    public static final void a(n nVar, d0 d0Var) {
        nVar.x(new e0(d0Var));
    }

    public static final o b(o8.d dVar) {
        if (!(dVar instanceof kotlinx.coroutines.internal.f)) {
            return new o(dVar, 1);
        }
        o j = ((kotlinx.coroutines.internal.f) dVar).j();
        if (j != null) {
            if (!j.G()) {
                j = null;
            }
            if (j != null) {
                return j;
            }
        }
        return new o(dVar, 2);
    }

    public static final void c(n nVar, kotlinx.coroutines.internal.m mVar) {
        nVar.x(new N0(mVar));
    }
}
