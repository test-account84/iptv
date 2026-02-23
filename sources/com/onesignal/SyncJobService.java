package com.onesignal;

import android.app.job.JobParameters;
import android.app.job.JobService;
import com.onesignal.F1;
import com.onesignal.o1;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class SyncJobService extends JobService {
    public boolean onStartJob(JobParameters jobParameters) {
        o1.q().b(this, new o1.b(this, jobParameters));
        return true;
    }

    public boolean onStopJob(JobParameters jobParameters) {
        boolean l = o1.q().l();
        F1.a(F1.v.DEBUG, "SyncJobService onStopJob called, system conditions not available reschedule: " + l);
        return l;
    }
}
