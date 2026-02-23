package com.google.android.recaptcha.internal;

import G8.L;
import java.util.List;
import java.util.concurrent.TimeUnit;
import k8.k;
import k8.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q8.l;
import w8.p;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzaz extends l implements p {
    Object zza;
    int zzb;
    final /* synthetic */ zzba zzc;
    final /* synthetic */ String zzd;
    final /* synthetic */ zzn zze;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzaz(zzba zzbaVar, String str, zzn zznVar, o8.d dVar) {
        super(2, dVar);
        this.zzc = zzbaVar;
        this.zzd = str;
        this.zze = zznVar;
    }

    @NotNull
    public final o8.d create(@Nullable Object obj, @NotNull o8.d dVar) {
        return new zzaz(this.zzc, this.zzd, this.zze, dVar);
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return create((L) obj, (o8.d) obj2).invokeSuspend(q.a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object d = p8.c.d();
        zzn zznVar = this.zzb;
        try {
        } catch (Exception e) {
            zzba zzbaVar = this.zzc;
            zzn zznVar2 = this.zze;
            this.zza = null;
            this.zzb = 2;
            if (zzba.zzf(zzbaVar, e, "recaptcha.m.Main.rge", zznVar2, zznVar, 0, this, 16, null) == d) {
                return d;
            }
        }
        if (zznVar == 0) {
            k.b(obj);
            zzn zznVar3 = new zzn();
            zzmp zzg = zzmp.zzg(zzeb.zzh().zzj(this.zzd));
            zzdk zzb = zzdk.zzb();
            zzmh zzc = zzba.zzc(this.zzc, zzg.zzi(), zzg.zzj());
            zzb.zzf();
            long zza = zzb.zza(TimeUnit.MICROSECONDS);
            zzj zzjVar = zzj.zza;
            zzj.zza(zzl.zzm.zza(), zza);
            zzba zzbaVar2 = this.zzc;
            List zzi = zzc.zzi();
            zzn zznVar4 = this.zze;
            this.zza = zznVar3;
            this.zzb = 1;
            Object zzd = zzba.zzd(zzbaVar2, zzi, zznVar4, zznVar3, this);
            zznVar = zznVar3;
            if (zzd == d) {
                return d;
            }
        } else {
            if (zznVar != 1) {
                k.b(obj);
                return q.a;
            }
            Object obj2 = this.zza;
            k.b(obj);
            zznVar = obj2;
        }
        return q.a;
    }
}
