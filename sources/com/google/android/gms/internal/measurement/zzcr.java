package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.common.internal.r;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzcr extends zzdu {
    final /* synthetic */ Activity zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ zzef zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzcr(zzef zzefVar, Activity activity, String str, String str2) {
        super(zzefVar, true);
        this.zzd = zzefVar;
        this.zza = activity;
        this.zzb = str;
        this.zzc = str2;
    }

    public final void zza() throws RemoteException {
        ((zzcc) r.m(zzef.zze(this.zzd))).setCurrentScreen(F4.b.Z(this.zza), this.zzb, this.zzc, this.zzh);
    }
}
