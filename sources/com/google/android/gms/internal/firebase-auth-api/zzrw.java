package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.internal.firebase-auth-api.zzajc;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzrw extends zzajc implements zzakp {
    private static final zzrw zzc;
    private static volatile zzakw zzd;
    private int zze;
    private int zzf;
    private zzahp zzg = zzahp.zza;
    private zzsb zzh;

    public static final class zza extends zzajc.zza implements zzakp {
        private zza() {
            super(zzrw.zzc());
        }

        public final zza zza(int i) {
            zzi();
            zzrw.zza((zzrw) this.zza, 0);
            return this;
        }

        public /* synthetic */ zza(zzry zzryVar) {
            this();
        }

        public final zza zza(zzahp zzahpVar) {
            zzi();
            zzrw.zza((zzrw) this.zza, zzahpVar);
            return this;
        }

        public final zza zza(zzsb zzsbVar) {
            zzi();
            zzrw.zza((zzrw) this.zza, zzsbVar);
            return this;
        }
    }

    static {
        zzrw zzrwVar = new zzrw();
        zzc = zzrwVar;
        zzajc.zza(zzrw.class, zzrwVar);
    }

    private zzrw() {
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    public static /* synthetic */ zzrw zzc() {
        return zzc;
    }

    public final int zza() {
        return this.zzf;
    }

    public final zzsb zzd() {
        zzsb zzsbVar = this.zzh;
        return zzsbVar == null ? zzsb.zzd() : zzsbVar;
    }

    public final zzahp zze() {
        return this.zzg;
    }

    public static zzrw zza(zzahp zzahpVar, zzaio zzaioVar) throws zzaji {
        return (zzrw) zzajc.zza(zzc, zzahpVar, zzaioVar);
    }

    /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.firebase-auth-api.zzajc$zzc, com.google.android.gms.internal.firebase-auth-api.zzakw] */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzry.zza[i - 1]) {
            case 1:
                return new zzrw();
            case 2:
                return new zza(null);
            case 3:
                return zzajc.zza(zzc, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\n\u0003ဉ\u0000", new Object[]{"zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzc;
            case 5:
                zzakw zzakwVar = zzd;
                zzakw zzakwVar2 = zzakwVar;
                if (zzakwVar == null) {
                    synchronized (zzrw.class) {
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
        this.zzf = 0;
    }

    private final void zza(zzahp zzahpVar) {
        zzahpVar.getClass();
        this.zzg = zzahpVar;
    }

    public static /* synthetic */ void zza(zzrw zzrwVar, int i) {
        zzrwVar.zza(0);
    }

    public static /* synthetic */ void zza(zzrw zzrwVar, zzahp zzahpVar) {
        zzrwVar.zza(zzahpVar);
    }

    public static /* synthetic */ void zza(zzrw zzrwVar, zzsb zzsbVar) {
        zzrwVar.zza(zzsbVar);
    }

    private final void zza(zzsb zzsbVar) {
        zzsbVar.getClass();
        this.zzh = zzsbVar;
        this.zze |= 1;
    }
}
