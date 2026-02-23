package com.google.android.gms.internal.location;

import J4.o;
import android.app.PendingIntent;
import android.util.Log;
import com.google.android.gms.common.api.internal.e;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzax extends zzaj {
    private e zza;

    public zzax(e eVar) {
        this.zza = eVar;
    }

    private final void zze(int i) {
        if (this.zza == null) {
            Log.wtf("LocationClientImpl", "onRemoveGeofencesResult called multiple times", new Exception());
            return;
        }
        this.zza.setResult(o.b(o.a(i)));
        this.zza = null;
    }

    public final void zzb(int i, String[] strArr) {
        Log.wtf("LocationClientImpl", "Unexpected call to onAddGeofencesResult", new Exception());
    }

    public final void zzc(int i, String[] strArr) {
        zze(i);
    }

    public final void zzd(int i, PendingIntent pendingIntent) {
        zze(i);
    }
}
