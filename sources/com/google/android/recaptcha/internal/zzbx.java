package com.google.android.recaptcha.internal;

import k8.n;
import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class zzbx {
    @NotNull
    public static String zza(zzby zzbyVar, @NotNull String str, byte b) {
        StringBuilder sb = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            sb.append((char) n.a(n.a(str.charAt(i)) ^ n.a(b)));
        }
        return sb.toString();
    }

    public static void zzb(zzby zzbyVar, int i, int i2) throws zzt {
        if (i != i2) {
            throw new zzt(4, 24, null);
        }
    }
}
