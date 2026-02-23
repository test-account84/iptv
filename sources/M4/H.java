package M4;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import java.lang.reflect.InvocationTargetException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class h extends E2 {
    public Boolean b;
    public g c;
    public Boolean d;

    public h(l2 l2Var) {
        super(l2Var);
        this.c = f.a;
    }

    public static final long I() {
        return ((Long) m1.f.a(null)).longValue();
    }

    public static final long i() {
        return ((Long) m1.F.a(null)).longValue();
    }

    public final boolean A() {
        Boolean t = t("google_analytics_adid_collection_enabled");
        return t == null || t.booleanValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:3:0x0003  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean B(java.lang.String r4, M4.l1 r5) {
        /*
            r3 = this;
            r0 = 0
            if (r4 != 0) goto Le
        L3:
            java.lang.Object r4 = r5.a(r0)
        L7:
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            return r4
        Le:
            M4.g r1 = r3.c
            java.lang.String r2 = r5.b()
            java.lang.String r4 = r1.e(r4, r2)
            boolean r1 = android.text.TextUtils.isEmpty(r4)
            if (r1 == 0) goto L1f
            goto L3
        L1f:
            java.lang.String r0 = "1"
            boolean r4 = r0.equals(r4)
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            java.lang.Object r4 = r5.a(r4)
            goto L7
        */
        throw new UnsupportedOperationException("Method not decompiled: M4.h.B(java.lang.String, M4.l1):boolean");
    }

    public final boolean C(String str) {
        return "1".equals(this.c.e(str, "gaia_collection_enabled"));
    }

    public final boolean D() {
        Boolean t = t("google_analytics_automatic_screen_reporting_enabled");
        return t == null || t.booleanValue();
    }

    public final boolean E() {
        this.a.b();
        Boolean t = t("firebase_analytics_collection_deactivated");
        return t != null && t.booleanValue();
    }

    public final boolean F(String str) {
        return "1".equals(this.c.e(str, "measurement.event_sampling_enabled"));
    }

    public final boolean G() {
        if (this.b == null) {
            Boolean t = t("app_measurement_lite");
            this.b = t;
            if (t == null) {
                this.b = Boolean.FALSE;
            }
        }
        return this.b.booleanValue() || !this.a.s();
    }

    public final boolean H() {
        if (this.d == null) {
            synchronized (this) {
                try {
                    if (this.d == null) {
                        ApplicationInfo applicationInfo = this.a.c().getApplicationInfo();
                        String a = C4.n.a();
                        if (applicationInfo != null) {
                            String str = applicationInfo.processName;
                            boolean z = false;
                            if (str != null && str.equals(a)) {
                                z = true;
                            }
                            this.d = Boolean.valueOf(z);
                        }
                        if (this.d == null) {
                            this.d = Boolean.TRUE;
                            this.a.d().r().a("My process not in the list of running processes");
                        }
                    }
                } finally {
                }
            }
        }
        return this.d.booleanValue();
    }

    public final String j(String str, String str2) {
        x1 r;
        String str3;
        try {
            String str4 = (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class, String.class}).invoke((Object) null, new Object[]{str, ""});
            com.google.android.gms.common.internal.r.m(str4);
            return str4;
        } catch (NoSuchMethodException e) {
            e = e;
            r = this.a.d().r();
            str3 = "Could not find SystemProperties.get() method";
            r.b(str3, e);
            return "";
        } catch (IllegalAccessException e2) {
            e = e2;
            r = this.a.d().r();
            str3 = "Could not access SystemProperties.get()";
            r.b(str3, e);
            return "";
        } catch (ClassNotFoundException e3) {
            e = e3;
            r = this.a.d().r();
            str3 = "Could not find SystemProperties class";
            r.b(str3, e);
            return "";
        } catch (InvocationTargetException e4) {
            e = e4;
            r = this.a.d().r();
            str3 = "SystemProperties.get() threw an exception";
            r.b(str3, e);
            return "";
        }
    }

    public final double k(String str, l1 l1Var) {
        if (str != null) {
            String e = this.c.e(str, l1Var.b());
            if (!TextUtils.isEmpty(e)) {
                try {
                    return ((Double) l1Var.a(Double.valueOf(Double.parseDouble(e)))).doubleValue();
                } catch (NumberFormatException unused) {
                }
            }
        }
        return ((Double) l1Var.a(null)).doubleValue();
    }

    public final int l(String str) {
        return p(str, m1.J, 500, 2000);
    }

    public final int m() {
        return this.a.N().X(201500000, true) ? 100 : 25;
    }

    public final int n(String str) {
        return p(str, m1.K, 25, 100);
    }

    public final int o(String str, l1 l1Var) {
        if (str != null) {
            String e = this.c.e(str, l1Var.b());
            if (!TextUtils.isEmpty(e)) {
                try {
                    return ((Integer) l1Var.a(Integer.valueOf(Integer.parseInt(e)))).intValue();
                } catch (NumberFormatException unused) {
                }
            }
        }
        return ((Integer) l1Var.a(null)).intValue();
    }

    public final int p(String str, l1 l1Var, int i, int i2) {
        return Math.max(Math.min(o(str, l1Var), i2), i);
    }

    public final long q() {
        this.a.b();
        return 79000L;
    }

    public final long r(String str, l1 l1Var) {
        if (str != null) {
            String e = this.c.e(str, l1Var.b());
            if (!TextUtils.isEmpty(e)) {
                try {
                    return ((Long) l1Var.a(Long.valueOf(Long.parseLong(e)))).longValue();
                } catch (NumberFormatException unused) {
                }
            }
        }
        return ((Long) l1Var.a(null)).longValue();
    }

    public final Bundle s() {
        try {
            if (this.a.c().getPackageManager() == null) {
                this.a.d().r().a("Failed to load metadata: PackageManager is null");
                return null;
            }
            ApplicationInfo c = E4.e.a(this.a.c()).c(this.a.c().getPackageName(), 128);
            if (c != null) {
                return c.metaData;
            }
            this.a.d().r().a("Failed to load metadata: ApplicationInfo is null");
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            this.a.d().r().b("Failed to load metadata: Package name not found", e);
            return null;
        }
    }

    public final Boolean t(String str) {
        com.google.android.gms.common.internal.r.g(str);
        Bundle s = s();
        if (s == null) {
            this.a.d().r().a("Failed to load metadata: Metadata bundle is null");
            return null;
        }
        if (s.containsKey(str)) {
            return Boolean.valueOf(s.getBoolean(str));
        }
        return null;
    }

    public final String u() {
        return j("debug.firebase.analytics.app", "");
    }

    public final String v() {
        return j("debug.deferred.deeplink", "");
    }

    public final String w() {
        this.a.b();
        return "FA";
    }

    public final String x(String str, l1 l1Var) {
        return (String) l1Var.a(str == null ? null : this.c.e(str, l1Var.b()));
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x002e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List y(java.lang.String r4) {
        /*
            r3 = this;
            java.lang.String r4 = "analytics.safelisted_events"
            com.google.android.gms.common.internal.r.g(r4)
            android.os.Bundle r0 = r3.s()
            r1 = 0
            if (r0 != 0) goto L1d
            M4.l2 r4 = r3.a
            M4.z1 r4 = r4.d()
            M4.x1 r4 = r4.r()
            java.lang.String r0 = "Failed to load metadata: Metadata bundle is null"
            r4.a(r0)
        L1b:
            r4 = r1
            goto L2c
        L1d:
            boolean r2 = r0.containsKey(r4)
            if (r2 != 0) goto L24
            goto L1b
        L24:
            int r4 = r0.getInt(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
        L2c:
            if (r4 == 0) goto L58
            M4.l2 r0 = r3.a     // Catch: android.content.res.Resources.NotFoundException -> L48
            android.content.Context r0 = r0.c()     // Catch: android.content.res.Resources.NotFoundException -> L48
            android.content.res.Resources r0 = r0.getResources()     // Catch: android.content.res.Resources.NotFoundException -> L48
            int r4 = r4.intValue()     // Catch: android.content.res.Resources.NotFoundException -> L48
            java.lang.String[] r4 = r0.getStringArray(r4)     // Catch: android.content.res.Resources.NotFoundException -> L48
            if (r4 != 0) goto L43
            return r1
        L43:
            java.util.List r4 = java.util.Arrays.asList(r4)     // Catch: android.content.res.Resources.NotFoundException -> L48
            return r4
        L48:
            r4 = move-exception
            M4.l2 r0 = r3.a
            M4.z1 r0 = r0.d()
            M4.x1 r0 = r0.r()
            java.lang.String r2 = "Failed to load string array from metadata: resource not found"
            r0.b(r2, r4)
        L58:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: M4.h.y(java.lang.String):java.util.List");
    }

    public final void z(g gVar) {
        this.c = gVar;
    }
}
