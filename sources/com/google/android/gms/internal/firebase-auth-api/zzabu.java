package com.google.android.gms.internal.firebase-auth-api;

import H5.T;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzabu extends zzacx {
    private final String zzaa;
    private final String zzy;
    private final String zzz;

    public zzabu(String str, String str2, String str3) {
        super(2);
        this.zzy = r.g(str);
        this.zzz = r.g(str2);
        this.zzaa = str3;
    }

    public final String zza() {
        return "unenrollMfa";
    }

    public final void zzb() {
        ((T) this.zze).a(this.zzj, zzaai.zza(this.zzc, this.zzk));
        zzb(null);
    }

    public final void zza(TaskCompletionSource taskCompletionSource, zzacg zzacgVar) {
        this.zzg = new zzade(this, taskCompletionSource);
        zzacgVar.zza(this.zzy, this.zzz, this.zzaa, this.zzb);
    }
}
