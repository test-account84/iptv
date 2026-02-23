package com.google.ads.interactivemedia.v3.internal;

import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class adu {
    private static final byte[] d = {0, 0, 1};
    public int a;
    public int b;
    public byte[] c = new byte[128];
    private boolean e;
    private int f;

    public final void a(byte[] bArr, int i, int i2) {
        if (this.e) {
            int i3 = i2 - i;
            byte[] bArr2 = this.c;
            int length = bArr2.length;
            int i4 = this.a + i3;
            if (length < i4) {
                this.c = Arrays.copyOf(bArr2, i4 + i4);
            }
            System.arraycopy(bArr, i, this.c, this.a, i3);
            this.a += i3;
        }
    }

    public final void b() {
        this.e = false;
        this.a = 0;
        this.f = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean c(int r9, int r10) {
        /*
            r8 = this;
            int r0 = r8.f
            r1 = 0
            r2 = 3
            r3 = 1
            if (r0 == 0) goto L45
            r4 = 181(0xb5, float:2.54E-43)
            r5 = 2
            java.lang.String r6 = "Unexpected start code value"
            java.lang.String r7 = "H263Reader"
            if (r0 == r3) goto L3f
            if (r0 == r5) goto L37
            if (r0 == r2) goto L22
            r0 = 179(0xb3, float:2.51E-43)
            if (r9 == r0) goto L1a
            if (r9 != r4) goto L4d
        L1a:
            int r9 = r8.a
            int r9 = r9 - r10
            r8.a = r9
            r8.e = r1
            return r3
        L22:
            r9 = r9 & 240(0xf0, float:3.36E-43)
            r10 = 32
            if (r9 == r10) goto L2f
        L28:
            com.google.ads.interactivemedia.v3.internal.cd.e(r7, r6)
            r8.b()
            goto L4d
        L2f:
            int r9 = r8.a
            r8.b = r9
            r9 = 4
            r8.f = r9
            goto L4d
        L37:
            r10 = 31
            if (r9 <= r10) goto L3c
            goto L28
        L3c:
            r8.f = r2
            goto L4d
        L3f:
            if (r9 == r4) goto L42
            goto L28
        L42:
            r8.f = r5
            goto L4d
        L45:
            r10 = 176(0xb0, float:2.47E-43)
            if (r9 != r10) goto L4d
            r8.f = r3
            r8.e = r3
        L4d:
            byte[] r9 = com.google.ads.interactivemedia.v3.internal.adu.d
            r8.a(r9, r1, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.adu.c(int, int):boolean");
    }
}
