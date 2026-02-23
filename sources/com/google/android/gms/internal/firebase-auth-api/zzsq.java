package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.internal.firebase-auth-api.zzajc;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzsq extends zzajc implements zzakp {
    private static final zzsq zzc;
    private static volatile zzakw zzd;
    private int zze;
    private zzsr zzf;
    private int zzg;

    public static final class zza extends zzajc.zza implements zzakp {
        private zza() {
            super(zzsq.zzc());
        }

        public final zza zza(int i) {
            zzi();
            zzsq.zza((zzsq) this.zza, i);
            return this;
        }

        public /* synthetic */ zza(zzsp zzspVar) {
            this();
        }

        public final zza zza(zzsr zzsrVar) {
            zzi();
            zzsq.zza((zzsq) this.zza, zzsrVar);
            return this;
        }
    }

    static {
        zzsq zzsqVar = new zzsq();
        zzc = zzsqVar;
        zzajc.zza(zzsq.class, zzsqVar);
    }

    private zzsq() {
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    public static /* synthetic */ zzsq zzc() {
        return zzc;
    }

    public final int zza() {
        return this.zzg;
    }

    public final zzsr zzd() {
        zzsr zzsrVar = this.zzf;
        return zzsrVar == null ? zzsr.zzd() : zzsrVar;
    }

    public static zzsq zza(zzahp zzahpVar, zzaio zzaioVar) throws zzaji {
        return (zzsq) zzajc.zza(zzc, zzahpVar, zzaioVar);
    }

    /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.firebase-auth-api.zzajc$zzc, com.google.android.gms.internal.firebase-auth-api.zzakw] */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzsp.zza[i - 1]) {
            case 1:
                return new zzsq();
            case 2:
                return new zza(null);
            case 3:
                return zzajc.zza(zzc, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u000b", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzakw zzakwVar = zzd;
                zzakw zzakwVar2 = zzakwVar;
                if (zzakwVar == null) {
                    synchronized (zzsq.class) {
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

    public static /* synthetic */ void zza(zzsq zzsqVar, int i) {
        zzsqVar.zza(i);
    }

    public static /* synthetic */ void zza(zzsq zzsqVar, zzsr zzsrVar) {
        zzsqVar.zza(zzsrVar);
    }

    private final void zza(zzsr zzsrVar) {
        zzsrVar.getClass();
        this.zzf = zzsrVar;
        this.zze |= 1;
    }
}
