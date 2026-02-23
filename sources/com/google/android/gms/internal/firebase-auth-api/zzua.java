package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.internal.firebase-auth-api.zzajc;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzua extends zzajc implements zzakp {
    private static final zzua zzc;
    private static volatile zzakw zzd;
    private int zze;
    private zzahp zzf = zzahp.zza;
    private zzvj zzg;

    public static final class zza extends zzajc.zza implements zzakp {
        private zza() {
            super(zzua.zzb());
        }

        public final zza zza(zzahp zzahpVar) {
            zzi();
            zzua.zza((zzua) this.zza, zzahpVar);
            return this;
        }

        public /* synthetic */ zza(zztz zztzVar) {
            this();
        }

        public final zza zza(zzvj zzvjVar) {
            zzi();
            zzua.zza((zzua) this.zza, zzvjVar);
            return this;
        }
    }

    static {
        zzua zzuaVar = new zzua();
        zzc = zzuaVar;
        zzajc.zza(zzua.class, zzuaVar);
    }

    private zzua() {
    }

    public static zza zza() {
        return (zza) zzc.zzm();
    }

    public static /* synthetic */ zzua zzb() {
        return zzc;
    }

    public final zzahp zzc() {
        return this.zzf;
    }

    public static zzua zza(InputStream inputStream, zzaio zzaioVar) throws IOException {
        return (zzua) zzajc.zza(zzc, inputStream, zzaioVar);
    }

    /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.firebase-auth-api.zzajc$zzc, com.google.android.gms.internal.firebase-auth-api.zzakw] */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zztz.zza[i - 1]) {
            case 1:
                return new zzua();
            case 2:
                return new zza(null);
            case 3:
                return zzajc.zza(zzc, "\u0000\u0002\u0000\u0001\u0002\u0003\u0002\u0000\u0000\u0000\u0002\n\u0003ဉ\u0000", new Object[]{"zze", "zzf", "zzg"});
            case 4:
                return zzc;
            case 5:
                zzakw zzakwVar = zzd;
                zzakw zzakwVar2 = zzakwVar;
                if (zzakwVar == null) {
                    synchronized (zzua.class) {
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

    public static /* synthetic */ void zza(zzua zzuaVar, zzahp zzahpVar) {
        zzuaVar.zza(zzahpVar);
    }

    public static /* synthetic */ void zza(zzua zzuaVar, zzvj zzvjVar) {
        zzuaVar.zza(zzvjVar);
    }

    private final void zza(zzvj zzvjVar) {
        zzvjVar.getClass();
        this.zzg = zzvjVar;
        this.zze |= 1;
    }
}
