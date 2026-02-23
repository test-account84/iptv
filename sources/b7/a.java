package B7;

import O2.G1;
import X2.b;
import a4.i;
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
import z3.s;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class a {
    public static o.a a;
    public static o.a b;
    public static T2.b c;
    public static s d;
    public static i e;

    public static c.c a(o.a aVar, c4.a aVar2) {
        return new c.c().i(aVar2).l(aVar).j((m.a) null).k(2);
    }

    public static G1 b(Context context, boolean z) {
        return new O2.s(context.getApplicationContext()).j(i() ? z ? 2 : 1 : 0);
    }

    public static synchronized void c(Context context) {
        synchronized (a.class) {
            if (d == null) {
                s sVar = new s(context, e(context), p1.a(context), h(context), Executors.newFixedThreadPool(6));
                d = sVar;
                sVar.y(1);
            }
        }
    }

    public static synchronized o.a d(Context context) {
        o.a aVar;
        synchronized (a.class) {
            try {
                if (a == null) {
                    Context applicationContext = context.getApplicationContext();
                    a = a(new w.a(applicationContext, h(applicationContext)), p1.a(applicationContext));
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
        synchronized (a.class) {
            try {
                if (c == null) {
                    c = new T2.c(context);
                }
                bVar = c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return bVar;
    }

    public static synchronized s f(Context context) {
        s sVar;
        synchronized (a.class) {
            c(context);
            sVar = d;
        }
        return sVar;
    }

    public static synchronized i g(Context context) {
        i iVar;
        synchronized (a.class) {
            try {
                if (e == null) {
                    e = new i(context, "downChannel");
                }
                iVar = e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return iVar;
    }

    public static synchronized o.a h(Context context) {
        o.a aVar;
        synchronized (a.class) {
            try {
                if (b == null) {
                    CronetEngine b2 = X2.c.b(context.getApplicationContext(), "IPTVSmartersPlayer", true);
                    if (b2 != null) {
                        b = new b.b(b2, Executors.newSingleThreadExecutor());
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

    public static boolean i() {
        return true;
    }
}
