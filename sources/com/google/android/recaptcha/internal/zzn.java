package com.google.android.recaptcha.internal;

import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzn {

    @NotNull
    public static final zzm zza = new zzm(null);
    private final long zzb = System.currentTimeMillis();

    @NotNull
    private final zzdk zzc = zzdk.zzb();

    public final long zza(@NotNull TimeUnit timeUnit) {
        return this.zzc.zza(timeUnit);
    }

    public final long zzb() {
        return this.zzb;
    }
}
