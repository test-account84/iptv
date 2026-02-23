package com.google.ads.interactivemedia.v3.internal;

import android.media.AudioDeviceInfo;
import android.media.AudioFormat;
import android.media.AudioTrack;
import android.util.Pair;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ExecutorService;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class kh implements jp {
    private static final Object a = new Object();
    private static ExecutorService b;
    private static int c;
    private int A;
    private long B;
    private long C;
    private long D;
    private long E;
    private int F;
    private boolean G;
    private boolean H;
    private long I;
    private float J;
    private jb[] K;
    private ByteBuffer[] L;
    private ByteBuffer M;
    private int N;
    private ByteBuffer O;
    private byte[] P;
    private int Q;
    private int R;
    private boolean S;
    private boolean T;
    private boolean U;
    private boolean V;
    private int W;
    private g X;
    private jy Y;
    private boolean Z;
    private long aa;
    private boolean ab;
    private boolean ac;
    private final agp ad;
    private final ui ae;
    private final iy d;
    private final boolean e;
    private final jv f;
    private final ks g;
    private final jb[] h;
    private final jb[] i;
    private final jt j;
    private final ArrayDeque k;
    private final boolean l;
    private kg m;
    private final kd n;
    private final kd o;
    private final jz p;
    private iw q;
    private jm r;
    private kb s;
    private kb t;
    private AudioTrack u;
    private f v;
    private kc w;
    private kc x;
    private au y;
    private ByteBuffer z;

    public /* synthetic */ kh(ka kaVar) {
        this.d = ka.a(kaVar);
        ui d = ka.d(kaVar);
        this.ae = d;
        int i = cq.a;
        this.e = false;
        this.l = false;
        this.p = kaVar.a;
        agp agpVar = new agp(null);
        this.ad = agpVar;
        agpVar.f();
        this.j = new jt(new ke(this));
        jv jvVar = new jv();
        this.f = jvVar;
        ks ksVar = new ks();
        this.g = ksVar;
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, new ju[]{new ko(), jvVar, ksVar});
        Collections.addAll(arrayList, d.k());
        this.h = (jb[]) arrayList.toArray(new jb[0]);
        this.i = new jb[]{new kk()};
        this.J = 1.0f;
        this.v = f.a;
        this.W = 0;
        this.X = new g();
        au auVar = au.a;
        this.x = new kc(auVar, false, 0L, 0L);
        this.y = auVar;
        this.R = -1;
        this.K = new jb[0];
        this.L = new ByteBuffer[0];
        this.k = new ArrayDeque();
        this.n = new kd();
        this.o = new kd();
    }

    public static /* bridge */ /* synthetic */ long A(kh khVar) {
        return khVar.J();
    }

    public static /* bridge */ /* synthetic */ AudioFormat B(int i, int i2, int i3) {
        return new AudioFormat.Builder().setSampleRate(i).setChannelMask(i2).setEncoding(i3).build();
    }

    public static /* bridge */ /* synthetic */ AudioTrack C(kh khVar) {
        return khVar.u;
    }

    public static /* bridge */ /* synthetic */ jm D(kh khVar) {
        return khVar.r;
    }

    public static /* bridge */ /* synthetic */ boolean E(kh khVar) {
        return khVar.U;
    }

    public static /* synthetic */ void G(AudioTrack audioTrack, agp agpVar) {
        try {
            audioTrack.flush();
            audioTrack.release();
            agpVar.f();
            synchronized (a) {
                try {
                    int i = c - 1;
                    c = i;
                    if (i == 0) {
                        b.shutdown();
                        b = null;
                    }
                } finally {
                }
            }
        } catch (Throwable th) {
            agpVar.f();
            synchronized (a) {
                try {
                    int i2 = c - 1;
                    c = i2;
                    if (i2 == 0) {
                        b.shutdown();
                        b = null;
                    }
                    throw th;
                } finally {
                }
            }
        }
    }

    private static int H(AudioTrack audioTrack, ByteBuffer byteBuffer, int i) {
        return audioTrack.write(byteBuffer, i, 1);
    }

    private final long I() {
        return this.t.c == 0 ? this.B / r0.b : this.C;
    }

    private final long J() {
        return this.t.c == 0 ? this.D / r0.d : this.E;
    }

    private final AudioTrack K(kb kbVar) throws jl {
        try {
            return kbVar.b(this.Z, this.v, this.W);
        } catch (jl e) {
            jm jmVar = this.r;
            if (jmVar != null) {
                jmVar.a(e);
            }
            throw e;
        }
    }

    private final au L() {
        return M().a;
    }

    private final kc M() {
        kc kcVar = this.w;
        return kcVar != null ? kcVar : !this.k.isEmpty() ? (kc) this.k.getLast() : this.x;
    }

    private final void N(long j) {
        au auVar;
        boolean z;
        if (X()) {
            ui uiVar = this.ae;
            auVar = L();
            uiVar.l(auVar);
        } else {
            auVar = au.a;
        }
        au auVar2 = auVar;
        if (X()) {
            ui uiVar2 = this.ae;
            boolean F = F();
            uiVar2.m(F);
            z = F;
        } else {
            z = false;
        }
        this.k.add(new kc(auVar2, z, Math.max(0L, j), this.t.a(J())));
        jb[] jbVarArr = this.t.i;
        ArrayList arrayList = new ArrayList();
        for (jb jbVar : jbVarArr) {
            if (jbVar.g()) {
                arrayList.add(jbVar);
            } else {
                jbVar.c();
            }
        }
        int size = arrayList.size();
        this.K = (jb[]) arrayList.toArray(new jb[size]);
        this.L = new ByteBuffer[size];
        O();
        jm jmVar = this.r;
        if (jmVar != null) {
            kn.U(((km) jmVar).a).s(z);
        }
    }

    private final void O() {
        int i = 0;
        while (true) {
            jb[] jbVarArr = this.K;
            if (i >= jbVarArr.length) {
                return;
            }
            jb jbVar = jbVarArr[i];
            jbVar.c();
            this.L[i] = jbVar.b();
            i++;
        }
    }

    private final void P() {
        if (this.T) {
            return;
        }
        this.T = true;
        this.j.c(J());
        this.u.stop();
        this.A = 0;
    }

    private final void Q(long j) throws jo {
        ByteBuffer byteBuffer;
        int length = this.K.length;
        int i = length;
        while (i >= 0) {
            if (i > 0) {
                byteBuffer = this.L[i - 1];
            } else {
                byteBuffer = this.M;
                if (byteBuffer == null) {
                    byteBuffer = jb.a;
                }
            }
            if (i == length) {
                T(byteBuffer, j);
            } else {
                jb jbVar = this.K[i];
                if (i > this.R) {
                    jbVar.e(byteBuffer);
                }
                ByteBuffer b2 = jbVar.b();
                this.L[i] = b2;
                if (b2.hasRemaining()) {
                    i++;
                }
            }
            if (byteBuffer.hasRemaining()) {
                return;
            } else {
                i--;
            }
        }
    }

    private final void R(au auVar, boolean z) {
        kc M = M();
        if (auVar.equals(M.a) && z == M.b) {
            return;
        }
        kc kcVar = new kc(auVar, z, -9223372036854775807L, -9223372036854775807L);
        if (V()) {
            this.w = kcVar;
        } else {
            this.x = kcVar;
        }
    }

    private final void S() {
        if (V()) {
            if (cq.a >= 21) {
                this.u.setVolume(this.J);
                return;
            }
            AudioTrack audioTrack = this.u;
            float f = this.J;
            audioTrack.setStereoVolume(f, f);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00de  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void T(java.nio.ByteBuffer r13, long r14) throws com.google.ads.interactivemedia.v3.internal.jo {
        /*
            Method dump skipped, instructions count: 393
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.kh.T(java.nio.ByteBuffer, long):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0029 -> B:4:0x0009). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean U() throws com.google.ads.interactivemedia.v3.internal.jo {
        /*
            r9 = this;
            int r0 = r9.R
            r1 = 1
            r2 = 0
            r3 = -1
            if (r0 != r3) goto Lb
            r9.R = r2
        L9:
            r0 = 1
            goto Lc
        Lb:
            r0 = 0
        Lc:
            int r4 = r9.R
            com.google.ads.interactivemedia.v3.internal.jb[] r5 = r9.K
            int r6 = r5.length
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r4 >= r6) goto L2f
            r4 = r5[r4]
            if (r0 == 0) goto L1f
            r4.d()
        L1f:
            r9.Q(r7)
            boolean r0 = r4.h()
            if (r0 != 0) goto L29
            return r2
        L29:
            int r0 = r9.R
            int r0 = r0 + r1
            r9.R = r0
            goto L9
        L2f:
            java.nio.ByteBuffer r0 = r9.O
            if (r0 == 0) goto L3b
            r9.T(r0, r7)
            java.nio.ByteBuffer r0 = r9.O
            if (r0 == 0) goto L3b
            return r2
        L3b:
            r9.R = r3
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.kh.U():boolean");
    }

    private final boolean V() {
        return this.u != null;
    }

    private static boolean W(AudioTrack audioTrack) {
        return cq.a >= 29 && q1.a(audioTrack);
    }

    private final boolean X() {
        return (this.Z || !"audio/raw".equals(this.t.a.l) || Y(this.t.a.A)) ? false : true;
    }

    private final boolean Y(int i) {
        return false;
    }

    public static /* bridge */ /* synthetic */ long y(kh khVar) {
        return khVar.aa;
    }

    public static /* bridge */ /* synthetic */ long z(kh khVar) {
        return khVar.I();
    }

    public final boolean F() {
        return M().b;
    }

    public final int a(s sVar) {
        if (!"audio/raw".equals(sVar.l)) {
            if (!this.ab) {
                int i = cq.a;
            }
            return this.d.a(sVar) != null ? 2 : 0;
        }
        boolean Y = cq.Y(sVar.A);
        int i2 = sVar.A;
        if (Y) {
            return i2 != 2 ? 1 : 2;
        }
        cd.e("DefaultAudioSink", "Invalid PCM encoding: " + i2);
        return 0;
    }

    public final long b(boolean z) {
        long q;
        if (!V() || this.H) {
            return Long.MIN_VALUE;
        }
        long min = Math.min(this.j.b(z), this.t.a(J()));
        while (!this.k.isEmpty() && min >= ((kc) this.k.getFirst()).d) {
            this.x = (kc) this.k.remove();
        }
        kc kcVar = this.x;
        long j = min - kcVar.d;
        if (kcVar.a.equals(au.a)) {
            q = this.x.c + j;
        } else if (this.k.isEmpty()) {
            q = this.ae.i(j) + this.x.c;
        } else {
            kc kcVar2 = (kc) this.k.getFirst();
            q = kcVar2.c - cq.q(kcVar2.d - min, this.x.a.b);
        }
        return q + this.t.a(this.ae.j());
    }

    public final au c() {
        return L();
    }

    public final void d() {
        if (this.Z) {
            this.Z = false;
            e();
        }
    }

    public final void e() {
        if (V()) {
            this.B = 0L;
            this.C = 0L;
            this.D = 0L;
            this.E = 0L;
            this.ac = false;
            this.F = 0;
            this.x = new kc(L(), F(), 0L, 0L);
            this.I = 0L;
            this.w = null;
            this.k.clear();
            this.M = null;
            this.N = 0;
            this.O = null;
            this.T = false;
            this.S = false;
            this.R = -1;
            this.z = null;
            this.A = 0;
            this.g.p();
            O();
            if (this.j.h()) {
                this.u.pause();
            }
            if (W(this.u)) {
                kg kgVar = this.m;
                af.s(kgVar);
                kgVar.b(this.u);
            }
            if (cq.a < 21 && !this.V) {
                this.W = 0;
            }
            kb kbVar = this.s;
            if (kbVar != null) {
                this.t = kbVar;
                this.s = null;
            }
            this.j.d();
            AudioTrack audioTrack = this.u;
            agp agpVar = this.ad;
            agpVar.g();
            synchronized (a) {
                try {
                    if (b == null) {
                        b = cq.R("ExoPlayer:AudioTrackReleaseThread");
                    }
                    c++;
                    b.execute(new jc(audioTrack, agpVar, 6, (byte[]) null));
                } catch (Throwable th) {
                    throw th;
                }
            }
            this.u = null;
        }
        this.o.a();
        this.n.a();
    }

    public final void f() {
        this.G = true;
    }

    public final void g() {
        this.U = false;
        if (V() && this.j.k()) {
            this.u.pause();
        }
    }

    public final void h() {
        this.U = true;
        if (V()) {
            this.j.f();
            this.u.play();
        }
    }

    public final void i() throws jo {
        if (!this.S && V() && U()) {
            P();
            this.S = true;
        }
    }

    public final void j() {
        e();
        for (jb jbVar : this.h) {
            jbVar.f();
        }
        jb[] jbVarArr = this.i;
        int length = jbVarArr.length;
        for (int i = 0; i <= 0; i++) {
            jbVarArr[i].f();
        }
        this.U = false;
        this.ab = false;
    }

    public final void k(f fVar) {
        if (this.v.equals(fVar)) {
            return;
        }
        this.v = fVar;
        if (this.Z) {
            return;
        }
        e();
    }

    public final void l(int i) {
        if (this.W != i) {
            this.W = i;
            this.V = i != 0;
            e();
        }
    }

    public final void m(g gVar) {
        if (this.X.equals(gVar)) {
            return;
        }
        int i = gVar.a;
        if (this.u != null) {
            int i2 = this.X.a;
        }
        this.X = gVar;
    }

    public final void n(jm jmVar) {
        this.r = jmVar;
    }

    public final void o(au auVar) {
        R(new au(cq.a(auVar.b, 0.1f, 8.0f), cq.a(auVar.c, 0.1f, 8.0f)), F());
    }

    public final void p(iw iwVar) {
        this.q = iwVar;
    }

    public final void q(AudioDeviceInfo audioDeviceInfo) {
        jy jyVar = audioDeviceInfo == null ? null : new jy(audioDeviceInfo);
        this.Y = jyVar;
        AudioTrack audioTrack = this.u;
        if (audioTrack != null) {
            jw.a(audioTrack, jyVar);
        }
    }

    public final void r(boolean z) {
        R(L(), z);
    }

    public final void s(float f) {
        if (this.J != f) {
            this.J = f;
            S();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0161 A[Catch: jl -> 0x00e9, TryCatch #3 {jl -> 0x00e9, blocks: (B:137:0x0086, B:142:0x00d3, B:144:0x00db, B:146:0x00e1, B:147:0x00ec, B:148:0x00fe, B:150:0x0104, B:152:0x0108, B:153:0x010d, B:156:0x0123, B:160:0x013b, B:161:0x0140, B:166:0x009b, B:168:0x00a4, B:178:0x0159, B:180:0x0161, B:181:0x0164, B:141:0x008f), top: B:136:0x0086, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:182:? A[Catch: jl -> 0x00e9, SYNTHETIC, TRY_LEAVE, TryCatch #3 {jl -> 0x00e9, blocks: (B:137:0x0086, B:142:0x00d3, B:144:0x00db, B:146:0x00e1, B:147:0x00ec, B:148:0x00fe, B:150:0x0104, B:152:0x0108, B:153:0x010d, B:156:0x0123, B:160:0x013b, B:161:0x0140, B:166:0x009b, B:168:0x00a4, B:178:0x0159, B:180:0x0161, B:181:0x0164, B:141:0x008f), top: B:136:0x0086, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x02dc A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean t(java.nio.ByteBuffer r26, long r27, int r29) throws com.google.ads.interactivemedia.v3.internal.jl, com.google.ads.interactivemedia.v3.internal.jo {
        /*
            Method dump skipped, instructions count: 956
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.kh.t(java.nio.ByteBuffer, long, int):boolean");
    }

    public final boolean u() {
        return V() && this.j.g(J());
    }

    public final boolean v() {
        if (V()) {
            return this.S && !u();
        }
        return true;
    }

    public final boolean w(s sVar) {
        return a(sVar) != 0;
    }

    public final void x(s sVar, int[] iArr) throws jk {
        int i;
        jb[] jbVarArr;
        int intValue;
        int i2;
        int intValue2;
        int i3;
        int i4;
        int d;
        int[] iArr2;
        if ("audio/raw".equals(sVar.l)) {
            af.u(cq.Y(sVar.A));
            i2 = cq.l(sVar.A, sVar.y);
            jb[] jbVarArr2 = Y(sVar.A) ? this.i : this.h;
            this.g.q(sVar.B, sVar.C);
            if (cq.a < 21 && sVar.y == 8 && iArr == null) {
                iArr2 = new int[6];
                for (int i5 = 0; i5 < 6; i5++) {
                    iArr2[i5] = i5;
                }
            } else {
                iArr2 = iArr;
            }
            this.f.o(iArr2);
            iz izVar = new iz(sVar.z, sVar.y, sVar.A);
            for (jb jbVar : jbVarArr2) {
                try {
                    iz a2 = jbVar.a(izVar);
                    if (true == jbVar.g()) {
                        izVar = a2;
                    }
                } catch (ja e) {
                    throw new jk((Throwable) e, sVar);
                }
            }
            int i6 = izVar.d;
            int i7 = izVar.b;
            int i8 = izVar.c;
            int f = cq.f(i8);
            jbVarArr = jbVarArr2;
            i4 = cq.l(i6, i8);
            i3 = i7;
            i = 0;
            intValue = i6;
            intValue2 = f;
        } else {
            jb[] jbVarArr3 = new jb[0];
            int i9 = sVar.z;
            int i10 = cq.a;
            Pair a3 = this.d.a(sVar);
            if (a3 == null) {
                throw new jk("Unable to configure passthrough for: ".concat(String.valueOf(sVar)), sVar);
            }
            i = 2;
            jbVarArr = jbVarArr3;
            intValue = ((Integer) a3.first).intValue();
            i2 = -1;
            intValue2 = ((Integer) a3.second).intValue();
            i3 = i9;
            i4 = -1;
        }
        int minBufferSize = AudioTrack.getMinBufferSize(i3, intValue2, intValue);
        af.w(minBufferSize != -2);
        int i11 = 250000;
        if (i == 0) {
            d = cq.d(minBufferSize * 4, kj.a(250000, i3, i4), kj.a(750000, i3, i4));
        } else if (i != 1) {
            int i12 = 5;
            if (intValue == 5) {
                i11 = 500000;
            } else {
                i12 = intValue;
            }
            d = axy.a((i11 * kj.b(i12)) / 1000000);
            i4 = i4;
        } else {
            d = axy.a((kj.b(intValue) * 50000000) / 1000000);
        }
        int max = (((Math.max(minBufferSize, d) + i4) - 1) / i4) * i4;
        if (intValue == 0) {
            throw new jk("Invalid output encoding (mode=" + i + ") for: " + String.valueOf(sVar), sVar);
        }
        if (intValue2 != 0) {
            this.ab = false;
            kb kbVar = new kb(sVar, i2, i, i4, i3, intValue2, intValue, max, jbVarArr);
            if (V()) {
                this.s = kbVar;
                return;
            } else {
                this.t = kbVar;
                return;
            }
        }
        throw new jk("Invalid output channel config (mode=" + i + ") for: " + String.valueOf(sVar), sVar);
    }
}
