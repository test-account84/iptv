package com.google.android.gms.internal.firebase-auth-api;

import H5.m;
import android.text.TextUtils;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzzj implements zzadk {
    private final /* synthetic */ zzzk zza;

    public zzzj(zzzk zzzkVar) {
        this.zza = zzzkVar;
    }

    public final /* synthetic */ void zza(Object obj) {
        zzahd zzahdVar = (zzahd) obj;
        if (TextUtils.isEmpty(zzahdVar.zza()) || TextUtils.isEmpty(zzahdVar.zzb())) {
            this.zza.zza.zza(m.a("INTERNAL_SUCCESS_SIGN_OUT"));
            return;
        }
        zzafn zzafnVar = new zzafn(zzahdVar.zzb(), zzahdVar.zza(), Long.valueOf(zzafp.zza(zzahdVar.zza())), "Bearer");
        zzzk zzzkVar = this.zza;
        zzyj.zza(zzzkVar.zzb, zzafnVar, null, null, Boolean.FALSE, null, zzzkVar.zza, this);
    }

    public final void zza(String str) {
        this.zza.zza.zza(m.a(str));
    }
}
