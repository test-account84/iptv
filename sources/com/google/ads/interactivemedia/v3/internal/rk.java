package com.google.ads.interactivemedia.v3.internal;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.SystemClock;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class rk extends eo {
    private static final byte[] b = {0, 0, 1, 103, 66, -64, 11, -38, 37, -112, 0, 0, 1, 104, -50, 15, 19, 32, 0, 0, 1, 101, -120, -124, 13, -50, 113, 24, -96, 0, 47, -65, 28, 49, -61, 39, 93, 120};
    private MediaFormat A;
    private boolean B;
    private float C;
    private ArrayDeque D;
    private rj E;
    private rh F;
    private int G;
    private boolean H;
    private boolean I;
    private boolean J;
    private boolean K;
    private boolean L;
    private boolean M;
    private boolean N;
    private boolean O;
    private boolean P;
    private boolean Q;
    private ra R;
    private long S;
    private int T;
    private int U;
    private ByteBuffer V;
    private boolean W;
    private boolean X;
    private boolean Y;
    private boolean Z;
    protected ep a;
    private boolean aa;
    private boolean ab;
    private int ac;
    private int ad;
    private int ae;
    private boolean af;
    private boolean ag;
    private boolean ah;
    private long ai;
    private long aj;
    private boolean ak;
    private boolean al;
    private boolean am;
    private boolean an;
    private ev ao;
    private long ap;
    private long aq;
    private int ar;
    private final re c;
    private final rm d;
    private final float e;
    private final ef f;
    private final ef g;
    private final ef h;
    private final qz i;
    private final cn j;
    private final ArrayList k;
    private final MediaCodec.BufferInfo l;
    private final long[] m;
    private final long[] n;
    private final long[] o;
    private s p;
    private s q;
    private nm r;
    private nm s;
    private MediaCrypto t;
    private boolean u;
    private final long v;
    private float w;
    private float x;
    private rf y;
    private s z;

    public rk(int i, re reVar, rm rmVar, float f) {
        super(i);
        this.c = reVar;
        af.s(rmVar);
        this.d = rmVar;
        this.e = f;
        this.f = new ef(0);
        this.g = new ef(0);
        this.h = new ef(2);
        qz qzVar = new qz();
        this.i = qzVar;
        this.j = new cn();
        this.k = new ArrayList();
        this.l = new MediaCodec.BufferInfo();
        this.w = 1.0f;
        this.x = 1.0f;
        this.v = -9223372036854775807L;
        this.m = new long[10];
        this.n = new long[10];
        this.o = new long[10];
        this.ap = -9223372036854775807L;
        aF(-9223372036854775807L);
        qzVar.i(0);
        qzVar.b.order(ByteOrder.nativeOrder());
        this.C = -1.0f;
        this.G = 0;
        this.ac = 0;
        this.T = -1;
        this.U = -1;
        this.S = -9223372036854775807L;
        this.ai = -9223372036854775807L;
        this.aj = -9223372036854775807L;
        this.ad = 0;
        this.ae = 0;
    }

    private final void T() {
        this.aa = false;
        this.i.b();
        this.h.b();
        this.Z = false;
        this.Y = false;
    }

    private final void U() throws ev {
        if (!this.af) {
            aB();
        } else {
            this.ad = 1;
            this.ae = 3;
        }
    }

    @TargetApi(23)
    private final void aA() throws ev {
        int i = this.ae;
        if (i == 1) {
            aa();
            return;
        }
        if (i == 2) {
            aa();
            aH();
        } else if (i == 3) {
            aB();
        } else {
            this.al = true;
            ad();
        }
    }

    private final void aB() throws ev {
        aq();
        ao();
    }

    private final void aC() {
        this.T = -1;
        this.g.b = null;
    }

    private final void aD() {
        this.U = -1;
        this.V = null;
    }

    private final void aE(nm nmVar) {
        pi.c(this.r, nmVar);
        this.r = nmVar;
    }

    private final void aF(long j) {
        this.aq = j;
    }

    private final void aG(nm nmVar) {
        pi.c(this.s, nmVar);
        this.s = nmVar;
    }

    private final void aH() throws ev {
        try {
            E1.a(this.t, aO(this.s).c);
            aE(this.s);
            this.ad = 0;
            this.ae = 0;
        } catch (MediaCryptoException e) {
            throw bi(e, this.p, 6006);
        }
    }

    @TargetApi(23)
    private final boolean aI() throws ev {
        if (this.af) {
            this.ad = 1;
            if (this.I || this.K) {
                this.ae = 3;
                return false;
            }
            this.ae = 2;
        } else {
            aH();
        }
        return true;
    }

    private final boolean aJ() throws ev {
        rf rfVar = this.y;
        if (rfVar == null || this.ad == 2 || this.ak) {
            return false;
        }
        if (this.T < 0) {
            int a = rfVar.a();
            this.T = a;
            if (a < 0) {
                return false;
            }
            this.g.b = this.y.f(a);
            this.g.b();
        }
        if (this.ad == 1) {
            if (!this.Q) {
                this.ag = true;
                this.y.q(this.T, 0, 0L, 4);
                aC();
            }
            this.ad = 2;
            return false;
        }
        if (this.O) {
            this.O = false;
            this.g.b.put(b);
            this.y.q(this.T, 38, 0L, 0);
            aC();
            this.af = true;
            return true;
        }
        if (this.ac == 1) {
            for (int i = 0; i < this.z.n.size(); i++) {
                this.g.b.put((byte[]) this.z.n.get(i));
            }
            this.ac = 2;
        }
        int position = this.g.b.position();
        go i2 = i();
        try {
            int bh = bh(i2, this.g, 0);
            if (G()) {
                this.aj = this.ai;
            }
            if (bh == -3) {
                return false;
            }
            if (bh == -5) {
                if (this.ac == 2) {
                    this.g.b();
                    this.ac = 1;
                }
                S(i2);
                return true;
            }
            ef efVar = this.g;
            if (efVar.g()) {
                if (this.ac == 2) {
                    efVar.b();
                    this.ac = 1;
                }
                this.ak = true;
                if (!this.af) {
                    aA();
                    return false;
                }
                try {
                    if (!this.Q) {
                        this.ag = true;
                        this.y.q(this.T, 0, 0L, 4);
                        aC();
                    }
                    return false;
                } catch (MediaCodec.CryptoException e) {
                    throw bi(e, this.p, cq.i(e.getErrorCode()));
                }
            }
            if (!this.af && !efVar.h()) {
                efVar.b();
                if (this.ac == 2) {
                    this.ac = 1;
                }
                return true;
            }
            boolean k = efVar.k();
            if (k) {
                efVar.a.b(position);
            }
            if (this.H && !k) {
                ByteBuffer byteBuffer = this.g.b;
                byte[] bArr = zw.a;
                int position2 = byteBuffer.position();
                int i3 = 0;
                int i4 = 0;
                while (true) {
                    int i5 = i3 + 1;
                    if (i5 >= position2) {
                        byteBuffer.clear();
                        break;
                    }
                    int i6 = byteBuffer.get(i3) & 255;
                    if (i4 == 3) {
                        if (i6 == 1) {
                            if ((byteBuffer.get(i5) & 31) == 7) {
                                ByteBuffer duplicate = byteBuffer.duplicate();
                                duplicate.position(i3 - 3);
                                duplicate.limit(position2);
                                byteBuffer.position(0);
                                byteBuffer.put(duplicate);
                                break;
                            }
                            i6 = 1;
                        }
                    } else if (i6 == 0) {
                        i4++;
                    }
                    if (i6 != 0) {
                        i4 = 0;
                    }
                    i3 = i5;
                }
                if (this.g.b.position() == 0) {
                    return true;
                }
                this.H = false;
            }
            ef efVar2 = this.g;
            long j = efVar2.d;
            ra raVar = this.R;
            if (raVar != null) {
                j = raVar.b(this.p, efVar2);
                this.ai = Math.max(this.ai, this.R.a(this.p));
            }
            long j2 = j;
            if (this.g.f()) {
                this.k.add(Long.valueOf(j2));
            }
            if (this.am) {
                this.j.d(j2, this.p);
                this.am = false;
            }
            this.ai = Math.max(this.ai, j2);
            this.g.j();
            ef efVar3 = this.g;
            if (efVar3.e()) {
                an(efVar3);
            }
            ac(this.g);
            try {
                if (k) {
                    this.y.r(this.T, this.g.a, j2);
                } else {
                    this.y.q(this.T, this.g.b.limit(), j2, 0);
                }
                aC();
                this.af = true;
                this.ac = 0;
                this.a.c++;
                return true;
            } catch (MediaCodec.CryptoException e2) {
                throw bi(e2, this.p, cq.i(e2.getErrorCode()));
            }
        } catch (ee e3) {
            X(e3);
            aL(0);
            aa();
            return true;
        }
    }

    private final boolean aK() {
        return this.U >= 0;
    }

    private final boolean aL(int i) throws ev {
        go i2 = i();
        this.f.b();
        int bh = bh(i2, this.f, i | 4);
        if (bh == -5) {
            S(i2);
            return true;
        }
        if (bh != -4 || !this.f.g()) {
            return false;
        }
        this.ak = true;
        aA();
        return false;
    }

    private final boolean aM(long j) {
        return true;
    }

    private final boolean aN(s sVar) throws ev {
        if (cq.a >= 23 && this.y != null && this.ae != 3 && bg() != 0) {
            float ag = ag(this.x, J());
            float f = this.C;
            if (f == ag) {
                return true;
            }
            if (ag == -1.0f) {
                U();
                return false;
            }
            if (f == -1.0f && ag <= this.e) {
                return true;
            }
            Bundle bundle = new Bundle();
            bundle.putFloat("operating-rate", ag);
            this.y.m(bundle);
            this.C = ag;
        }
        return true;
    }

    private static final oc aO(nm nmVar) throws ev {
        return (oc) nmVar.b();
    }

    private final void aa() {
        try {
            this.y.h();
        } finally {
            ar();
        }
    }

    public static boolean ax(s sVar) {
        int i = sVar.E;
        return i == 0 || i == 2;
    }

    /* JADX WARN: Removed duplicated region for block: B:125:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x02d3 A[Catch: all -> 0x0078, TRY_ENTER, TryCatch #0 {all -> 0x0078, blocks: (B:11:0x003c, B:14:0x0053, B:15:0x00b8, B:157:0x007b, B:160:0x0096, B:165:0x02d3, B:166:0x02d6), top: B:10:0x003c }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void az(com.google.ads.interactivemedia.v3.internal.rh r17, android.media.MediaCrypto r18) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 731
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.rk.az(com.google.ads.interactivemedia.v3.internal.rh, android.media.MediaCrypto):void");
    }

    public void D(float f, float f2) throws ev {
        this.w = f;
        this.x = f2;
        aN(this.z);
    }

    public final void K(long j, long j2) throws ev {
        if (this.aq == -9223372036854775807L) {
            af.w(this.ap == -9223372036854775807L);
            this.ap = j;
            aF(j2);
            return;
        }
        int i = this.ar;
        if (i == 10) {
            cd.e("MediaCodecRenderer", "Too many stream changes, so dropping offset: " + this.n[9]);
        } else {
            this.ar = i + 1;
        }
        long[] jArr = this.m;
        int i2 = this.ar - 1;
        jArr[i2] = j;
        this.n[i2] = j2;
        this.o[i2] = this.ai;
    }

    /*  JADX ERROR: Types fix failed
        LL1ili1iI1iI.iliLiI1iLLIL: Type inference error: updates count limit reached
        	at ILlL1lil1i1i.iiIiLiL1LIiIII1.LL1ll1L1IL1LlII(Unknown Source:51)
        	at ILlL1lil1i1i.iiIiLiL1LIiIII1.L1IlILiL1l11Ll(Unknown Source:8)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(Unknown Source:0)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(Unknown Source:53)
        */
    public final void M(long r24, long r26) throws com.google.ads.interactivemedia.v3.internal.ev {
        /*
            Method dump skipped, instructions count: 933
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.rk.M(long, long):void");
    }

    public boolean N() {
        return this.al;
    }

    public boolean O() {
        if (this.p == null) {
            return false;
        }
        if (I() || aK()) {
            return true;
        }
        return this.S != -9223372036854775807L && SystemClock.elapsedRealtime() < this.S;
    }

    public final int P(s sVar) throws ev {
        try {
            return Q(this.d, sVar);
        } catch (rr e) {
            throw bi(e, sVar, 4002);
        }
    }

    public abstract int Q(rm rmVar, s sVar) throws rr;

    public eq R(rh rhVar, s sVar, s sVar2) {
        throw null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0069, code lost:
    
        if (r2 != false) goto L101;
     */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.google.ads.interactivemedia.v3.internal.eq S(com.google.ads.interactivemedia.v3.internal.go r12) throws com.google.ads.interactivemedia.v3.internal.ev {
        /*
            Method dump skipped, instructions count: 307
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.rk.S(com.google.ads.interactivemedia.v3.internal.go):com.google.ads.interactivemedia.v3.internal.eq");
    }

    public abstract rd V(rh rhVar, s sVar, MediaCrypto mediaCrypto, float f);

    public abstract List W(rm rmVar, s sVar, boolean z) throws rr;

    public void X(Exception exc) {
        throw null;
    }

    public void Y(String str) {
        throw null;
    }

    public void Z(s sVar, MediaFormat mediaFormat) throws ev {
        throw null;
    }

    public void ab() {
    }

    public void ac(ef efVar) throws ev {
        throw null;
    }

    public void ad() throws ev {
    }

    public abstract boolean ae(long j, long j2, rf rfVar, ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, s sVar) throws ev;

    public boolean af(s sVar) {
        return false;
    }

    public float ag(float f, s[] sVarArr) {
        throw null;
    }

    public void ah(String str, long j, long j2) {
        throw null;
    }

    public final float ai() {
        return this.w;
    }

    public final long aj() {
        return this.aq;
    }

    public final rf ak() {
        return this.y;
    }

    public rg al(Throwable th, rh rhVar) {
        return new rg(th, rhVar);
    }

    public final rh am() {
        return this.F;
    }

    public void an(ef efVar) throws ev {
    }

    public final void ao() throws ev {
        s sVar;
        if (this.y != null || this.Y || (sVar = this.p) == null) {
            return;
        }
        if (this.s == null && af(sVar)) {
            s sVar2 = this.p;
            T();
            String str = sVar2.l;
            if ("audio/mp4a-latm".equals(str) || "audio/mpeg".equals(str) || "audio/opus".equals(str)) {
                this.i.n(32);
            } else {
                this.i.n(1);
            }
            this.Y = true;
            return;
        }
        aE(this.s);
        String str2 = this.p.l;
        nm nmVar = this.r;
        if (nmVar != null) {
            if (this.t == null) {
                oc aO = aO(nmVar);
                if (aO != null) {
                    try {
                        MediaCrypto mediaCrypto = new MediaCrypto(aO.b, aO.c);
                        this.t = mediaCrypto;
                        this.u = !aO.d && mediaCrypto.requiresSecureDecoderComponent(str2);
                    } catch (MediaCryptoException e) {
                        throw bi(e, this.p, 6006);
                    }
                } else if (this.r.c() == null) {
                    return;
                }
            }
            if (oc.a) {
                int a = this.r.a();
                if (a == 1) {
                    Throwable c = this.r.c();
                    af.s(c);
                    throw bi(c, this.p, c.a);
                }
                if (a != 4) {
                    return;
                }
            }
        }
        try {
            MediaCrypto mediaCrypto2 = this.t;
            boolean z = this.u;
            if (this.D == null) {
                try {
                    List W = W(this.d, this.p, z);
                    if (W.isEmpty() && z) {
                        W = W(this.d, this.p, false);
                        if (!W.isEmpty()) {
                            cd.e("MediaCodecRenderer", "Drm session requires secure decoder for " + this.p.l + ", but no secure decoder available. Trying to proceed with " + W.toString() + ".");
                        }
                    }
                    this.D = new ArrayDeque();
                    if (!W.isEmpty()) {
                        this.D.add((rh) W.get(0));
                    }
                    this.E = null;
                } catch (rr e2) {
                    throw new rj(this.p, (Throwable) e2, z, -49998);
                }
            }
            if (this.D.isEmpty()) {
                throw new rj(this.p, (Throwable) null, z, -49999);
            }
            rh rhVar = (rh) this.D.peekFirst();
            while (this.y == null) {
                rh rhVar2 = (rh) this.D.peekFirst();
                if (!aw(rhVar2)) {
                    return;
                }
                try {
                    az(rhVar2, mediaCrypto2);
                } catch (Exception e3) {
                    if (rhVar2 != rhVar) {
                        throw e3;
                    }
                    try {
                        cd.e("MediaCodecRenderer", "Preferred decoder instantiation failed. Sleeping for 50ms then retrying.");
                        Thread.sleep(50L);
                        az(rhVar2, mediaCrypto2);
                    } catch (Exception e4) {
                        cd.f("MediaCodecRenderer", "Failed to initialize decoder: ".concat(String.valueOf(rhVar2)), e4);
                        this.D.removeFirst();
                        rj rjVar = new rj(this.p, (Throwable) e4, z, rhVar2);
                        X(rjVar);
                        rj rjVar2 = this.E;
                        if (rjVar2 == null) {
                            this.E = rjVar;
                        } else {
                            this.E = rj.a(rjVar2, rjVar);
                        }
                        if (this.D.isEmpty()) {
                            throw this.E;
                        }
                    }
                }
            }
            this.D = null;
        } catch (rj e5) {
            throw bi(e5, this.p, 4001);
        }
    }

    public void ap(long j) {
        while (this.ar != 0 && j >= this.o[0]) {
            this.ap = this.m[0];
            aF(this.n[0]);
            int i = this.ar - 1;
            this.ar = i;
            long[] jArr = this.m;
            System.arraycopy(jArr, 1, jArr, 0, i);
            long[] jArr2 = this.n;
            System.arraycopy(jArr2, 1, jArr2, 0, this.ar);
            long[] jArr3 = this.o;
            System.arraycopy(jArr3, 1, jArr3, 0, this.ar);
            ab();
        }
    }

    public final void aq() {
        try {
            rf rfVar = this.y;
            if (rfVar != null) {
                rfVar.i();
                this.a.b++;
                Y(this.F.a);
            }
            this.y = null;
            try {
                MediaCrypto mediaCrypto = this.t;
                if (mediaCrypto != null) {
                    mediaCrypto.release();
                }
            } finally {
            }
        } catch (Throwable th) {
            this.y = null;
            try {
                MediaCrypto mediaCrypto2 = this.t;
                if (mediaCrypto2 != null) {
                    mediaCrypto2.release();
                }
                throw th;
            } finally {
            }
        }
    }

    public void ar() {
        aC();
        aD();
        this.S = -9223372036854775807L;
        this.ag = false;
        this.af = false;
        this.O = false;
        this.P = false;
        this.W = false;
        this.X = false;
        this.k.clear();
        this.ai = -9223372036854775807L;
        this.aj = -9223372036854775807L;
        ra raVar = this.R;
        if (raVar != null) {
            raVar.c();
        }
        this.ad = 0;
        this.ae = 0;
        this.ac = this.ab ? 1 : 0;
    }

    public final void as() {
        ar();
        this.ao = null;
        this.R = null;
        this.D = null;
        this.F = null;
        this.z = null;
        this.A = null;
        this.B = false;
        this.ah = false;
        this.C = -1.0f;
        this.G = 0;
        this.H = false;
        this.I = false;
        this.J = false;
        this.K = false;
        this.L = false;
        this.M = false;
        this.N = false;
        this.Q = false;
        this.ab = false;
        this.ac = 0;
        this.u = false;
    }

    public final void at(long j) throws ev {
        s sVar = (s) this.j.c(j);
        if (sVar == null && this.B) {
            sVar = (s) this.j.b();
        }
        if (sVar != null) {
            this.q = sVar;
        } else if (!this.B || this.q == null) {
            return;
        }
        Z(this.q, this.A);
        this.B = false;
    }

    public final boolean au() {
        if (this.y == null) {
            return false;
        }
        int i = this.ae;
        if (i == 3 || this.I || ((this.J && !this.ah) || (this.K && this.ag))) {
            aq();
            return true;
        }
        if (i == 2) {
            int i2 = cq.a;
            af.w(i2 >= 23);
            if (i2 >= 23) {
                try {
                    aH();
                } catch (ev e) {
                    cd.f("MediaCodecRenderer", "Failed to update the DRM session, releasing the codec instead.", e);
                    aq();
                    return true;
                }
            }
        }
        aa();
        return false;
    }

    public boolean av() {
        return false;
    }

    public boolean aw(rh rhVar) {
        return true;
    }

    public final void ay() throws ev {
        if (au()) {
            ao();
        }
    }

    public final int e() {
        return 8;
    }

    public void t() {
        this.p = null;
        this.ap = -9223372036854775807L;
        aF(-9223372036854775807L);
        this.ar = 0;
        au();
    }

    public void u(boolean z, boolean z2) throws ev {
        this.a = new ep();
    }

    public void v(long j, boolean z) throws ev {
        this.ak = false;
        this.al = false;
        this.an = false;
        if (this.Y) {
            this.i.b();
            this.h.b();
            this.Z = false;
        } else {
            ay();
        }
        cn cnVar = this.j;
        if (cnVar.a() > 0) {
            this.am = true;
        }
        cnVar.e();
        int i = this.ar;
        if (i != 0) {
            aF(this.n[i - 1]);
            this.ap = this.m[this.ar - 1];
            this.ar = 0;
        }
    }

    public void w() {
        try {
            T();
            aq();
        } finally {
            aG(null);
        }
    }
}
