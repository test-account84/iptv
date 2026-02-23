package com.google.android.gms.internal.firebase-auth-api;

import H5.T;
import H5.v;
import android.text.TextUtils;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzaap extends zzacx {
    private final String zzy;

    public zzaap(String str) {
        super(1);
        r.h(str, "refresh token cannot be null");
        this.zzy = str;
    }

    public final String zza() {
        return "getAccessToken";
    }

    public final void zzb() {
        if (TextUtils.isEmpty(this.zzj.zzd())) {
            this.zzj.zzc(this.zzy);
        }
        ((T) this.zze).a(this.zzj, this.zzd);
        zzb(v.a(this.zzj.zzc()));
    }

    public final void zza(TaskCompletionSource taskCompletionSource, zzacg zzacgVar) {
        this.zzg = new zzade(this, taskCompletionSource);
        zzacgVar.zzb(this.zzy, this.zzb);
    }
}
