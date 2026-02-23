package com.google.android.gms.internal.location;

import J4.e;
import J4.i;
import J4.j;
import J4.k;
import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.Build;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationRequest;
import java.lang.reflect.InvocationTargetException;

@VisibleForTesting
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzz implements e {
    public final f flushLocations(GoogleApiClient googleApiClient) {
        return googleApiClient.f(new zzq(this, googleApiClient));
    }

    public final Location getLastLocation(GoogleApiClient googleApiClient) {
        String str;
        zzaz a = k.a(googleApiClient);
        Context h = googleApiClient.h();
        if (Build.VERSION.SDK_INT < 30 || h == null) {
            str = null;
        } else {
            try {
                str = (String) Context.class.getMethod("getAttributionTag", (Class[]) null).invoke(h, (Object[]) null);
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException unused) {
            }
        }
        try {
            return a.zzz(str);
        } catch (Exception unused2) {
            return null;
        }
    }

    public final LocationAvailability getLocationAvailability(GoogleApiClient googleApiClient) {
        try {
            return k.a(googleApiClient).zzA();
        } catch (Exception unused) {
            return null;
        }
    }

    public final f removeLocationUpdates(GoogleApiClient googleApiClient, i iVar) {
        return googleApiClient.f(new zzn(this, googleApiClient, iVar));
    }

    public final f requestLocationUpdates(GoogleApiClient googleApiClient, LocationRequest locationRequest, i iVar, Looper looper) {
        return googleApiClient.f(new zzt(this, googleApiClient, locationRequest, iVar, looper));
    }

    public final f setMockLocation(GoogleApiClient googleApiClient, Location location) {
        return googleApiClient.f(new zzp(this, googleApiClient, location));
    }

    public final f setMockMode(GoogleApiClient googleApiClient, boolean z) {
        return googleApiClient.f(new zzo(this, googleApiClient, z));
    }

    public final f removeLocationUpdates(GoogleApiClient googleApiClient, j jVar) {
        return googleApiClient.f(new zzv(this, googleApiClient, jVar));
    }

    public final f requestLocationUpdates(GoogleApiClient googleApiClient, LocationRequest locationRequest, j jVar) {
        r.n(Looper.myLooper(), "Calling thread must be a prepared Looper thread.");
        return googleApiClient.f(new zzr(this, googleApiClient, locationRequest, jVar));
    }

    public final f removeLocationUpdates(GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
        return googleApiClient.f(new zzw(this, googleApiClient, pendingIntent));
    }

    public final f requestLocationUpdates(GoogleApiClient googleApiClient, LocationRequest locationRequest, j jVar, Looper looper) {
        return googleApiClient.f(new zzs(this, googleApiClient, locationRequest, jVar, looper));
    }

    public final f requestLocationUpdates(GoogleApiClient googleApiClient, LocationRequest locationRequest, PendingIntent pendingIntent) {
        return googleApiClient.f(new zzu(this, googleApiClient, locationRequest, pendingIntent));
    }
}
