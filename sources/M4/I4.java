package M4;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Pair;
import com.google.android.gms.internal.measurement.zzcf;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class i4 extends G1 {
    public final h4 c;
    public p1 d;
    public volatile Boolean e;
    public final o f;
    public final A4 g;
    public final List h;
    public final o i;

    public i4(l2 l2Var) {
        super(l2Var);
        this.h = new ArrayList();
        this.g = new A4(l2Var.a());
        this.c = new h4(this);
        this.f = new S3(this, l2Var);
        this.i = new U3(this, l2Var);
    }

    public static /* bridge */ /* synthetic */ p1 H(i4 i4Var) {
        return i4Var.d;
    }

    public static /* bridge */ /* synthetic */ h4 I(i4 i4Var) {
        return i4Var.c;
    }

    public static /* bridge */ /* synthetic */ void K(i4 i4Var, p1 p1Var) {
        i4Var.d = null;
    }

    public static /* bridge */ /* synthetic */ void L(i4 i4Var) {
        i4Var.D();
    }

    public static /* bridge */ /* synthetic */ void M(i4 i4Var, ComponentName componentName) {
        i4Var.h();
        if (i4Var.d != null) {
            i4Var.d = null;
            i4Var.a.d().v().b("Disconnected from device MeasurementService", componentName);
            i4Var.h();
            i4Var.P();
        }
    }

    public static /* bridge */ /* synthetic */ void N(i4 i4Var) {
        i4Var.E();
    }

    public final boolean A() {
        h();
        i();
        return !B() || this.a.N().q0() >= ((Integer) m1.j0.a(null)).intValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0125  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean B() {
        /*
            Method dump skipped, instructions count: 330
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: M4.i4.B():boolean");
    }

    public final f5 C(boolean z) {
        Pair a;
        this.a.b();
        q1 B = this.a.B();
        String str = null;
        if (z) {
            z1 d = this.a.d();
            if (d.a.F().d != null && (a = d.a.F().d.a()) != null && a != P1.y) {
                str = String.valueOf(a.second) + ":" + ((String) a.first);
            }
        }
        return B.q(str);
    }

    public final void D() {
        h();
        this.a.d().v().b("Processing queued up service tasks", Integer.valueOf(this.h.size()));
        Iterator it = this.h.iterator();
        while (it.hasNext()) {
            try {
                ((Runnable) it.next()).run();
            } catch (RuntimeException e) {
                this.a.d().r().b("Task exception while flushing queue", e);
            }
        }
        this.h.clear();
        this.i.b();
    }

    public final void E() {
        h();
        this.g.b();
        o oVar = this.f;
        this.a.z();
        oVar.d(((Long) m1.L.a(null)).longValue());
    }

    public final void F(Runnable runnable) {
        h();
        if (z()) {
            runnable.run();
            return;
        }
        long size = this.h.size();
        this.a.z();
        if (size >= 1000) {
            this.a.d().r().a("Discarding data. Max runnable queue size reached");
            return;
        }
        this.h.add(runnable);
        this.i.d(60000L);
        P();
    }

    public final boolean G() {
        this.a.b();
        return true;
    }

    public final Boolean J() {
        return this.e;
    }

    public final void O() {
        h();
        i();
        f5 C = C(true);
        this.a.C().r();
        F(new P3(this, C));
    }

    public final void P() {
        h();
        i();
        if (z()) {
            return;
        }
        if (B()) {
            this.c.c();
            return;
        }
        if (this.a.z().G()) {
            return;
        }
        this.a.b();
        List queryIntentServices = this.a.c().getPackageManager().queryIntentServices(new Intent().setClassName(this.a.c(), "com.google.android.gms.measurement.AppMeasurementService"), 65536);
        if (queryIntentServices == null || queryIntentServices.isEmpty()) {
            this.a.d().r().a("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
            return;
        }
        Intent intent = new Intent("com.google.android.gms.measurement.START");
        Context c = this.a.c();
        this.a.b();
        intent.setComponent(new ComponentName(c, "com.google.android.gms.measurement.AppMeasurementService"));
        this.c.b(intent);
    }

    public final void Q() {
        h();
        i();
        this.c.d();
        try {
            B4.b.b().c(this.a.c(), this.c);
        } catch (IllegalStateException | IllegalArgumentException unused) {
        }
        this.d = null;
    }

    public final void R(zzcf zzcfVar) {
        h();
        i();
        F(new O3(this, C(false), zzcfVar));
    }

    public final void S(AtomicReference atomicReference) {
        h();
        i();
        F(new N3(this, atomicReference, C(false)));
    }

    public final void T(zzcf zzcfVar, String str, String str2) {
        h();
        i();
        F(new a4(this, str, str2, C(false), zzcfVar));
    }

    public final void U(AtomicReference atomicReference, String str, String str2, String str3) {
        h();
        i();
        F(new Z3(this, atomicReference, null, str2, str3, C(false)));
    }

    public final void V(zzcf zzcfVar, String str, String str2, boolean z) {
        h();
        i();
        F(new K3(this, str, str2, C(false), z, zzcfVar));
    }

    public final void W(AtomicReference atomicReference, String str, String str2, String str3, boolean z) {
        h();
        i();
        F(new b4(this, atomicReference, null, str2, str3, C(false), z));
    }

    public final boolean n() {
        return false;
    }

    public final void o(v vVar, String str) {
        com.google.android.gms.common.internal.r.m(vVar);
        h();
        i();
        G();
        F(new X3(this, true, C(true), this.a.C().v(vVar), vVar, str));
    }

    public final void p(zzcf zzcfVar, v vVar, String str) {
        h();
        i();
        if (this.a.N().r0(12451000) == 0) {
            F(new T3(this, vVar, str, zzcfVar));
        } else {
            this.a.d().w().a("Not bundling data. Service unavailable or out of date");
            this.a.N().H(zzcfVar, new byte[0]);
        }
    }

    public final void q() {
        h();
        i();
        f5 C = C(false);
        G();
        this.a.C().q();
        F(new M3(this, C));
    }

    public final void r(p1 p1Var, y4.a aVar, f5 f5Var) {
        int i;
        x1 r;
        String str;
        h();
        i();
        G();
        this.a.z();
        int i2 = 0;
        int i3 = 100;
        while (i2 < 1001 && i3 == 100) {
            ArrayList arrayList = new ArrayList();
            List p = this.a.C().p(100);
            if (p != null) {
                arrayList.addAll(p);
                i = p.size();
            } else {
                i = 0;
            }
            if (aVar != null && i < 100) {
                arrayList.add(aVar);
            }
            int size = arrayList.size();
            for (int i4 = 0; i4 < size; i4++) {
                y4.a aVar2 = (y4.a) arrayList.get(i4);
                if (aVar2 instanceof v) {
                    try {
                        p1Var.N((v) aVar2, f5Var);
                    } catch (RemoteException e) {
                        e = e;
                        r = this.a.d().r();
                        str = "Failed to send event to the service";
                        r.b(str, e);
                    }
                } else if (aVar2 instanceof V4) {
                    try {
                        p1Var.a1((V4) aVar2, f5Var);
                    } catch (RemoteException e2) {
                        e = e2;
                        r = this.a.d().r();
                        str = "Failed to send user property to the service";
                        r.b(str, e);
                    }
                } else if (aVar2 instanceof d) {
                    try {
                        p1Var.P0((d) aVar2, f5Var);
                    } catch (RemoteException e3) {
                        e = e3;
                        r = this.a.d().r();
                        str = "Failed to send conditional user property to the service";
                        r.b(str, e);
                    }
                } else {
                    this.a.d().r().a("Discarding data. Unrecognized parcel type.");
                }
            }
            i2++;
            i3 = i;
        }
    }

    public final void s(d dVar) {
        com.google.android.gms.common.internal.r.m(dVar);
        h();
        i();
        this.a.b();
        F(new Y3(this, true, C(true), this.a.C().u(dVar), new d(dVar), dVar));
    }

    public final void t(boolean z) {
        h();
        i();
        if (z) {
            G();
            this.a.C().q();
        }
        if (A()) {
            F(new W3(this, C(false)));
        }
    }

    public final void u(A3 a3) {
        h();
        i();
        F(new Q3(this, a3));
    }

    public final void v(Bundle bundle) {
        h();
        i();
        F(new R3(this, C(false), bundle));
    }

    public final void w() {
        h();
        i();
        F(new V3(this, C(true)));
    }

    public final void x(p1 p1Var) {
        h();
        com.google.android.gms.common.internal.r.m(p1Var);
        this.d = p1Var;
        E();
        D();
    }

    public final void y(V4 v4) {
        h();
        i();
        G();
        F(new L3(this, C(true), this.a.C().w(v4), v4));
    }

    public final boolean z() {
        h();
        i();
        return this.d != null;
    }
}
