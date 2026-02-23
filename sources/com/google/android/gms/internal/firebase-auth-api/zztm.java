package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.internal.firebase-auth-api.zzajc;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zztm extends zzajc implements zzakp {
    private static final zztm zzc;
    private static volatile zzakw zzd;
    private int zze;
    private zzvb zzf;

    public static final class zza extends zzajc.zza implements zzakp {
        private zza() {
            super(zztm.zzb());
        }

        public final zza zza(zzvb zzvbVar) {
            zzi();
            zztm.zza((zztm) this.zza, zzvbVar);
            return this;
        }

        public /* synthetic */ zza(zztl zztlVar) {
            this();
        }
    }

    static {
        zztm zztmVar = new zztm();
        zzc = zztmVar;
        zzajc.zza(zztm.class, zztmVar);
    }

    private zztm() {
    }

    public static zza zza() {
        return (zza) zzc.zzm();
    }

    public static /* synthetic */ zztm zzb() {
        return zzc;
    }

    public static zztm zzc() {
        return zzc;
    }

    public final zzvb zzd() {
        zzvb zzvbVar = this.zzf;
        return zzvbVar == null ? zzvb.zzc() : zzvbVar;
    }

    /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.firebase-auth-api.zzajc$zzc, com.google.android.gms.internal.firebase-auth-api.zzakw] */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zztl.zza[i - 1]) {
            case 1:
                return new zztm();
            case 2:
                return new zza(null);
            case 3:
                return zzajc.zza(zzc, "\u0000\u0001\u0000\u0001\u0002\u0002\u0001\u0000\u0000\u0000\u0002ဉ\u0000", new Object[]{"zze", "zzf"});
            case 4:
                return zzc;
            case 5:
                zzakw zzakwVar = zzd;
                zzakw zzakwVar2 = zzakwVar;
                if (zzakwVar == null) {
                    synchronized (zztm.class) {
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

    public static /* synthetic */ void zza(zztm zztmVar, zzvb zzvbVar) {
        zztmVar.zza(zzvbVar);
    }

    private final void zza(zzvb zzvbVar) {
        zzvbVar.getClass();
        this.zzf = zzvbVar;
        this.zze |= 1;
    }
}
