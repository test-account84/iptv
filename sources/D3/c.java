package d3;

import O2.w0;
import d4.k0;
import java.io.EOFException;
import java.io.InterruptedIOException;
import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class c implements j {
    public final b4.k b;
    public final long c;
    public long d;
    public int f;
    public int g;
    public byte[] e = new byte[65536];
    public final byte[] a = new byte[4096];

    static {
        w0.a("goog.exo.extractor");
    }

    public c(b4.k kVar, long j, long j2) {
        this.b = kVar;
        this.d = j;
        this.c = j2;
    }

    public int b(int i) {
        int w = w(i);
        if (w == 0) {
            byte[] bArr = this.a;
            w = v(bArr, 0, Math.min(i, bArr.length), 0, true);
        }
        j(w);
        return w;
    }

    public boolean d(byte[] bArr, int i, int i2, boolean z) {
        if (!r(i2, z)) {
            return false;
        }
        System.arraycopy(this.e, this.f - i2, bArr, i, i2);
        return true;
    }

    public void f() {
        this.f = 0;
    }

    public long getLength() {
        return this.c;
    }

    public long getPosition() {
        return this.d;
    }

    public boolean h(byte[] bArr, int i, int i2, boolean z) {
        int u = u(bArr, i, i2);
        while (u < i2 && u != -1) {
            u = v(bArr, i, i2, u, z);
        }
        j(u);
        return u != -1;
    }

    public final void j(int i) {
        if (i != -1) {
            this.d += i;
        }
    }

    public long k() {
        return this.d + this.f;
    }

    public void m(byte[] bArr, int i, int i2) {
        h(bArr, i, i2, false);
    }

    public void n(int i) {
        r(i, false);
    }

    public void o(long j, Throwable th) {
        d4.a.a(j >= 0);
        this.d = j;
        throw th;
    }

    public int p(byte[] bArr, int i, int i2) {
        int min;
        t(i2);
        int i3 = this.g;
        int i4 = this.f;
        int i5 = i3 - i4;
        if (i5 == 0) {
            min = v(this.e, i4, i2, 0, true);
            if (min == -1) {
                return -1;
            }
            this.g += min;
        } else {
            min = Math.min(i2, i5);
        }
        System.arraycopy(this.e, this.f, bArr, i, min);
        this.f += min;
        return min;
    }

    public void q(int i) {
        x(i, false);
    }

    public boolean r(int i, boolean z) {
        t(i);
        int i2 = this.g - this.f;
        while (i2 < i) {
            i2 = v(this.e, this.f, i, i2, z);
            if (i2 == -1) {
                return false;
            }
            this.g = this.f + i2;
        }
        this.f += i;
        return true;
    }

    public int read(byte[] bArr, int i, int i2) {
        int u = u(bArr, i, i2);
        if (u == 0) {
            u = v(bArr, i, i2, 0, true);
        }
        j(u);
        return u;
    }

    public void s(byte[] bArr, int i, int i2) {
        d(bArr, i, i2, false);
    }

    public final void t(int i) {
        int i2 = this.f + i;
        byte[] bArr = this.e;
        if (i2 > bArr.length) {
            this.e = Arrays.copyOf(this.e, k0.r(bArr.length * 2, 65536 + i2, i2 + 524288));
        }
    }

    public final int u(byte[] bArr, int i, int i2) {
        int i3 = this.g;
        if (i3 == 0) {
            return 0;
        }
        int min = Math.min(i3, i2);
        System.arraycopy(this.e, 0, bArr, i, min);
        y(min);
        return min;
    }

    public final int v(byte[] bArr, int i, int i2, int i3, boolean z) {
        if (Thread.interrupted()) {
            throw new InterruptedIOException();
        }
        int read = this.b.read(bArr, i + i3, i2 - i3);
        if (read != -1) {
            return i3 + read;
        }
        if (i3 == 0 && z) {
            return -1;
        }
        throw new EOFException();
    }

    public final int w(int i) {
        int min = Math.min(this.g, i);
        y(min);
        return min;
    }

    public boolean x(int i, boolean z) {
        int w = w(i);
        while (w < i && w != -1) {
            w = v(this.a, -w, Math.min(i, this.a.length + w), w, z);
        }
        j(w);
        return w != -1;
    }

    public final void y(int i) {
        int i2 = this.g - i;
        this.g = i2;
        this.f = 0;
        byte[] bArr = this.e;
        byte[] bArr2 = i2 < bArr.length - 524288 ? new byte[65536 + i2] : bArr;
        System.arraycopy(bArr, i, bArr2, 0, i2);
        this.e = bArr2;
    }
}
