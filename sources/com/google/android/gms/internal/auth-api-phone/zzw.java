package com.google.android.gms.internal.auth-api-phone;

import com.google.android.gms.common.api.internal.q;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final /* synthetic */ class zzw implements q {
    private final zzu zza;
    private final String zzb;

    public zzw(zzu zzuVar, String str) {
        this.zza = zzuVar;
        this.zzb = str;
    }

    public final void accept(Object obj, Object obj2) {
        zzu zzuVar = this.zza;
        ((zzj) ((zzv) obj).getService()).zza(this.zzb, new zzy(zzuVar, (TaskCompletionSource) obj2));
    }
}
