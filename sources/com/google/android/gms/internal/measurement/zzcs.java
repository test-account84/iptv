package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.r;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzcs extends zzdu {
    final /* synthetic */ Boolean zza;
    final /* synthetic */ zzef zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzcs(zzef zzefVar, Boolean bool) {
        super(zzefVar, true);
        this.zzb = zzefVar;
        this.zza = bool;
    }

    public final void zza() throws RemoteException {
        if (this.zza != null) {
            ((zzcc) r.m(zzef.zze(this.zzb))).setMeasurementEnabled(this.zza.booleanValue(), this.zzh);
        } else {
            ((zzcc) r.m(zzef.zze(this.zzb))).clearMeasurementEnabled(this.zzh);
        }
    }
}
