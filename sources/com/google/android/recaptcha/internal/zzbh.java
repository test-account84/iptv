package com.google.android.recaptcha.internal;

import k8.n;
import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class zzbh {
    @NotNull
    public static String zza(zzbi zzbiVar, @NotNull String str, byte b) {
        StringBuilder sb = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            sb.append((char) n.a(n.a(str.charAt(i)) ^ n.a(b)));
        }
        return sb.toString();
    }
}
