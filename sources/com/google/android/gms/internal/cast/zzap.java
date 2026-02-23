package com.google.android.gms.internal.cast;

import android.app.Activity;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class zzap implements Runnable {
    public final /* synthetic */ zzaq zza;
    public final /* synthetic */ Activity zzb;

    public /* synthetic */ zzap(zzaq zzaqVar, Activity activity) {
        this.zza = zzaqVar;
        this.zzb = activity;
    }

    public final void run() {
        zzaq zzaqVar = this.zza;
        Activity activity = this.zzb;
        if (zzar.zzc(zzaqVar.zzc)) {
            activity.getWindow().getDecorView().removeView(zzaqVar.zzc);
            zzar.zza(zzaqVar.zzc);
            zzar.zzb(zzaqVar.zzc);
        }
    }
}
