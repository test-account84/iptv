package com.google.android.gms.internal.firebase-auth-api;

import G5.F;
import android.text.TextUtils;
import com.google.android.gms.common.api.Status;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzze implements zzadk {
    private final /* synthetic */ zzadk zza;
    private final /* synthetic */ zzzb zzb;

    public zzze(zzzb zzzbVar, zzadk zzadkVar) {
        this.zzb = zzzbVar;
        this.zza = zzadkVar;
    }

    public final /* synthetic */ void zza(Object obj) {
        zzahb zzahbVar = (zzahb) obj;
        if (TextUtils.isEmpty(zzahbVar.zze())) {
            zzyj.zza(this.zzb.zzb, new zzafn(zzahbVar.zzd(), zzahbVar.zzb(), Long.valueOf(zzahbVar.zza()), "Bearer"), null, "phone", Boolean.valueOf(zzahbVar.zzf()), null, this.zzb.zza, this.zza);
        } else {
            this.zzb.zza.zza(new Status(17025), F.N(zzahbVar.zzc(), zzahbVar.zze()));
        }
    }

    public final void zza(String str) {
        this.zza.zza(str);
    }
}
