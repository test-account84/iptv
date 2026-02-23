package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.internal.firebase-auth-api.zzajc;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzuy extends zzajc implements zzakp {
    private static final zzuy zzc;
    private static volatile zzakw zzd;
    private String zze = "";
    private zzahp zzf = zzahp.zza;
    private int zzg;

    public enum zza implements zzaje {
        UNKNOWN_KEYMATERIAL(0),
        SYMMETRIC(1),
        ASYMMETRIC_PRIVATE(2),
        ASYMMETRIC_PUBLIC(3),
        REMOTE(4),
        UNRECOGNIZED(-1);

        private static final zzajh zzg = new zzva();
        private final int zzi;

        zza(int i) {
            this.zzi = i;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("<");
            sb.append(zza.class.getName());
            sb.append('@');
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            if (this != UNRECOGNIZED) {
                sb.append(" number=");
                sb.append(zza());
            }
            sb.append(" name=");
            sb.append(name());
            sb.append('>');
            return sb.toString();
        }

        public final int zza() {
            if (this != UNRECOGNIZED) {
                return this.zzi;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        public static zza zza(int i) {
            if (i == 0) {
                return UNKNOWN_KEYMATERIAL;
            }
            if (i == 1) {
                return SYMMETRIC;
            }
            if (i == 2) {
                return ASYMMETRIC_PRIVATE;
            }
            if (i == 3) {
                return ASYMMETRIC_PUBLIC;
            }
            if (i != 4) {
                return null;
            }
            return REMOTE;
        }
    }

    public static final class zzb extends zzajc.zza implements zzakp {
        private zzb() {
            super(zzuy.zzc());
        }

        public final zzb zza(zzahp zzahpVar) {
            zzi();
            zzuy.zza((zzuy) this.zza, zzahpVar);
            return this;
        }

        public /* synthetic */ zzb(zzux zzuxVar) {
            this();
        }

        public final zzb zza(zza zzaVar) {
            zzi();
            zzuy.zza((zzuy) this.zza, zzaVar);
            return this;
        }

        public final zzb zza(String str) {
            zzi();
            zzuy.zza((zzuy) this.zza, str);
            return this;
        }
    }

    static {
        zzuy zzuyVar = new zzuy();
        zzc = zzuyVar;
        zzajc.zza(zzuy.class, zzuyVar);
    }

    private zzuy() {
    }

    public static zzb zza() {
        return (zzb) zzc.zzm();
    }

    public static /* synthetic */ zzuy zzc() {
        return zzc;
    }

    public static zzuy zzd() {
        return zzc;
    }

    public final zza zzb() {
        zza zza2 = zza.zza(this.zzg);
        return zza2 == null ? zza.UNRECOGNIZED : zza2;
    }

    public final zzahp zze() {
        return this.zzf;
    }

    public final String zzf() {
        return this.zze;
    }

    /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.firebase-auth-api.zzajc$zzc, com.google.android.gms.internal.firebase-auth-api.zzakw] */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzux.zza[i - 1]) {
            case 1:
                return new zzuy();
            case 2:
                return new zzb(null);
            case 3:
                return zzajc.zza(zzc, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzakw zzakwVar = zzd;
                zzakw zzakwVar2 = zzakwVar;
                if (zzakwVar == null) {
                    synchronized (zzuy.class) {
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

    private final void zza(zza zzaVar) {
        this.zzg = zzaVar.zza();
    }

    public static /* synthetic */ void zza(zzuy zzuyVar, zzahp zzahpVar) {
        zzuyVar.zza(zzahpVar);
    }

    public static /* synthetic */ void zza(zzuy zzuyVar, zza zzaVar) {
        zzuyVar.zza(zzaVar);
    }

    public static /* synthetic */ void zza(zzuy zzuyVar, String str) {
        zzuyVar.zza(str);
    }

    private final void zza(String str) {
        str.getClass();
        this.zze = str;
    }
}
