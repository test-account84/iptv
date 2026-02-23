package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.internal.firebase-auth-api.zzajc;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zztr extends zzajc implements zzakp {
    private static final zztr zzc;
    private static volatile zzakw zzd;
    private int zze;
    private int zzf;
    private zztu zzg;
    private zzahp zzh = zzahp.zza;

    public static final class zza extends zzajc.zza implements zzakp {
        private zza() {
            super(zztr.zzc());
        }

        public final zza zza(int i) {
            zzi();
            zztr.zza((zztr) this.zza, 0);
            return this;
        }

        public /* synthetic */ zza(zzts zztsVar) {
            this();
        }

        public final zza zza(zzahp zzahpVar) {
            zzi();
            zztr.zza((zztr) this.zza, zzahpVar);
            return this;
        }

        public final zza zza(zztu zztuVar) {
            zzi();
            zztr.zza((zztr) this.zza, zztuVar);
            return this;
        }
    }

    static {
        zztr zztrVar = new zztr();
        zzc = zztrVar;
        zzajc.zza(zztr.class, zztrVar);
    }

    private zztr() {
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    public static /* synthetic */ zztr zzc() {
        return zzc;
    }

    public final int zza() {
        return this.zzf;
    }

    public final zztu zzd() {
        zztu zztuVar = this.zzg;
        return zztuVar == null ? zztu.zze() : zztuVar;
    }

    public final zzahp zze() {
        return this.zzh;
    }

    public static zztr zza(zzahp zzahpVar, zzaio zzaioVar) throws zzaji {
        return (zztr) zzajc.zza(zzc, zzahpVar, zzaioVar);
    }

    /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.firebase-auth-api.zzajc$zzc, com.google.android.gms.internal.firebase-auth-api.zzakw] */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzts.zza[i - 1]) {
            case 1:
                return new zztr();
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
                    synchronized (zztr.class) {
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

    public static /* synthetic */ void zza(zztr zztrVar, int i) {
        zztrVar.zza(0);
    }

    public static /* synthetic */ void zza(zztr zztrVar, zzahp zzahpVar) {
        zztrVar.zza(zzahpVar);
    }

    public static /* synthetic */ void zza(zztr zztrVar, zztu zztuVar) {
        zztrVar.zza(zztuVar);
    }

    private final void zza(zztu zztuVar) {
        zztuVar.getClass();
        this.zzg = zztuVar;
        this.zze |= 1;
    }
}
