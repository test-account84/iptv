package com.google.android.gms.internal.cast;

import com.google.android.gms.common.api.f;
import com.google.android.gms.tasks.Task;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzbr {
    public static f zza(Task task, zzbq zzbqVar, zzbq zzbqVar2) {
        zzbp zzbpVar = new zzbp(zzbqVar2);
        task.addOnSuccessListener(new zzbn(zzbpVar, zzbqVar)).addOnFailureListener(new zzbo(zzbpVar, zzbqVar2));
        return zzbpVar;
    }
}
