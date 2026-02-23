package q6;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import java.util.concurrent.TimeUnit;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class f0 {
    public static final long a = TimeUnit.MINUTES.toMillis(1);
    public static final Object b = new Object();
    public static Q4.a c;

    public static void a(Context context) {
        if (c == null) {
            Q4.a aVar = new Q4.a(context, 1, "wake:com.google.firebase.iid.WakeLockHolder");
            c = aVar;
            aVar.d(true);
        }
    }

    public static void b(Intent intent) {
        synchronized (b) {
            try {
                if (c != null && c(intent)) {
                    d(intent, false);
                    c.c();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean c(Intent intent) {
        return intent.getBooleanExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", false);
    }

    public static void d(Intent intent, boolean z) {
        intent.putExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", z);
    }

    public static ComponentName e(Context context, Intent intent) {
        synchronized (b) {
            try {
                a(context);
                boolean c2 = c(intent);
                d(intent, true);
                ComponentName startService = context.startService(intent);
                if (startService == null) {
                    return null;
                }
                if (!c2) {
                    c.a(a);
                }
                return startService;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
