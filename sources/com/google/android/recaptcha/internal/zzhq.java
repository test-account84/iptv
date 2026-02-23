package com.google.android.recaptcha.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzhq implements zzim {
    private static final zzhw zza = new zzho();
    private final zzhw zzb;

    public zzhq() {
        zzhw zzhwVar;
        zzgh zza2 = zzgh.zza();
        try {
            zzhwVar = (zzhw) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", (Class[]) null).invoke((Object) null, (Object[]) null);
        } catch (Exception unused) {
            zzhwVar = zza;
        }
        zzhp zzhpVar = new zzhp(zza2, zzhwVar);
        byte[] bArr = zzgw.zzd;
        this.zzb = zzhpVar;
    }

    private static boolean zzb(zzhv zzhvVar) {
        return zzhvVar.zzc() == 1;
    }

    public final zzil zza(Class cls) {
        zzie zza2;
        zzhm zzd;
        zzjf zzz;
        zzga zzgaVar;
        zzht zza3;
        zzjf zzy;
        zzga zza4;
        zzin.zzF(cls);
        zzhv zzb = this.zzb.zzb(cls);
        if (zzb.zzb()) {
            if (zzgo.class.isAssignableFrom(cls)) {
                zzy = zzin.zzA();
                zza4 = zzgc.zzb();
            } else {
                zzy = zzin.zzy();
                zza4 = zzgc.zza();
            }
            return zzic.zzc(zzy, zza4, zzb.zza());
        }
        if (zzgo.class.isAssignableFrom(cls)) {
            boolean zzb2 = zzb(zzb);
            zza2 = zzif.zzb();
            zzd = zzhm.zze();
            zzz = zzin.zzA();
            zzgaVar = zzb2 ? zzgc.zzb() : null;
            zza3 = zzhu.zzb();
        } else {
            boolean zzb3 = zzb(zzb);
            zza2 = zzif.zza();
            zzd = zzhm.zzd();
            if (zzb3) {
                zzz = zzin.zzy();
                zzgaVar = zzgc.zza();
            } else {
                zzz = zzin.zzz();
                zzgaVar = null;
            }
            zza3 = zzhu.zza();
        }
        return zzib.zzm(cls, zzb, zza2, zzd, zzz, zzgaVar, zza3);
    }
}
