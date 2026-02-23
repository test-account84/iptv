package com.google.android.recaptcha.internal;

import G8.L;
import android.content.ContentValues;
import k8.k;
import k8.q;
import l8.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q8.l;
import w8.p;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzan extends l implements p {
    final /* synthetic */ zzkx zza;
    final /* synthetic */ zzao zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzan(zzkx zzkxVar, zzao zzaoVar, o8.d dVar) {
        super(2, dVar);
        this.zza = zzkxVar;
        this.zzb = zzaoVar;
    }

    @NotNull
    public final o8.d create(@Nullable Object obj, @NotNull o8.d dVar) {
        return new zzan(this.zza, this.zzb, dVar);
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return create((L) obj, (o8.d) obj2).invokeSuspend(q.a);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        p8.c.d();
        k.b(obj);
        zzkx zzkxVar = this.zza;
        zzao zzaoVar = this.zzb;
        synchronized (zzaj.class) {
            try {
                byte[] zzd = zzkxVar.zzd();
                zzae zzaeVar = new zzae(zzeb.zzg().zzi(zzd, 0, zzd.length), System.currentTimeMillis(), 0);
                zzad zza = zzao.zza(zzaoVar);
                ContentValues contentValues = new ContentValues();
                contentValues.put("ss", zzaeVar.zzc());
                contentValues.put("ts", Long.valueOf(zzaeVar.zzb()));
                zza.getWritableDatabase().insert("ce", (String) null, contentValues);
                int zzb = zzao.zza(zzaoVar).zzb() - 500;
                if (zzb > 0) {
                    zzao.zza(zzaoVar).zza(s.H(zzao.zza(zzaoVar).zzd(), zzb));
                }
                if (zzao.zza(zzaoVar).zzb() >= 20) {
                    zzao.zzd(zzaoVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return q.a;
    }
}
