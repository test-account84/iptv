package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.internal.firebase-auth-api.zzajc;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzsy extends zzajc implements zzakp {
    private static final zzsy zzc;
    private static volatile zzakw zzd;
    private int zze;
    private zzahp zzf = zzahp.zza;

    public static final class zza extends zzajc.zza implements zzakp {
        private zza() {
            super(zzsy.zzc());
        }

        public final zza zza(int i) {
            zzi();
            zzsy.zza((zzsy) this.zza, i);
            return this;
        }

        public /* synthetic */ zza(zzsx zzsxVar) {
            this();
        }

        public final zza zza(zzahp zzahpVar) {
            zzi();
            zzsy.zza((zzsy) this.zza, zzahpVar);
            return this;
        }
    }

    static {
        zzsy zzsyVar = new zzsy();
        zzc = zzsyVar;
        zzajc.zza(zzsy.class, zzsyVar);
    }

    private zzsy() {
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    public static /* synthetic */ zzsy zzc() {
        return zzc;
    }

    public final int zza() {
        return this.zze;
    }

    public final zzahp zzd() {
        return this.zzf;
    }

    public static zzsy zza(zzahp zzahpVar, zzaio zzaioVar) throws zzaji {
        return (zzsy) zzajc.zza(zzc, zzahpVar, zzaioVar);
    }

    /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.firebase-auth-api.zzajc$zzc, com.google.android.gms.internal.firebase-auth-api.zzakw] */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzsx.zza[i - 1]) {
            case 1:
                return new zzsy();
            case 2:
                return new zza(null);
            case 3:
                return zzajc.zza(zzc, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[]{"zze", "zzf"});
            case 4:
                return zzc;
            case 5:
                zzakw zzakwVar = zzd;
                zzakw zzakwVar2 = zzakwVar;
                if (zzakwVar == null) {
                    synchronized (zzsy.class) {
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

    private final void zza(zzahp zzahpVar) {
        zzahpVar.getClass();
        this.zzf = zzahpVar;
    }

    public static /* synthetic */ void zza(zzsy zzsyVar, int i) {
        zzsyVar.zza(i);
    }

    public static /* synthetic */ void zza(zzsy zzsyVar, zzahp zzahpVar) {
        zzsyVar.zza(zzahpVar);
    }
}
