package com.google.android.gms.tasks;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzo implements Runnable {
    final /* synthetic */ Task zza;
    final /* synthetic */ zzp zzb;

    public zzo(zzp zzpVar, Task task) {
        this.zzb = zzpVar;
        this.zza = task;
    }

    public final void run() {
        try {
            Task then = zzp.zza(this.zzb).then(this.zza.getResult());
            if (then == null) {
                this.zzb.onFailure(new NullPointerException("Continuation returned null"));
                return;
            }
            zzp zzpVar = this.zzb;
            Executor executor = TaskExecutors.zza;
            then.addOnSuccessListener(executor, zzpVar);
            then.addOnFailureListener(executor, this.zzb);
            then.addOnCanceledListener(executor, this.zzb);
        } catch (Exception e) {
            this.zzb.onFailure(e);
        } catch (RuntimeExecutionException e2) {
            if (e2.getCause() instanceof Exception) {
                this.zzb.onFailure((Exception) e2.getCause());
            } else {
                this.zzb.onFailure(e2);
            }
        } catch (CancellationException unused) {
            this.zzb.onCanceled();
        }
    }
}
