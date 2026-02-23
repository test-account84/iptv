package com.google.android.gms.internal.measurement;

import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zziz extends zzja {
    final transient int zza;
    final transient int zzb;
    final /* synthetic */ zzja zzc;

    public zziz(zzja zzjaVar, int i, int i2) {
        this.zzc = zzjaVar;
        this.zza = i;
        this.zzb = i2;
    }

    public final Object get(int i) {
        zzij.zza(i, this.zzb, "index");
        return this.zzc.get(i + this.zza);
    }

    public final int size() {
        return this.zzb;
    }

    public final /* bridge */ /* synthetic */ List subList(int i, int i2) {
        return zzf(i, i2);
    }

    public final int zzb() {
        return this.zzc.zzc() + this.zza + this.zzb;
    }

    public final int zzc() {
        return this.zzc.zzc() + this.zza;
    }

    public final Object[] zze() {
        return this.zzc.zze();
    }

    public final zzja zzf(int i, int i2) {
        zzij.zzc(i, i2, this.zzb);
        zzja zzjaVar = this.zzc;
        int i3 = this.zza;
        return zzjaVar.zzf(i + i3, i2 + i3);
    }
}
