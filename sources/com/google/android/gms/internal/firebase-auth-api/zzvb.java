package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.internal.firebase-auth-api.zzajc;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzvb extends zzajc implements zzakp {
    private static final zzvb zzc;
    private static volatile zzakw zzd;
    private String zze = "";
    private zzahp zzf = zzahp.zza;
    private int zzg;

    public static final class zza extends zzajc.zza implements zzakp {
        private zza() {
            super(zzvb.zzb());
        }

        public final zza zza(zzahp zzahpVar) {
            zzi();
            zzvb.zza((zzvb) this.zza, zzahpVar);
            return this;
        }

        public /* synthetic */ zza(zzvd zzvdVar) {
            this();
        }

        public final zza zza(zzvs zzvsVar) {
            zzi();
            zzvb.zza((zzvb) this.zza, zzvsVar);
            return this;
        }

        public final zza zza(String str) {
            zzi();
            zzvb.zza((zzvb) this.zza, str);
            return this;
        }
    }

    static {
        zzvb zzvbVar = new zzvb();
        zzc = zzvbVar;
        zzajc.zza(zzvb.class, zzvbVar);
    }

    private zzvb() {
    }

    public static zza zza() {
        return (zza) zzc.zzm();
    }

    public static /* synthetic */ zzvb zzb() {
        return zzc;
    }

    public static zzvb zzc() {
        return zzc;
    }

    public final zzvs zzd() {
        zzvs zza2 = zzvs.zza(this.zzg);
        return zza2 == null ? zzvs.zzf : zza2;
    }

    public final zzahp zze() {
        return this.zzf;
    }

    public final String zzf() {
        return this.zze;
    }

    public static zzvb zza(byte[] bArr, zzaio zzaioVar) throws zzaji {
        return (zzvb) zzajc.zza(zzc, bArr, zzaioVar);
    }

    /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.firebase-auth-api.zzajc$zzc, com.google.android.gms.internal.firebase-auth-api.zzakw] */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzvd.zza[i - 1]) {
            case 1:
                return new zzvb();
            case 2:
                return new zza(null);
            case 3:
                return zzajc.zza(zzc, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzakw zzakwVar = zzd;
                zzakw zzakwVar2 = zzakwVar;
                if (zzakwVar == null) {
                    synchronized (zzvb.class) {
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
        this.zzf = zzahpVar;
    }

    public static /* synthetic */ void zza(zzvb zzvbVar, zzahp zzahpVar) {
        zzvbVar.zza(zzahpVar);
    }

    public static /* synthetic */ void zza(zzvb zzvbVar, zzvs zzvsVar) {
        zzvbVar.zza(zzvsVar);
    }

    public static /* synthetic */ void zza(zzvb zzvbVar, String str) {
        zzvbVar.zza(str);
    }

    private final void zza(zzvs zzvsVar) {
        this.zzg = zzvsVar.zza();
    }

    private final void zza(String str) {
        str.getClass();
        this.zze = str;
    }
}
