package G8;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class b1 extends kotlinx.coroutines.internal.x {
    public ThreadLocal e;

    /* JADX WARN: Illegal instructions before constructor call */
    public b1(o8.g gVar, o8.d dVar) {
        c1 c1Var = c1.a;
        super(gVar.a(c1Var) == null ? gVar.V(c1Var) : gVar, dVar);
        this.e = new ThreadLocal();
        if (dVar.getContext().a(o8.e.d0) instanceof H) {
            return;
        }
        Object c = kotlinx.coroutines.internal.C.c(gVar, null);
        kotlinx.coroutines.internal.C.a(gVar, c);
        Q0(gVar, c);
    }

    public void K0(Object obj) {
        k8.i iVar = (k8.i) this.e.get();
        if (iVar != null) {
            kotlinx.coroutines.internal.C.a((o8.g) iVar.a(), iVar.b());
            this.e.set((Object) null);
        }
        Object a = F.a(obj, this.d);
        o8.d dVar = this.d;
        o8.g context = dVar.getContext();
        Object c = kotlinx.coroutines.internal.C.c(context, null);
        b1 g = c != kotlinx.coroutines.internal.C.a ? G.g(dVar, context, c) : null;
        try {
            this.d.resumeWith(a);
            k8.q qVar = k8.q.a;
        } finally {
            if (g == null || g.P0()) {
                kotlinx.coroutines.internal.C.a(context, c);
            }
        }
    }

    public final boolean P0() {
        if (this.e.get() == null) {
            return false;
        }
        this.e.set((Object) null);
        return true;
    }

    public final void Q0(o8.g gVar, Object obj) {
        this.e.set(k8.m.a(gVar, obj));
    }
}
