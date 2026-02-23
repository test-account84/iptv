package com.google.android.recaptcha.internal;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzbk {

    @NotNull
    public static final zzbk zza = new zzbk();

    private zzbk() {
    }

    @NotNull
    public static final Class zza(@Nullable Object obj) {
        if (obj instanceof Class) {
            return (Class) obj;
        }
        if (obj instanceof Integer) {
            int intValue = ((Number) obj).intValue();
            Class cls = intValue == 1 ? Integer.TYPE : intValue == 2 ? Short.TYPE : intValue == 3 ? Byte.TYPE : intValue == 4 ? Long.TYPE : intValue == 5 ? Character.TYPE : intValue == 6 ? Float.TYPE : intValue == 7 ? Double.TYPE : intValue == 8 ? Boolean.TYPE : intValue == 9 ? zzcr.class : null;
            if (cls != null) {
                return cls;
            }
            throw new zzt(4, 6, null);
        }
        if (!(obj instanceof String)) {
            throw new zzt(6, 8, null);
        }
        String str = (String) obj;
        if (!zzbj.zzc(str)) {
            throw new zzt(6, 47, null);
        }
        try {
            return Class.forName(str);
        } catch (Exception e) {
            throw new zzt(6, 8, e);
        }
    }
}
