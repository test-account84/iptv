package r7;

import O2.G1;
import X2.b;
import android.content.Context;
import b4.m;
import b4.o;
import b4.w;
import b4.x;
import c4.c;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.util.concurrent.Executors;
import org.chromium.net.CronetEngine;
import p7.p1;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class b {
    public static o.a a;
    public static o.a b;
    public static T2.b c;
    public static z3.s d;
    public static com.nst.iptvsmarterstvbox.view.demo.a e;

    public static c.c a(o.a aVar, c4.a aVar2) {
        return new c.c().i(aVar2).l(aVar).j((m.a) null).k(2);
    }

    public static G1 b(Context context, boolean z) {
        return new O2.s(context.getApplicationContext()).j(h() ? z ? 2 : 1 : 0);
    }

    public static synchronized void c(Context context) {
        synchronized (b.class) {
            if (d == null) {
                d = new z3.s(context, e(context), p1.a(context), g(context), Executors.newFixedThreadPool(6));
                e = new com.nst.iptvsmarterstvbox.view.demo.a(context, g(context), d);
            }
        }
    }

    public static synchronized o.a d(Context context) {
        o.a aVar;
        synchronized (b.class) {
            try {
                if (a == null) {
                    Context applicationContext = context.getApplicationContext();
                    a = a(new w.a(applicationContext, g(applicationContext)), p1.a(applicationContext));
                }
                aVar = a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aVar;
    }

    public static synchronized T2.b e(Context context) {
        T2.b bVar;
        synchronized (b.class) {
            try {
                if (c == null) {
                    c = new T2.d(context);
                }
                bVar = c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return bVar;
    }

    public static synchronized com.nst.iptvsmarterstvbox.view.demo.a f(Context context) {
        com.nst.iptvsmarterstvbox.view.demo.a aVar;
        synchronized (b.class) {
            c(context);
            aVar = e;
        }
        return aVar;
    }

    public static synchronized o.a g(Context context) {
        o.a aVar;
        synchronized (b.class) {
            try {
                if (b == null) {
                    CronetEngine a2 = X2.c.a(context.getApplicationContext());
                    if (a2 != null) {
                        b = new b.b(a2, Executors.newSingleThreadExecutor());
                    }
                    if (b == null) {
                        CookieManager cookieManager = new CookieManager();
                        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ORIGINAL_SERVER);
                        CookieHandler.setDefault(cookieManager);
                        b = new x.b();
                    }
                }
                aVar = b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aVar;
    }

    public static boolean h() {
        return true;
    }
}
