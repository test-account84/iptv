package com.google.android.recaptcha.internal;

import java.lang.reflect.Array;
import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzbq implements zzby {

    @NotNull
    public static final zzbq zza = new zzbq();

    private zzbq() {
    }

    public final void zza(int i, @NotNull zzbl zzblVar, @NotNull Object... objArr) throws zzt {
        if (objArr.length != 3) {
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
        Object obj3 = objArr[2];
        if (true != (obj3 instanceof Object)) {
            obj3 = null;
        }
        if (obj3 == null) {
            throw new zzt(4, 5, null);
        }
        try {
            Array.set(obj, intValue, obj3);
        } catch (Exception e) {
            if (!(e instanceof ArrayIndexOutOfBoundsException)) {
                throw new zzt(4, 25, e);
            }
            throw new zzt(4, 22, e);
        }
    }
}
