package com.google.android.recaptcha.internal;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzv extends q8.d {
    Object zza;
    Object zzb;
    Object zzc;
    Object zzd;
    /* synthetic */ Object zze;
    final /* synthetic */ zzw zzf;
    int zzg;
    zzw zzh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzv(zzw zzwVar, o8.d dVar) {
        super(dVar);
        this.zzf = zzwVar;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.zze = obj;
        this.zzg |= Integer.MIN_VALUE;
        return this.zzf.zza(null, null, null, null, this);
    }
}
