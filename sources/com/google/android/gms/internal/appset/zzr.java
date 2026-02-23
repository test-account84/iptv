package com.google.android.gms.internal.appset;

import android.content.Context;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import i4.b;
import w4.i;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzr implements b {
    private final b zza;
    private final b zzb;

    public zzr(Context context) {
        this.zza = new zzp(context, i.h());
        this.zzb = zzl.zzc(context);
    }

    public static /* synthetic */ Task zza(zzr zzrVar, Task task) {
        if (task.isSuccessful() || task.isCanceled()) {
            return task;
        }
        Exception exception = task.getException();
        if (!(exception instanceof com.google.android.gms.common.api.b)) {
            return task;
        }
        int statusCode = ((com.google.android.gms.common.api.b) exception).getStatusCode();
        return (statusCode == 43001 || statusCode == 43002 || statusCode == 43003 || statusCode == 17) ? zzrVar.zzb.getAppSetIdInfo() : statusCode == 43000 ? Tasks.forException(new Exception("Failed to get app set ID due to an internal error. Please try again later.")) : statusCode != 15 ? task : Tasks.forException(new Exception("The operation to get app set ID timed out. Please try again later."));
    }

    public final Task getAppSetIdInfo() {
        return this.zza.getAppSetIdInfo().continueWithTask(new zzq(this));
    }
}
