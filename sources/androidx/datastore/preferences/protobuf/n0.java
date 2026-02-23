package androidx.datastore.preferences.protobuf;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class n0 extends l0 {
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public m0 g(Object obj) {
        return ((w) obj).unknownFields;
    }

    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public int h(m0 m0Var) {
        return m0Var.f();
    }

    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public int i(m0 m0Var) {
        return m0Var.g();
    }

    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public m0 k(m0 m0Var, m0 m0Var2) {
        return m0Var2.equals(m0.e()) ? m0Var : m0.k(m0Var, m0Var2);
    }

    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public m0 n() {
        return m0.l();
    }

    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public void o(Object obj, m0 m0Var) {
        p(obj, m0Var);
    }

    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public void p(Object obj, m0 m0Var) {
        ((w) obj).unknownFields = m0Var;
    }

    /* renamed from: H, reason: merged with bridge method [inline-methods] */
    public m0 r(m0 m0Var) {
        m0Var.j();
        return m0Var;
    }

    /* renamed from: I, reason: merged with bridge method [inline-methods] */
    public void s(m0 m0Var, s0 s0Var) {
        m0Var.o(s0Var);
    }

    /* renamed from: J, reason: merged with bridge method [inline-methods] */
    public void t(m0 m0Var, s0 s0Var) {
        m0Var.q(s0Var);
    }

    public void j(Object obj) {
        g(obj).j();
    }

    public boolean q(d0 d0Var) {
        return false;
    }

    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public void a(m0 m0Var, int i, int i2) {
        m0Var.n(r0.c(i, 5), Integer.valueOf(i2));
    }

    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public void b(m0 m0Var, int i, long j) {
        m0Var.n(r0.c(i, 1), Long.valueOf(j));
    }

    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public void c(m0 m0Var, int i, m0 m0Var2) {
        m0Var.n(r0.c(i, 3), m0Var2);
    }

    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public void d(m0 m0Var, int i, g gVar) {
        m0Var.n(r0.c(i, 2), gVar);
    }

    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void e(m0 m0Var, int i, long j) {
        m0Var.n(r0.c(i, 0), Long.valueOf(j));
    }

    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public m0 f(Object obj) {
        m0 g = g(obj);
        if (g != m0.e()) {
            return g;
        }
        m0 l = m0.l();
        p(obj, l);
        return l;
    }
}
