package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.internal.firebase-auth-api.zzajc;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzug extends zzajc implements zzakp {
    private static final zzug zzc;
    private static volatile zzakw zzd;
    private int zze;
    private zzuh zzf;
    private int zzg;
    private int zzh;

    public static final class zza extends zzajc.zza implements zzakp {
        private zza() {
            super(zzug.zzd());
        }

        public final zza zza(int i) {
            zzi();
            zzug.zza((zzug) this.zza, i);
            return this;
        }

        public /* synthetic */ zza(zzuf zzufVar) {
            this();
        }

        public final zza zza(zzuh zzuhVar) {
            zzi();
            zzug.zza((zzug) this.zza, zzuhVar);
            return this;
        }
    }

    static {
        zzug zzugVar = new zzug();
        zzc = zzugVar;
        zzajc.zza(zzug.class, zzugVar);
    }

    private zzug() {
    }

    public static zza zzc() {
        return (zza) zzc.zzm();
    }

    public static /* synthetic */ zzug zzd() {
        return zzc;
    }

    public static zzug zze() {
        return zzc;
    }

    public final int zza() {
        return this.zzg;
    }

    public final int zzb() {
        return this.zzh;
    }

    public final zzuh zzf() {
        zzuh zzuhVar = this.zzf;
        return zzuhVar == null ? zzuh.zze() : zzuhVar;
    }

    public static zzug zza(zzahp zzahpVar, zzaio zzaioVar) throws zzaji {
        return (zzug) zzajc.zza(zzc, zzahpVar, zzaioVar);
    }

    /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.firebase-auth-api.zzajc$zzc, com.google.android.gms.internal.firebase-auth-api.zzakw] */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzuf.zza[i - 1]) {
            case 1:
                return new zzug();
            case 2:
                return new zza(null);
            case 3:
                return zzajc.zza(zzc, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u000b\u0003\u000b", new Object[]{"zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzc;
            case 5:
                zzakw zzakwVar = zzd;
                zzakw zzakwVar2 = zzakwVar;
                if (zzakwVar == null) {
                    synchronized (zzug.class) {
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
        this.zzg = i;
    }

    public static /* synthetic */ void zza(zzug zzugVar, int i) {
        zzugVar.zza(i);
    }

    public static /* synthetic */ void zza(zzug zzugVar, zzuh zzuhVar) {
        zzugVar.zza(zzuhVar);
    }

    private final void zza(zzuh zzuhVar) {
        zzuhVar.getClass();
        this.zzf = zzuhVar;
        this.zze |= 1;
    }
}
