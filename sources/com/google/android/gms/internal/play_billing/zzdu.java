package com.google.android.gms.internal.play_billing;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzdu implements zzep {
    private static final zzea zza = new zzds();
    private final zzea zzb;

    public zzdu() {
        zzea zzeaVar;
        zzcm zza2 = zzcm.zza();
        try {
            zzeaVar = (zzea) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", (Class[]) null).invoke((Object) null, (Object[]) null);
        } catch (Exception unused) {
            zzeaVar = zza;
        }
        zzdt zzdtVar = new zzdt(zza2, zzeaVar);
        byte[] bArr = zzda.zzd;
        this.zzb = zzdtVar;
    }

    private static boolean zzb(zzdz zzdzVar) {
        return zzdzVar.zzc() + (-1) != 1;
    }

    public final zzeo zza(Class cls) {
        zzei zza2;
        zzdq zzc;
        zzff zzm;
        zzce zza3;
        zzdx zza4;
        zzff zzm2;
        zzce zza5;
        zzeq.zzr(cls);
        zzdz zzb = this.zzb.zzb(cls);
        if (zzb.zzb()) {
            if (zzcs.class.isAssignableFrom(cls)) {
                zzm2 = zzeq.zzn();
                zza5 = zzcg.zzb();
            } else {
                zzm2 = zzeq.zzm();
                zza5 = zzcg.zza();
            }
            return zzeg.zzc(zzm2, zza5, zzb.zza());
        }
        if (zzcs.class.isAssignableFrom(cls)) {
            boolean zzb2 = zzb(zzb);
            zza2 = zzej.zzb();
            zzc = zzdq.zzd();
            zzm = zzeq.zzn();
            zza3 = zzb2 ? zzcg.zzb() : null;
            zza4 = zzdy.zzb();
        } else {
            boolean zzb3 = zzb(zzb);
            zza2 = zzej.zza();
            zzc = zzdq.zzc();
            zzm = zzeq.zzm();
            zza3 = zzb3 ? zzcg.zza() : null;
            zza4 = zzdy.zza();
        }
        return zzef.zzl(cls, zzb, zza2, zzc, zzm, zza3, zza4);
    }
}
