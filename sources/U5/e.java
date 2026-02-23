package U5;

import C2.l;
import O5.D;
import O5.W;
import O5.r;
import android.database.SQLException;
import android.os.SystemClock;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Locale;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import z2.f;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class e {
    public final double a;
    public final double b;
    public final long c;
    public final long d;
    public final int e;
    public final BlockingQueue f;
    public final ThreadPoolExecutor g;
    public final f h;
    public final D i;
    public int j;
    public long k;

    public final class b implements Runnable {
        public final r a;
        public final TaskCompletionSource c;

        public b(r rVar, TaskCompletionSource taskCompletionSource) {
            this.a = rVar;
            this.c = taskCompletionSource;
        }

        public void run() {
            e.c(e.this, this.a, this.c);
            e.d(e.this).c();
            double e = e.e(e.this);
            L5.f.f().b("Delay for: " + String.format(Locale.US, "%.2f", new Object[]{Double.valueOf(e / 1000.0d)}) + " s for report: " + this.a.d());
            e.f(e);
        }

        public /* synthetic */ b(e eVar, r rVar, TaskCompletionSource taskCompletionSource, a aVar) {
            this(rVar, taskCompletionSource);
        }
    }

    public e(double d, double d2, long j, f fVar, D d3) {
        this.a = d;
        this.b = d2;
        this.c = j;
        this.h = fVar;
        this.i = d3;
        this.d = SystemClock.elapsedRealtime();
        int i = (int) d;
        this.e = i;
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(i);
        this.f = arrayBlockingQueue;
        this.g = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, arrayBlockingQueue);
        this.j = 0;
        this.k = 0L;
    }

    public static /* synthetic */ void a(e eVar, TaskCompletionSource taskCompletionSource, boolean z, r rVar, Exception exc) {
        eVar.n(taskCompletionSource, z, rVar, exc);
    }

    public static /* synthetic */ void b(e eVar, CountDownLatch countDownLatch) {
        eVar.m(countDownLatch);
    }

    public static /* synthetic */ void c(e eVar, r rVar, TaskCompletionSource taskCompletionSource) {
        eVar.p(rVar, taskCompletionSource);
    }

    public static /* synthetic */ D d(e eVar) {
        return eVar.i;
    }

    public static /* synthetic */ double e(e eVar) {
        return eVar.g();
    }

    public static /* synthetic */ void f(double d) {
        q(d);
    }

    public static void q(double d) {
        try {
            Thread.sleep((long) d);
        } catch (InterruptedException unused) {
        }
    }

    public final double g() {
        return Math.min(3600000.0d, (60000.0d / this.a) * Math.pow(this.b, h()));
    }

    public final int h() {
        if (this.k == 0) {
            this.k = o();
        }
        int o = (int) ((o() - this.k) / this.c);
        int min = l() ? Math.min(100, this.j + o) : Math.max(0, this.j - o);
        if (this.j != min) {
            this.j = min;
            this.k = o();
        }
        return min;
    }

    public TaskCompletionSource i(r rVar, boolean z) {
        synchronized (this.f) {
            try {
                TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
                if (!z) {
                    p(rVar, taskCompletionSource);
                    return taskCompletionSource;
                }
                this.i.b();
                if (!k()) {
                    h();
                    L5.f.f().b("Dropping report due to queue being full: " + rVar.d());
                    this.i.a();
                    taskCompletionSource.trySetResult(rVar);
                    return taskCompletionSource;
                }
                L5.f.f().b("Enqueueing report: " + rVar.d());
                L5.f.f().b("Queue size: " + this.f.size());
                this.g.execute(new b(this, rVar, taskCompletionSource, null));
                L5.f.f().b("Closing task for report: " + rVar.d());
                taskCompletionSource.trySetResult(rVar);
                return taskCompletionSource;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void j() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        new Thread(new d(this, countDownLatch)).start();
        W.g(countDownLatch, 2L, TimeUnit.SECONDS);
    }

    public final boolean k() {
        return this.f.size() < this.e;
    }

    public final boolean l() {
        return this.f.size() == this.e;
    }

    public final /* synthetic */ void m(CountDownLatch countDownLatch) {
        try {
            l.a(this.h, z2.d.HIGHEST);
        } catch (SQLException unused) {
        }
        countDownLatch.countDown();
    }

    public final /* synthetic */ void n(TaskCompletionSource taskCompletionSource, boolean z, r rVar, Exception exc) {
        if (exc != null) {
            taskCompletionSource.trySetException(exc);
            return;
        }
        if (z) {
            j();
        }
        taskCompletionSource.trySetResult(rVar);
    }

    public final long o() {
        return System.currentTimeMillis();
    }

    public final void p(r rVar, TaskCompletionSource taskCompletionSource) {
        L5.f.f().b("Sending report through Google DataTransport: " + rVar.d());
        this.h.b(z2.c.h(rVar.b()), new c(this, taskCompletionSource, SystemClock.elapsedRealtime() - this.d < 2000, rVar));
    }

    public e(f fVar, V5.d dVar, D d) {
        this(dVar.f, dVar.g, dVar.h * 1000, fVar, d);
    }
}
