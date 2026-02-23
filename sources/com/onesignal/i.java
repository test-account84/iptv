package com.onesignal;

import android.app.job.JobParameters;
import android.app.job.JobWorkItem;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract /* synthetic */ class I {
    public static /* bridge */ /* synthetic */ JobWorkItem a(JobParameters jobParameters) {
        return jobParameters.dequeueWork();
    }
}
