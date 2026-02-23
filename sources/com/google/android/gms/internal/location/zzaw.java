package com.google.android.gms.internal.location;

import J4.o;
import android.app.PendingIntent;
import android.util.Log;
import com.google.android.gms.common.api.internal.e;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzaw extends zzaj {
    private e zza;

    public zzaw(e eVar) {
        this.zza = eVar;
    }

    public final void zzb(int i, String[] strArr) {
        if (this.zza == null) {
            Log.wtf("LocationClientImpl", "onAddGeofenceResult called multiple times", new Exception());
            return;
        }
        this.zza.setResult(o.b(o.a(i)));
        this.zza = null;
    }

    public final void zzc(int i, String[] strArr) {
        Log.wtf("LocationClientImpl", "Unexpected call to onRemoveGeofencesByRequestIdsResult", new Exception());
    }

    public final void zzd(int i, PendingIntent pendingIntent) {
        Log.wtf("LocationClientImpl", "Unexpected call to onRemoveGeofencesByPendingIntentResult", new Exception());
    }
}
