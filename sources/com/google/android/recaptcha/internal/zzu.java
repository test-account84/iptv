package com.google.android.recaptcha.internal;

import android.content.Context;
import android.os.Build;
import org.jetbrains.annotations.NotNull;
import w4.i;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzu {

    @NotNull
    public static final zzu zza = new zzu();

    @NotNull
    private static final String zzb = String.valueOf(Build.VERSION.SDK_INT);

    @NotNull
    private static final i zzc = i.h();

    private zzu() {
    }

    @NotNull
    public static final String zza(@NotNull Context context) {
        int i = zzc.i(context);
        return (i == 1 || i == 3 || i == 9) ? "ANDROID_OFFPLAY" : "ANDROID_ONPLAY";
    }

    @NotNull
    public static final String zzb() {
        return zzb;
    }
}
