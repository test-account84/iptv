package com.google.android.recaptcha.internal;

import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzcq {

    @NotNull
    public static final zzcp zza = new zzcp(null);
    private int zzb;

    public zzcq(short s, short s2) {
        this.zzb = Math.abs(s);
    }

    public final short zza() {
        int i = ((this.zzb * 4391) + 277) % 32779;
        this.zzb = i;
        return (short) (i % 255);
    }
}
