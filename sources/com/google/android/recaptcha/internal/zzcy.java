package com.google.android.recaptcha.internal;

import G8.L;
import android.content.Context;
import k8.k;
import k8.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q8.l;
import w8.p;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzcy extends l implements p {
    Object zza;
    Object zzb;
    Object zzc;
    int zzd;
    final /* synthetic */ zzda zze;
    final /* synthetic */ String zzf;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzcy(zzda zzdaVar, String str, o8.d dVar) {
        super(2, dVar);
        this.zze = zzdaVar;
        this.zzf = str;
    }

    @NotNull
    public final o8.d create(@Nullable Object obj, @NotNull o8.d dVar) {
        return new zzcy(this.zze, this.zzf, dVar);
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return create((L) obj, (o8.d) obj2).invokeSuspend(q.a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [kotlinx.coroutines.sync.b] */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v7 */
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        kotlinx.coroutines.sync.b zzn;
        Object obj2;
        Object obj3;
        kotlinx.coroutines.sync.b bVar;
        Object d = p8.c.d();
        int i = this.zzd;
        try {
            if (i == 0) {
                k.b(obj);
                zzda zzdaVar = this.zze;
                zzn = zzda.zzn(zzdaVar);
                obj2 = this.zzf;
                this.zza = zzn;
                this.zzb = zzdaVar;
                this.zzc = obj2;
                this.zzd = 1;
                if (zzn.a((Object) null, this) == d) {
                    return d;
                }
                obj3 = zzdaVar;
            } else {
                if (i != 1) {
                    bVar = this.zza;
                    try {
                        k.b(obj);
                        bVar = bVar;
                        q qVar = q.a;
                        bVar.c((Object) null);
                        return q.a;
                    } catch (Throwable th) {
                        th = th;
                        bVar.c((Object) null);
                        throw th;
                    }
                }
                Object obj4 = this.zzc;
                obj3 = this.zzb;
                Object obj5 = this.zza;
                k.b(obj);
                obj2 = obj4;
                zzn = obj5;
            }
            String zzb = zzda.zzc((zzda) obj3).zzb();
            String zzj = zzda.zzj((zzda) obj3);
            String zzi = zzda.zzi((zzda) obj3);
            String zzh = zzda.zzh((zzda) obj3);
            Context zza = zzda.zza((zzda) obj3);
            zzr zzc = zzda.zzc((zzda) obj3);
            this.zza = zzn;
            this.zzb = null;
            this.zzc = null;
            this.zzd = 2;
            if (zzbj.zzb(zzb, zzj, (String) obj2, zzi, zzh, zza, zzc, this) == d) {
                return d;
            }
            bVar = zzn;
            q qVar2 = q.a;
            bVar.c((Object) null);
            return q.a;
        } catch (Throwable th2) {
            th = th2;
            bVar = zzn;
            bVar.c((Object) null);
            throw th;
        }
    }
}
