package com.google.android.gms.internal.firebase-auth-api;

import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzzt implements zzadk {
    private final /* synthetic */ zzadk zza;
    private final /* synthetic */ zzafn zzb;
    private final /* synthetic */ zzzu zzc;

    public zzzt(zzzu zzzuVar, zzadk zzadkVar, zzafn zzafnVar) {
        this.zzc = zzzuVar;
        this.zza = zzadkVar;
        this.zzb = zzafnVar;
    }

    public final /* synthetic */ void zza(Object obj) {
        List zza = ((zzafd) obj).zza();
        if (zza == null || zza.isEmpty()) {
            this.zza.zza("No users");
        } else {
            this.zzc.zza.zza(this.zzb, (zzafc) zza.get(0));
        }
    }

    public final void zza(String str) {
        this.zza.zza(str);
    }
}
