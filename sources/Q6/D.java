package q6;

import D.l;
import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.tasks.Tasks;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import q6.b;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class d {
    public final Executor a;
    public final Context b;
    public final J c;

    public d(Context context, J j, Executor executor) {
        this.a = executor;
        this.b = context;
        this.c = j;
    }

    public boolean a() {
        if (this.c.a("gcm.n.noui")) {
            return true;
        }
        if (b()) {
            return false;
        }
        F d = d();
        b.a e = b.e(this.b, this.c);
        e(e.a, d);
        c(e);
        return true;
    }

    public final boolean b() {
        if (((KeyguardManager) this.b.getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
            return false;
        }
        if (!C4.m.f()) {
            SystemClock.sleep(10L);
        }
        int myPid = Process.myPid();
        List runningAppProcesses = ((ActivityManager) this.b.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            Iterator it = runningAppProcesses.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ActivityManager.RunningAppProcessInfo runningAppProcessInfo = (ActivityManager.RunningAppProcessInfo) it.next();
                if (runningAppProcessInfo.pid == myPid) {
                    if (runningAppProcessInfo.importance == 100) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final void c(b.a aVar) {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Showing notification");
        }
        ((NotificationManager) this.b.getSystemService("notification")).notify(aVar.b, aVar.c, aVar.a.c());
    }

    public final F d() {
        F d = F.d(this.c.p("gcm.n.image"));
        if (d != null) {
            d.g(this.a);
        }
        return d;
    }

    public final void e(l.e eVar, F f) {
        if (f == null) {
            return;
        }
        try {
            Bitmap bitmap = (Bitmap) Tasks.await(f.e(), 5L, TimeUnit.SECONDS);
            eVar.u(bitmap);
            eVar.F(new l.b().i(bitmap).h((Bitmap) null));
        } catch (ExecutionException e) {
            Log.w("FirebaseMessaging", "Failed to download image: ".concat(String.valueOf(e.getCause())));
        } catch (TimeoutException unused) {
            Log.w("FirebaseMessaging", "Failed to download image in time, showing notification without it");
            f.close();
        } catch (InterruptedException unused2) {
            Log.w("FirebaseMessaging", "Interrupted while downloading image, showing notification without it");
            f.close();
            Thread.currentThread().interrupt();
        }
    }
}
