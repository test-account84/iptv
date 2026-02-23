package v4;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.internal.cloudmessaging.zze;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class w {
    public static w e;
    public final Context a;
    public final ScheduledExecutorService b;
    public q c = new q(this, null);
    public int d = 1;

    public w(Context context, ScheduledExecutorService scheduledExecutorService) {
        this.b = scheduledExecutorService;
        this.a = context.getApplicationContext();
    }

    public static /* bridge */ /* synthetic */ Context a(w wVar) {
        return wVar.a;
    }

    public static synchronized w b(Context context) {
        w wVar;
        synchronized (w.class) {
            try {
                if (e == null) {
                    zze.zza();
                    e = new w(context, Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1, new D4.b("MessengerIpcClient"))));
                }
                wVar = e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return wVar;
    }

    public static /* bridge */ /* synthetic */ ScheduledExecutorService e(w wVar) {
        return wVar.b;
    }

    public final Task c(int i, Bundle bundle) {
        return g(new s(f(), 2, bundle));
    }

    public final Task d(int i, Bundle bundle) {
        return g(new v(f(), 1, bundle));
    }

    public final synchronized int f() {
        int i;
        i = this.d;
        this.d = i + 1;
        return i;
    }

    public final synchronized Task g(t tVar) {
        try {
            if (Log.isLoggable("MessengerIpcClient", 3)) {
                String valueOf = String.valueOf(tVar);
                StringBuilder sb = new StringBuilder(valueOf.length() + 9);
                sb.append("Queueing ");
                sb.append(valueOf);
                Log.d("MessengerIpcClient", sb.toString());
            }
            if (!this.c.g(tVar)) {
                q qVar = new q(this, null);
                this.c = qVar;
                qVar.g(tVar);
            }
        } catch (Throwable th) {
            throw th;
        }
        return tVar.b.getTask();
    }
}
