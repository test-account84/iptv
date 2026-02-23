package J2;

import D2.g;
import F2.c;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import j$.util.Objects;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executor;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class r {
    public final Context a;
    public final D2.e b;
    public final K2.d c;
    public final x d;
    public final Executor e;
    public final L2.b f;
    public final M2.a g;
    public final M2.a h;
    public final K2.c i;

    public r(Context context, D2.e eVar, K2.d dVar, x xVar, Executor executor, L2.b bVar, M2.a aVar, M2.a aVar2, K2.c cVar) {
        this.a = context;
        this.b = eVar;
        this.c = dVar;
        this.d = xVar;
        this.e = executor;
        this.f = bVar;
        this.g = aVar;
        this.h = aVar2;
        this.i = cVar;
    }

    public static /* synthetic */ Iterable a(r rVar, C2.p pVar) {
        return rVar.m(pVar);
    }

    public static /* synthetic */ Object b(r rVar, Iterable iterable, C2.p pVar, long j) {
        return rVar.n(iterable, pVar, j);
    }

    public static /* synthetic */ Object c(r rVar) {
        return rVar.p();
    }

    public static /* synthetic */ Boolean d(r rVar, C2.p pVar) {
        return rVar.l(pVar);
    }

    public static /* synthetic */ Object e(r rVar, Iterable iterable) {
        return rVar.o(iterable);
    }

    public static /* synthetic */ Object f(r rVar, C2.p pVar, int i) {
        return rVar.s(pVar, i);
    }

    public static /* synthetic */ Object g(r rVar, C2.p pVar, long j) {
        return rVar.r(pVar, j);
    }

    public static /* synthetic */ Object h(r rVar, Map map) {
        return rVar.q(map);
    }

    public static /* synthetic */ void i(r rVar, C2.p pVar, int i, Runnable runnable) {
        rVar.t(pVar, i, runnable);
    }

    public C2.i j(D2.m mVar) {
        L2.b bVar = this.f;
        K2.c cVar = this.i;
        Objects.requireNonNull(cVar);
        return mVar.a(C2.i.a().i(this.g.a()).k(this.h.a()).j("GDT_CLIENT_METRICS").h(new C2.h(z2.b.b("proto"), ((F2.a) bVar.a(new h(cVar))).f())).d());
    }

    public boolean k() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.a.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public final /* synthetic */ Boolean l(C2.p pVar) {
        return Boolean.valueOf(this.c.M(pVar));
    }

    public final /* synthetic */ Iterable m(C2.p pVar) {
        return this.c.L(pVar);
    }

    public final /* synthetic */ Object n(Iterable iterable, C2.p pVar, long j) {
        this.c.N(iterable);
        this.c.P(pVar, this.g.a() + j);
        return null;
    }

    public final /* synthetic */ Object o(Iterable iterable) {
        this.c.z(iterable);
        return null;
    }

    public final /* synthetic */ Object p() {
        this.i.c();
        return null;
    }

    public final /* synthetic */ Object q(Map map) {
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            this.i.d(((Integer) r0.getValue()).intValue(), c.b.INVALID_PAYLOD, (String) ((Map.Entry) it.next()).getKey());
        }
        return null;
    }

    public final /* synthetic */ Object r(C2.p pVar, long j) {
        this.c.P(pVar, this.g.a() + j);
        return null;
    }

    public final /* synthetic */ Object s(C2.p pVar, int i) {
        this.d.b(pVar, i + 1);
        return null;
    }

    public final /* synthetic */ void t(C2.p pVar, int i, Runnable runnable) {
        try {
            try {
                L2.b bVar = this.f;
                K2.d dVar = this.c;
                Objects.requireNonNull(dVar);
                bVar.a(new i(dVar));
                if (k()) {
                    u(pVar, i);
                } else {
                    this.f.a(new j(this, pVar, i));
                }
            } catch (L2.a unused) {
                this.d.b(pVar, i + 1);
            }
            runnable.run();
        } catch (Throwable th) {
            runnable.run();
            throw th;
        }
    }

    public D2.g u(C2.p pVar, int i) {
        D2.g b;
        D2.m mVar = this.b.get(pVar.b());
        long j = 0;
        D2.g e = D2.g.e(0L);
        while (true) {
            long j2 = j;
            while (((Boolean) this.f.a(new k(this, pVar))).booleanValue()) {
                Iterable iterable = (Iterable) this.f.a(new l(this, pVar));
                if (!iterable.iterator().hasNext()) {
                    return e;
                }
                if (mVar == null) {
                    G2.a.b("Uploader", "Unknown backend for %s, deleting event batch for it...", pVar);
                    b = D2.g.a();
                } else {
                    Iterable arrayList = new ArrayList();
                    Iterator it = iterable.iterator();
                    while (it.hasNext()) {
                        arrayList.add(((K2.k) it.next()).b());
                    }
                    if (pVar.e()) {
                        arrayList.add(j(mVar));
                    }
                    b = mVar.b(D2.f.a().b(arrayList).c(pVar.c()).a());
                }
                e = b;
                if (e.c() == g.a.TRANSIENT_ERROR) {
                    this.f.a(new m(this, iterable, pVar, j2));
                    this.d.a(pVar, i + 1, true);
                    return e;
                }
                this.f.a(new n(this, iterable));
                if (e.c() == g.a.OK) {
                    j = Math.max(j2, e.b());
                    if (pVar.e()) {
                        this.f.a(new o(this));
                    }
                } else if (e.c() == g.a.INVALID_PAYLOAD) {
                    HashMap hashMap = new HashMap();
                    Iterator it2 = iterable.iterator();
                    while (it2.hasNext()) {
                        String j3 = ((K2.k) it2.next()).b().j();
                        hashMap.put(j3, !hashMap.containsKey(j3) ? 1 : Integer.valueOf(((Integer) hashMap.get(j3)).intValue() + 1));
                    }
                    this.f.a(new p(this, hashMap));
                }
            }
            this.f.a(new q(this, pVar, j2));
            return e;
        }
    }

    public void v(C2.p pVar, int i, Runnable runnable) {
        this.e.execute(new g(this, pVar, i, runnable));
    }
}
