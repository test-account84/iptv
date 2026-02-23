package com.google.android.gms.internal.cast;

import android.hardware.display.VirtualDisplay;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.f;
import t4.b;

@Deprecated
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzdm {
    private static final b zza = new b("CastRemoteDisplayApiImpl");
    private final a zzb;
    private VirtualDisplay zzc;
    private final zzdu zzd = new zzde(this);

    public zzdm(a aVar) {
        this.zzb = aVar;
    }

    public static /* bridge */ /* synthetic */ VirtualDisplay zza(zzdm zzdmVar) {
        return zzdmVar.zzc;
    }

    public static /* bridge */ /* synthetic */ b zzb() {
        return zza;
    }

    public static /* bridge */ /* synthetic */ zzdu zzc(zzdm zzdmVar) {
        return zzdmVar.zzd;
    }

    public static /* bridge */ /* synthetic */ a zzd(zzdm zzdmVar) {
        return zzdmVar.zzb;
    }

    public static /* bridge */ /* synthetic */ void zze(zzdm zzdmVar, VirtualDisplay virtualDisplay) {
        zzdmVar.zzc = virtualDisplay;
    }

    public static /* bridge */ /* synthetic */ void zzf(zzdm zzdmVar) {
        VirtualDisplay virtualDisplay = zzdmVar.zzc;
        if (virtualDisplay != null) {
            if (virtualDisplay.getDisplay() != null) {
                zza.a("releasing virtual display: " + virtualDisplay.getDisplay().getDisplayId(), new Object[0]);
            }
            virtualDisplay.release();
        }
        zzdmVar.zzc = null;
    }

    public final f startRemoteDisplay(GoogleApiClient googleApiClient, String str) {
        zza.a("startRemoteDisplay", new Object[0]);
        return googleApiClient.f(new zzdf(this, googleApiClient, str));
    }

    public final f stopRemoteDisplay(GoogleApiClient googleApiClient) {
        zza.a("stopRemoteDisplay", new Object[0]);
        return googleApiClient.f(new zzdg(this, googleApiClient));
    }
}
