package com.google.android.gms.internal.cast;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.a;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzdf extends zzdk {
    final /* synthetic */ String zza;
    final /* synthetic */ zzdm zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzdf(zzdm zzdmVar, GoogleApiClient googleApiClient, String str) {
        super(zzdmVar, googleApiClient);
        this.zzb = zzdmVar;
        this.zza = str;
    }

    public final /* bridge */ /* synthetic */ void doExecute(a.b bVar) throws RemoteException {
        zza((zzdp) bVar);
    }

    public final void zza(zzdp zzdpVar) throws RemoteException {
        zzdpVar.zzr(new zzdi(this, zzdpVar), zzdm.zzc(this.zzb), this.zza);
    }
}
