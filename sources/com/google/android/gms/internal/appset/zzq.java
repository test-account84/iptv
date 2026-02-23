package com.google.android.gms.internal.appset;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class zzq implements Continuation {
    public final /* synthetic */ zzr zza;

    public /* synthetic */ zzq(zzr zzrVar) {
        this.zza = zzrVar;
    }

    public final Object then(Task task) {
        return zzr.zza(this.zza, task);
    }
}
