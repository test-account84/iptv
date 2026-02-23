package com.google.android.recaptcha.internal;

import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzbl {

    @NotNull
    private final zzbn zza;

    @NotNull
    private String zzb = "recaptcha.m.Main.rge";
    private int zzc;

    @NotNull
    private final zzbm zzd;

    public zzbl(@NotNull zzbn zzbnVar) {
        this.zza = zzbnVar;
        this.zzd = zzbnVar.zzb();
    }

    public final byte zza() {
        return this.zza.zza();
    }

    public final int zzb() {
        return this.zzc;
    }

    @NotNull
    public final zzbm zzc() {
        return this.zzd;
    }

    @NotNull
    public final String zzd() {
        return this.zzb;
    }

    public final void zze() {
        this.zza.zzc();
    }

    public final void zzf(@NotNull String str) {
        this.zzb = str;
    }

    public final void zzg(int i) {
        this.zzc = i;
    }

    public final void zzh(byte b) {
        this.zza.zzd(b);
    }
}
