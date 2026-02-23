package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.internal.firebase-auth-api.zzajc;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzuu extends zzajc implements zzakp {
    private static final zzuu zzc;
    private static volatile zzakw zzd;
    private int zze;
    private int zzf;
    private zzuv zzg;
    private zzahp zzh = zzahp.zza;

    public static final class zza extends zzajc.zza implements zzakp {
        private zza() {
            super(zzuu.zzc());
        }

        public final zza zza(int i) {
            zzi();
            zzuu.zza((zzuu) this.zza, 0);
            return this;
        }

        public /* synthetic */ zza(zzut zzutVar) {
            this();
        }

        public final zza zza(zzahp zzahpVar) {
            zzi();
            zzuu.zza((zzuu) this.zza, zzahpVar);
            return this;
        }

        public final zza zza(zzuv zzuvVar) {
            zzi();
            zzuu.zza((zzuu) this.zza, zzuvVar);
            return this;
        }
    }

    static {
        zzuu zzuuVar = new zzuu();
        zzc = zzuuVar;
        zzajc.zza(zzuu.class, zzuuVar);
    }

    private zzuu() {
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    public static /* synthetic */ zzuu zzc() {
        return zzc;
    }

    public final int zza() {
        return this.zzf;
    }

    public final zzuv zzd() {
        zzuv zzuvVar = this.zzg;
        return zzuvVar == null ? zzuv.zze() : zzuvVar;
    }

    public final zzahp zze() {
        return this.zzh;
    }

    public final boolean zzf() {
        return (this.zze & 1) != 0;
    }

    public static zzuu zza(zzahp zzahpVar, zzaio zzaioVar) throws zzaji {
        return (zzuu) zzajc.zza(zzc, zzahpVar, zzaioVar);
    }

    /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.firebase-auth-api.zzajc$zzc, com.google.android.gms.internal.firebase-auth-api.zzakw] */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzut.zza[i - 1]) {
            case 1:
                return new zzuu();
            case 2:
                return new zza(null);
            case 3:
                return zzajc.zza(zzc, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n", new Object[]{"zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzc;
            case 5:
                zzakw zzakwVar = zzd;
                zzakw zzakwVar2 = zzakwVar;
                if (zzakwVar == null) {
                    synchronized (zzuu.class) {
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

    private final void zza(zzahp zzahpVar) {
        zzahpVar.getClass();
        this.zzh = zzahpVar;
    }

    public static /* synthetic */ void zza(zzuu zzuuVar, int i) {
        zzuuVar.zza(0);
    }

    public static /* synthetic */ void zza(zzuu zzuuVar, zzahp zzahpVar) {
        zzuuVar.zza(zzahpVar);
    }

    public static /* synthetic */ void zza(zzuu zzuuVar, zzuv zzuvVar) {
        zzuuVar.zza(zzuvVar);
    }

    private final void zza(zzuv zzuvVar) {
        zzuvVar.getClass();
        this.zzg = zzuvVar;
        this.zze |= 1;
    }
}
