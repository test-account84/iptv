package com.google.ads.interactivemedia.v3.internal;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class amc {
    static boolean a = false;
    private static MessageDigest c;
    private static final Object d = new Object();
    private static final Object e = new Object();
    static final CountDownLatch b = new CountDownLatch(1);

    public static String a(agc agcVar, String str) throws GeneralSecurityException, UnsupportedEncodingException {
        byte[] h;
        bqn aY;
        byte[] av = agcVar.av();
        if (((Boolean) aqo.u.f()).booleanValue()) {
            Vector f = f(av);
            if (f == null || f.size() == 0) {
                h = h(g(afx.u).av(), str, true);
                return com.google.ads.interactivemedia.v3.impl.data.aq.a(h, true);
            }
            agl a2 = agm.a();
            int size = f.size();
            for (int i = 0; i < size; i++) {
                a2.a(bpb.t(h((byte[]) f.get(i), str, false)));
            }
            a2.b(bpb.t(d(av)));
            aY = a2.aY();
        } else {
            if (any.a == null) {
                throw new GeneralSecurityException();
            }
            byte[] a3 = any.a.a(av, str != null ? str.getBytes() : new byte[0]);
            agl a4 = agm.a();
            a4.a(bpb.t(a3));
            a4.c(agg.c);
            aY = a4.aY();
        }
        h = ((agm) aY).av();
        return com.google.ads.interactivemedia.v3.impl.data.aq.a(h, true);
    }

    public static /* bridge */ /* synthetic */ void b(MessageDigest messageDigest) {
        c = messageDigest;
    }

    public static void c() {
        synchronized (e) {
            try {
                if (!a) {
                    a = true;
                    new Thread(new amb(null)).start();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static byte[] d(byte[] bArr) throws NoSuchAlgorithmException {
        byte[] digest;
        MessageDigest messageDigest;
        synchronized (d) {
            try {
                c();
                MessageDigest messageDigest2 = null;
                try {
                    if (b.await(2L, TimeUnit.SECONDS) && (messageDigest = c) != null) {
                        messageDigest2 = messageDigest;
                    }
                } catch (InterruptedException unused) {
                }
                if (messageDigest2 == null) {
                    throw new NoSuchAlgorithmException("Cannot compute hash");
                }
                messageDigest2.reset();
                messageDigest2.update(bArr);
                digest = c.digest();
            } finally {
            }
        }
        return digest;
    }

    public static byte[] e(String str, String str2) {
        agl d2 = age.d();
        try {
            d2.j(bpb.t(str.length() < 3 ? str.getBytes("ISO-8859-1") : com.google.ads.interactivemedia.v3.impl.data.aq.b(str, true)));
            d2.i(bpb.t(str2.length() < 3 ? str2.getBytes("ISO-8859-1") : com.google.ads.interactivemedia.v3.impl.data.aq.b(str2, true)));
            return ((age) d2.aY()).av();
        } catch (GeneralSecurityException | UnsupportedEncodingException unused) {
            return null;
        }
    }

    public static Vector f(byte[] bArr) {
        int length;
        if (bArr == null || (length = bArr.length) <= 0) {
            return null;
        }
        int i = (length + 254) / 255;
        Vector vector = new Vector();
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = i2 * 255;
            try {
                int length2 = bArr.length;
                if (length2 - i3 > 255) {
                    length2 = i3 + 255;
                }
                vector.add(Arrays.copyOfRange(bArr, i3, length2));
            } catch (IndexOutOfBoundsException unused) {
                return null;
            }
        }
        return vector;
    }

    public static agc g(int i) {
        agl as = agc.as();
        as.am(afx.a(i));
        return (agc) as.aY();
    }

    private static byte[] h(byte[] bArr, String str, boolean z) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        ByteBuffer put;
        int i = true != z ? 255 : 239;
        if (bArr.length > i) {
            bArr = g(afx.u).av();
        }
        int length = bArr.length;
        if (length < i) {
            byte[] bArr2 = new byte[i - length];
            new SecureRandom().nextBytes(bArr2);
            put = ByteBuffer.allocate(i + 1).put((byte) length).put(bArr).put(bArr2);
        } else {
            put = ByteBuffer.allocate(i + 1).put((byte) length).put(bArr);
        }
        byte[] array = put.array();
        if (z) {
            array = ByteBuffer.allocate(256).put(d(array)).put(array).array();
        }
        byte[] bArr3 = new byte[256];
        amd[] amdVarArr = new amq().cN;
        int length2 = amdVarArr.length;
        for (int i2 = 0; i2 < 12; i2++) {
            amdVarArr[i2].a(array, bArr3);
        }
        if (str != null && str.length() > 0) {
            if (str.length() > 32) {
                str = str.substring(0, 32);
            }
            new bol(str.getBytes("UTF-8")).a(bArr3);
        }
        return bArr3;
    }
}
