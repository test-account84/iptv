package com.google.android.recaptcha;

import G8.L;
import android.app.Application;
import com.google.android.recaptcha.internal.zzaa;
import com.google.android.recaptcha.internal.zzw;
import k8.k;
import k8.q;
import o8.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.c;
import q8.l;
import w8.p;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class Recaptcha$getClient$2$1 extends l implements p {
    int zza;
    final /* synthetic */ Application zzb;
    final /* synthetic */ String zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Recaptcha$getClient$2$1(Application application, String str, d dVar) {
        super(2, dVar);
        this.zzb = application;
        this.zzc = str;
    }

    @NotNull
    public final d create(@Nullable Object obj, @NotNull d dVar) {
        return new Recaptcha$getClient$2$1(this.zzb, this.zzc, dVar);
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return create((L) obj, (d) obj2).invokeSuspend(q.a);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object d = c.d();
        int i = this.zza;
        k.b(obj);
        if (i == 0) {
            zzw zzwVar = zzaa.zza;
            Application application = this.zzb;
            String str = this.zzc;
            this.zza = 1;
            obj = zzw.zzb(zzwVar, application, str, null, null, this, 12, null);
            if (obj == d) {
                return d;
            }
        }
        return obj;
    }
}
