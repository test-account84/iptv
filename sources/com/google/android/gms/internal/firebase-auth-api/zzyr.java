package com.google.android.gms.internal.firebase-auth-api;

import G5.f0;
import android.text.TextUtils;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzyr implements zzadk {
    private final /* synthetic */ zzadl zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ Boolean zzd;
    private final /* synthetic */ f0 zze;
    private final /* synthetic */ zzacd zzf;
    private final /* synthetic */ zzafn zzg;

    public zzyr(zzyj zzyjVar, zzadl zzadlVar, String str, String str2, Boolean bool, f0 f0Var, zzacd zzacdVar, zzafn zzafnVar) {
        this.zza = zzadlVar;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = bool;
        this.zze = f0Var;
        this.zzf = zzacdVar;
        this.zzg = zzafnVar;
    }

    public final /* synthetic */ void zza(Object obj) {
        Object obj2;
        List zza = ((zzafd) obj).zza();
        if (zza == null || zza.isEmpty()) {
            this.zza.zza("No users.");
            return;
        }
        boolean z = false;
        zzafc zzafcVar = (zzafc) zza.get(0);
        zzafv zzf = zzafcVar.zzf();
        List zza2 = zzf != null ? zzf.zza() : null;
        if (zza2 != null && !zza2.isEmpty()) {
            if (TextUtils.isEmpty(this.zzb)) {
                obj2 = zza2.get(0);
            } else {
                for (int i = 0; i < zza2.size(); i++) {
                    if (((zzafs) zza2.get(i)).zzf().equals(this.zzb)) {
                        obj2 = zza2.get(i);
                    }
                }
            }
            ((zzafs) obj2).zza(this.zzc);
            break;
        }
        Boolean bool = this.zzd;
        if (bool != null) {
            z = bool.booleanValue();
        } else if (zzafcVar.zzb() - zzafcVar.zza() < 1000) {
            z = true;
        }
        zzafcVar.zza(z);
        zzafcVar.zza(this.zze);
        this.zzf.zza(this.zzg, zzafcVar);
    }

    public final void zza(String str) {
        this.zza.zza(str);
    }
}
