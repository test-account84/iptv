package com.google.android.recaptcha.internal;

import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzcc implements zzby {

    @NotNull
    public static final zzcc zza = new zzcc();

    private zzcc() {
    }

    public final void zza(int i, @NotNull zzbl zzblVar, @NotNull Object... objArr) throws zzt {
        if (objArr.length != 2) {
            throw new zzt(4, 3, null);
        }
        Object obj = objArr[0];
        if (true != (obj instanceof Object)) {
            obj = null;
        }
        if (obj == null) {
            throw new zzt(4, 5, null);
        }
        Class cls = obj instanceof Class ? (Class) obj : obj.getClass();
        Object obj2 = objArr[1];
        if (true != (obj2 instanceof String)) {
            obj2 = null;
        }
        String str = (String) obj2;
        if (str == null) {
            throw new zzt(4, 5, null);
        }
        try {
            zzblVar.zzc().zzf(i, cls.getField(zzbx.zza(this, str, zzblVar.zza())));
        } catch (Exception e) {
            throw new zzt(6, 10, e);
        }
    }
}
