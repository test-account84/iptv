package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.internal.firebase-auth-api.zzajc;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzvr extends zzajc implements zzakp {
    private static final zzvr zzc;
    private static volatile zzakw zzd;
    private int zze;
    private String zzf = "";
    private zzvb zzg;

    public static final class zza extends zzajc.zza implements zzakp {
        private zza() {
            super(zzvr.zzc());
        }

        public final zza zza(zzvb zzvbVar) {
            zzi();
            zzvr.zza((zzvr) this.zza, zzvbVar);
            return this;
        }

        public /* synthetic */ zza(zzvq zzvqVar) {
            this();
        }

        public final zza zza(String str) {
            zzi();
            zzvr.zza((zzvr) this.zza, str);
            return this;
        }
    }

    static {
        zzvr zzvrVar = new zzvr();
        zzc = zzvrVar;
        zzajc.zza(zzvr.class, zzvrVar);
    }

    private zzvr() {
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    public static /* synthetic */ zzvr zzc() {
        return zzc;
    }

    public static zzvr zzd() {
        return zzc;
    }

    public final zzvb zza() {
        zzvb zzvbVar = this.zzg;
        return zzvbVar == null ? zzvb.zzc() : zzvbVar;
    }

    public final String zze() {
        return this.zzf;
    }

    public final boolean zzf() {
        return (this.zze & 1) != 0;
    }

    public static zzvr zza(zzahp zzahpVar, zzaio zzaioVar) throws zzaji {
        return (zzvr) zzajc.zza(zzc, zzahpVar, zzaioVar);
    }

    /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.firebase-auth-api.zzajc$zzc, com.google.android.gms.internal.firebase-auth-api.zzakw] */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzvq.zza[i - 1]) {
            case 1:
                return new zzvr();
            case 2:
                return new zza(null);
            case 3:
                return zzajc.zza(zzc, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002ဉ\u0000", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzakw zzakwVar = zzd;
                zzakw zzakwVar2 = zzakwVar;
                if (zzakwVar == null) {
                    synchronized (zzvr.class) {
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

    private final void zza(zzvb zzvbVar) {
        zzvbVar.getClass();
        this.zzg = zzvbVar;
        this.zze |= 1;
    }

    public static /* synthetic */ void zza(zzvr zzvrVar, zzvb zzvbVar) {
        zzvrVar.zza(zzvbVar);
    }

    public static /* synthetic */ void zza(zzvr zzvrVar, String str) {
        zzvrVar.zza(str);
    }

    private final void zza(String str) {
        str.getClass();
        this.zzf = str;
    }
}
