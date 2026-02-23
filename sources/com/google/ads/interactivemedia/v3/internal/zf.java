package com.google.ads.interactivemedia.v3.internal;

import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zf {
    public static final /* synthetic */ int a = 0;
    private static final int[] b = {1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8};
    private static final int[] c = {-1, 8000, 16000, 32000, -1, -1, 11025, 22050, 44100, -1, -1, 12000, 24000, 48000, -1, -1};
    private static final int[] d = {64, 112, 128, 192, 224, 256, 384, 448, 512, 640, 768, 896, 1024, 1152, 1280, 1536, 1920, 2048, 2304, 2560, 2688, 2816, 2823, 2944, 3072, 3840, 4096, 6144, 7680};

    public static s a(byte[] bArr, String str, String str2) {
        ci ciVar;
        if (bArr[0] == Byte.MAX_VALUE) {
            ciVar = new ci(bArr);
        } else {
            byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
            byte b2 = copyOf[0];
            if (b2 == -2 || b2 == -1) {
                for (int i = 0; i < copyOf.length - 1; i += 2) {
                    byte b3 = copyOf[i];
                    int i2 = i + 1;
                    copyOf[i] = copyOf[i2];
                    copyOf[i2] = b3;
                }
            }
            ciVar = new ci(copyOf);
            if (copyOf[0] == 31) {
                ci ciVar2 = new ci(copyOf);
                while (ciVar2.a() >= 16) {
                    ciVar2.i(2);
                    ciVar.l(ciVar2.c(14));
                }
            }
            ciVar.e(copyOf);
        }
        ciVar.i(60);
        int i3 = b[ciVar.c(6)];
        int i4 = c[ciVar.c(4)];
        int c2 = ciVar.c(5);
        int i5 = c2 < 29 ? (d[c2] * 1000) / 2 : -1;
        ciVar.i(10);
        int i6 = ciVar.c(2) > 0 ? 1 : 0;
        r rVar = new r();
        rVar.S(str);
        rVar.ae("audio/vnd.dts");
        rVar.G(i5);
        rVar.H(i3 + i6);
        rVar.af(i4);
        rVar.M(null);
        rVar.V(str2);
        return rVar.v();
    }
}
