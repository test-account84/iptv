package com.google.android.gms.internal.firebase-auth-api;

import G5.g;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.FirebaseAuth;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzade implements zzacv {
    private final zzacx zza;
    private final TaskCompletionSource zzb;

    public zzade(zzacx zzacxVar, TaskCompletionSource taskCompletionSource) {
        this.zza = zzacxVar;
        this.zzb = taskCompletionSource;
    }

    public final void zza(Object obj, Status status) {
        r.n(this.zzb, "completion source cannot be null");
        if (status == null) {
            this.zzb.setResult(obj);
            return;
        }
        zzacx zzacxVar = this.zza;
        if (zzacxVar.zzs != null) {
            TaskCompletionSource taskCompletionSource = this.zzb;
            FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(zzacxVar.zzc);
            zzacx zzacxVar2 = this.zza;
            taskCompletionSource.setException(zzacf.zza(firebaseAuth, zzacxVar2.zzs, ("reauthenticateWithCredential".equals(zzacxVar2.zza()) || "reauthenticateWithCredentialWithData".equals(this.zza.zza())) ? this.zza.zzd : null));
            return;
        }
        g gVar = zzacxVar.zzp;
        if (gVar != null) {
            this.zzb.setException(zzacf.zza(status, gVar, zzacxVar.zzq, zzacxVar.zzr));
        } else {
            this.zzb.setException(zzacf.zza(status));
        }
    }
}
