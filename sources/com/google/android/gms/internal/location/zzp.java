package com.google.android.gms.internal.location;

import android.location.Location;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.h;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzp extends zzx {
    final /* synthetic */ Location zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzp(zzz zzzVar, GoogleApiClient googleApiClient, Location location) {
        super(googleApiClient);
        this.zza = location;
    }

    public final /* bridge */ /* synthetic */ void doExecute(a.b bVar) throws RemoteException {
        ((zzaz) bVar).zzJ(this.zza);
        setResult((h) Status.k);
    }
}
