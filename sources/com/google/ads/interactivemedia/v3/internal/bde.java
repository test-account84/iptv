package com.google.ads.interactivemedia.v3.internal;

import java.security.GeneralSecurityException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bde {
    private final String a;

    public bde(String str) {
        this.a = str;
    }

    private final byte[] f(byte[] bArr, byte[] bArr2, int i) throws GeneralSecurityException {
        Mac mac = (Mac) biv.b.a(this.a);
        if (i > mac.getMacLength() * 255) {
            throw new GeneralSecurityException("size too large");
        }
        byte[] bArr3 = new byte[i];
        mac.init(new SecretKeySpec(bArr, this.a));
        byte[] bArr4 = new byte[0];
        int i2 = 1;
        int i3 = 0;
        while (true) {
            mac.update(bArr4);
            mac.update(bArr2);
            mac.update((byte) i2);
            bArr4 = mac.doFinal();
            int length = bArr4.length;
            int i4 = i3 + length;
            if (i4 >= i) {
                System.arraycopy(bArr4, 0, bArr3, i3, i - i3);
                return bArr3;
            }
            System.arraycopy(bArr4, 0, bArr3, i3, length);
            i2++;
            i3 = i4;
        }
    }

    private final byte[] g(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        Mac mac = (Mac) biv.b.a(this.a);
        if (bArr2 == null || bArr2.length == 0) {
            mac.init(new SecretKeySpec(new byte[mac.getMacLength()], this.a));
        } else {
            mac.init(new SecretKeySpec(bArr2, this.a));
        }
        return mac.doFinal(bArr);
    }

    public final int a() throws GeneralSecurityException {
        return Mac.getInstance(this.a).getMacLength();
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final byte[] b() throws java.security.GeneralSecurityException {
        /*
            r5 = this;
            java.lang.String r0 = r5.a
            int r1 = r0.hashCode()
            r2 = 984523022(0x3aaea10e, float:0.0013323145)
            r3 = 1
            r4 = 2
            if (r1 == r2) goto L2c
            r2 = 984524074(0x3aaea52a, float:0.0013324369)
            if (r1 == r2) goto L22
            r2 = 984525777(0x3aaeabd1, float:0.0013326352)
            if (r1 == r2) goto L18
            goto L36
        L18:
            java.lang.String r1 = "HmacSha512"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L36
            r0 = 2
            goto L37
        L22:
            java.lang.String r1 = "HmacSha384"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L36
            r0 = 1
            goto L37
        L2c:
            java.lang.String r1 = "HmacSha256"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L36
            r0 = 0
            goto L37
        L36:
            r0 = -1
        L37:
            if (r0 == 0) goto L4b
            if (r0 == r3) goto L48
            if (r0 != r4) goto L40
            byte[] r0 = com.google.ads.interactivemedia.v3.internal.bdr.h
            return r0
        L40:
            java.security.GeneralSecurityException r0 = new java.security.GeneralSecurityException
            java.lang.String r1 = "Could not determine HPKE KDF ID"
            r0.<init>(r1)
            throw r0
        L48:
            byte[] r0 = com.google.ads.interactivemedia.v3.internal.bdr.g
            return r0
        L4b:
            byte[] r0 = com.google.ads.interactivemedia.v3.internal.bdr.f
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.bde.b():byte[]");
    }

    public final byte[] c(byte[] bArr, byte[] bArr2, String str, byte[] bArr3, int i) throws GeneralSecurityException {
        return f(bArr, bdr.f(str, bArr2, bArr3, i), i);
    }

    public final byte[] d(byte[] bArr, byte[] bArr2, String str, byte[] bArr3) throws GeneralSecurityException {
        return g(bdr.e(str, bArr2, bArr3), bArr);
    }

    public final byte[] e(byte[] bArr, byte[] bArr2, byte[] bArr3, int i) throws GeneralSecurityException {
        return f(g(bdr.e("eae_prk", bArr, bArr3), null), bdr.f("shared_secret", bArr2, bArr3, i), i);
    }
}
