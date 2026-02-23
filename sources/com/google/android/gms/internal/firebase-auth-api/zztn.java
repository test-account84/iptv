package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.internal.firebase-auth-api.zzajc;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zztn extends zzajc implements zzakp {
    private static final zztn zzc;
    private static volatile zzakw zzd;
    private int zze;
    private zztq zzf;

    public static final class zza extends zzajc.zza implements zzakp {
        private zza() {
            super(zztn.zzb());
        }

        public final zza zza(zztq zztqVar) {
            zzi();
            zztn.zza((zztn) this.zza, zztqVar);
            return this;
        }

        public /* synthetic */ zza(zzto zztoVar) {
            this();
        }
    }

    static {
        zztn zztnVar = new zztn();
        zzc = zztnVar;
        zzajc.zza(zztn.class, zztnVar);
    }

    private zztn() {
    }

    public static zza zza() {
        return (zza) zzc.zzm();
    }

    public static /* synthetic */ zztn zzb() {
        return zzc;
    }

    public final zztq zzc() {
        zztq zztqVar = this.zzf;
        return zztqVar == null ? zztq.zze() : zztqVar;
    }

    public static zztn zza(zzahp zzahpVar, zzaio zzaioVar) throws zzaji {
        return (zztn) zzajc.zza(zzc, zzahpVar, zzaioVar);
    }

    /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.firebase-auth-api.zzajc$zzc, com.google.android.gms.internal.firebase-auth-api.zzakw] */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzto.zza[i - 1]) {
            case 1:
                return new zztn();
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
                    synchronized (zztn.class) {
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

    public static /* synthetic */ void zza(zztn zztnVar, zztq zztqVar) {
        zztnVar.zza(zztqVar);
    }

    private final void zza(zztq zztqVar) {
        zztqVar.getClass();
        this.zzf = zztqVar;
        this.zze |= 1;
    }
}
