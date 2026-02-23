package p3;

import O2.z0;
import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.util.Pair;
import d4.F;
import d4.k0;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class t {
    public final String a;
    public final String b;
    public final String c;
    public final MediaCodecInfo.CodecCapabilities d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final boolean i;
    public final boolean j;
    public final boolean k;

    public static final class a {
        public static int a(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2, double d) {
            List a = q.a(videoCapabilities);
            if (a == null || a.isEmpty() || t.a()) {
                return 0;
            }
            p.a();
            MediaCodecInfo.VideoCapabilities.PerformancePoint a2 = o.a(i, i2, (int) d);
            for (int i3 = 0; i3 < a.size(); i3++) {
                if (s.a(r.a(a.get(i3)), a2)) {
                    return 2;
                }
            }
            return 1;
        }
    }

    public t(String str, String str2, String str3, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.a = (String) d4.a.e(str);
        this.b = str2;
        this.c = str3;
        this.d = codecCapabilities;
        this.h = z;
        this.i = z2;
        this.j = z3;
        this.e = z4;
        this.f = z5;
        this.g = z6;
        this.k = F.s(str2);
    }

    public static boolean A(String str) {
        return k0.d.startsWith("SM-T230") && "OMX.MARVELL.VIDEO.HW.CODA7542DECODER".equals(str);
    }

    public static boolean B(String str) {
        if (k0.a <= 22) {
            String str2 = k0.d;
            if (("ODROID-XU3".equals(str2) || "Nexus 10".equals(str2)) && ("OMX.Exynos.AVC.Decoder".equals(str) || "OMX.Exynos.AVC.Decoder.secure".equals(str))) {
                return true;
            }
        }
        return false;
    }

    public static boolean C() {
        String str = k0.b;
        if (!str.equals("sabrina") && !str.equals("boreal")) {
            String str2 = k0.d;
            if (!str2.startsWith("Lenovo TB-X605") && !str2.startsWith("Lenovo TB-X606") && !str2.startsWith("Lenovo TB-X616")) {
                return false;
            }
        }
        return true;
    }

    public static boolean D(String str, int i) {
        if ("video/hevc".equals(str) && 2 == i) {
            String str2 = k0.b;
            if ("sailfish".equals(str2) || "marlin".equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean E(String str) {
        return ("OMX.MTK.VIDEO.DECODER.HEVC".equals(str) && "mcv5a".equals(k0.b)) ? false : true;
    }

    public static t F(String str, String str2, String str3, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        return new t(str, str2, str3, codecCapabilities, z, z2, z3, (z4 || codecCapabilities == null || !i(codecCapabilities) || B(str)) ? false : true, codecCapabilities != null && u(codecCapabilities), z5 || (codecCapabilities != null && s(codecCapabilities)));
    }

    public static /* synthetic */ boolean a() {
        return C();
    }

    public static int b(String str, String str2, int i) {
        if (i > 1 || ((k0.a >= 26 && i > 0) || "audio/mpeg".equals(str2) || "audio/3gpp".equals(str2) || "audio/amr-wb".equals(str2) || "audio/mp4a-latm".equals(str2) || "audio/vorbis".equals(str2) || "audio/opus".equals(str2) || "audio/raw".equals(str2) || "audio/flac".equals(str2) || "audio/g711-alaw".equals(str2) || "audio/g711-mlaw".equals(str2) || "audio/gsm".equals(str2))) {
            return i;
        }
        int i2 = "audio/ac3".equals(str2) ? 6 : "audio/eac3".equals(str2) ? 16 : 30;
        d4.B.j("MediaCodecInfo", "AssumedMaxChannelAdjustment: " + str + ", [" + i + " to " + i2 + "]");
        return i2;
    }

    public static Point d(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2) {
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        return new Point(k0.l(i, widthAlignment) * widthAlignment, k0.l(i2, heightAlignment) * heightAlignment);
    }

    public static boolean e(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2, double d) {
        Point d2 = d(videoCapabilities, i, i2);
        int i3 = d2.x;
        int i4 = d2.y;
        return (d == -1.0d || d < 1.0d) ? videoCapabilities.isSizeSupported(i3, i4) : videoCapabilities.areSizeAndRateSupported(i3, i4, Math.floor(d));
    }

    public static MediaCodecInfo.CodecProfileLevel[] g(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        int intValue = (codecCapabilities == null || (videoCapabilities = codecCapabilities.getVideoCapabilities()) == null) ? 0 : videoCapabilities.getBitrateRange().getUpper().intValue();
        int i = intValue >= 180000000 ? 1024 : intValue >= 120000000 ? 512 : intValue >= 60000000 ? 256 : intValue >= 30000000 ? 128 : intValue >= 18000000 ? 64 : intValue >= 12000000 ? 32 : intValue >= 7200000 ? 16 : intValue >= 3600000 ? 8 : intValue >= 1800000 ? 4 : intValue >= 800000 ? 2 : 1;
        MediaCodecInfo.CodecProfileLevel codecProfileLevel = new MediaCodecInfo.CodecProfileLevel();
        codecProfileLevel.profile = 1;
        codecProfileLevel.level = i;
        return new MediaCodecInfo.CodecProfileLevel[]{codecProfileLevel};
    }

    public static boolean i(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return k0.a >= 19 && j(codecCapabilities);
    }

    public static boolean j(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("adaptive-playback");
    }

    public static boolean s(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return k0.a >= 21 && t(codecCapabilities);
    }

    public static boolean t(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("secure-playback");
    }

    public static boolean u(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return k0.a >= 21 && v(codecCapabilities);
    }

    public static boolean v(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("tunneled-playback");
    }

    public static boolean z(String str) {
        return "audio/opus".equals(str);
    }

    public Point c(int i, int i2) {
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.d;
        if (codecCapabilities == null || (videoCapabilities = codecCapabilities.getVideoCapabilities()) == null) {
            return null;
        }
        return d(videoCapabilities, i, i2);
    }

    public U2.h f(z0 z0Var, z0 z0Var2) {
        int i = !k0.c(z0Var.m, z0Var2.m) ? 8 : 0;
        if (this.k) {
            if (z0Var.u != z0Var2.u) {
                i |= 1024;
            }
            if (!this.e && (z0Var.r != z0Var2.r || z0Var.s != z0Var2.s)) {
                i |= 512;
            }
            if (!k0.c(z0Var.y, z0Var2.y)) {
                i |= 2048;
            }
            if (A(this.a) && !z0Var.g(z0Var2)) {
                i |= 2;
            }
            if (i == 0) {
                return new U2.h(this.a, z0Var, z0Var2, z0Var.g(z0Var2) ? 3 : 2, 0);
            }
        } else {
            if (z0Var.z != z0Var2.z) {
                i |= 4096;
            }
            if (z0Var.A != z0Var2.A) {
                i |= 8192;
            }
            if (z0Var.B != z0Var2.B) {
                i |= 16384;
            }
            if (i == 0 && "audio/mp4a-latm".equals(this.b)) {
                Pair r = B.r(z0Var);
                Pair r2 = B.r(z0Var2);
                if (r != null && r2 != null) {
                    int intValue = ((Integer) r.first).intValue();
                    int intValue2 = ((Integer) r2.first).intValue();
                    if (intValue == 42 && intValue2 == 42) {
                        return new U2.h(this.a, z0Var, z0Var2, 3, 0);
                    }
                }
            }
            if (!z0Var.g(z0Var2)) {
                i |= 32;
            }
            if (z(this.b)) {
                i |= 2;
            }
            if (i == 0) {
                return new U2.h(this.a, z0Var, z0Var2, 1, 0);
            }
        }
        return new U2.h(this.a, z0Var, z0Var2, 0, i);
    }

    public MediaCodecInfo.CodecProfileLevel[] h() {
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.d;
        return (codecCapabilities == null || (codecProfileLevelArr = codecCapabilities.profileLevels) == null) ? new MediaCodecInfo.CodecProfileLevel[0] : codecProfileLevelArr;
    }

    public boolean k(int i) {
        String str;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.d;
        if (codecCapabilities == null) {
            str = "channelCount.caps";
        } else {
            MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
            if (audioCapabilities == null) {
                str = "channelCount.aCaps";
            } else {
                if (b(this.a, this.b, audioCapabilities.getMaxInputChannelCount()) >= i) {
                    return true;
                }
                str = "channelCount.support, " + i;
            }
        }
        y(str);
        return false;
    }

    public boolean l(int i) {
        String str;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.d;
        if (codecCapabilities == null) {
            str = "sampleRate.caps";
        } else {
            MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
            if (audioCapabilities == null) {
                str = "sampleRate.aCaps";
            } else {
                if (audioCapabilities.isSampleRateSupported(i)) {
                    return true;
                }
                str = "sampleRate.support, " + i;
            }
        }
        y(str);
        return false;
    }

    public final boolean m(z0 z0Var, boolean z) {
        Pair r = B.r(z0Var);
        if (r == null) {
            return true;
        }
        int intValue = ((Integer) r.first).intValue();
        int intValue2 = ((Integer) r.second).intValue();
        if ("video/dolby-vision".equals(z0Var.m)) {
            if (!"video/avc".equals(this.b)) {
                intValue = "video/hevc".equals(this.b) ? 2 : 8;
            }
            intValue2 = 0;
        }
        if (!this.k && intValue != 42) {
            return true;
        }
        MediaCodecInfo.CodecProfileLevel[] h = h();
        if (k0.a <= 23 && "video/x-vnd.on2.vp9".equals(this.b) && h.length == 0) {
            h = g(this.d);
        }
        for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : h) {
            if (codecProfileLevel.profile == intValue && ((codecProfileLevel.level >= intValue2 || !z) && !D(this.b, intValue))) {
                return true;
            }
        }
        y("codec.profileLevel, " + z0Var.j + ", " + this.c);
        return false;
    }

    public boolean n(z0 z0Var) {
        return q(z0Var) && m(z0Var, false);
    }

    public boolean o(z0 z0Var) {
        int i;
        if (!q(z0Var) || !m(z0Var, true)) {
            return false;
        }
        if (!this.k) {
            if (k0.a >= 21) {
                int i2 = z0Var.A;
                if (i2 != -1 && !l(i2)) {
                    return false;
                }
                int i3 = z0Var.z;
                if (i3 != -1 && !k(i3)) {
                    return false;
                }
            }
            return true;
        }
        int i4 = z0Var.r;
        if (i4 <= 0 || (i = z0Var.s) <= 0) {
            return true;
        }
        if (k0.a >= 21) {
            return w(i4, i, z0Var.t);
        }
        boolean z = i4 * i <= B.P();
        if (!z) {
            y("legacyFrameSize, " + z0Var.r + "x" + z0Var.s);
        }
        return z;
    }

    public boolean p() {
        if (k0.a >= 29 && "video/x-vnd.on2.vp9".equals(this.b)) {
            for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : h()) {
                if (codecProfileLevel.profile == 16384) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean q(z0 z0Var) {
        return this.b.equals(z0Var.m) || this.b.equals(B.m(z0Var));
    }

    public boolean r(z0 z0Var) {
        if (this.k) {
            return this.e;
        }
        Pair r = B.r(z0Var);
        return r != null && ((Integer) r.first).intValue() == 42;
    }

    public String toString() {
        return this.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean w(int r8, int r9, double r10) {
        /*
            r7 = this;
            android.media.MediaCodecInfo$CodecCapabilities r0 = r7.d
            r1 = 0
            if (r0 != 0) goto Lb
            java.lang.String r8 = "sizeAndRate.caps"
        L7:
            r7.y(r8)
            return r1
        Lb:
            android.media.MediaCodecInfo$VideoCapabilities r0 = r0.getVideoCapabilities()
            if (r0 != 0) goto L14
            java.lang.String r8 = "sizeAndRate.vCaps"
            goto L7
        L14:
            int r2 = d4.k0.a
            r3 = 29
            java.lang.String r4 = "@"
            java.lang.String r5 = "x"
            r6 = 1
            if (r2 < r3) goto L47
            int r2 = p3.t.a.a(r0, r8, r9, r10)
            r3 = 2
            if (r2 != r3) goto L27
            return r6
        L27:
            if (r2 != r6) goto L47
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "sizeAndRate.cover, "
        L30:
            r0.append(r2)
            r0.append(r8)
            r0.append(r5)
            r0.append(r9)
            r0.append(r4)
            r0.append(r10)
            java.lang.String r8 = r0.toString()
            goto L7
        L47:
            boolean r2 = e(r0, r8, r9, r10)
            if (r2 != 0) goto L87
            if (r8 >= r9) goto L7f
            java.lang.String r2 = r7.a
            boolean r2 = E(r2)
            if (r2 == 0) goto L7f
            boolean r0 = e(r0, r9, r8, r10)
            if (r0 != 0) goto L5e
            goto L7f
        L5e:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "sizeAndRate.rotated, "
            r0.append(r1)
            r0.append(r8)
            r0.append(r5)
            r0.append(r9)
            r0.append(r4)
            r0.append(r10)
            java.lang.String r8 = r0.toString()
            r7.x(r8)
            goto L87
        L7f:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "sizeAndRate.support, "
            goto L30
        L87:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: p3.t.w(int, int, double):boolean");
    }

    public final void x(String str) {
        d4.B.b("MediaCodecInfo", "AssumedSupport [" + str + "] [" + this.a + ", " + this.b + "] [" + k0.e + "]");
    }

    public final void y(String str) {
        d4.B.b("MediaCodecInfo", "NoSupport [" + str + "] [" + this.a + ", " + this.b + "] [" + k0.e + "]");
    }
}
