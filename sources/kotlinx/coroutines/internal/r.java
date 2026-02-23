package kotlinx.coroutines.internal;

import G8.I0;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class r {
    public static final s a(Throwable th, String str) {
        if (th != null) {
            throw th;
        }
        d();
        throw new k8.c();
    }

    public static /* synthetic */ s b(Throwable th, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            th = null;
        }
        if ((i & 2) != 0) {
            str = null;
        }
        return a(th, str);
    }

    public static final boolean c(I0 i0) {
        return i0.f0() instanceof s;
    }

    public static final Void d() {
        throw new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");
    }

    public static final I0 e(p pVar, List list) {
        try {
            return pVar.b(list);
        } catch (Throwable th) {
            return a(th, pVar.a());
        }
    }
}
