package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.internal.firebase-auth-api.zzajc;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzamb extends zzajc implements zzakp {
    private static final zzamb zzc;
    private static volatile zzakw zzd;
    private long zze;
    private int zzf;

    public static final class zza extends zzajc.zza implements zzakp {
        private zza() {
            super(zzamb.zzd());
        }

        public final zza zza(int i) {
            if (!this.zza.zzu()) {
                zzj();
            }
            zzamb.zza((zzamb) this.zza, i);
            return this;
        }

        public /* synthetic */ zza(zzama zzamaVar) {
            this();
        }

        public final zza zza(long j) {
            if (!this.zza.zzu()) {
                zzj();
            }
            zzamb.zza((zzamb) this.zza, j);
            return this;
        }
    }

    static {
        zzamb zzambVar = new zzamb();
        zzc = zzambVar;
        zzajc.zza(zzamb.class, zzambVar);
    }

    private zzamb() {
    }

    public static zza zzc() {
        return (zza) zzc.zzm();
    }

    public static /* synthetic */ zzamb zzd() {
        return zzc;
    }

    public final int zza() {
        return this.zzf;
    }

    public final long zzb() {
        return this.zze;
    }

    /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.firebase-auth-api.zzajc$zzc, com.google.android.gms.internal.firebase-auth-api.zzakw] */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzama.zza[i - 1]) {
            case 1:
                return new zzamb();
            case 2:
                return new zza(null);
            case 3:
                return zzajc.zza(zzc, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0002\u0004", new Object[]{"zze", "zzf"});
            case 4:
                return zzc;
            case 5:
                zzakw zzakwVar = zzd;
                zzakw zzakwVar2 = zzakwVar;
                if (zzakwVar == null) {
                    synchronized (zzamb.class) {
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

    private final void zza(long j) {
        this.zze = j;
    }

    public static /* synthetic */ void zza(zzamb zzambVar, int i) {
        zzambVar.zza(i);
    }

    public static /* synthetic */ void zza(zzamb zzambVar, long j) {
        zzambVar.zza(j);
    }
}
