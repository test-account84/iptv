package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.internal.firebase-auth-api.zzajc;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzsv extends zzajc implements zzakp {
    private static final zzsv zzc;
    private static volatile zzakw zzd;
    private int zze;
    private int zzf;

    public static final class zza extends zzajc.zza implements zzakp {
        private zza() {
            super(zzsv.zzd());
        }

        public final zza zza(int i) {
            zzi();
            zzsv.zza((zzsv) this.zza, i);
            return this;
        }

        public /* synthetic */ zza(zzsw zzswVar) {
            this();
        }
    }

    static {
        zzsv zzsvVar = new zzsv();
        zzc = zzsvVar;
        zzajc.zza(zzsv.class, zzsvVar);
    }

    private zzsv() {
    }

    public static zza zzc() {
        return (zza) zzc.zzm();
    }

    public static /* synthetic */ zzsv zzd() {
        return zzc;
    }

    public final int zza() {
        return this.zze;
    }

    public final int zzb() {
        return this.zzf;
    }

    public static zzsv zza(zzahp zzahpVar, zzaio zzaioVar) throws zzaji {
        return (zzsv) zzajc.zza(zzc, zzahpVar, zzaioVar);
    }

    /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.firebase-auth-api.zzajc$zzc, com.google.android.gms.internal.firebase-auth-api.zzakw] */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzsw.zza[i - 1]) {
            case 1:
                return new zzsv();
            case 2:
                return new zza(null);
            case 3:
                return zzajc.zza(zzc, "\u0000\u0002\u0000\u0000\u0002\u0003\u0002\u0000\u0000\u0000\u0002\u000b\u0003\u000b", new Object[]{"zze", "zzf"});
            case 4:
                return zzc;
            case 5:
                zzakw zzakwVar = zzd;
                zzakw zzakwVar2 = zzakwVar;
                if (zzakwVar == null) {
                    synchronized (zzsv.class) {
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
        this.zze = i;
    }

    public static /* synthetic */ void zza(zzsv zzsvVar, int i) {
        zzsvVar.zza(i);
    }
}
