package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.internal.firebase-auth-api.zzajc;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzvj extends zzajc implements zzakp {
    private static final zzvj zzc;
    private static volatile zzakw zzd;
    private int zze;
    private zzajj zzf = zzajc.zzp();

    public static final class zza extends zzajc implements zzakp {
        private static final zza zzc;
        private static volatile zzakw zzd;
        private String zze = "";
        private int zzf;
        private int zzg;
        private int zzh;

        public static final class zza extends zzajc.zza implements zzakp {
            private zza() {
                super(zza.zzc());
            }

            public final zza zza(int i) {
                zzi();
                zza.zza((zza) this.zza, i);
                return this;
            }

            public /* synthetic */ zza(zzvi zzviVar) {
                this();
            }

            public final zza zza(zzuz zzuzVar) {
                zzi();
                zza.zza((zza) this.zza, zzuzVar);
                return this;
            }

            public final zza zza(zzvs zzvsVar) {
                zzi();
                zza.zza((zza) this.zza, zzvsVar);
                return this;
            }

            public final zza zza(String str) {
                zzi();
                zza.zza((zza) this.zza, str);
                return this;
            }
        }

        static {
            zza zzaVar = new zza();
            zzc = zzaVar;
            zzajc.zza(zza.class, zzaVar);
        }

        private zza() {
        }

        public static zza zzb() {
            return (zza) zzc.zzm();
        }

        public static /* synthetic */ zza zzc() {
            return zzc;
        }

        public final int zza() {
            return this.zzg;
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.firebase-auth-api.zzajc$zzc, com.google.android.gms.internal.firebase-auth-api.zzakw] */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzvi.zza[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new zza(null);
                case 3:
                    return zzajc.zza(zzc, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002\f\u0003\u000b\u0004\f", new Object[]{"zze", "zzf", "zzg", "zzh"});
                case 4:
                    return zzc;
                case 5:
                    zzakw zzakwVar = zzd;
                    zzakw zzakwVar2 = zzakwVar;
                    if (zzakwVar == null) {
                        synchronized (zza.class) {
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

        private final void zza(zzuz zzuzVar) {
            this.zzf = zzuzVar.zza();
        }

        public static /* synthetic */ void zza(zza zzaVar, int i) {
            zzaVar.zza(i);
        }

        public static /* synthetic */ void zza(zza zzaVar, zzuz zzuzVar) {
            zzaVar.zza(zzuzVar);
        }

        public static /* synthetic */ void zza(zza zzaVar, zzvs zzvsVar) {
            zzaVar.zza(zzvsVar);
        }

        public static /* synthetic */ void zza(zza zzaVar, String str) {
            zzaVar.zza(str);
        }

        private final void zza(zzvs zzvsVar) {
            this.zzh = zzvsVar.zza();
        }

        private final void zza(String str) {
            str.getClass();
            this.zze = str;
        }
    }

    public static final class zzb extends zzajc.zza implements zzakp {
        private zzb() {
            super(zzvj.zzb());
        }

        public final zzb zza(int i) {
            zzi();
            zzvj.zza((zzvj) this.zza, i);
            return this;
        }

        public /* synthetic */ zzb(zzvi zzviVar) {
            this();
        }

        public final zzb zza(zza zzaVar) {
            zzi();
            zzvj.zza((zzvj) this.zza, zzaVar);
            return this;
        }
    }

    static {
        zzvj zzvjVar = new zzvj();
        zzc = zzvjVar;
        zzajc.zza(zzvj.class, zzvjVar);
    }

    private zzvj() {
    }

    public static /* synthetic */ zzvj zzb() {
        return zzc;
    }

    private final void zzc(int i) {
        this.zze = i;
    }

    public final zza zza(int i) {
        return (zza) this.zzf.get(0);
    }

    public static zzb zza() {
        return (zzb) zzc.zzm();
    }

    /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.firebase-auth-api.zzajc$zzc, com.google.android.gms.internal.firebase-auth-api.zzakw] */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzvi.zza[i - 1]) {
            case 1:
                return new zzvj();
            case 2:
                return new zzb(null);
            case 3:
                return zzajc.zza(zzc, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zze", "zzf", zza.class});
            case 4:
                return zzc;
            case 5:
                zzakw zzakwVar = zzd;
                zzakw zzakwVar2 = zzakwVar;
                if (zzakwVar == null) {
                    synchronized (zzvj.class) {
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

    private final void zza(zza zzaVar) {
        zzaVar.getClass();
        zzajj zzajjVar = this.zzf;
        if (!zzajjVar.zzc()) {
            this.zzf = zzajc.zza(zzajjVar);
        }
        this.zzf.add(zzaVar);
    }

    public static /* synthetic */ void zza(zzvj zzvjVar, int i) {
        zzvjVar.zzc(i);
    }

    public static /* synthetic */ void zza(zzvj zzvjVar, zza zzaVar) {
        zzvjVar.zza(zzaVar);
    }
}
