package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.internal.firebase-auth-api.zzajc;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzuv extends zzajc implements zzakp {
    private static final zzuv zzc;
    private static volatile zzakw zzd;
    private int zze;
    private int zzf;
    private zzur zzg;
    private zzahp zzh = zzahp.zza;

    public static final class zza extends zzajc.zza implements zzakp {
        private zza() {
            super(zzuv.zzd());
        }

        public final zza zza(int i) {
            zzi();
            zzuv.zza((zzuv) this.zza, 0);
            return this;
        }

        public /* synthetic */ zza(zzuw zzuwVar) {
            this();
        }

        public final zza zza(zzahp zzahpVar) {
            zzi();
            zzuv.zza((zzuv) this.zza, zzahpVar);
            return this;
        }

        public final zza zza(zzur zzurVar) {
            zzi();
            zzuv.zza((zzuv) this.zza, zzurVar);
            return this;
        }
    }

    static {
        zzuv zzuvVar = new zzuv();
        zzc = zzuvVar;
        zzajc.zza(zzuv.class, zzuvVar);
    }

    private zzuv() {
    }

    public static zza zzc() {
        return (zza) zzc.zzm();
    }

    public static /* synthetic */ zzuv zzd() {
        return zzc;
    }

    public static zzuv zze() {
        return zzc;
    }

    public final int zza() {
        return this.zzf;
    }

    public final zzur zzb() {
        zzur zzurVar = this.zzg;
        return zzurVar == null ? zzur.zzf() : zzurVar;
    }

    public final zzahp zzf() {
        return this.zzh;
    }

    public final boolean zzg() {
        return (this.zze & 1) != 0;
    }

    public static zzuv zza(zzahp zzahpVar, zzaio zzaioVar) throws zzaji {
        return (zzuv) zzajc.zza(zzc, zzahpVar, zzaioVar);
    }

    /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.firebase-auth-api.zzajc$zzc, com.google.android.gms.internal.firebase-auth-api.zzakw] */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzuw.zza[i - 1]) {
            case 1:
                return new zzuv();
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
                    synchronized (zzuv.class) {
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

    private final void zza(zzur zzurVar) {
        zzurVar.getClass();
        this.zzg = zzurVar;
        this.zze |= 1;
    }

    public static /* synthetic */ void zza(zzuv zzuvVar, int i) {
        zzuvVar.zza(0);
    }

    public static /* synthetic */ void zza(zzuv zzuvVar, zzahp zzahpVar) {
        zzuvVar.zza(zzahpVar);
    }

    public static /* synthetic */ void zza(zzuv zzuvVar, zzur zzurVar) {
        zzuvVar.zza(zzurVar);
    }
}
