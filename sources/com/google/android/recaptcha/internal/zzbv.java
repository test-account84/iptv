package com.google.android.recaptcha.internal;

import java.lang.reflect.Array;
import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzbv implements zzby {

    @NotNull
    public static final zzbv zza = new zzbv();

    private zzbv() {
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
        Object obj2 = objArr[1];
        if (true != (obj2 instanceof Integer)) {
            obj2 = null;
        }
        Integer num = (Integer) obj2;
        if (num == null) {
            throw new zzt(4, 5, null);
        }
        int intValue = num.intValue();
        try {
            if (obj instanceof String) {
                obj = zzbx.zza(this, (String) obj, zzblVar.zza());
            }
            zzblVar.zzc().zzf(i, Array.newInstance(zzbk.zza(obj), intValue));
        } catch (Exception e) {
            throw new zzt(6, 21, e);
        }
    }
}
