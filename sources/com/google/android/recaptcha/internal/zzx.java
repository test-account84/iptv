package com.google.android.recaptcha.internal;

import k8.j;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzx extends q8.d {
    /* synthetic */ Object zza;
    final /* synthetic */ zzaa zzb;
    int zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzx(zzaa zzaaVar, o8.d dVar) {
        super(dVar);
        this.zzb = zzaaVar;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.zza = obj;
        this.zzc |= Integer.MIN_VALUE;
        Object obj2 = this.zzb.execute-gIAlu-s(null, this);
        return obj2 == p8.c.d() ? obj2 : j.a(obj2);
    }
}
