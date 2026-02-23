package q6;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.messaging.FirebaseMessaging;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class d0 {
    public static final long i = TimeUnit.HOURS.toSeconds(8);
    public final Context a;
    public final I b;
    public final D c;
    public final FirebaseMessaging d;
    public final ScheduledExecutorService f;
    public final b0 h;
    public final Map e = new s.a();
    public boolean g = false;

    public d0(FirebaseMessaging firebaseMessaging, I i2, b0 b0Var, D d, Context context, ScheduledExecutorService scheduledExecutorService) {
        this.d = firebaseMessaging;
        this.b = i2;
        this.h = b0Var;
        this.c = d;
        this.a = context;
        this.f = scheduledExecutorService;
    }

    public static void b(Task task) {
        try {
            Tasks.await(task, 30L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e = e;
            throw new IOException("SERVICE_NOT_AVAILABLE", e);
        } catch (TimeoutException e2) {
            e = e2;
            throw new IOException("SERVICE_NOT_AVAILABLE", e);
        } catch (ExecutionException e3) {
            RuntimeException cause = e3.getCause();
            if (cause instanceof IOException) {
                throw ((IOException) cause);
            }
            if (!(cause instanceof RuntimeException)) {
                throw new IOException(e3);
            }
            throw cause;
        }
    }

    public static Task e(FirebaseMessaging firebaseMessaging, I i2, D d, Context context, ScheduledExecutorService scheduledExecutorService) {
        return Tasks.call(scheduledExecutorService, new c0(context, scheduledExecutorService, firebaseMessaging, i2, d));
    }

    public static boolean g() {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            return true;
        }
        return Build.VERSION.SDK_INT == 23 && Log.isLoggable("FirebaseMessaging", 3);
    }

    public static /* synthetic */ d0 i(Context context, ScheduledExecutorService scheduledExecutorService, FirebaseMessaging firebaseMessaging, I i2, D d) {
        return new d0(firebaseMessaging, i2, b0.b(context, scheduledExecutorService), d, context, scheduledExecutorService);
    }

    public final void a(a0 a0Var, TaskCompletionSource taskCompletionSource) {
        ArrayDeque arrayDeque;
        synchronized (this.e) {
            try {
                String e = a0Var.e();
                if (this.e.containsKey(e)) {
                    arrayDeque = (ArrayDeque) this.e.get(e);
                } else {
                    ArrayDeque arrayDeque2 = new ArrayDeque();
                    this.e.put(e, arrayDeque2);
                    arrayDeque = arrayDeque2;
                }
                arrayDeque.add(taskCompletionSource);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void c(String str) {
        b(this.c.j(this.d.c(), str));
    }

    public final void d(String str) {
        b(this.c.k(this.d.c(), str));
    }

    public boolean f() {
        return this.h.c() != null;
    }

    public synchronized boolean h() {
        return this.g;
    }

    public final void j(a0 a0Var) {
        synchronized (this.e) {
            try {
                String e = a0Var.e();
                if (this.e.containsKey(e)) {
                    ArrayDeque arrayDeque = (ArrayDeque) this.e.get(e);
                    TaskCompletionSource taskCompletionSource = (TaskCompletionSource) arrayDeque.poll();
                    if (taskCompletionSource != null) {
                        taskCompletionSource.setResult(null);
                    }
                    if (arrayDeque.isEmpty()) {
                        this.e.remove(e);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean k(q6.a0 r7) {
        /*
            Method dump skipped, instructions count: 264
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: q6.d0.k(q6.a0):boolean");
    }

    public void l(Runnable runnable, long j) {
        this.f.schedule(runnable, j, TimeUnit.SECONDS);
    }

    public Task m(a0 a0Var) {
        this.h.a(a0Var);
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        a(a0Var, taskCompletionSource);
        return taskCompletionSource.getTask();
    }

    public synchronized void n(boolean z) {
        this.g = z;
    }

    public final void o() {
        if (h()) {
            return;
        }
        s(0L);
    }

    public void p() {
        if (f()) {
            o();
        }
    }

    public Task q(String str) {
        Task m = m(a0.f(str));
        p();
        return m;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x000d, code lost:
    
        if (g() == false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x000f, code lost:
    
        android.util.Log.d("FirebaseMessaging", "topic sync succeeded");
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x001a, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean r() {
        /*
            r2 = this;
        L0:
            monitor-enter(r2)
            q6.b0 r0 = r2.h     // Catch: java.lang.Throwable -> L17
            q6.a0 r0 = r0.c()     // Catch: java.lang.Throwable -> L17
            if (r0 != 0) goto L1c
            boolean r0 = g()     // Catch: java.lang.Throwable -> L17
            if (r0 == 0) goto L19
            java.lang.String r0 = "FirebaseMessaging"
            java.lang.String r1 = "topic sync succeeded"
            android.util.Log.d(r0, r1)     // Catch: java.lang.Throwable -> L17
            goto L19
        L17:
            r0 = move-exception
            goto L2e
        L19:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L17
            r0 = 1
            return r0
        L1c:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L17
            boolean r1 = r2.k(r0)
            if (r1 != 0) goto L25
            r0 = 0
            return r0
        L25:
            q6.b0 r1 = r2.h
            r1.e(r0)
            r2.j(r0)
            goto L0
        L2e:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L17
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: q6.d0.r():boolean");
    }

    public void s(long j) {
        l(new e0(this, this.a, this.b, Math.min(Math.max(30L, j + j), i)), j);
        n(true);
    }
}
