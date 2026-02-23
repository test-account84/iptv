package com.google.android.gms.internal.cast;

import android.os.Handler;
import android.os.Looper;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzeg extends zzei {
    private final Handler zza;

    public zzeg(Looper looper) {
        this.zza = new Handler(looper);
    }

    public final void zza(zzef zzefVar) {
        this.zza.postDelayed(zzefVar.zzc(), 0L);
    }
}
