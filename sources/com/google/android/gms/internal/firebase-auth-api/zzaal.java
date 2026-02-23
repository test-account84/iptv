package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.tasks.TaskCompletionSource;
import d.D;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzaal extends zzacx {
    public zzaal() {
        super(5);
    }

    public final String zza() {
        return "delete";
    }

    public final void zzb() {
        D.a(this.zze);
        throw null;
    }

    public final void zza(TaskCompletionSource taskCompletionSource, zzacg zzacgVar) {
        this.zzg = new zzade(this, taskCompletionSource);
        zzacgVar.zza(this.zzd.zze(), this.zzb);
    }
}
