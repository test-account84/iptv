package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.internal.firebase-auth-api.zzajc;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zztu extends zzajc implements zzakp {
    private static final zztu zzc;
    private static volatile zzakw zzd;
    private int zze;
    private int zzf;
    private zztq zzg;
    private zzahp zzh;
    private zzahp zzi;

    public static final class zza extends zzajc.zza implements zzakp {
        private zza() {
            super(zztu.zzd());
        }

        public final zza zza(int i) {
            zzi();
            zztu.zza((zztu) this.zza, 0);
            return this;
        }

        public final zza zzb(zzahp zzahpVar) {
            zzi();
            zztu.zzb((zztu) this.zza, zzahpVar);
            return this;
        }

        public /* synthetic */ zza(zztt zzttVar) {
            this();
        }

        public final zza zza(zzahp zzahpVar) {
            zzi();
            zztu.zza((zztu) this.zza, zzahpVar);
            return this;
        }

        public final zza zza(zztq zztqVar) {
            zzi();
            zztu.zza((zztu) this.zza, zztqVar);
            return this;
        }
    }

    static {
        zztu zztuVar = new zztu();
        zzc = zztuVar;
        zzajc.zza(zztu.class, zztuVar);
    }

    private zztu() {
        zzahp zzahpVar = zzahp.zza;
        this.zzh = zzahpVar;
        this.zzi = zzahpVar;
    }

    public static zza zzc() {
        return (zza) zzc.zzm();
    }

    public static /* synthetic */ zztu zzd() {
        return zzc;
    }

    public static zztu zze() {
        return zzc;
    }

    public final int zza() {
        return this.zzf;
    }

    public final zztq zzb() {
        zztq zztqVar = this.zzg;
        return zztqVar == null ? zztq.zze() : zztqVar;
    }

    public final zzahp zzf() {
        return this.zzh;
    }

    public final zzahp zzg() {
        return this.zzi;
    }

    public static zztu zza(zzahp zzahpVar, zzaio zzaioVar) throws zzaji {
        return (zztu) zzajc.zza(zzc, zzahpVar, zzaioVar);
    }

    private final void zzb(zzahp zzahpVar) {
        zzahpVar.getClass();
        this.zzi = zzahpVar;
    }

    public static /* synthetic */ void zzb(zztu zztuVar, zzahp zzahpVar) {
        zztuVar.zzb(zzahpVar);
    }

    /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.firebase-auth-api.zzajc$zzc, com.google.android.gms.internal.firebase-auth-api.zzakw] */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zztt.zza[i - 1]) {
            case 1:
                return new zztu();
            case 2:
                return new zza(null);
            case 3:
                return zzajc.zza(zzc, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n\u0004\n", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi"});
            case 4:
                return zzc;
            case 5:
                zzakw zzakwVar = zzd;
                zzakw zzakwVar2 = zzakwVar;
                if (zzakwVar == null) {
                    synchronized (zztu.class) {
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

    private final void zza(zztq zztqVar) {
        zztqVar.getClass();
        this.zzg = zztqVar;
        this.zze |= 1;
    }

    public static /* synthetic */ void zza(zztu zztuVar, int i) {
        zztuVar.zza(0);
    }

    public static /* synthetic */ void zza(zztu zztuVar, zzahp zzahpVar) {
        zztuVar.zza(zzahpVar);
    }

    public static /* synthetic */ void zza(zztu zztuVar, zztq zztqVar) {
        zztuVar.zza(zztqVar);
    }
}
