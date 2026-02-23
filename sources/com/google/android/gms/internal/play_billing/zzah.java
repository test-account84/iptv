package com.google.android.gms.internal.play_billing;

import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzah extends zzai {
    final transient int zza;
    final transient int zzb;
    final /* synthetic */ zzai zzc;

    public zzah(zzai zzaiVar, int i, int i2) {
        this.zzc = zzaiVar;
        this.zza = i;
        this.zzb = i2;
    }

    public final Object get(int i) {
        zzaa.zza(i, this.zzb, "index");
        return this.zzc.get(i + this.zza);
    }

    public final int size() {
        return this.zzb;
    }

    public final /* bridge */ /* synthetic */ List subList(int i, int i2) {
        return zzh(i, i2);
    }

    public final int zzb() {
        return this.zzc.zzc() + this.zza + this.zzb;
    }

    public final int zzc() {
        return this.zzc.zzc() + this.zza;
    }

    public final boolean zzf() {
        return true;
    }

    public final Object[] zzg() {
        return this.zzc.zzg();
    }

    public final zzai zzh(int i, int i2) {
        zzaa.zzd(i, i2, this.zzb);
        int i3 = this.zza;
        return this.zzc.zzh(i + i3, i2 + i3);
    }
}
