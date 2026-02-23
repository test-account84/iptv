package com.google.ads.interactivemedia.v3.internal;

import android.annotation.SuppressLint;
import android.media.MediaCodecInfo;
import android.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

@SuppressLint({"InlinedApi"})
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class rw {
    public static final /* synthetic */ int a = 0;
    private static final Pattern b = Pattern.compile("^\\D?(\\d+)$");
    private static final HashMap c = new HashMap();
    private static int d = -1;

    public static int a() throws rr {
        int i;
        int i2 = d;
        if (i2 == -1) {
            rh g = g("video/avc");
            if (g != null) {
                int i3 = 0;
                for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : g.f()) {
                    int i4 = codecProfileLevel.level;
                    if (i4 != 1 && i4 != 2) {
                        switch (i4) {
                            case 8:
                            case 16:
                            case 32:
                                i = 101376;
                                break;
                            case 64:
                                i = 202752;
                                break;
                            case 128:
                            case 256:
                                i = 414720;
                                break;
                            case 512:
                                i = 921600;
                                break;
                            case 1024:
                                i = 1310720;
                                break;
                            case 2048:
                            case 4096:
                                i = 2097152;
                                break;
                            case 8192:
                                i = 2228224;
                                break;
                            case 16384:
                                i = 5652480;
                                break;
                            case 32768:
                            case 65536:
                                i = 9437184;
                                break;
                            case 131072:
                            case 262144:
                            case 524288:
                                i = 35651584;
                                break;
                            default:
                                i = -1;
                                break;
                        }
                    } else {
                        i = 25344;
                    }
                    i3 = Math.max(i, i3);
                }
                i2 = Math.max(i3, cq.a >= 21 ? 345600 : 172800);
            } else {
                i2 = 0;
            }
            d = i2;
        }
        return i2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:112:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x02a6 A[Catch: NumberFormatException -> 0x023a, TRY_LEAVE, TryCatch #3 {NumberFormatException -> 0x023a, blocks: (B:127:0x024a, B:129:0x025c, B:140:0x0278, B:143:0x02a6), top: B:126:0x024a }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0392  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x03ce  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x057d  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x0585  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:343:0x0500  */
    /* JADX WARN: Removed duplicated region for block: B:492:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.util.Pair b(com.google.ads.interactivemedia.v3.internal.s r17) {
        /*
            Method dump skipped, instructions count: 2336
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.rw.b(com.google.ads.interactivemedia.v3.internal.s):android.util.Pair");
    }

    public static rh c() throws rr {
        return g("audio/raw");
    }

    public static String d(s sVar) {
        Pair b2;
        if ("audio/eac3-joc".equals(sVar.l)) {
            return "audio/eac3";
        }
        if (!"video/dolby-vision".equals(sVar.l) || (b2 = b(sVar)) == null) {
            return null;
        }
        int intValue = ((Integer) b2.first).intValue();
        if (intValue == 16 || intValue == 256) {
            return "video/hevc";
        }
        if (intValue == 512) {
            return "video/avc";
        }
        return null;
    }

    public static synchronized List e(String str, boolean z, boolean z2) throws rr {
        synchronized (rw.class) {
            try {
                rq rqVar = new rq(str, z, z2);
                HashMap hashMap = c;
                List list = (List) hashMap.get(rqVar);
                if (list != null) {
                    return list;
                }
                int i = cq.a;
                ArrayList h = h(rqVar, i >= 21 ? new ru(z, z2) : new rt(null));
                if (z && h.isEmpty() && i >= 21 && i <= 23) {
                    h = h(rqVar, new rt(null));
                    if (!h.isEmpty()) {
                        cd.e("MediaCodecUtil", "MediaCodecList API didn't list secure decoder for: " + str + ". Assuming: " + ((rh) h.get(0)).a);
                    }
                }
                if ("audio/raw".equals(str)) {
                    if (i < 26 && cq.b.equals("R9") && h.size() == 1 && ((rh) h.get(0)).a.equals("OMX.MTK.AUDIO.DECODER.RAW")) {
                        h.add(rh.g("OMX.google.raw.decoder", "audio/raw", "audio/raw", null, false, true, false, false));
                    }
                    i(h, rp.b);
                }
                if (i < 21 && h.size() > 1) {
                    String str2 = ((rh) h.get(0)).a;
                    if ("OMX.SEC.mp3.dec".equals(str2) || "OMX.SEC.MP3.Decoder".equals(str2) || "OMX.brcm.audio.mp3.decoder".equals(str2)) {
                        i(h, rp.a);
                    }
                }
                if (i < 32 && h.size() > 1 && "OMX.qti.audio.decoder.flac".equals(((rh) h.get(0)).a)) {
                    h.add((rh) h.remove(0));
                }
                avo m = avo.m(h);
                hashMap.put(rqVar, m);
                return m;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static List f(List list, s sVar) {
        ArrayList arrayList = new ArrayList(list);
        i(arrayList, new rn(sVar));
        return arrayList;
    }

    public static rh g(String str) throws rr {
        List e = e(str, false, false);
        if (e.isEmpty()) {
            return null;
        }
        return (rh) e.get(0);
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x029b  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x02a7 A[Catch: Exception -> 0x02ac, TryCatch #2 {Exception -> 0x02ac, blocks: (B:141:0x0276, B:145:0x028d, B:149:0x02a1, B:151:0x02a7, B:152:0x02bd, B:154:0x02c5, B:156:0x02ef, B:178:0x02f5, B:189:0x02ca, B:191:0x02da, B:193:0x02e2, B:197:0x02b4), top: B:140:0x0276 }] */
    /* JADX WARN: Removed duplicated region for block: B:154:0x02c5 A[Catch: Exception -> 0x02ac, TryCatch #2 {Exception -> 0x02ac, blocks: (B:141:0x0276, B:145:0x028d, B:149:0x02a1, B:151:0x02a7, B:152:0x02bd, B:154:0x02c5, B:156:0x02ef, B:178:0x02f5, B:189:0x02ca, B:191:0x02da, B:193:0x02e2, B:197:0x02b4), top: B:140:0x0276 }] */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0319 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0386 A[ADDED_TO_REGION, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:189:0x02ca A[Catch: Exception -> 0x02ac, TryCatch #2 {Exception -> 0x02ac, blocks: (B:141:0x0276, B:145:0x028d, B:149:0x02a1, B:151:0x02a7, B:152:0x02bd, B:154:0x02c5, B:156:0x02ef, B:178:0x02f5, B:189:0x02ca, B:191:0x02da, B:193:0x02e2, B:197:0x02b4), top: B:140:0x0276 }] */
    /* JADX WARN: Removed duplicated region for block: B:197:0x02b4 A[Catch: Exception -> 0x02ac, TryCatch #2 {Exception -> 0x02ac, blocks: (B:141:0x0276, B:145:0x028d, B:149:0x02a1, B:151:0x02a7, B:152:0x02bd, B:154:0x02c5, B:156:0x02ef, B:178:0x02f5, B:189:0x02ca, B:191:0x02da, B:193:0x02e2, B:197:0x02b4), top: B:140:0x0276 }] */
    /* JADX WARN: Removed duplicated region for block: B:201:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.util.ArrayList h(com.google.ads.interactivemedia.v3.internal.rq r22, com.google.ads.interactivemedia.v3.internal.rs r23) throws com.google.ads.interactivemedia.v3.internal.rr {
        /*
            Method dump skipped, instructions count: 917
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.rw.h(com.google.ads.interactivemedia.v3.internal.rq, com.google.ads.interactivemedia.v3.internal.rs):java.util.ArrayList");
    }

    private static void i(List list, rv rvVar) {
        Collections.sort(list, new ro(rvVar));
    }

    private static boolean j(MediaCodecInfo mediaCodecInfo, String str) {
        if (cq.a >= 29) {
            return F1.a(mediaCodecInfo);
        }
        if (ar.m(str)) {
            return true;
        }
        String d2 = com.google.ads.interactivemedia.v3.impl.data.k.d(mediaCodecInfo.getName());
        if (d2.startsWith("arc.")) {
            return false;
        }
        if (d2.startsWith("omx.google.") || d2.startsWith("omx.ffmpeg.")) {
            return true;
        }
        if ((d2.startsWith("omx.sec.") && d2.contains(".sw.")) || d2.equals("omx.qcom.video.decoder.hevcswvdec") || d2.startsWith("c2.android.") || d2.startsWith("c2.google.")) {
            return true;
        }
        return (d2.startsWith("omx.") || d2.startsWith("c2.")) ? false : true;
    }
}
