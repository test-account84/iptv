package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.internal.firebase-auth-api.zzajc;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzuh extends zzajc implements zzakp {
    private static final zzuh zzc;
    private static volatile zzakw zzd;
    private int zze;
    private int zzf;

    public static final class zza extends zzajc.zza implements zzakp {
        private zza() {
            super(zzuh.zzd());
        }

        public final zza zza(int i) {
            zzi();
            zzuh.zza((zzuh) this.zza, i);
            return this;
        }

        public /* synthetic */ zza(zzui zzuiVar) {
            this();
        }

        public final zza zza(zzub zzubVar) {
            zzi();
            zzuh.zza((zzuh) this.zza, zzubVar);
            return this;
        }
    }

    static {
        zzuh zzuhVar = new zzuh();
        zzc = zzuhVar;
        zzajc.zza(zzuh.class, zzuhVar);
    }

    private zzuh() {
    }

    public static zza zzc() {
        return (zza) zzc.zzm();
    }

    public static /* synthetic */ zzuh zzd() {
        return zzc;
    }

    public static zzuh zze() {
        return zzc;
    }

    public final int zza() {
        return this.zzf;
    }

    public final zzub zzb() {
        zzub zza2 = zzub.zza(this.zze);
        return zza2 == null ? zzub.UNRECOGNIZED : zza2;
    }

    /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.firebase-auth-api.zzajc$zzc, com.google.android.gms.internal.firebase-auth-api.zzakw] */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzui.zza[i - 1]) {
            case 1:
                return new zzuh();
            case 2:
                return new zza(null);
            case 3:
                return zzajc.zza(zzc, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002\u000b", new Object[]{"zze", "zzf"});
            case 4:
                return zzc;
            case 5:
                zzakw zzakwVar = zzd;
                zzakw zzakwVar2 = zzakwVar;
                if (zzakwVar == null) {
                    synchronized (zzuh.class) {
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

    private final void zza(zzub zzubVar) {
        this.zze = zzubVar.zza();
    }

    public static /* synthetic */ void zza(zzuh zzuhVar, int i) {
        zzuhVar.zza(i);
    }

    public static /* synthetic */ void zza(zzuh zzuhVar, zzub zzubVar) {
        zzuhVar.zza(zzubVar);
    }
}
