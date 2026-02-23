package com.google.ads.interactivemedia.v3.internal;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.util.Arrays;
import javax.crypto.Mac;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bjc implements bgd {
    public static final int a = bch.b;
    private final ThreadLocal b;
    private final String c;
    private final Key d;
    private final int e;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:38:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public bjc(java.lang.String r6, java.security.Key r7) throws java.security.GeneralSecurityException {
        /*
            r5 = this;
            r5.<init>()
            com.google.ads.interactivemedia.v3.internal.bjb r0 = new com.google.ads.interactivemedia.v3.internal.bjb
            r0.<init>(r5)
            r5.b = r0
            int r1 = com.google.ads.interactivemedia.v3.internal.bjc.a
            boolean r1 = com.google.ads.interactivemedia.v3.internal.bch.a(r1)
            if (r1 == 0) goto L91
            r5.c = r6
            r5.d = r7
            byte[] r7 = r7.getEncoded()
            int r7 = r7.length
            r1 = 16
            if (r7 < r1) goto L89
            int r7 = r6.hashCode()
            r1 = 1
            r2 = 2
            r3 = 3
            r4 = 4
            switch(r7) {
                case -1823053428: goto L53;
                case 392315023: goto L49;
                case 392315118: goto L3f;
                case 392316170: goto L35;
                case 392317873: goto L2b;
                default: goto L2a;
            }
        L2a:
            goto L5d
        L2b:
            java.lang.String r7 = "HMACSHA512"
            boolean r7 = r6.equals(r7)
            if (r7 == 0) goto L5d
            r7 = 4
            goto L5e
        L35:
            java.lang.String r7 = "HMACSHA384"
            boolean r7 = r6.equals(r7)
            if (r7 == 0) goto L5d
            r7 = 3
            goto L5e
        L3f:
            java.lang.String r7 = "HMACSHA256"
            boolean r7 = r6.equals(r7)
            if (r7 == 0) goto L5d
            r7 = 2
            goto L5e
        L49:
            java.lang.String r7 = "HMACSHA224"
            boolean r7 = r6.equals(r7)
            if (r7 == 0) goto L5d
            r7 = 1
            goto L5e
        L53:
            java.lang.String r7 = "HMACSHA1"
            boolean r7 = r6.equals(r7)
            if (r7 == 0) goto L5d
            r7 = 0
            goto L5e
        L5d:
            r7 = -1
        L5e:
            if (r7 == 0) goto L82
            if (r7 == r1) goto L7f
            if (r7 == r2) goto L7c
            if (r7 == r3) goto L79
            if (r7 != r4) goto L6d
            r6 = 64
        L6a:
            r5.e = r6
            goto L85
        L6d:
            java.security.NoSuchAlgorithmException r7 = new java.security.NoSuchAlgorithmException
            java.lang.String r0 = "unknown Hmac algorithm: "
            java.lang.String r6 = r0.concat(r6)
            r7.<init>(r6)
            throw r7
        L79:
            r6 = 48
            goto L6a
        L7c:
            r6 = 32
            goto L6a
        L7f:
            r6 = 28
            goto L6a
        L82:
            r6 = 20
            goto L6a
        L85:
            r0.get()
            return
        L89:
            java.security.InvalidAlgorithmParameterException r6 = new java.security.InvalidAlgorithmParameterException
            java.lang.String r7 = "key size too small, need at least 16 bytes"
            r6.<init>(r7)
            throw r6
        L91:
            java.security.GeneralSecurityException r6 = new java.security.GeneralSecurityException
            java.lang.String r7 = "Can not use HMAC in FIPS-mode, as BoringCrypto module is not available."
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.bjc.<init>(java.lang.String, java.security.Key):void");
    }

    public static /* bridge */ /* synthetic */ String b(bjc bjcVar) {
        return bjcVar.c;
    }

    public static /* bridge */ /* synthetic */ Key c(bjc bjcVar) {
        return bjcVar.d;
    }

    public final byte[] a(byte[] bArr, int i) throws GeneralSecurityException {
        if (i > this.e) {
            throw new InvalidAlgorithmParameterException("tag size too big");
        }
        ((Mac) this.b.get()).update(bArr);
        return Arrays.copyOf(((Mac) this.b.get()).doFinal(), i);
    }
}
