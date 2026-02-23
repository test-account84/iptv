package com.google.android.gms.internal.firebase-auth-api;

import G5.h;
import H5.T;
import H5.d0;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzaau extends zzacx {
    private final h zzy;
    private final String zzz;

    public zzaau(h hVar, String str) {
        super(2);
        this.zzy = (h) r.n(hVar, "credential cannot be null");
        r.h(hVar.zzc(), "email cannot be null");
        r.h(hVar.zzd(), "password cannot be null");
        this.zzz = str;
    }

    public final String zza() {
        return "linkEmailAuthCredential";
    }

    public final void zzb() {
        H5.b zza = zzaai.zza(this.zzc, this.zzk);
        ((T) this.zze).a(this.zzj, zza);
        zzb(new d0(zza));
    }

    public final void zza(TaskCompletionSource taskCompletionSource, zzacg zzacgVar) {
        this.zzg = new zzade(this, taskCompletionSource);
        zzacgVar.zza(this.zzy.zzc(), r.g(this.zzy.zzd()), this.zzd.zze(), this.zzd.K(), this.zzz, this.zzb);
    }
}
