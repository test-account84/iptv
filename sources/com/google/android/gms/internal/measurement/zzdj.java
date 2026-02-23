package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.r;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzdj extends zzdu {
    final /* synthetic */ String zza;
    final /* synthetic */ zzbz zzb;
    final /* synthetic */ zzef zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzdj(zzef zzefVar, String str, zzbz zzbzVar) {
        super(zzefVar, true);
        this.zzc = zzefVar;
        this.zza = str;
        this.zzb = zzbzVar;
    }

    public final void zza() throws RemoteException {
        ((zzcc) r.m(zzef.zze(this.zzc))).getMaxUserProperties(this.zza, this.zzb);
    }

    public final void zzb() {
        this.zzb.zze(null);
    }
}
