package M;

import android.os.Handler;
import android.os.Process;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class h {

    public static class a implements ThreadFactory {
        public String a;
        public int b;

        public static class a extends Thread {
            public final int a;

            public a(Runnable runnable, String str, int i) {
                super(runnable, str);
                this.a = i;
            }

            public void run() {
                Process.setThreadPriority(this.a);
                super.run();
            }
        }

        public a(String str, int i) {
            this.a = str;
            this.b = i;
        }

        public Thread newThread(Runnable runnable) {
            return new a(runnable, this.a, this.b);
        }
    }

    public static class b implements Runnable {
        public Callable a;
        public O.a c;
        public Handler d;

        public class a implements Runnable {
            public final /* synthetic */ O.a a;
            public final /* synthetic */ Object c;

            public a(O.a aVar, Object obj) {
                this.a = aVar;
                this.c = obj;
            }

            public void run() {
                this.a.accept(this.c);
            }
        }

        public b(Handler handler, Callable callable, O.a aVar) {
            this.a = callable;
            this.c = aVar;
            this.d = handler;
        }

        public void run() {
            Object obj;
            try {
                obj = this.a.call();
            } catch (Exception unused) {
                obj = null;
            }
            this.d.post(new a(this.c, obj));
        }
    }

    public static ThreadPoolExecutor a(String str, int i, int i2) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, i2, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new a(str, i));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    public static void b(Executor executor, Callable callable, O.a aVar) {
        executor.execute(new b(M.b.a(), callable, aVar));
    }

    public static Object c(ExecutorService executorService, Callable callable, int i) {
        try {
            return executorService.submit(callable).get(i, TimeUnit.MILLISECONDS);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (TimeoutException unused) {
            throw new InterruptedException("timeout");
        } catch (InterruptedException e2) {
            throw e2;
        }
    }
}
