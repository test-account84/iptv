package M4;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.internal.measurement.zzcl;
import com.google.android.gms.internal.measurement.zzib;
import com.google.android.gms.internal.measurement.zzos;
import java.net.URL;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class l2 implements G2 {
    public static volatile l2 H;
    public volatile Boolean A;
    public Boolean B;
    public Boolean C;
    public volatile boolean D;
    public int E;
    public final long G;
    public final Context a;
    public final String b;
    public final String c;
    public final String d;
    public final boolean e;
    public final c f;
    public final h g;
    public final P1 h;
    public final z1 i;
    public final i2 j;
    public final z4 k;
    public final a5 l;
    public final u1 m;
    public final C4.e n;
    public final I3 o;
    public final t3 p;
    public final E0 q;
    public final x3 r;
    public final String s;
    public s1 t;
    public i4 u;
    public p v;
    public q1 w;
    public Boolean y;
    public long z;
    public boolean x = false;
    public final AtomicInteger F = new AtomicInteger(0);

    public l2(R2 r2) {
        x1 w;
        String str;
        Bundle bundle;
        com.google.android.gms.common.internal.r.m(r2);
        Context context = r2.a;
        c cVar = new c(context);
        this.f = cVar;
        j1.a = cVar;
        this.a = context;
        this.b = r2.b;
        this.c = r2.c;
        this.d = r2.d;
        this.e = r2.h;
        this.A = r2.e;
        this.s = r2.j;
        this.D = true;
        zzcl zzclVar = r2.g;
        if (zzclVar != null && (bundle = zzclVar.zzg) != null) {
            Object obj = bundle.get("measurementEnabled");
            if (obj instanceof Boolean) {
                this.B = (Boolean) obj;
            }
            Object obj2 = zzclVar.zzg.get("measurementDeactivated");
            if (obj2 instanceof Boolean) {
                this.C = (Boolean) obj2;
            }
        }
        zzib.zzd(context);
        C4.e c = C4.h.c();
        this.n = c;
        Long l = r2.i;
        this.G = l != null ? l.longValue() : c.a();
        this.g = new h(this);
        P1 p1 = new P1(this);
        p1.l();
        this.h = p1;
        z1 z1Var = new z1(this);
        z1Var.l();
        this.i = z1Var;
        a5 a5Var = new a5(this);
        a5Var.l();
        this.l = a5Var;
        this.m = new u1(new Q2(r2, this));
        this.q = new E0(this);
        I3 i3 = new I3(this);
        i3.j();
        this.o = i3;
        t3 t3Var = new t3(this);
        t3Var.j();
        this.p = t3Var;
        z4 z4Var = new z4(this);
        z4Var.j();
        this.k = z4Var;
        x3 x3Var = new x3(this);
        x3Var.l();
        this.r = x3Var;
        i2 i2Var = new i2(this);
        i2Var.l();
        this.j = i2Var;
        zzcl zzclVar2 = r2.g;
        boolean z = zzclVar2 == null || zzclVar2.zzb == 0;
        if (context.getApplicationContext() instanceof Application) {
            t3 I = I();
            if (I.a.a.getApplicationContext() instanceof Application) {
                Application applicationContext = I.a.a.getApplicationContext();
                if (I.c == null) {
                    I.c = new s3(I);
                }
                if (z) {
                    applicationContext.unregisterActivityLifecycleCallbacks(I.c);
                    applicationContext.registerActivityLifecycleCallbacks(I.c);
                    w = I.a.d().v();
                    str = "Registered activity lifecycle callback";
                }
            }
            i2Var.z(new k2(this, r2));
        }
        w = d().w();
        str = "Application context is not an Application";
        w.a(str);
        i2Var.z(new k2(this, r2));
    }

    public static l2 H(Context context, zzcl zzclVar, Long l) {
        Bundle bundle;
        if (zzclVar != null && (zzclVar.zze == null || zzclVar.zzf == null)) {
            zzclVar = new zzcl(zzclVar.zza, zzclVar.zzb, zzclVar.zzc, zzclVar.zzd, null, null, zzclVar.zzg, null);
        }
        com.google.android.gms.common.internal.r.m(context);
        com.google.android.gms.common.internal.r.m(context.getApplicationContext());
        if (H == null) {
            synchronized (l2.class) {
                try {
                    if (H == null) {
                        H = new l2(new R2(context, zzclVar, l));
                    }
                } finally {
                }
            }
        } else if (zzclVar != null && (bundle = zzclVar.zzg) != null && bundle.containsKey("dataCollectionDefaultEnabled")) {
            com.google.android.gms.common.internal.r.m(H);
            H.A = Boolean.valueOf(zzclVar.zzg.getBoolean("dataCollectionDefaultEnabled"));
        }
        com.google.android.gms.common.internal.r.m(H);
        return H;
    }

    public static /* bridge */ /* synthetic */ void e(l2 l2Var, R2 r2) {
        l2Var.f().h();
        l2Var.g.w();
        p pVar = new p(l2Var);
        pVar.l();
        l2Var.v = pVar;
        q1 q1Var = new q1(l2Var, r2.f);
        q1Var.j();
        l2Var.w = q1Var;
        s1 s1Var = new s1(l2Var);
        s1Var.j();
        l2Var.t = s1Var;
        i4 i4Var = new i4(l2Var);
        i4Var.j();
        l2Var.u = i4Var;
        l2Var.l.m();
        l2Var.h.m();
        l2Var.w.k();
        x1 u = l2Var.d().u();
        l2Var.g.q();
        u.b("App measurement initialized, version", 79000L);
        l2Var.d().u().a("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
        String s = q1Var.s();
        if (TextUtils.isEmpty(l2Var.b)) {
            if (l2Var.N().U(s)) {
                l2Var.d().u().a("Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop debug.firebase.analytics.app .none.");
            } else {
                l2Var.d().u().a("To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ".concat(String.valueOf(s)));
            }
        }
        l2Var.d().q().a("Debug-level message logging enabled");
        if (l2Var.E != l2Var.F.get()) {
            l2Var.d().r().c("Not all components initialized", Integer.valueOf(l2Var.E), Integer.valueOf(l2Var.F.get()));
        }
        l2Var.x = true;
    }

    public static final void t() {
        throw new IllegalStateException("Unexpected call on client side");
    }

    public static final void u(E2 e2) {
        if (e2 == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    public static final void v(G1 g1) {
        if (g1 == null) {
            throw new IllegalStateException("Component not created");
        }
        if (!g1.m()) {
            throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(g1.getClass())));
        }
    }

    public static final void w(F2 f2) {
        if (f2 == null) {
            throw new IllegalStateException("Component not created");
        }
        if (!f2.n()) {
            throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(f2.getClass())));
        }
    }

    public final p A() {
        w(this.v);
        return this.v;
    }

    public final q1 B() {
        v(this.w);
        return this.w;
    }

    public final s1 C() {
        v(this.t);
        return this.t;
    }

    public final u1 D() {
        return this.m;
    }

    public final z1 E() {
        z1 z1Var = this.i;
        if (z1Var == null || !z1Var.n()) {
            return null;
        }
        return z1Var;
    }

    public final P1 F() {
        u(this.h);
        return this.h;
    }

    public final i2 G() {
        return this.j;
    }

    public final t3 I() {
        v(this.p);
        return this.p;
    }

    public final x3 J() {
        w(this.r);
        return this.r;
    }

    public final I3 K() {
        v(this.o);
        return this.o;
    }

    public final i4 L() {
        v(this.u);
        return this.u;
    }

    public final z4 M() {
        v(this.k);
        return this.k;
    }

    public final a5 N() {
        u(this.l);
        return this.l;
    }

    public final String O() {
        return this.b;
    }

    public final String P() {
        return this.c;
    }

    public final String Q() {
        return this.d;
    }

    public final String R() {
        return this.s;
    }

    public final C4.e a() {
        return this.n;
    }

    public final c b() {
        return this.f;
    }

    public final Context c() {
        return this.a;
    }

    public final z1 d() {
        w(this.i);
        return this.i;
    }

    public final i2 f() {
        w(this.j);
        return this.j;
    }

    public final void g() {
        this.F.incrementAndGet();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final /* synthetic */ void h(java.lang.String r7, int r8, java.lang.Throwable r9, byte[] r10, java.util.Map r11) {
        /*
            Method dump skipped, instructions count: 291
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: M4.l2.h(java.lang.String, int, java.lang.Throwable, byte[], java.util.Map):void");
    }

    public final void i() {
        this.E++;
    }

    public final void j() {
        f().h();
        w(J());
        String s = B().s();
        Pair p = F().p(s);
        if (!this.g.A() || ((Boolean) p.second).booleanValue() || TextUtils.isEmpty((CharSequence) p.first)) {
            d().q().a("ADID unavailable to retrieve Deferred Deep Link. Skipping");
            return;
        }
        x3 J = J();
        J.k();
        ConnectivityManager connectivityManager = (ConnectivityManager) J.a.a.getSystemService("connectivity");
        NetworkInfo networkInfo = null;
        if (connectivityManager != null) {
            try {
                networkInfo = connectivityManager.getActiveNetworkInfo();
            } catch (SecurityException unused) {
            }
        }
        if (networkInfo == null || !networkInfo.isConnected()) {
            d().w().a("Network is not available for Deferred Deep Link request. Skipping");
            return;
        }
        a5 N = N();
        B().a.g.q();
        URL s2 = N.s(79000L, s, (String) p.first, (-1) + F().t.a());
        if (s2 != null) {
            x3 J2 = J();
            j2 j2Var = new j2(this);
            J2.h();
            J2.k();
            com.google.android.gms.common.internal.r.m(s2);
            com.google.android.gms.common.internal.r.m(j2Var);
            J2.a.f().y(new w3(J2, s, s2, null, null, j2Var));
        }
    }

    public final void k(boolean z) {
        this.A = Boolean.valueOf(z);
    }

    public final void l(boolean z) {
        f().h();
        this.D = z;
    }

    public final void m(zzcl zzclVar) {
        K2 k2;
        f().h();
        K2 q = F().q();
        int a = q.a();
        h hVar = this.g;
        l2 l2Var = hVar.a;
        Boolean t = hVar.t("google_analytics_default_allow_ad_storage");
        h hVar2 = this.g;
        l2 l2Var2 = hVar2.a;
        Boolean t2 = hVar2.t("google_analytics_default_allow_analytics_storage");
        if (!(t == null && t2 == null) && F().w(-10)) {
            k2 = new K2(t, t2, -10);
        } else {
            if (!TextUtils.isEmpty(B().t()) && (a == 0 || a == 30 || a == 10 || a == 30 || a == 30 || a == 40)) {
                I().F(new K2(null, null, -10), this.G);
            } else if (TextUtils.isEmpty(B().t()) && zzclVar != null && zzclVar.zzg != null && F().w(30)) {
                k2 = K2.b(zzclVar.zzg, 30);
                if (!k2.l()) {
                }
            }
            k2 = null;
        }
        if (k2 != null) {
            I().F(k2, this.G);
            q = k2;
        }
        I().J(q);
        if (F().e.a() == 0) {
            d().v().b("Persisting first open", Long.valueOf(this.G));
            F().e.b(this.G);
        }
        I().l.c();
        if (r()) {
            if (!TextUtils.isEmpty(B().t()) || !TextUtils.isEmpty(B().r())) {
                a5 N = N();
                String t3 = B().t();
                P1 F = F();
                F.h();
                String string = F.o().getString("gmp_app_id", (String) null);
                String r = B().r();
                P1 F2 = F();
                F2.h();
                if (N.d0(t3, string, r, F2.o().getString("admob_app_id", (String) null))) {
                    d().u().a("Rechecking which service to use due to a GMP App Id change");
                    P1 F3 = F();
                    F3.h();
                    Boolean r2 = F3.r();
                    SharedPreferences.Editor edit = F3.o().edit();
                    edit.clear();
                    edit.apply();
                    if (r2 != null) {
                        F3.s(r2);
                    }
                    C().q();
                    this.u.Q();
                    this.u.P();
                    F().e.b(this.G);
                    F().g.b(null);
                }
                P1 F4 = F();
                String t4 = B().t();
                F4.h();
                SharedPreferences.Editor edit2 = F4.o().edit();
                edit2.putString("gmp_app_id", t4);
                edit2.apply();
                P1 F5 = F();
                String r3 = B().r();
                F5.h();
                SharedPreferences.Editor edit3 = F5.o().edit();
                edit3.putString("admob_app_id", r3);
                edit3.apply();
            }
            if (!F().q().j(J2.ANALYTICS_STORAGE)) {
                F().g.b(null);
            }
            I().C(F().g.a());
            zzos.zzc();
            if (this.g.B(null, m1.g0)) {
                try {
                    N().a.a.getClassLoader().loadClass("com.google.firebase.remoteconfig.FirebaseRemoteConfig");
                } catch (ClassNotFoundException unused) {
                    if (!TextUtils.isEmpty(F().u.a())) {
                        d().w().a("Remote config removed with active feature rollouts");
                        F().u.b(null);
                    }
                }
            }
            if (!TextUtils.isEmpty(B().t()) || !TextUtils.isEmpty(B().r())) {
                boolean o = o();
                if (!F().u() && !this.g.E()) {
                    F().t(!o);
                }
                if (o) {
                    I().f0();
                }
                M().e.a();
                L().S(new AtomicReference());
                L().v(F().x.a());
            }
        } else if (o()) {
            if (!N().T("android.permission.INTERNET")) {
                d().r().a("App is missing INTERNET permission");
            }
            if (!N().T("android.permission.ACCESS_NETWORK_STATE")) {
                d().r().a("App is missing ACCESS_NETWORK_STATE permission");
            }
            if (!E4.e.a(this.a).f() && !this.g.G()) {
                if (!a5.a0(this.a)) {
                    d().r().a("AppMeasurementReceiver not registered/enabled");
                }
                if (!a5.b0(this.a, false)) {
                    d().r().a("AppMeasurementService not registered/enabled");
                }
            }
            d().r().a("Uploading is not possible. App measurement disabled");
        }
        F().n.a(true);
    }

    public final boolean n() {
        return this.A != null && this.A.booleanValue();
    }

    public final boolean o() {
        return x() == 0;
    }

    public final boolean p() {
        f().h();
        return this.D;
    }

    public final boolean q() {
        return TextUtils.isEmpty(this.b);
    }

    public final boolean r() {
        if (!this.x) {
            throw new IllegalStateException("AppMeasurement is not initialized");
        }
        f().h();
        Boolean bool = this.y;
        if (bool == null || this.z == 0 || (!bool.booleanValue() && Math.abs(this.n.b() - this.z) > 1000)) {
            this.z = this.n.b();
            boolean z = true;
            Boolean valueOf = Boolean.valueOf(N().T("android.permission.INTERNET") && N().T("android.permission.ACCESS_NETWORK_STATE") && (E4.e.a(this.a).f() || this.g.G() || (a5.a0(this.a) && a5.b0(this.a, false))));
            this.y = valueOf;
            if (valueOf.booleanValue()) {
                if (!N().M(B().t(), B().r()) && TextUtils.isEmpty(B().r())) {
                    z = false;
                }
                this.y = Boolean.valueOf(z);
            }
        }
        return this.y.booleanValue();
    }

    public final boolean s() {
        return this.e;
    }

    public final int x() {
        f().h();
        if (this.g.E()) {
            return 1;
        }
        Boolean bool = this.C;
        if (bool != null && bool.booleanValue()) {
            return 2;
        }
        f().h();
        if (!this.D) {
            return 8;
        }
        Boolean r = F().r();
        if (r != null) {
            return r.booleanValue() ? 0 : 3;
        }
        h hVar = this.g;
        c cVar = hVar.a.f;
        Boolean t = hVar.t("firebase_analytics_collection_enabled");
        if (t != null) {
            return t.booleanValue() ? 0 : 4;
        }
        Boolean bool2 = this.B;
        return bool2 != null ? bool2.booleanValue() ? 0 : 5 : (this.A == null || this.A.booleanValue()) ? 0 : 7;
    }

    public final E0 y() {
        E0 e0 = this.q;
        if (e0 != null) {
            return e0;
        }
        throw new IllegalStateException("Component not created");
    }

    public final h z() {
        return this.g;
    }
}
