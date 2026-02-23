package e4;

import O2.A0;
import O2.D1;
import O2.z0;
import android.content.Context;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import android.view.Display;
import android.view.Surface;
import com.google.ads.interactivemedia.v3.internal.Q1;
import com.google.ads.interactivemedia.v3.internal.R1;
import com.google.ads.interactivemedia.v3.internal.S1;
import d.D;
import d4.E;
import d4.F;
import d4.S;
import d4.V;
import d4.a0;
import d4.k0;
import d4.l0;
import d4.t;
import e4.A;
import j$.util.Objects;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import p3.B;
import p3.m;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class i extends p3.u {
    public static final int[] t1 = {1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};
    public static boolean u1;
    public static boolean v1;
    public final Context L0;
    public final o M0;
    public final A.a N0;
    public final d O0;
    public final long P0;
    public final int Q0;
    public final boolean R0;
    public b S0;
    public boolean T0;
    public boolean U0;
    public Surface V0;
    public j W0;
    public boolean X0;
    public int Y0;
    public boolean Z0;
    public boolean a1;
    public boolean b1;
    public long c1;
    public long d1;
    public long e1;
    public int f1;
    public int g1;
    public int h1;
    public long i1;
    public long j1;
    public long k1;
    public int l1;
    public long m1;
    public C n1;
    public C o1;
    public boolean p1;
    public int q1;
    public c r1;
    public m s1;

    public static final class a {
        public static boolean a(Context context) {
            DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
            Display display = displayManager != null ? displayManager.getDisplay(0) : null;
            if (display == null || !Q1.a(display)) {
                return false;
            }
            for (int i : S1.a(R1.a(display))) {
                if (i == 1) {
                    return true;
                }
            }
            return false;
        }
    }

    public static final class b {
        public final int a;
        public final int b;
        public final int c;

        public b(int i, int i2, int i3) {
            this.a = i;
            this.b = i2;
            this.c = i3;
        }
    }

    public final class c implements m.c, Handler.Callback {
        public final Handler a;

        public c(p3.m mVar) {
            Handler y = k0.y(this);
            this.a = y;
            mVar.a(this, y);
        }

        public void a(p3.m mVar, long j, long j2) {
            if (k0.a >= 30) {
                b(j);
            } else {
                this.a.sendMessageAtFrontOfQueue(Message.obtain(this.a, 0, (int) (j >> 32), (int) j));
            }
        }

        public final void b(long j) {
            i iVar = i.this;
            if (this != iVar.r1 || i.B1(iVar) == null) {
                return;
            }
            if (j == Long.MAX_VALUE) {
                i.C1(i.this);
                return;
            }
            try {
                i.this.f2(j);
            } catch (O2.w e) {
                i.D1(i.this, e);
            }
        }

        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            b(k0.t1(message.arg1, message.arg2));
            return true;
        }
    }

    public static final class d {
        public final o a;
        public final i b;
        public Handler e;
        public CopyOnWriteArrayList f;
        public Pair g;
        public Pair h;
        public boolean k;
        public boolean l;
        public final ArrayDeque c = new ArrayDeque();
        public final ArrayDeque d = new ArrayDeque();
        public int i = -1;
        public boolean j = true;
        public long m = -9223372036854775807L;
        public C n = C.f;
        public long o = -9223372036854775807L;
        public long p = -9223372036854775807L;

        public class a {
            public final /* synthetic */ z0 a;

            public a(z0 z0Var) {
                this.a = z0Var;
            }
        }

        public static final class b {
            public static Constructor a;
            public static Method b;
            public static Method c;
            public static Constructor d;
            public static Method e;

            public static d4.o a(float f) {
                c();
                Object newInstance = a.newInstance((Object[]) null);
                b.invoke(newInstance, new Object[]{Float.valueOf(f)});
                D.a(d4.a.e(c.invoke(newInstance, (Object[]) null)));
                return null;
            }

            public static l0 b() {
                c();
                D.a(d4.a.e(e.invoke(d.newInstance((Object[]) null), (Object[]) null)));
                return null;
            }

            public static void c() {
                if (a == null || b == null || c == null) {
                    Class cls = Class.forName("com.google.android.exoplayer2.effect.ScaleAndRotateTransformation$Builder");
                    a = cls.getConstructor((Class[]) null);
                    b = cls.getMethod("setRotationDegrees", new Class[]{Float.TYPE});
                    c = cls.getMethod("build", (Class[]) null);
                }
                if (d == null || e == null) {
                    Class cls2 = Class.forName("com.google.android.exoplayer2.effect.DefaultVideoFrameProcessor$Factory$Builder");
                    d = cls2.getConstructor((Class[]) null);
                    e = cls2.getMethod("build", (Class[]) null);
                }
            }
        }

        public d(o oVar, i iVar) {
            this.a = oVar;
            this.b = iVar;
        }

        public MediaFormat a(MediaFormat mediaFormat) {
            if (k0.a >= 29 && i.u1(this.b).getApplicationContext().getApplicationInfo().targetSdkVersion >= 29) {
                mediaFormat.setInteger("allow-frame-drop", 0);
            }
            return mediaFormat;
        }

        public void b() {
            D.a(d4.a.e(null));
            throw null;
        }

        public void c() {
            d4.a.i(null);
            throw null;
        }

        public long d(long j, long j2) {
            d4.a.g(this.p != -9223372036854775807L);
            return (j + j2) - this.p;
        }

        public Surface e() {
            D.a(d4.a.e(null));
            throw null;
        }

        public boolean f() {
            return false;
        }

        public boolean g() {
            Pair pair = this.h;
            return pair == null || !((S) pair.second).equals(S.c);
        }

        public boolean h(z0 z0Var, long j) {
            int i;
            d4.a.g(!f());
            if (!this.j) {
                return false;
            }
            if (this.f == null) {
                this.j = false;
                return false;
            }
            this.e = k0.x();
            Pair N1 = this.b.N1(z0Var.y);
            try {
                if (!i.t1() && (i = z0Var.u) != 0) {
                    CopyOnWriteArrayList copyOnWriteArrayList = this.f;
                    b.a(i);
                    copyOnWriteArrayList.add(0, (Object) null);
                }
                b.b();
                i.u1(this.b);
                d4.m mVar = d4.m.a;
                Handler handler = this.e;
                Objects.requireNonNull(handler);
                new u0.w(handler);
                new a(z0Var);
                throw null;
            } catch (Exception e) {
                throw i.v1(this.b, e, z0Var, 7000);
            }
        }

        public boolean i(z0 z0Var, long j, boolean z) {
            d4.a.i(null);
            d4.a.g(this.i != -1);
            throw null;
        }

        public void j(String str) {
            this.i = k0.e0(i.u1(this.b), str, false);
        }

        public final void k(long j, boolean z) {
            d4.a.i(null);
            throw null;
        }

        public void l(long j, long j2) {
            d4.a.i(null);
            while (!this.c.isEmpty()) {
                boolean z = false;
                boolean z2 = this.b.getState() == 2;
                long longValue = ((Long) d4.a.e((Long) this.c.peek())).longValue();
                long j3 = longValue + this.p;
                long w1 = i.w1(this.b, j, j2, SystemClock.elapsedRealtime() * 1000, j3, z2);
                if (this.k && this.c.size() == 1) {
                    z = true;
                }
                if (i.x1(this.b, j, w1)) {
                    k(-1L, z);
                    return;
                }
                if (!z2 || j == i.y1(this.b) || w1 > 50000) {
                    return;
                }
                this.a.h(j3);
                long b2 = this.a.b(System.nanoTime() + (w1 * 1000));
                if (this.b.q2((b2 - System.nanoTime()) / 1000, j2, z)) {
                    k(-2L, z);
                } else {
                    if (!this.d.isEmpty() && j3 > ((Long) ((Pair) this.d.peek()).first).longValue()) {
                        this.g = (Pair) this.d.remove();
                    }
                    i.z1(this.b, longValue, b2, (z0) this.g.second);
                    if (this.o >= j3) {
                        this.o = -9223372036854775807L;
                        i.A1(this.b, this.n);
                    }
                    k(b2, z);
                }
            }
        }

        public boolean m() {
            return this.l;
        }

        public void n() {
            D.a(d4.a.e(null));
            throw null;
        }

        public void o(z0 z0Var) {
            D.a(d4.a.e(null));
            new t.b(z0Var.r, z0Var.s).b(z0Var.v).a();
            throw null;
        }

        public void p(Surface surface, S s) {
            Pair pair = this.h;
            if (pair != null && ((Surface) pair.first).equals(surface) && ((S) this.h.second).equals(s)) {
                return;
            }
            this.h = Pair.create(surface, s);
            if (f()) {
                D.a(d4.a.e(null));
                new V(surface, s.b(), s.a());
                throw null;
            }
        }

        public void q(List list) {
            CopyOnWriteArrayList copyOnWriteArrayList = this.f;
            if (copyOnWriteArrayList == null) {
                this.f = new CopyOnWriteArrayList(list);
            } else {
                copyOnWriteArrayList.clear();
                this.f.addAll(list);
            }
        }
    }

    public i(Context context, m.b bVar, p3.w wVar, long j, boolean z, Handler handler, A a2, int i) {
        this(context, bVar, wVar, j, z, handler, a2, i, 30.0f);
    }

    public static /* synthetic */ void A1(i iVar, C c2) {
        iVar.b2(c2);
    }

    public static /* synthetic */ p3.m B1(i iVar) {
        return iVar.q0();
    }

    public static /* synthetic */ void C1(i iVar) {
        iVar.g2();
    }

    public static /* synthetic */ void D1(i iVar, O2.w wVar) {
        iVar.i1(wVar);
    }

    public static boolean H1() {
        return k0.a >= 21;
    }

    public static void J1(MediaFormat mediaFormat, int i) {
        mediaFormat.setFeatureEnabled("tunneled-playback", true);
        mediaFormat.setInteger("audio-session-id", i);
    }

    public static boolean K1() {
        return "NVIDIA".equals(k0.c);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:5:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean M1() {
        /*
            Method dump skipped, instructions count: 3184
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e4.i.M1():boolean");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int O1(p3.t r10, O2.z0 r11) {
        /*
            Method dump skipped, instructions count: 276
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e4.i.O1(p3.t, O2.z0):int");
    }

    public static Point P1(p3.t tVar, z0 z0Var) {
        int i = z0Var.s;
        int i2 = z0Var.r;
        boolean z = i > i2;
        int i3 = z ? i : i2;
        if (z) {
            i = i2;
        }
        float f = i / i3;
        for (int i4 : t1) {
            int i5 = (int) (i4 * f);
            if (i4 <= i3 || i5 <= i) {
                break;
            }
            if (k0.a >= 21) {
                int i6 = z ? i5 : i4;
                if (!z) {
                    i4 = i5;
                }
                Point c2 = tVar.c(i6, i4);
                if (tVar.w(c2.x, c2.y, z0Var.t)) {
                    return c2;
                }
            } else {
                try {
                    int l = k0.l(i4, 16) * 16;
                    int l2 = k0.l(i5, 16) * 16;
                    if (l * l2 <= p3.B.P()) {
                        int i7 = z ? l2 : l;
                        if (!z) {
                            l = l2;
                        }
                        return new Point(i7, l);
                    }
                } catch (B.c unused) {
                }
            }
        }
        return null;
    }

    public static List R1(Context context, p3.w wVar, z0 z0Var, boolean z, boolean z2) {
        String str = z0Var.m;
        if (str == null) {
            return s5.y.z();
        }
        if (k0.a >= 26 && "video/dolby-vision".equals(str) && !a.a(context)) {
            List n = p3.B.n(wVar, z0Var, z, z2);
            if (!n.isEmpty()) {
                return n;
            }
        }
        return p3.B.v(wVar, z0Var, z, z2);
    }

    public static int S1(p3.t tVar, z0 z0Var) {
        if (z0Var.n == -1) {
            return O1(tVar, z0Var);
        }
        int size = z0Var.o.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += ((byte[]) z0Var.o.get(i2)).length;
        }
        return z0Var.n + i;
    }

    public static int T1(int i, int i2) {
        return (i * 3) / (i2 * 2);
    }

    public static boolean V1(long j) {
        return j < -30000;
    }

    public static boolean W1(long j) {
        return j < -500000;
    }

    public static void l2(p3.m mVar, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("hdr10-plus-info", bArr);
        mVar.i(bundle);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void n2(Object obj) {
        j jVar = obj instanceof Surface ? (Surface) obj : null;
        if (jVar == null) {
            j jVar2 = this.W0;
            if (jVar2 != null) {
                jVar = jVar2;
            } else {
                p3.t r0 = r0();
                if (r0 != null && t2(r0)) {
                    jVar = j.d(this.L0, r0.g);
                    this.W0 = jVar;
                }
            }
        }
        if (this.V0 == jVar) {
            if (jVar == null || jVar == this.W0) {
                return;
            }
            d2();
            c2();
            return;
        }
        this.V0 = jVar;
        this.M0.m(jVar);
        this.X0 = false;
        int state = getState();
        p3.m q0 = q0();
        if (q0 != null && !this.O0.f()) {
            if (k0.a < 23 || jVar == null || this.T0) {
                Z0();
                I0();
            } else {
                o2(q0, jVar);
            }
        }
        if (jVar == null || jVar == this.W0) {
            G1();
            F1();
            if (this.O0.f()) {
                this.O0.b();
                return;
            }
            return;
        }
        d2();
        F1();
        if (state == 2) {
            m2();
        }
        if (this.O0.f()) {
            this.O0.p(jVar, S.c);
        }
    }

    public static /* synthetic */ boolean t1() {
        return H1();
    }

    public static /* synthetic */ Context u1(i iVar) {
        return iVar.L0;
    }

    public static /* synthetic */ O2.w v1(i iVar, Throwable th, z0 z0Var, int i) {
        return iVar.y(th, z0Var, i);
    }

    public static /* synthetic */ long w1(i iVar, long j, long j2, long j3, long j4, boolean z) {
        return iVar.E1(j, j2, j3, j4, z);
    }

    public static /* synthetic */ boolean x1(i iVar, long j, long j2) {
        return iVar.r2(j, j2);
    }

    public static /* synthetic */ long y1(i iVar) {
        return iVar.c1;
    }

    public static /* synthetic */ void z1(i iVar, long j, long j2, z0 z0Var) {
        iVar.e2(j, j2, z0Var);
    }

    public final long E1(long j, long j2, long j3, long j4, boolean z) {
        long y0 = (long) ((j4 - j) / y0());
        return z ? y0 - (j3 - j2) : y0;
    }

    public final void F1() {
        p3.m q0;
        this.Z0 = false;
        if (k0.a < 23 || !this.p1 || (q0 = q0()) == null) {
            return;
        }
        this.r1 = new c(q0);
    }

    public void G() {
        G1();
        F1();
        this.X0 = false;
        this.r1 = null;
        try {
            super.G();
        } finally {
            this.N0.m(this.G0);
            this.N0.D(C.f);
        }
    }

    public final void G1() {
        this.o1 = null;
    }

    public void H(boolean z, boolean z2) {
        super.H(z, z2);
        boolean z3 = A().a;
        d4.a.g((z3 && this.q1 == 0) ? false : true);
        if (this.p1 != z3) {
            this.p1 = z3;
            Z0();
        }
        this.N0.o(this.G0);
        this.a1 = z2;
        this.b1 = false;
    }

    public void I(long j, boolean z) {
        super.I(j, z);
        if (this.O0.f()) {
            this.O0.c();
        }
        F1();
        this.M0.j();
        this.i1 = -9223372036854775807L;
        this.c1 = -9223372036854775807L;
        this.g1 = 0;
        if (z) {
            m2();
        } else {
            this.d1 = -9223372036854775807L;
        }
    }

    public boolean I1(String str) {
        if (str.startsWith("OMX.google")) {
            return false;
        }
        synchronized (i.class) {
            try {
                if (!u1) {
                    v1 = M1();
                    u1 = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return v1;
    }

    public void K0(Exception exc) {
        d4.B.e("MediaCodecVideoRenderer", "Video codec error", exc);
        this.N0.C(exc);
    }

    public void L() {
        try {
            super.L();
        } finally {
            if (this.O0.f()) {
                this.O0.n();
            }
            if (this.W0 != null) {
                h2();
            }
        }
    }

    public void L0(String str, m.a aVar, long j, long j2) {
        this.N0.k(str, j, j2);
        this.T0 = I1(str);
        this.U0 = ((p3.t) d4.a.e(r0())).p();
        if (k0.a >= 23 && this.p1) {
            this.r1 = new c((p3.m) d4.a.e(q0()));
        }
        this.O0.j(str);
    }

    public void L1(p3.m mVar, int i, long j) {
        a0.a("dropVideoBuffer");
        mVar.m(i, false);
        a0.c();
        v2(0, 1);
    }

    public void M() {
        super.M();
        this.f1 = 0;
        this.e1 = SystemClock.elapsedRealtime();
        this.j1 = SystemClock.elapsedRealtime() * 1000;
        this.k1 = 0L;
        this.l1 = 0;
        this.M0.k();
    }

    public void M0(String str) {
        this.N0.l(str);
    }

    public void N() {
        this.d1 = -9223372036854775807L;
        Y1();
        a2();
        this.M0.l();
        super.N();
    }

    public U2.h N0(A0 a0) {
        U2.h N0 = super.N0(a0);
        this.N0.p(a0.b, N0);
        return N0;
    }

    public Pair N1(e4.c cVar) {
        if (e4.c.f(cVar)) {
            return cVar.d == 7 ? Pair.create(cVar, cVar.b().d(6).a()) : Pair.create(cVar, cVar);
        }
        e4.c cVar2 = e4.c.g;
        return Pair.create(cVar2, cVar2);
    }

    public void O0(z0 z0Var, MediaFormat mediaFormat) {
        int integer;
        int i;
        p3.m q0 = q0();
        if (q0 != null) {
            q0.d(this.Y0);
        }
        int i2 = 0;
        if (this.p1) {
            i = z0Var.r;
            integer = z0Var.s;
        } else {
            d4.a.e(mediaFormat);
            boolean z = mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top");
            int integer2 = z ? (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1 : mediaFormat.getInteger("width");
            integer = z ? (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1 : mediaFormat.getInteger("height");
            i = integer2;
        }
        float f = z0Var.v;
        if (H1()) {
            int i3 = z0Var.u;
            if (i3 == 90 || i3 == 270) {
                f = 1.0f / f;
                int i4 = integer;
                integer = i;
                i = i4;
            }
        } else if (!this.O0.f()) {
            i2 = z0Var.u;
        }
        this.n1 = new C(i, integer, i2, f);
        this.M0.g(z0Var.t);
        if (this.O0.f()) {
            this.O0.o(z0Var.b().n0(i).S(integer).f0(i2).c0(f).G());
        }
    }

    public void Q0(long j) {
        super.Q0(j);
        if (this.p1) {
            return;
        }
        this.h1--;
    }

    public b Q1(p3.t tVar, z0 z0Var, z0[] z0VarArr) {
        int O1;
        int i = z0Var.r;
        int i2 = z0Var.s;
        int S1 = S1(tVar, z0Var);
        if (z0VarArr.length == 1) {
            if (S1 != -1 && (O1 = O1(tVar, z0Var)) != -1) {
                S1 = Math.min((int) (S1 * 1.5f), O1);
            }
            return new b(i, i2, S1);
        }
        int length = z0VarArr.length;
        boolean z = false;
        for (int i3 = 0; i3 < length; i3++) {
            z0 z0Var2 = z0VarArr[i3];
            if (z0Var.y != null && z0Var2.y == null) {
                z0Var2 = z0Var2.b().L(z0Var.y).G();
            }
            if (tVar.f(z0Var, z0Var2).d != 0) {
                int i4 = z0Var2.r;
                z |= i4 == -1 || z0Var2.s == -1;
                i = Math.max(i, i4);
                i2 = Math.max(i2, z0Var2.s);
                S1 = Math.max(S1, S1(tVar, z0Var2));
            }
        }
        if (z) {
            d4.B.j("MediaCodecVideoRenderer", "Resolutions unknown. Codec max resolution: " + i + "x" + i2);
            Point P1 = P1(tVar, z0Var);
            if (P1 != null) {
                i = Math.max(i, P1.x);
                i2 = Math.max(i2, P1.y);
                S1 = Math.max(S1, O1(tVar, z0Var.b().n0(i).S(i2).G()));
                d4.B.j("MediaCodecVideoRenderer", "Codec max resolution adjusted to: " + i + "x" + i2);
            }
        }
        return new b(i, i2, S1);
    }

    public void R0() {
        super.R0();
        F1();
    }

    public void S0(U2.g gVar) {
        boolean z = this.p1;
        if (!z) {
            this.h1++;
        }
        if (k0.a >= 23 || !z) {
            return;
        }
        f2(gVar.f);
    }

    public void T0(z0 z0Var) {
        if (this.O0.f()) {
            return;
        }
        this.O0.h(z0Var, x0());
    }

    public U2.h U(p3.t tVar, z0 z0Var, z0 z0Var2) {
        U2.h f = tVar.f(z0Var, z0Var2);
        int i = f.e;
        int i2 = z0Var2.r;
        b bVar = this.S0;
        if (i2 > bVar.a || z0Var2.s > bVar.b) {
            i |= 256;
        }
        if (S1(tVar, z0Var2) > this.S0.c) {
            i |= 64;
        }
        int i3 = i;
        return new U2.h(tVar.a, z0Var, z0Var2, i3 != 0 ? 0 : f.d, i3);
    }

    public MediaFormat U1(z0 z0Var, String str, b bVar, float f, boolean z, int i) {
        Pair r;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger("width", z0Var.r);
        mediaFormat.setInteger("height", z0Var.s);
        E.e(mediaFormat, z0Var.o);
        E.c(mediaFormat, "frame-rate", z0Var.t);
        E.d(mediaFormat, "rotation-degrees", z0Var.u);
        E.b(mediaFormat, z0Var.y);
        if ("video/dolby-vision".equals(z0Var.m) && (r = p3.B.r(z0Var)) != null) {
            E.d(mediaFormat, "profile", ((Integer) r.first).intValue());
        }
        mediaFormat.setInteger("max-width", bVar.a);
        mediaFormat.setInteger("max-height", bVar.b);
        E.d(mediaFormat, "max-input-size", bVar.c);
        if (k0.a >= 23) {
            mediaFormat.setInteger("priority", 0);
            if (f != -1.0f) {
                mediaFormat.setFloat("operating-rate", f);
            }
        }
        if (z) {
            mediaFormat.setInteger("no-post-process", 1);
            mediaFormat.setInteger("auto-frc", 0);
        }
        if (i != 0) {
            J1(mediaFormat, i);
        }
        return mediaFormat;
    }

    public boolean V0(long j, long j2, p3.m mVar, ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, z0 z0Var) {
        d4.a.e(mVar);
        if (this.c1 == -9223372036854775807L) {
            this.c1 = j;
        }
        if (j3 != this.i1) {
            if (!this.O0.f()) {
                this.M0.h(j3);
            }
            this.i1 = j3;
        }
        long x0 = j3 - x0();
        if (z && !z2) {
            u2(mVar, i, x0);
            return true;
        }
        boolean z3 = false;
        boolean z4 = getState() == 2;
        long E1 = E1(j, j2, SystemClock.elapsedRealtime() * 1000, j3, z4);
        if (this.V0 == this.W0) {
            if (!V1(E1)) {
                return false;
            }
            u2(mVar, i, x0);
            w2(E1);
            return true;
        }
        if (r2(j, E1)) {
            if (!this.O0.f()) {
                z3 = true;
            } else if (!this.O0.i(z0Var, x0, z2)) {
                return false;
            }
            j2(mVar, z0Var, i, x0, z3);
            w2(E1);
            return true;
        }
        if (z4 && j != this.c1) {
            long nanoTime = System.nanoTime();
            long b2 = this.M0.b((E1 * 1000) + nanoTime);
            if (!this.O0.f()) {
                E1 = (b2 - nanoTime) / 1000;
            }
            boolean z5 = this.d1 != -9223372036854775807L;
            if (p2(E1, j2, z2) && X1(j, z5)) {
                return false;
            }
            if (q2(E1, j2, z2)) {
                if (z5) {
                    u2(mVar, i, x0);
                } else {
                    L1(mVar, i, x0);
                }
                w2(E1);
                return true;
            }
            if (this.O0.f()) {
                this.O0.l(j, j2);
                if (!this.O0.i(z0Var, x0, z2)) {
                    return false;
                }
                j2(mVar, z0Var, i, x0, false);
                return true;
            }
            if (k0.a >= 21) {
                if (E1 < 50000) {
                    if (b2 == this.m1) {
                        u2(mVar, i, x0);
                    } else {
                        e2(x0, b2, z0Var);
                        k2(mVar, i, x0, b2);
                    }
                    w2(E1);
                    this.m1 = b2;
                    return true;
                }
            } else if (E1 < 30000) {
                if (E1 > 11000) {
                    try {
                        Thread.sleep((E1 - 10000) / 1000);
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        return false;
                    }
                }
                e2(x0, b2, z0Var);
                i2(mVar, i, x0);
                w2(E1);
                return true;
            }
        }
        return false;
    }

    public boolean X1(long j, boolean z) {
        int R = R(j);
        if (R == 0) {
            return false;
        }
        if (z) {
            U2.e eVar = this.G0;
            eVar.d += R;
            eVar.f += this.h1;
        } else {
            this.G0.j++;
            v2(R, this.h1);
        }
        n0();
        if (this.O0.f()) {
            this.O0.c();
        }
        return true;
    }

    public final void Y1() {
        if (this.f1 > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.N0.n(this.f1, elapsedRealtime - this.e1);
            this.f1 = 0;
            this.e1 = elapsedRealtime;
        }
    }

    public void Z1() {
        this.b1 = true;
        if (this.Z0) {
            return;
        }
        this.Z0 = true;
        this.N0.A(this.V0);
        this.X0 = true;
    }

    public final void a2() {
        int i = this.l1;
        if (i != 0) {
            this.N0.B(this.k1, i);
            this.k1 = 0L;
            this.l1 = 0;
        }
    }

    public void b1() {
        super.b1();
        this.h1 = 0;
    }

    public final void b2(C c2) {
        if (c2.equals(C.f) || c2.equals(this.o1)) {
            return;
        }
        this.o1 = c2;
        this.N0.D(c2);
    }

    public final void c2() {
        if (this.X0) {
            this.N0.A(this.V0);
        }
    }

    public boolean d() {
        boolean d2 = super.d();
        return this.O0.f() ? d2 & this.O0.m() : d2;
    }

    public final void d2() {
        C c2 = this.o1;
        if (c2 != null) {
            this.N0.D(c2);
        }
    }

    public boolean e() {
        j jVar;
        if (super.e() && ((!this.O0.f() || this.O0.g()) && (this.Z0 || (((jVar = this.W0) != null && this.V0 == jVar) || q0() == null || this.p1)))) {
            this.d1 = -9223372036854775807L;
            return true;
        }
        if (this.d1 == -9223372036854775807L) {
            return false;
        }
        if (SystemClock.elapsedRealtime() < this.d1) {
            return true;
        }
        this.d1 = -9223372036854775807L;
        return false;
    }

    public p3.n e0(Throwable th, p3.t tVar) {
        return new h(th, tVar, this.V0);
    }

    public final void e2(long j, long j2, z0 z0Var) {
        m mVar = this.s1;
        if (mVar != null) {
            mVar.a(j, j2, z0Var, u0());
        }
    }

    public void f2(long j) {
        s1(j);
        b2(this.n1);
        this.G0.e++;
        Z1();
        Q0(j);
    }

    public final void g2() {
        h1();
    }

    public String getName() {
        return "MediaCodecVideoRenderer";
    }

    public final void h2() {
        Surface surface = this.V0;
        j jVar = this.W0;
        if (surface == jVar) {
            this.V0 = null;
        }
        jVar.release();
        this.W0 = null;
    }

    public void i2(p3.m mVar, int i, long j) {
        a0.a("releaseOutputBuffer");
        mVar.m(i, true);
        a0.c();
        this.G0.e++;
        this.g1 = 0;
        if (this.O0.f()) {
            return;
        }
        this.j1 = SystemClock.elapsedRealtime() * 1000;
        b2(this.n1);
        Z1();
    }

    public final void j2(p3.m mVar, z0 z0Var, int i, long j, boolean z) {
        long d2 = this.O0.f() ? this.O0.d(j, x0()) * 1000 : System.nanoTime();
        if (z) {
            e2(j, d2, z0Var);
        }
        if (k0.a >= 21) {
            k2(mVar, i, j, d2);
        } else {
            i2(mVar, i, j);
        }
    }

    public void k2(p3.m mVar, int i, long j, long j2) {
        a0.a("releaseOutputBuffer");
        mVar.j(i, j2);
        a0.c();
        this.G0.e++;
        this.g1 = 0;
        if (this.O0.f()) {
            return;
        }
        this.j1 = SystemClock.elapsedRealtime() * 1000;
        b2(this.n1);
        Z1();
    }

    public boolean l1(p3.t tVar) {
        return this.V0 != null || t2(tVar);
    }

    public final void m2() {
        this.d1 = this.P0 > 0 ? SystemClock.elapsedRealtime() + this.P0 : -9223372036854775807L;
    }

    public void n(int i, Object obj) {
        Surface surface;
        if (i == 1) {
            n2(obj);
            return;
        }
        if (i == 7) {
            this.s1 = (m) obj;
            return;
        }
        if (i == 10) {
            int intValue = ((Integer) obj).intValue();
            if (this.q1 != intValue) {
                this.q1 = intValue;
                if (this.p1) {
                    Z0();
                    return;
                }
                return;
            }
            return;
        }
        if (i == 4) {
            this.Y0 = ((Integer) obj).intValue();
            p3.m q0 = q0();
            if (q0 != null) {
                q0.d(this.Y0);
                return;
            }
            return;
        }
        if (i == 5) {
            this.M0.o(((Integer) obj).intValue());
            return;
        }
        if (i == 13) {
            this.O0.q((List) d4.a.e(obj));
            return;
        }
        if (i != 14) {
            super.n(i, obj);
            return;
        }
        S s = (S) d4.a.e(obj);
        if (s.b() == 0 || s.a() == 0 || (surface = this.V0) == null) {
            return;
        }
        this.O0.p(surface, s);
    }

    public int o1(p3.w wVar, z0 z0Var) {
        boolean z;
        int i = 0;
        if (!F.s(z0Var.m)) {
            return D1.a(0);
        }
        boolean z2 = z0Var.p != null;
        List R1 = R1(this.L0, wVar, z0Var, z2, false);
        if (z2 && R1.isEmpty()) {
            R1 = R1(this.L0, wVar, z0Var, false, false);
        }
        if (R1.isEmpty()) {
            return D1.a(1);
        }
        if (!p3.u.p1(z0Var)) {
            return D1.a(2);
        }
        p3.t tVar = (p3.t) R1.get(0);
        boolean o = tVar.o(z0Var);
        if (o) {
            z = true;
        } else {
            for (int i2 = 1; i2 < R1.size(); i2++) {
                p3.t tVar2 = (p3.t) R1.get(i2);
                if (tVar2.o(z0Var)) {
                    tVar = tVar2;
                    z = false;
                    o = true;
                    break;
                }
            }
            z = true;
        }
        int i3 = o ? 4 : 3;
        int i4 = tVar.r(z0Var) ? 16 : 8;
        int i5 = tVar.h ? 64 : 0;
        int i6 = z ? 128 : 0;
        if (k0.a >= 26 && "video/dolby-vision".equals(z0Var.m) && !a.a(this.L0)) {
            i6 = 256;
        }
        if (o) {
            List R12 = R1(this.L0, wVar, z0Var, z2, true);
            if (!R12.isEmpty()) {
                p3.t tVar3 = (p3.t) p3.B.w(R12, z0Var).get(0);
                if (tVar3.o(z0Var) && tVar3.r(z0Var)) {
                    i = 32;
                }
            }
        }
        return D1.c(i3, i4, i, i5, i6);
    }

    public void o2(p3.m mVar, Surface surface) {
        mVar.f(surface);
    }

    public boolean p2(long j, long j2, boolean z) {
        return W1(j) && !z;
    }

    public boolean q2(long j, long j2, boolean z) {
        return V1(j) && !z;
    }

    public final boolean r2(long j, long j2) {
        boolean z = getState() == 2;
        boolean z2 = this.b1 ? !this.Z0 : z || this.a1;
        long elapsedRealtime = (SystemClock.elapsedRealtime() * 1000) - this.j1;
        if (this.d1 != -9223372036854775807L || j < x0()) {
            return false;
        }
        return z2 || (z && s2(j2, elapsedRealtime));
    }

    public void s(float f, float f2) {
        super.s(f, f2);
        this.M0.i(f);
    }

    public boolean s0() {
        return this.p1 && k0.a < 23;
    }

    public boolean s2(long j, long j2) {
        return V1(j) && j2 > 100000;
    }

    public float t0(float f, z0 z0Var, z0[] z0VarArr) {
        float f2 = -1.0f;
        for (z0 z0Var2 : z0VarArr) {
            float f3 = z0Var2.t;
            if (f3 != -1.0f) {
                f2 = Math.max(f2, f3);
            }
        }
        if (f2 == -1.0f) {
            return -1.0f;
        }
        return f2 * f;
    }

    public final boolean t2(p3.t tVar) {
        return k0.a >= 23 && !this.p1 && !I1(tVar.a) && (!tVar.g || j.c(this.L0));
    }

    public void u(long j, long j2) {
        super.u(j, j2);
        if (this.O0.f()) {
            this.O0.l(j, j2);
        }
    }

    public void u2(p3.m mVar, int i, long j) {
        a0.a("skipVideoBuffer");
        mVar.m(i, false);
        a0.c();
        this.G0.f++;
    }

    public List v0(p3.w wVar, z0 z0Var, boolean z) {
        return p3.B.w(R1(this.L0, wVar, z0Var, z, this.p1), z0Var);
    }

    public void v2(int i, int i2) {
        U2.e eVar = this.G0;
        eVar.h += i;
        int i3 = i + i2;
        eVar.g += i3;
        this.f1 += i3;
        int i4 = this.g1 + i3;
        this.g1 = i4;
        eVar.i = Math.max(i4, eVar.i);
        int i5 = this.Q0;
        if (i5 <= 0 || this.f1 < i5) {
            return;
        }
        Y1();
    }

    public m.a w0(p3.t tVar, z0 z0Var, MediaCrypto mediaCrypto, float f) {
        j jVar = this.W0;
        if (jVar != null && jVar.a != tVar.g) {
            h2();
        }
        String str = tVar.c;
        b Q1 = Q1(tVar, z0Var, E());
        this.S0 = Q1;
        MediaFormat U1 = U1(z0Var, str, Q1, f, this.R0, this.p1 ? this.q1 : 0);
        if (this.V0 == null) {
            if (!t2(tVar)) {
                throw new IllegalStateException();
            }
            if (this.W0 == null) {
                this.W0 = j.d(this.L0, tVar.g);
            }
            this.V0 = this.W0;
        }
        if (this.O0.f()) {
            U1 = this.O0.a(U1);
        }
        return m.a.b(tVar, U1, z0Var, this.O0.f() ? this.O0.e() : this.V0, mediaCrypto);
    }

    public void w2(long j) {
        this.G0.a(j);
        this.k1 += j;
        this.l1++;
    }

    public void z0(U2.g gVar) {
        if (this.U0) {
            ByteBuffer byteBuffer = (ByteBuffer) d4.a.e(gVar.g);
            if (byteBuffer.remaining() >= 7) {
                byte b2 = byteBuffer.get();
                short s = byteBuffer.getShort();
                short s2 = byteBuffer.getShort();
                byte b3 = byteBuffer.get();
                byte b4 = byteBuffer.get();
                byteBuffer.position(0);
                if (b2 == -75 && s == 60 && s2 == 1 && b3 == 4) {
                    if (b4 == 0 || b4 == 1) {
                        byte[] bArr = new byte[byteBuffer.remaining()];
                        byteBuffer.get(bArr);
                        byteBuffer.position(0);
                        l2(q0(), bArr);
                    }
                }
            }
        }
    }

    public i(Context context, m.b bVar, p3.w wVar, long j, boolean z, Handler handler, A a2, int i, float f) {
        super(2, bVar, wVar, z, f);
        this.P0 = j;
        this.Q0 = i;
        Context applicationContext = context.getApplicationContext();
        this.L0 = applicationContext;
        o oVar = new o(applicationContext);
        this.M0 = oVar;
        this.N0 = new A.a(handler, a2);
        this.O0 = new d(oVar, this);
        this.R0 = K1();
        this.d1 = -9223372036854775807L;
        this.Y0 = 1;
        this.n1 = C.f;
        this.q1 = 0;
        G1();
    }
}
