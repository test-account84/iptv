package com.google.android.gms.internal.firebase-auth-api;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzif {
    private static final Logger zza = Logger.getLogger(zzif.class.getName());
    private static final AtomicBoolean zzb = new AtomicBoolean(false);

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static abstract class zza {
        public static final zza zza;
        public static final zza zzb;
        private static final /* synthetic */ zza[] zzc;

        static {
            zzih zzihVar = new zzih("ALGORITHM_NOT_FIPS", 0, null);
            zza = zzihVar;
            zzij zzijVar = new zzij("ALGORITHM_REQUIRES_BORINGCRYPTO", 1, null);
            zzb = zzijVar;
            zzc = new zza[]{zzihVar, zzijVar};
        }

        private zza(String str, int i) {
        }

        public static zza[] values() {
            return (zza[]) zzc.clone();
        }

        public abstract boolean zza();

        public /* synthetic */ zza(String str, int i, zzil zzilVar) {
            this(str, i);
        }
    }

    private zzif() {
    }

    public static Boolean zza() {
        try {
            return (Boolean) Class.forName("org.conscrypt.Conscrypt").getMethod("isBoringSslFIPSBuild", (Class[]) null).invoke((Object) null, (Object[]) null);
        } catch (Exception unused) {
            zza.logp(Level.INFO, "com.google.crypto.tink.config.internal.TinkFipsUtil", "checkConscryptIsAvailableAndUsesFipsBoringSsl", "Conscrypt is not available or does not support checking for FIPS build.");
            return Boolean.FALSE;
        }
    }

    public static boolean zzb() {
        return zzb.get();
    }
}
