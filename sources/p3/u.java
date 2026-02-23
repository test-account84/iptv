package p3;

import O2.A0;
import O2.z0;
import P2.v0;
import Q2.c0;
import U2.g;
import V2.H;
import V2.o;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaFormat;
import android.media.metrics.LogSessionId;
import android.os.Bundle;
import android.os.SystemClock;
import com.google.ads.interactivemedia.v3.internal.D1;
import com.google.ads.interactivemedia.v3.internal.E1;
import com.google.ads.interactivemedia.v3.internal.X;
import com.google.ads.interactivemedia.v3.internal.d1;
import com.google.android.exoplayer2.decoder.CryptoConfig;
import d4.G;
import d4.Y;
import d4.a0;
import d4.k0;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import p3.B;
import p3.m;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class u extends O2.k {
    public static final byte[] K0 = {0, 0, 1, 103, 66, -64, 11, -38, 37, -112, 0, 0, 1, 104, -50, 15, 19, 32, 0, 0, 1, 101, -120, -124, 13, -50, 113, 24, -96, 0, 47, -65, 28, 49, -61, 39, 93, 120};
    public final ArrayDeque A;
    public long A0;
    public final c0 B;
    public boolean B0;
    public z0 C;
    public boolean C0;
    public z0 D;
    public boolean D0;
    public V2.o E;
    public boolean E0;
    public V2.o F;
    public O2.w F0;
    public MediaCrypto G;
    public U2.e G0;
    public boolean H;
    public c H0;
    public long I;
    public long I0;
    public float J;
    public boolean J0;
    public float K;
    public m L;
    public z0 M;
    public MediaFormat N;
    public boolean O;
    public float P;
    public ArrayDeque Q;
    public b R;
    public t S;
    public int T;
    public boolean U;
    public boolean V;
    public boolean W;
    public boolean X;
    public boolean Y;
    public boolean Z;
    public boolean e0;
    public boolean f0;
    public boolean g0;
    public boolean h0;
    public j i0;
    public long j0;
    public int k0;
    public int l0;
    public ByteBuffer m0;
    public boolean n0;
    public boolean o0;
    public boolean p0;
    public final m.b q;
    public boolean q0;
    public final w r;
    public boolean r0;
    public final boolean s;
    public boolean s0;
    public final float t;
    public int t0;
    public final U2.g u;
    public int u0;
    public final U2.g v;
    public int v0;
    public final U2.g w;
    public boolean w0;
    public final i x;
    public boolean x0;
    public final ArrayList y;
    public boolean y0;
    public final MediaCodec.BufferInfo z;
    public long z0;

    public static final class a {
        public static void a(m.a aVar, v0 v0Var) {
            LogSessionId a = v0Var.a();
            if (d1.a(a, X.a())) {
                return;
            }
            aVar.b.setString("log-session-id", D1.a(a));
        }
    }

    public static class b extends Exception {
        public final String a;
        public final boolean c;
        public final t d;
        public final String e;
        public final b f;

        public b(z0 z0Var, Throwable th, boolean z, int i) {
            this("Decoder init failed: [" + i + "], " + z0Var, th, z0Var.m, z, null, b(i), null);
        }

        public static /* synthetic */ b a(b bVar, b bVar2) {
            return bVar.c(bVar2);
        }

        public static String b(int i) {
            return "com.google.android.exoplayer2.mediacodec.MediaCodecRenderer_" + (i < 0 ? "neg_" : "") + Math.abs(i);
        }

        public static String d(Throwable th) {
            if (th instanceof MediaCodec.CodecException) {
                return ((MediaCodec.CodecException) th).getDiagnosticInfo();
            }
            return null;
        }

        public final b c(b bVar) {
            return new b(getMessage(), getCause(), this.a, this.c, this.d, this.e, bVar);
        }

        public b(z0 z0Var, Throwable th, boolean z, t tVar) {
            this("Decoder init failed: " + tVar.a + ", " + z0Var, th, z0Var.m, z, tVar, k0.a >= 21 ? d(th) : null, null);
        }

        public b(String str, Throwable th, String str2, boolean z, t tVar, String str3, b bVar) {
            super(str, th);
            this.a = str2;
            this.c = z;
            this.d = tVar;
            this.e = str3;
            this.f = bVar;
        }
    }

    public static final class c {
        public static final c e = new c(-9223372036854775807L, -9223372036854775807L, -9223372036854775807L);
        public final long a;
        public final long b;
        public final long c;
        public final Y d = new Y();

        public c(long j, long j2, long j3) {
            this.a = j;
            this.b = j2;
            this.c = j3;
        }
    }

    public u(int i, m.b bVar, w wVar, boolean z, float f) {
        super(i);
        this.q = bVar;
        this.r = (w) d4.a.e(wVar);
        this.s = z;
        this.t = f;
        this.u = U2.g.l();
        this.v = new U2.g(0);
        this.w = new U2.g(2);
        i iVar = new i();
        this.x = iVar;
        this.y = new ArrayList();
        this.z = new MediaCodec.BufferInfo();
        this.J = 1.0f;
        this.K = 1.0f;
        this.I = -9223372036854775807L;
        this.A = new ArrayDeque();
        g1(c.e);
        iVar.e(0);
        iVar.d.order(ByteOrder.nativeOrder());
        this.B = new c0();
        this.P = -1.0f;
        this.T = 0;
        this.t0 = 0;
        this.k0 = -1;
        this.l0 = -1;
        this.j0 = -9223372036854775807L;
        this.z0 = -9223372036854775807L;
        this.A0 = -9223372036854775807L;
        this.I0 = -9223372036854775807L;
        this.u0 = 0;
        this.v0 = 0;
    }

    public static boolean F0(IllegalStateException illegalStateException) {
        if (k0.a >= 21 && G0(illegalStateException)) {
            return true;
        }
        StackTraceElement[] stackTrace = illegalStateException.getStackTrace();
        return stackTrace.length > 0 && stackTrace[0].getClassName().equals("android.media.MediaCodec");
    }

    public static boolean G0(IllegalStateException illegalStateException) {
        return illegalStateException instanceof MediaCodec.CodecException;
    }

    public static boolean H0(IllegalStateException illegalStateException) {
        if (illegalStateException instanceof MediaCodec.CodecException) {
            return ((MediaCodec.CodecException) illegalStateException).isRecoverable();
        }
        return false;
    }

    private void U0() {
        int i = this.v0;
        if (i == 1) {
            m0();
            return;
        }
        if (i == 2) {
            m0();
            r1();
        } else if (i == 3) {
            Y0();
        } else {
            this.C0 = true;
            a1();
        }
    }

    public static boolean W(String str, z0 z0Var) {
        return k0.a < 21 && z0Var.o.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(str);
    }

    public static boolean X(String str) {
        if (k0.a < 21 && "OMX.SEC.mp3.dec".equals(str) && "samsung".equals(k0.c)) {
            String str2 = k0.b;
            if (str2.startsWith("baffin") || str2.startsWith("grand") || str2.startsWith("fortuna") || str2.startsWith("gprimelte") || str2.startsWith("j2y18lte") || str2.startsWith("ms01")) {
                return true;
            }
        }
        return false;
    }

    public static boolean Y(String str) {
        int i = k0.a;
        if (i > 23 || !"OMX.google.vorbis.decoder".equals(str)) {
            if (i <= 19) {
                String str2 = k0.b;
                if (("hb2000".equals(str2) || "stvm8".equals(str2)) && ("OMX.amlogic.avc.decoder.awesome".equals(str) || "OMX.amlogic.avc.decoder.awesome.secure".equals(str))) {
                }
            }
            return false;
        }
        return true;
    }

    public static boolean Z(String str) {
        return k0.a == 21 && "OMX.google.aac.decoder".equals(str);
    }

    public static boolean a0(t tVar) {
        String str = tVar.a;
        int i = k0.a;
        return (i <= 25 && "OMX.rk.video_decoder.avc".equals(str)) || (i <= 17 && "OMX.allwinner.video.decoder.avc".equals(str)) || ((i <= 29 && ("OMX.broadcom.video_decoder.tunnel".equals(str) || "OMX.broadcom.video_decoder.tunnel.secure".equals(str) || "OMX.bcm.vdec.avc.tunnel".equals(str) || "OMX.bcm.vdec.avc.tunnel.secure".equals(str) || "OMX.bcm.vdec.hevc.tunnel".equals(str) || "OMX.bcm.vdec.hevc.tunnel.secure".equals(str))) || ("Amazon".equals(k0.c) && "AFTS".equals(k0.d) && tVar.g));
    }

    public static boolean b0(String str) {
        int i = k0.a;
        return i < 18 || (i == 18 && ("OMX.SEC.avc.dec".equals(str) || "OMX.SEC.avc.dec.secure".equals(str))) || (i == 19 && k0.d.startsWith("SM-G800") && ("OMX.Exynos.avc.dec".equals(str) || "OMX.Exynos.avc.dec.secure".equals(str)));
    }

    public static boolean c0(String str, z0 z0Var) {
        return k0.a <= 18 && z0Var.z == 1 && "OMX.MTK.AUDIO.DECODER.MP3".equals(str);
    }

    public static boolean d0(String str) {
        return k0.a == 29 && "c2.android.aac.decoder".equals(str);
    }

    private void j1(V2.o oVar) {
        V2.n.a(this.F, oVar);
        this.F = oVar;
    }

    private boolean l0() {
        int i;
        if (this.L == null || (i = this.u0) == 2 || this.B0) {
            return false;
        }
        if (i == 0 && m1()) {
            h0();
        }
        if (this.k0 < 0) {
            int k = this.L.k();
            this.k0 = k;
            if (k < 0) {
                return false;
            }
            this.v.d = this.L.e(k);
            this.v.clear();
        }
        if (this.u0 == 1) {
            if (!this.h0) {
                this.x0 = true;
                this.L.g(this.k0, 0, 0, 0L, 4);
                d1();
            }
            this.u0 = 2;
            return false;
        }
        if (this.f0) {
            this.f0 = false;
            ByteBuffer byteBuffer = this.v.d;
            byte[] bArr = K0;
            byteBuffer.put(bArr);
            this.L.g(this.k0, 0, bArr.length, 0L, 0);
            d1();
            this.w0 = true;
            return true;
        }
        if (this.t0 == 1) {
            for (int i2 = 0; i2 < this.M.o.size(); i2++) {
                this.v.d.put((byte[]) this.M.o.get(i2));
            }
            this.t0 = 2;
        }
        int position = this.v.d.position();
        A0 B = B();
        try {
            int P = P(B, this.v, 0);
            if (h() || this.v.isLastSample()) {
                this.A0 = this.z0;
            }
            if (P == -3) {
                return false;
            }
            if (P == -5) {
                if (this.t0 == 2) {
                    this.v.clear();
                    this.t0 = 1;
                }
                N0(B);
                return true;
            }
            if (this.v.isEndOfStream()) {
                if (this.t0 == 2) {
                    this.v.clear();
                    this.t0 = 1;
                }
                this.B0 = true;
                if (!this.w0) {
                    U0();
                    return false;
                }
                try {
                    if (!this.h0) {
                        this.x0 = true;
                        this.L.g(this.k0, 0, 0, 0L, 4);
                        d1();
                    }
                    return false;
                } catch (MediaCodec.CryptoException e) {
                    throw y(e, this.C, k0.Z(e.getErrorCode()));
                }
            }
            if (!this.w0 && !this.v.isKeyFrame()) {
                this.v.clear();
                if (this.t0 == 2) {
                    this.t0 = 1;
                }
                return true;
            }
            boolean j = this.v.j();
            if (j) {
                this.v.c.b(position);
            }
            if (this.U && !j) {
                G.b(this.v.d);
                if (this.v.d.position() == 0) {
                    return true;
                }
                this.U = false;
            }
            U2.g gVar = this.v;
            long j2 = gVar.f;
            j jVar = this.i0;
            if (jVar != null) {
                j2 = jVar.d(this.C, gVar);
                this.z0 = Math.max(this.z0, this.i0.b(this.C));
            }
            long j3 = j2;
            if (this.v.isDecodeOnly()) {
                this.y.add(Long.valueOf(j3));
            }
            if (this.D0) {
                (!this.A.isEmpty() ? (c) this.A.peekLast() : this.H0).d.a(j3, this.C);
                this.D0 = false;
            }
            this.z0 = Math.max(this.z0, j3);
            this.v.i();
            if (this.v.hasSupplementalData()) {
                z0(this.v);
            }
            S0(this.v);
            try {
                if (j) {
                    this.L.c(this.k0, 0, this.v.c, j3, 0);
                } else {
                    this.L.g(this.k0, 0, this.v.d.limit(), j3, 0);
                }
                d1();
                this.w0 = true;
                this.t0 = 0;
                this.G0.c++;
                return true;
            } catch (MediaCodec.CryptoException e2) {
                throw y(e2, this.C, k0.Z(e2.getErrorCode()));
            }
        } catch (g.a e3) {
            K0(e3);
            X0(0);
            m0();
            return true;
        }
    }

    public static boolean p1(z0 z0Var) {
        int i = z0Var.H;
        return i == 0 || i == 2;
    }

    public final boolean A0() {
        return this.l0 >= 0;
    }

    public final void B0(z0 z0Var) {
        f0();
        String str = z0Var.m;
        if ("audio/mp4a-latm".equals(str) || "audio/mpeg".equals(str) || "audio/opus".equals(str)) {
            this.x.u(32);
        } else {
            this.x.u(1);
        }
        this.p0 = true;
    }

    public final void C0(t tVar, MediaCrypto mediaCrypto) {
        String str = tVar.a;
        int i = k0.a;
        float t0 = i < 23 ? -1.0f : t0(this.K, this.C, E());
        float f = t0 > this.t ? t0 : -1.0f;
        T0(this.C);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        m.a w0 = w0(tVar, this.C, mediaCrypto, f);
        if (i >= 31) {
            a.a(w0, D());
        }
        try {
            a0.a("createCodec:" + str);
            this.L = this.q.a(w0);
            a0.c();
            long elapsedRealtime2 = SystemClock.elapsedRealtime();
            if (!tVar.o(this.C)) {
                d4.B.j("MediaCodecRenderer", k0.D("Format exceeds selected codec's capabilities [%s, %s]", z0.k(this.C), str));
            }
            this.S = tVar;
            this.P = f;
            this.M = this.C;
            this.T = V(str);
            this.U = W(str, this.M);
            this.V = b0(str);
            this.W = d0(str);
            this.X = Y(str);
            this.Y = Z(str);
            this.Z = X(str);
            this.e0 = c0(str, this.M);
            this.h0 = a0(tVar) || s0();
            if (this.L.h()) {
                this.s0 = true;
                this.t0 = 1;
                this.f0 = this.T != 0;
            }
            if ("c2.android.mp3.decoder".equals(tVar.a)) {
                this.i0 = new j();
            }
            if (getState() == 2) {
                this.j0 = SystemClock.elapsedRealtime() + 1000;
            }
            this.G0.a++;
            L0(str, w0, elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
        } catch (Throwable th) {
            a0.c();
            throw th;
        }
    }

    public final boolean D0(z0 z0Var) {
        return this.F == null && n1(z0Var);
    }

    public final boolean E0(long j) {
        int size = this.y.size();
        for (int i = 0; i < size; i++) {
            if (((Long) this.y.get(i)).longValue() == j) {
                this.y.remove(i);
                return true;
            }
        }
        return false;
    }

    public void G() {
        this.C = null;
        g1(c.e);
        this.A.clear();
        o0();
    }

    public void H(boolean z, boolean z2) {
        this.G0 = new U2.e();
    }

    public void I(long j, boolean z) {
        this.B0 = false;
        this.C0 = false;
        this.E0 = false;
        if (this.p0) {
            this.x.clear();
            this.w.clear();
            this.q0 = false;
        } else {
            n0();
        }
        if (this.H0.d.l() > 0) {
            this.D0 = true;
        }
        this.H0.d.c();
        this.A.clear();
    }

    public final void I0() {
        z0 z0Var;
        if (this.L != null || this.p0 || (z0Var = this.C) == null) {
            return;
        }
        if (D0(z0Var)) {
            B0(this.C);
            return;
        }
        f1(this.F);
        String str = this.C.m;
        V2.o oVar = this.E;
        if (oVar != null) {
            CryptoConfig d = oVar.d();
            if (this.G == null) {
                if (d == null) {
                    if (this.E.getError() == null) {
                        return;
                    }
                } else if (d instanceof H) {
                    H h = (H) d;
                    try {
                        MediaCrypto mediaCrypto = new MediaCrypto(h.a, h.b);
                        this.G = mediaCrypto;
                        this.H = !h.c && mediaCrypto.requiresSecureDecoderComponent(str);
                    } catch (MediaCryptoException e) {
                        throw y(e, this.C, 6006);
                    }
                }
            }
            if (H.d && (d instanceof H)) {
                int state = this.E.getState();
                if (state == 1) {
                    o.a aVar = (o.a) d4.a.e(this.E.getError());
                    throw y(aVar, this.C, aVar.a);
                }
                if (state != 4) {
                    return;
                }
            }
        }
        try {
            J0(this.G, this.H);
        } catch (b e2) {
            throw y(e2, this.C, 4001);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00b0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x004a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void J0(android.media.MediaCrypto r8, boolean r9) {
        /*
            r7 = this;
            java.util.ArrayDeque r0 = r7.Q
            r1 = 0
            if (r0 != 0) goto L3a
            java.util.List r0 = r7.p0(r9)     // Catch: p3.B.c -> L18
            java.util.ArrayDeque r2 = new java.util.ArrayDeque     // Catch: p3.B.c -> L18
            r2.<init>()     // Catch: p3.B.c -> L18
            r7.Q = r2     // Catch: p3.B.c -> L18
            boolean r3 = r7.s     // Catch: p3.B.c -> L18
            if (r3 == 0) goto L1a
            r2.addAll(r0)     // Catch: p3.B.c -> L18
            goto L2c
        L18:
            r8 = move-exception
            goto L2f
        L1a:
            boolean r2 = r0.isEmpty()     // Catch: p3.B.c -> L18
            if (r2 != 0) goto L2c
            java.util.ArrayDeque r2 = r7.Q     // Catch: p3.B.c -> L18
            r3 = 0
            java.lang.Object r0 = r0.get(r3)     // Catch: p3.B.c -> L18
            p3.t r0 = (p3.t) r0     // Catch: p3.B.c -> L18
            r2.add(r0)     // Catch: p3.B.c -> L18
        L2c:
            r7.R = r1     // Catch: p3.B.c -> L18
            goto L3a
        L2f:
            p3.u$b r0 = new p3.u$b
            O2.z0 r1 = r7.C
            r2 = -49998(0xffffffffffff3cb2, float:NaN)
            r0.<init>(r1, r8, r9, r2)
            throw r0
        L3a:
            java.util.ArrayDeque r0 = r7.Q
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto Lb6
            java.util.ArrayDeque r0 = r7.Q
            java.lang.Object r0 = r0.peekFirst()
            p3.t r0 = (p3.t) r0
        L4a:
            p3.m r2 = r7.L
            if (r2 != 0) goto Lb3
            java.util.ArrayDeque r2 = r7.Q
            java.lang.Object r2 = r2.peekFirst()
            p3.t r2 = (p3.t) r2
            boolean r3 = r7.l1(r2)
            if (r3 != 0) goto L5d
            return
        L5d:
            r7.C0(r2, r8)     // Catch: java.lang.Exception -> L61
            goto L4a
        L61:
            r3 = move-exception
            java.lang.String r4 = "MediaCodecRenderer"
            if (r2 != r0) goto L76
            java.lang.String r3 = "Preferred decoder instantiation failed. Sleeping for 50ms then retrying."
            d4.B.j(r4, r3)     // Catch: java.lang.Exception -> L74
            r5 = 50
            java.lang.Thread.sleep(r5)     // Catch: java.lang.Exception -> L74
            r7.C0(r2, r8)     // Catch: java.lang.Exception -> L74
            goto L4a
        L74:
            r3 = move-exception
            goto L77
        L76:
            throw r3     // Catch: java.lang.Exception -> L74
        L77:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Failed to initialize decoder: "
            r5.append(r6)
            r5.append(r2)
            java.lang.String r5 = r5.toString()
            d4.B.k(r4, r5, r3)
            java.util.ArrayDeque r4 = r7.Q
            r4.removeFirst()
            p3.u$b r4 = new p3.u$b
            O2.z0 r5 = r7.C
            r4.<init>(r5, r3, r9, r2)
            r7.K0(r4)
            p3.u$b r2 = r7.R
            if (r2 != 0) goto La1
            r7.R = r4
            goto La7
        La1:
            p3.u$b r2 = p3.u.b.a(r2, r4)
            r7.R = r2
        La7:
            java.util.ArrayDeque r2 = r7.Q
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto Lb0
            goto L4a
        Lb0:
            p3.u$b r8 = r7.R
            throw r8
        Lb3:
            r7.Q = r1
            return
        Lb6:
            p3.u$b r8 = new p3.u$b
            O2.z0 r0 = r7.C
            r2 = -49999(0xffffffffffff3cb1, float:NaN)
            r8.<init>(r0, r1, r9, r2)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: p3.u.J0(android.media.MediaCrypto, boolean):void");
    }

    public abstract void K0(Exception exc);

    public void L() {
        try {
            f0();
            Z0();
        } finally {
            j1(null);
        }
    }

    public abstract void L0(String str, m.a aVar, long j, long j2);

    public abstract void M0(String str);

    /* JADX WARN: Removed duplicated region for block: B:45:0x0084  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public U2.h N0(O2.A0 r12) {
        /*
            Method dump skipped, instructions count: 248
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p3.u.N0(O2.A0):U2.h");
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0037, code lost:
    
        if (r5 >= r1) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void O(O2.z0[] r16, long r17, long r19) {
        /*
            r15 = this;
            r0 = r15
            p3.u$c r1 = r0.H0
            long r1 = r1.c
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 != 0) goto L21
            p3.u$c r1 = new p3.u$c
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r6 = r1
            r9 = r17
            r11 = r19
            r6.<init>(r7, r9, r11)
            r15.g1(r1)
            goto L68
        L21:
            java.util.ArrayDeque r1 = r0.A
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L57
            long r1 = r0.z0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L39
            long r5 = r0.I0
            int r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r7 == 0) goto L57
            int r7 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r7 < 0) goto L57
        L39:
            p3.u$c r1 = new p3.u$c
            r9 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r8 = r1
            r11 = r17
            r13 = r19
            r8.<init>(r9, r11, r13)
            r15.g1(r1)
            p3.u$c r1 = r0.H0
            long r1 = r1.c
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L68
            r15.R0()
            goto L68
        L57:
            java.util.ArrayDeque r1 = r0.A
            p3.u$c r9 = new p3.u$c
            long r3 = r0.z0
            r2 = r9
            r5 = r17
            r7 = r19
            r2.<init>(r3, r5, r7)
            r1.add(r9)
        L68:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p3.u.O(O2.z0[], long, long):void");
    }

    public abstract void O0(z0 z0Var, MediaFormat mediaFormat);

    public void Q0(long j) {
        this.I0 = j;
        while (!this.A.isEmpty() && j >= ((c) this.A.peek()).a) {
            g1((c) this.A.poll());
            R0();
        }
    }

    public final void S() {
        String str;
        d4.a.g(!this.B0);
        A0 B = B();
        this.w.clear();
        do {
            this.w.clear();
            int P = P(B, this.w, 0);
            if (P == -5) {
                N0(B);
                return;
            }
            if (P != -4) {
                if (P != -3) {
                    throw new IllegalStateException();
                }
                return;
            }
            if (this.w.isEndOfStream()) {
                this.B0 = true;
                return;
            }
            if (this.D0) {
                z0 z0Var = (z0) d4.a.e(this.C);
                this.D = z0Var;
                O0(z0Var, null);
                this.D0 = false;
            }
            this.w.i();
            z0 z0Var2 = this.C;
            if (z0Var2 != null && (str = z0Var2.m) != null && str.equals("audio/opus")) {
                this.B.a(this.w);
            }
        } while (this.x.o(this.w));
        this.q0 = true;
    }

    public abstract void S0(U2.g gVar);

    public final boolean T(long j, long j2) {
        d4.a.g(!this.C0);
        if (this.x.t()) {
            i iVar = this.x;
            if (!V0(j, j2, null, iVar.d, this.l0, 0, iVar.s(), this.x.q(), this.x.isDecodeOnly(), this.x.isEndOfStream(), this.D)) {
                return false;
            }
            Q0(this.x.r());
            this.x.clear();
        }
        if (this.B0) {
            this.C0 = true;
            return false;
        }
        if (this.q0) {
            d4.a.g(this.x.o(this.w));
            this.q0 = false;
        }
        if (this.r0) {
            if (this.x.t()) {
                return true;
            }
            f0();
            this.r0 = false;
            I0();
            if (!this.p0) {
                return false;
            }
        }
        S();
        if (this.x.t()) {
            this.x.i();
        }
        return this.x.t() || this.B0 || this.r0;
    }

    public abstract U2.h U(t tVar, z0 z0Var, z0 z0Var2);

    public final int V(String str) {
        int i = k0.a;
        if (i <= 25 && "OMX.Exynos.avc.dec.secure".equals(str)) {
            String str2 = k0.d;
            if (str2.startsWith("SM-T585") || str2.startsWith("SM-A510") || str2.startsWith("SM-A520") || str2.startsWith("SM-J700")) {
                return 2;
            }
        }
        if (i >= 24) {
            return 0;
        }
        if (!"OMX.Nvidia.h264.decode".equals(str) && !"OMX.Nvidia.h264.decode.secure".equals(str)) {
            return 0;
        }
        String str3 = k0.b;
        return ("flounder".equals(str3) || "flounder_lte".equals(str3) || "grouper".equals(str3) || "tilapia".equals(str3)) ? 1 : 0;
    }

    public abstract boolean V0(long j, long j2, m mVar, ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, z0 z0Var);

    public final void W0() {
        this.y0 = true;
        MediaFormat b2 = this.L.b();
        if (this.T != 0 && b2.getInteger("width") == 32 && b2.getInteger("height") == 32) {
            this.g0 = true;
            return;
        }
        if (this.e0) {
            b2.setInteger("channel-count", 1);
        }
        this.N = b2;
        this.O = true;
    }

    public final boolean X0(int i) {
        A0 B = B();
        this.u.clear();
        int P = P(B, this.u, i | 4);
        if (P == -5) {
            N0(B);
            return true;
        }
        if (P != -4 || !this.u.isEndOfStream()) {
            return false;
        }
        this.B0 = true;
        U0();
        return false;
    }

    public final void Y0() {
        Z0();
        I0();
    }

    public void Z0() {
        try {
            m mVar = this.L;
            if (mVar != null) {
                mVar.release();
                this.G0.b++;
                M0(this.S.a);
            }
            this.L = null;
            try {
                MediaCrypto mediaCrypto = this.G;
                if (mediaCrypto != null) {
                    mediaCrypto.release();
                }
            } finally {
            }
        } catch (Throwable th) {
            this.L = null;
            try {
                MediaCrypto mediaCrypto2 = this.G;
                if (mediaCrypto2 != null) {
                    mediaCrypto2.release();
                }
                throw th;
            } finally {
            }
        }
    }

    public final int a(z0 z0Var) {
        try {
            return o1(this.r, z0Var);
        } catch (B.c e) {
            throw y(e, z0Var, 4002);
        }
    }

    public void b1() {
        d1();
        e1();
        this.j0 = -9223372036854775807L;
        this.x0 = false;
        this.w0 = false;
        this.f0 = false;
        this.g0 = false;
        this.n0 = false;
        this.o0 = false;
        this.y.clear();
        this.z0 = -9223372036854775807L;
        this.A0 = -9223372036854775807L;
        this.I0 = -9223372036854775807L;
        j jVar = this.i0;
        if (jVar != null) {
            jVar.c();
        }
        this.u0 = 0;
        this.v0 = 0;
        this.t0 = this.s0 ? 1 : 0;
    }

    public void c1() {
        b1();
        this.F0 = null;
        this.i0 = null;
        this.Q = null;
        this.S = null;
        this.M = null;
        this.N = null;
        this.O = false;
        this.y0 = false;
        this.P = -1.0f;
        this.T = 0;
        this.U = false;
        this.V = false;
        this.W = false;
        this.X = false;
        this.Y = false;
        this.Z = false;
        this.e0 = false;
        this.h0 = false;
        this.s0 = false;
        this.t0 = 0;
        this.H = false;
    }

    public boolean d() {
        return this.C0;
    }

    public final void d1() {
        this.k0 = -1;
        this.v.d = null;
    }

    public boolean e() {
        return this.C != null && (F() || A0() || (this.j0 != -9223372036854775807L && SystemClock.elapsedRealtime() < this.j0));
    }

    public n e0(Throwable th, t tVar) {
        return new n(th, tVar);
    }

    public final void e1() {
        this.l0 = -1;
        this.m0 = null;
    }

    public final void f0() {
        this.r0 = false;
        this.x.clear();
        this.w.clear();
        this.q0 = false;
        this.p0 = false;
        this.B.d();
    }

    public final void f1(V2.o oVar) {
        V2.n.a(this.E, oVar);
        this.E = oVar;
    }

    public final boolean g0() {
        if (this.w0) {
            this.u0 = 1;
            if (this.V || this.X) {
                this.v0 = 3;
                return false;
            }
            this.v0 = 1;
        }
        return true;
    }

    public final void g1(c cVar) {
        this.H0 = cVar;
        long j = cVar.c;
        if (j != -9223372036854775807L) {
            this.J0 = true;
            P0(j);
        }
    }

    public final void h0() {
        if (!this.w0) {
            Y0();
        } else {
            this.u0 = 1;
            this.v0 = 3;
        }
    }

    public final void h1() {
        this.E0 = true;
    }

    public final boolean i0() {
        if (this.w0) {
            this.u0 = 1;
            if (this.V || this.X) {
                this.v0 = 3;
                return false;
            }
            this.v0 = 2;
        } else {
            r1();
        }
        return true;
    }

    public final void i1(O2.w wVar) {
        this.F0 = wVar;
    }

    public final boolean j0(long j, long j2) {
        boolean z;
        boolean V0;
        int l;
        if (!A0()) {
            if (this.Y && this.x0) {
                try {
                    l = this.L.l(this.z);
                } catch (IllegalStateException unused) {
                    U0();
                    if (this.C0) {
                        Z0();
                    }
                    return false;
                }
            } else {
                l = this.L.l(this.z);
            }
            if (l < 0) {
                if (l == -2) {
                    W0();
                    return true;
                }
                if (this.h0 && (this.B0 || this.u0 == 2)) {
                    U0();
                }
                return false;
            }
            if (this.g0) {
                this.g0 = false;
                this.L.m(l, false);
                return true;
            }
            MediaCodec.BufferInfo bufferInfo = this.z;
            if (bufferInfo.size == 0 && (bufferInfo.flags & 4) != 0) {
                U0();
                return false;
            }
            this.l0 = l;
            ByteBuffer n = this.L.n(l);
            this.m0 = n;
            if (n != null) {
                n.position(this.z.offset);
                ByteBuffer byteBuffer = this.m0;
                MediaCodec.BufferInfo bufferInfo2 = this.z;
                byteBuffer.limit(bufferInfo2.offset + bufferInfo2.size);
            }
            if (this.Z) {
                MediaCodec.BufferInfo bufferInfo3 = this.z;
                if (bufferInfo3.presentationTimeUs == 0 && (bufferInfo3.flags & 4) != 0) {
                    long j3 = this.z0;
                    if (j3 != -9223372036854775807L) {
                        bufferInfo3.presentationTimeUs = j3;
                    }
                }
            }
            this.n0 = E0(this.z.presentationTimeUs);
            long j4 = this.A0;
            long j5 = this.z.presentationTimeUs;
            this.o0 = j4 == j5;
            s1(j5);
        }
        if (this.Y && this.x0) {
            try {
                m mVar = this.L;
                ByteBuffer byteBuffer2 = this.m0;
                int i = this.l0;
                MediaCodec.BufferInfo bufferInfo4 = this.z;
                z = false;
                try {
                    V0 = V0(j, j2, mVar, byteBuffer2, i, bufferInfo4.flags, 1, bufferInfo4.presentationTimeUs, this.n0, this.o0, this.D);
                } catch (IllegalStateException unused2) {
                    U0();
                    if (this.C0) {
                        Z0();
                    }
                    return z;
                }
            } catch (IllegalStateException unused3) {
                z = false;
            }
        } else {
            z = false;
            m mVar2 = this.L;
            ByteBuffer byteBuffer3 = this.m0;
            int i2 = this.l0;
            MediaCodec.BufferInfo bufferInfo5 = this.z;
            V0 = V0(j, j2, mVar2, byteBuffer3, i2, bufferInfo5.flags, 1, bufferInfo5.presentationTimeUs, this.n0, this.o0, this.D);
        }
        if (V0) {
            Q0(this.z.presentationTimeUs);
            boolean z2 = (this.z.flags & 4) != 0;
            e1();
            if (!z2) {
                return true;
            }
            U0();
        }
        return z;
    }

    public final boolean k0(t tVar, z0 z0Var, V2.o oVar, V2.o oVar2) {
        CryptoConfig d;
        CryptoConfig d2;
        if (oVar == oVar2) {
            return false;
        }
        if (oVar2 != null && oVar != null && (d = oVar2.d()) != null && (d2 = oVar.d()) != null && d.getClass().equals(d2.getClass())) {
            if (!(d instanceof H)) {
                return false;
            }
            H h = (H) d;
            if (!oVar2.a().equals(oVar.a()) || k0.a < 23) {
                return true;
            }
            UUID uuid = O2.o.e;
            if (!uuid.equals(oVar.a()) && !uuid.equals(oVar2.a())) {
                return !tVar.g && (h.c ? false : oVar2.h(z0Var.m));
            }
        }
        return true;
    }

    public final boolean k1(long j) {
        return this.I == -9223372036854775807L || SystemClock.elapsedRealtime() - j < this.I;
    }

    public boolean l1(t tVar) {
        return true;
    }

    public final void m0() {
        try {
            this.L.flush();
        } finally {
            b1();
        }
    }

    public boolean m1() {
        return false;
    }

    public final boolean n0() {
        boolean o0 = o0();
        if (o0) {
            I0();
        }
        return o0;
    }

    public boolean n1(z0 z0Var) {
        return false;
    }

    public boolean o0() {
        if (this.L == null) {
            return false;
        }
        int i = this.v0;
        if (i == 3 || this.V || ((this.W && !this.y0) || (this.X && this.x0))) {
            Z0();
            return true;
        }
        if (i == 2) {
            int i2 = k0.a;
            d4.a.g(i2 >= 23);
            if (i2 >= 23) {
                try {
                    r1();
                } catch (O2.w e) {
                    d4.B.k("MediaCodecRenderer", "Failed to update the DRM session, releasing the codec instead.", e);
                    Z0();
                    return true;
                }
            }
        }
        m0();
        return false;
    }

    public abstract int o1(w wVar, z0 z0Var);

    public final List p0(boolean z) {
        List v0 = v0(this.r, this.C, z);
        if (v0.isEmpty() && z) {
            v0 = v0(this.r, this.C, false);
            if (!v0.isEmpty()) {
                d4.B.j("MediaCodecRenderer", "Drm session requires secure decoder for " + this.C.m + ", but no secure decoder available. Trying to proceed with " + v0 + ".");
            }
        }
        return v0;
    }

    public final m q0() {
        return this.L;
    }

    public final boolean q1(z0 z0Var) {
        if (k0.a >= 23 && this.L != null && this.v0 != 3 && getState() != 0) {
            float t0 = t0(this.K, z0Var, E());
            float f = this.P;
            if (f == t0) {
                return true;
            }
            if (t0 == -1.0f) {
                h0();
                return false;
            }
            if (f == -1.0f && t0 <= this.t) {
                return true;
            }
            Bundle bundle = new Bundle();
            bundle.putFloat("operating-rate", t0);
            this.L.i(bundle);
            this.P = t0;
        }
        return true;
    }

    public final t r0() {
        return this.S;
    }

    public final void r1() {
        CryptoConfig d = this.F.d();
        if (d instanceof H) {
            try {
                E1.a(this.G, ((H) d).b);
            } catch (MediaCryptoException e) {
                throw y(e, this.C, 6006);
            }
        }
        f1(this.F);
        this.u0 = 0;
        this.v0 = 0;
    }

    public void s(float f, float f2) {
        this.J = f;
        this.K = f2;
        q1(this.M);
    }

    public boolean s0() {
        return false;
    }

    public final void s1(long j) {
        z0 z0Var = (z0) this.H0.d.j(j);
        if (z0Var == null && this.J0 && this.N != null) {
            z0Var = (z0) this.H0.d.i();
        }
        if (z0Var != null) {
            this.D = z0Var;
        } else if (!this.O || this.D == null) {
            return;
        }
        O0(this.D, this.N);
        this.O = false;
        this.J0 = false;
    }

    public final int t() {
        return 8;
    }

    public abstract float t0(float f, z0 z0Var, z0[] z0VarArr);

    public void u(long j, long j2) {
        boolean z = false;
        if (this.E0) {
            this.E0 = false;
            U0();
        }
        O2.w wVar = this.F0;
        if (wVar != null) {
            this.F0 = null;
            throw wVar;
        }
        try {
            if (this.C0) {
                a1();
                return;
            }
            if (this.C != null || X0(2)) {
                I0();
                if (this.p0) {
                    a0.a("bypassRender");
                    while (T(j, j2)) {
                    }
                } else {
                    if (this.L == null) {
                        this.G0.d += R(j);
                        X0(1);
                        this.G0.c();
                    }
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    a0.a("drainAndFeed");
                    while (j0(j, j2) && k1(elapsedRealtime)) {
                    }
                    while (l0() && k1(elapsedRealtime)) {
                    }
                }
                a0.c();
                this.G0.c();
            }
        } catch (IllegalStateException e) {
            if (!F0(e)) {
                throw e;
            }
            K0(e);
            if (k0.a >= 21 && H0(e)) {
                z = true;
            }
            if (z) {
                Z0();
            }
            throw z(e0(e, r0()), this.C, z, 4003);
        }
    }

    public final MediaFormat u0() {
        return this.N;
    }

    public abstract List v0(w wVar, z0 z0Var, boolean z);

    public abstract m.a w0(t tVar, z0 z0Var, MediaCrypto mediaCrypto, float f);

    public final long x0() {
        return this.H0.c;
    }

    public float y0() {
        return this.J;
    }

    public void M() {
    }

    public void N() {
    }

    public void R0() {
    }

    public void a1() {
    }

    public void P0(long j) {
    }

    public void T0(z0 z0Var) {
    }

    public void z0(U2.g gVar) {
    }
}
