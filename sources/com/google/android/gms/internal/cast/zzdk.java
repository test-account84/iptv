package com.google.android.gms.internal.cast;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.h;
import com.google.android.gms.common.api.internal.d;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
class zzdk extends d {
    final /* synthetic */ zzdm zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzdk(zzdm zzdmVar, GoogleApiClient googleApiClient) {
        super(zzdm.zzd(zzdmVar), googleApiClient);
        this.zzc = zzdmVar;
    }

    public final /* synthetic */ h createFailedResult(Status status) {
        return new zzdl(status);
    }

    public final /* bridge */ /* synthetic */ void setResult(Object obj) {
        super.setResult((h) obj);
    }

    @VisibleForTesting
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public void doExecute(zzdp zzdpVar) throws RemoteException {
        throw null;
    }
}
