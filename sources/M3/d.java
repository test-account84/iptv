package m3;

import O2.l1;
import d3.k;
import d3.o;
import d3.t;
import d3.w;
import d4.M;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class d implements d3.i {
    public static final o d = new c();
    public k a;
    public i b;
    public boolean c;

    public static /* synthetic */ d3.i[] c() {
        return e();
    }

    private static /* synthetic */ d3.i[] e() {
        return new d3.i[]{new d()};
    }

    public static M f(M m) {
        m.U(0);
        return m;
    }

    public void a(long j, long j2) {
        i iVar = this.b;
        if (iVar != null) {
            iVar.m(j, j2);
        }
    }

    public void b(k kVar) {
        this.a = kVar;
    }

    public int d(d3.j jVar, t tVar) {
        d4.a.i(this.a);
        if (this.b == null) {
            if (!g(jVar)) {
                throw l1.a("Failed to determine bitstream type", null);
            }
            jVar.f();
        }
        if (!this.c) {
            w e = this.a.e(0, 1);
            this.a.q();
            this.b.d(this.a, e);
            this.c = true;
        }
        return this.b.g(jVar, tVar);
    }

    public final boolean g(d3.j jVar) {
        i hVar;
        f fVar = new f();
        if (fVar.a(jVar, true) && (fVar.b & 2) == 2) {
            int min = Math.min(fVar.i, 8);
            M m = new M(min);
            jVar.s(m.e(), 0, min);
            if (b.p(f(m))) {
                hVar = new b();
            } else if (j.r(f(m))) {
                hVar = new j();
            } else if (h.o(f(m))) {
                hVar = new h();
            }
            this.b = hVar;
            return true;
        }
        return false;
    }

    public boolean h(d3.j jVar) {
        try {
            return g(jVar);
        } catch (l1 unused) {
            return false;
        }
    }

    public void release() {
    }
}
