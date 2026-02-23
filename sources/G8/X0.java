package G8;

import java.util.concurrent.CancellationException;
import o8.g;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public interface x0 extends g.b {
    public static final b b0 = b.a;

    public static final class a {
        public static /* synthetic */ void a(x0 x0Var, CancellationException cancellationException, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if ((i & 1) != 0) {
                cancellationException = null;
            }
            x0Var.s(cancellationException);
        }

        public static Object b(x0 x0Var, Object obj, w8.p pVar) {
            return g.b.a.a(x0Var, obj, pVar);
        }

        public static g.b c(x0 x0Var, g.c cVar) {
            return g.b.a.b(x0Var, cVar);
        }

        public static /* synthetic */ d0 d(x0 x0Var, boolean z, boolean z2, w8.l lVar, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokeOnCompletion");
            }
            if ((i & 1) != 0) {
                z = false;
            }
            if ((i & 2) != 0) {
                z2 = true;
            }
            return x0Var.v(z, z2, lVar);
        }

        public static o8.g e(x0 x0Var, g.c cVar) {
            return g.b.a.c(x0Var, cVar);
        }

        public static o8.g f(x0 x0Var, o8.g gVar) {
            return g.b.a.d(x0Var, gVar);
        }
    }

    public static final class b implements g.c {
        public static final /* synthetic */ b a = new b();
    }

    D8.d d();

    CancellationException h();

    d0 i(w8.l lVar);

    boolean isActive();

    t k(v vVar);

    Object m(o8.d dVar);

    void s(CancellationException cancellationException);

    boolean start();

    d0 v(boolean z, boolean z2, w8.l lVar);
}
