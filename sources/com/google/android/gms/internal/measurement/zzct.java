package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.r;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzct extends zzdu {
    final /* synthetic */ Bundle zza;
    final /* synthetic */ zzef zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzct(zzef zzefVar, Bundle bundle) {
        super(zzefVar, true);
        this.zzb = zzefVar;
        this.zza = bundle;
    }

    public final void zza() throws RemoteException {
        ((zzcc) r.m(zzef.zze(this.zzb))).setConsent(this.zza, this.zzh);
    }
}
