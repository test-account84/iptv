package q6;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class l0 implements ServiceConnection {
    public final Context a;
    public final Intent c;
    public final ScheduledExecutorService d;
    public final Queue e;
    public i0 f;
    public boolean g;

    public static class a {
        public final Intent a;
        public final TaskCompletionSource b = new TaskCompletionSource();

        public a(Intent intent) {
            this.a = intent;
        }

        public static /* synthetic */ void e(ScheduledFuture scheduledFuture, Task task) {
            scheduledFuture.cancel(false);
        }

        public void a(ScheduledExecutorService scheduledExecutorService) {
            c().addOnCompleteListener((Executor) scheduledExecutorService, (OnCompleteListener) new j0(scheduledExecutorService.schedule(new k0(this), 9000L, TimeUnit.MILLISECONDS)));
        }

        public void b() {
            this.b.trySetResult(null);
        }

        public Task c() {
            return this.b.getTask();
        }

        public /* synthetic */ void d() {
            String action = this.a.getAction();
            StringBuilder sb = new StringBuilder(String.valueOf(action).length() + 61);
            sb.append("Service took too long to process intent: ");
            sb.append(action);
            sb.append(" App may get closed.");
            Log.w("FirebaseMessaging", sb.toString());
            b();
        }
    }

    public l0(Context context, String str) {
        this(context, "com.google.firebase.MESSAGING_EVENT", new ScheduledThreadPoolExecutor(0, new D4.b("Firebase-FirebaseInstanceIdServiceConnection")));
    }

    public final void a() {
        while (!this.e.isEmpty()) {
            ((a) this.e.poll()).b();
        }
    }

    public final synchronized void b() {
        try {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "flush queue called");
            }
            while (!this.e.isEmpty()) {
                if (Log.isLoggable("FirebaseMessaging", 3)) {
                    Log.d("FirebaseMessaging", "found intent to be delivered");
                }
                i0 i0Var = this.f;
                if (i0Var == null || !i0Var.isBinderAlive()) {
                    d();
                    return;
                }
                if (Log.isLoggable("FirebaseMessaging", 3)) {
                    Log.d("FirebaseMessaging", "binder is alive, sending the intent.");
                }
                this.f.b((a) this.e.poll());
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized Task c(Intent intent) {
        a aVar;
        try {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "new intent queued in the bind-strategy delivery");
            }
            aVar = new a(intent);
            aVar.a(this.d);
            this.e.add(aVar);
            b();
        } catch (Throwable th) {
            throw th;
        }
        return aVar.c();
    }

    public final void d() {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            boolean z = this.g;
            StringBuilder sb = new StringBuilder(39);
            sb.append("binder is dead. start connection? ");
            sb.append(!z);
            Log.d("FirebaseMessaging", sb.toString());
        }
        if (this.g) {
            return;
        }
        this.g = true;
        try {
        } catch (SecurityException e) {
            Log.e("FirebaseMessaging", "Exception while binding the service", e);
        }
        if (B4.b.b().a(this.a, this.c, this, 65)) {
            return;
        }
        Log.e("FirebaseMessaging", "binding to the service failed");
        this.g = false;
        a();
    }

    public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "onServiceConnected: ".concat(String.valueOf(componentName)));
            }
            this.g = false;
            if (iBinder instanceof i0) {
                this.f = (i0) iBinder;
                b();
            } else {
                Log.e("FirebaseMessaging", "Invalid service connection: ".concat(String.valueOf(iBinder)));
                a();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "onServiceDisconnected: ".concat(String.valueOf(componentName)));
        }
        b();
    }

    public l0(Context context, String str, ScheduledExecutorService scheduledExecutorService) {
        this.e = new ArrayDeque();
        this.g = false;
        Context applicationContext = context.getApplicationContext();
        this.a = applicationContext;
        this.c = new Intent("com.google.firebase.MESSAGING_EVENT").setPackage(applicationContext.getPackageName());
        this.d = scheduledExecutorService;
    }
}
