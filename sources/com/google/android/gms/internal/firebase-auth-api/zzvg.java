package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.internal.firebase-auth-api.zzajc;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzvg extends zzajc implements zzakp {
    private static final zzvg zzc;
    private static volatile zzakw zzd;
    private int zze;
    private zzajj zzf = zzajc.zzp();

    public static final class zza extends zzajc.zza implements zzakp {
        private zza() {
            super(zzvg.zzd());
        }

        public final int zza() {
            return ((zzvg) this.zza).zza();
        }

        public final zzb zzb(int i) {
            return ((zzvg) this.zza).zza(i);
        }

        public /* synthetic */ zza(zzvh zzvhVar) {
            this();
        }

        public final zza zza(int i) {
            zzi();
            zzvg.zza((zzvg) this.zza, i);
            return this;
        }

        public final List zzb() {
            return Collections.unmodifiableList(((zzvg) this.zza).zze());
        }

        public final zza zza(zzb zzbVar) {
            zzi();
            zzvg.zza((zzvg) this.zza, zzbVar);
            return this;
        }
    }

    public static final class zzb extends zzajc implements zzakp {
        private static final zzb zzc;
        private static volatile zzakw zzd;
        private int zze;
        private zzuy zzf;
        private int zzg;
        private int zzh;
        private int zzi;

        public static final class zza extends zzajc.zza implements zzakp {
            private zza() {
                super(zzb.zze());
            }

            public final zza zza(int i) {
                zzi();
                zzb.zza((zzb) this.zza, i);
                return this;
            }

            public /* synthetic */ zza(zzvh zzvhVar) {
                this();
            }

            public final zza zza(zzuy zzuyVar) {
                zzi();
                zzb.zza((zzb) this.zza, zzuyVar);
                return this;
            }

            public final zza zza(zzuz zzuzVar) {
                zzi();
                zzb.zza((zzb) this.zza, zzuzVar);
                return this;
            }

            public final zza zza(zzvs zzvsVar) {
                zzi();
                zzb.zza((zzb) this.zza, zzvsVar);
                return this;
            }
        }

        static {
            zzb zzbVar = new zzb();
            zzc = zzbVar;
            zzajc.zza(zzb.class, zzbVar);
        }

        private zzb() {
        }

        public static zza zzd() {
            return (zza) zzc.zzm();
        }

        public static /* synthetic */ zzb zze() {
            return zzc;
        }

        public final int zza() {
            return this.zzh;
        }

        public final zzuy zzb() {
            zzuy zzuyVar = this.zzf;
            return zzuyVar == null ? zzuy.zzd() : zzuyVar;
        }

        public final zzuz zzc() {
            zzuz zza2 = zzuz.zza(this.zzg);
            return zza2 == null ? zzuz.UNRECOGNIZED : zza2;
        }

        public final zzvs zzf() {
            zzvs zza2 = zzvs.zza(this.zzi);
            return zza2 == null ? zzvs.zzf : zza2;
        }

        public final boolean zzg() {
            return (this.zze & 1) != 0;
        }

        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.firebase-auth-api.zzajc$zzc, com.google.android.gms.internal.firebase-auth-api.zzakw] */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzvh.zza[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(null);
                case 3:
                    return zzajc.zza(zzc, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002\f\u0003\u000b\u0004\f", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi"});
                case 4:
                    return zzc;
                case 5:
                    zzakw zzakwVar = zzd;
                    zzakw zzakwVar2 = zzakwVar;
                    if (zzakwVar == null) {
                        synchronized (zzb.class) {
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
            this.zzh = i;
        }

        private final void zza(zzuy zzuyVar) {
            zzuyVar.getClass();
            this.zzf = zzuyVar;
            this.zze |= 1;
        }

        private final void zza(zzuz zzuzVar) {
            this.zzg = zzuzVar.zza();
        }

        public static /* synthetic */ void zza(zzb zzbVar, int i) {
            zzbVar.zza(i);
        }

        public static /* synthetic */ void zza(zzb zzbVar, zzuy zzuyVar) {
            zzbVar.zza(zzuyVar);
        }

        public static /* synthetic */ void zza(zzb zzbVar, zzuz zzuzVar) {
            zzbVar.zza(zzuzVar);
        }

        public static /* synthetic */ void zza(zzb zzbVar, zzvs zzvsVar) {
            zzbVar.zza(zzvsVar);
        }

        private final void zza(zzvs zzvsVar) {
            this.zzi = zzvsVar.zza();
        }
    }

    static {
        zzvg zzvgVar = new zzvg();
        zzc = zzvgVar;
        zzajc.zza(zzvg.class, zzvgVar);
    }

    private zzvg() {
    }

    public static zza zzc() {
        return (zza) zzc.zzm();
    }

    public static /* synthetic */ zzvg zzd() {
        return zzc;
    }

    public final int zza() {
        return this.zzf.size();
    }

    public final int zzb() {
        return this.zze;
    }

    public final List zze() {
        return this.zzf;
    }

    private final void zzc(int i) {
        this.zze = i;
    }

    public final zzb zza(int i) {
        return (zzb) this.zzf.get(i);
    }

    public static zzvg zza(InputStream inputStream, zzaio zzaioVar) throws IOException {
        return (zzvg) zzajc.zza(zzc, inputStream, zzaioVar);
    }

    public static zzvg zza(byte[] bArr, zzaio zzaioVar) throws zzaji {
        return (zzvg) zzajc.zza(zzc, bArr, zzaioVar);
    }

    /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.firebase-auth-api.zzajc$zzc, com.google.android.gms.internal.firebase-auth-api.zzakw] */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzvh.zza[i - 1]) {
            case 1:
                return new zzvg();
            case 2:
                return new zza(null);
            case 3:
                return zzajc.zza(zzc, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zze", "zzf", zzb.class});
            case 4:
                return zzc;
            case 5:
                zzakw zzakwVar = zzd;
                zzakw zzakwVar2 = zzakwVar;
                if (zzakwVar == null) {
                    synchronized (zzvg.class) {
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

    private final void zza(zzb zzbVar) {
        zzbVar.getClass();
        zzajj zzajjVar = this.zzf;
        if (!zzajjVar.zzc()) {
            this.zzf = zzajc.zza(zzajjVar);
        }
        this.zzf.add(zzbVar);
    }

    public static /* synthetic */ void zza(zzvg zzvgVar, int i) {
        zzvgVar.zzc(i);
    }

    public static /* synthetic */ void zza(zzvg zzvgVar, zzb zzbVar) {
        zzvgVar.zza(zzbVar);
    }
}
