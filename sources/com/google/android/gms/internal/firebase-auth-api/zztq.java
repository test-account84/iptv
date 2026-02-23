package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.internal.firebase-auth-api.zzajc;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zztq extends zzajc implements zzakp {
    private static final zztq zzc;
    private static volatile zzakw zzd;
    private int zze;
    private zztv zzf;
    private zztm zzg;
    private int zzh;

    public static final class zza extends zzajc.zza implements zzakp {
        private zza() {
            super(zztq.zzd());
        }

        public final zza zza(zztk zztkVar) {
            zzi();
            zztq.zza((zztq) this.zza, zztkVar);
            return this;
        }

        public /* synthetic */ zza(zztp zztpVar) {
            this();
        }

        public final zza zza(zztm zztmVar) {
            zzi();
            zztq.zza((zztq) this.zza, zztmVar);
            return this;
        }

        public final zza zza(zztv zztvVar) {
            zzi();
            zztq.zza((zztq) this.zza, zztvVar);
            return this;
        }
    }

    static {
        zztq zztqVar = new zztq();
        zzc = zztqVar;
        zzajc.zza(zztq.class, zztqVar);
    }

    private zztq() {
    }

    public static zza zzc() {
        return (zza) zzc.zzm();
    }

    public static /* synthetic */ zztq zzd() {
        return zzc;
    }

    public static zztq zze() {
        return zzc;
    }

    public final zztk zza() {
        zztk zza2 = zztk.zza(this.zzh);
        return zza2 == null ? zztk.UNRECOGNIZED : zza2;
    }

    public final zztm zzb() {
        zztm zztmVar = this.zzg;
        return zztmVar == null ? zztm.zzc() : zztmVar;
    }

    public final zztv zzf() {
        zztv zztvVar = this.zzf;
        return zztvVar == null ? zztv.zzc() : zztvVar;
    }

    /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.firebase-auth-api.zzajc$zzc, com.google.android.gms.internal.firebase-auth-api.zzakw] */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zztp.zza[i - 1]) {
            case 1:
                return new zztq();
            case 2:
                return new zza(null);
            case 3:
                return zzajc.zza(zzc, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003\f", new Object[]{"zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzc;
            case 5:
                zzakw zzakwVar = zzd;
                zzakw zzakwVar2 = zzakwVar;
                if (zzakwVar == null) {
                    synchronized (zztq.class) {
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

    private final void zza(zztk zztkVar) {
        this.zzh = zztkVar.zza();
    }

    private final void zza(zztm zztmVar) {
        zztmVar.getClass();
        this.zzg = zztmVar;
        this.zze |= 2;
    }

    public static /* synthetic */ void zza(zztq zztqVar, zztk zztkVar) {
        zztqVar.zza(zztkVar);
    }

    public static /* synthetic */ void zza(zztq zztqVar, zztm zztmVar) {
        zztqVar.zza(zztmVar);
    }

    public static /* synthetic */ void zza(zztq zztqVar, zztv zztvVar) {
        zztqVar.zza(zztvVar);
    }

    private final void zza(zztv zztvVar) {
        zztvVar.getClass();
        this.zzf = zztvVar;
        this.zze |= 1;
    }
}
