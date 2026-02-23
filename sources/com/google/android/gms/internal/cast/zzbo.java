package com.google.android.gms.internal.cast;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.b;
import com.google.android.gms.tasks.OnFailureListener;
import o4.e;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class zzbo implements OnFailureListener {
    public final /* synthetic */ zzbp zza;
    public final /* synthetic */ zzbq zzb;

    public /* synthetic */ zzbo(zzbp zzbpVar, zzbq zzbqVar) {
        this.zza = zzbpVar;
        this.zzb = zzbqVar;
    }

    public final void onFailure(Exception exc) {
        zzbp zzbpVar = this.zza;
        Status status = new Status(8, "unknown error");
        if (exc instanceof b) {
            b bVar = (b) exc;
            status = new Status(bVar.getStatusCode(), bVar.getMessage());
        }
        t4.b bVar2 = e.o;
        zzbpVar.setResult(status);
    }
}
