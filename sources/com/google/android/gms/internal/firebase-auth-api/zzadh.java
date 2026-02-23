package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.Executor;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class zzadh {
    zzacg zza;
    Executor zzb;

    public final Task zza(zzadj zzadjVar) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.zzb.execute(new zzadg(this, zzadjVar, taskCompletionSource));
        return taskCompletionSource.getTask();
    }
}
