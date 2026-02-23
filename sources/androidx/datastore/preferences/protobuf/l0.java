package androidx.datastore.preferences.protobuf;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class l0 {
    public abstract void a(Object obj, int i, int i2);

    public abstract void b(Object obj, int i, long j);

    public abstract void c(Object obj, int i, Object obj2);

    public abstract void d(Object obj, int i, g gVar);

    public abstract void e(Object obj, int i, long j);

    public abstract Object f(Object obj);

    public abstract Object g(Object obj);

    public abstract int h(Object obj);

    public abstract int i(Object obj);

    public abstract void j(Object obj);

    public abstract Object k(Object obj, Object obj2);

    public final void l(Object obj, d0 d0Var) {
        while (d0Var.E() != Integer.MAX_VALUE && m(obj, d0Var)) {
        }
    }

    public final boolean m(Object obj, d0 d0Var) {
        int tag = d0Var.getTag();
        int a = r0.a(tag);
        int b = r0.b(tag);
        if (b == 0) {
            e(obj, a, d0Var.N());
            return true;
        }
        if (b == 1) {
            b(obj, a, d0Var.b());
            return true;
        }
        if (b == 2) {
            d(obj, a, d0Var.p());
            return true;
        }
        if (b != 3) {
            if (b == 4) {
                return false;
            }
            if (b != 5) {
                throw z.d();
            }
            a(obj, a, d0Var.x());
            return true;
        }
        Object n = n();
        int c = r0.c(a, 4);
        l(n, d0Var);
        if (c != d0Var.getTag()) {
            throw z.a();
        }
        c(obj, a, r(n));
        return true;
    }

    public abstract Object n();

    public abstract void o(Object obj, Object obj2);

    public abstract void p(Object obj, Object obj2);

    public abstract boolean q(d0 d0Var);

    public abstract Object r(Object obj);

    public abstract void s(Object obj, s0 s0Var);

    public abstract void t(Object obj, s0 s0Var);
}
