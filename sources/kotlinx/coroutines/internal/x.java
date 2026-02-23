package kotlinx.coroutines.internal;

import G8.x0;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class x extends G8.a implements q8.e {
    public final o8.d d;

    public x(o8.g gVar, o8.d dVar) {
        super(gVar, true, true);
        this.d = dVar;
    }

    public void D(Object obj) {
        g.c(p8.b.c(this.d), G8.F.a(obj, this.d), null, 2, null);
    }

    public void K0(Object obj) {
        o8.d dVar = this.d;
        dVar.resumeWith(G8.F.a(obj, dVar));
    }

    public final x0 O0() {
        G8.t c0 = c0();
        if (c0 != null) {
            return c0.getParent();
        }
        return null;
    }

    public final q8.e getCallerFrame() {
        o8.d dVar = this.d;
        if (dVar instanceof q8.e) {
            return (q8.e) dVar;
        }
        return null;
    }

    public final boolean i0() {
        return true;
    }
}
