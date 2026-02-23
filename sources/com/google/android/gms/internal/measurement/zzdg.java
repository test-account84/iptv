package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.r;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzdg extends zzdu {
    final /* synthetic */ String zza;
    final /* synthetic */ Object zzb;
    final /* synthetic */ zzef zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzdg(zzef zzefVar, boolean z, int i, String str, Object obj, Object obj2, Object obj3) {
        super(zzefVar, false);
        this.zzc = zzefVar;
        this.zza = str;
        this.zzb = obj;
    }

    public final void zza() throws RemoteException {
        ((zzcc) r.m(zzef.zze(this.zzc))).logHealthData(5, this.zza, F4.b.Z(this.zzb), F4.b.Z(null), F4.b.Z(null));
    }
}
