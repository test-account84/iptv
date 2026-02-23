package com.google.ads.interactivemedia.v3.internal;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bby {
    public static final int a = bch.b;
    private static final ThreadLocal b = new bbx();
    private final SecretKey c;
    private final boolean d;

    public bby(byte[] bArr, boolean z) throws GeneralSecurityException {
        if (!bch.a(a)) {
            throw new GeneralSecurityException("Can not use AES-GCM in FIPS-mode, as BoringCrypto module is not available.");
        }
        bjg.a(bArr.length);
        this.c = new SecretKeySpec(bArr, "AES");
        this.d = z;
    }

    public final byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length != 12) {
            throw new GeneralSecurityException("iv is wrong size");
        }
        int length = bArr2.length;
        if (length > 2147483619) {
            throw new GeneralSecurityException("plaintext too long");
        }
        boolean z = this.d;
        byte[] bArr3 = new byte[z ? length + 28 : length + 16];
        if (z) {
            System.arraycopy(bArr, 0, bArr3, 0, 12);
        }
        IvParameterSpec gCMParameterSpec = (!bjh.f() || com.google.ads.interactivemedia.v3.impl.data.p.b().intValue() > 19) ? new GCMParameterSpec(128, bArr, 0, 12) : new IvParameterSpec(bArr, 0, 12);
        ThreadLocal threadLocal = b;
        ((Cipher) threadLocal.get()).init(1, this.c, gCMParameterSpec);
        int doFinal = ((Cipher) threadLocal.get()).doFinal(bArr2, 0, length, bArr3, true != this.d ? 0 : 12);
        if (doFinal == length + 16) {
            return bArr3;
        }
        throw new GeneralSecurityException(String.format("encryption failed; GCM tag must be %s bytes, but got only %s bytes", new Object[]{16, Integer.valueOf(doFinal - length)}));
    }
}
