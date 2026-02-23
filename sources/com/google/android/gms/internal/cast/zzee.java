package com.google.android.gms.internal.cast;

import android.view.Choreographer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class zzee implements Choreographer.FrameCallback {
    public final /* synthetic */ zzef zza;

    public /* synthetic */ zzee(zzef zzefVar) {
        this.zza = zzefVar;
    }

    public final void doFrame(long j) {
        this.zza.zza(j);
    }
}
