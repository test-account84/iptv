package J2;

import android.app.job.JobParameters;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class e implements Runnable {
    public final /* synthetic */ JobInfoSchedulerService a;
    public final /* synthetic */ JobParameters c;

    public /* synthetic */ e(JobInfoSchedulerService jobInfoSchedulerService, JobParameters jobParameters) {
        this.a = jobInfoSchedulerService;
        this.c = jobParameters;
    }

    public final void run() {
        JobInfoSchedulerService.a(this.a, this.c);
    }
}
