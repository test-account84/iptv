package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.r;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzdp extends zzdu {
    final /* synthetic */ zzdv zza;
    final /* synthetic */ zzef zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzdp(zzef zzefVar, zzdv zzdvVar) {
        super(zzefVar, true);
        this.zzb = zzefVar;
        this.zza = zzdvVar;
    }

    public final void zza() throws RemoteException {
        ((zzcc) r.m(zzef.zze(this.zzb))).setEventInterceptor(this.zza);
    }
}
