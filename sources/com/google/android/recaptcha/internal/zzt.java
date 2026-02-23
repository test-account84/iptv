package com.google.android.recaptcha.internal;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzt extends Exception {

    @Nullable
    private final Throwable zza;

    @NotNull
    private final zzmi zzb;

    @NotNull
    private final int zzc;

    @NotNull
    private final int zzd;

    public zzt(@NotNull int i, @NotNull int i2, @Nullable Throwable th) {
        this.zzc = i;
        this.zzd = i2;
        this.zza = th;
        zzmi zzf = zzmj.zzf();
        zzf.zze(i2);
        zzf.zzp(i);
        this.zzb = zzf;
    }

    @Nullable
    public final Throwable getCause() {
        return this.zza;
    }

    @NotNull
    public final zzmi zza() {
        return this.zzb;
    }
}
