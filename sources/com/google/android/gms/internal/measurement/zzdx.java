package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.r;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzdx extends zzdu {
    final /* synthetic */ Bundle zza;
    final /* synthetic */ Activity zzb;
    final /* synthetic */ zzee zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzdx(zzee zzeeVar, Bundle bundle, Activity activity) {
        super(zzeeVar.zza, true);
        this.zzc = zzeeVar;
        this.zza = bundle;
        this.zzb = activity;
    }

    public final void zza() throws RemoteException {
        Bundle bundle;
        if (this.zza != null) {
            bundle = new Bundle();
            if (this.zza.containsKey("com.google.app_measurement.screen_service")) {
                Object obj = this.zza.get("com.google.app_measurement.screen_service");
                if (obj instanceof Bundle) {
                    bundle.putBundle("com.google.app_measurement.screen_service", (Bundle) obj);
                }
            }
        } else {
            bundle = null;
        }
        ((zzcc) r.m(zzef.zze(this.zzc.zza))).onActivityCreated(F4.b.Z(this.zzb), bundle, this.zzi);
    }
}
