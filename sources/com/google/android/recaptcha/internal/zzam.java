package com.google.android.recaptcha.internal;

import G8.L;
import java.util.Timer;
import k8.k;
import k8.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q8.l;
import w8.p;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzam extends l implements p {
    final /* synthetic */ zzao zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzam(zzao zzaoVar, o8.d dVar) {
        super(2, dVar);
        this.zza = zzaoVar;
    }

    @NotNull
    public final o8.d create(@Nullable Object obj, @NotNull o8.d dVar) {
        return new zzam(this.zza, dVar);
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return create((L) obj, (o8.d) obj2).invokeSuspend(q.a);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        p8.c.d();
        k.b(obj);
        zzao zzaoVar = this.zza;
        synchronized (zzaj.class) {
            try {
                if (zzao.zza(zzaoVar).zzb() == 0) {
                    Timer zzb = zzao.zzb();
                    if (zzb != null) {
                        zzb.cancel();
                    }
                    zzao.zze(null);
                }
                zzao.zzd(zzaoVar);
            } catch (Throwable th) {
                throw th;
            }
        }
        return q.a;
    }
}
