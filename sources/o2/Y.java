package O2;

import B3.C;
import O2.p;
import android.content.Context;
import android.os.Looper;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public interface y extends t1 {

    public interface a {
        void D(boolean z);

        void E(boolean z);
    }

    public static final class b {
        public boolean A;
        public Looper B;
        public boolean C;
        public final Context a;
        public d4.e b;
        public long c;
        public r5.r d;
        public r5.r e;
        public r5.r f;
        public r5.r g;
        public r5.r h;
        public r5.f i;
        public Looper j;
        public Q2.e k;
        public boolean l;
        public int m;
        public boolean n;
        public boolean o;
        public boolean p;
        public int q;
        public int r;
        public boolean s;
        public H1 t;
        public long u;
        public long v;
        public E0 w;
        public long x;
        public long y;
        public boolean z;

        public b(Context context) {
            this(context, new z(context), new B(context));
        }

        public static /* synthetic */ G1 a(Context context) {
            return l(context);
        }

        public static /* synthetic */ C.a b(C.a aVar) {
            return r(aVar);
        }

        public static /* synthetic */ Z3.C c(Z3.C c) {
            return t(c);
        }

        public static /* synthetic */ G1 d(G1 g1) {
            return s(g1);
        }

        public static /* synthetic */ G1 e(G1 g1) {
            return p(g1);
        }

        public static /* synthetic */ C.a f(Context context) {
            return m(context);
        }

        public static /* synthetic */ b4.f g(Context context) {
            return o(context);
        }

        public static /* synthetic */ C.a h(Context context) {
            return q(context);
        }

        public static /* synthetic */ Z3.C i(Context context) {
            return n(context);
        }

        public static /* synthetic */ G1 l(Context context) {
            return new s(context);
        }

        public static /* synthetic */ C.a m(Context context) {
            return new B3.q(context, new d3.f());
        }

        public static /* synthetic */ Z3.C n(Context context) {
            return new Z3.m(context);
        }

        public static /* synthetic */ b4.f o(Context context) {
            return b4.v.n(context);
        }

        public static /* synthetic */ C.a q(Context context) {
            return new B3.q(context, new d3.f());
        }

        public y j() {
            d4.a.g(!this.C);
            this.C = true;
            return new j0(this, null);
        }

        public I1 k() {
            d4.a.g(!this.C);
            this.C = true;
            return new I1(this);
        }

        public b u(C.a aVar) {
            d4.a.g(!this.C);
            d4.a.e(aVar);
            this.e = new G(aVar);
            return this;
        }

        public b v(G1 g1) {
            d4.a.g(!this.C);
            d4.a.e(g1);
            this.d = new F(g1);
            return this;
        }

        public b w(Z3.C c) {
            d4.a.g(!this.C);
            d4.a.e(c);
            this.f = new C(c);
            return this;
        }

        public b(Context context, G1 g1) {
            this(context, new D(g1), new E(context));
            d4.a.e(g1);
        }

        public b(Context context, r5.r rVar, r5.r rVar2) {
            this(context, rVar, rVar2, new H(context), new I(), new J(context), new A());
        }

        public b(Context context, r5.r rVar, r5.r rVar2, r5.r rVar3, r5.r rVar4, r5.r rVar5, r5.f fVar) {
            this.a = (Context) d4.a.e(context);
            this.d = rVar;
            this.e = rVar2;
            this.f = rVar3;
            this.g = rVar4;
            this.h = rVar5;
            this.i = fVar;
            this.j = d4.k0.S();
            this.k = Q2.e.h;
            this.m = 0;
            this.q = 1;
            this.r = 0;
            this.s = true;
            this.t = H1.g;
            this.u = 5000L;
            this.v = 15000L;
            this.w = new p.b().a();
            this.b = d4.e.a;
            this.x = 500L;
            this.y = 2000L;
            this.A = true;
        }

        public static /* synthetic */ G1 p(G1 g1) {
            return g1;
        }

        public static /* synthetic */ C.a r(C.a aVar) {
            return aVar;
        }

        public static /* synthetic */ G1 s(G1 g1) {
            return g1;
        }

        public static /* synthetic */ Z3.C t(Z3.C c) {
            return c;
        }
    }

    void O(Q2.e eVar, boolean z);

    U2.e Q();

    z0 S();

    void W(P2.c cVar);

    z0 a();

    U2.e c0();
}
