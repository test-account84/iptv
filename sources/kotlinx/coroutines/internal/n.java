package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class n {
    public static final /* synthetic */ AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(n.class, Object.class, "_cur");

    @NotNull
    private volatile /* synthetic */ Object _cur;

    public n(boolean z) {
        this._cur = new o(8, z);
    }

    public final boolean a(Object obj) {
        while (true) {
            o oVar = (o) this._cur;
            int a2 = oVar.a(obj);
            if (a2 == 0) {
                return true;
            }
            if (a2 == 1) {
                t.b.a(a, this, oVar, oVar.i());
            } else if (a2 == 2) {
                return false;
            }
        }
    }

    public final void b() {
        while (true) {
            o oVar = (o) this._cur;
            if (oVar.d()) {
                return;
            } else {
                t.b.a(a, this, oVar, oVar.i());
            }
        }
    }

    public final int c() {
        return ((o) this._cur).f();
    }

    public final Object d() {
        while (true) {
            o oVar = (o) this._cur;
            Object j = oVar.j();
            if (j != o.h) {
                return j;
            }
            t.b.a(a, this, oVar, oVar.i());
        }
    }
}
