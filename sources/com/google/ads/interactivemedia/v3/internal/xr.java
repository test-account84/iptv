package com.google.ads.interactivemedia.v3.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.media.MediaCodecInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Pair;
import android.view.Display;
import android.view.Surface;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class xr extends rk {
    private static final int[] c = {1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};
    private static boolean d;
    private static boolean e;
    private long A;
    private int B;
    private int C;
    private int D;
    private int E;
    private float F;
    private bl G;
    private int H;
    private xu I;
    private yp J;
    xq b;
    private final Context f;
    private final yb g;
    private final yh h;
    private final boolean i;
    private boolean j;
    private boolean k;
    private Surface l;
    private xt m;
    private boolean n;
    private int o;
    private boolean p;
    private boolean q;
    private boolean r;
    private long s;
    private long t;
    private long u;
    private int v;
    private int w;
    private int x;
    private long y;
    private long z;

    public xr(Context context, re reVar, rm rmVar, Handler handler, yi yiVar) {
        super(2, reVar, rmVar, 30.0f);
        Context applicationContext = context.getApplicationContext();
        this.f = applicationContext;
        this.g = new yb(applicationContext);
        this.h = new yh(handler, yiVar);
        this.i = "NVIDIA".equals(cq.c);
        this.t = -9223372036854775807L;
        this.C = -1;
        this.D = -1;
        this.F = -1.0f;
        this.o = 1;
        this.H = 0;
        aI();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:58:0x007e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int T(com.google.ads.interactivemedia.v3.internal.rh r9, com.google.ads.interactivemedia.v3.internal.s r10) {
        /*
            Method dump skipped, instructions count: 268
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.xr.T(com.google.ads.interactivemedia.v3.internal.rh, com.google.ads.interactivemedia.v3.internal.s):int");
    }

    public static int U(rh rhVar, s sVar) {
        if (sVar.m == -1) {
            return T(rhVar, sVar);
        }
        int size = sVar.n.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += ((byte[]) sVar.n.get(i2)).length;
        }
        return sVar.m + i;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0080 A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:483:0x078c  */
    /* JADX WARN: Removed duplicated region for block: B:508:0x00fc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final boolean aB(java.lang.String r17) {
        /*
            Method dump skipped, instructions count: 2926
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.xr.aB(java.lang.String):boolean");
    }

    private static int aF(int i, int i2) {
        return (i * 3) / (i2 + i2);
    }

    private static List aG(Context context, rm rmVar, s sVar, boolean z, boolean z2) throws rr {
        String str = sVar.l;
        if (str == null) {
            return avo.o();
        }
        Iterable a = rmVar.a(str, z, z2);
        String d2 = rw.d(sVar);
        if (d2 == null) {
            return avo.m(a);
        }
        Iterable a2 = rmVar.a(d2, z, z2);
        if (cq.a >= 26 && "video/dolby-vision".equals(sVar.l) && !a2.isEmpty()) {
            DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
            Display display = displayManager != null ? displayManager.getDisplay(0) : null;
            if (display != null && Q1.a(display)) {
                for (int i : S1.a(R1.a(display))) {
                    if (i != 1) {
                    }
                }
            }
            return avo.m(a2);
        }
        avk j = avo.j();
        j.h(a);
        j.h(a2);
        return j.f();
    }

    private final void aH() {
        this.p = false;
        int i = cq.a;
    }

    private final void aI() {
        this.G = null;
    }

    private final void aJ() {
        if (this.v > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.h.d(this.v, elapsedRealtime - this.u);
            this.v = 0;
            this.u = elapsedRealtime;
        }
    }

    private final void aK() {
        int i = this.C;
        if (i == -1 && this.D == -1) {
            return;
        }
        bl blVar = this.G;
        if (blVar != null && blVar.b == i && blVar.c == this.D && blVar.d == this.E && blVar.e == this.F) {
            return;
        }
        bl blVar2 = new bl(i, this.D, this.E, this.F);
        this.G = blVar2;
        this.h.t(blVar2);
    }

    private final void aL() {
        bl blVar = this.G;
        if (blVar != null) {
            this.h.t(blVar);
        }
    }

    private final void aM() {
        Surface surface = this.l;
        xt xtVar = this.m;
        if (surface == xtVar) {
            this.l = null;
        }
        xtVar.release();
        this.m = null;
    }

    private final void aN() {
        this.t = SystemClock.elapsedRealtime() + 5000;
    }

    private static boolean aO(long j) {
        return j < -30000;
    }

    private final boolean aP(rh rhVar) {
        if (cq.a < 23 || aB(rhVar.a)) {
            return false;
        }
        return !rhVar.f || xt.b(this.f);
    }

    public final void D(float f, float f2) throws ev {
        super.D(f, f2);
        this.g.e(f);
    }

    public final String L() {
        return "MediaCodecVideoRenderer";
    }

    public final boolean O() {
        xt xtVar;
        if (super.O() && (this.p || (((xtVar = this.m) != null && this.l == xtVar) || ak() == null))) {
            this.t = -9223372036854775807L;
            return true;
        }
        if (this.t == -9223372036854775807L) {
            return false;
        }
        if (SystemClock.elapsedRealtime() < this.t) {
            return true;
        }
        this.t = -9223372036854775807L;
        return false;
    }

    public final int Q(rm rmVar, s sVar) throws rr {
        boolean z;
        int i = 0;
        if (!ar.q(sVar.l)) {
            return fz.b(0);
        }
        boolean z2 = sVar.o != null;
        List aG = aG(this.f, rmVar, sVar, z2, false);
        if (z2 && aG.isEmpty()) {
            aG = aG(this.f, rmVar, sVar, false, false);
        }
        if (aG.isEmpty()) {
            return fz.b(1);
        }
        if (!rk.ax(sVar)) {
            return fz.b(2);
        }
        rh rhVar = (rh) aG.get(0);
        boolean c2 = rhVar.c(sVar);
        if (c2) {
            z = true;
        } else {
            for (int i2 = 1; i2 < aG.size(); i2++) {
                rh rhVar2 = (rh) aG.get(i2);
                if (rhVar2.c(sVar)) {
                    rhVar = rhVar2;
                    z = false;
                    c2 = true;
                    break;
                }
            }
            z = true;
        }
        int i3 = true != c2 ? 3 : 4;
        int i4 = true != rhVar.d(sVar) ? 8 : 16;
        int i5 = true != rhVar.g ? 0 : 64;
        int i6 = true != z ? 0 : 128;
        if (c2) {
            List aG2 = aG(this.f, rmVar, sVar, z2, true);
            if (!aG2.isEmpty()) {
                rh rhVar3 = (rh) rw.f(aG2, sVar).get(0);
                if (rhVar3.c(sVar) && rhVar3.d(sVar)) {
                    i = 32;
                }
            }
        }
        return fz.d(i3, i4, i, i5, i6);
    }

    public final eq R(rh rhVar, s sVar, s sVar2) {
        int i;
        int i2;
        eq b = rhVar.b(sVar, sVar2);
        int i3 = b.e;
        int i4 = sVar2.q;
        yp ypVar = this.J;
        if (i4 > ypVar.a || sVar2.r > ypVar.b) {
            i3 |= 256;
        }
        if (U(rhVar, sVar2) > this.J.c) {
            i3 |= 64;
        }
        String str = rhVar.a;
        if (i3 != 0) {
            i2 = i3;
            i = 0;
        } else {
            i = b.d;
            i2 = 0;
        }
        return new eq(str, sVar, sVar2, i, i2);
    }

    public final eq S(go goVar) throws ev {
        eq S = super.S(goVar);
        this.h.f(goVar.b, S);
        return S;
    }

    @TargetApi(17)
    public final rd V(rh rhVar, s sVar, MediaCrypto mediaCrypto, float f) {
        yp ypVar;
        Point point;
        Pair b;
        int T;
        s sVar2 = sVar;
        xt xtVar = this.m;
        if (xtVar != null && xtVar.a != rhVar.f) {
            aM();
        }
        String str = rhVar.c;
        s[] J = J();
        int i = sVar2.q;
        int i2 = sVar2.r;
        int U = U(rhVar, sVar);
        int length = J.length;
        if (length == 1) {
            if (U != -1 && (T = T(rhVar, sVar)) != -1) {
                U = Math.min((int) (U * 1.5f), T);
            }
            ypVar = new yp(i, i2, U, null);
        } else {
            boolean z = false;
            for (int i3 = 0; i3 < length; i3++) {
                s sVar3 = J[i3];
                if (sVar2.x != null && sVar3.x == null) {
                    r b2 = sVar3.b();
                    b2.J(sVar2.x);
                    sVar3 = b2.v();
                }
                if (rhVar.b(sVar2, sVar3).d != 0) {
                    int i4 = sVar3.q;
                    z |= i4 == -1 || sVar3.r == -1;
                    i = Math.max(i, i4);
                    i2 = Math.max(i2, sVar3.r);
                    U = Math.max(U, U(rhVar, sVar3));
                }
            }
            if (z) {
                cd.e("MediaCodecVideoRenderer", "Resolutions unknown. Codec max resolution: " + i + "x" + i2);
                int i5 = sVar2.r;
                int i6 = sVar2.q;
                boolean z2 = i5 > i6;
                int i7 = z2 ? i5 : i6;
                if (true == z2) {
                    i5 = i6;
                }
                float f2 = i5 / i7;
                int[] iArr = c;
                int i8 = 0;
                while (i8 < 9) {
                    int i9 = iArr[i8];
                    int[] iArr2 = iArr;
                    int i10 = (int) (i9 * f2);
                    if (i9 <= i7 || i10 <= i5) {
                        break;
                    }
                    int i11 = i5;
                    float f3 = f2;
                    if (cq.a >= 21) {
                        int i12 = true != z2 ? i9 : i10;
                        if (true != z2) {
                            i9 = i10;
                        }
                        Point a = rhVar.a(i12, i9);
                        if (rhVar.e(a.x, a.y, sVar2.s)) {
                            point = a;
                            break;
                        }
                        i8++;
                        sVar2 = sVar;
                        iArr = iArr2;
                        i5 = i11;
                        f2 = f3;
                    } else {
                        try {
                            int c2 = cq.c(i9, 16) * 16;
                            int c3 = cq.c(i10, 16) * 16;
                            if (c2 * c3 <= rw.a()) {
                                int i13 = true != z2 ? c2 : c3;
                                if (true != z2) {
                                    c2 = c3;
                                }
                                point = new Point(i13, c2);
                            } else {
                                i8++;
                                sVar2 = sVar;
                                iArr = iArr2;
                                i5 = i11;
                                f2 = f3;
                            }
                        } catch (rr unused) {
                        }
                    }
                }
                point = null;
                if (point != null) {
                    i = Math.max(i, point.x);
                    i2 = Math.max(i2, point.y);
                    r b3 = sVar.b();
                    b3.aj(i);
                    b3.Q(i2);
                    U = Math.max(U, T(rhVar, b3.v()));
                    cd.e("MediaCodecVideoRenderer", "Codec max resolution adjusted to: " + i + "x" + i2);
                }
            }
            ypVar = new yp(i, i2, U, null);
        }
        this.J = ypVar;
        boolean z3 = this.i;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger("width", sVar.q);
        mediaFormat.setInteger("height", sVar.r);
        af.r(mediaFormat, sVar.n);
        float f4 = sVar.s;
        if (f4 != -1.0f) {
            mediaFormat.setFloat("frame-rate", f4);
        }
        af.q(mediaFormat, "rotation-degrees", sVar.t);
        j jVar = sVar.x;
        if (jVar != null) {
            af.q(mediaFormat, "color-transfer", jVar.c);
            af.q(mediaFormat, "color-standard", jVar.a);
            af.q(mediaFormat, "color-range", jVar.b);
            byte[] bArr = jVar.d;
            if (bArr != null) {
                mediaFormat.setByteBuffer("hdr-static-info", ByteBuffer.wrap(bArr));
            }
        }
        if ("video/dolby-vision".equals(sVar.l) && (b = rw.b(sVar)) != null) {
            af.q(mediaFormat, "profile", ((Integer) b.first).intValue());
        }
        mediaFormat.setInteger("max-width", ypVar.a);
        mediaFormat.setInteger("max-height", ypVar.b);
        af.q(mediaFormat, "max-input-size", ypVar.c);
        if (cq.a >= 23) {
            mediaFormat.setInteger("priority", 0);
            if (f != -1.0f) {
                mediaFormat.setFloat("operating-rate", f);
            }
        }
        if (z3) {
            mediaFormat.setInteger("no-post-process", 1);
            mediaFormat.setInteger("auto-frc", 0);
        }
        if (this.l == null) {
            if (!aP(rhVar)) {
                throw new IllegalStateException();
            }
            if (this.m == null) {
                this.m = xt.a(this.f, rhVar.f);
            }
            this.l = this.m;
        }
        return rd.b(rhVar, mediaFormat, sVar, this.l, mediaCrypto);
    }

    public final List W(rm rmVar, s sVar, boolean z) throws rr {
        return rw.f(aG(this.f, rmVar, sVar, z, false), sVar);
    }

    public final void X(Exception exc) {
        cd.c("MediaCodecVideoRenderer", "Video codec error", exc);
        this.h.s(exc);
    }

    public final void Y(String str) {
        this.h.b(str);
    }

    public final void Z(s sVar, MediaFormat mediaFormat) {
        rf ak = ak();
        if (ak != null) {
            ak.n(this.o);
        }
        af.s(mediaFormat);
        boolean z = false;
        if (mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top")) {
            z = true;
        }
        this.C = z ? (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1 : mediaFormat.getInteger("width");
        int integer = z ? (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1 : mediaFormat.getInteger("height");
        this.D = integer;
        float f = sVar.u;
        this.F = f;
        if (cq.a >= 21) {
            int i = sVar.t;
            if (i == 90 || i == 270) {
                int i2 = this.C;
                this.C = integer;
                this.D = i2;
                this.F = 1.0f / f;
            }
        } else {
            this.E = sVar.t;
        }
        this.g.c(sVar.s);
    }

    public final void aA(long j) {
        ep epVar = ((rk) this).a;
        epVar.k += j;
        epVar.l++;
        this.A += j;
        this.B++;
    }

    public final void aC(rf rfVar, int i) {
        aK();
        af.o("releaseOutputBuffer");
        rfVar.k(i, true);
        af.p();
        this.z = SystemClock.elapsedRealtime() * 1000;
        ((rk) this).a.e++;
        this.w = 0;
        aa();
    }

    public final void aD(rf rfVar, int i, long j) {
        aK();
        af.o("releaseOutputBuffer");
        rfVar.j(i, j);
        af.p();
        this.z = SystemClock.elapsedRealtime() * 1000;
        ((rk) this).a.e++;
        this.w = 0;
        aa();
    }

    public final void aE(rf rfVar, int i) {
        af.o("skipVideoBuffer");
        rfVar.k(i, false);
        af.p();
        ((rk) this).a.f++;
    }

    public final void aa() {
        this.r = true;
        if (this.p) {
            return;
        }
        this.p = true;
        this.h.q(this.l);
        this.n = true;
    }

    public final void ab() {
        aH();
    }

    public final void ac(ef efVar) throws ev {
        this.x++;
        int i = cq.a;
    }

    public final boolean ae(long j, long j2, rf rfVar, ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, s sVar) throws ev {
        boolean z3;
        boolean z4;
        int d2;
        af.s(rfVar);
        if (this.s == -9223372036854775807L) {
            this.s = j;
        }
        if (j3 != this.y) {
            this.g.d(j3);
            this.y = j3;
        }
        long aj = aj();
        if (z && !z2) {
            aE(rfVar, i);
            return true;
        }
        double ai = ai();
        boolean z5 = bg() == 2;
        long elapsedRealtime = SystemClock.elapsedRealtime() * 1000;
        long j4 = (long) ((j3 - j) / ai);
        if (z5) {
            j4 -= elapsedRealtime - j2;
        }
        if (this.l == this.m) {
            if (!aO(j4)) {
                return false;
            }
            aE(rfVar, i);
            aA(j4);
            return true;
        }
        long j5 = elapsedRealtime - this.z;
        if (this.r ? this.p : !(z5 || this.q)) {
            z3 = z5;
            z4 = false;
        } else {
            z3 = z5;
            z4 = true;
        }
        if (this.t == -9223372036854775807L && j >= aj && (z4 || (z3 && aO(j4) && j5 > 100000))) {
            long nanoTime = System.nanoTime();
            if (cq.a >= 21) {
                aD(rfVar, i, nanoTime);
            } else {
                aC(rfVar, i);
            }
            aA(j4);
            return true;
        }
        if (!z3 || j == this.s) {
            return false;
        }
        long nanoTime2 = System.nanoTime();
        long a = this.g.a((j4 * 1000) + nanoTime2);
        long j6 = (a - nanoTime2) / 1000;
        long j7 = this.t;
        if (j6 < -500000 && !z2 && (d2 = d(j)) != 0) {
            if (j7 != -9223372036854775807L) {
                ep epVar = ((rk) this).a;
                epVar.d += d2;
                epVar.f += this.x;
            } else {
                ((rk) this).a.j++;
                az(d2, this.x);
            }
            ay();
            return false;
        }
        if (aO(j6) && !z2) {
            if (j7 != -9223372036854775807L) {
                aE(rfVar, i);
            } else {
                af.o("dropVideoBuffer");
                rfVar.k(i, false);
                af.p();
                az(0, 1);
            }
            aA(j6);
            return true;
        }
        if (cq.a >= 21) {
            if (j6 < 50000) {
                aD(rfVar, i, a);
                aA(j6);
                return true;
            }
        } else if (j6 < 30000) {
            if (j6 > 11000) {
                try {
                    Thread.sleep(((-10000) + j6) / 1000);
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    return false;
                }
            }
            aC(rfVar, i);
            aA(j6);
            return true;
        }
        return false;
    }

    public final float ag(float f, s[] sVarArr) {
        float f2 = -1.0f;
        for (s sVar : sVarArr) {
            float f3 = sVar.s;
            if (f3 != -1.0f) {
                f2 = Math.max(f2, f3);
            }
        }
        if (f2 == -1.0f) {
            return -1.0f;
        }
        return f2 * f;
    }

    public final void ah(String str, long j, long j2) {
        this.h.a(str, j, j2);
        this.j = aB(str);
        rh am = am();
        af.s(am);
        boolean z = false;
        if (cq.a >= 29 && "video/x-vnd.on2.vp9".equals(am.b)) {
            MediaCodecInfo.CodecProfileLevel[] f = am.f();
            int length = f.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                if (f[i].profile == 16384) {
                    z = true;
                    break;
                }
                i++;
            }
        }
        this.k = z;
    }

    public final rg al(Throwable th, rh rhVar) {
        return new xp(th, rhVar, this.l);
    }

    @TargetApi(29)
    public final void an(ef efVar) throws ev {
        if (this.k) {
            ByteBuffer byteBuffer = efVar.e;
            af.s(byteBuffer);
            if (byteBuffer.remaining() >= 7) {
                byte b = byteBuffer.get();
                short s = byteBuffer.getShort();
                short s2 = byteBuffer.getShort();
                byte b2 = byteBuffer.get();
                byte b3 = byteBuffer.get();
                byteBuffer.position(0);
                if (b == -75 && s == 60 && s2 == 1 && b2 == 4) {
                    if (b3 == 0 || b3 == 1) {
                        byte[] bArr = new byte[byteBuffer.remaining()];
                        byteBuffer.get(bArr);
                        byteBuffer.position(0);
                        rf ak = ak();
                        Bundle bundle = new Bundle();
                        bundle.putByteArray("hdr10-plus-info", bArr);
                        ak.m(bundle);
                    }
                }
            }
        }
    }

    public final void ap(long j) {
        super.ap(j);
        this.x--;
    }

    public final void ar() {
        super.ar();
        this.x = 0;
    }

    public final boolean av() {
        return false;
    }

    public final boolean aw(rh rhVar) {
        return this.l != null || aP(rhVar);
    }

    public final void az(int i, int i2) {
        ep epVar = ((rk) this).a;
        epVar.h += i;
        int i3 = i + i2;
        epVar.g += i3;
        this.v += i3;
        int i4 = this.w + i3;
        this.w = i4;
        epVar.i = Math.max(i4, epVar.i);
        if (this.v >= 50) {
            aJ();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void q(int i, Object obj) throws ev {
        if (i != 1) {
            if (i == 7) {
                this.I = (xu) obj;
                return;
            }
            if (i == 10) {
                int intValue = ((Integer) obj).intValue();
                if (this.H != intValue) {
                    this.H = intValue;
                    return;
                }
                return;
            }
            if (i != 4) {
                if (i != 5) {
                    return;
                }
                this.g.j(((Integer) obj).intValue());
                return;
            } else {
                int intValue2 = ((Integer) obj).intValue();
                this.o = intValue2;
                rf ak = ak();
                if (ak != null) {
                    ak.n(intValue2);
                    return;
                }
                return;
            }
        }
        xt xtVar = obj instanceof Surface ? (Surface) obj : null;
        if (xtVar == null) {
            xt xtVar2 = this.m;
            if (xtVar2 != null) {
                xtVar = xtVar2;
            } else {
                rh am = am();
                if (am != null && aP(am)) {
                    xtVar = xt.a(this.f, am.f);
                    this.m = xtVar;
                }
            }
        }
        if (this.l == xtVar) {
            if (xtVar == null || xtVar == this.m) {
                return;
            }
            aL();
            if (this.n) {
                this.h.q(this.l);
                return;
            }
            return;
        }
        this.l = xtVar;
        this.g.i(xtVar);
        this.n = false;
        int bg = bg();
        rf ak2 = ak();
        if (ak2 != null) {
            if (cq.a < 23 || xtVar == null || this.j) {
                aq();
                ao();
            } else {
                ak2.l(xtVar);
            }
        }
        if (xtVar == null || xtVar == this.m) {
            aI();
            aH();
            return;
        }
        aL();
        aH();
        if (bg == 2) {
            aN();
        }
    }

    public final void t() {
        aI();
        aH();
        this.n = false;
        this.b = null;
        try {
            super.t();
        } finally {
            this.h.c(((rk) this).a);
        }
    }

    public final void u(boolean z, boolean z2) throws ev {
        super.u(z, z2);
        l();
        af.w(true);
        this.h.e(((rk) this).a);
        this.q = z2;
        this.r = false;
    }

    public final void v(long j, boolean z) throws ev {
        super.v(j, z);
        aH();
        this.g.f();
        this.y = -9223372036854775807L;
        this.s = -9223372036854775807L;
        this.w = 0;
        if (z) {
            aN();
        } else {
            this.t = -9223372036854775807L;
        }
    }

    @TargetApi(17)
    public final void w() {
        try {
            super.w();
            if (this.m != null) {
                aM();
            }
        } catch (Throwable th) {
            if (this.m != null) {
                aM();
            }
            throw th;
        }
    }

    public final void x() {
        this.v = 0;
        this.u = SystemClock.elapsedRealtime();
        this.z = SystemClock.elapsedRealtime() * 1000;
        this.A = 0L;
        this.B = 0;
        this.g.g();
    }

    public final void y() {
        this.t = -9223372036854775807L;
        aJ();
        int i = this.B;
        if (i != 0) {
            this.h.r(this.A, i);
            this.A = 0L;
            this.B = 0;
        }
        this.g.h();
    }
}
