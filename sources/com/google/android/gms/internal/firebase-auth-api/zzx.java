package com.google.android.gms.internal.firebase-auth-api;

import java.util.logging.Logger;
import java.util.regex.Pattern;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzx {
    private static final Logger zza = Logger.getLogger(zzx.class.getName());
    private static final zzv zzb = new zza(null);

    public static final class zza implements zzv {
        private zza() {
        }

        public final zzs zza(String str) {
            return new zzu(Pattern.compile(str));
        }

        public /* synthetic */ zza(zzz zzzVar) {
            this();
        }
    }

    private zzx() {
    }

    public static zzs zza(String str) {
        zzy.zza(str);
        return zzb.zza(str);
    }

    public static String zzb(String str) {
        if (zzd(str)) {
            return null;
        }
        return str;
    }

    public static String zzc(String str) {
        return str == null ? "" : str;
    }

    public static boolean zzd(String str) {
        return str == null || str.isEmpty();
    }
}
