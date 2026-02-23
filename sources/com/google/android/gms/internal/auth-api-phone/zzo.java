package com.google.android.gms.internal.auth-api-phone;

import com.google.android.gms.common.api.internal.q;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final /* synthetic */ class zzo implements q {
    private final zzn zza;
    private final String zzb;

    public zzo(zzn zznVar, String str) {
        this.zza = zznVar;
        this.zzb = str;
    }

    public final void accept(Object obj, Object obj2) {
        zzn zznVar = this.zza;
        ((zzj) ((zzv) obj).getService()).zza(this.zzb, new zzs(zznVar, (TaskCompletionSource) obj2));
    }
}
