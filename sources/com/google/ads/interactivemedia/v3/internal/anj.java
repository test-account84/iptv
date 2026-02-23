package com.google.ads.interactivemedia.v3.internal;

import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class anj {
    private static Cipher a;
    private static final Object b = new Object();
    private static final Object c = new Object();

    private static final Cipher c() throws NoSuchAlgorithmException, NoSuchPaddingException {
        Cipher cipher;
        synchronized (c) {
            try {
                if (a == null) {
                    a = Cipher.getInstance("AES/CBC/PKCS5Padding");
                }
                cipher = a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return cipher;
    }

    public final String a(byte[] bArr, byte[] bArr2) throws ani {
        byte[] doFinal;
        byte[] iv;
        int length = bArr.length;
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            synchronized (b) {
                c().init(1, secretKeySpec, (SecureRandom) null);
                doFinal = c().doFinal(bArr2);
                iv = c().getIV();
            }
            int length2 = doFinal.length + iv.length;
            ByteBuffer allocate = ByteBuffer.allocate(length2);
            allocate.put(iv).put(doFinal);
            allocate.flip();
            byte[] bArr3 = new byte[length2];
            allocate.get(bArr3);
            return com.google.ads.interactivemedia.v3.impl.data.aq.a(bArr3, false);
        } catch (BadPaddingException e) {
            throw new ani(e);
        } catch (NoSuchAlgorithmException e2) {
            throw new ani(e2);
        } catch (NoSuchPaddingException e3) {
            throw new ani(e3);
        } catch (IllegalBlockSizeException e4) {
            throw new ani(e4);
        } catch (InvalidKeyException e5) {
            throw new ani(e5);
        }
    }

    public final byte[] b(byte[] bArr, String str) throws ani {
        byte[] doFinal;
        int length = bArr.length;
        try {
            byte[] b2 = com.google.ads.interactivemedia.v3.impl.data.aq.b(str, false);
            int length2 = b2.length;
            if (length2 <= 16) {
                throw new ani();
            }
            ByteBuffer allocate = ByteBuffer.allocate(length2);
            allocate.put(b2);
            allocate.flip();
            byte[] bArr2 = new byte[16];
            byte[] bArr3 = new byte[length2 - 16];
            allocate.get(bArr2);
            allocate.get(bArr3);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            synchronized (b) {
                c().init(2, secretKeySpec, new IvParameterSpec(bArr2));
                doFinal = c().doFinal(bArr3);
            }
            return doFinal;
        } catch (InvalidAlgorithmParameterException e) {
            throw new ani(e);
        } catch (NoSuchAlgorithmException e2) {
            throw new ani(e2);
        } catch (IllegalArgumentException e3) {
            throw new ani(e3);
        } catch (NoSuchPaddingException e4) {
            throw new ani(e4);
        } catch (IllegalBlockSizeException e5) {
            throw new ani(e5);
        } catch (InvalidKeyException e6) {
            throw new ani(e6);
        } catch (BadPaddingException e7) {
            throw new ani(e7);
        }
    }
}
