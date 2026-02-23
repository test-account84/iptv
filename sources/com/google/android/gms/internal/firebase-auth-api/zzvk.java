package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.internal.firebase-auth-api.zzajc;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzvk extends zzajc implements zzakp {
    private static final zzvk zzc;
    private static volatile zzakw zzd;
    private int zze;
    private int zzf;
    private zzvn zzg;

    public static final class zza extends zzajc.zza implements zzakp {
        private zza() {
            super(zzvk.zzc());
        }

        public final zza zza(int i) {
            zzi();
            zzvk.zza((zzvk) this.zza, 0);
            return this;
        }

        public /* synthetic */ zza(zzvl zzvlVar) {
            this();
        }

        public final zza zza(zzvn zzvnVar) {
            zzi();
            zzvk.zza((zzvk) this.zza, zzvnVar);
            return this;
        }
    }

    static {
        zzvk zzvkVar = new zzvk();
        zzc = zzvkVar;
        zzajc.zza(zzvk.class, zzvkVar);
    }

    private zzvk() {
    }

    public static zza zzb() {
        return (zza) zzc.zzm();
    }

    public static /* synthetic */ zzvk zzc() {
        return zzc;
    }

    public final int zza() {
        return this.zzf;
    }

    public final zzvn zzd() {
        zzvn zzvnVar = this.zzg;
        return zzvnVar == null ? zzvn.zzc() : zzvnVar;
    }

    public static zzvk zza(zzahp zzahpVar, zzaio zzaioVar) throws zzaji {
        return (zzvk) zzajc.zza(zzc, zzahpVar, zzaioVar);
    }

    /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.firebase-auth-api.zzajc$zzc, com.google.android.gms.internal.firebase-auth-api.zzakw] */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzvl.zza[i - 1]) {
            case 1:
                return new zzvk();
            case 2:
                return new zza(null);
            case 3:
                return zzajc.zza(zzc, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzakw zzakwVar = zzd;
                zzakw zzakwVar2 = zzakwVar;
                if (zzakwVar == null) {
                    synchronized (zzvk.class) {
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

    public static /* synthetic */ void zza(zzvk zzvkVar, int i) {
        zzvkVar.zza(0);
    }

    public static /* synthetic */ void zza(zzvk zzvkVar, zzvn zzvnVar) {
        zzvkVar.zza(zzvnVar);
    }

    private final void zza(zzvn zzvnVar) {
        zzvnVar.getClass();
        this.zzg = zzvnVar;
        this.zze |= 1;
    }
}
