package O5;

import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class w {

    public class a implements ThreadFactory {
        public final /* synthetic */ String a;
        public final /* synthetic */ AtomicLong b;

        public class a extends d {
            public final /* synthetic */ Runnable a;

            public a(Runnable runnable) {
                this.a = runnable;
            }

            public void a() {
                this.a.run();
            }
        }

        public a(String str, AtomicLong atomicLong) {
            this.a = str;
            this.b = atomicLong;
        }

        public Thread newThread(Runnable runnable) {
            Thread newThread = Executors.defaultThreadFactory().newThread(new a(runnable));
            newThread.setName(this.a + this.b.getAndIncrement());
            return newThread;
        }
    }

    public class b extends d {
        public final /* synthetic */ String a;
        public final /* synthetic */ ExecutorService c;
        public final /* synthetic */ long d;
        public final /* synthetic */ TimeUnit e;

        public b(String str, ExecutorService executorService, long j, TimeUnit timeUnit) {
            this.a = str;
            this.c = executorService;
            this.d = j;
            this.e = timeUnit;
        }

        public void a() {
            try {
                L5.f.f().b("Executing shutdown hook for " + this.a);
                this.c.shutdown();
                if (this.c.awaitTermination(this.d, this.e)) {
                    return;
                }
                L5.f.f().b(this.a + " did not shut down in the allocated time. Requesting immediate shutdown.");
                this.c.shutdownNow();
            } catch (InterruptedException unused) {
                L5.f.f().b(String.format(Locale.US, "Interrupted while waiting for %s to shut down. Requesting immediate shutdown.", new Object[]{this.a}));
                this.c.shutdownNow();
            }
        }
    }

    public static void a(String str, ExecutorService executorService) {
        b(str, executorService, 2L, TimeUnit.SECONDS);
    }

    public static void b(String str, ExecutorService executorService, long j, TimeUnit timeUnit) {
        Runtime.getRuntime().addShutdownHook(new Thread(new b(str, executorService, j, timeUnit), "Crashlytics Shutdown Hook for " + str));
    }

    public static ExecutorService c(String str) {
        ExecutorService e = e(d(str), new ThreadPoolExecutor.DiscardPolicy());
        a(str, e);
        return e;
    }

    public static ThreadFactory d(String str) {
        return new a(str, new AtomicLong(1L));
    }

    public static ExecutorService e(ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        return Executors.unconfigurableExecutorService(new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), threadFactory, rejectedExecutionHandler));
    }
}
