package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.internal.base.zap;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.Lock;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class w implements v0 {
    public final Context a;
    public final Y c;
    public final Looper d;
    public final c0 e;
    public final c0 f;
    public final Map g;
    public final a.f i;
    public Bundle j;
    public final Lock n;
    public final Set h = Collections.newSetFromMap(new WeakHashMap());
    public w4.b k = null;
    public w4.b l = null;
    public boolean m = false;
    public int o = 0;

    public w(Context context, Y y, Lock lock, Looper looper, w4.i iVar, Map map, Map map2, com.google.android.gms.common.internal.e eVar, a.a aVar, a.f fVar, ArrayList arrayList, ArrayList arrayList2, Map map3, Map map4) {
        this.a = context;
        this.c = y;
        this.n = lock;
        this.d = looper;
        this.i = fVar;
        this.e = new c0(context, y, lock, looper, iVar, map2, null, map4, null, arrayList2, new h1(this, null));
        this.f = new c0(context, y, lock, looper, iVar, map, eVar, map3, aVar, arrayList, new j1(this, null));
        s.a aVar2 = new s.a();
        Iterator it = map2.keySet().iterator();
        while (it.hasNext()) {
            aVar2.put((a.c) it.next(), this.e);
        }
        Iterator it2 = map.keySet().iterator();
        while (it2.hasNext()) {
            aVar2.put((a.c) it2.next(), this.f);
        }
        this.g = Collections.unmodifiableMap(aVar2);
    }

    public static boolean k(w4.b bVar) {
        return bVar != null && bVar.L();
    }

    public static /* bridge */ /* synthetic */ w4.b l(w wVar) {
        return wVar.l;
    }

    public static w m(Context context, Y y, Lock lock, Looper looper, w4.i iVar, Map map, com.google.android.gms.common.internal.e eVar, Map map2, a.a aVar, ArrayList arrayList) {
        s.a aVar2 = new s.a();
        s.a aVar3 = new s.a();
        a.f fVar = null;
        for (Map.Entry entry : map.entrySet()) {
            a.f fVar2 = (a.f) entry.getValue();
            if (true == fVar2.providesSignIn()) {
                fVar = fVar2;
            }
            boolean requiresSignIn = fVar2.requiresSignIn();
            a.c cVar = (a.c) entry.getKey();
            if (requiresSignIn) {
                aVar2.put(cVar, fVar2);
            } else {
                aVar3.put(cVar, fVar2);
            }
        }
        com.google.android.gms.common.internal.r.q(!aVar2.isEmpty(), "CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
        s.a aVar4 = new s.a();
        s.a aVar5 = new s.a();
        for (com.google.android.gms.common.api.a aVar6 : map2.keySet()) {
            a.c b = aVar6.b();
            if (aVar2.containsKey(b)) {
                aVar4.put(aVar6, (Boolean) map2.get(aVar6));
            } else {
                if (!aVar3.containsKey(b)) {
                    throw new IllegalStateException("Each API in the isOptionalMap must have a corresponding client in the clients map.");
                }
                aVar5.put(aVar6, (Boolean) map2.get(aVar6));
            }
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            e1 e1Var = (e1) arrayList.get(i);
            if (aVar4.containsKey(e1Var.a)) {
                arrayList2.add(e1Var);
            } else {
                if (!aVar5.containsKey(e1Var.a)) {
                    throw new IllegalStateException("Each ClientCallbacks must have a corresponding API in the isOptionalMap");
                }
                arrayList3.add(e1Var);
            }
        }
        return new w(context, y, lock, looper, iVar, aVar2, aVar3, eVar, aVar, fVar, arrayList2, arrayList3, aVar4, aVar5);
    }

    public static /* bridge */ /* synthetic */ c0 n(w wVar) {
        return wVar.e;
    }

    public static /* bridge */ /* synthetic */ c0 o(w wVar) {
        return wVar.f;
    }

    public static /* bridge */ /* synthetic */ Lock p(w wVar) {
        return wVar.n;
    }

    public static /* bridge */ /* synthetic */ void q(w wVar, w4.b bVar) {
        wVar.k = bVar;
    }

    public static /* bridge */ /* synthetic */ void r(w wVar, w4.b bVar) {
        wVar.l = bVar;
    }

    public static /* bridge */ /* synthetic */ void s(w wVar, boolean z) {
        wVar.m = z;
    }

    public static /* bridge */ /* synthetic */ void t(w wVar, int i, boolean z) {
        wVar.c.c(i, z);
        wVar.l = null;
        wVar.k = null;
    }

    public static /* bridge */ /* synthetic */ void u(w wVar, Bundle bundle) {
        Bundle bundle2 = wVar.j;
        if (bundle2 == null) {
            wVar.j = bundle;
        } else if (bundle != null) {
            bundle2.putAll(bundle);
        }
    }

    public static /* bridge */ /* synthetic */ void v(w wVar) {
        w4.b bVar;
        if (!k(wVar.k)) {
            if (wVar.k != null && k(wVar.l)) {
                wVar.f.b();
                wVar.g((w4.b) com.google.android.gms.common.internal.r.m(wVar.k));
                return;
            }
            w4.b bVar2 = wVar.k;
            if (bVar2 == null || (bVar = wVar.l) == null) {
                return;
            }
            if (wVar.f.n < wVar.e.n) {
                bVar2 = bVar;
            }
            wVar.g(bVar2);
            return;
        }
        if (k(wVar.l) || wVar.i()) {
            int i = wVar.o;
            if (i == 1) {
                wVar.h();
            } else if (i != 2) {
                Log.wtf("CompositeGAC", "Attempted to call success callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new AssertionError());
            } else {
                ((Y) com.google.android.gms.common.internal.r.m(wVar.c)).a(wVar.j);
                wVar.h();
            }
            wVar.o = 0;
            return;
        }
        w4.b bVar3 = wVar.l;
        if (bVar3 != null) {
            if (wVar.o == 1) {
                wVar.h();
            } else {
                wVar.g(bVar3);
                wVar.e.b();
            }
        }
    }

    public static /* bridge */ /* synthetic */ boolean w(w wVar) {
        return wVar.m;
    }

    public final void a() {
        this.o = 2;
        this.m = false;
        this.l = null;
        this.k = null;
        this.e.a();
        this.f.a();
    }

    public final void b() {
        this.l = null;
        this.k = null;
        this.o = 0;
        this.e.b();
        this.f.b();
        h();
    }

    public final void c(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append(str).append("authClient").println(":");
        this.f.c(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
        printWriter.append(str).append("anonClient").println(":");
        this.e.c(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
    }

    public final d d(d dVar) {
        if (!j(dVar)) {
            this.e.d(dVar);
            return dVar;
        }
        if (i()) {
            dVar.setFailedResult(new Status(4, (String) null, x()));
            return dVar;
        }
        this.f.d(dVar);
        return dVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean e() {
        /*
            r3 = this;
            java.util.concurrent.locks.Lock r0 = r3.n
            r0.lock()
            com.google.android.gms.common.api.internal.c0 r0 = r3.e     // Catch: java.lang.Throwable -> L23
            boolean r0 = r0.e()     // Catch: java.lang.Throwable -> L23
            r1 = 0
            if (r0 == 0) goto L25
            com.google.android.gms.common.api.internal.c0 r0 = r3.f     // Catch: java.lang.Throwable -> L23
            boolean r0 = r0.e()     // Catch: java.lang.Throwable -> L23
            r2 = 1
            if (r0 != 0) goto L21
            boolean r0 = r3.i()     // Catch: java.lang.Throwable -> L23
            if (r0 != 0) goto L21
            int r0 = r3.o     // Catch: java.lang.Throwable -> L23
            if (r0 != r2) goto L25
        L21:
            r1 = 1
            goto L25
        L23:
            r0 = move-exception
            goto L2b
        L25:
            java.util.concurrent.locks.Lock r0 = r3.n
            r0.unlock()
            return r1
        L2b:
            java.util.concurrent.locks.Lock r1 = r3.n
            r1.unlock()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.w.e():boolean");
    }

    public final d f(d dVar) {
        if (!j(dVar)) {
            return this.e.f(dVar);
        }
        if (!i()) {
            return this.f.f(dVar);
        }
        dVar.setFailedResult(new Status(4, (String) null, x()));
        return dVar;
    }

    public final void g(w4.b bVar) {
        int i = this.o;
        if (i == 1) {
            h();
        } else if (i != 2) {
            Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
        } else {
            this.c.b(bVar);
            h();
        }
        this.o = 0;
    }

    public final void h() {
        Iterator it = this.h.iterator();
        if (it.hasNext()) {
            d.D.a(it.next());
            throw null;
        }
        this.h.clear();
    }

    public final boolean i() {
        w4.b bVar = this.l;
        return bVar != null && bVar.H() == 4;
    }

    public final boolean j(d dVar) {
        c0 c0Var = (c0) this.g.get(dVar.getClientKey());
        com.google.android.gms.common.internal.r.n(c0Var, "GoogleApiClient is not configured to use the API required for this call.");
        return c0Var.equals(this.f);
    }

    public final PendingIntent x() {
        a.f fVar = this.i;
        if (fVar == null) {
            return null;
        }
        return PendingIntent.getActivity(this.a, System.identityHashCode(this.c), fVar.getSignInIntent(), zap.zaa | 134217728);
    }
}
