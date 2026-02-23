package com.google.android.gms.internal.location;

import J4.b;
import android.app.PendingIntent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.f;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzg implements b {
    public final f removeActivityUpdates(GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
        return googleApiClient.f(new zze(this, googleApiClient, pendingIntent));
    }

    public final f requestActivityUpdates(GoogleApiClient googleApiClient, long j, PendingIntent pendingIntent) {
        return googleApiClient.f(new zzd(this, googleApiClient, j, pendingIntent));
    }
}
