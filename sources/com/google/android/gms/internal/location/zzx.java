package com.google.android.gms.internal.location;

import J4.H;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.h;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
abstract class zzx extends H {
    public zzx(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    public final /* bridge */ /* synthetic */ h createFailedResult(Status status) {
        return status;
    }
}
