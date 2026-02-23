package com.onesignal;

import android.content.Context;
import android.location.Location;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import com.onesignal.F1;
import j$.util.concurrent.ConcurrentHashMap;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class O {
    public static boolean c;
    public static c e;
    public static Thread f;
    public static Context g;
    public static Location h;
    public static String i;
    public static final List a = new ArrayList();
    public static ConcurrentHashMap b = new ConcurrentHashMap();
    public static final Object d = new a();

    public class a {
    }

    public interface b {
        void a(d dVar);

        f getType();
    }

    public static class c extends HandlerThread {
        public Handler a;

        public c() {
            super("OSH_LocationHandlerThread");
            start();
            this.a = new Handler(getLooper());
        }
    }

    public static class d {
        public Double a;
        public Double b;
        public Float c;
        public Integer d;
        public Boolean e;
        public Long f;

        public String toString() {
            return "LocationPoint{lat=" + this.a + ", log=" + this.b + ", accuracy=" + this.c + ", type=" + this.d + ", bg=" + this.e + ", timeStamp=" + this.f + '}';
        }
    }

    public static abstract class e implements b {
        public void b(F1.z zVar) {
        }
    }

    public enum f {
        STARTUP,
        PROMPT_LOCATION,
        SYNC_SERVICE
    }

    public static void a(b bVar) {
        if (bVar instanceof e) {
            List list = a;
            synchronized (list) {
                list.add((e) bVar);
            }
        }
    }

    public static void b(Context context, boolean z, boolean z2) {
        A a2 = X1.a.a(context, context.getPackageName(), 4096);
        if (!a2.b() || a2.a() == null) {
            n(z, F1.z.ERROR);
            return;
        }
        if (Arrays.asList(a2.a().requestedPermissions).contains("android.permission.ACCESS_BACKGROUND_LOCATION")) {
            i = "android.permission.ACCESS_BACKGROUND_LOCATION";
        }
        if (i != null && z) {
            P.a.d(z2, i);
        } else {
            n(z, F1.z.PERMISSION_GRANTED);
            p();
        }
    }

    public static void c(d dVar) {
        Thread thread;
        HashMap hashMap = new HashMap();
        synchronized (O.class) {
            hashMap.putAll(b);
            b.clear();
            thread = f;
        }
        Iterator it = hashMap.keySet().iterator();
        while (it.hasNext()) {
            ((b) hashMap.get((f) it.next())).a(dVar);
        }
        if (thread != null && !Thread.currentThread().equals(thread)) {
            thread.interrupt();
        }
        if (thread == f) {
            synchronized (O.class) {
                try {
                    if (thread == f) {
                        f = null;
                    }
                } finally {
                }
            }
        }
        o(F1.v0().a());
    }

    public static void d(Location location) {
        double longitude;
        F1.a(F1.v.DEBUG, "LocationController fireCompleteForLocation with location: " + location);
        d dVar = new d();
        dVar.c = Float.valueOf(location.getAccuracy());
        dVar.e = Boolean.valueOf(F1.N0() ^ true);
        dVar.d = Integer.valueOf(!c ? 1 : 0);
        dVar.f = Long.valueOf(location.getTime());
        if (c) {
            BigDecimal bigDecimal = new BigDecimal(location.getLatitude());
            RoundingMode roundingMode = RoundingMode.HALF_UP;
            dVar.a = Double.valueOf(bigDecimal.setScale(7, roundingMode).doubleValue());
            longitude = new BigDecimal(location.getLongitude()).setScale(7, roundingMode).doubleValue();
        } else {
            dVar.a = Double.valueOf(location.getLatitude());
            longitude = location.getLongitude();
        }
        dVar.b = Double.valueOf(longitude);
        c(dVar);
        m(g);
    }

    public static void e() {
        synchronized (d) {
            try {
                if (j()) {
                    v.e();
                } else if (k()) {
                    D.e();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        c(null);
    }

    public static long f() {
        return R1.d(R1.a, "OS_LAST_LOCATION_TIME", -600000L);
    }

    public static void g(Context context, boolean z, boolean z2, b bVar) {
        int i2;
        a(bVar);
        g = context;
        b.put(bVar.getType(), bVar);
        if (!F1.P0()) {
            n(z, F1.z.ERROR);
            e();
            return;
        }
        int a2 = h.a(context, "android.permission.ACCESS_FINE_LOCATION");
        if (a2 == -1) {
            i2 = h.a(context, "android.permission.ACCESS_COARSE_LOCATION");
            c = true;
        } else {
            i2 = -1;
        }
        int i3 = Build.VERSION.SDK_INT;
        int a3 = i3 >= 29 ? h.a(context, "android.permission.ACCESS_BACKGROUND_LOCATION") : -1;
        if (i3 < 23) {
            if (a2 != 0 && i2 != 0) {
                n(z, F1.z.LOCATION_PERMISSIONS_MISSING_MANIFEST);
                bVar.a(null);
                return;
            }
        } else if (a2 != 0) {
            A a4 = X1.a.a(context, context.getPackageName(), 4096);
            if (!a4.b() || a4.a() == null) {
                n(z, F1.z.ERROR);
                return;
            }
            List asList = Arrays.asList(a4.a().requestedPermissions);
            F1.z zVar = F1.z.PERMISSION_DENIED;
            if (asList.contains("android.permission.ACCESS_FINE_LOCATION")) {
                i = "android.permission.ACCESS_FINE_LOCATION";
            } else if (!asList.contains("android.permission.ACCESS_COARSE_LOCATION")) {
                F1.c1(F1.v.INFO, "Location permissions not added on AndroidManifest file");
                zVar = F1.z.LOCATION_PERMISSIONS_MISSING_MANIFEST;
            } else if (i2 != 0) {
                i = "android.permission.ACCESS_COARSE_LOCATION";
            } else if (i3 >= 29 && asList.contains("android.permission.ACCESS_BACKGROUND_LOCATION")) {
                i = "android.permission.ACCESS_BACKGROUND_LOCATION";
            }
            if (i != null && z) {
                P.a.d(z2, i);
                return;
            } else if (i2 != 0) {
                n(z, zVar);
                e();
                return;
            }
        } else if (i3 >= 29 && a3 != 0) {
            b(context, z, z2);
            return;
        }
        n(z, F1.z.PERMISSION_GRANTED);
        p();
    }

    public static c h() {
        if (e == null) {
            synchronized (d) {
                try {
                    if (e == null) {
                        e = new c();
                    }
                } finally {
                }
            }
        }
        return e;
    }

    public static boolean i(Context context) {
        return h.a(context, "android.permission.ACCESS_FINE_LOCATION") == 0 || h.a(context, "android.permission.ACCESS_COARSE_LOCATION") == 0;
    }

    public static boolean j() {
        return OSUtils.B() && OSUtils.s();
    }

    public static boolean k() {
        return OSUtils.G() && OSUtils.v();
    }

    public static void l() {
        synchronized (d) {
            try {
                if (j()) {
                    v.l();
                } else {
                    if (k()) {
                        D.l();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean m(Context context) {
        F1.v vVar;
        String str;
        if (!i(context)) {
            vVar = F1.v.DEBUG;
            str = "LocationController scheduleUpdate not possible, location permission not enabled";
        } else {
            if (F1.P0()) {
                long a2 = F1.v0().a() - f();
                long j = (F1.N0() ? 300L : 600L) * 1000;
                F1.c1(F1.v.DEBUG, "LocationController scheduleUpdate lastTime: " + a2 + " minTime: " + j);
                o1.q().r(context, j - a2);
                return true;
            }
            vVar = F1.v.DEBUG;
            str = "LocationController scheduleUpdate not possible, location shared not enabled";
        }
        F1.c1(vVar, str);
        return false;
    }

    public static void n(boolean z, F1.z zVar) {
        if (!z) {
            F1.c1(F1.v.DEBUG, "LocationController sendAndClearPromptHandlers from non prompt flow");
            return;
        }
        List list = a;
        synchronized (list) {
            try {
                F1.c1(F1.v.DEBUG, "LocationController calling prompt handlers");
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((e) it.next()).b(zVar);
                }
                a.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void o(long j) {
        R1.l(R1.a, "OS_LAST_LOCATION_TIME", j);
    }

    public static void p() {
        F1.a(F1.v.DEBUG, "LocationController startGetLocation with lastLocation: " + h);
        try {
            if (j()) {
                v.p();
            } else if (k()) {
                D.p();
            } else {
                F1.a(F1.v.WARN, "LocationController startGetLocation not possible, no location dependency found");
                e();
            }
        } catch (Throwable th) {
            F1.b(F1.v.WARN, "Location permission exists but there was an error initializing: ", th);
            e();
        }
    }
}
