package q6;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.ExecutorService;
import q6.i0;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class h extends Service {
    public Binder c;
    public int e;
    public final ExecutorService a = o.b();
    public final Object d = new Object();
    public int f = 0;

    public class a implements i0.a {
        public a() {
        }

        public Task a(Intent intent) {
            return h.a(h.this, intent);
        }
    }

    public static /* bridge */ /* synthetic */ Task a(h hVar, Intent intent) {
        return hVar.h(intent);
    }

    public final void b(Intent intent) {
        if (intent != null) {
            f0.b(intent);
        }
        synchronized (this.d) {
            try {
                int i = this.f - 1;
                this.f = i;
                if (i == 0) {
                    i(this.e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public abstract Intent c(Intent intent);

    public abstract void d(Intent intent);

    public boolean e(Intent intent) {
        return false;
    }

    public /* synthetic */ void f(Intent intent, Task task) {
        b(intent);
    }

    public /* synthetic */ void g(Intent intent, TaskCompletionSource taskCompletionSource) {
        try {
            d(intent);
        } finally {
            taskCompletionSource.setResult(null);
        }
    }

    public final Task h(Intent intent) {
        if (e(intent)) {
            return Tasks.forResult(null);
        }
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.a.execute(new f(this, intent, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    public boolean i(int i) {
        return stopSelfResult(i);
    }

    public final synchronized IBinder onBind(Intent intent) {
        try {
            if (Log.isLoggable("EnhancedIntentService", 3)) {
                Log.d("EnhancedIntentService", "Service received bind request");
            }
            if (this.c == null) {
                this.c = new i0(new a());
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.c;
    }

    public void onDestroy() {
        this.a.shutdown();
        super.onDestroy();
    }

    public final int onStartCommand(Intent intent, int i, int i2) {
        synchronized (this.d) {
            this.e = i2;
            this.f++;
        }
        Intent c = c(intent);
        if (c == null) {
            b(intent);
            return 2;
        }
        Task h = h(c);
        if (h.isComplete()) {
            b(intent);
            return 2;
        }
        h.addOnCompleteListener(g.a, new e(this, intent));
        return 3;
    }
}
