package com.google.android.gms.internal.location;

import J4.P;
import J4.g;
import J4.h;
import android.app.PendingIntent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.f;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzaf implements g {
    public final f addGeofences(GoogleApiClient googleApiClient, h hVar, PendingIntent pendingIntent) {
        return googleApiClient.f(new zzac(this, googleApiClient, hVar, pendingIntent));
    }

    public final f removeGeofences(GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
        return zza(googleApiClient, P.e(pendingIntent));
    }

    public final f zza(GoogleApiClient googleApiClient, P p) {
        return googleApiClient.f(new zzad(this, googleApiClient, p));
    }

    @Deprecated
    public final f addGeofences(GoogleApiClient googleApiClient, List list, PendingIntent pendingIntent) {
        h.a aVar = new h.a();
        aVar.b(list);
        aVar.d(5);
        return googleApiClient.f(new zzac(this, googleApiClient, aVar.c(), pendingIntent));
    }

    public final f removeGeofences(GoogleApiClient googleApiClient, List list) {
        return zza(googleApiClient, P.c(list));
    }
}
