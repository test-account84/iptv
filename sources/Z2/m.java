package Z2;

import C3.b;
import C3.n;
import O2.Q1;
import android.content.Context;
import android.os.Looper;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import b4.r;
import b4.s;
import com.google.ads.interactivemedia.v3.api.AdDisplayContainer;
import com.google.ads.interactivemedia.v3.api.AdError;
import com.google.ads.interactivemedia.v3.api.AdErrorEvent;
import com.google.ads.interactivemedia.v3.api.AdEvent;
import com.google.ads.interactivemedia.v3.api.AdPodInfo;
import com.google.ads.interactivemedia.v3.api.AdsLoader;
import com.google.ads.interactivemedia.v3.api.AdsRenderingSettings;
import com.google.ads.interactivemedia.v3.api.AdsRequest;
import com.google.ads.interactivemedia.v3.api.FriendlyObstruction;
import com.google.ads.interactivemedia.v3.api.FriendlyObstructionPurpose;
import com.google.ads.interactivemedia.v3.api.ImaSdkSettings;
import com.google.ads.interactivemedia.v3.api.player.VideoAdPlayer;
import com.google.ads.interactivemedia.v3.api.player.VideoProgressUpdate;
import d4.k0;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import s5.y;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class m {

    public static final class a {
        public final long a;
        public final int b;
        public final int c;
        public final boolean d;
        public final boolean e;
        public final int f;
        public final Boolean g;
        public final List h;
        public final Set i;
        public final Collection j;
        public final AdErrorEvent.AdErrorListener k;
        public final AdEvent.AdEventListener l;
        public final VideoAdPlayer.VideoAdPlayerCallback m;
        public final ImaSdkSettings n;
        public final boolean o;

        public a(long j, int i, int i2, boolean z, boolean z2, int i3, Boolean bool, List list, Set set, Collection collection, AdErrorEvent.AdErrorListener adErrorListener, AdEvent.AdEventListener adEventListener, VideoAdPlayer.VideoAdPlayerCallback videoAdPlayerCallback, ImaSdkSettings imaSdkSettings, boolean z3) {
            this.a = j;
            this.b = i;
            this.c = i2;
            this.d = z;
            this.e = z2;
            this.f = i3;
            this.g = bool;
            this.h = list;
            this.i = set;
            this.j = collection;
            this.k = adErrorListener;
            this.l = adEventListener;
            this.m = videoAdPlayerCallback;
            this.n = imaSdkSettings;
            this.o = z3;
        }
    }

    public interface b {
        AdsLoader a(Context context, ImaSdkSettings imaSdkSettings, AdDisplayContainer adDisplayContainer);

        AdDisplayContainer b(ViewGroup viewGroup, VideoAdPlayer videoAdPlayer);

        ImaSdkSettings c();

        FriendlyObstruction d(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, String str);

        AdsRenderingSettings e();

        AdsRequest f();

        AdDisplayContainer g(Context context, VideoAdPlayer videoAdPlayer);
    }

    public static final class c {
        public final a4.b a;
        public final ImaSdkSettings b;
        public final AdEvent.AdEventListener c;
        public final AdErrorEvent.AdErrorListener d;
        public final y e;
        public final boolean f;
        public final boolean g;

        public c(a4.b bVar, ImaSdkSettings imaSdkSettings, AdEvent.AdEventListener adEventListener, AdErrorEvent.AdErrorListener adErrorListener, List list, boolean z, boolean z2) {
            this.b = imaSdkSettings;
            this.a = bVar;
            this.c = adEventListener;
            this.d = adErrorListener;
            this.e = y.r(list);
            this.f = z;
            this.g = z2;
        }
    }

    public static C3.b a(long j, long j2, int i, long j3, int i2, C3.b bVar) {
        C3.b bVar2 = bVar;
        d4.a.a(i > 0);
        long f = n.f(j, -1, bVar2);
        int g = bVar2.g(f, -9223372036854775807L);
        if (g == -1) {
            long[] v = v(new long[i2 - (i - 1)], 0, j2, j3);
            C3.b a2 = n.a(bVar, j, k0.n1(v), v);
            int g2 = a2.g(f, -9223372036854775807L);
            return g2 != -1 ? a2.r(g2, 0).z(g2, i2) : a2;
        }
        b.b e = bVar2.e(g);
        long[] copyOf = Arrays.copyOf(e.g, e.c);
        int j4 = j(e);
        if (e.d < i2 || j4 == e.c) {
            int i3 = j4 + 1;
            int max = Math.max(i2, i3);
            bVar2 = bVar2.l(g, max).z(g, max);
            copyOf = Arrays.copyOf(copyOf, max);
            copyOf[j4] = j3;
            Arrays.fill(copyOf, i3, max, 0L);
        }
        v(copyOf, j4, j2, Math.max(j2, copyOf[j4]));
        return bVar2.m(g, copyOf).r(g, j4).u(g, k0.n1(copyOf));
    }

    public static C3.b b(int i, long j, int i2, long j2, int i3, C3.b bVar) {
        d4.a.a(i2 < i3);
        long[] v = v(new long[i3], i2, j2, j);
        return bVar.l(i, v.length).m(i, v);
    }

    public static Pair c(int i, int i2, Q1 q1, C3.b bVar) {
        Q1.d s = q1.s(i, new Q1.d());
        d4.a.a(s.i());
        Q1.b bVar2 = new Q1.b();
        q1.l(i2, bVar2, true);
        long l = l(s.g, s.r) + bVar2.f;
        int g = bVar.g(l, -9223372036854775807L);
        if (g != -1) {
            b.b e = bVar.e(g);
            int i3 = 0;
            while (true) {
                int[] iArr = e.f;
                if (i3 >= iArr.length) {
                    break;
                }
                int i4 = iArr[i3];
                if (i4 == 1 || i4 == 0) {
                    break;
                }
                i3++;
            }
            return new Pair(Integer.valueOf(g), Integer.valueOf(i3));
        }
        throw new IllegalStateException(String.format("No unplayed ad group found before or at the start time us %d of the period with index %d", new Object[]{Long.valueOf(l), Integer.valueOf(i2)}));
    }

    public static Pair d(int i, C3.b bVar, Q1 q1) {
        int i2;
        C3.b bVar2 = bVar;
        Q1 q12 = q1;
        Q1.d s = q12.s(0, new Q1.d());
        d4.a.a(q1.u() == 1);
        long l = s.i() ? l(s.g, s.r) - s.r : 0L;
        Q1.b bVar3 = new Q1.b();
        int i3 = bVar2.f;
        int i4 = 0;
        while (i3 < bVar2.c) {
            b.b e = bVar2.e(i3);
            long n1 = k0.n1(e.g);
            int i5 = i4;
            long j = 0;
            int i6 = 0;
            while (true) {
                if (i4 >= Math.min(q1.n(), i + 1)) {
                    i2 = i3;
                    break;
                }
                q12.l(i4, bVar3, true);
                i2 = i3;
                long j2 = e.a;
                if (l >= j2) {
                    long j3 = bVar3.e;
                    if (l + j + j3 > j2 + n1) {
                        l += Math.min(j, e.h);
                        break;
                    }
                    if (i4 == i) {
                        return new Pair(Integer.valueOf(i2), Integer.valueOf(i6));
                    }
                    j += j3;
                    i6++;
                } else {
                    l += bVar3.e;
                }
                i5++;
                i4++;
                q12 = q1;
                i3 = i2;
            }
            i3 = i2 + 1;
            bVar2 = bVar;
            q12 = q1;
            i4 = i5;
        }
        throw new IllegalStateException();
    }

    public static long e(Q1 q1, AdPodInfo adPodInfo, int i, Q1.d dVar, Q1.b bVar) {
        long j;
        q1.k(i, bVar);
        q1.s(bVar.d, dVar);
        d4.a.a(dVar.i());
        int adPosition = i - (adPodInfo.getAdPosition() - 1);
        int totalAds = i + ((adPodInfo.getTotalAds() - r11) - 1);
        if (dVar.p > adPosition || totalAds >= dVar.q) {
            j = -9223372036854775807L;
            break;
        }
        Q1.b bVar2 = new Q1.b();
        j = 0;
        while (adPosition <= totalAds) {
            long j2 = q1.k(adPosition, bVar2).e;
            if (j2 == -9223372036854775807L) {
                j = -9223372036854775807L;
                break;
            }
            j += j2;
            adPosition++;
        }
        return j != -9223372036854775807L ? j : r(adPodInfo.getMaxDuration());
    }

    public static long[] f(List list) {
        if (list.isEmpty()) {
            return new long[]{0};
        }
        int size = list.size();
        long[] jArr = new long[size];
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            double floatValue = ((Float) list.get(i2)).floatValue();
            if (floatValue == -1.0d) {
                jArr[size - 1] = Long.MIN_VALUE;
            } else {
                jArr[i] = Math.round(floatValue * 1000000.0d);
                i++;
            }
        }
        Arrays.sort(jArr, 0, i);
        return jArr;
    }

    public static AdsRequest g(b bVar, s sVar) {
        AdsRequest f = bVar.f();
        if ("data".equals(sVar.a.getScheme())) {
            b4.l lVar = new b4.l();
            try {
                lVar.a(sVar);
                f.setAdsResponse(k0.E(r.b(lVar)));
            } finally {
                lVar.close();
            }
        } else {
            f.setAdTagUrl(sVar.a.toString());
        }
        return f;
    }

    public static FriendlyObstructionPurpose h(int i) {
        return i != 1 ? i != 2 ? i != 4 ? FriendlyObstructionPurpose.OTHER : FriendlyObstructionPurpose.NOT_VISIBLE : FriendlyObstructionPurpose.CLOSE_AD : FriendlyObstructionPurpose.VIDEO_CONTROLS;
    }

    public static Looper i() {
        return Looper.getMainLooper();
    }

    public static int j(b.b bVar) {
        int i = 0;
        while (true) {
            int[] iArr = bVar.f;
            if (i >= iArr.length) {
                return iArr.length;
            }
            if (iArr[i] == 0) {
                return i;
            }
            i++;
        }
    }

    public static String k(VideoProgressUpdate videoProgressUpdate) {
        return VideoProgressUpdate.VIDEO_TIME_NOT_READY.equals(videoProgressUpdate) ? "not ready" : k0.D("%d ms of %d ms", Long.valueOf(videoProgressUpdate.getCurrentTimeMs()), Long.valueOf(videoProgressUpdate.getDurationMs()));
    }

    public static long l(long j, long j2) {
        return k0.P0(j) + (j2 % 1000);
    }

    public static C3.b m(int i, Q1 q1, C3.b bVar) {
        C3.b bVar2 = bVar;
        Q1.b k = q1.k(i, new Q1.b());
        Q1.d s = q1.s(k.d, new Q1.d());
        long l = l(s.g, s.r) + k.f;
        int g = bVar2.g(l, -9223372036854775807L);
        int i2 = -1;
        if (g != -1) {
            b.b e = bVar2.e(g);
            if (e.a + e.h > l) {
                long j = 0;
                int i3 = 0;
                while (true) {
                    int[] iArr = e.f;
                    if (i3 >= iArr.length) {
                        break;
                    }
                    int i4 = iArr[i3];
                    if (i4 == 1) {
                        i2 = i3;
                    }
                    long j2 = e.a;
                    if (l <= j2 + j) {
                        if (l == j2 + j) {
                            if (i4 == 1 || i4 == 3) {
                                return bVar2;
                            }
                            if (i4 == 0 && i2 == i3 - 1) {
                                long j3 = k.e;
                                if (j3 == -9223372036854775807L) {
                                    return bVar2;
                                }
                                C3.b w = w(g, i3, j3, bVar2);
                                return w.u(g, k0.n1(w.e(g).g));
                            }
                        }
                        C3.b o = o(g, false, bVar2);
                        long j4 = k.e;
                        return j4 != -9223372036854775807L ? a(l, j4, 1, j4, 1, o) : o;
                    }
                    if (i4 == 1 || i4 == 0) {
                        bVar2 = bVar2.B(g, i3);
                    }
                    j += e.g[i3];
                    i3++;
                }
            } else {
                return o(g, true, bVar2);
            }
        }
        return bVar2;
    }

    public static boolean n(AdError adError) {
        return adError.getErrorCode() == AdError.AdErrorCode.VAST_LINEAR_ASSET_MISMATCH || adError.getErrorCode() == AdError.AdErrorCode.UNKNOWN_ERROR;
    }

    public static C3.b o(int i, boolean z, C3.b bVar) {
        b.b e = bVar.e(i);
        int length = e.g.length;
        long[] jArr = new long[length];
        for (int i2 = 0; i2 < length; i2++) {
            jArr[i2] = z ? e.g[i2] : 0L;
            int i3 = e.f[i2];
            if (i3 == 1 || i3 == 0) {
                bVar = bVar.B(i, i2);
            }
        }
        return bVar.m(i, jArr).u(i, k0.n1(jArr));
    }

    public static C3.b p(Q1 q1, C3.b bVar) {
        int i;
        Q1.d s = q1.s(0, new Q1.d());
        if (s.p == s.q || bVar.c < 2) {
            return bVar;
        }
        Q1.b bVar2 = new Q1.b();
        int i2 = s.q;
        if (q1.k(i2, bVar2).e == -9223372036854775807L) {
            i2--;
            q1.k(i2, bVar2);
        }
        long l = l(s.g, s.r);
        int g = bVar.g(bVar2.f + l, -9223372036854775807L);
        if (g == -1) {
            return bVar;
        }
        b.b e = bVar.e(g);
        long j = l - s.r;
        long j2 = e.a;
        if (e.h + j2 <= j) {
            return bVar;
        }
        int i3 = 0;
        while (j2 < j) {
            if (e.f[i3] == 1) {
                return bVar;
            }
            j2 += e.g[i3];
            i3++;
        }
        int i4 = s.p;
        while (true) {
            if (i4 > i2) {
                i4 = -1;
                break;
            }
            if (e.a <= j) {
                break;
            }
            j += q1.k(i4, bVar2).e;
            i4++;
        }
        d4.a.g(i4 != -1);
        for (int i5 = i3; i5 < e.g.length && (i = (i5 - i3) + i4) <= i2; i5++) {
            q1.k(i, bVar2);
            long j3 = bVar2.e;
            if (j3 != e.g[i5]) {
                bVar = w(g, i5, j3, bVar);
            }
        }
        return bVar.u(g, k0.n1(bVar.e(g).g));
    }

    public static long q(double d) {
        return v5.b.c(BigDecimal.valueOf(d).scaleByPowerOfTen(3).doubleValue(), RoundingMode.HALF_UP);
    }

    public static long r(double d) {
        return v5.b.c(BigDecimal.valueOf(d).scaleByPowerOfTen(6).doubleValue(), RoundingMode.HALF_UP);
    }

    public static C3.b s(b.b bVar, int i, int i2, C3.b bVar2) {
        int i3 = 0;
        d4.a.a(i2 > 0 && i2 < bVar.c);
        C3.b bVar3 = bVar2;
        for (int i4 = 0; i4 < bVar.c - i2; i4++) {
            bVar3 = bVar3.w(i);
        }
        b.b e = bVar3.e(i);
        long j = e.a + e.h;
        int[] copyOfRange = Arrays.copyOfRange(bVar.f, i2, bVar.c);
        long[] copyOfRange2 = Arrays.copyOfRange(bVar.g, i2, bVar.c);
        long n1 = k0.n1(copyOfRange2);
        C3.b bVar4 = bVar3;
        while (i3 < copyOfRange.length && copyOfRange[i3] == 1) {
            int i5 = i3 + 1;
            bVar4 = a(j, copyOfRange2[i3], i5, n1, copyOfRange2.length, bVar4);
            n1 -= copyOfRange2[i3];
            i3 = i5;
        }
        return bVar4;
    }

    public static C3.b t(Object obj, b.b bVar, long j, long j2, boolean z) {
        C3.b l = new C3.b(d4.a.e(obj), 0).v(0, true).l(0, 1);
        if (z) {
            l = l.x();
        }
        long j3 = 0;
        for (int i = 0; i < bVar.c; i++) {
            long j4 = j2 != -9223372036854775807L ? j2 : bVar.g[i];
            long j5 = j + j4;
            j3 += bVar.g[i];
            if (j5 <= bVar.a + j3 + 10000) {
                C3.b u = l.m(0, j4).u(0, z ? j4 : 0L);
                int i2 = bVar.f[i];
                return i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? u : u.p(0, 0) : u.A(0, 0) : u.B(0, 0) : u.r(0, 0);
            }
        }
        return l;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0103, code lost:
    
        if (r4.i() == false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0105, code lost:
    
        r17 = r17 + r19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static s5.A u(C3.b r32, O2.Q1 r33) {
        /*
            Method dump skipped, instructions count: 346
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: Z2.m.u(C3.b, O2.Q1):s5.A");
    }

    public static long[] v(long[] jArr, int i, long j, long j2) {
        jArr[i] = j;
        int length = (i + 1) % jArr.length;
        if (jArr[length] == 0) {
            jArr[length] = Math.max(0L, j2 - j);
        }
        return jArr;
    }

    public static C3.b w(int i, int i2, long j, C3.b bVar) {
        b.b e = bVar.e(i);
        d4.a.a(i2 < e.g.length);
        long[] jArr = e.g;
        return bVar.m(i, v(Arrays.copyOf(jArr, jArr.length), i2, j, e.g[i2]));
    }
}
