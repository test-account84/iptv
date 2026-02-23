package com.amazonaws.mobileconnectors.cognitoauth.util;

import android.util.Base64;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.SecureRandom;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class Pkce {
    public static final String encodeBase64(String str) {
        if (str == null) {
            return null;
        }
        return Base64.encodeToString(str.getBytes(Charset.forName("ISO-8859-1")), 3);
    }

    public static final String generateHash(String str) throws Exception {
        byte[] bytes = str.getBytes("US-ASCII");
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(bytes, 0, bytes.length);
        return Base64.encodeToString(messageDigest.digest(), 11);
    }

    public static final String generateRandom() {
        byte[] bArr = new byte[32];
        new SecureRandom().nextBytes(bArr);
        return Base64.encodeToString(bArr, 11);
    }
}
