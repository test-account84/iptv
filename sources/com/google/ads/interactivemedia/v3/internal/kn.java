package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.media.MediaFormat;
import android.os.Handler;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class kn extends rk implements gp {
    private final Context b;
    private final ji c;
    private final jp d;
    private int e;
    private boolean f;
    private s g;
    private long h;
    private boolean i;
    private boolean j;
    private boolean k;
    private hg l;

    public kn(Context context, re reVar, rm rmVar, Handler handler, jj jjVar, jp jpVar) {
        super(1, reVar, rmVar, 44100.0f);
        this.b = context.getApplicationContext();
        this.d = jpVar;
        this.c = new ji(handler, jjVar);
        jpVar.n(new km(this));
    }

    public static /* bridge */ /* synthetic */ hg T(kn knVar) {
        return knVar.l;
    }

    public static /* bridge */ /* synthetic */ ji U(kn knVar) {
        return knVar.c;
    }

    private static List aA(rm rmVar, s sVar, boolean z, jp jpVar) throws rr {
        rh c;
        String str = sVar.l;
        if (str == null) {
            return avo.o();
        }
        if (jpVar.w(sVar) && (c = rw.c()) != null) {
            return avo.p(c);
        }
        Iterable a = rmVar.a(str, z, false);
        String d = rw.d(sVar);
        if (d == null) {
            return avo.m(a);
        }
        Iterable a2 = rmVar.a(d, z, false);
        avk j = avo.j();
        j.h(a);
        j.h(a2);
        return j.f();
    }

    private final void aB() {
        long b = this.d.b(N());
        if (b != Long.MIN_VALUE) {
            if (!this.j) {
                b = Math.max(this.h, b);
            }
            this.h = b;
            this.j = false;
        }
    }

    private final int az(rh rhVar, s sVar) {
        int i;
        if (!"OMX.google.raw.decoder".equals(rhVar.a) || (i = cq.a) >= 24 || (i == 23 && cq.ab(this.b))) {
            return sVar.m;
        }
        return -1;
    }

    public final String L() {
        return "MediaCodecAudioRenderer";
    }

    public final boolean N() {
        return super.N() && this.d.v();
    }

    public final boolean O() {
        return this.d.u() || super.O();
    }

    public final int Q(rm rmVar, s sVar) throws rr {
        boolean z;
        if (!ar.m(sVar.l)) {
            return fz.b(0);
        }
        int i = cq.a >= 21 ? 32 : 0;
        int i2 = sVar.E;
        boolean ax = rk.ax(sVar);
        int i3 = 8;
        if (ax && this.d.w(sVar) && (i2 == 0 || rw.c() != null)) {
            return fz.c(4, 8, i);
        }
        if ((!"audio/raw".equals(sVar.l) || this.d.w(sVar)) && this.d.w(cq.E(2, sVar.y, sVar.z))) {
            List aA = aA(rmVar, sVar, false, this.d);
            if (aA.isEmpty()) {
                return fz.b(1);
            }
            if (!ax) {
                return fz.b(2);
            }
            rh rhVar = (rh) aA.get(0);
            boolean c = rhVar.c(sVar);
            if (c) {
                z = true;
            } else {
                for (int i4 = 1; i4 < aA.size(); i4++) {
                    rh rhVar2 = (rh) aA.get(i4);
                    if (rhVar2.c(sVar)) {
                        rhVar = rhVar2;
                        z = false;
                        c = true;
                        break;
                    }
                }
                z = true;
            }
            int i5 = true != c ? 3 : 4;
            if (c && rhVar.d(sVar)) {
                i3 = 16;
            }
            return fz.d(i5, i3, i, true != rhVar.g ? 0 : 64, true == z ? 128 : 0);
        }
        return fz.b(1);
    }

    public final eq R(rh rhVar, s sVar, s sVar2) {
        int i;
        int i2;
        eq b = rhVar.b(sVar, sVar2);
        int i3 = b.e;
        if (az(rhVar, sVar2) > this.e) {
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
        this.c.g(goVar.b, S);
        return S;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x005e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.ads.interactivemedia.v3.internal.rd V(com.google.ads.interactivemedia.v3.internal.rh r9, com.google.ads.interactivemedia.v3.internal.s r10, android.media.MediaCrypto r11, float r12) {
        /*
            Method dump skipped, instructions count: 257
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.kn.V(com.google.ads.interactivemedia.v3.internal.rh, com.google.ads.interactivemedia.v3.internal.s, android.media.MediaCrypto, float):com.google.ads.interactivemedia.v3.internal.rd");
    }

    public final List W(rm rmVar, s sVar, boolean z) throws rr {
        return rw.f(aA(rmVar, sVar, z, this.d), sVar);
    }

    public final void X(Exception exc) {
        cd.c("MediaCodecAudioRenderer", "Audio codec error", exc);
        this.c.a(exc);
    }

    public final void Y(String str) {
        this.c.d(str);
    }

    public final void Z(s sVar, MediaFormat mediaFormat) throws ev {
        int i;
        s sVar2 = this.g;
        int[] iArr = null;
        if (sVar2 != null) {
            sVar = sVar2;
        } else if (ak() != null) {
            int k = "audio/raw".equals(sVar.l) ? sVar.A : (cq.a < 24 || !mediaFormat.containsKey("pcm-encoding")) ? mediaFormat.containsKey("v-bits-per-sample") ? cq.k(mediaFormat.getInteger("v-bits-per-sample")) : 2 : mediaFormat.getInteger("pcm-encoding");
            r rVar = new r();
            rVar.ae("audio/raw");
            rVar.Y(k);
            rVar.N(sVar.B);
            rVar.O(sVar.C);
            rVar.H(mediaFormat.getInteger("channel-count"));
            rVar.af(mediaFormat.getInteger("sample-rate"));
            s v = rVar.v();
            if (this.f && v.y == 6 && (i = sVar.y) < 6) {
                iArr = new int[i];
                for (int i2 = 0; i2 < sVar.y; i2++) {
                    iArr[i2] = i2;
                }
            }
            sVar = v;
        }
        try {
            this.d.x(sVar, iArr);
        } catch (jk e) {
            throw bi(e, e.a, 5001);
        }
    }

    public final long a() {
        if (bg() == 2) {
            aB();
        }
        return this.h;
    }

    public final void aa() {
        this.j = true;
    }

    public final void ab() {
        this.d.f();
    }

    public final void ac(ef efVar) {
        if (!this.i || efVar.f()) {
            return;
        }
        if (Math.abs(efVar.d - this.h) > 500000) {
            this.h = efVar.d;
        }
        this.i = false;
    }

    public final void ad() throws ev {
        try {
            this.d.i();
        } catch (jo e) {
            throw h(e, e.c, e.b, 5002);
        }
    }

    public final boolean ae(long j, long j2, rf rfVar, ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, s sVar) throws ev {
        af.s(byteBuffer);
        if (this.g != null && (i2 & 2) != 0) {
            af.s(rfVar);
            rfVar.k(i, false);
            return true;
        }
        if (z) {
            if (rfVar != null) {
                rfVar.k(i, false);
            }
            ((rk) this).a.f += i3;
            this.d.f();
            return true;
        }
        try {
            if (!this.d.t(byteBuffer, j3, i3)) {
                return false;
            }
            if (rfVar != null) {
                rfVar.k(i, false);
            }
            ((rk) this).a.e += i3;
            return true;
        } catch (jl e) {
            throw h(e, e.c, e.b, 5001);
        } catch (jo e2) {
            throw h(e2, sVar, e2.b, 5002);
        }
    }

    public final boolean af(s sVar) {
        return this.d.w(sVar);
    }

    public final float ag(float f, s[] sVarArr) {
        int i = -1;
        for (s sVar : sVarArr) {
            int i2 = sVar.z;
            if (i2 != -1) {
                i = Math.max(i, i2);
            }
        }
        if (i == -1) {
            return -1.0f;
        }
        return i * f;
    }

    public final void ah(String str, long j, long j2) {
        this.c.c(str, j, j2);
    }

    public final au c() {
        return this.d.c();
    }

    public final void g(au auVar) {
        this.d.o(auVar);
    }

    public final gp j() {
        return this;
    }

    public final void q(int i, Object obj) throws ev {
        if (i == 2) {
            this.d.s(((Float) obj).floatValue());
            return;
        }
        if (i == 3) {
            this.d.k((f) obj);
            return;
        }
        if (i == 6) {
            this.d.m((g) obj);
            return;
        }
        switch (i) {
            case 9:
                this.d.r(((Boolean) obj).booleanValue());
                break;
            case 10:
                this.d.l(((Integer) obj).intValue());
                break;
            case 11:
                this.l = (hg) obj;
                break;
            case 12:
                if (cq.a >= 23) {
                    kl.a(this.d, obj);
                    break;
                }
                break;
        }
    }

    public final void t() {
        this.k = true;
        try {
            this.d.e();
            try {
                super.t();
            } finally {
            }
        } catch (Throwable th) {
            try {
                super.t();
                throw th;
            } finally {
            }
        }
    }

    public final void u(boolean z, boolean z2) throws ev {
        super.u(z, z2);
        this.c.f(((rk) this).a);
        l();
        this.d.d();
        this.d.p(m());
    }

    public final void v(long j, boolean z) throws ev {
        super.v(j, z);
        this.d.e();
        this.h = j;
        this.i = true;
        this.j = true;
    }

    public final void w() {
        try {
            super.w();
            if (this.k) {
                this.k = false;
                this.d.j();
            }
        } catch (Throwable th) {
            if (this.k) {
                this.k = false;
                this.d.j();
            }
            throw th;
        }
    }

    public final void x() {
        this.d.h();
    }

    public final void y() {
        aB();
        this.d.g();
    }
}
