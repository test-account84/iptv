package com.google.android.recaptcha;

import k8.j;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.c;
import q8.d;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class Recaptcha$getClient$1 extends d {
    /* synthetic */ Object zza;
    final /* synthetic */ Recaptcha zzb;
    int zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Recaptcha$getClient$1(Recaptcha recaptcha, o8.d dVar) {
        super(dVar);
        this.zzb = recaptcha;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.zza = obj;
        this.zzc |= Integer.MIN_VALUE;
        Object obj2 = this.zzb.getClient-0E7RQCE(null, null, this);
        return obj2 == c.d() ? obj2 : j.a(obj2);
    }
}
