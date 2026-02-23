package com.google.android.recaptcha.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class zzgj extends zzgi implements zzhz {
    public zzgj(zzgk zzgkVar) {
        super(zzgkVar);
    }

    /* renamed from: zzd, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final zzgk zzk() {
        zzgo zzk;
        if (((zzgk) this.zza).zzF()) {
            ((zzgk) this.zza).zzb.zzg();
            zzk = super.zzk();
        } else {
            zzk = this.zza;
        }
        return (zzgk) zzk;
    }

    public final void zzn() {
        super.zzn();
        if (((zzgk) this.zza).zzb != zzge.zzd()) {
            zzgk zzgkVar = (zzgk) this.zza;
            zzgkVar.zzb = zzgkVar.zzb.clone();
        }
    }
}
