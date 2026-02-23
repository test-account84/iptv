package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class ym {
    public static final /* synthetic */ int a = 0;
    private static final int[] b = {96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350};
    private static final int[] c = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    public static yl a(byte[] bArr) throws as {
        return b(new ci(bArr), false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x00b7, code lost:
    
        if (r11 != 3) goto L59;
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00b1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.ads.interactivemedia.v3.internal.yl b(com.google.ads.interactivemedia.v3.internal.ci r11, boolean r12) throws com.google.ads.interactivemedia.v3.internal.as {
        /*
            Method dump skipped, instructions count: 266
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.ym.b(com.google.ads.interactivemedia.v3.internal.ci, boolean):com.google.ads.interactivemedia.v3.internal.yl");
    }

    private static int c(ci ciVar) {
        int c2 = ciVar.c(5);
        return c2 == 31 ? ciVar.c(6) + 32 : c2;
    }

    private static int d(ci ciVar) throws as {
        int c2 = ciVar.c(4);
        if (c2 == 15) {
            return ciVar.c(24);
        }
        if (c2 < 13) {
            return b[c2];
        }
        throw as.a(null, null);
    }
}
