package com.onesignal;

import android.content.Context;
import android.os.Bundle;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class k2 {
    public static Class c;
    public static AtomicLong d;
    public static AtomicLong e;
    public static Q0 f;
    public Object a;
    public Context b;

    public k2(Context context) {
        this.b = context;
    }

    public static boolean a() {
        try {
            c = FirebaseAnalytics.class;
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static Method d(Class cls) {
        try {
            return cls.getMethod("getInstance", new Class[]{Context.class});
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static Method e(Class cls) {
        try {
            return cls.getMethod("logEvent", new Class[]{String.class, Bundle.class});
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public final String b(Q0 q0) {
        if (q0.j().isEmpty() || q0.i().isEmpty()) {
            return q0.k() != null ? q0.k().substring(0, Math.min(10, q0.k().length())) : "";
        }
        return q0.j() + " - " + q0.i();
    }

    public final Object c(Context context) {
        if (this.a == null) {
            try {
                this.a = d(c).invoke((Object) null, new Object[]{context});
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return this.a;
    }

    public void f() {
        if (d == null || f == null) {
            return;
        }
        long a = F1.v0().a();
        if (a - d.get() > 120000) {
            return;
        }
        AtomicLong atomicLong = e;
        if (atomicLong == null || a - atomicLong.get() >= 30000) {
            try {
                Object c2 = c(this.b);
                Method e2 = e(c);
                Bundle bundle = new Bundle();
                bundle.putString("source", "OneSignal");
                bundle.putString("medium", "notification");
                bundle.putString("notification_id", f.g());
                bundle.putString("campaign", b(f));
                e2.invoke(c2, new Object[]{"os_notification_influence_open", bundle});
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void g(Z0 z0) {
        if (e == null) {
            e = new AtomicLong();
        }
        e.set(F1.v0().a());
        try {
            Object c2 = c(this.b);
            Method e2 = e(c);
            Bundle bundle = new Bundle();
            bundle.putString("source", "OneSignal");
            bundle.putString("medium", "notification");
            bundle.putString("notification_id", z0.d().g());
            bundle.putString("campaign", b(z0.d()));
            e2.invoke(c2, new Object[]{"os_notification_opened", bundle});
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void h(Z0 z0) {
        try {
            Object c2 = c(this.b);
            Method e2 = e(c);
            Bundle bundle = new Bundle();
            bundle.putString("source", "OneSignal");
            bundle.putString("medium", "notification");
            bundle.putString("notification_id", z0.d().g());
            bundle.putString("campaign", b(z0.d()));
            e2.invoke(c2, new Object[]{"os_notification_received", bundle});
            if (d == null) {
                d = new AtomicLong();
            }
            d.set(F1.v0().a());
            f = z0.d();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
