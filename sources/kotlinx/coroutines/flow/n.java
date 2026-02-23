package kotlinx.coroutines.flow;

import G8.o;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import k8.j;
import k8.q;
import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class n extends J8.d {
    public static final /* synthetic */ AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(n.class, Object.class, "_state");

    @NotNull
    volatile /* synthetic */ Object _state = null;

    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean a(l lVar) {
        if (this._state != null) {
            return false;
        }
        this._state = m.b();
        return true;
    }

    public final Object d(o8.d dVar) {
        o oVar = new o(p8.b.c(dVar), 1);
        oVar.v();
        if (!t.b.a(a, this, m.b(), oVar)) {
            j.a aVar = k8.j.c;
            oVar.resumeWith(k8.j.b(q.a));
        }
        Object r = oVar.r();
        if (r == p8.c.d()) {
            q8.h.c(dVar);
        }
        return r == p8.c.d() ? r : q.a;
    }

    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public o8.d[] b(l lVar) {
        this._state = null;
        return J8.c.a;
    }

    public final void f() {
        while (true) {
            Object obj = this._state;
            if (obj == null || obj == m.c()) {
                return;
            }
            if (obj == m.b()) {
                if (t.b.a(a, this, obj, m.c())) {
                    return;
                }
            } else if (t.b.a(a, this, obj, m.b())) {
                j.a aVar = k8.j.c;
                ((o) obj).resumeWith(k8.j.b(q.a));
                return;
            }
        }
    }

    public final boolean g() {
        Object andSet = a.getAndSet(this, m.b());
        kotlin.jvm.internal.l.b(andSet);
        return andSet == m.c();
    }
}
