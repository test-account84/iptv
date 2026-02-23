package com.google.android.recaptcha.internal;

import k8.j;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzcv extends q8.d {
    /* synthetic */ Object zza;
    final /* synthetic */ zzda zzb;
    int zzc;
    zzda zzd;
    String zze;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzcv(zzda zzdaVar, o8.d dVar) {
        super(dVar);
        this.zzb = zzdaVar;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.zza = obj;
        this.zzc |= Integer.MIN_VALUE;
        Object zzf = this.zzb.zzf(null, this);
        return zzf == p8.c.d() ? zzf : j.a(zzf);
    }
}
