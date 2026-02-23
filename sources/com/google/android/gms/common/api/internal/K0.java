package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.k;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class k0 implements GoogleApiClient.b, GoogleApiClient.c, f1 {
    public final a.f c;
    public final b d;
    public final z e;
    public final int h;
    public final J0 i;
    public boolean j;
    public final /* synthetic */ g n;
    public final Queue a = new LinkedList();
    public final Set f = new HashSet();
    public final Map g = new HashMap();
    public final List k = new ArrayList();
    public w4.b l = null;
    public int m = 0;

    public k0(g gVar, com.google.android.gms.common.api.e eVar) {
        this.n = gVar;
        a.f zab = eVar.zab(g.n(gVar).getLooper(), this);
        this.c = zab;
        this.d = eVar.getApiKey();
        this.e = new z();
        this.h = eVar.zaa();
        if (zab.requiresSignIn()) {
            this.i = eVar.zac(g.m(gVar), g.n(gVar));
        } else {
            this.i = null;
        }
    }

    public static /* bridge */ /* synthetic */ boolean K(k0 k0Var) {
        return k0Var.j;
    }

    public static /* bridge */ /* synthetic */ boolean L(k0 k0Var, boolean z) {
        return k0Var.o(false);
    }

    public static /* bridge */ /* synthetic */ a.f r(k0 k0Var) {
        return k0Var.c;
    }

    public static /* bridge */ /* synthetic */ b t(k0 k0Var) {
        return k0Var.d;
    }

    public static /* bridge */ /* synthetic */ void v(k0 k0Var, Status status) {
        k0Var.e(status);
    }

    public static /* bridge */ /* synthetic */ void w(k0 k0Var) {
        k0Var.h();
    }

    public static /* bridge */ /* synthetic */ void x(k0 k0Var, int i) {
        k0Var.i(i);
    }

    public static /* bridge */ /* synthetic */ void y(k0 k0Var, m0 m0Var) {
        if (k0Var.k.contains(m0Var) && !k0Var.j) {
            if (k0Var.c.isConnected()) {
                k0Var.g();
            } else {
                k0Var.C();
            }
        }
    }

    public static /* bridge */ /* synthetic */ void z(k0 k0Var, m0 m0Var) {
        w4.d[] g;
        if (k0Var.k.remove(m0Var)) {
            g.n(k0Var.n).removeMessages(15, m0Var);
            g.n(k0Var.n).removeMessages(16, m0Var);
            w4.d a = m0.a(m0Var);
            ArrayList arrayList = new ArrayList(k0Var.a.size());
            for (V0 v0 : k0Var.a) {
                if ((v0 instanceof u0) && (g = ((u0) v0).g(k0Var)) != null && C4.b.b(g, a)) {
                    arrayList.add(v0);
                }
            }
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                V0 v02 = (V0) arrayList.get(i);
                k0Var.a.remove(v02);
                v02.b(new com.google.android.gms.common.api.l(a));
            }
        }
    }

    public final void A(w4.b bVar, com.google.android.gms.common.api.a aVar, boolean z) {
        throw null;
    }

    public final void B() {
        com.google.android.gms.common.internal.r.d(g.n(this.n));
        this.l = null;
    }

    public final void C() {
        w4.b bVar;
        com.google.android.gms.common.internal.r.d(g.n(this.n));
        if (this.c.isConnected() || this.c.isConnecting()) {
            return;
        }
        try {
            g gVar = this.n;
            int b = g.u(gVar).b(g.m(gVar), this.c);
            if (b != 0) {
                w4.b bVar2 = new w4.b(b, null);
                Log.w("GoogleApiManager", "The service for " + this.c.getClass().getName() + " is not available: " + bVar2.toString());
                F(bVar2, null);
                return;
            }
            g gVar2 = this.n;
            a.f fVar = this.c;
            o0 o0Var = new o0(gVar2, fVar, this.d);
            if (fVar.requiresSignIn()) {
                ((J0) com.google.android.gms.common.internal.r.m(this.i)).c0(o0Var);
            }
            try {
                this.c.connect(o0Var);
            } catch (SecurityException e) {
                e = e;
                bVar = new w4.b(10);
                F(bVar, e);
            }
        } catch (IllegalStateException e2) {
            e = e2;
            bVar = new w4.b(10);
        }
    }

    public final void D(V0 v0) {
        com.google.android.gms.common.internal.r.d(g.n(this.n));
        if (this.c.isConnected()) {
            if (m(v0)) {
                j();
                return;
            } else {
                this.a.add(v0);
                return;
            }
        }
        this.a.add(v0);
        w4.b bVar = this.l;
        if (bVar == null || !bVar.K()) {
            C();
        } else {
            F(this.l, null);
        }
    }

    public final void E() {
        this.m++;
    }

    public final void F(w4.b bVar, Exception exc) {
        com.google.android.gms.common.internal.r.d(g.n(this.n));
        J0 j0 = this.i;
        if (j0 != null) {
            j0.c1();
        }
        B();
        g.u(this.n).c();
        d(bVar);
        if ((this.c instanceof z4.e) && bVar.H() != 24) {
            g.B(this.n, true);
            g gVar = this.n;
            g.n(gVar).sendMessageDelayed(g.n(gVar).obtainMessage(19), 300000L);
        }
        if (bVar.H() == 4) {
            e(g.p());
            return;
        }
        if (this.a.isEmpty()) {
            this.l = bVar;
            return;
        }
        if (exc != null) {
            com.google.android.gms.common.internal.r.d(g.n(this.n));
            f(null, exc, false);
            return;
        }
        if (!g.c(this.n)) {
            e(g.q(this.d, bVar));
            return;
        }
        f(g.q(this.d, bVar), null, true);
        if (this.a.isEmpty() || n(bVar) || this.n.e(bVar, this.h)) {
            return;
        }
        if (bVar.H() == 18) {
            this.j = true;
        }
        if (!this.j) {
            e(g.q(this.d, bVar));
            return;
        }
        g gVar2 = this.n;
        g.n(gVar2).sendMessageDelayed(Message.obtain(g.n(gVar2), 9, this.d), 5000L);
    }

    public final void G(w4.b bVar) {
        com.google.android.gms.common.internal.r.d(g.n(this.n));
        a.f fVar = this.c;
        fVar.disconnect("onSignInFailed for " + fVar.getClass().getName() + " with " + String.valueOf(bVar));
        F(bVar, null);
    }

    public final void H() {
        com.google.android.gms.common.internal.r.d(g.n(this.n));
        if (this.j) {
            C();
        }
    }

    public final void I() {
        com.google.android.gms.common.internal.r.d(g.n(this.n));
        e(g.q);
        this.e.f();
        for (k.a aVar : (k.a[]) this.g.keySet().toArray(new k.a[0])) {
            D(new U0(aVar, new TaskCompletionSource()));
        }
        d(new w4.b(4));
        if (this.c.isConnected()) {
            this.c.onUserSignOut(new j0(this));
        }
    }

    public final void J() {
        com.google.android.gms.common.internal.r.d(g.n(this.n));
        if (this.j) {
            l();
            g gVar = this.n;
            e(g.o(gVar).i(g.m(gVar)) == 18 ? new Status(21, "Connection timed out waiting for Google Play services update to complete.") : new Status(22, "API failed to connect while resuming due to an unknown error."));
            this.c.disconnect("Timing out connection while resuming.");
        }
    }

    public final boolean a() {
        return this.c.requiresSignIn();
    }

    public final boolean b() {
        return o(true);
    }

    public final w4.d c(w4.d[] dVarArr) {
        if (dVarArr != null && dVarArr.length != 0) {
            w4.d[] availableFeatures = this.c.getAvailableFeatures();
            if (availableFeatures == null) {
                availableFeatures = new w4.d[0];
            }
            s.a aVar = new s.a(availableFeatures.length);
            for (w4.d dVar : availableFeatures) {
                aVar.put(dVar.getName(), Long.valueOf(dVar.H()));
            }
            for (w4.d dVar2 : dVarArr) {
                Long l = (Long) aVar.get(dVar2.getName());
                if (l == null || l.longValue() < dVar2.H()) {
                    return dVar2;
                }
            }
        }
        return null;
    }

    public final void d(w4.b bVar) {
        Iterator it = this.f.iterator();
        if (!it.hasNext()) {
            this.f.clear();
            return;
        }
        d.D.a(it.next());
        if (com.google.android.gms.common.internal.q.b(bVar, w4.b.j)) {
            this.c.getEndpointPackageName();
        }
        throw null;
    }

    public final void e(Status status) {
        com.google.android.gms.common.internal.r.d(g.n(this.n));
        f(status, null, false);
    }

    public final void f(Status status, Exception exc, boolean z) {
        com.google.android.gms.common.internal.r.d(g.n(this.n));
        if ((status == null) == (exc == null)) {
            throw new IllegalArgumentException("Status XOR exception should be null");
        }
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            V0 v0 = (V0) it.next();
            if (!z || v0.a == 2) {
                if (status != null) {
                    v0.a(status);
                } else {
                    v0.b(exc);
                }
                it.remove();
            }
        }
    }

    public final void g() {
        ArrayList arrayList = new ArrayList(this.a);
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            V0 v0 = (V0) arrayList.get(i);
            if (!this.c.isConnected()) {
                return;
            }
            if (m(v0)) {
                this.a.remove(v0);
            }
        }
    }

    public final void h() {
        B();
        d(w4.b.j);
        l();
        Iterator it = this.g.values().iterator();
        while (it.hasNext()) {
            A0 a0 = (A0) it.next();
            if (c(a0.a.c()) == null) {
                try {
                    a0.a.d(this.c, new TaskCompletionSource());
                } catch (DeadObjectException unused) {
                    onConnectionSuspended(3);
                    this.c.disconnect("DeadObjectException thrown while calling register listener method.");
                } catch (RemoteException unused2) {
                }
            }
            it.remove();
        }
        g();
        j();
    }

    public final void i(int i) {
        B();
        this.j = true;
        this.e.e(i, this.c.getLastDisconnectMessage());
        b bVar = this.d;
        g gVar = this.n;
        g.n(gVar).sendMessageDelayed(Message.obtain(g.n(gVar), 9, bVar), 5000L);
        b bVar2 = this.d;
        g gVar2 = this.n;
        g.n(gVar2).sendMessageDelayed(Message.obtain(g.n(gVar2), 11, bVar2), 120000L);
        g.u(this.n).c();
        Iterator it = this.g.values().iterator();
        while (it.hasNext()) {
            ((A0) it.next()).c.run();
        }
    }

    public final void j() {
        g.n(this.n).removeMessages(12, this.d);
        b bVar = this.d;
        g gVar = this.n;
        g.n(gVar).sendMessageDelayed(g.n(gVar).obtainMessage(12, bVar), g.l(this.n));
    }

    public final void k(V0 v0) {
        v0.d(this.e, a());
        try {
            v0.c(this);
        } catch (DeadObjectException unused) {
            onConnectionSuspended(1);
            this.c.disconnect("DeadObjectException thrown while running ApiCallRunner.");
        }
    }

    public final void l() {
        if (this.j) {
            g gVar = this.n;
            g.n(gVar).removeMessages(11, this.d);
            g gVar2 = this.n;
            g.n(gVar2).removeMessages(9, this.d);
            this.j = false;
        }
    }

    public final boolean m(V0 v0) {
        if (!(v0 instanceof u0)) {
            k(v0);
            return true;
        }
        u0 u0Var = (u0) v0;
        w4.d c = c(u0Var.g(this));
        if (c == null) {
            k(v0);
            return true;
        }
        Log.w("GoogleApiManager", this.c.getClass().getName() + " could not execute call because it requires feature (" + c.getName() + ", " + c.H() + ").");
        if (!g.c(this.n) || !u0Var.f(this)) {
            u0Var.b(new com.google.android.gms.common.api.l(c));
            return true;
        }
        m0 m0Var = new m0(this.d, c, null);
        int indexOf = this.k.indexOf(m0Var);
        if (indexOf >= 0) {
            m0 m0Var2 = (m0) this.k.get(indexOf);
            g.n(this.n).removeMessages(15, m0Var2);
            g gVar = this.n;
            g.n(gVar).sendMessageDelayed(Message.obtain(g.n(gVar), 15, m0Var2), 5000L);
            return false;
        }
        this.k.add(m0Var);
        g gVar2 = this.n;
        g.n(gVar2).sendMessageDelayed(Message.obtain(g.n(gVar2), 15, m0Var), 5000L);
        g gVar3 = this.n;
        g.n(gVar3).sendMessageDelayed(Message.obtain(g.n(gVar3), 16, m0Var), 120000L);
        w4.b bVar = new w4.b(2, null);
        if (n(bVar)) {
            return false;
        }
        this.n.e(bVar, this.h);
        return false;
    }

    public final boolean n(w4.b bVar) {
        synchronized (g.y()) {
            try {
                g gVar = this.n;
                if (g.r(gVar) == null || !g.A(gVar).contains(this.d)) {
                    return false;
                }
                g.r(this.n).h(bVar, this.h);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean o(boolean z) {
        com.google.android.gms.common.internal.r.d(g.n(this.n));
        if (!this.c.isConnected() || !this.g.isEmpty()) {
            return false;
        }
        if (!this.e.g()) {
            this.c.disconnect("Timing out service connection.");
            return true;
        }
        if (!z) {
            return false;
        }
        j();
        return false;
    }

    public final void onConnected(Bundle bundle) {
        if (Looper.myLooper() == g.n(this.n).getLooper()) {
            h();
        } else {
            g.n(this.n).post(new g0(this));
        }
    }

    public final void onConnectionFailed(w4.b bVar) {
        F(bVar, null);
    }

    public final void onConnectionSuspended(int i) {
        if (Looper.myLooper() == g.n(this.n).getLooper()) {
            i(i);
        } else {
            g.n(this.n).post(new h0(this, i));
        }
    }

    public final int p() {
        return this.h;
    }

    public final int q() {
        return this.m;
    }

    public final a.f s() {
        return this.c;
    }

    public final Map u() {
        return this.g;
    }
}
