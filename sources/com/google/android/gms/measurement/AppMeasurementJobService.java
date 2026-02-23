package com.google.android.gms.measurement;

import M4.p4;
import M4.q4;
import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;

@TargetApi(24)
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class AppMeasurementJobService extends JobService implements p4 {
    public q4 a;

    public final q4 a() {
        if (this.a == null) {
            this.a = new q4(this);
        }
        return this.a;
    }

    public final boolean c(int i) {
        throw new UnsupportedOperationException();
    }

    public final void d(Intent intent) {
    }

    public final void e(JobParameters jobParameters, boolean z) {
        jobFinished(jobParameters, false);
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

    public boolean onStartJob(JobParameters jobParameters) {
        a().i(jobParameters);
        return true;
    }

    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

    public boolean onUnbind(Intent intent) {
        a().j(intent);
        return true;
    }
}
