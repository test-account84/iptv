package com.onesignal;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.app.job.JobWorkItem;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract /* synthetic */ class M {
    public static /* bridge */ /* synthetic */ int a(JobScheduler jobScheduler, JobInfo jobInfo, JobWorkItem jobWorkItem) {
        return jobScheduler.enqueue(jobInfo, jobWorkItem);
    }
}
