package com.google.android.recaptcha.internal;

import G8.L;
import G8.M;
import java.util.List;
import java.util.concurrent.TimeUnit;
import k8.k;
import k8.q;
import l8.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q8.l;
import w8.p;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzax extends l implements p {
    int zza;
    final /* synthetic */ zzba zzb;
    final /* synthetic */ List zzc;
    final /* synthetic */ zzn zzd;
    final /* synthetic */ zzn zze;
    private /* synthetic */ Object zzf;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzax(zzba zzbaVar, List list, zzn zznVar, zzn zznVar2, o8.d dVar) {
        super(2, dVar);
        this.zzb = zzbaVar;
        this.zzc = list;
        this.zzd = zznVar;
        this.zze = zznVar2;
    }

    @NotNull
    public final o8.d create(@Nullable Object obj, @NotNull o8.d dVar) {
        zzax zzaxVar = new zzax(this.zzb, this.zzc, this.zzd, this.zze, dVar);
        zzaxVar.zzf = obj;
        return zzaxVar;
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return create((L) obj, (o8.d) obj2).invokeSuspend(q.a);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object d = p8.c.d();
        int i = this.zza;
        k.b(obj);
        if (i == 0) {
            L l = (L) this.zzf;
            zzbl zzblVar = new zzbl(this.zzb.zzb());
            zzdk zzb = zzdk.zzb();
            while (zzblVar.zzb() >= 0 && zzblVar.zzb() < this.zzc.size() && M.e(l)) {
                zzmv zzmvVar = (zzmv) this.zzc.get(zzblVar.zzb());
                try {
                    int zzk = zzmvVar.zzk();
                    int zzg = zzmvVar.zzg();
                    List zzj = zzmvVar.zzj();
                    if (!zzba.zzs(this.zzb, zzmvVar, zzblVar)) {
                        zzdk zzb2 = zzdk.zzb();
                        int i2 = zzk - 2;
                        if (i2 == 7) {
                            zzba.zzo(this.zzb, zzg, zzj);
                        } else if (i2 == 15) {
                            zzba.zzi(this.zzb, zzj);
                        } else if (i2 == 30) {
                            zzba.zzh(this.zzb, zzg, zzj);
                        } else if (i2 != 40) {
                            switch (i2) {
                                case 10:
                                    zzba.zzm(this.zzb, zzg, zzj);
                                    break;
                                case 11:
                                    zzba.zzn(this.zzb, zzg, zzj);
                                    break;
                                case 12:
                                    zzba.zzp(this.zzb, zzj);
                                    break;
                                case 13:
                                    zzba.zzq(this.zzb, zzj);
                                    break;
                                default:
                                    switch (i2) {
                                        case 18:
                                            zzba.zzk(this.zzb, zzg, zzj);
                                            break;
                                        case 19:
                                            zzba.zzl(this.zzb, zzg, zzj);
                                            break;
                                        case 20:
                                            zzba.zzj(this.zzb, zzj);
                                            break;
                                        default:
                                            throw new zzt(5, 2, null);
                                    }
                            }
                        } else {
                            zzba.zzr(this.zzb, this.zzd, zzg, zzj);
                        }
                        zzb2.zzf();
                        long zza = zzb2.zza(TimeUnit.MICROSECONDS);
                        zzj zzjVar = zzj.zza;
                        zzj.zza(zzms.zza(zzk), zza);
                        q8.b.c(zza);
                        q8.b.b(zzg);
                        s.A(zzj, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new zzaw(this.zzb), 31, (Object) null);
                        zzblVar.zzg(zzblVar.zzb() + 1);
                    }
                } catch (Exception e) {
                    zzba zzbaVar = this.zzb;
                    String zzd = zzblVar.zzd();
                    zzn zznVar = this.zzd;
                    zzn zznVar2 = this.zze;
                    int zzb3 = zzblVar.zzb();
                    this.zza = 1;
                    if (zzba.zze(zzbaVar, e, zzd, zznVar, zznVar2, zzb3, this) == d) {
                        return d;
                    }
                }
            }
            zzb.zzf();
            q8.b.c(zzb.zza(TimeUnit.MICROSECONDS));
            return q.a;
        }
        return q.a;
    }
}
