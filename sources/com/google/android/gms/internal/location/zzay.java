package com.google.android.gms.internal.location;

import J4.m;
import android.os.RemoteException;
import com.google.android.gms.common.api.internal.e;
import com.google.android.gms.common.internal.r;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzay extends zzan {
    private e zza;

    public zzay(e eVar) {
        r.b(eVar != null, "listener can't be null.");
        this.zza = eVar;
    }

    public final void zzb(m mVar) throws RemoteException {
        this.zza.setResult(mVar);
        this.zza = null;
    }
}
