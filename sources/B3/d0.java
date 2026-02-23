package B3;

import B3.C;
import O2.H0;
import O2.Q1;
import O2.z0;
import android.net.Uri;
import b4.o;
import b4.s;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class d0 extends B3.a {
    public final b4.s i;
    public final o.a j;
    public final z0 k;
    public final long l;
    public final b4.F m;
    public final boolean n;
    public final Q1 o;
    public final H0 p;
    public b4.S q;

    public static final class b {
        public final o.a a;
        public b4.F b = new b4.A();
        public boolean c = true;
        public Object d;
        public String e;

        public b(o.a aVar) {
            this.a = (o.a) d4.a.e(aVar);
        }

        public d0 a(H0.k kVar, long j) {
            return new d0(this.e, kVar, this.a, j, this.b, this.c, this.d, null);
        }

        public b b(b4.F f) {
            if (f == null) {
                f = new b4.A();
            }
            this.b = f;
            return this;
        }
    }

    public d0(String str, H0.k kVar, o.a aVar, long j, b4.F f, boolean z, Object obj) {
        this.j = aVar;
        this.l = j;
        this.m = f;
        this.n = z;
        H0 a2 = new H0.c().m(Uri.EMPTY).g(kVar.a.toString()).k(s5.y.A(kVar)).l(obj).a();
        this.p = a2;
        z0.b W = new z0.b().g0((String) r5.h.a(kVar.c, "text/x-unknown")).X(kVar.d).i0(kVar.e).e0(kVar.f).W(kVar.g);
        String str2 = kVar.h;
        this.k = W.U(str2 == null ? str : str2).G();
        this.i = new s.b().i(kVar.a).b(1).a();
        this.o = new b0(j, true, false, false, null, a2);
    }

    public z E(C.b bVar, b4.b bVar2, long j) {
        return new c0(this.i, this.j, this.q, this.k, this.l, this.m, f0(bVar), this.n);
    }

    public void Y(z zVar) {
        ((c0) zVar).q();
    }

    public H0 e() {
        return this.p;
    }

    public void l0(b4.S s) {
        this.q = s;
        m0(this.o);
    }

    public /* synthetic */ d0(String str, H0.k kVar, o.a aVar, long j, b4.F f, boolean z, Object obj, a aVar2) {
        this(str, kVar, aVar, j, f, z, obj);
    }

    public void P() {
    }

    public void n0() {
    }
}
