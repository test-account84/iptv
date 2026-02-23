package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzpd extends RuntimeException {
    public zzpd(String str) {
        super(str);
    }

    public static Object zza(zzpg zzpgVar) {
        try {
            return zzpgVar.zza();
        } catch (Exception e) {
            throw new zzpd((Throwable) e);
        }
    }

    public zzpd(String str, Throwable th) {
        super(str, th);
    }

    private zzpd(Throwable th) {
        super(th);
    }
}
