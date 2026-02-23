package o0;

import android.os.Binder;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class d {
    public static final ThreadFactory g;
    public static final BlockingQueue h;
    public static final Executor i;
    public static f j;
    public static volatile Executor k;
    public final h a;
    public final FutureTask c;
    public volatile g d = g.PENDING;
    public final AtomicBoolean e = new AtomicBoolean();
    public final AtomicBoolean f = new AtomicBoolean();

    public static class a implements ThreadFactory {
        public final AtomicInteger a = new AtomicInteger(1);

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "ModernAsyncTask #" + this.a.getAndIncrement());
        }
    }

    public class b extends h {
        public b() {
        }

        public Object call() {
            d.this.f.set(true);
            Object obj = null;
            try {
                Process.setThreadPriority(10);
                obj = d.this.b(this.a);
                Binder.flushPendingCommands();
                return obj;
            } finally {
            }
        }
    }

    public class c extends FutureTask {
        public c(Callable callable) {
            super(callable);
        }

        public void done() {
            try {
                d.this.l(get());
            } catch (InterruptedException e) {
                Log.w("AsyncTask", e);
            } catch (CancellationException unused) {
                d.this.l(null);
            } catch (ExecutionException e2) {
                throw new RuntimeException("An error occurred while executing doInBackground()", e2.getCause());
            } catch (Throwable th) {
                throw new RuntimeException("An error occurred while executing doInBackground()", th);
            }
        }
    }

    public static /* synthetic */ class d {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[g.values().length];
            a = iArr;
            try {
                iArr[g.RUNNING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[g.FINISHED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static class e {
        public final d a;
        public final Object[] b;

        public e(d dVar, Object... objArr) {
            this.a = dVar;
            this.b = objArr;
        }
    }

    public static class f extends Handler {
        public f() {
            super(Looper.getMainLooper());
        }

        public void handleMessage(Message message) {
            e eVar = (e) message.obj;
            int i = message.what;
            if (i == 1) {
                eVar.a.d(eVar.b[0]);
            } else {
                if (i != 2) {
                    return;
                }
                eVar.a.j(eVar.b);
            }
        }
    }

    public enum g {
        PENDING,
        RUNNING,
        FINISHED
    }

    public static abstract class h implements Callable {
        public Object[] a;
    }

    static {
        a aVar = new a();
        g = aVar;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(10);
        h = linkedBlockingQueue;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 128, 1L, TimeUnit.SECONDS, linkedBlockingQueue, aVar);
        i = threadPoolExecutor;
        k = threadPoolExecutor;
    }

    public d() {
        b bVar = new b();
        this.a = bVar;
        this.c = new c(bVar);
    }

    public static Handler e() {
        f fVar;
        synchronized (d.class) {
            try {
                if (j == null) {
                    j = new f();
                }
                fVar = j;
            } catch (Throwable th) {
                throw th;
            }
        }
        return fVar;
    }

    public final boolean a(boolean z) {
        this.e.set(true);
        return this.c.cancel(z);
    }

    public abstract Object b(Object... objArr);

    public final d c(Executor executor, Object... objArr) {
        if (this.d == g.PENDING) {
            this.d = g.RUNNING;
            i();
            this.a.a = objArr;
            executor.execute(this.c);
            return this;
        }
        int i2 = d.a[this.d.ordinal()];
        if (i2 == 1) {
            throw new IllegalStateException("Cannot execute task: the task is already running.");
        }
        if (i2 != 2) {
            throw new IllegalStateException("We should never reach this state");
        }
        throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
    }

    public void d(Object obj) {
        if (f()) {
            g(obj);
        } else {
            h(obj);
        }
        this.d = g.FINISHED;
    }

    public final boolean f() {
        return this.e.get();
    }

    public abstract void g(Object obj);

    public abstract void h(Object obj);

    public Object k(Object obj) {
        e().obtainMessage(1, new e(this, obj)).sendToTarget();
        return obj;
    }

    public void l(Object obj) {
        if (this.f.get()) {
            return;
        }
        k(obj);
    }

    public void j(Object... objArr) {
    }

    public void i() {
    }
}
