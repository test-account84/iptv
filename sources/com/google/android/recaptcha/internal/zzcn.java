package com.google.android.recaptcha.internal;

import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzcn implements zzby {

    @NotNull
    public static final zzcn zza = new zzcn();

    private zzcn() {
    }

    public final void zza(int i, @NotNull zzbl zzblVar, @NotNull Object... objArr) throws zzt {
        if (objArr.length != 2) {
            throw new zzt(4, 3, null);
        }
        Object obj = objArr[0];
        if (true != (obj instanceof int[])) {
            obj = null;
        }
        int[] iArr = (int[]) obj;
        if (iArr == null) {
            throw new zzt(4, 5, null);
        }
        Object obj2 = objArr[1];
        if (true != (obj2 instanceof String)) {
            obj2 = null;
        }
        String str = (String) obj2;
        if (str == null) {
            throw new zzt(4, 5, null);
        }
        zzbm zzc = zzblVar.zzc();
        StringBuilder sb = new StringBuilder();
        try {
            for (int i2 : iArr) {
                sb.append(str.charAt(i2));
            }
            zzc.zzf(i, sb.toString());
        } catch (Exception e) {
            throw new zzt(4, 22, e);
        }
    }
}
