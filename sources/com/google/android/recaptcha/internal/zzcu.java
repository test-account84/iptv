package com.google.android.recaptcha.internal;

import G8.n;
import android.webkit.JavascriptInterface;
import java.util.concurrent.TimeUnit;
import k8.j;
import k8.k;
import k8.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzcu {
    final /* synthetic */ zzda zza;

    @Nullable
    private Long zzb;

    @NotNull
    private final zzdk zzc = zzdk.zzb();

    public zzcu(zzda zzdaVar) {
        this.zza = zzdaVar;
    }

    private final void zzb() {
        if (this.zzb == null) {
            this.zzc.zzf();
            this.zzb = Long.valueOf(this.zzc.zza(TimeUnit.MILLISECONDS));
        }
    }

    @Nullable
    public final Long zza() {
        return this.zzb;
    }

    @JavascriptInterface
    public final void zzoed(@NotNull String str) {
        Object a;
        zzb();
        zzlz zzg = zzlz.zzg(zzeb.zzh().zzj(str));
        zzg.zzi().name();
        zzg.zzk();
        n nVar = (n) zzda.zzl(this.zza).remove(zzg.zzj());
        String zzk = zzg.zzk();
        if (zzk == null || zzk.length() == 0) {
            zzg.zzi().name();
            zzg zzgVar = zzh.zza;
            zzh zza = zzg.zza(zzg.zzi());
            zzg.zzj();
            if (nVar == null) {
                return;
            }
            j.a aVar = j.c;
            a = k.a(zza);
        } else if (nVar == null) {
            return;
        } else {
            a = zzg.zzk();
        }
        nVar.resumeWith(j.b(a));
    }

    @JavascriptInterface
    public final void zzoid(@NotNull String str) {
        zzb();
        zzmd zzg = zzmd.zzg(zzeb.zzh().zzj(str));
        zzg.zzi().name();
        if (zzg.zzi() == zzmf.JS_CODE_SUCCESS) {
            this.zza.zzm().hashCode();
            if (this.zza.zzm().p(q.a)) {
                return;
            }
            this.zza.zzm().hashCode();
            return;
        }
        zzg.zzi().name();
        zzg zzgVar = zzh.zza;
        zzh zza = zzg.zza(zzg.zzi());
        this.zza.zzm().hashCode();
        this.zza.zzm().n(zza);
    }

    @JavascriptInterface
    public final void zzrp(@NotNull String str) {
        zzb();
        this.zza.zzd().zza(str);
    }
}
