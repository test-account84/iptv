package com.google.android.gms.internal.location;

import J4.l;
import J4.p;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.f;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzbi implements p {
    public final f checkLocationSettings(GoogleApiClient googleApiClient, l lVar) {
        return googleApiClient.e(new zzbh(this, googleApiClient, lVar, null));
    }
}
