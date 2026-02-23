package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.internal.firebase-auth-api.zzajc;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzsa extends zzajc implements zzakp {
    private static final zzsa zzc;
    private static volatile zzakw zzd;
    private int zze;
    private int zzf;
    private zzsb zzg;

    public static final class zza extends zzajc.zza implements zzakp {
        private zza() {
            super(zzsa.zzc());
        }

        public final zza zza(int i) {
            zzi();
            zzsa.zza((zzsa) this.zza, i);
            return this;
        }

        public /* synthetic */ zza(zzrz zzrzVar) {
            this();
        }

        public final zza zza(zzsb zzsbVar) {
            zzi();
            zzsa.zza((zzsa) this.zza, zzsbVar);
            return this;
        }
    }

    static {
        zzsa zzsaVar = new zzsa();
        zzc = zzsaVar;
        zzajc.zza(zzsa.class, zzsaVar);
    }

    private zzsa() {
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    public static /* synthetic */ zzsa zzc() {
        return zzc;
    }

    public final int zza() {
        return this.zzf;
    }

    public final zzsb zzd() {
        zzsb zzsbVar = this.zzg;
        return zzsbVar == null ? zzsb.zzd() : zzsbVar;
    }

    public static zzsa zza(zzahp zzahpVar, zzaio zzaioVar) throws zzaji {
        return (zzsa) zzajc.zza(zzc, zzahpVar, zzaioVar);
    }

    /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.firebase-auth-api.zzajc$zzc, com.google.android.gms.internal.firebase-auth-api.zzakw] */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzrz.zza[i - 1]) {
            case 1:
                return new zzsa();
            case 2:
                return new zza(null);
            case 3:
                return zzajc.zza(zzc, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzakw zzakwVar = zzd;
                zzakw zzakwVar2 = zzakwVar;
                if (zzakwVar == null) {
                    synchronized (zzsa.class) {
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

    public static /* synthetic */ void zza(zzsa zzsaVar, int i) {
        zzsaVar.zza(i);
    }

    public static /* synthetic */ void zza(zzsa zzsaVar, zzsb zzsbVar) {
        zzsaVar.zza(zzsbVar);
    }

    private final void zza(zzsb zzsbVar) {
        zzsbVar.getClass();
        this.zzg = zzsbVar;
        this.zze |= 1;
    }
}
