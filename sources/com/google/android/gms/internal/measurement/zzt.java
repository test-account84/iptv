package com.google.android.gms.internal.measurement;

import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzt extends zzai {
    private final zzr zza;

    public zzt(zzr zzrVar) {
        super("internal.logger");
        this.zza = zzrVar;
        this.zze.put("log", new zzs(this, false, true));
        this.zze.put("silent", new zzp(this, "silent"));
        ((zzai) this.zze.get("silent")).zzr("log", new zzs(this, true, true));
        this.zze.put("unmonitored", new zzq(this, "unmonitored"));
        ((zzai) this.zze.get("unmonitored")).zzr("log", new zzs(this, false, false));
    }

    public static /* bridge */ /* synthetic */ zzr zzb(zzt zztVar) {
        return zztVar.zza;
    }

    public final zzap zza(zzg zzgVar, List list) {
        return zzap.zzf;
    }
}
