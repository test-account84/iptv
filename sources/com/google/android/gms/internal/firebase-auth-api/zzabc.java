package com.google.android.gms.internal.firebase-auth-api;

import H5.T;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzabc extends zzacx {
    private final String zzaa;
    private final String zzab;
    private final String zzy;
    private final String zzz;

    public zzabc(String str, String str2, String str3, String str4) {
        super(2);
        r.h(str, "email cannot be null or empty");
        r.h(str2, "password cannot be null or empty");
        this.zzy = str;
        this.zzz = str2;
        this.zzaa = str3;
        this.zzab = str4;
    }

    public final String zza() {
        return "reauthenticateWithEmailPassword";
    }

    public final void zzb() {
        H5.b zza = zzaai.zza(this.zzc, this.zzk);
        if (!this.zzd.L().equalsIgnoreCase(zza.L())) {
            zza(new Status(17024));
        } else {
            ((T) this.zze).a(this.zzj, zza);
            zzb(null);
        }
    }

    public final void zza(TaskCompletionSource taskCompletionSource, zzacg zzacgVar) {
        this.zzg = new zzade(this, taskCompletionSource);
        zzacgVar.zzb(this.zzy, this.zzz, this.zzaa, this.zzab, this.zzb);
    }
}
