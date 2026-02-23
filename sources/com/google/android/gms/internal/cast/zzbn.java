package com.google.android.gms.internal.cast;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.OnSuccessListener;
import o4.e;
import t4.b;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class zzbn implements OnSuccessListener {
    public final /* synthetic */ zzbp zza;
    public final /* synthetic */ zzbq zzb;

    public /* synthetic */ zzbn(zzbp zzbpVar, zzbq zzbqVar) {
        this.zza = zzbpVar;
        this.zzb = zzbqVar;
    }

    public final void onSuccess(Object obj) {
        zzbp zzbpVar = this.zza;
        b bVar = e.o;
        zzbpVar.setResult(new Status(0));
    }
}
