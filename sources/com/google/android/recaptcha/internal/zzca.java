package com.google.android.recaptcha.internal;

import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzca implements zzby {

    @NotNull
    public static final zzca zza = new zzca();

    private zzca() {
    }

    public final void zza(int i, @NotNull zzbl zzblVar, @NotNull Object... objArr) throws zzt {
        if (objArr.length != 1) {
            throw new zzt(4, 3, null);
        }
        Object obj = objArr[0];
        if (true != (obj instanceof Object)) {
            obj = null;
        }
        if (obj == null) {
            throw new zzt(4, 5, null);
        }
        try {
            if (obj instanceof String) {
                obj = zzbx.zza(this, (String) obj, zzblVar.zza());
            }
            zzblVar.zzc().zzf(i, zzbk.zza(obj));
        } catch (Exception e) {
            throw new zzt(6, 8, e);
        }
    }
}
