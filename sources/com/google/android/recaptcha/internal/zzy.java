package com.google.android.recaptcha.internal;

import G8.L;
import com.google.android.recaptcha.RecaptchaAction;
import k8.j;
import k8.k;
import k8.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q8.l;
import w8.p;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzy extends l implements p {
    int zza;
    final /* synthetic */ zzaa zzb;
    final /* synthetic */ RecaptchaAction zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzy(zzaa zzaaVar, RecaptchaAction recaptchaAction, o8.d dVar) {
        super(2, dVar);
        this.zzb = zzaaVar;
        this.zzc = recaptchaAction;
    }

    @NotNull
    public final o8.d create(@Nullable Object obj, @NotNull o8.d dVar) {
        return new zzy(this.zzb, this.zzc, dVar);
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return create((L) obj, (o8.d) obj2).invokeSuspend(q.a);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object zzf;
        Object d = p8.c.d();
        int i = this.zza;
        k.b(obj);
        if (i != 0) {
            zzf = ((j) obj).i();
        } else {
            zzda zzb = this.zzb.zzb();
            RecaptchaAction recaptchaAction = this.zzc;
            this.zza = 1;
            zzf = zzb.zzf(recaptchaAction, this);
            if (zzf == d) {
                return d;
            }
        }
        return j.a(zzf);
    }
}
