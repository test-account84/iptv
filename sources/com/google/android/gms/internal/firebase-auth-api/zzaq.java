package com.google.android.gms.internal.firebase-auth-api;

import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzaq extends zzap {
    private final transient int zza;
    private final transient int zzb;
    private final /* synthetic */ zzap zzc;

    public zzaq(zzap zzapVar, int i, int i2) {
        this.zzc = zzapVar;
        this.zza = i;
        this.zzb = i2;
    }

    public final Object get(int i) {
        zzy.zza(i, this.zzb);
        return this.zzc.get(i + this.zza);
    }

    public final int size() {
        return this.zzb;
    }

    public final /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }

    public final int zza() {
        return this.zzc.zzb() + this.zza + this.zzb;
    }

    public final int zzb() {
        return this.zzc.zzb() + this.zza;
    }

    public final boolean zze() {
        return true;
    }

    public final Object[] zzf() {
        return this.zzc.zzf();
    }

    public final zzap zza(int i, int i2) {
        zzy.zza(i, i2, this.zzb);
        zzap zzapVar = this.zzc;
        int i3 = this.zza;
        return (zzap) zzapVar.subList(i + i3, i2 + i3);
    }
}
