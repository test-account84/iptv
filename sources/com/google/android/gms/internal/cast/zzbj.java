package com.google.android.gms.internal.cast;

import com.google.android.gms.tasks.OnFailureListener;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class zzbj implements OnFailureListener {
    public final /* synthetic */ zzbm zza;

    public /* synthetic */ zzbj(zzbm zzbmVar) {
        this.zza = zzbmVar;
    }

    public final void onFailure(Exception exc) {
        this.zza.zzk(exc);
    }
}
