package com.google.android.recaptcha.internal;

import java.lang.reflect.Array;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzbp implements zzby {

    @NotNull
    public static final zzbp zza = new zzbp();

    private zzbp() {
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
            zzblVar.zzc().zzf(i, obj instanceof String ? String.valueOf(((String) obj).charAt(intValue)) : obj instanceof List ? ((List) obj).get(intValue) : Array.get(obj, intValue));
        } catch (Exception e) {
            if (!(e instanceof ArrayIndexOutOfBoundsException)) {
                throw new zzt(4, 23, e);
            }
            throw new zzt(4, 22, e);
        }
    }
}
