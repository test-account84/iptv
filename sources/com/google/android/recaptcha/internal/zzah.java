package com.google.android.recaptcha.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import java.util.Locale;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzah {

    @NotNull
    public static final zzag zza = new zzag(null);

    @Nullable
    private static zzkj zzb;

    @NotNull
    private final String zzc;

    @NotNull
    private final zzs zzd;

    @NotNull
    private final zzku zze;
    private final long zzf;

    public zzah(@NotNull zzaf zzafVar, @NotNull String str, @NotNull zzs zzsVar) {
        this.zzc = str;
        this.zzd = zzsVar;
        zzku zzi = zzkx.zzi();
        this.zze = zzi;
        this.zzf = System.currentTimeMillis();
        zzi.zzq(zzafVar.zza());
        zzi.zze(zzafVar.zzb());
        zzi.zzs(zzafVar.zzc());
        zzi.zzv(zzafVar.zzd());
        zzi.zzu(zzka.zzc(zzka.zzb(System.currentTimeMillis())));
    }

    private static final zzkj zzd(Context context) {
        int i;
        PackageInfo packageInfo;
        int i2;
        String str = "unknown";
        String valueOf = (Build.VERSION.SDK_INT < 33 ? (i2 = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getInt("com.google.android.gms.version", -1)) != -1 : (i2 = b.a(context.getPackageManager(), context.getPackageName(), a.a(128L)).metaData.getInt("com.google.android.gms.version", -1)) != -1) ? String.valueOf(i2) : "unknown";
        try {
            i = Build.VERSION.SDK_INT;
        } catch (PackageManager.NameNotFoundException unused) {
        }
        if (i >= 33) {
            packageInfo = d.a(context.getPackageManager(), context.getPackageName(), c.a(0L));
        } else {
            if (i < 28) {
                str = String.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
                zzki zzf = zzkj.zzf();
                zzf.zzd(Build.VERSION.SDK_INT);
                zzf.zzq(valueOf);
                zzf.zzs("18.1.2");
                zzf.zzp(Build.MODEL);
                zzf.zzr(Build.MANUFACTURER);
                zzf.zze(str);
                return (zzkj) zzf.zzj();
            }
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        }
        str = String.valueOf(e.a(packageInfo));
        zzki zzf2 = zzkj.zzf();
        zzf2.zzd(Build.VERSION.SDK_INT);
        zzf2.zzq(valueOf);
        zzf2.zzs("18.1.2");
        zzf2.zzp(Build.MODEL);
        zzf2.zzr(Build.MANUFACTURER);
        zzf2.zze(str);
        return (zzkj) zzf2.zzj();
    }

    public final long zza() {
        return this.zzf;
    }

    @NotNull
    public final zzku zzb() {
        return this.zze;
    }

    @NotNull
    public final zzkx zzc(@NotNull int i, @Nullable zzkm zzkmVar, @NotNull Context context) {
        zzku zzkuVar = this.zze;
        zzkuVar.zzp(System.currentTimeMillis() - this.zzf);
        zzkuVar.zzw(i);
        if (zzkmVar != null) {
            this.zze.zzr(zzkmVar);
        }
        if (zzb == null) {
            zzb = zzd(context);
        }
        zzku zzkuVar2 = this.zze;
        zzli zzf = zzlj.zzf();
        zzf.zzq(this.zzc);
        zzkj zzkjVar = zzb;
        if (zzkjVar == null) {
            zzkjVar = zzd(context);
        }
        zzf.zzd(zzkjVar);
        zzf.zzp(Locale.getDefault().getISO3Language());
        zzf.zze(Locale.getDefault().getISO3Country());
        zzkuVar2.zzt((zzlj) zzf.zzj());
        return (zzkx) this.zze.zzj();
    }
}
