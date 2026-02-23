package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.r;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzdf extends zzdu {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ boolean zzc;
    final /* synthetic */ zzbz zzd;
    final /* synthetic */ zzef zze;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzdf(zzef zzefVar, String str, String str2, boolean z, zzbz zzbzVar) {
        super(zzefVar, true);
        this.zze = zzefVar;
        this.zza = str;
        this.zzb = str2;
        this.zzc = z;
        this.zzd = zzbzVar;
    }

    public final void zza() throws RemoteException {
        ((zzcc) r.m(zzef.zze(this.zze))).getUserProperties(this.zza, this.zzb, this.zzc, this.zzd);
    }

    public final void zzb() {
        this.zzd.zze(null);
    }
}
