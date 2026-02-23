package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.internal.firebase-auth-api.zzajc;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzuc extends zzajc implements zzakp {
    private static final zzuc zzc;
    private static volatile zzakw zzd;
    private int zze;
    private int zzf;
    private zzuh zzg;
    private zzahp zzh = zzahp.zza;

    public static final class zza extends zzajc.zza implements zzakp {
        private zza() {
            super(zzuc.zzc());
        }

        public final zza zza(int i) {
            zzi();
            zzuc.zza((zzuc) this.zza, i);
            return this;
        }

        public /* synthetic */ zza(zzue zzueVar) {
            this();
        }

        public final zza zza(zzahp zzahpVar) {
            zzi();
            zzuc.zza((zzuc) this.zza, zzahpVar);
            return this;
        }

        public final zza zza(zzuh zzuhVar) {
            zzi();
            zzuc.zza((zzuc) this.zza, zzuhVar);
            return this;
        }
    }

    static {
        zzuc zzucVar = new zzuc();
        zzc = zzucVar;
        zzajc.zza(zzuc.class, zzucVar);
    }

    private zzuc() {
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    public static /* synthetic */ zzuc zzc() {
        return zzc;
    }

    public static zzuc zzd() {
        return zzc;
    }

    public final int zza() {
        return this.zzf;
    }

    public final zzuh zze() {
        zzuh zzuhVar = this.zzg;
        return zzuhVar == null ? zzuh.zze() : zzuhVar;
    }

    public final zzahp zzf() {
        return this.zzh;
    }

    public static zzuc zza(zzahp zzahpVar, zzaio zzaioVar) throws zzaji {
        return (zzuc) zzajc.zza(zzc, zzahpVar, zzaioVar);
    }

    /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.firebase-auth-api.zzajc$zzc, com.google.android.gms.internal.firebase-auth-api.zzakw] */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzue.zza[i - 1]) {
            case 1:
                return new zzuc();
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
                    synchronized (zzuc.class) {
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

    public static /* synthetic */ void zza(zzuc zzucVar, int i) {
        zzucVar.zza(i);
    }

    public static /* synthetic */ void zza(zzuc zzucVar, zzahp zzahpVar) {
        zzucVar.zza(zzahpVar);
    }

    public static /* synthetic */ void zza(zzuc zzucVar, zzuh zzuhVar) {
        zzucVar.zza(zzuhVar);
    }

    private final void zza(zzuh zzuhVar) {
        zzuhVar.getClass();
        this.zzg = zzuhVar;
        this.zze |= 1;
    }
}
