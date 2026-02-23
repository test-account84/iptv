package G8;

import o8.e;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract /* synthetic */ class k {
    public static final T a(L l, o8.g gVar, N n, w8.p pVar) {
        o8.g d = G.d(l, gVar);
        U g0 = n.isLazy() ? new G0(d, pVar) : new U(d, true);
        g0.N0(n, g0, pVar);
        return g0;
    }

    public static /* synthetic */ T b(L l, o8.g gVar, N n, w8.p pVar, int i, Object obj) {
        if ((i & 1) != 0) {
            gVar = o8.h.a;
        }
        if ((i & 2) != 0) {
            n = N.DEFAULT;
        }
        return i.a(l, gVar, n, pVar);
    }

    public static final x0 c(L l, o8.g gVar, N n, w8.p pVar) {
        o8.g d = G.d(l, gVar);
        Q0 h0 = n.isLazy() ? new H0(d, pVar) : new Q0(d, true);
        h0.N0(n, h0, pVar);
        return h0;
    }

    public static /* synthetic */ x0 d(L l, o8.g gVar, N n, w8.p pVar, int i, Object obj) {
        if ((i & 1) != 0) {
            gVar = o8.h.a;
        }
        if ((i & 2) != 0) {
            n = N.DEFAULT;
        }
        return i.c(l, gVar, n, pVar);
    }

    public static final Object e(o8.g gVar, w8.p pVar, o8.d dVar) {
        Object P0;
        o8.g context = dVar.getContext();
        o8.g e = G.e(context, gVar);
        B0.i(e);
        if (e == context) {
            kotlinx.coroutines.internal.x xVar = new kotlinx.coroutines.internal.x(e, dVar);
            P0 = K8.b.c(xVar, xVar, pVar);
        } else {
            e.b bVar = o8.e.d0;
            if (kotlin.jvm.internal.l.a(e.a(bVar), context.a(bVar))) {
                b1 b1Var = new b1(e, dVar);
                Object c = kotlinx.coroutines.internal.C.c(e, null);
                try {
                    Object c2 = K8.b.c(b1Var, b1Var, pVar);
                    kotlinx.coroutines.internal.C.a(e, c);
                    P0 = c2;
                } catch (Throwable th) {
                    kotlinx.coroutines.internal.C.a(e, c);
                    throw th;
                }
            } else {
                Y y = new Y(e, dVar);
                K8.a.e(pVar, y, y, null, 4, null);
                P0 = y.P0();
            }
        }
        if (P0 == p8.c.d()) {
            q8.h.c(dVar);
        }
        return P0;
    }
}
