package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.internal.firebase-auth-api.zzajc;

@Deprecated
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzvt extends zzajc implements zzakp {
    private static final zzvt zzc;
    private static volatile zzakw zzd;
    private String zze = "";
    private zzajj zzf = zzajc.zzp();

    public static final class zza extends zzajc.zza implements zzakp {
        private zza() {
            super(zzvt.zza());
        }

        public /* synthetic */ zza(zzvv zzvvVar) {
            this();
        }
    }

    static {
        zzvt zzvtVar = new zzvt();
        zzc = zzvtVar;
        zzajc.zza(zzvt.class, zzvtVar);
    }

    private zzvt() {
    }

    public static /* synthetic */ zzvt zza() {
        return zzc;
    }

    public static zzvt zzb() {
        return zzc;
    }

    /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.firebase-auth-api.zzajc$zzc, com.google.android.gms.internal.firebase-auth-api.zzakw] */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzvv.zza[i - 1]) {
            case 1:
                return new zzvt();
            case 2:
                return new zza(null);
            case 3:
                return zzajc.zza(zzc, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002\u001b", new Object[]{"zze", "zzf", zzvf.class});
            case 4:
                return zzc;
            case 5:
                zzakw zzakwVar = zzd;
                zzakw zzakwVar2 = zzakwVar;
                if (zzakwVar == null) {
                    synchronized (zzvt.class) {
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
}
