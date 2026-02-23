package androidx.work.impl.foreground;

import Q0.k;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.r;
import androidx.work.impl.foreground.a;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class SystemForegroundService extends r implements a.b {
    public static final String g = k.f("SystemFgService");
    public static SystemForegroundService h = null;
    public Handler c;
    public boolean d;
    public androidx.work.impl.foreground.a e;
    public NotificationManager f;

    public class a implements Runnable {
        public final /* synthetic */ int a;
        public final /* synthetic */ Notification c;
        public final /* synthetic */ int d;

        public a(int i, Notification notification, int i2) {
            this.a = i;
            this.c = notification;
            this.d = i2;
        }

        public void run() {
            if (Build.VERSION.SDK_INT >= 29) {
                Y0.b.a(SystemForegroundService.this, this.a, this.c, this.d);
            } else {
                SystemForegroundService.this.startForeground(this.a, this.c);
            }
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ int a;
        public final /* synthetic */ Notification c;

        public b(int i, Notification notification) {
            this.a = i;
            this.c = notification;
        }

        public void run() {
            SystemForegroundService.this.f.notify(this.a, this.c);
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ int a;

        public c(int i) {
            this.a = i;
        }

        public void run() {
            SystemForegroundService.this.f.cancel(this.a);
        }
    }

    private void e() {
        this.c = new Handler(Looper.getMainLooper());
        this.f = (NotificationManager) getApplicationContext().getSystemService("notification");
        androidx.work.impl.foreground.a aVar = new androidx.work.impl.foreground.a(getApplicationContext());
        this.e = aVar;
        aVar.m(this);
    }

    public void a(int i, Notification notification) {
        this.c.post(new b(i, notification));
    }

    public void c(int i, int i2, Notification notification) {
        this.c.post(new a(i, notification, i2));
    }

    public void d(int i) {
        this.c.post(new c(i));
    }

    public void onCreate() {
        super.onCreate();
        h = this;
        e();
    }

    public void onDestroy() {
        super.onDestroy();
        this.e.k();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        if (this.d) {
            k.c().d(g, "Re-initializing SystemForegroundService after a request to shut-down.", new Throwable[0]);
            this.e.k();
            e();
            this.d = false;
        }
        if (intent == null) {
            return 3;
        }
        this.e.l(intent);
        return 3;
    }

    public void stop() {
        this.d = true;
        k.c().a(g, "All commands completed.", new Throwable[0]);
        if (Build.VERSION.SDK_INT >= 26) {
            stopForeground(true);
        }
        h = null;
        stopSelf();
    }
}
