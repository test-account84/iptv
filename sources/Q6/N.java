package q6;

import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.Executor;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class n {
    public static final Object c = new Object();
    public static l0 d;
    public final Context a;
    public final Executor b = m.a;

    public n(Context context) {
        this.a = context;
    }

    public static Task a(Context context, Intent intent) {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Binding to service");
        }
        return b(context, "com.google.firebase.MESSAGING_EVENT").c(intent).continueWith(m.a, j.a);
    }

    public static l0 b(Context context, String str) {
        l0 l0Var;
        synchronized (c) {
            try {
                if (d == null) {
                    d = new l0(context, "com.google.firebase.MESSAGING_EVENT");
                }
                l0Var = d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return l0Var;
    }

    public static /* synthetic */ Integer c(Task task) {
        return -1;
    }

    public static /* synthetic */ Integer d(Context context, Intent intent) {
        return Integer.valueOf(W.b().g(context, intent));
    }

    public static /* synthetic */ Integer e(Task task) {
        return 403;
    }

    public static /* synthetic */ Task f(Context context, Intent intent, Task task) {
        return (C4.m.i() && ((Integer) task.getResult()).intValue() == 402) ? a(context, intent).continueWith(m.a, k.a) : task;
    }

    public Task g(Intent intent) {
        String stringExtra = intent.getStringExtra("gcm.rawData64");
        if (stringExtra != null) {
            intent.putExtra("rawData", Base64.decode(stringExtra, 0));
            intent.removeExtra("gcm.rawData64");
        }
        return h(this.a, intent);
    }

    public Task h(Context context, Intent intent) {
        boolean z = false;
        if (C4.m.i() && context.getApplicationInfo().targetSdkVersion >= 26) {
            z = true;
        }
        return (z && (intent.getFlags() & 268435456) == 0) ? a(context, intent) : Tasks.call(this.b, new l(context, intent)).continueWithTask(this.b, new i(context, intent));
    }
}
