package com.google.android.gms.internal.cast;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzth implements zzub {
    private static final zztn zza = new zztf();
    private final zztn zzb;

    public zzth() {
        zztn zztnVar;
        zzsd zza2 = zzsd.zza();
        try {
            zztnVar = (zztn) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", (Class[]) null).invoke((Object) null, (Object[]) null);
        } catch (Exception unused) {
            zztnVar = zza;
        }
        zztg zztgVar = new zztg(zza2, zztnVar);
        byte[] bArr = zzsq.zzd;
        this.zzb = zztgVar;
    }

    private static boolean zzb(zztm zztmVar) {
        return zztmVar.zzc() == 1;
    }

    public final zzua zza(Class cls) {
        zztu zza2;
        zztd zzc;
        zzur zzz;
        zzrx zzrxVar;
        zztk zza3;
        zzur zzy;
        zzrx zza4;
        zzuc.zzC(cls);
        zztm zzb = this.zzb.zzb(cls);
        if (zzb.zzb()) {
            if (zzsh.class.isAssignableFrom(cls)) {
                zzy = zzuc.zzA();
                zza4 = zzrz.zzb();
            } else {
                zzy = zzuc.zzy();
                zza4 = zzrz.zza();
            }
            return zztt.zzi(zzy, zza4, zzb.zza());
        }
        if (zzsh.class.isAssignableFrom(cls)) {
            boolean zzb2 = zzb(zzb);
            zza2 = zztv.zzb();
            zzc = zztd.zzd();
            zzz = zzuc.zzA();
            zzrxVar = zzb2 ? zzrz.zzb() : null;
            zza3 = zztl.zzb();
        } else {
            boolean zzb3 = zzb(zzb);
            zza2 = zztv.zza();
            zzc = zztd.zzc();
            if (zzb3) {
                zzz = zzuc.zzy();
                zzrxVar = zzrz.zza();
            } else {
                zzz = zzuc.zzz();
                zzrxVar = null;
            }
            zza3 = zztl.zza();
        }
        return zzts.zzi(cls, zzb, zza2, zzc, zzz, zzrxVar, zza3);
    }
}
