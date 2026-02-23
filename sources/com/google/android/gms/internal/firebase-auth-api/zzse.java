package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.internal.firebase-auth-api.zzajc;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzse extends zzajc implements zzakp {
    private static final zzse zzc;
    private static volatile zzakw zzd;
    private int zze;
    private int zzf;
    private zzsi zzg;
    private zzuc zzh;

    public static final class zza extends zzajc.zza implements zzakp {
        private zza() {
            super(zzse.zzc());
        }

        public final zza zza(int i) {
            zzi();
            zzse.zza((zzse) this.zza, i);
            return this;
        }

        public /* synthetic */ zza(zzsd zzsdVar) {
            this();
        }

        public final zza zza(zzsi zzsiVar) {
            zzi();
            zzse.zza((zzse) this.zza, zzsiVar);
            return this;
        }

        public final zza zza(zzuc zzucVar) {
            zzi();
            zzse.zza((zzse) this.zza, zzucVar);
            return this;
        }
    }

    static {
        zzse zzseVar = new zzse();
        zzc = zzseVar;
        zzajc.zza(zzse.class, zzseVar);
    }

    private zzse() {
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    public static /* synthetic */ zzse zzc() {
        return zzc;
    }

    public final int zza() {
        return this.zzf;
    }

    public final zzsi zzd() {
        zzsi zzsiVar = this.zzg;
        return zzsiVar == null ? zzsi.zzd() : zzsiVar;
    }

    public final zzuc zze() {
        zzuc zzucVar = this.zzh;
        return zzucVar == null ? zzuc.zzd() : zzucVar;
    }

    public static zzse zza(zzahp zzahpVar, zzaio zzaioVar) throws zzaji {
        return (zzse) zzajc.zza(zzc, zzahpVar, zzaioVar);
    }

    /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.firebase-auth-api.zzajc$zzc, com.google.android.gms.internal.firebase-auth-api.zzakw] */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzsd.zza[i - 1]) {
            case 1:
                return new zzse();
            case 2:
                return new zza(null);
            case 3:
                return zzajc.zza(zzc, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003ဉ\u0001", new Object[]{"zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzc;
            case 5:
                zzakw zzakwVar = zzd;
                zzakw zzakwVar2 = zzakwVar;
                if (zzakwVar == null) {
                    synchronized (zzse.class) {
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

    private final void zza(int i) {
        this.zzf = i;
    }

    public static /* synthetic */ void zza(zzse zzseVar, int i) {
        zzseVar.zza(i);
    }

    public static /* synthetic */ void zza(zzse zzseVar, zzsi zzsiVar) {
        zzseVar.zza(zzsiVar);
    }

    public static /* synthetic */ void zza(zzse zzseVar, zzuc zzucVar) {
        zzseVar.zza(zzucVar);
    }

    private final void zza(zzsi zzsiVar) {
        zzsiVar.getClass();
        this.zzg = zzsiVar;
        this.zze |= 1;
    }

    private final void zza(zzuc zzucVar) {
        zzucVar.getClass();
        this.zzh = zzucVar;
        this.zze |= 2;
    }
}
