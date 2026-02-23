package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class axw {
    /* JADX WARN: Code restructure failed: missing block: B:18:0x004b, code lost:
    
        if (r10 > 0) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x004e, code lost:
    
        if (r10 < 0) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static long a(long r10, java.math.RoundingMode r12) {
        /*
            com.google.ads.interactivemedia.v3.internal.atp.k(r12)
            r0 = 1000(0x3e8, double:4.94E-321)
            long r2 = r10 / r0
            long r4 = r2 * r0
            long r4 = r10 - r4
            r6 = 0
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 != 0) goto L12
            return r2
        L12:
            long r10 = r10 ^ r0
            r9 = 63
            long r10 = r10 >> r9
            int r11 = (int) r10
            r10 = r11 | 1
            int[] r11 = com.google.ads.interactivemedia.v3.internal.axv.a
            int r9 = r12.ordinal()
            r11 = r11[r9]
            switch(r11) {
                case 1: goto L53;
                case 2: goto L55;
                case 3: goto L4e;
                case 4: goto L50;
                case 5: goto L4b;
                case 6: goto L2a;
                case 7: goto L2a;
                case 8: goto L2a;
                default: goto L24;
            }
        L24:
            java.lang.AssertionError r10 = new java.lang.AssertionError
            r10.<init>()
            throw r10
        L2a:
            long r4 = java.lang.Math.abs(r4)
            long r0 = java.lang.Math.abs(r0)
            long r0 = r0 - r4
            long r4 = r4 - r0
            int r11 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r11 != 0) goto L48
            java.math.RoundingMode r11 = java.math.RoundingMode.HALF_UP
            if (r12 == r11) goto L50
            java.math.RoundingMode r11 = java.math.RoundingMode.HALF_EVEN
            if (r12 != r11) goto L55
            r11 = 1
            long r11 = r11 & r2
            int r0 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1))
            if (r0 == 0) goto L55
            goto L50
        L48:
            if (r11 <= 0) goto L55
            goto L50
        L4b:
            if (r10 <= 0) goto L55
            goto L50
        L4e:
            if (r10 >= 0) goto L55
        L50:
            long r10 = (long) r10
            long r2 = r2 + r10
            return r2
        L53:
            if (r8 != 0) goto L56
        L55:
            return r2
        L56:
            java.lang.ArithmeticException r10 = new java.lang.ArithmeticException
            java.lang.String r11 = "mode was UNNECESSARY, but rounding was necessary"
            r10.<init>(r11)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.axw.a(long, java.math.RoundingMode):long");
    }
}
