package com.google.android.gms.internal.firebase-auth-api;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class zzacj {
    public static String zza(zzack zzackVar, String str) {
        try {
            String str2 = new String(MessageDigest.getInstance("SHA-256").digest(str.getBytes()));
            int length = str2.length();
            int i = 0;
            while (i < length) {
                if (zzk.zza(str2.charAt(i))) {
                    char[] charArray = str2.toCharArray();
                    while (i < length) {
                        char c = charArray[i];
                        if (zzk.zza(c)) {
                            charArray[i] = (char) (c ^ ' ');
                        }
                        i++;
                    }
                    return String.valueOf(charArray);
                }
                i++;
            }
            return str2;
        } catch (NoSuchAlgorithmException unused) {
            zzack.zza.c("Failed to get SHA-256 MessageDigest", new Object[0]);
            return null;
        }
    }

    public static void zzb(zzack zzackVar, String str) {
        zzackVar.zza(str, null);
    }
}
