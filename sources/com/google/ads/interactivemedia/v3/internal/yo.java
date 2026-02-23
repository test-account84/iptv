package com.google.ads.interactivemedia.v3.internal;

import java.nio.ByteBuffer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class yo {
    public static final /* synthetic */ int a = 0;
    private static final int[] b = {1, 2, 3, 6};
    private static final int[] c = {48000, 44100, 32000};
    private static final int[] d = {24000, 22050, 16000};
    private static final int[] e = {2, 1, 2, 3, 3, 4, 4, 5};
    private static final int[] f = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320, 384, 448, 512, 576, 640};
    private static final int[] g = {69, 87, 104, 121, 139, 174, 208, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    public static int a(ByteBuffer byteBuffer) {
        if (((byteBuffer.get(byteBuffer.position() + 5) & 248) >> 3) > 10) {
            return b[((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3 ? (byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4 : 3] * 256;
        }
        return 1536;
    }

    public static int b(byte[] bArr) {
        if (bArr.length < 6) {
            return -1;
        }
        if (((bArr[5] & 248) >> 3) <= 10) {
            byte b2 = bArr[4];
            return f((b2 & 192) >> 6, b2 & 63);
        }
        int i = ((bArr[3] & 255) | ((bArr[2] & 7) << 8)) + 1;
        return i + i;
    }

    public static s c(cj cjVar, String str, String str2, o oVar) {
        int i = c[(cjVar.i() & 192) >> 6];
        int i2 = cjVar.i();
        int i3 = e[(i2 & 56) >> 3];
        if ((i2 & 4) != 0) {
            i3++;
        }
        r rVar = new r();
        rVar.S(str);
        rVar.ae("audio/ac3");
        rVar.H(i3);
        rVar.af(i);
        rVar.M(oVar);
        rVar.V(str2);
        return rVar.v();
    }

    public static s d(cj cjVar, String str, String str2, o oVar) {
        cjVar.G(2);
        int i = c[(cjVar.i() & 192) >> 6];
        int i2 = cjVar.i();
        int i3 = e[(i2 & 14) >> 1];
        if ((i2 & 1) != 0) {
            i3++;
        }
        if (((cjVar.i() & 30) >> 1) > 0 && (2 & cjVar.i()) != 0) {
            i3 += 2;
        }
        String str3 = (cjVar.a() <= 0 || (cjVar.i() & 1) == 0) ? "audio/eac3" : "audio/eac3-joc";
        r rVar = new r();
        rVar.S(str);
        rVar.ae(str3);
        rVar.H(i3);
        rVar.af(i);
        rVar.M(oVar);
        rVar.V(str2);
        return rVar.v();
    }

    /* JADX WARN: Removed duplicated region for block: B:116:0x0175  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.ads.interactivemedia.v3.internal.yn e(com.google.ads.interactivemedia.v3.internal.ci r19) {
        /*
            Method dump skipped, instructions count: 624
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.yo.e(com.google.ads.interactivemedia.v3.internal.ci):com.google.ads.interactivemedia.v3.internal.yn");
    }

    private static int f(int i, int i2) {
        int i3 = i2 / 2;
        if (i < 0 || i >= 3 || i2 < 0 || i3 >= 19) {
            return -1;
        }
        int i4 = c[i];
        if (i4 == 44100) {
            int i5 = g[i3] + (i2 & 1);
            return i5 + i5;
        }
        int i6 = f[i3];
        return i4 == 32000 ? i6 * 6 : i6 * 4;
    }
}
