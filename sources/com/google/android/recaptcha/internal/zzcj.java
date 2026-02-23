package com.google.android.recaptcha.internal;

import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzcj implements zzby {

    @NotNull
    public static final zzcj zza = new zzcj();

    private zzcj() {
    }

    public final void zza(int i, @NotNull zzbl zzblVar, @NotNull Object... objArr) throws zzt {
        if (objArr.length != 1) {
            throw new zzt(4, 3, null);
        }
        zzblVar.zzc().zzf(i, objArr[0]);
    }
}
