package com.google.android.recaptcha.internal;

import G8.L;
import G8.N;
import G8.i;
import G8.w;
import android.os.Build;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import k8.j;
import k8.k;
import k8.q;
import o8.g;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q8.l;
import w8.p;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzcz extends l implements p {
    int zza;
    final /* synthetic */ zzda zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzcz(zzda zzdaVar, o8.d dVar) {
        super(2, dVar);
        this.zzb = zzdaVar;
    }

    @NotNull
    public final o8.d create(@Nullable Object obj, @NotNull o8.d dVar) {
        return new zzcz(this.zzb, dVar);
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
            zzu zzuVar = zzu.zza;
            String zza = zzu.zza(zzda.zza(this.zzb));
            String zzj = zzda.zzj(this.zzb);
            String packageName = zzda.zza(this.zzb).getPackageName();
            String zzi = zzda.zzi(this.zzb);
            int i2 = Build.VERSION.SDK_INT;
            byte[] bytes = ("k=" + URLEncoder.encode(zzj, "UTF-8") + "&pk=" + URLEncoder.encode(packageName, "UTF-8") + "&mst=" + URLEncoder.encode(zza, "UTF-8") + "&msv=" + URLEncoder.encode("18.1.2", "UTF-8") + "&msi=" + URLEncoder.encode(zzi, "UTF-8") + "&mov=" + i2).getBytes(Charset.forName("UTF-8"));
            zzai zzaiVar = zzai.zza;
            zzai.zzc(new zzaf(zzkw.INIT_NATIVE, zzda.zzh(this.zzb), zzda.zzi(this.zzb), zzda.zzi(this.zzb), null), zzda.zza(this.zzb), zzda.zzc(this.zzb));
            zzai.zzb(new zzaf(zzkw.INIT_NETWORK, zzda.zzh(this.zzb), zzda.zzi(this.zzb), zzda.zzi(this.zzb), null), zzda.zzj(this.zzb), new zzs());
            i.d(zzp.zza(), (g) null, (N) null, new zzcy(this.zzb, zza, null), 3, (Object) null);
            zzda.zze(this.zzb).zzd();
            zzda.zze(this.zzb).zze();
            zzda zzdaVar = this.zzb;
            zzdaVar.zzb().postUrl(zzda.zzc(zzdaVar).zza(), bytes);
            q8.b.b(this.zzb.zzm().hashCode());
            w zzm = this.zzb.zzm();
            this.zza = 1;
            if (zzm.q(this) == d) {
                return d;
            }
        }
        return j.a(j.b(q.a));
    }
}
