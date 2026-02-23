package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.r;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzdh extends zzdu {
    final /* synthetic */ Bundle zza;
    final /* synthetic */ zzbz zzb;
    final /* synthetic */ zzef zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzdh(zzef zzefVar, Bundle bundle, zzbz zzbzVar) {
        super(zzefVar, true);
        this.zzc = zzefVar;
        this.zza = bundle;
        this.zzb = zzbzVar;
    }

    public final void zza() throws RemoteException {
        ((zzcc) r.m(zzef.zze(this.zzc))).performAction(this.zza, this.zzb, this.zzh);
    }

    public final void zzb() {
        this.zzb.zze(null);
    }
}
