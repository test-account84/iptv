package w4;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.UserManager;
import android.util.Log;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class m {
    public static final int a = 12451000;
    public static boolean c = false;
    public static boolean d = false;
    public static final AtomicBoolean b = new AtomicBoolean();
    public static final AtomicBoolean e = new AtomicBoolean();

    public static void a(Context context) {
        if (b.getAndSet(true)) {
            return;
        }
        try {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            if (notificationManager != null) {
                notificationManager.cancel(10436);
            }
        } catch (SecurityException e2) {
            Log.d("GooglePlayServicesUtil", "Suppressing Security Exception %s in cancelAvailabilityErrorNotifications.", e2);
        }
    }

    public static void b(Context context, int i) {
        int j = i.h().j(context, i);
        if (j != 0) {
            Intent d2 = i.h().d(context, j, "e");
            Log.e("GooglePlayServicesUtil", "GooglePlayServices not available due to error " + j);
            if (d2 != null) {
                throw new k(j, "Google Play Services not available", d2);
            }
            throw new j(j);
        }
    }

    public static int c(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            return 0;
        }
    }

    public static String d(int i) {
        return b.M(i);
    }

    public static Context e(Context context) {
        try {
            return context.createPackageContext("com.google.android.gms", 3);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static Resources f(Context context) {
        try {
            return context.getPackageManager().getResourcesForApplication("com.google.android.gms");
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static boolean g(Context context) {
        if (!d) {
            try {
                try {
                    PackageInfo e2 = E4.e.a(context).e("com.google.android.gms", 64);
                    n.a(context);
                    if (e2 == null || n.e(e2, false) || !n.e(e2, true)) {
                        c = false;
                    } else {
                        c = true;
                    }
                } catch (PackageManager.NameNotFoundException e3) {
                    Log.w("GooglePlayServicesUtil", "Cannot find Google Play services package name.", e3);
                }
                d = true;
            } catch (Throwable th) {
                d = true;
                throw th;
            }
        }
        return c || !C4.i.b();
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00a5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int h(android.content.Context r10, int r11) {
        /*
            Method dump skipped, instructions count: 287
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: w4.m.h(android.content.Context, int):int");
    }

    public static boolean i(Context context, int i) {
        if (i == 18) {
            return true;
        }
        if (i == 1) {
            return m(context, "com.google.android.gms");
        }
        return false;
    }

    public static boolean j(Context context) {
        if (!C4.m.c()) {
            return false;
        }
        Object systemService = context.getSystemService("user");
        com.google.android.gms.common.internal.r.m(systemService);
        Bundle applicationRestrictions = ((UserManager) systemService).getApplicationRestrictions(context.getPackageName());
        return applicationRestrictions != null && "true".equals(applicationRestrictions.getString("restricted_profile"));
    }

    public static boolean k(int i) {
        return i == 1 || i == 2 || i == 3 || i == 9;
    }

    public static boolean l(Context context, int i, String str) {
        return C4.p.b(context, i, str);
    }

    public static boolean m(Context context, String str) {
        ApplicationInfo applicationInfo;
        boolean equals = str.equals("com.google.android.gms");
        if (C4.m.f()) {
            try {
                Iterator it = context.getPackageManager().getPackageInstaller().getAllSessions().iterator();
                while (it.hasNext()) {
                    if (str.equals(((PackageInstaller.SessionInfo) it.next()).getAppPackageName())) {
                        return true;
                    }
                }
            } catch (Exception unused) {
                return false;
            }
        }
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(str, 8192);
        } catch (PackageManager.NameNotFoundException unused2) {
        }
        return equals ? applicationInfo.enabled : applicationInfo.enabled && !j(context);
    }
}
