package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.internal.firebase-auth-api.zzajc;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzth extends zzajc implements zzakp {
    private static final zzth zzc;
    private static volatile zzakw zzd;

    public static final class zza extends zzajc.zza implements zzakp {
        private zza() {
            super(zzth.zza());
        }

        public /* synthetic */ zza(zzti zztiVar) {
            this();
        }
    }

    static {
        zzth zzthVar = new zzth();
        zzc = zzthVar;
        zzajc.zza(zzth.class, zzthVar);
    }

    private zzth() {
    }

    public static /* synthetic */ zzth zza() {
        return zzc;
    }

    public static zzth zzb() {
        return zzc;
    }

    public static zzth zza(zzahp zzahpVar, zzaio zzaioVar) throws zzaji {
        return (zzth) zzajc.zza(zzc, zzahpVar, zzaioVar);
    }

    /* JADX WARN: Type inference failed for: r1v13, types: [com.google.android.gms.internal.firebase-auth-api.zzajc$zzc, com.google.android.gms.internal.firebase-auth-api.zzakw] */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzti.zza[i - 1]) {
            case 1:
                return new zzth();
            case 2:
                return new zza(null);
            case 3:
                return zzajc.zza(zzc, "\u0000\u0000", (Object[]) null);
            case 4:
                return zzc;
            case 5:
                zzakw zzakwVar = zzd;
                zzakw zzakwVar2 = zzakwVar;
                if (zzakwVar == null) {
                    synchronized (zzth.class) {
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
