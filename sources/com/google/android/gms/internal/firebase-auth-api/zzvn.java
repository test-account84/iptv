package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.internal.firebase-auth-api.zzajc;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzvn extends zzajc implements zzakp {
    private static final zzvn zzc;
    private static volatile zzakw zzd;
    private String zze = "";

    public static final class zza extends zzajc.zza implements zzakp {
        private zza() {
            super(zzvn.zzb());
        }

        public final zza zza(String str) {
            zzi();
            zzvn.zza((zzvn) this.zza, str);
            return this;
        }

        public /* synthetic */ zza(zzvm zzvmVar) {
            this();
        }
    }

    static {
        zzvn zzvnVar = new zzvn();
        zzc = zzvnVar;
        zzajc.zza(zzvn.class, zzvnVar);
    }

    private zzvn() {
    }

    public static zza zza() {
        return (zza) zzc.zzm();
    }

    public static /* synthetic */ zzvn zzb() {
        return zzc;
    }

    public static zzvn zzc() {
        return zzc;
    }

    public final String zzd() {
        return this.zze;
    }

    public static zzvn zza(zzahp zzahpVar, zzaio zzaioVar) throws zzaji {
        return (zzvn) zzajc.zza(zzc, zzahpVar, zzaioVar);
    }

    /* JADX WARN: Type inference failed for: r1v13, types: [com.google.android.gms.internal.firebase-auth-api.zzajc$zzc, com.google.android.gms.internal.firebase-auth-api.zzakw] */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzvm.zza[i - 1]) {
            case 1:
                return new zzvn();
            case 2:
                return new zza(null);
            case 3:
                return zzajc.zza(zzc, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"zze"});
            case 4:
                return zzc;
            case 5:
                zzakw zzakwVar = zzd;
                zzakw zzakwVar2 = zzakwVar;
                if (zzakwVar == null) {
                    synchronized (zzvn.class) {
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

    public static /* synthetic */ void zza(zzvn zzvnVar, String str) {
        zzvnVar.zza(str);
    }

    private final void zza(String str) {
        str.getClass();
        this.zze = str;
    }
}
