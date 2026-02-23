package com.google.android.gms.internal.cast;

import android.app.Activity;
import com.google.android.gms.cast.framework.internal.featurehighlight.g;
import com.google.android.gms.cast.framework.internal.featurehighlight.h;
import o4.W;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzaq implements g {
    final /* synthetic */ Activity zza;
    final /* synthetic */ h zzb;
    final /* synthetic */ zzar zzc;

    public zzaq(zzar zzarVar, Activity activity, h hVar) {
        this.zzc = zzarVar;
        this.zza = activity;
        this.zzb = hVar;
    }

    public final void zza() {
        if (zzar.zzc(this.zzc)) {
            W.a(this.zza);
            this.zzb.h(new zzao(this, this.zza));
        }
    }

    public final void zzb() {
        if (zzar.zzc(this.zzc)) {
            W.a(this.zza);
            this.zzb.g(new zzap(this, this.zza));
        }
    }
}
