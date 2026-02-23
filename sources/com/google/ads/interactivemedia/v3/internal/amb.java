package com.google.ads.interactivemedia.v3.internal;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class amb implements Runnable {
    private amb() {
    }

    public final void run() {
        try {
            amc.b(MessageDigest.getInstance("MD5"));
        } catch (NoSuchAlgorithmException unused) {
        } catch (Throwable th) {
            amc.b.countDown();
            throw th;
        }
        amc.b.countDown();
    }

    public /* synthetic */ amb(byte[] bArr) {
    }
}
