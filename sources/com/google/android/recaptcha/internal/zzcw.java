package com.google.android.recaptcha.internal;

import G8.L;
import G8.o;
import android.webkit.ValueCallback;
import com.google.android.recaptcha.RecaptchaAction;
import k8.k;
import k8.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q8.h;
import q8.l;
import w8.p;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzcw extends l implements p {
    Object zza;
    Object zzb;
    Object zzc;
    int zzd;
    final /* synthetic */ RecaptchaAction zze;
    final /* synthetic */ zzda zzf;
    final /* synthetic */ String zzg;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzcw(RecaptchaAction recaptchaAction, zzda zzdaVar, String str, o8.d dVar) {
        super(2, dVar);
        this.zze = recaptchaAction;
        this.zzf = zzdaVar;
        this.zzg = str;
    }

    @NotNull
    public final o8.d create(@Nullable Object obj, @NotNull o8.d dVar) {
        return new zzcw(this.zze, this.zzf, this.zzg, dVar);
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return create((L) obj, (o8.d) obj2).invokeSuspend(q.a);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object d = p8.c.d();
        int i = this.zzd;
        k.b(obj);
        if (i == 0) {
            zzda zzdaVar = this.zzf;
            String str = this.zzg;
            RecaptchaAction recaptchaAction = this.zze;
            this.zza = zzdaVar;
            this.zzb = str;
            this.zzc = recaptchaAction;
            this.zzd = 1;
            o oVar = new o(p8.b.c(this), 1);
            oVar.v();
            zzda.zzl(zzdaVar).put(str, oVar);
            zzma zzf = zzmb.zzf();
            zzf.zze(str);
            zzf.zzd(recaptchaAction.getAction());
            byte[] zzd = ((zzmb) zzf.zzj()).zzd();
            String zzi = zzeb.zzh().zzi(zzd, 0, zzd.length);
            zzai zzaiVar = zzai.zza;
            zzai.zzc(new zzaf(zzkw.EXECUTE_NATIVE, zzda.zzh(zzdaVar), zzda.zzi(zzdaVar), str, null), zzda.zza(zzdaVar), zzda.zzc(zzdaVar));
            zzdaVar.zzb().evaluateJavascript("recaptcha.m.Main.execute(\"" + zzi + "\")", (ValueCallback) null);
            obj = oVar.r();
            if (obj == p8.c.d()) {
                h.c(this);
            }
            if (obj == d) {
                return d;
            }
        }
        return obj;
    }
}
