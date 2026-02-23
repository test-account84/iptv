package com.google.android.gms.internal.cast;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.google.android.gms.tasks.OnSuccessListener;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class zzd implements OnSuccessListener {
    public final /* synthetic */ zzf zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ SharedPreferences zzc;

    public /* synthetic */ zzd(zzf zzfVar, String str, SharedPreferences sharedPreferences) {
        this.zza = zzfVar;
        this.zzb = str;
        this.zzc = sharedPreferences;
    }

    public final void onSuccess(Object obj) {
        this.zza.zzb(this.zzb, this.zzc, (Bundle) obj);
    }
}
