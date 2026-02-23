package com.google.android.recaptcha.internal;

import G8.L;
import G8.M;
import k8.k;
import k8.q;
import kotlin.jvm.internal.C;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q8.l;
import w8.p;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzay extends l implements p {
    final /* synthetic */ Exception zza;
    final /* synthetic */ int zzb;
    final /* synthetic */ zzn zzc;
    final /* synthetic */ zzn zzd;
    final /* synthetic */ String zze;
    final /* synthetic */ zzba zzf;
    private /* synthetic */ Object zzg;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzay(Exception exc, int i, zzn zznVar, zzn zznVar2, String str, zzba zzbaVar, o8.d dVar) {
        super(2, dVar);
        this.zza = exc;
        this.zzb = i;
        this.zzc = zznVar;
        this.zzd = zznVar2;
        this.zze = str;
        this.zzf = zzbaVar;
    }

    @NotNull
    public final o8.d create(@Nullable Object obj, @NotNull o8.d dVar) {
        zzay zzayVar = new zzay(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, dVar);
        zzayVar.zzg = obj;
        return zzayVar;
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return create((L) obj, (o8.d) obj2).invokeSuspend(q.a);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        zzmi zzf;
        p8.c.d();
        k.b(obj);
        L l = (L) this.zzg;
        Exception exc = this.zza;
        if (exc instanceof zzt) {
            zzf = ((zzt) exc).zza();
            zzf.zzd(this.zzb);
        } else {
            zzf = zzmj.zzf();
            zzf.zzd(this.zzb);
            zzf.zzp(2);
            zzf.zze(2);
        }
        zzmj zzmjVar = (zzmj) zzf.zzj();
        zzmjVar.zzk();
        zzmjVar.zzj();
        C.b(this.zza.getClass()).b();
        this.zza.getMessage();
        zzlg zza = zzar.zza(this.zzc, this.zzd);
        String str = this.zze;
        if (str.length() == 0) {
            str = "recaptcha.m.Main.rge";
        }
        if (M.e(l)) {
            zzba zzbaVar = this.zzf;
            zzeb zzh = zzeb.zzh();
            byte[] zzd = zzmjVar.zzd();
            String zzi = zzh.zzi(zzd, 0, zzd.length);
            zzeb zzh2 = zzeb.zzh();
            byte[] zzd2 = zza.zzd();
            zzba.zzg(zzbaVar, str, zzi, zzh2.zzi(zzd2, 0, zzd2.length));
        }
        return q.a;
    }
}
