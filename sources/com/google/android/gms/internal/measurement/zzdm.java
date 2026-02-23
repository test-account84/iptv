package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.r;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzdm extends zzdu {
    final /* synthetic */ zzbz zza;
    final /* synthetic */ int zzb;
    final /* synthetic */ zzef zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzdm(zzef zzefVar, zzbz zzbzVar, int i) {
        super(zzefVar, true);
        this.zzc = zzefVar;
        this.zza = zzbzVar;
        this.zzb = i;
    }

    public final void zza() throws RemoteException {
        ((zzcc) r.m(zzef.zze(this.zzc))).getTestFlag(this.zza, this.zzb);
    }

    public final void zzb() {
        this.zza.zze(null);
    }
}
