package com.google.android.gms.internal.location;

import J4.i;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.l;
import com.google.android.gms.location.LocationRequest;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzt extends zzx {
    final /* synthetic */ LocationRequest zza;
    final /* synthetic */ i zzb;
    final /* synthetic */ Looper zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzt(zzz zzzVar, GoogleApiClient googleApiClient, LocationRequest locationRequest, i iVar, Looper looper) {
        super(googleApiClient);
        this.zza = locationRequest;
        this.zzc = looper;
    }

    public final /* bridge */ /* synthetic */ void doExecute(a.b bVar) throws RemoteException {
        ((zzaz) bVar).zzB(zzba.zza(null, this.zza), l.a(null, zzbj.zza(this.zzc), i.class.getSimpleName()), new zzy(this));
    }
}
