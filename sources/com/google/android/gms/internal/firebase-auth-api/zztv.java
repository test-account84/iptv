package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.internal.firebase-auth-api.zzajc;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zztv extends zzajc implements zzakp {
    private static final zztv zzc;
    private static volatile zzakw zzd;
    private int zze;
    private int zzf;
    private zzahp zzg = zzahp.zza;

    public static final class zza extends zzajc.zza implements zzakp {
        private zza() {
            super(zztv.zzb());
        }

        public final zza zza(zzahp zzahpVar) {
            zzi();
            zztv.zza((zztv) this.zza, zzahpVar);
            return this;
        }

        public /* synthetic */ zza(zztw zztwVar) {
            this();
        }

        public final zza zza(zzty zztyVar) {
            zzi();
            zztv.zza((zztv) this.zza, zztyVar);
            return this;
        }

        public final zza zza(zzub zzubVar) {
            zzi();
            zztv.zza((zztv) this.zza, zzubVar);
            return this;
        }
    }

    static {
        zztv zztvVar = new zztv();
        zzc = zztvVar;
        zzajc.zza(zztv.class, zztvVar);
    }

    private zztv() {
    }

    public static zza zza() {
        return (zza) zzc.zzm();
    }

    public static /* synthetic */ zztv zzb() {
        return zzc;
    }

    public static zztv zzc() {
        return zzc;
    }

    public final zzty zzd() {
        zzty zza2 = zzty.zza(this.zze);
        return zza2 == null ? zzty.zze : zza2;
    }

    public final zzub zze() {
        zzub zza2 = zzub.zza(this.zzf);
        return zza2 == null ? zzub.zzf : zza2;
    }

    public final zzahp zzf() {
        return this.zzg;
    }

    /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.firebase-auth-api.zzajc$zzc, com.google.android.gms.internal.firebase-auth-api.zzakw] */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zztw.zza[i - 1]) {
            case 1:
                return new zztv();
            case 2:
                return new zza(null);
            case 3:
                return zzajc.zza(zzc, "\u0000\u0003\u0000\u0000\u0001\u000b\u0003\u0000\u0000\u0000\u0001\f\u0002\f\u000b\n", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzakw zzakwVar = zzd;
                zzakw zzakwVar2 = zzakwVar;
                if (zzakwVar == null) {
                    synchronized (zztv.class) {
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

    private final void zza(zzahp zzahpVar) {
        zzahpVar.getClass();
        this.zzg = zzahpVar;
    }

    public static /* synthetic */ void zza(zztv zztvVar, zzahp zzahpVar) {
        zztvVar.zza(zzahpVar);
    }

    public static /* synthetic */ void zza(zztv zztvVar, zzty zztyVar) {
        zztvVar.zza(zztyVar);
    }

    public static /* synthetic */ void zza(zztv zztvVar, zzub zzubVar) {
        zztvVar.zza(zzubVar);
    }

    private final void zza(zzty zztyVar) {
        this.zze = zztyVar.zza();
    }

    private final void zza(zzub zzubVar) {
        this.zzf = zzubVar.zza();
    }
}
