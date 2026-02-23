package C2;

import C2.v;
import K2.N;
import K2.V;
import android.content.Context;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class e extends v {
    public j8.a a;
    public j8.a c;
    public j8.a d;
    public j8.a e;
    public j8.a f;
    public j8.a g;
    public j8.a h;
    public j8.a i;
    public j8.a j;
    public j8.a k;
    public j8.a l;
    public j8.a m;
    public j8.a n;

    public static final class b implements v.a {
        public Context a;

        public b() {
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public b a(Context context) {
            this.a = (Context) E2.d.b(context);
            return this;
        }

        public v build() {
            E2.d.a(this.a, Context.class);
            return new e(this.a, null);
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    public e(Context context) {
        e(context);
    }

    public static v.a d() {
        return new b(null);
    }

    public K2.d a() {
        return (K2.d) this.h.get();
    }

    public u c() {
        return (u) this.n.get();
    }

    public final void e(Context context) {
        this.a = E2.a.a(k.a());
        E2.b a2 = E2.c.a(context);
        this.c = a2;
        D2.j a3 = D2.j.a(a2, M2.c.a(), M2.d.a());
        this.d = a3;
        this.e = E2.a.a(D2.l.a(this.c, a3));
        this.f = V.a(this.c, K2.g.a(), K2.i.a());
        this.g = E2.a.a(K2.h.a(this.c));
        this.h = E2.a.a(N.a(M2.c.a(), M2.d.a(), K2.j.a(), this.f, this.g));
        I2.g b2 = I2.g.b(M2.c.a());
        this.i = b2;
        I2.i a4 = I2.i.a(this.c, this.h, b2, M2.d.a());
        this.j = a4;
        j8.a aVar = this.a;
        j8.a aVar2 = this.e;
        j8.a aVar3 = this.h;
        this.k = I2.d.a(aVar, aVar2, a4, aVar3, aVar3);
        j8.a aVar4 = this.c;
        j8.a aVar5 = this.e;
        j8.a aVar6 = this.h;
        this.l = J2.s.a(aVar4, aVar5, aVar6, this.j, this.a, aVar6, M2.c.a(), M2.d.a(), this.h);
        j8.a aVar7 = this.a;
        j8.a aVar8 = this.h;
        this.m = J2.w.a(aVar7, aVar8, this.j, aVar8);
        this.n = E2.a.a(w.a(M2.c.a(), M2.d.a(), this.k, this.l, this.m));
    }

    public /* synthetic */ e(Context context, a aVar) {
        this(context);
    }
}
