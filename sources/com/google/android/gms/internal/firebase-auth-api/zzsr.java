package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.internal.firebase-auth-api.zzajc;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzsr extends zzajc implements zzakp {
    private static final zzsr zzc;
    private static volatile zzakw zzd;
    private int zze;

    public static final class zza extends zzajc.zza implements zzakp {
        private zza() {
            super(zzsr.zzc());
        }

        public final zza zza(int i) {
            zzi();
            zzsr.zza((zzsr) this.zza, i);
            return this;
        }

        public /* synthetic */ zza(zzss zzssVar) {
            this();
        }
    }

    static {
        zzsr zzsrVar = new zzsr();
        zzc = zzsrVar;
        zzajc.zza(zzsr.class, zzsrVar);
    }

    private zzsr() {
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    public static /* synthetic */ zzsr zzc() {
        return zzc;
    }

    public static zzsr zzd() {
        return zzc;
    }

    public final int zza() {
        return this.zze;
    }

    /* JADX WARN: Type inference failed for: r1v13, types: [com.google.android.gms.internal.firebase-auth-api.zzajc$zzc, com.google.android.gms.internal.firebase-auth-api.zzakw] */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzss.zza[i - 1]) {
            case 1:
                return new zzsr();
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
                    synchronized (zzsr.class) {
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

    public static /* synthetic */ void zza(zzsr zzsrVar, int i) {
        zzsrVar.zza(i);
    }
}
