package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.internal.firebase-auth-api.zzajc;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzsn extends zzajc implements zzakp {
    private static final zzsn zzc;
    private static volatile zzakw zzd;
    private int zze;
    private int zzf;
    private zzsr zzg;
    private zzahp zzh = zzahp.zza;

    public static final class zza extends zzajc.zza implements zzakp {
        private zza() {
            super(zzsn.zzc());
        }

        public final zza zza(int i) {
            zzi();
            zzsn.zza((zzsn) this.zza, 0);
            return this;
        }

        public /* synthetic */ zza(zzso zzsoVar) {
            this();
        }

        public final zza zza(zzahp zzahpVar) {
            zzi();
            zzsn.zza((zzsn) this.zza, zzahpVar);
            return this;
        }

        public final zza zza(zzsr zzsrVar) {
            zzi();
            zzsn.zza((zzsn) this.zza, zzsrVar);
            return this;
        }
    }

    static {
        zzsn zzsnVar = new zzsn();
        zzc = zzsnVar;
        zzajc.zza(zzsn.class, zzsnVar);
    }

    private zzsn() {
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    public static /* synthetic */ zzsn zzc() {
        return zzc;
    }

    public final int zza() {
        return this.zzf;
    }

    public final zzsr zzd() {
        zzsr zzsrVar = this.zzg;
        return zzsrVar == null ? zzsr.zzd() : zzsrVar;
    }

    public final zzahp zze() {
        return this.zzh;
    }

    public static zzsn zza(zzahp zzahpVar, zzaio zzaioVar) throws zzaji {
        return (zzsn) zzajc.zza(zzc, zzahpVar, zzaioVar);
    }

    /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.firebase-auth-api.zzajc$zzc, com.google.android.gms.internal.firebase-auth-api.zzakw] */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzso.zza[i - 1]) {
            case 1:
                return new zzsn();
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
                    synchronized (zzsn.class) {
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

    public static /* synthetic */ void zza(zzsn zzsnVar, int i) {
        zzsnVar.zza(0);
    }

    public static /* synthetic */ void zza(zzsn zzsnVar, zzahp zzahpVar) {
        zzsnVar.zza(zzahpVar);
    }

    public static /* synthetic */ void zza(zzsn zzsnVar, zzsr zzsrVar) {
        zzsnVar.zza(zzsrVar);
    }

    private final void zza(zzsr zzsrVar) {
        zzsrVar.getClass();
        this.zzg = zzsrVar;
        this.zze |= 1;
    }
}
