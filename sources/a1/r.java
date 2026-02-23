package a1;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class r {
    public static final String f = Q0.k.f("WorkTimer");
    public final ThreadFactory a;
    public final ScheduledExecutorService b;
    public final Map c;
    public final Map d;
    public final Object e;

    public class a implements ThreadFactory {
        public int a = 0;

        public a() {
        }

        public Thread newThread(Runnable runnable) {
            Thread newThread = Executors.defaultThreadFactory().newThread(runnable);
            newThread.setName("WorkManager-WorkTimer-thread-" + this.a);
            this.a = this.a + 1;
            return newThread;
        }
    }

    public interface b {
        void a(String str);
    }

    public static class c implements Runnable {
        public final r a;
        public final String c;

        public c(r rVar, String str) {
            this.a = rVar;
            this.c = str;
        }

        public void run() {
            synchronized (this.a.e) {
                try {
                    if (((c) this.a.c.remove(this.c)) != null) {
                        b bVar = (b) this.a.d.remove(this.c);
                        if (bVar != null) {
                            bVar.a(this.c);
                        }
                    } else {
                        Q0.k.c().a("WrkTimerRunnable", String.format("Timer with %s is already marked as complete.", new Object[]{this.c}), new Throwable[0]);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public r() {
        a aVar = new a();
        this.a = aVar;
        this.c = new HashMap();
        this.d = new HashMap();
        this.e = new Object();
        this.b = Executors.newSingleThreadScheduledExecutor(aVar);
    }

    public void a() {
        if (this.b.isShutdown()) {
            return;
        }
        this.b.shutdownNow();
    }

    public void b(String str, long j, b bVar) {
        synchronized (this.e) {
            Q0.k.c().a(f, String.format("Starting timer for %s", new Object[]{str}), new Throwable[0]);
            c(str);
            c cVar = new c(this, str);
            this.c.put(str, cVar);
            this.d.put(str, bVar);
            this.b.schedule(cVar, j, TimeUnit.MILLISECONDS);
        }
    }

    public void c(String str) {
        synchronized (this.e) {
            try {
                if (((c) this.c.remove(str)) != null) {
                    Q0.k.c().a(f, String.format("Stopping timer for %s", new Object[]{str}), new Throwable[0]);
                    this.d.remove(str);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
