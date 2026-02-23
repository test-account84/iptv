package com.google.android.gms.tasks;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class TaskCompletionSource {
    private final zzw zza = new zzw();

    public TaskCompletionSource() {
    }

    public static /* bridge */ /* synthetic */ zzw zza(TaskCompletionSource taskCompletionSource) {
        return taskCompletionSource.zza;
    }

    public Task getTask() {
        return this.zza;
    }

    public void setException(Exception exc) {
        this.zza.zza(exc);
    }

    public void setResult(Object obj) {
        this.zza.zzb(obj);
    }

    public boolean trySetException(Exception exc) {
        return this.zza.zzd(exc);
    }

    public boolean trySetResult(Object obj) {
        return this.zza.zze(obj);
    }

    public TaskCompletionSource(CancellationToken cancellationToken) {
        cancellationToken.onCanceledRequested(new zzs(this));
    }
}
