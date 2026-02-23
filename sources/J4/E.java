package J4;

import android.location.Location;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public interface e {
    Location getLastLocation(GoogleApiClient googleApiClient);

    com.google.android.gms.common.api.f removeLocationUpdates(GoogleApiClient googleApiClient, j jVar);

    com.google.android.gms.common.api.f requestLocationUpdates(GoogleApiClient googleApiClient, LocationRequest locationRequest, j jVar);
}
