package com.google.android.gms.internal.location;

import J4.j;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.l;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzv extends zzx {
    final /* synthetic */ j zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzv(zzz zzzVar, GoogleApiClient googleApiClient, j jVar) {
        super(googleApiClient);
        this.zza = jVar;
    }

    public final /* bridge */ /* synthetic */ void doExecute(a.b bVar) throws RemoteException {
        ((zzaz) bVar).zzF(l.b(this.zza, j.class.getSimpleName()), new zzy(this));
    }
}
