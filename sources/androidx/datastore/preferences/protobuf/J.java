package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.q0;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class j extends f {
    public static final Logger c = Logger.getLogger(j.class.getName());
    public static final boolean d = p0.C();
    public k a;
    public boolean b;

    public static abstract class b extends j {
        public final byte[] e;
        public final int f;
        public int g;
        public int h;

        public b(int i) {
            super(null);
            if (i < 0) {
                throw new IllegalArgumentException("bufferSize must be >= 0");
            }
            byte[] bArr = new byte[Math.max(i, 20)];
            this.e = bArr;
            this.f = bArr.length;
        }

        public final void S0(byte b) {
            byte[] bArr = this.e;
            int i = this.g;
            this.g = i + 1;
            bArr[i] = b;
            this.h++;
        }

        public final void T0(int i) {
            byte[] bArr = this.e;
            int i2 = this.g;
            bArr[i2] = (byte) (i & 255);
            bArr[i2 + 1] = (byte) ((i >> 8) & 255);
            bArr[i2 + 2] = (byte) ((i >> 16) & 255);
            this.g = i2 + 4;
            bArr[i2 + 3] = (byte) ((i >> 24) & 255);
            this.h += 4;
        }

        public final void U0(long j) {
            byte[] bArr = this.e;
            int i = this.g;
            bArr[i] = (byte) (j & 255);
            bArr[i + 1] = (byte) ((j >> 8) & 255);
            bArr[i + 2] = (byte) ((j >> 16) & 255);
            bArr[i + 3] = (byte) (255 & (j >> 24));
            bArr[i + 4] = (byte) (((int) (j >> 32)) & 255);
            bArr[i + 5] = (byte) (((int) (j >> 40)) & 255);
            bArr[i + 6] = (byte) (((int) (j >> 48)) & 255);
            this.g = i + 8;
            bArr[i + 7] = (byte) (((int) (j >> 56)) & 255);
            this.h += 8;
        }

        public final void V0(int i) {
            if (i >= 0) {
                X0(i);
            } else {
                Y0(i);
            }
        }

        public final void W0(int i, int i2) {
            X0(r0.c(i, i2));
        }

        public final void X0(int i) {
            if (!j.b()) {
                while ((i & (-128)) != 0) {
                    byte[] bArr = this.e;
                    int i2 = this.g;
                    this.g = i2 + 1;
                    bArr[i2] = (byte) ((i & 127) | 128);
                    this.h++;
                    i >>>= 7;
                }
                byte[] bArr2 = this.e;
                int i3 = this.g;
                this.g = i3 + 1;
                bArr2[i3] = (byte) i;
                this.h++;
                return;
            }
            long j = this.g;
            while ((i & (-128)) != 0) {
                byte[] bArr3 = this.e;
                int i4 = this.g;
                this.g = i4 + 1;
                p0.H(bArr3, i4, (byte) ((i & 127) | 128));
                i >>>= 7;
            }
            byte[] bArr4 = this.e;
            int i5 = this.g;
            this.g = i5 + 1;
            p0.H(bArr4, i5, (byte) i);
            this.h += (int) (this.g - j);
        }

        public final void Y0(long j) {
            if (!j.b()) {
                while ((j & (-128)) != 0) {
                    byte[] bArr = this.e;
                    int i = this.g;
                    this.g = i + 1;
                    bArr[i] = (byte) ((((int) j) & 127) | 128);
                    this.h++;
                    j >>>= 7;
                }
                byte[] bArr2 = this.e;
                int i2 = this.g;
                this.g = i2 + 1;
                bArr2[i2] = (byte) j;
                this.h++;
                return;
            }
            long j2 = this.g;
            while ((j & (-128)) != 0) {
                byte[] bArr3 = this.e;
                int i3 = this.g;
                this.g = i3 + 1;
                p0.H(bArr3, i3, (byte) ((((int) j) & 127) | 128));
                j >>>= 7;
            }
            byte[] bArr4 = this.e;
            int i4 = this.g;
            this.g = i4 + 1;
            p0.H(bArr4, i4, (byte) j);
            this.h += (int) (this.g - j2);
        }
    }

    public static class c extends IOException {
        public c(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }
    }

    public static final class d extends b {
        public final OutputStream i;

        public d(OutputStream outputStream, int i) {
            super(i);
            if (outputStream == null) {
                throw new NullPointerException("out");
            }
            this.i = outputStream;
        }

        public void A0(O o) {
            P0(o.d());
            o.g(this);
        }

        public void B0(int i, O o) {
            N0(1, 3);
            O0(2, i);
            c1(3, o);
            N0(1, 4);
        }

        public void C0(int i, g gVar) {
            N0(1, 3);
            O0(2, i);
            f0(3, gVar);
            N0(1, 4);
        }

        public void L0(int i, String str) {
            N0(i, 2);
            M0(str);
        }

        public void M0(String str) {
            int g;
            try {
                int length = str.length() * 3;
                int R = j.R(length);
                int i = R + length;
                int i2 = this.f;
                if (i > i2) {
                    byte[] bArr = new byte[length];
                    int f = q0.f(str, bArr, 0, length);
                    P0(f);
                    a(bArr, 0, f);
                    return;
                }
                if (i > i2 - this.g) {
                    Z0();
                }
                int R2 = j.R(str.length());
                int i3 = this.g;
                try {
                    if (R2 == R) {
                        int i4 = i3 + R2;
                        this.g = i4;
                        int f2 = q0.f(str, this.e, i4, this.f - i4);
                        this.g = i3;
                        g = (f2 - i3) - R2;
                        X0(g);
                        this.g = f2;
                    } else {
                        g = q0.g(str);
                        X0(g);
                        this.g = q0.f(str, this.e, this.g, g);
                    }
                    this.h += g;
                } catch (q0.d e) {
                    this.h -= this.g - i3;
                    this.g = i3;
                    throw e;
                } catch (ArrayIndexOutOfBoundsException e2) {
                    throw new c(e2);
                }
            } catch (q0.d e3) {
                X(str, e3);
            }
        }

        public void N0(int i, int i2) {
            P0(r0.c(i, i2));
        }

        public void O0(int i, int i2) {
            a1(20);
            W0(i, 0);
            X0(i2);
        }

        public void P0(int i) {
            a1(5);
            X0(i);
        }

        public void Q0(int i, long j) {
            a1(20);
            W0(i, 0);
            Y0(j);
        }

        public void R0(long j) {
            a1(10);
            Y0(j);
        }

        public void W() {
            if (this.g > 0) {
                Z0();
            }
        }

        public final void Z0() {
            this.i.write(this.e, 0, this.g);
            this.g = 0;
        }

        public void a(byte[] bArr, int i, int i2) {
            b1(bArr, i, i2);
        }

        public void a0(byte b) {
            if (this.g == this.f) {
                Z0();
            }
            S0(b);
        }

        public final void a1(int i) {
            if (this.f - this.g < i) {
                Z0();
            }
        }

        public void b0(int i, boolean z) {
            a1(11);
            W0(i, 0);
            S0(z ? (byte) 1 : (byte) 0);
        }

        public void b1(byte[] bArr, int i, int i2) {
            int i3 = this.f;
            int i4 = this.g;
            if (i3 - i4 >= i2) {
                System.arraycopy(bArr, i, this.e, i4, i2);
                this.g += i2;
            } else {
                int i5 = i3 - i4;
                System.arraycopy(bArr, i, this.e, i4, i5);
                int i6 = i + i5;
                i2 -= i5;
                this.g = this.f;
                this.h += i5;
                Z0();
                if (i2 <= this.f) {
                    System.arraycopy(bArr, i6, this.e, 0, i2);
                    this.g = i2;
                } else {
                    this.i.write(bArr, i6, i2);
                }
            }
            this.h += i2;
        }

        public void c1(int i, O o) {
            N0(i, 2);
            A0(o);
        }

        public void d1(O o, e0 e0Var) {
            P0(((androidx.datastore.preferences.protobuf.a) o).i(e0Var));
            e0Var.h(o, this.a);
        }

        public void e0(byte[] bArr, int i, int i2) {
            P0(i2);
            b1(bArr, i, i2);
        }

        public void f0(int i, g gVar) {
            N0(i, 2);
            g0(gVar);
        }

        public void g0(g gVar) {
            P0(gVar.size());
            gVar.z(this);
        }

        public void l0(int i, int i2) {
            a1(14);
            W0(i, 5);
            T0(i2);
        }

        public void m0(int i) {
            a1(4);
            T0(i);
        }

        public void n0(int i, long j) {
            a1(18);
            W0(i, 1);
            U0(j);
        }

        public void o0(long j) {
            a1(8);
            U0(j);
        }

        public void v0(int i, int i2) {
            a1(20);
            W0(i, 0);
            V0(i2);
        }

        public void w0(int i) {
            if (i >= 0) {
                P0(i);
            } else {
                R0(i);
            }
        }

        public void z0(int i, O o, e0 e0Var) {
            N0(i, 2);
            d1(o, e0Var);
        }
    }

    public j() {
    }

    public static int A(O o) {
        return y(o.d());
    }

    public static int B(O o, e0 e0Var) {
        return y(((androidx.datastore.preferences.protobuf.a) o).i(e0Var));
    }

    public static int C(int i) {
        if (i > 4096) {
            return 4096;
        }
        return i;
    }

    public static int D(int i, g gVar) {
        return (P(1) * 2) + Q(2, i) + f(3, gVar);
    }

    public static int E(int i) {
        return R(i);
    }

    public static int F(int i, int i2) {
        return P(i) + G(i2);
    }

    public static int G(int i) {
        return 4;
    }

    public static int H(int i, long j) {
        return P(i) + I(j);
    }

    public static int I(long j) {
        return 8;
    }

    public static int J(int i, int i2) {
        return P(i) + K(i2);
    }

    public static int K(int i) {
        return R(U(i));
    }

    public static int L(int i, long j) {
        return P(i) + M(j);
    }

    public static int M(long j) {
        return T(V(j));
    }

    public static int N(int i, String str) {
        return P(i) + O(str);
    }

    public static int O(String str) {
        int length;
        try {
            length = q0.g(str);
        } catch (q0.d unused) {
            length = str.getBytes(y.a).length;
        }
        return y(length);
    }

    public static int P(int i) {
        return R(r0.c(i, 0));
    }

    public static int Q(int i, int i2) {
        return P(i) + R(i2);
    }

    public static int R(int i) {
        if ((i & (-128)) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        return (i & (-268435456)) == 0 ? 4 : 5;
    }

    public static int S(int i, long j) {
        return P(i) + T(j);
    }

    public static int T(long j) {
        int i;
        if (((-128) & j) == 0) {
            return 1;
        }
        if (j < 0) {
            return 10;
        }
        if (((-34359738368L) & j) != 0) {
            j >>>= 28;
            i = 6;
        } else {
            i = 2;
        }
        if (((-2097152) & j) != 0) {
            i += 2;
            j >>>= 14;
        }
        return (j & (-16384)) != 0 ? i + 1 : i;
    }

    public static int U(int i) {
        return (i >> 31) ^ (i << 1);
    }

    public static long V(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public static j Z(OutputStream outputStream, int i) {
        return new d(outputStream, i);
    }

    public static /* synthetic */ boolean b() {
        return d;
    }

    public static int c(int i, boolean z) {
        return P(i) + d(z);
    }

    public static int d(boolean z) {
        return 1;
    }

    public static int e(byte[] bArr) {
        return y(bArr.length);
    }

    public static int f(int i, g gVar) {
        return P(i) + g(gVar);
    }

    public static int g(g gVar) {
        return y(gVar.size());
    }

    public static int h(int i, double d2) {
        return P(i) + i(d2);
    }

    public static int i(double d2) {
        return 8;
    }

    public static int j(int i, int i2) {
        return P(i) + k(i2);
    }

    public static int k(int i) {
        return v(i);
    }

    public static int l(int i, int i2) {
        return P(i) + m(i2);
    }

    public static int m(int i) {
        return 4;
    }

    public static int n(int i, long j) {
        return P(i) + o(j);
    }

    public static int o(long j) {
        return 8;
    }

    public static int p(int i, float f) {
        return P(i) + q(f);
    }

    public static int q(float f) {
        return 4;
    }

    public static int r(int i, O o, e0 e0Var) {
        return (P(i) * 2) + t(o, e0Var);
    }

    public static int s(O o) {
        return o.d();
    }

    public static int t(O o, e0 e0Var) {
        return ((androidx.datastore.preferences.protobuf.a) o).i(e0Var);
    }

    public static int u(int i, int i2) {
        return P(i) + v(i2);
    }

    public static int v(int i) {
        if (i >= 0) {
            return R(i);
        }
        return 10;
    }

    public static int w(int i, long j) {
        return P(i) + x(j);
    }

    public static int x(long j) {
        return T(j);
    }

    public static int y(int i) {
        return R(i) + i;
    }

    public static int z(int i, O o, e0 e0Var) {
        return P(i) + B(o, e0Var);
    }

    public abstract void A0(O o);

    public abstract void B0(int i, O o);

    public abstract void C0(int i, g gVar);

    public final void D0(int i, int i2) {
        l0(i, i2);
    }

    public final void E0(int i) {
        m0(i);
    }

    public final void F0(int i, long j) {
        n0(i, j);
    }

    public final void G0(long j) {
        o0(j);
    }

    public final void H0(int i, int i2) {
        O0(i, U(i2));
    }

    public final void I0(int i) {
        P0(U(i));
    }

    public final void J0(int i, long j) {
        Q0(i, V(j));
    }

    public final void K0(long j) {
        R0(V(j));
    }

    public abstract void L0(int i, String str);

    public abstract void M0(String str);

    public abstract void N0(int i, int i2);

    public abstract void O0(int i, int i2);

    public abstract void P0(int i);

    public abstract void Q0(int i, long j);

    public abstract void R0(long j);

    public abstract void W();

    public final void X(String str, q0.d dVar) {
        c.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", dVar);
        byte[] bytes = str.getBytes(y.a);
        try {
            P0(bytes.length);
            a(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e) {
            throw new c(e);
        } catch (c e2) {
            throw e2;
        }
    }

    public boolean Y() {
        return this.b;
    }

    public abstract void a(byte[] bArr, int i, int i2);

    public abstract void a0(byte b2);

    public abstract void b0(int i, boolean z);

    public final void c0(boolean z) {
        a0(z ? (byte) 1 : (byte) 0);
    }

    public final void d0(byte[] bArr) {
        e0(bArr, 0, bArr.length);
    }

    public abstract void e0(byte[] bArr, int i, int i2);

    public abstract void f0(int i, g gVar);

    public abstract void g0(g gVar);

    public final void h0(int i, double d2) {
        n0(i, Double.doubleToRawLongBits(d2));
    }

    public final void i0(double d2) {
        o0(Double.doubleToRawLongBits(d2));
    }

    public final void j0(int i, int i2) {
        v0(i, i2);
    }

    public final void k0(int i) {
        w0(i);
    }

    public abstract void l0(int i, int i2);

    public abstract void m0(int i);

    public abstract void n0(int i, long j);

    public abstract void o0(long j);

    public final void p0(int i, float f) {
        l0(i, Float.floatToRawIntBits(f));
    }

    public final void q0(float f) {
        m0(Float.floatToRawIntBits(f));
    }

    public final void r0(int i, O o) {
        N0(i, 3);
        t0(o);
        N0(i, 4);
    }

    public final void s0(int i, O o, e0 e0Var) {
        N0(i, 3);
        u0(o, e0Var);
        N0(i, 4);
    }

    public final void t0(O o) {
        o.g(this);
    }

    public final void u0(O o, e0 e0Var) {
        e0Var.h(o, this.a);
    }

    public abstract void v0(int i, int i2);

    public abstract void w0(int i);

    public final void x0(int i, long j) {
        Q0(i, j);
    }

    public final void y0(long j) {
        R0(j);
    }

    public abstract void z0(int i, O o, e0 e0Var);

    public /* synthetic */ j(a aVar) {
        this();
    }
}
