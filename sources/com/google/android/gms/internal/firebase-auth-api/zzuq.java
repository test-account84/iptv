package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.internal.firebase-auth-api.zzajc;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzuq extends zzajc implements zzakp {
    private static final zzuq zzc;
    private static volatile zzakw zzd;
    private int zze;
    private zzur zzf;

    public static final class zza extends zzajc.zza implements zzakp {
        private zza() {
            super(zzuq.zzb());
        }

        public final zza zza(zzur zzurVar) {
            zzi();
            zzuq.zza((zzuq) this.zza, zzurVar);
            return this;
        }

        public /* synthetic */ zza(zzup zzupVar) {
            this();
        }
    }

    static {
        zzuq zzuqVar = new zzuq();
        zzc = zzuqVar;
        zzajc.zza(zzuq.class, zzuqVar);
    }

    private zzuq() {
    }

    public static zza zza() {
        return (zza) zzc.zzm();
    }

    public static /* synthetic */ zzuq zzb() {
        return zzc;
    }

    public final zzur zzc() {
        zzur zzurVar = this.zzf;
        return zzurVar == null ? zzur.zzf() : zzurVar;
    }

    public static zzuq zza(zzahp zzahpVar, zzaio zzaioVar) throws zzaji {
        return (zzuq) zzajc.zza(zzc, zzahpVar, zzaioVar);
    }

    /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.firebase-auth-api.zzajc$zzc, com.google.android.gms.internal.firebase-auth-api.zzakw] */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzup.zza[i - 1]) {
            case 1:
                return new zzuq();
            case 2:
                return new zza(null);
            case 3:
                return zzajc.zza(zzc, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"zze", "zzf"});
            case 4:
                return zzc;
            case 5:
                zzakw zzakwVar = zzd;
                zzakw zzakwVar2 = zzakwVar;
                if (zzakwVar == null) {
                    synchronized (zzuq.class) {
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

    public static /* synthetic */ void zza(zzuq zzuqVar, zzur zzurVar) {
        zzuqVar.zza(zzurVar);
    }

    private final void zza(zzur zzurVar) {
        zzurVar.getClass();
        this.zzf = zzurVar;
        this.zze |= 1;
    }
}
