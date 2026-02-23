package com.google.android.gms.internal.measurement;

import M4.d2;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.dynamite.DynamiteModule;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzcx extends zzdu {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ Context zzc;
    final /* synthetic */ Bundle zzd;
    final /* synthetic */ zzef zze;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzcx(zzef zzefVar, String str, String str2, Context context, Bundle bundle) {
        super(zzefVar, true);
        this.zze = zzefVar;
        this.zza = str;
        this.zzb = str2;
        this.zzc = context;
        this.zzd = bundle;
    }

    public final void zza() {
        String str;
        String str2;
        String str3;
        try {
            if (zzef.zzR(this.zze, this.zza, this.zzb)) {
                str3 = this.zzb;
                str2 = this.zza;
                str = zzef.zzj(this.zze);
            } else {
                str = null;
                str2 = null;
                str3 = null;
            }
            r.m(this.zzc);
            zzef zzefVar = this.zze;
            zzef.zzs(zzefVar, zzefVar.zzf(this.zzc, true));
            if (zzef.zze(this.zze) == null) {
                Log.w(zzef.zzj(this.zze), "Failed to connect to measurement client.");
                return;
            }
            int a = DynamiteModule.a(this.zzc, "com.google.android.gms.measurement.dynamite");
            ((zzcc) r.m(zzef.zze(this.zze))).initialize(F4.b.Z(this.zzc), new zzcl(79000L, Math.max(a, r0), DynamiteModule.c(this.zzc, "com.google.android.gms.measurement.dynamite") < a, str, str2, str3, this.zzd, d2.a(this.zzc)), this.zzh);
        } catch (Exception e) {
            zzef.zzt(this.zze, e, true, false);
        }
    }
}
