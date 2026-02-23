package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.internal.firebase-auth-api.zzajc;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzur extends zzajc implements zzakp {
    private static final zzur zzc;
    private static volatile zzakw zzd;
    private int zze;
    private int zzf;
    private int zzg;

    public static final class zza extends zzajc.zza implements zzakp {
        private zza() {
            super(zzur.zze());
        }

        public final zza zza(zzuk zzukVar) {
            zzi();
            zzur.zza((zzur) this.zza, zzukVar);
            return this;
        }

        public /* synthetic */ zza(zzus zzusVar) {
            this();
        }

        public final zza zza(zzum zzumVar) {
            zzi();
            zzur.zza((zzur) this.zza, zzumVar);
            return this;
        }

        public final zza zza(zzuo zzuoVar) {
            zzi();
            zzur.zza((zzur) this.zza, zzuoVar);
            return this;
        }
    }

    static {
        zzur zzurVar = new zzur();
        zzc = zzurVar;
        zzajc.zza(zzur.class, zzurVar);
    }

    private zzur() {
    }

    public static zza zzd() {
        return (zza) zzc.zzm();
    }

    public static /* synthetic */ zzur zze() {
        return zzc;
    }

    public static zzur zzf() {
        return zzc;
    }

    public final zzuk zza() {
        zzuk zza2 = zzuk.zza(this.zzg);
        return zza2 == null ? zzuk.UNRECOGNIZED : zza2;
    }

    public final zzum zzb() {
        zzum zza2 = zzum.zza(this.zzf);
        return zza2 == null ? zzum.UNRECOGNIZED : zza2;
    }

    public final zzuo zzc() {
        zzuo zza2 = zzuo.zza(this.zze);
        return zza2 == null ? zzuo.UNRECOGNIZED : zza2;
    }

    /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.firebase-auth-api.zzajc$zzc, com.google.android.gms.internal.firebase-auth-api.zzakw] */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzus.zza[i - 1]) {
            case 1:
                return new zzur();
            case 2:
                return new zza(null);
            case 3:
                return zzajc.zza(zzc, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0002\f\u0003\f", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzakw zzakwVar = zzd;
                zzakw zzakwVar2 = zzakwVar;
                if (zzakwVar == null) {
                    synchronized (zzur.class) {
                        try {
                            zzakw zzakwVar3 = zzd;
                            zzakw zzakwVar4 = zzakwVar3;
                            if (zzakwVar3 == null) {
                                ?? zzcVar = new zzajc.zzc(zzc);
                                zzd = zzcVar;
                                zzakwVar4 = zzcVar;
                            }
                        } finally {
                        }
                    }
                }
                return zzakwVar2;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    private final void zza(zzuk zzukVar) {
        this.zzg = zzukVar.zza();
    }

    private final void zza(zzum zzumVar) {
        this.zzf = zzumVar.zza();
    }

    private final void zza(zzuo zzuoVar) {
        this.zze = zzuoVar.zza();
    }

    public static /* synthetic */ void zza(zzur zzurVar, zzuk zzukVar) {
        zzurVar.zza(zzukVar);
    }

    public static /* synthetic */ void zza(zzur zzurVar, zzum zzumVar) {
        zzurVar.zza(zzumVar);
    }

    public static /* synthetic */ void zza(zzur zzurVar, zzuo zzuoVar) {
        zzurVar.zza(zzuoVar);
    }
}
