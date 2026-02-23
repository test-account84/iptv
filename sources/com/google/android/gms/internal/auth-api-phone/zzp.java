package com.google.android.gms.internal.auth-api-phone;

import com.google.android.gms.common.api.internal.q;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final /* synthetic */ class zzp implements q {
    private final zzn zza;

    public zzp(zzn zznVar) {
        this.zza = zznVar;
    }

    public final void accept(Object obj, Object obj2) {
        ((zzj) ((zzv) obj).getService()).zza(new zzt(this.zza, (TaskCompletionSource) obj2));
    }
}
