package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.internal.firebase-auth-api.zzajc;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzsb extends zzajc implements zzakp {
    private static final zzsb zzc;
    private static volatile zzakw zzd;
    private int zze;

    public static final class zza extends zzajc.zza implements zzakp {
        private zza() {
            super(zzsb.zzc());
        }

        public final zza zza(int i) {
            zzi();
            zzsb.zza((zzsb) this.zza, i);
            return this;
        }

        public /* synthetic */ zza(zzsc zzscVar) {
            this();
        }
    }

    static {
        zzsb zzsbVar = new zzsb();
        zzc = zzsbVar;
        zzajc.zza(zzsb.class, zzsbVar);
    }

    private zzsb() {
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    public static /* synthetic */ zzsb zzc() {
        return zzc;
    }

    public static zzsb zzd() {
        return zzc;
    }

    public final int zza() {
        return this.zze;
    }

    /* JADX WARN: Type inference failed for: r1v13, types: [com.google.android.gms.internal.firebase-auth-api.zzajc$zzc, com.google.android.gms.internal.firebase-auth-api.zzakw] */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzsc.zza[i - 1]) {
            case 1:
                return new zzsb();
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
                    synchronized (zzsb.class) {
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

    public static /* synthetic */ void zza(zzsb zzsbVar, int i) {
        zzsbVar.zza(i);
    }
}
