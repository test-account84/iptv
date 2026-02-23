package com.google.android.gms.internal.cast;

import android.annotation.TargetApi;
import android.view.Choreographer;

@TargetApi(16)
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzeh extends zzei {
    private final Choreographer zza = Choreographer.getInstance();

    public final void zza(zzef zzefVar) {
        this.zza.postFrameCallback(zzefVar.zzb());
    }
}
