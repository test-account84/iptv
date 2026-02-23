package com.google.android.gms.internal.firebase-auth-api;

import G5.A;
import G5.u;
import H5.T;
import H5.d0;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.tasks.TaskCompletionSource;
import d.D;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzaaq extends zzacx {
    private final String zzaa;
    private final A zzy;
    private final String zzz;

    public zzaaq(A a, String str, String str2) {
        super(2);
        D.a(r.m(a));
        this.zzz = r.g(str);
        this.zzaa = str2;
    }

    public final String zza() {
        return "finalizeMfaSignIn";
    }

    public final void zzb() {
        H5.b zza = zzaai.zza(this.zzc, this.zzk);
        u uVar = this.zzd;
        if (uVar != null && !uVar.L().equalsIgnoreCase(zza.L())) {
            zza(new Status(17024));
        } else {
            ((T) this.zze).a(this.zzj, zza);
            zzb(new d0(zza));
        }
    }

    public final void zza(TaskCompletionSource taskCompletionSource, zzacg zzacgVar) {
        this.zzg = new zzade(this, taskCompletionSource);
        zzacgVar.zza(this.zzz, (A) null, this.zzaa, this.zzb);
    }
}
