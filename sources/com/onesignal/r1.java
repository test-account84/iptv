package com.onesignal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.HandlerThread;
import com.onesignal.F1;
import java.util.HashMap;
import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class R1 {
    public static final String a = F1.class.getSimpleName();
    public static HashMap b;
    public static a c;

    public static class a extends HandlerThread {
        public Handler a;
        public long c;
        public boolean d;

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                a.a(a.this);
            }
        }

        public a(String str) {
            super(str);
            this.c = 0L;
        }

        public static /* synthetic */ void a(a aVar) {
            aVar.c();
        }

        public static /* synthetic */ void b(a aVar) {
            aVar.e();
        }

        public final void c() {
            for (String str : R1.b.keySet()) {
                SharedPreferences.Editor edit = R1.e(str).edit();
                HashMap hashMap = (HashMap) R1.b.get(str);
                synchronized (hashMap) {
                    try {
                        for (String str2 : hashMap.keySet()) {
                            Object obj = hashMap.get(str2);
                            if (obj instanceof String) {
                                edit.putString(str2, (String) obj);
                            } else if (obj instanceof Boolean) {
                                edit.putBoolean(str2, ((Boolean) obj).booleanValue());
                            } else if (obj instanceof Integer) {
                                edit.putInt(str2, ((Integer) obj).intValue());
                            } else if (obj instanceof Long) {
                                edit.putLong(str2, ((Long) obj).longValue());
                            } else if (obj instanceof Set) {
                                edit.putStringSet(str2, (Set) obj);
                            } else if (obj == null) {
                                edit.remove(str2);
                            }
                        }
                        hashMap.clear();
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                edit.apply();
            }
            this.c = F1.v0().a();
        }

        public final synchronized void d() {
            try {
                Handler handler = this.a;
                if (handler == null) {
                    return;
                }
                handler.removeCallbacksAndMessages((Object) null);
                if (this.c == 0) {
                    this.c = F1.v0().a();
                }
                long a2 = (this.c - F1.v0().a()) + 200;
                this.a.postDelayed(new a(), a2);
            } catch (Throwable th) {
                throw th;
            }
        }

        public final synchronized void e() {
            if (F1.b == null) {
                return;
            }
            f();
            d();
        }

        public final void f() {
            if (this.d) {
                return;
            }
            start();
            this.d = true;
        }

        public void onLooperPrepared() {
            super.onLooperPrepared();
            this.a = new Handler(getLooper());
            d();
        }
    }

    static {
        h();
    }

    public static Object a(String str, String str2, Class cls, Object obj) {
        HashMap hashMap = (HashMap) b.get(str);
        synchronized (hashMap) {
            try {
                if (cls.equals(Object.class) && hashMap.containsKey(str2)) {
                    return Boolean.TRUE;
                }
                Object obj2 = hashMap.get(str2);
                if (obj2 == null && !hashMap.containsKey(str2)) {
                    SharedPreferences e = e(str);
                    if (e == null) {
                        return obj;
                    }
                    if (cls.equals(String.class)) {
                        return e.getString(str2, (String) obj);
                    }
                    if (cls.equals(Boolean.class)) {
                        return Boolean.valueOf(e.getBoolean(str2, ((Boolean) obj).booleanValue()));
                    }
                    if (cls.equals(Integer.class)) {
                        return Integer.valueOf(e.getInt(str2, ((Integer) obj).intValue()));
                    }
                    if (cls.equals(Long.class)) {
                        return Long.valueOf(e.getLong(str2, ((Long) obj).longValue()));
                    }
                    if (cls.equals(Set.class)) {
                        return e.getStringSet(str2, (Set) obj);
                    }
                    if (cls.equals(Object.class)) {
                        return Boolean.valueOf(e.contains(str2));
                    }
                    return null;
                }
                return obj2;
            } finally {
            }
        }
    }

    public static boolean b(String str, String str2, boolean z) {
        return ((Boolean) a(str, str2, Boolean.class, Boolean.valueOf(z))).booleanValue();
    }

    public static int c(String str, String str2, int i) {
        return ((Integer) a(str, str2, Integer.class, Integer.valueOf(i))).intValue();
    }

    public static long d(String str, String str2, long j) {
        return ((Long) a(str, str2, Long.class, Long.valueOf(j))).longValue();
    }

    public static synchronized SharedPreferences e(String str) {
        synchronized (R1.class) {
            Context context = F1.b;
            if (context != null) {
                return context.getSharedPreferences(str, 0);
            }
            F1.b(F1.v.WARN, "OneSignal.appContext null, could not read " + str + " from getSharedPreferences.", new Throwable());
            return null;
        }
    }

    public static String f(String str, String str2, String str3) {
        return (String) a(str, str2, String.class, str3);
    }

    public static Set g(String str, String str2, Set set) {
        return (Set) a(str, str2, Set.class, set);
    }

    public static void h() {
        HashMap hashMap = new HashMap();
        b = hashMap;
        hashMap.put(a, new HashMap());
        b.put("GTPlayerPurchases", new HashMap());
        b.put("OneSignalTriggers", new HashMap());
        c = new a("OSH_WritePrefs");
    }

    public static void i(String str, String str2, Object obj) {
        HashMap hashMap = (HashMap) b.get(str);
        synchronized (hashMap) {
            hashMap.put(str2, obj);
        }
        o();
    }

    public static void j(String str, String str2, boolean z) {
        i(str, str2, Boolean.valueOf(z));
    }

    public static void k(String str, String str2, int i) {
        i(str, str2, Integer.valueOf(i));
    }

    public static void l(String str, String str2, long j) {
        i(str, str2, Long.valueOf(j));
    }

    public static void m(String str, String str2, String str3) {
        i(str, str2, str3);
    }

    public static void n(String str, String str2, Set set) {
        i(str, str2, set);
    }

    public static void o() {
        a.b(c);
    }
}
