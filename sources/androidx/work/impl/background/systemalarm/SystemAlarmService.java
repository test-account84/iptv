package androidx.work.impl.background.systemalarm;

import Q0.k;
import a1.n;
import android.content.Intent;
import androidx.lifecycle.r;
import androidx.work.impl.background.systemalarm.d;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class SystemAlarmService extends r implements d.c {
    public static final String e = k.f("SystemAlarmService");
    public d c;
    public boolean d;

    public void b() {
        this.d = true;
        k.c().a(e, "All commands completed in dispatcher", new Throwable[0]);
        n.a();
        stopSelf();
    }

    public final void e() {
        d dVar = new d(this);
        this.c = dVar;
        dVar.m(this);
    }

    public void onCreate() {
        super.onCreate();
        e();
        this.d = false;
    }

    public void onDestroy() {
        super.onDestroy();
        this.d = true;
        this.c.j();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        if (this.d) {
            k.c().d(e, "Re-initializing SystemAlarmDispatcher after a request to shut-down.", new Throwable[0]);
            this.c.j();
            e();
            this.d = false;
        }
        if (intent == null) {
            return 3;
        }
        this.c.a(intent, i2);
        return 3;
    }
}
