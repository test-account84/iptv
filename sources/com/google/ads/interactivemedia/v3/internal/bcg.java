package com.google.ads.interactivemedia.v3.internal;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bcg implements azo {
    private static final ThreadLocal a = new bcf();
    private final SecretKey b;

    public bcg(byte[] bArr) throws GeneralSecurityException {
        bjg.a(bArr.length);
        this.b = new SecretKeySpec(bArr, "AES");
    }

    public final byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        GCMParameterSpec ivParameterSpec;
        int length = bArr.length;
        if (length > 2147483619) {
            throw new GeneralSecurityException("plaintext too long");
        }
        byte[] bArr3 = new byte[length + 28];
        byte[] b = bjf.b(12);
        System.arraycopy(b, 0, bArr3, 0, 12);
        int length2 = b.length;
        try {
            Class.forName("javax.crypto.spec.GCMParameterSpec");
            ivParameterSpec = new GCMParameterSpec(128, b, 0, length2);
        } catch (ClassNotFoundException unused) {
            if (!bjh.f()) {
                throw new GeneralSecurityException("cannot use AES-GCM: javax.crypto.spec.GCMParameterSpec not found");
            }
            ivParameterSpec = new IvParameterSpec(b, 0, length2);
        }
        ThreadLocal threadLocal = a;
        ((Cipher) threadLocal.get()).init(1, this.b, ivParameterSpec);
        Cipher cipher = (Cipher) threadLocal.get();
        int length3 = bArr.length;
        int doFinal = cipher.doFinal(bArr, 0, length3, bArr3, 12);
        if (doFinal == length3 + 16) {
            return bArr3;
        }
        throw new GeneralSecurityException(String.format("encryption failed; GCM tag must be %s bytes, but got only %s bytes", new Object[]{16, Integer.valueOf(doFinal - length3)}));
    }
}
