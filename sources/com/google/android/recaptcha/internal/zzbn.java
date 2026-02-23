package com.google.android.recaptcha.internal;

import B8.h;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzbn {

    @NotNull
    private final zzbm zza;
    private byte zzb;

    @NotNull
    private final HashMap zzc;

    public zzbn() {
        zzbm zzbmVar = new zzbm();
        this.zza = zzbmVar;
        this.zzb = (byte) h.k(new B8.c(1, 127), z8.c.a);
        HashMap hashMap = new HashMap();
        this.zzc = hashMap;
        zzbmVar.zze(173, hashMap);
    }

    public final byte zza() {
        return this.zzb;
    }

    @NotNull
    public final zzbm zzb() {
        return this.zza;
    }

    public final void zzc() {
        this.zza.zzd();
        this.zza.zze(173, this.zzc);
    }

    public final void zzd(byte b) {
        this.zzb = b;
    }

    public final void zze(@NotNull int i, @NotNull Object obj) {
        this.zzc.put(1, obj);
    }
}
