package com.google.android.gms.internal.location;

import J4.H;
import J4.l;
import J4.m;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.h;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzbh extends H {
    final /* synthetic */ l zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzbh(zzbi zzbiVar, GoogleApiClient googleApiClient, l lVar, String str) {
        super(googleApiClient);
        this.zza = lVar;
    }

    public final /* bridge */ /* synthetic */ h createFailedResult(Status status) {
        return new m(status, null);
    }

    public final /* bridge */ /* synthetic */ void doExecute(a.b bVar) throws RemoteException {
        ((zzaz) bVar).zzL(this.zza, this, null);
    }
}
