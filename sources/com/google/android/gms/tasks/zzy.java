package com.google.android.gms.tasks;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class zzy implements OnCompleteListener {
    public final /* synthetic */ com.google.android.gms.internal.tasks.zza zza;
    public final /* synthetic */ TaskCompletionSource zzb;
    public final /* synthetic */ zzb zzc;

    public /* synthetic */ zzy(com.google.android.gms.internal.tasks.zza zzaVar, TaskCompletionSource taskCompletionSource, zzb zzbVar) {
        this.zza = zzaVar;
        this.zzb = taskCompletionSource;
        this.zzc = zzbVar;
    }

    public final void onComplete(Task task) {
        this.zza.removeCallbacksAndMessages((Object) null);
        TaskCompletionSource taskCompletionSource = this.zzb;
        if (task.isSuccessful()) {
            taskCompletionSource.trySetResult(task.getResult());
        } else {
            if (task.isCanceled()) {
                this.zzc.zza();
                return;
            }
            Exception exception = task.getException();
            exception.getClass();
            taskCompletionSource.trySetException(exception);
        }
    }
}
