package Q2;

import O2.A0;
import O2.C1;
import O2.D1;
import O2.s1;
import O2.z0;
import Q2.B;
import Q2.z;
import android.content.Context;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import com.google.ads.interactivemedia.v3.internal.u1;
import java.nio.ByteBuffer;
import java.util.List;
import p3.m;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class a0 extends p3.u implements d4.D {
    public final Context L0;
    public final z.a M0;
    public final B N0;
    public int O0;
    public boolean P0;
    public z0 Q0;
    public z0 R0;
    public long S0;
    public boolean T0;
    public boolean U0;
    public boolean V0;
    public boolean W0;
    public C1.a X0;

    public static final class b {
        public static void a(B b, Object obj) {
            b.e(u1.a(obj));
        }
    }

    public final class c implements B.c {
        public c() {
        }

        public void a(boolean z) {
            a0.t1(a0.this).C(z);
        }

        public void b(Exception exc) {
            d4.B.e("MediaCodecAudioRenderer", "Audio sink error", exc);
            a0.t1(a0.this).l(exc);
        }

        public void c(long j) {
            a0.t1(a0.this).B(j);
        }

        public void d() {
            if (a0.u1(a0.this) != null) {
                a0.u1(a0.this).a();
            }
        }

        public void e(int i, long j, long j2) {
            a0.t1(a0.this).D(i, j, j2);
        }

        public void f() {
            a0.v1(a0.this);
        }

        public void g() {
            a0.this.C1();
        }

        public void h() {
            if (a0.u1(a0.this) != null) {
                a0.u1(a0.this).b();
            }
        }

        public /* synthetic */ c(a0 a0Var, a aVar) {
            this();
        }
    }

    public a0(Context context, m.b bVar, p3.w wVar, boolean z, Handler handler, z zVar, B b2) {
        super(1, bVar, wVar, z, 44100.0f);
        this.L0 = context.getApplicationContext();
        this.N0 = b2;
        this.M0 = new z.a(handler, zVar);
        b2.k(new c(this, null));
    }

    public static List A1(p3.w wVar, z0 z0Var, boolean z, B b2) {
        p3.t x;
        return z0Var.m == null ? s5.y.z() : (!b2.a(z0Var) || (x = p3.B.x()) == null) ? p3.B.v(wVar, z0Var, z, false) : s5.y.A(x);
    }

    private void D1() {
        long p = this.N0.p(d());
        if (p != Long.MIN_VALUE) {
            if (!this.U0) {
                p = Math.max(this.S0, p);
            }
            this.S0 = p;
            this.U0 = false;
        }
    }

    public static /* synthetic */ z.a t1(a0 a0Var) {
        return a0Var.M0;
    }

    public static /* synthetic */ C1.a u1(a0 a0Var) {
        return a0Var.X0;
    }

    public static /* synthetic */ void v1(a0 a0Var) {
        a0Var.K();
    }

    public static boolean w1(String str) {
        if (d4.k0.a < 24 && "OMX.SEC.aac.dec".equals(str) && "samsung".equals(d4.k0.c)) {
            String str2 = d4.k0.b;
            if (str2.startsWith("zeroflte") || str2.startsWith("herolte") || str2.startsWith("heroqlte")) {
                return true;
            }
        }
        return false;
    }

    public static boolean x1() {
        if (d4.k0.a == 23) {
            String str = d4.k0.d;
            if ("ZTE B2017G".equals(str) || "AXON 7 mini".equals(str)) {
                return true;
            }
        }
        return false;
    }

    private int y1(p3.t tVar, z0 z0Var) {
        int i;
        if (!"OMX.google.raw.decoder".equals(tVar.a) || (i = d4.k0.a) >= 24 || (i == 23 && d4.k0.I0(this.L0))) {
            return z0Var.n;
        }
        return -1;
    }

    public MediaFormat B1(z0 z0Var, String str, int i, float f) {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger("channel-count", z0Var.z);
        mediaFormat.setInteger("sample-rate", z0Var.A);
        d4.E.e(mediaFormat, z0Var.o);
        d4.E.d(mediaFormat, "max-input-size", i);
        int i2 = d4.k0.a;
        if (i2 >= 23) {
            mediaFormat.setInteger("priority", 0);
            if (f != -1.0f && !x1()) {
                mediaFormat.setFloat("operating-rate", f);
            }
        }
        if (i2 <= 28 && "audio/ac4".equals(z0Var.m)) {
            mediaFormat.setInteger("ac4-is-sync", 1);
        }
        if (i2 >= 24 && this.N0.j(d4.k0.i0(4, z0Var.z, z0Var.A)) == 2) {
            mediaFormat.setInteger("pcm-encoding", 4);
        }
        if (i2 >= 32) {
            mediaFormat.setInteger("max-output-channel-count", 99);
        }
        return mediaFormat;
    }

    public void C1() {
        this.U0 = true;
    }

    public void G() {
        this.V0 = true;
        this.Q0 = null;
        try {
            this.N0.flush();
            try {
                super.G();
            } finally {
            }
        } catch (Throwable th) {
            try {
                super.G();
                throw th;
            } finally {
            }
        }
    }

    public void H(boolean z, boolean z2) {
        super.H(z, z2);
        this.M0.p(this.G0);
        if (A().a) {
            this.N0.s();
        } else {
            this.N0.h();
        }
        this.N0.i(D());
    }

    public void I(long j, boolean z) {
        super.I(j, z);
        if (this.W0) {
            this.N0.n();
        } else {
            this.N0.flush();
        }
        this.S0 = j;
        this.T0 = true;
        this.U0 = true;
    }

    public void J() {
        this.N0.release();
    }

    public void K0(Exception exc) {
        d4.B.e("MediaCodecAudioRenderer", "Audio codec error", exc);
        this.M0.k(exc);
    }

    public void L() {
        try {
            super.L();
        } finally {
            if (this.V0) {
                this.V0 = false;
                this.N0.reset();
            }
        }
    }

    public void L0(String str, m.a aVar, long j, long j2) {
        this.M0.m(str, j, j2);
    }

    public void M() {
        super.M();
        this.N0.play();
    }

    public void M0(String str) {
        this.M0.n(str);
    }

    public void N() {
        D1();
        this.N0.pause();
        super.N();
    }

    public U2.h N0(A0 a0) {
        this.Q0 = (z0) d4.a.e(a0.b);
        U2.h N0 = super.N0(a0);
        this.M0.q(this.Q0, N0);
        return N0;
    }

    public void O0(z0 z0Var, MediaFormat mediaFormat) {
        int i;
        z0 z0Var2 = this.R0;
        int[] iArr = null;
        if (z0Var2 != null) {
            z0Var = z0Var2;
        } else if (q0() != null) {
            z0 G = new z0.b().g0("audio/raw").a0("audio/raw".equals(z0Var.m) ? z0Var.B : (d4.k0.a < 24 || !mediaFormat.containsKey("pcm-encoding")) ? mediaFormat.containsKey("v-bits-per-sample") ? d4.k0.h0(mediaFormat.getInteger("v-bits-per-sample")) : 2 : mediaFormat.getInteger("pcm-encoding")).P(z0Var.C).Q(z0Var.D).J(mediaFormat.getInteger("channel-count")).h0(mediaFormat.getInteger("sample-rate")).G();
            if (this.P0 && G.z == 6 && (i = z0Var.z) < 6) {
                iArr = new int[i];
                for (int i2 = 0; i2 < z0Var.z; i2++) {
                    iArr[i2] = i2;
                }
            }
            z0Var = G;
        }
        try {
            this.N0.u(z0Var, 0, iArr);
        } catch (B.a e) {
            throw y(e, e.a, 5001);
        }
    }

    public void P0(long j) {
        this.N0.q(j);
    }

    public void R0() {
        super.R0();
        this.N0.r();
    }

    public void S0(U2.g gVar) {
        if (!this.T0 || gVar.isDecodeOnly()) {
            return;
        }
        if (Math.abs(gVar.f - this.S0) > 500000) {
            this.S0 = gVar.f;
        }
        this.T0 = false;
    }

    public U2.h U(p3.t tVar, z0 z0Var, z0 z0Var2) {
        U2.h f = tVar.f(z0Var, z0Var2);
        int i = f.e;
        if (D0(z0Var2)) {
            i |= 32768;
        }
        if (y1(tVar, z0Var2) > this.O0) {
            i |= 64;
        }
        int i2 = i;
        return new U2.h(tVar.a, z0Var, z0Var2, i2 != 0 ? 0 : f.d, i2);
    }

    public boolean V0(long j, long j2, p3.m mVar, ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, z0 z0Var) {
        d4.a.e(byteBuffer);
        if (this.R0 != null && (i2 & 2) != 0) {
            ((p3.m) d4.a.e(mVar)).m(i, false);
            return true;
        }
        if (z) {
            if (mVar != null) {
                mVar.m(i, false);
            }
            this.G0.f += i3;
            this.N0.r();
            return true;
        }
        try {
            if (!this.N0.l(byteBuffer, j3, i3)) {
                return false;
            }
            if (mVar != null) {
                mVar.m(i, false);
            }
            this.G0.e += i3;
            return true;
        } catch (B.b e) {
            throw z(e, this.Q0, e.c, 5001);
        } catch (B.e e2) {
            throw z(e2, z0Var, e2.c, 5002);
        }
    }

    public void a1() {
        try {
            this.N0.o();
        } catch (B.e e) {
            throw z(e, e.d, e.c, 5002);
        }
    }

    public void b(s1 s1Var) {
        this.N0.b(s1Var);
    }

    public s1 c() {
        return this.N0.c();
    }

    public boolean d() {
        return super.d() && this.N0.d();
    }

    public boolean e() {
        return this.N0.f() || super.e();
    }

    public String getName() {
        return "MediaCodecAudioRenderer";
    }

    public void n(int i, Object obj) {
        if (i == 2) {
            this.N0.setVolume(((Float) obj).floatValue());
        }
        if (i == 3) {
            this.N0.t((e) obj);
            return;
        }
        if (i == 6) {
            this.N0.m((F) obj);
            return;
        }
        switch (i) {
            case 9:
                this.N0.v(((Boolean) obj).booleanValue());
                break;
            case 10:
                this.N0.g(((Integer) obj).intValue());
                break;
            case 11:
                this.X0 = (C1.a) obj;
                break;
            case 12:
                if (d4.k0.a >= 23) {
                    b.a(this.N0, obj);
                    break;
                }
                break;
            default:
                super.n(i, obj);
                break;
        }
    }

    public boolean n1(z0 z0Var) {
        return this.N0.a(z0Var);
    }

    public int o1(p3.w wVar, z0 z0Var) {
        boolean z;
        if (!d4.F.o(z0Var.m)) {
            return D1.a(0);
        }
        int i = d4.k0.a >= 21 ? 32 : 0;
        boolean z2 = true;
        boolean z3 = z0Var.H != 0;
        boolean p1 = p3.u.p1(z0Var);
        int i2 = 8;
        if (p1 && this.N0.a(z0Var) && (!z3 || p3.B.x() != null)) {
            return D1.b(4, 8, i);
        }
        if ("audio/raw".equals(z0Var.m) && !this.N0.a(z0Var)) {
            return D1.a(1);
        }
        if (!this.N0.a(d4.k0.i0(2, z0Var.z, z0Var.A))) {
            return D1.a(1);
        }
        List A1 = A1(wVar, z0Var, false, this.N0);
        if (A1.isEmpty()) {
            return D1.a(1);
        }
        if (!p1) {
            return D1.a(2);
        }
        p3.t tVar = (p3.t) A1.get(0);
        boolean o = tVar.o(z0Var);
        if (o) {
            z2 = o;
            z = true;
        } else {
            for (int i3 = 1; i3 < A1.size(); i3++) {
                p3.t tVar2 = (p3.t) A1.get(i3);
                if (tVar2.o(z0Var)) {
                    tVar = tVar2;
                    z = false;
                    break;
                }
            }
            z2 = o;
            z = true;
        }
        int i4 = z2 ? 4 : 3;
        if (z2 && tVar.r(z0Var)) {
            i2 = 16;
        }
        return D1.c(i4, i2, i, tVar.h ? 64 : 0, z ? 128 : 0);
    }

    public long r() {
        if (getState() == 2) {
            D1();
        }
        return this.S0;
    }

    public float t0(float f, z0 z0Var, z0[] z0VarArr) {
        int i = -1;
        for (z0 z0Var2 : z0VarArr) {
            int i2 = z0Var2.A;
            if (i2 != -1) {
                i = Math.max(i, i2);
            }
        }
        if (i == -1) {
            return -1.0f;
        }
        return f * i;
    }

    public List v0(p3.w wVar, z0 z0Var, boolean z) {
        return p3.B.w(A1(wVar, z0Var, z, this.N0), z0Var);
    }

    public m.a w0(p3.t tVar, z0 z0Var, MediaCrypto mediaCrypto, float f) {
        this.O0 = z1(tVar, z0Var, E());
        this.P0 = w1(tVar.a);
        MediaFormat B1 = B1(z0Var, tVar.c, this.O0, f);
        this.R0 = (!"audio/raw".equals(tVar.b) || "audio/raw".equals(z0Var.m)) ? null : z0Var;
        return m.a.a(tVar, B1, z0Var, mediaCrypto);
    }

    public int z1(p3.t tVar, z0 z0Var, z0[] z0VarArr) {
        int y1 = y1(tVar, z0Var);
        if (z0VarArr.length == 1) {
            return y1;
        }
        for (z0 z0Var2 : z0VarArr) {
            if (tVar.f(z0Var, z0Var2).d != 0) {
                y1 = Math.max(y1, y1(tVar, z0Var2));
            }
        }
        return y1;
    }

    public d4.D x() {
        return this;
    }
}
