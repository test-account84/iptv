package com.google.android.gms.measurement;

import M4.p4;
import M4.q4;
import android.app.Service;
import android.app.job.JobParameters;
import android.content.Intent;
import android.os.IBinder;
import k0.a;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class AppMeasurementService extends Service implements p4 {
    public q4 a;

    private final q4 a() {
        if (this.a == null) {
            this.a = new q4(this);
        }
        return this.a;
    }

    public final boolean c(int i) {
        return stopSelfResult(i);
    }

    public final void d(Intent intent) {
        a.b(intent);
    }

    public final void e(JobParameters jobParameters, boolean z) {
        throw new UnsupportedOperationException();
    }

    public IBinder onBind(Intent intent) {
        return a().b(intent);
    }

    public void onCreate() {
        super.onCreate();
        a().e();
    }

    public void onDestroy() {
        a().f();
        super.onDestroy();
    }

    public void onRebind(Intent intent) {
        a().g(intent);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        a().a(intent, i, i2);
        return 2;
    }

    public boolean onUnbind(Intent intent) {
        a().j(intent);
        return true;
    }
}
