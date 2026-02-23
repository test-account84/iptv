package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.internal.firebase-auth-api.zzajc;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzsi extends zzajc implements zzakp {
    private static final zzsi zzc;
    private static volatile zzakw zzd;
    private int zze;
    private int zzf;
    private zzsm zzg;
    private zzahp zzh = zzahp.zza;

    public static final class zza extends zzajc.zza implements zzakp {
        private zza() {
            super(zzsi.zzc());
        }

        public final zza zza(int i) {
            zzi();
            zzsi.zza((zzsi) this.zza, 0);
            return this;
        }

        public /* synthetic */ zza(zzsh zzshVar) {
            this();
        }

        public final zza zza(zzahp zzahpVar) {
            zzi();
            zzsi.zza((zzsi) this.zza, zzahpVar);
            return this;
        }

        public final zza zza(zzsm zzsmVar) {
            zzi();
            zzsi.zza((zzsi) this.zza, zzsmVar);
            return this;
        }
    }

    static {
        zzsi zzsiVar = new zzsi();
        zzc = zzsiVar;
        zzajc.zza(zzsi.class, zzsiVar);
    }

    private zzsi() {
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    public static /* synthetic */ zzsi zzc() {
        return zzc;
    }

    public static zzsi zzd() {
        return zzc;
    }

    public final int zza() {
        return this.zzf;
    }

    public final zzsm zze() {
        zzsm zzsmVar = this.zzg;
        return zzsmVar == null ? zzsm.zzd() : zzsmVar;
    }

    public final zzahp zzf() {
        return this.zzh;
    }

    public static zzsi zza(zzahp zzahpVar, zzaio zzaioVar) throws zzaji {
        return (zzsi) zzajc.zza(zzc, zzahpVar, zzaioVar);
    }

    /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.firebase-auth-api.zzajc$zzc, com.google.android.gms.internal.firebase-auth-api.zzakw] */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzsh.zza[i - 1]) {
            case 1:
                return new zzsi();
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
                    synchronized (zzsi.class) {
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

    public static /* synthetic */ void zza(zzsi zzsiVar, int i) {
        zzsiVar.zza(0);
    }

    public static /* synthetic */ void zza(zzsi zzsiVar, zzahp zzahpVar) {
        zzsiVar.zza(zzahpVar);
    }

    public static /* synthetic */ void zza(zzsi zzsiVar, zzsm zzsmVar) {
        zzsiVar.zza(zzsmVar);
    }

    private final void zza(zzsm zzsmVar) {
        zzsmVar.getClass();
        this.zzg = zzsmVar;
        this.zze |= 1;
    }
}
