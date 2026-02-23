package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.r;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzdt extends zzdu {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ Object zzc;
    final /* synthetic */ boolean zzd;
    final /* synthetic */ zzef zze;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzdt(zzef zzefVar, String str, String str2, Object obj, boolean z) {
        super(zzefVar, true);
        this.zze = zzefVar;
        this.zza = str;
        this.zzb = str2;
        this.zzc = obj;
        this.zzd = z;
    }

    public final void zza() throws RemoteException {
        ((zzcc) r.m(zzef.zze(this.zze))).setUserProperty(this.zza, this.zzb, F4.b.Z(this.zzc), this.zzd, this.zzh);
    }
}
