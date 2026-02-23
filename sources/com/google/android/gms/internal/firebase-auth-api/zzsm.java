package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.internal.firebase-auth-api.zzajc;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzsm extends zzajc implements zzakp {
    private static final zzsm zzc;
    private static volatile zzakw zzd;
    private int zze;

    public static final class zza extends zzajc.zza implements zzakp {
        private zza() {
            super(zzsm.zzc());
        }

        public final zza zza(int i) {
            zzi();
            zzsm.zza((zzsm) this.zza, i);
            return this;
        }

        public /* synthetic */ zza(zzsl zzslVar) {
            this();
        }
    }

    static {
        zzsm zzsmVar = new zzsm();
        zzc = zzsmVar;
        zzajc.zza(zzsm.class, zzsmVar);
    }

    private zzsm() {
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    public static /* synthetic */ zzsm zzc() {
        return zzc;
    }

    public static zzsm zzd() {
        return zzc;
    }

    public final int zza() {
        return this.zze;
    }

    /* JADX WARN: Type inference failed for: r1v13, types: [com.google.android.gms.internal.firebase-auth-api.zzajc$zzc, com.google.android.gms.internal.firebase-auth-api.zzakw] */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzsl.zza[i - 1]) {
            case 1:
                return new zzsm();
            case 2:
                return new zza(null);
            case 3:
                return zzajc.zza(zzc, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zze"});
            case 4:
                return zzc;
            case 5:
                zzakw zzakwVar = zzd;
                zzakw zzakwVar2 = zzakwVar;
                if (zzakwVar == null) {
                    synchronized (zzsm.class) {
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

    public static /* synthetic */ void zza(zzsm zzsmVar, int i) {
        zzsmVar.zza(i);
    }
}
