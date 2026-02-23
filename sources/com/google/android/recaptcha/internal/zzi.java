package com.google.android.recaptcha.internal;

import E8.o;
import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzi implements Comparable {
    private int zza;
    private long zzb;
    private long zzc;

    @NotNull
    public final String toString() {
        return "avgExecutionTime: " + o.c0(String.valueOf(this.zzb / this.zza), 10, (char) 0, 2, (Object) null) + " us| maxExecutionTime: " + o.c0(String.valueOf(this.zzc), 10, (char) 0, 2, (Object) null) + " us| totalTime: " + o.c0(String.valueOf(this.zzb), 10, (char) 0, 2, (Object) null) + " us| #Usages: " + o.c0(String.valueOf(this.zza), 5, (char) 0, 2, (Object) null);
    }

    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final int compareTo(@NotNull zzi zziVar) {
        return m8.a.a(Long.valueOf(this.zzb), Long.valueOf(zziVar.zzb));
    }

    public final int zzb() {
        return this.zza;
    }

    public final long zzc() {
        return this.zzc;
    }

    public final long zzd() {
        return this.zzb;
    }

    public final void zze(long j) {
        this.zzc = j;
    }

    public final void zzf(long j) {
        this.zzb = j;
    }

    public final void zzg(int i) {
        this.zza = i;
    }
}
