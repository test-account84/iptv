package com.google.android.recaptcha.internal;

import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzcl implements zzby {

    @NotNull
    public static final zzcl zza = new zzcl();

    private zzcl() {
    }

    public final void zza(int i, @NotNull zzbl zzblVar, @NotNull Object... objArr) throws zzt {
        if (objArr.length != 1) {
            throw new zzt(4, 3, null);
        }
        Object obj = objArr[0];
        if (true != (obj instanceof Byte)) {
            obj = null;
        }
        Byte b = (Byte) obj;
        if (b == null) {
            throw new zzt(4, 5, null);
        }
        zzblVar.zzh(b.byteValue());
    }
}
