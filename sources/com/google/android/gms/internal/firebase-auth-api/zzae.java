package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
abstract class zzae extends zzi {
    final CharSequence zza;
    private final zzj zzb;
    private int zze;
    private int zzd = 0;
    private final boolean zzc = false;

    public zzae(zzab zzabVar, CharSequence charSequence) {
        this.zzb = zzab.zzb(zzabVar);
        this.zze = zzab.zza(zzabVar);
        this.zza = charSequence;
    }

    public abstract int zza(int i);

    public final /* synthetic */ Object zza() {
        int i = this.zzd;
        while (true) {
            int i2 = this.zzd;
            if (i2 == -1) {
                zzb();
                return null;
            }
            int zzb = zzb(i2);
            if (zzb == -1) {
                zzb = this.zza.length();
                this.zzd = -1;
            } else {
                this.zzd = zza(zzb);
            }
            int i3 = this.zzd;
            if (i3 != i) {
                while (i < zzb && this.zzb.zza(this.zza.charAt(i))) {
                    i++;
                }
                while (zzb > i && this.zzb.zza(this.zza.charAt(zzb - 1))) {
                    zzb--;
                }
                int i4 = this.zze;
                if (i4 == 1) {
                    zzb = this.zza.length();
                    this.zzd = -1;
                    while (zzb > i && this.zzb.zza(this.zza.charAt(zzb - 1))) {
                        zzb--;
                    }
                } else {
                    this.zze = i4 - 1;
                }
                return this.zza.subSequence(i, zzb).toString();
            }
            int i5 = i3 + 1;
            this.zzd = i5;
            if (i5 > this.zza.length()) {
                this.zzd = -1;
            }
        }
    }

    public abstract int zzb(int i);
}
