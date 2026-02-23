package u0;

import android.content.ComponentName;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.view.Display;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import u0.F;
import u0.H;
import u0.I;
import u0.L;
import u0.d0;
import u0.e0;
import u0.f0;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class m0 extends H {

    public static class a extends d {
        public a(Context context, e eVar) {
            super(context, eVar);
        }

        public void O(b.b bVar, F.a aVar) {
            super.O(bVar, aVar);
            aVar.i(c0.a(bVar.a));
        }
    }

    public static class c extends b implements e0.a {
        public c(Context context, e eVar) {
            super(context, eVar);
        }

        public Object G() {
            return e0.a(this);
        }

        public void O(b.b bVar, F.a aVar) {
            super.O(bVar, aVar);
            if (!e0.c.b(bVar.a)) {
                aVar.j(false);
            }
            if (V(bVar)) {
                aVar.g(1);
            }
            Display a = e0.c.a(bVar.a);
            if (a != null) {
                aVar.q(a.getDisplayId());
            }
        }

        public abstract boolean V(b.b bVar);

        public void i(Object obj) {
            int I = I(obj);
            if (I >= 0) {
                b.b bVar = (b.b) this.r.get(I);
                Display a = e0.c.a(obj);
                int displayId = a != null ? a.getDisplayId() : -1;
                if (displayId != bVar.c.r()) {
                    bVar.c = new F.a(bVar.c).q(displayId).e();
                    P();
                }
            }
        }
    }

    public static class d extends c {
        public d(Context context, e eVar) {
            super(context, eVar);
        }

        public Object L() {
            return f0.b(this.k);
        }

        public void O(b.b bVar, F.a aVar) {
            super.O(bVar, aVar);
            CharSequence a = f0.a.a(bVar.a);
            if (a != null) {
                aVar.h(a.toString());
            }
        }

        public void Q(Object obj) {
            d0.j(this.k, 8388611, obj);
        }

        public void R() {
            if (this.q) {
                d0.h(this.k, this.l);
            }
            this.q = true;
            f0.a(this.k, this.o, this.l, (this.p ? 1 : 0) | 2);
        }

        public void U(b.c cVar) {
            super.U(cVar);
            f0.b.a(cVar.b, cVar.a.d());
        }

        public boolean V(b.b bVar) {
            return f0.a.b(bVar.a);
        }
    }

    public interface e {
        void c(String str);
    }

    public m0(Context context) {
        super(context, new H.d(new ComponentName("android", m0.class.getName())));
    }

    public static m0 z(Context context, e eVar) {
        return Build.VERSION.SDK_INT >= 24 ? new a(context, eVar) : new d(context, eVar);
    }

    public abstract void A(L.h hVar);

    public abstract void B(L.h hVar);

    public abstract void C(L.h hVar);

    public abstract void D(L.h hVar);

    public static class b extends m0 implements d0.a, d0.e {
        public static final ArrayList t;
        public static final ArrayList u;
        public final e j;
        public final Object k;
        public final Object l;
        public final Object m;
        public final Object n;
        public int o;
        public boolean p;
        public boolean q;
        public final ArrayList r;
        public final ArrayList s;

        public static final class a extends H.e {
            public final Object a;

            public a(Object obj) {
                this.a = obj;
            }

            public void f(int i) {
                d0.c.i(this.a, i);
            }

            public void i(int i) {
                d0.c.j(this.a, i);
            }
        }

        public static final class b {
            public final Object a;
            public final String b;
            public F c;

            public b(Object obj, String str) {
                this.a = obj;
                this.b = str;
            }
        }

        public static final class c {
            public final L.h a;
            public final Object b;

            public c(L.h hVar, Object obj) {
                this.a = hVar;
                this.b = obj;
            }
        }

        static {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addCategory("android.media.intent.category.LIVE_AUDIO");
            ArrayList arrayList = new ArrayList();
            t = arrayList;
            arrayList.add(intentFilter);
            IntentFilter intentFilter2 = new IntentFilter();
            intentFilter2.addCategory("android.media.intent.category.LIVE_VIDEO");
            ArrayList arrayList2 = new ArrayList();
            u = arrayList2;
            arrayList2.add(intentFilter2);
        }

        public b(Context context, e eVar) {
            super(context);
            this.r = new ArrayList();
            this.s = new ArrayList();
            this.j = eVar;
            Object e = d0.e(context);
            this.k = e;
            this.l = G();
            this.m = H();
            this.n = d0.b(e, context.getResources().getString(t0.j.s), false);
            T();
        }

        public void A(L.h hVar) {
            if (hVar.r() == this) {
                int I = I(d0.g(this.k, 8388611));
                if (I < 0 || !((b) this.r.get(I)).b.equals(hVar.e())) {
                    return;
                }
                hVar.I();
                return;
            }
            Object c2 = d0.c(this.k, this.n);
            c cVar = new c(hVar, c2);
            d0.c.k(c2, cVar);
            d0.d.f(c2, this.m);
            U(cVar);
            this.s.add(cVar);
            d0.a(this.k, c2);
        }

        public void B(L.h hVar) {
            int K;
            if (hVar.r() == this || (K = K(hVar)) < 0) {
                return;
            }
            U((c) this.s.get(K));
        }

        public void C(L.h hVar) {
            int K;
            if (hVar.r() == this || (K = K(hVar)) < 0) {
                return;
            }
            c cVar = (c) this.s.remove(K);
            d0.c.k(cVar.b, null);
            d0.d.f(cVar.b, null);
            d0.i(this.k, cVar.b);
        }

        public void D(L.h hVar) {
            Object obj;
            if (hVar.C()) {
                if (hVar.r() != this) {
                    int K = K(hVar);
                    if (K < 0) {
                        return;
                    } else {
                        obj = ((c) this.s.get(K)).b;
                    }
                } else {
                    int J = J(hVar.e());
                    if (J < 0) {
                        return;
                    } else {
                        obj = ((b) this.r.get(J)).a;
                    }
                }
                Q(obj);
            }
        }

        public final boolean E(Object obj) {
            if (N(obj) != null || I(obj) >= 0) {
                return false;
            }
            b bVar = new b(obj, F(obj));
            S(bVar);
            this.r.add(bVar);
            return true;
        }

        public final String F(Object obj) {
            String format = L() == obj ? "DEFAULT_ROUTE" : String.format(Locale.US, "ROUTE_%08x", new Object[]{Integer.valueOf(M(obj).hashCode())});
            if (J(format) < 0) {
                return format;
            }
            int i = 2;
            while (true) {
                String format2 = String.format(Locale.US, "%s_%d", new Object[]{format, Integer.valueOf(i)});
                if (J(format2) < 0) {
                    return format2;
                }
                i++;
            }
        }

        public abstract Object G();

        public Object H() {
            return d0.d(this);
        }

        public int I(Object obj) {
            int size = this.r.size();
            for (int i = 0; i < size; i++) {
                if (((b) this.r.get(i)).a == obj) {
                    return i;
                }
            }
            return -1;
        }

        public int J(String str) {
            int size = this.r.size();
            for (int i = 0; i < size; i++) {
                if (((b) this.r.get(i)).b.equals(str)) {
                    return i;
                }
            }
            return -1;
        }

        public int K(L.h hVar) {
            int size = this.s.size();
            for (int i = 0; i < size; i++) {
                if (((c) this.s.get(i)).a == hVar) {
                    return i;
                }
            }
            return -1;
        }

        public abstract Object L();

        public String M(Object obj) {
            CharSequence a2 = d0.c.a(obj, n());
            return a2 != null ? a2.toString() : "";
        }

        public c N(Object obj) {
            Object e = d0.c.e(obj);
            if (e instanceof c) {
                return (c) e;
            }
            return null;
        }

        public void O(b bVar, F.a aVar) {
            int d = d0.c.d(bVar.a);
            if ((d & 1) != 0) {
                aVar.b(t);
            }
            if ((d & 2) != 0) {
                aVar.b(u);
            }
            aVar.p(d0.c.c(bVar.a));
            aVar.o(d0.c.b(bVar.a));
            aVar.r(d0.c.f(bVar.a));
            aVar.t(d0.c.h(bVar.a));
            aVar.s(d0.c.g(bVar.a));
        }

        public void P() {
            I.a aVar = new I.a();
            int size = this.r.size();
            for (int i = 0; i < size; i++) {
                aVar.a(((b) this.r.get(i)).c);
            }
            w(aVar.c());
        }

        public abstract void Q(Object obj);

        public abstract void R();

        public void S(b bVar) {
            F.a aVar = new F.a(bVar.b, M(bVar.a));
            O(bVar, aVar);
            bVar.c = aVar.e();
        }

        public final void T() {
            R();
            Iterator it = d0.f(this.k).iterator();
            boolean z = false;
            while (it.hasNext()) {
                z |= E(it.next());
            }
            if (z) {
                P();
            }
        }

        public void U(c cVar) {
            d0.d.a(cVar.b, cVar.a.m());
            d0.d.c(cVar.b, cVar.a.o());
            d0.d.b(cVar.b, cVar.a.n());
            d0.d.e(cVar.b, cVar.a.s());
            d0.d.h(cVar.b, cVar.a.u());
            d0.d.g(cVar.b, cVar.a.t());
        }

        public void a(Object obj, int i) {
            c N = N(obj);
            if (N != null) {
                N.a.H(i);
            }
        }

        public void d(Object obj, int i) {
            c N = N(obj);
            if (N != null) {
                N.a.G(i);
            }
        }

        public void e(Object obj) {
            int I;
            if (N(obj) != null || (I = I(obj)) < 0) {
                return;
            }
            S((b) this.r.get(I));
            P();
        }

        public void g(Object obj) {
            int I;
            if (N(obj) != null || (I = I(obj)) < 0) {
                return;
            }
            this.r.remove(I);
            P();
        }

        public void h(int i, Object obj) {
            if (obj != d0.g(this.k, 8388611)) {
                return;
            }
            c N = N(obj);
            if (N != null) {
                N.a.I();
                return;
            }
            int I = I(obj);
            if (I >= 0) {
                this.j.c(((b) this.r.get(I)).b);
            }
        }

        public void j(Object obj) {
            if (E(obj)) {
                P();
            }
        }

        public void k(Object obj) {
            int I;
            if (N(obj) != null || (I = I(obj)) < 0) {
                return;
            }
            b bVar = (b) this.r.get(I);
            int f = d0.c.f(obj);
            if (f != bVar.c.t()) {
                bVar.c = new F.a(bVar.c).r(f).e();
                P();
            }
        }

        public H.e s(String str) {
            int J = J(str);
            if (J >= 0) {
                return new a(((b) this.r.get(J)).a);
            }
            return null;
        }

        public void u(G g) {
            boolean z;
            int i = 0;
            if (g != null) {
                List e = g.c().e();
                int size = e.size();
                int i2 = 0;
                while (i < size) {
                    String str = (String) e.get(i);
                    i2 = str.equals("android.media.intent.category.LIVE_AUDIO") ? i2 | 1 : str.equals("android.media.intent.category.LIVE_VIDEO") ? i2 | 2 : i2 | 8388608;
                    i++;
                }
                z = g.d();
                i = i2;
            } else {
                z = false;
            }
            if (this.o == i && this.p == z) {
                return;
            }
            this.o = i;
            this.p = z;
            T();
        }

        public void b(Object obj, Object obj2) {
        }

        public void f(int i, Object obj) {
        }

        public void c(Object obj, Object obj2, int i) {
        }
    }
}
