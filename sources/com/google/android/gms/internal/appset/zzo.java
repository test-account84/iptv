package com.google.android.gms.internal.appset;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.u;
import com.google.android.gms.tasks.TaskCompletionSource;
import i4.c;
import i4.f;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzo extends zze {
    final /* synthetic */ TaskCompletionSource zza;

    public zzo(zzp zzpVar, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    public final void zzb(Status status, f fVar) {
        u.b(status, fVar != null ? new c(fVar.I(), fVar.H()) : null, this.zza);
    }
}
