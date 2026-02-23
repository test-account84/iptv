package com.google.android.gms.internal.location;

import J4.j;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.l;
import com.google.android.gms.location.LocationRequest;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzs extends zzx {
    final /* synthetic */ LocationRequest zza;
    final /* synthetic */ j zzb;
    final /* synthetic */ Looper zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzs(zzz zzzVar, GoogleApiClient googleApiClient, LocationRequest locationRequest, j jVar, Looper looper) {
        super(googleApiClient);
        this.zza = locationRequest;
        this.zzb = jVar;
        this.zzc = looper;
    }

    public final /* bridge */ /* synthetic */ void doExecute(a.b bVar) throws RemoteException {
        ((zzaz) bVar).zzC(this.zza, l.a(this.zzb, zzbj.zza(this.zzc), j.class.getSimpleName()), new zzy(this));
    }
}
