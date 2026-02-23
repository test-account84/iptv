package com.google.ads.interactivemedia.v3.internal;

import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.util.Pair;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class rh {
    public final String a;
    public final String b;
    public final String c;
    public final MediaCodecInfo.CodecCapabilities d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    private final boolean h;

    public rh(String str, String str2, String str3, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2, boolean z3) {
        af.s(str);
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = codecCapabilities;
        this.g = z;
        this.e = z2;
        this.f = z3;
        this.h = ar.q(str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.ads.interactivemedia.v3.internal.rh g(java.lang.String r8, java.lang.String r9, java.lang.String r10, android.media.MediaCodecInfo.CodecCapabilities r11, boolean r12, boolean r13, boolean r14, boolean r15) {
        /*
            com.google.ads.interactivemedia.v3.internal.rh r13 = new com.google.ads.interactivemedia.v3.internal.rh
            r14 = 1
            r0 = 0
            if (r11 == 0) goto L3d
            int r1 = com.google.ads.interactivemedia.v3.internal.cq.a
            r2 = 19
            if (r1 < r2) goto L3d
            java.lang.String r2 = "adaptive-playback"
            boolean r2 = r11.isFeatureSupported(r2)
            if (r2 == 0) goto L3d
            r2 = 22
            if (r1 > r2) goto L2b
            java.lang.String r1 = com.google.ads.interactivemedia.v3.internal.cq.d
            java.lang.String r2 = "ODROID-XU3"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L2d
            java.lang.String r2 = "Nexus 10"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L2b
            goto L2d
        L2b:
            r6 = 1
            goto L3e
        L2d:
            java.lang.String r1 = "OMX.Exynos.AVC.Decoder"
            boolean r1 = r1.equals(r8)
            if (r1 != 0) goto L3d
            java.lang.String r1 = "OMX.Exynos.AVC.Decoder.secure"
            boolean r1 = r1.equals(r8)
            if (r1 == 0) goto L2b
        L3d:
            r6 = 0
        L3e:
            r1 = 21
            if (r11 == 0) goto L4b
            int r2 = com.google.ads.interactivemedia.v3.internal.cq.a
            if (r2 < r1) goto L4b
            java.lang.String r2 = "tunneled-playback"
            r11.isFeatureSupported(r2)
        L4b:
            if (r15 != 0) goto L5b
            if (r11 == 0) goto L5d
            int r15 = com.google.ads.interactivemedia.v3.internal.cq.a
            if (r15 < r1) goto L5d
            java.lang.String r15 = "secure-playback"
            boolean r15 = r11.isFeatureSupported(r15)
            if (r15 == 0) goto L5d
        L5b:
            r7 = 1
            goto L5e
        L5d:
            r7 = 0
        L5e:
            r0 = r13
            r1 = r8
            r2 = r9
            r3 = r10
            r4 = r11
            r5 = r12
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.rh.g(java.lang.String, java.lang.String, java.lang.String, android.media.MediaCodecInfo$CodecCapabilities, boolean, boolean, boolean, boolean):com.google.ads.interactivemedia.v3.internal.rh");
    }

    private static Point h(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2) {
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        return new Point(cq.c(i, widthAlignment) * widthAlignment, cq.c(i2, heightAlignment) * heightAlignment);
    }

    private final void i(String str) {
        cd.a("MediaCodecInfo", "NoSupport [" + str + "] [" + this.a + ", " + this.b + "] [" + cq.e + "]");
    }

    private static boolean j(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2, double d) {
        Point h = h(videoCapabilities, i, i2);
        int i3 = h.x;
        int i4 = h.y;
        return (d == -1.0d || d < 1.0d) ? videoCapabilities.isSizeSupported(i3, i4) : videoCapabilities.areSizeAndRateSupported(i3, i4, Math.floor(d));
    }

    public final Point a(int i, int i2) {
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.d;
        if (codecCapabilities == null || (videoCapabilities = codecCapabilities.getVideoCapabilities()) == null) {
            return null;
        }
        return h(videoCapabilities, i, i2);
    }

    public final eq b(s sVar, s sVar2) {
        int i = true != cq.V(sVar.l, sVar2.l) ? 8 : 0;
        if (this.h) {
            if (sVar.t != sVar2.t) {
                i |= 1024;
            }
            if (!this.e && (sVar.q != sVar2.q || sVar.r != sVar2.r)) {
                i |= 512;
            }
            if (!cq.V(sVar.x, sVar2.x)) {
                i |= 2048;
            }
            String str = this.a;
            if (cq.d.startsWith("SM-T230") && "OMX.MARVELL.VIDEO.HW.CODA7542DECODER".equals(str) && !sVar.e(sVar2)) {
                i |= 2;
            }
            if (i == 0) {
                return new eq(this.a, sVar, sVar2, true != sVar.e(sVar2) ? 2 : 3, 0);
            }
        } else {
            if (sVar.y != sVar2.y) {
                i |= 4096;
            }
            if (sVar.z != sVar2.z) {
                i |= 8192;
            }
            if (sVar.A != sVar2.A) {
                i |= 16384;
            }
            if (i == 0 && "audio/mp4a-latm".equals(this.b)) {
                Pair b = rw.b(sVar);
                Pair b2 = rw.b(sVar2);
                if (b != null && b2 != null) {
                    int intValue = ((Integer) b.first).intValue();
                    int intValue2 = ((Integer) b2.first).intValue();
                    if (intValue == 42 && intValue2 == 42) {
                        return new eq(this.a, sVar, sVar2, 3, 0);
                    }
                }
            }
            if (!sVar.e(sVar2)) {
                i |= 32;
            }
            if ("audio/opus".equals(this.b)) {
                i |= 2;
            }
            if (i == 0) {
                return new eq(this.a, sVar, sVar2, 1, 0);
            }
        }
        return new eq(this.a, sVar, sVar2, 0, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00f9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean c(com.google.ads.interactivemedia.v3.internal.s r13) throws com.google.ads.interactivemedia.v3.internal.rr {
        /*
            Method dump skipped, instructions count: 668
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.rh.c(com.google.ads.interactivemedia.v3.internal.s):boolean");
    }

    public final boolean d(s sVar) {
        if (this.h) {
            return this.e;
        }
        Pair b = rw.b(sVar);
        return b != null && ((Integer) b.first).intValue() == 42;
    }

    public final boolean e(int i, int i2, double d) {
        String str;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.d;
        if (codecCapabilities == null) {
            str = "sizeAndRate.caps";
        } else {
            MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
            if (videoCapabilities == null) {
                str = "sizeAndRate.vCaps";
            } else {
                if (j(videoCapabilities, i, i2, d)) {
                    return true;
                }
                if (i < i2 && ((!"OMX.MTK.VIDEO.DECODER.HEVC".equals(this.a) || !"mcv5a".equals(cq.b)) && j(videoCapabilities, i2, i, d))) {
                    String str2 = this.a;
                    String str3 = this.b;
                    String str4 = cq.e;
                    StringBuilder sb = new StringBuilder();
                    sb.append("AssumedSupport [");
                    sb.append("sizeAndRate.rotated, " + i + "x" + i2 + "x" + d);
                    sb.append("] [");
                    sb.append(str2);
                    sb.append(", ");
                    sb.append(str3);
                    sb.append("] [");
                    sb.append(str4);
                    sb.append("]");
                    cd.a("MediaCodecInfo", sb.toString());
                    return true;
                }
                str = "sizeAndRate.support, " + i + "x" + i2 + "x" + d;
            }
        }
        i(str);
        return false;
    }

    public final MediaCodecInfo.CodecProfileLevel[] f() {
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.d;
        return (codecCapabilities == null || (codecProfileLevelArr = codecCapabilities.profileLevels) == null) ? new MediaCodecInfo.CodecProfileLevel[0] : codecProfileLevelArr;
    }

    public final String toString() {
        return this.a;
    }
}
