package M4;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.zzos;
import com.google.android.gms.internal.measurement.zzph;
import com.google.android.gms.internal.measurement.zzqu;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class t3 extends G1 {
    public s3 c;
    public O2 d;
    public final Set e;
    public boolean f;
    public final AtomicReference g;
    public final Object h;
    public K2 i;
    public final AtomicLong j;
    public long k;
    public final h5 l;
    public boolean m;
    public final Z4 n;

    public t3(l2 l2Var) {
        super(l2Var);
        this.e = new CopyOnWriteArraySet();
        this.h = new Object();
        this.m = true;
        this.n = new h3(this);
        this.g = new AtomicReference();
        this.i = K2.c;
        this.k = -1L;
        this.j = new AtomicLong(0L);
        this.l = new h5(l2Var);
    }

    public static /* bridge */ /* synthetic */ void b0(t3 t3Var, K2 k2, K2 k22) {
        boolean z;
        J2[] j2Arr = {J2.ANALYTICS_STORAGE, J2.AD_STORAGE};
        int i = 0;
        while (true) {
            if (i >= 2) {
                z = false;
                break;
            }
            J2 j2 = j2Arr[i];
            if (!k22.j(j2) && k2.j(j2)) {
                z = true;
                break;
            }
            i++;
        }
        boolean n = k2.n(k22, J2.ANALYTICS_STORAGE, J2.AD_STORAGE);
        if (z || n) {
            t3Var.a.B().v();
        }
    }

    public static /* synthetic */ void c0(t3 t3Var, K2 k2, long j, boolean z, boolean z2) {
        t3Var.h();
        t3Var.i();
        K2 q = t3Var.a.F().q();
        if (j <= t3Var.k && K2.k(q.a(), k2.a())) {
            t3Var.a.d().u().b("Dropped out-of-date consent setting, proposed settings", k2);
            return;
        }
        P1 F = t3Var.a.F();
        l2 l2Var = F.a;
        F.h();
        int a = k2.a();
        if (!F.w(a)) {
            t3Var.a.d().u().b("Lower precedence consent source ignored, proposed source", Integer.valueOf(k2.a()));
            return;
        }
        SharedPreferences.Editor edit = F.o().edit();
        edit.putString("consent_settings", k2.i());
        edit.putInt("consent_source", a);
        edit.apply();
        t3Var.k = j;
        t3Var.a.L().t(z);
        if (z2) {
            t3Var.a.L().S(new AtomicReference());
        }
    }

    public static /* bridge */ /* synthetic */ void d0(t3 t3Var, Boolean bool, boolean z) {
        t3Var.O(bool, true);
    }

    public static /* bridge */ /* synthetic */ void e0(t3 t3Var) {
        t3Var.P();
    }

    public final void A(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        Bundle bundle2 = new Bundle(bundle);
        for (String str4 : bundle2.keySet()) {
            Object obj = bundle2.get(str4);
            if (obj instanceof Bundle) {
                bundle2.putBundle(str4, new Bundle((Bundle) obj));
            } else {
                int i = 0;
                if (obj instanceof Parcelable[]) {
                    Bundle[] bundleArr = (Parcelable[]) obj;
                    while (i < bundleArr.length) {
                        Bundle bundle3 = bundleArr[i];
                        if (bundle3 instanceof Bundle) {
                            bundleArr[i] = new Bundle(bundle3);
                        }
                        i++;
                    }
                } else if (obj instanceof List) {
                    List list = (List) obj;
                    while (i < list.size()) {
                        Object obj2 = list.get(i);
                        if (obj2 instanceof Bundle) {
                            list.set(i, new Bundle((Bundle) obj2));
                        }
                        i++;
                    }
                }
            }
        }
        this.a.f().z(new Y2(this, str, str2, j, bundle2, z, z2, z3, str3));
    }

    public final void B(String str, String str2, long j, Object obj) {
        this.a.f().z(new Z2(this, str, str2, obj, j));
    }

    public final void C(String str) {
        this.g.set(str);
    }

    public final void D(Bundle bundle) {
        E(bundle, this.a.a().a());
    }

    public final void E(Bundle bundle, long j) {
        com.google.android.gms.common.internal.r.m(bundle);
        Bundle bundle2 = new Bundle(bundle);
        if (!TextUtils.isEmpty(bundle2.getString("app_id"))) {
            this.a.d().w().a("Package name should be null when calling setConditionalUserProperty");
        }
        bundle2.remove("app_id");
        com.google.android.gms.common.internal.r.m(bundle2);
        H2.a(bundle2, "app_id", String.class, null);
        H2.a(bundle2, "origin", String.class, null);
        H2.a(bundle2, "name", String.class, null);
        H2.a(bundle2, "value", Object.class, null);
        H2.a(bundle2, "trigger_event_name", String.class, null);
        H2.a(bundle2, "trigger_timeout", Long.class, 0L);
        H2.a(bundle2, "timed_out_event_name", String.class, null);
        H2.a(bundle2, "timed_out_event_params", Bundle.class, null);
        H2.a(bundle2, "triggered_event_name", String.class, null);
        H2.a(bundle2, "triggered_event_params", Bundle.class, null);
        H2.a(bundle2, "time_to_live", Long.class, 0L);
        H2.a(bundle2, "expired_event_name", String.class, null);
        H2.a(bundle2, "expired_event_params", Bundle.class, null);
        com.google.android.gms.common.internal.r.g(bundle2.getString("name"));
        com.google.android.gms.common.internal.r.g(bundle2.getString("origin"));
        com.google.android.gms.common.internal.r.m(bundle2.get("value"));
        bundle2.putLong("creation_timestamp", j);
        String string = bundle2.getString("name");
        Object obj = bundle2.get("value");
        if (this.a.N().p0(string) != 0) {
            this.a.d().r().b("Invalid conditional user property name", this.a.D().f(string));
            return;
        }
        if (this.a.N().l0(string, obj) != 0) {
            this.a.d().r().c("Invalid conditional user property value", this.a.D().f(string), obj);
            return;
        }
        Object p = this.a.N().p(string, obj);
        if (p == null) {
            this.a.d().r().c("Unable to normalize conditional user property value", this.a.D().f(string), obj);
            return;
        }
        H2.b(bundle2, p);
        long j2 = bundle2.getLong("trigger_timeout");
        if (!TextUtils.isEmpty(bundle2.getString("trigger_event_name"))) {
            this.a.z();
            if (j2 > 15552000000L || j2 < 1) {
                this.a.d().r().c("Invalid conditional user property timeout", this.a.D().f(string), Long.valueOf(j2));
                return;
            }
        }
        long j3 = bundle2.getLong("time_to_live");
        this.a.z();
        if (j3 > 15552000000L || j3 < 1) {
            this.a.d().r().c("Invalid conditional user property time to live", this.a.D().f(string), Long.valueOf(j3));
        } else {
            this.a.f().z(new b3(this, bundle2));
        }
    }

    public final void F(K2 k2, long j) {
        K2 k22;
        boolean z;
        K2 k23;
        boolean z2;
        boolean z3;
        i();
        int a = k2.a();
        if (a != -10 && k2.f() == null && k2.g() == null) {
            this.a.d().x().a("Discarding empty consent settings");
            return;
        }
        synchronized (this.h) {
            try {
                k22 = this.i;
                z = false;
                if (K2.k(a, k22.a())) {
                    z3 = k2.m(this.i);
                    J2 j2 = J2.ANALYTICS_STORAGE;
                    if (k2.j(j2) && !this.i.j(j2)) {
                        z = true;
                    }
                    K2 e = k2.e(this.i);
                    this.i = e;
                    k23 = e;
                    z2 = z;
                    z = true;
                } else {
                    k23 = k2;
                    z2 = false;
                    z3 = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (!z) {
            this.a.d().u().b("Ignoring lower-priority consent settings, proposed settings", k23);
            return;
        }
        long andIncrement = this.j.getAndIncrement();
        if (z3) {
            this.g.set((Object) null);
            this.a.f().A(new o3(this, k23, j, andIncrement, z2, k22));
            return;
        }
        p3 p3Var = new p3(this, k23, andIncrement, z2, k22);
        if (a == 30 || a == -10) {
            this.a.f().A(p3Var);
        } else {
            this.a.f().z(p3Var);
        }
    }

    public final void G(Bundle bundle, int i, long j) {
        i();
        String h = K2.h(bundle);
        if (h != null) {
            this.a.d().x().b("Ignoring invalid consent setting", h);
            this.a.d().x().a("Valid consent values are 'granted', 'denied'");
        }
        F(K2.b(bundle, i), j);
    }

    public final void H(O2 o2) {
        O2 o22;
        h();
        i();
        if (o2 != null && o2 != (o22 = this.d)) {
            com.google.android.gms.common.internal.r.q(o22 == null, "EventInterceptor already set.");
        }
        this.d = o2;
    }

    public final void I(Boolean bool) {
        i();
        this.a.f().z(new n3(this, bool));
    }

    public final void J(K2 k2) {
        h();
        boolean z = (k2.j(J2.ANALYTICS_STORAGE) && k2.j(J2.AD_STORAGE)) || this.a.L().A();
        if (z != this.a.p()) {
            this.a.l(z);
            P1 F = this.a.F();
            l2 l2Var = F.a;
            F.h();
            Boolean valueOf = F.o().contains("measurement_enabled_from_api") ? Boolean.valueOf(F.o().getBoolean("measurement_enabled_from_api", true)) : null;
            if (!z || valueOf == null || valueOf.booleanValue()) {
                O(Boolean.valueOf(z), false);
            }
        }
    }

    public final void K(String str, String str2, Object obj, boolean z) {
        L("auto", "_ldl", obj, true, this.a.a().a());
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void L(java.lang.String r17, java.lang.String r18, java.lang.Object r19, boolean r20, long r21) {
        /*
            r16 = this;
            r6 = r16
            r2 = r18
            r0 = r19
            r1 = 0
            r3 = 24
            M4.l2 r4 = r6.a
            M4.a5 r4 = r4.N()
            if (r20 == 0) goto L17
            int r4 = r4.p0(r2)
            r12 = r4
            goto L3d
        L17:
            java.lang.String r5 = "user property"
            boolean r7 = r4.S(r5, r2)
            r8 = 6
            if (r7 != 0) goto L22
        L20:
            r12 = 6
            goto L3d
        L22:
            java.lang.String[] r7 = M4.N2.a
            r9 = 0
            boolean r7 = r4.P(r5, r7, r9, r2)
            if (r7 != 0) goto L30
            r4 = 15
            r12 = 15
            goto L3d
        L30:
            M4.l2 r7 = r4.a
            r7.z()
            boolean r4 = r4.N(r5, r3, r2)
            if (r4 != 0) goto L3c
            goto L20
        L3c:
            r12 = 0
        L3d:
            r4 = 1
            if (r12 == 0) goto L67
            M4.l2 r0 = r6.a
            M4.a5 r0 = r0.N()
            M4.l2 r5 = r6.a
            r5.z()
            java.lang.String r14 = r0.r(r2, r3, r4)
            if (r2 == 0) goto L57
            int r1 = r18.length()
            r15 = r1
            goto L58
        L57:
            r15 = 0
        L58:
            M4.l2 r0 = r6.a
            M4.a5 r9 = r0.N()
            M4.Z4 r10 = r6.n
            r11 = 0
            java.lang.String r13 = "_ev"
            r9.C(r10, r11, r12, r13, r14, r15)
            return
        L67:
            if (r17 != 0) goto L6c
            java.lang.String r5 = "app"
            goto L6e
        L6c:
            r5 = r17
        L6e:
            if (r0 == 0) goto Lc6
            M4.l2 r7 = r6.a
            M4.a5 r7 = r7.N()
            int r11 = r7.l0(r2, r0)
            if (r11 == 0) goto Lae
            M4.l2 r5 = r6.a
            M4.a5 r5 = r5.N()
            M4.l2 r7 = r6.a
            r7.z()
            java.lang.String r13 = r5.r(r2, r3, r4)
            boolean r2 = r0 instanceof java.lang.String
            if (r2 != 0) goto L96
            boolean r2 = r0 instanceof java.lang.CharSequence
            if (r2 == 0) goto L94
            goto L96
        L94:
            r14 = 0
            goto L9f
        L96:
            java.lang.String r0 = r19.toString()
            int r1 = r0.length()
            r14 = r1
        L9f:
            M4.l2 r0 = r6.a
            M4.a5 r8 = r0.N()
            M4.Z4 r9 = r6.n
            r10 = 0
            java.lang.String r12 = "_ev"
            r8.C(r9, r10, r11, r12, r13, r14)
            return
        Lae:
            M4.l2 r1 = r6.a
            M4.a5 r1 = r1.N()
            java.lang.Object r7 = r1.p(r2, r0)
            if (r7 == 0) goto Lc5
            r0 = r16
            r1 = r5
            r2 = r18
            r3 = r21
            r5 = r7
            r0.B(r1, r2, r3, r5)
        Lc5:
            return
        Lc6:
            r7 = 0
            r0 = r16
            r1 = r5
            r2 = r18
            r3 = r21
            r5 = r7
            r0.B(r1, r2, r3, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: M4.t3.L(java.lang.String, java.lang.String, java.lang.Object, boolean, long):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void M(java.lang.String r9, java.lang.String r10, java.lang.Object r11, long r12) {
        /*
            r8 = this;
            com.google.android.gms.common.internal.r.g(r9)
            com.google.android.gms.common.internal.r.g(r10)
            r8.h()
            r8.i()
            java.lang.String r0 = "allow_personalized_ads"
            boolean r0 = r0.equals(r10)
            if (r0 == 0) goto L62
            boolean r0 = r11 instanceof java.lang.String
            java.lang.String r1 = "_npa"
            if (r0 == 0) goto L50
            r0 = r11
            java.lang.String r0 = (java.lang.String) r0
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L50
            java.util.Locale r10 = java.util.Locale.ENGLISH
            java.lang.String r10 = r0.toLowerCase(r10)
            r11 = 1
            java.lang.String r0 = "false"
            boolean r10 = r0.equals(r10)
            r2 = 1
            if (r11 == r10) goto L37
            r10 = 0
            goto L38
        L37:
            r10 = r2
        L38:
            java.lang.Long r4 = java.lang.Long.valueOf(r10)
            M4.l2 r5 = r8.a
            M4.P1 r5 = r5.F()
            M4.O1 r5 = r5.m
            int r6 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r6 != 0) goto L4a
            java.lang.String r0 = "true"
        L4a:
            r5.b(r0)
            r3 = r1
            r6 = r4
            goto L64
        L50:
            if (r11 != 0) goto L62
            M4.l2 r10 = r8.a
            M4.P1 r10 = r10.F()
            M4.O1 r10 = r10.m
            java.lang.String r0 = "unset"
            r10.b(r0)
            r6 = r11
            r3 = r1
            goto L64
        L62:
            r3 = r10
            r6 = r11
        L64:
            M4.l2 r10 = r8.a
            boolean r10 = r10.o()
            if (r10 != 0) goto L7c
            M4.l2 r9 = r8.a
            M4.z1 r9 = r9.d()
            M4.x1 r9 = r9.v()
            java.lang.String r10 = "User property not set since app measurement is disabled"
            r9.a(r10)
            return
        L7c:
            M4.l2 r10 = r8.a
            boolean r10 = r10.r()
            if (r10 != 0) goto L85
            return
        L85:
            M4.V4 r10 = new M4.V4
            r2 = r10
            r4 = r12
            r7 = r9
            r2.<init>(r3, r4, r6, r7)
            M4.l2 r9 = r8.a
            M4.i4 r9 = r9.L()
            r9.y(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: M4.t3.M(java.lang.String, java.lang.String, java.lang.Object, long):void");
    }

    public final void N(P2 p2) {
        i();
        com.google.android.gms.common.internal.r.m(p2);
        if (this.e.remove(p2)) {
            return;
        }
        this.a.d().w().a("OnEventListener had not been registered");
    }

    public final void O(Boolean bool, boolean z) {
        h();
        i();
        this.a.d().q().b("Setting app measurement enabled (FE)", bool);
        this.a.F().s(bool);
        if (z) {
            P1 F = this.a.F();
            l2 l2Var = F.a;
            F.h();
            SharedPreferences.Editor edit = F.o().edit();
            if (bool != null) {
                edit.putBoolean("measurement_enabled_from_api", bool.booleanValue());
            } else {
                edit.remove("measurement_enabled_from_api");
            }
            edit.apply();
        }
        if (this.a.p() || !(bool == null || bool.booleanValue())) {
            P();
        }
    }

    public final void P() {
        h();
        String a = this.a.F().m.a();
        if (a != null) {
            if ("unset".equals(a)) {
                M("app", "_npa", null, this.a.a().a());
            } else {
                M("app", "_npa", Long.valueOf(true != "true".equals(a) ? 0L : 1L), this.a.a().a());
            }
        }
        if (!this.a.o() || !this.m) {
            this.a.d().q().a("Updating Scion state (FE)");
            this.a.L().w();
            return;
        }
        this.a.d().q().a("Recording app launch after enabling measurement for the first time (FE)");
        f0();
        zzph.zzc();
        if (this.a.z().B(null, m1.h0)) {
            this.a.M().e.a();
        }
        this.a.f().z(new W2(this));
    }

    public final int Q(String str) {
        com.google.android.gms.common.internal.r.g(str);
        this.a.z();
        return 25;
    }

    public final Boolean R() {
        AtomicReference atomicReference = new AtomicReference();
        return (Boolean) this.a.f().r(atomicReference, 15000L, "boolean test flag value", new e3(this, atomicReference));
    }

    public final Double S() {
        AtomicReference atomicReference = new AtomicReference();
        return (Double) this.a.f().r(atomicReference, 15000L, "double test flag value", new m3(this, atomicReference));
    }

    public final Integer T() {
        AtomicReference atomicReference = new AtomicReference();
        return (Integer) this.a.f().r(atomicReference, 15000L, "int test flag value", new l3(this, atomicReference));
    }

    public final Long U() {
        AtomicReference atomicReference = new AtomicReference();
        return (Long) this.a.f().r(atomicReference, 15000L, "long test flag value", new k3(this, atomicReference));
    }

    public final String V() {
        return (String) this.g.get();
    }

    public final String W() {
        A3 r = this.a.K().r();
        if (r != null) {
            return r.b;
        }
        return null;
    }

    public final String X() {
        A3 r = this.a.K().r();
        if (r != null) {
            return r.a;
        }
        return null;
    }

    public final String Y() {
        AtomicReference atomicReference = new AtomicReference();
        return (String) this.a.f().r(atomicReference, 15000L, "String test flag value", new j3(this, atomicReference));
    }

    public final ArrayList Z(String str, String str2) {
        if (this.a.f().C()) {
            this.a.d().r().a("Cannot get conditional user properties from analytics worker thread");
            return new ArrayList(0);
        }
        this.a.b();
        if (c.a()) {
            this.a.d().r().a("Cannot get conditional user properties from main thread");
            return new ArrayList(0);
        }
        AtomicReference atomicReference = new AtomicReference();
        this.a.f().r(atomicReference, 5000L, "get conditional user properties", new d3(this, atomicReference, null, str, str2));
        List list = (List) atomicReference.get();
        if (list != null) {
            return a5.v(list);
        }
        this.a.d().r().b("Timed out waiting for get conditional user properties", null);
        return new ArrayList();
    }

    public final Map a0(String str, String str2, boolean z) {
        x1 r;
        String str3;
        if (this.a.f().C()) {
            r = this.a.d().r();
            str3 = "Cannot get user properties from analytics worker thread";
        } else {
            this.a.b();
            if (!c.a()) {
                AtomicReference atomicReference = new AtomicReference();
                this.a.f().r(atomicReference, 5000L, "get user properties", new f3(this, atomicReference, null, str, str2, z));
                List<V4> list = (List) atomicReference.get();
                if (list == null) {
                    this.a.d().r().b("Timed out waiting for handle get user properties, includeInternal", Boolean.valueOf(z));
                    return Collections.emptyMap();
                }
                s.a aVar = new s.a(list.size());
                for (V4 v4 : list) {
                    Object H = v4.H();
                    if (H != null) {
                        aVar.put(v4.g, H);
                    }
                }
                return aVar;
            }
            r = this.a.d().r();
            str3 = "Cannot get user properties from main thread";
        }
        r.a(str3);
        return Collections.emptyMap();
    }

    public final void f0() {
        h();
        i();
        if (this.a.r()) {
            if (this.a.z().B(null, m1.b0)) {
                h z = this.a.z();
                z.a.b();
                Boolean t = z.t("google_analytics_deferred_deep_link_enabled");
                if (t != null && t.booleanValue()) {
                    this.a.d().q().a("Deferred Deep Link feature enabled.");
                    this.a.f().z(new V2(this));
                }
            }
            this.a.L().O();
            this.m = false;
            P1 F = this.a.F();
            F.h();
            String string = F.o().getString("previous_os_version", (String) null);
            F.a.A().k();
            String str = Build.VERSION.RELEASE;
            if (!TextUtils.isEmpty(str) && !str.equals(string)) {
                SharedPreferences.Editor edit = F.o().edit();
                edit.putString("previous_os_version", str);
                edit.apply();
            }
            if (TextUtils.isEmpty(string)) {
                return;
            }
            this.a.A().k();
            if (string.equals(str)) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("_po", string);
            u("auto", "_ou", bundle);
        }
    }

    public final boolean n() {
        return false;
    }

    public final void o(String str, String str2, Bundle bundle) {
        long a = this.a.a().a();
        com.google.android.gms.common.internal.r.g(str);
        Bundle bundle2 = new Bundle();
        bundle2.putString("name", str);
        bundle2.putLong("creation_timestamp", a);
        if (str2 != null) {
            bundle2.putString("expired_event_name", str2);
            bundle2.putBundle("expired_event_params", bundle);
        }
        this.a.f().z(new c3(this, bundle2));
    }

    public final void p() {
        if (!(this.a.c().getApplicationContext() instanceof Application) || this.c == null) {
            return;
        }
        this.a.c().getApplicationContext().unregisterActivityLifecycleCallbacks(this.c);
    }

    public final /* synthetic */ void q(Bundle bundle) {
        if (bundle == null) {
            this.a.F().x.b(new Bundle());
            return;
        }
        Bundle a = this.a.F().x.a();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj != null && !(obj instanceof String) && !(obj instanceof Long) && !(obj instanceof Double)) {
                if (this.a.N().V(obj)) {
                    this.a.N().C(this.n, null, 27, null, null, 0);
                }
                this.a.d().x().c("Invalid default event parameter type. Name, value", str, obj);
            } else if (a5.Y(str)) {
                this.a.d().x().b("Invalid default event parameter name. Name", str);
            } else if (obj == null) {
                a.remove(str);
            } else {
                a5 N = this.a.N();
                this.a.z();
                if (N.Q("param", str, 100, obj)) {
                    this.a.N().D(a, str, obj);
                }
            }
        }
        this.a.N();
        int m = this.a.z().m();
        if (a.size() > m) {
            int i = 0;
            for (String str2 : new TreeSet(a.keySet())) {
                i++;
                if (i > m) {
                    a.remove(str2);
                }
            }
            this.a.N().C(this.n, null, 26, null, null, 0);
            this.a.d().x().a("Too many default event parameters set. Discarding beyond event parameter limit");
        }
        this.a.F().x.b(a);
        this.a.L().v(a);
    }

    public final void r(String str, String str2, Bundle bundle) {
        s(str, str2, bundle, true, true, this.a.a().a());
    }

    public final void s(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) {
        Bundle bundle2 = bundle == null ? new Bundle() : bundle;
        if (str2 == "screen_view" || (str2 != null && str2.equals("screen_view"))) {
            this.a.K().E(bundle2, j);
        } else {
            A(str == null ? "app" : str, str2, j, bundle2, z2, !z2 || this.d == null || a5.Y(str2), z, null);
        }
    }

    public final void t(String str, String str2, Bundle bundle, String str3) {
        l2.t();
        A("auto", str2, this.a.a().a(), bundle, false, true, true, str3);
    }

    public final void u(String str, String str2, Bundle bundle) {
        h();
        v(str, str2, this.a.a().a(), bundle);
    }

    public final void v(String str, String str2, long j, Bundle bundle) {
        h();
        w(str, str2, j, bundle, true, this.d == null || a5.Y(str2), true, null);
    }

    public final void w(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        boolean z4;
        String str4;
        long j2;
        Bundle[] bundleArr;
        Object[] objArr;
        com.google.android.gms.common.internal.r.g(str);
        com.google.android.gms.common.internal.r.m(bundle);
        h();
        i();
        if (!this.a.o()) {
            this.a.d().q().a("Event not sent since app measurement is disabled");
            return;
        }
        List u = this.a.B().u();
        if (u != null && !u.contains(str2)) {
            this.a.d().q().c("Dropping non-safelisted event. event name, origin", str2, str);
            return;
        }
        if (!this.f) {
            this.f = true;
            try {
                try {
                    (!this.a.s() ? Class.forName("com.google.android.gms.tagmanager.TagManagerService", true, this.a.c().getClassLoader()) : Class.forName("com.google.android.gms.tagmanager.TagManagerService")).getDeclaredMethod("initialize", new Class[]{Context.class}).invoke((Object) null, new Object[]{this.a.c()});
                } catch (Exception e) {
                    this.a.d().w().b("Failed to invoke Tag Manager's initialize() method", e);
                }
            } catch (ClassNotFoundException unused) {
                this.a.d().u().a("Tag Manager is not found and thus will not be used");
            }
        }
        if ("_cmp".equals(str2) && bundle.containsKey("gclid")) {
            this.a.b();
            M("auto", "_lgclid", bundle.getString("gclid"), this.a.a().a());
        }
        this.a.b();
        if (z && a5.c0(str2)) {
            this.a.N().z(bundle, this.a.F().x.a());
        }
        if (!z3) {
            this.a.b();
            if (!"_iap".equals(str2)) {
                a5 N = this.a.N();
                int i = 2;
                if (N.S("event", str2)) {
                    if (N.P("event", L2.a, L2.b, str2)) {
                        N.a.z();
                        if (N.N("event", 40, str2)) {
                            i = 0;
                        }
                    } else {
                        i = 13;
                    }
                }
                if (i != 0) {
                    this.a.d().s().b("Invalid public event name. Event will not be logged (FE)", this.a.D().d(str2));
                    a5 N2 = this.a.N();
                    this.a.z();
                    this.a.N().C(this.n, null, i, "_ev", N2.r(str2, 40, true), str2 != null ? str2.length() : 0);
                    return;
                }
            }
        }
        this.a.b();
        A3 s = this.a.K().s(false);
        if (s != null && !bundle.containsKey("_sc")) {
            s.d = true;
        }
        a5.y(s, bundle, z && !z3);
        boolean equals = "am".equals(str);
        boolean Y = a5.Y(str2);
        if (!z || this.d == null || Y) {
            z4 = equals;
        } else {
            if (!equals) {
                this.a.d().q().c("Passing event to registered event handler (FE)", this.a.D().d(str2), this.a.D().b(bundle));
                com.google.android.gms.common.internal.r.m(this.d);
                this.d.a(str, str2, bundle, j);
                return;
            }
            z4 = true;
        }
        if (this.a.r()) {
            int m0 = this.a.N().m0(str2);
            if (m0 != 0) {
                this.a.d().s().b("Invalid event name. Event will not be logged (FE)", this.a.D().d(str2));
                a5 N3 = this.a.N();
                this.a.z();
                this.a.N().C(this.n, str3, m0, "_ev", N3.r(str2, 40, true), str2 != null ? str2.length() : 0);
                return;
            }
            Bundle x0 = this.a.N().x0(str3, str2, bundle, C4.f.b("_o", "_sn", "_sc", "_si"), z3);
            com.google.android.gms.common.internal.r.m(x0);
            this.a.b();
            if (this.a.K().s(false) != null && "_ae".equals(str2)) {
                x4 x4Var = this.a.M().f;
                long b = x4Var.d.a.a().b();
                long j3 = b - x4Var.b;
                x4Var.b = b;
                if (j3 > 0) {
                    this.a.N().w(x0, j3);
                }
            }
            zzos.zzc();
            if (this.a.z().B(null, m1.g0)) {
                if (!"auto".equals(str) && "_ssr".equals(str2)) {
                    a5 N4 = this.a.N();
                    String string = x0.getString("_ffr");
                    if (C4.o.b(string)) {
                        string = null;
                    } else if (string != null) {
                        string = string.trim();
                    }
                    if (Y4.a(string, N4.a.F().u.a())) {
                        N4.a.d().q().a("Not logging duplicate session_start_with_rollout event");
                        return;
                    }
                    N4.a.F().u.b(string);
                } else if ("_ae".equals(str2)) {
                    String a = this.a.N().a.F().u.a();
                    if (!TextUtils.isEmpty(a)) {
                        x0.putString("_ffr", a);
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(x0);
            boolean t = this.a.z().B(null, m1.I0) ? this.a.M().t() : this.a.F().r.b();
            if (this.a.F().o.a() > 0 && this.a.F().v(j) && t) {
                this.a.d().v().a("Current session is expired, remove the session number, ID, and engagement time");
                j2 = 0;
                str4 = "_ae";
                M("auto", "_sid", null, this.a.a().a());
                M("auto", "_sno", null, this.a.a().a());
                M("auto", "_se", null, this.a.a().a());
                this.a.F().p.b(0L);
            } else {
                str4 = "_ae";
                j2 = 0;
            }
            if (x0.getLong("extend_session", j2) == 1) {
                this.a.d().v().a("EXTEND_SESSION param attached: initiate a new session or extend the current active session");
                this.a.M().e.b(j, true);
            }
            ArrayList arrayList2 = new ArrayList(x0.keySet());
            Collections.sort(arrayList2);
            int size = arrayList2.size();
            for (int i2 = 0; i2 < size; i2++) {
                String str5 = (String) arrayList2.get(i2);
                if (str5 != null) {
                    this.a.N();
                    Object obj = x0.get(str5);
                    if (obj instanceof Bundle) {
                        bundleArr = new Bundle[]{(Bundle) obj};
                    } else {
                        if (obj instanceof Parcelable[]) {
                            Parcelable[] parcelableArr = (Parcelable[]) obj;
                            objArr = Arrays.copyOf(parcelableArr, parcelableArr.length, Bundle[].class);
                        } else if (obj instanceof ArrayList) {
                            ArrayList arrayList3 = (ArrayList) obj;
                            objArr = arrayList3.toArray(new Bundle[arrayList3.size()]);
                        } else {
                            bundleArr = null;
                        }
                        bundleArr = (Bundle[]) objArr;
                    }
                    if (bundleArr != null) {
                        x0.putParcelableArray(str5, bundleArr);
                    }
                }
            }
            int i3 = 0;
            while (i3 < arrayList.size()) {
                Bundle bundle2 = (Bundle) arrayList.get(i3);
                String str6 = i3 != 0 ? "_ep" : str2;
                bundle2.putString("_o", str);
                if (z2) {
                    bundle2 = this.a.N().w0(bundle2);
                }
                Bundle bundle3 = bundle2;
                this.a.L().o(new v(str6, new t(bundle3), str, j), str3);
                if (!z4) {
                    Iterator it = this.e.iterator();
                    while (it.hasNext()) {
                        ((P2) it.next()).a(str, str2, new Bundle(bundle3), j);
                    }
                }
                i3++;
            }
            this.a.b();
            if (this.a.K().s(false) == null || !str4.equals(str2)) {
                return;
            }
            this.a.M().f.d(true, true, this.a.a().b());
        }
    }

    public final void x(P2 p2) {
        i();
        com.google.android.gms.common.internal.r.m(p2);
        if (this.e.add(p2)) {
            return;
        }
        this.a.d().w().a("OnEventListener already registered");
    }

    public final void y(long j) {
        this.g.set((Object) null);
        this.a.f().z(new a3(this, j));
    }

    public final void z(long j, boolean z) {
        h();
        i();
        this.a.d().q().a("Resetting analytics data (FE)");
        z4 M = this.a.M();
        M.h();
        M.f.a();
        zzqu.zzc();
        if (this.a.z().B(null, m1.p0)) {
            this.a.B().v();
        }
        boolean o = this.a.o();
        P1 F = this.a.F();
        F.e.b(j);
        if (!TextUtils.isEmpty(F.a.F().u.a())) {
            F.u.b(null);
        }
        zzph.zzc();
        h z2 = F.a.z();
        l1 l1Var = m1.h0;
        if (z2.B(null, l1Var)) {
            F.o.b(0L);
        }
        F.p.b(0L);
        if (!F.a.z().E()) {
            F.t(!o);
        }
        F.v.b(null);
        F.w.b(0L);
        F.x.b(null);
        if (z) {
            this.a.L().q();
        }
        zzph.zzc();
        if (this.a.z().B(null, l1Var)) {
            this.a.M().e.a();
        }
        this.m = !o;
    }
}
