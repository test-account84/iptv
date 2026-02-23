package l;

import java.util.concurrent.Executor;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class a extends d {
    public static volatile a c;
    public static final Executor d = new a();
    public static final Executor e = new b();
    public d a;
    public d b;

    public static class a implements Executor {
        public void execute(Runnable runnable) {
            a.e().c(runnable);
        }
    }

    public static class b implements Executor {
        public void execute(Runnable runnable) {
            a.e().a(runnable);
        }
    }

    public a() {
        c cVar = new c();
        this.b = cVar;
        this.a = cVar;
    }

    public static Executor d() {
        return e;
    }

    public static a e() {
        if (c != null) {
            return c;
        }
        synchronized (a.class) {
            try {
                if (c == null) {
                    c = new a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return c;
    }

    public void a(Runnable runnable) {
        this.a.a(runnable);
    }

    public boolean b() {
        return this.a.b();
    }

    public void c(Runnable runnable) {
        this.a.c(runnable);
    }
}
