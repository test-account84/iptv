package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.internal.firebase-auth-api.zzajc;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzsf extends zzajc implements zzakp {
    private static final zzsf zzc;
    private static volatile zzakw zzd;
    private int zze;
    private zzsj zzf;
    private zzug zzg;

    public static final class zza extends zzajc.zza implements zzakp {
        private zza() {
            super(zzsf.zzb());
        }

        public final zza zza(zzsj zzsjVar) {
            zzi();
            zzsf.zza((zzsf) this.zza, zzsjVar);
            return this;
        }

        public /* synthetic */ zza(zzsg zzsgVar) {
            this();
        }

        public final zza zza(zzug zzugVar) {
            zzi();
            zzsf.zza((zzsf) this.zza, zzugVar);
            return this;
        }
    }

    static {
        zzsf zzsfVar = new zzsf();
        zzc = zzsfVar;
        zzajc.zza(zzsf.class, zzsfVar);
    }

    private zzsf() {
    }

    public static zza zza() {
        return (zza) zzc.zzm();
    }

    public static /* synthetic */ zzsf zzb() {
        return zzc;
    }

    public final zzsj zzc() {
        zzsj zzsjVar = this.zzf;
        return zzsjVar == null ? zzsj.zzd() : zzsjVar;
    }

    public final zzug zzd() {
        zzug zzugVar = this.zzg;
        return zzugVar == null ? zzug.zze() : zzugVar;
    }

    public static zzsf zza(zzahp zzahpVar, zzaio zzaioVar) throws zzaji {
        return (zzsf) zzajc.zza(zzc, zzahpVar, zzaioVar);
    }

    /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.firebase-auth-api.zzajc$zzc, com.google.android.gms.internal.firebase-auth-api.zzakw] */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzsg.zza[i - 1]) {
            case 1:
                return new zzsf();
            case 2:
                return new zza(null);
            case 3:
                return zzajc.zza(zzc, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzakw zzakwVar = zzd;
                zzakw zzakwVar2 = zzakwVar;
                if (zzakwVar == null) {
                    synchronized (zzsf.class) {
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

    public static /* synthetic */ void zza(zzsf zzsfVar, zzsj zzsjVar) {
        zzsfVar.zza(zzsjVar);
    }

    public static /* synthetic */ void zza(zzsf zzsfVar, zzug zzugVar) {
        zzsfVar.zza(zzugVar);
    }

    private final void zza(zzsj zzsjVar) {
        zzsjVar.getClass();
        this.zzf = zzsjVar;
        this.zze |= 1;
    }

    private final void zza(zzug zzugVar) {
        zzugVar.getClass();
        this.zzg = zzugVar;
        this.zze |= 2;
    }
}
