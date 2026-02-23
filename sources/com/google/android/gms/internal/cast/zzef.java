package com.google.android.gms.internal.cast;

import android.annotation.TargetApi;
import android.view.Choreographer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class zzef {
    private Runnable zza;
    private Choreographer.FrameCallback zzb;

    public abstract void zza(long j);

    @TargetApi(16)
    public final Choreographer.FrameCallback zzb() {
        if (this.zzb == null) {
            this.zzb = new zzee(this);
        }
        return this.zzb;
    }

    public final Runnable zzc() {
        if (this.zza == null) {
            this.zza = new zzed(this);
        }
        return this.zza;
    }
}
