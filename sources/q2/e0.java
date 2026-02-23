package Q2;

import Q2.m;
import java.nio.ByteBuffer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class e0 extends G {
    public final long i;
    public final long j;
    public final short k;
    public int l;
    public boolean m;
    public byte[] n;
    public byte[] o;
    public int p;
    public int q;
    public int r;
    public boolean s;
    public long t;

    public e0() {
        this(150000L, 20000L, (short) 1024);
    }

    public void b(ByteBuffer byteBuffer) {
        while (byteBuffer.hasRemaining() && !f()) {
            int i = this.p;
            if (i == 0) {
                s(byteBuffer);
            } else if (i == 1) {
                r(byteBuffer);
            } else {
                if (i != 2) {
                    throw new IllegalStateException();
                }
                t(byteBuffer);
            }
        }
    }

    public m.a g(m.a aVar) {
        if (aVar.c == 2) {
            return this.m ? aVar : m.a.e;
        }
        throw new m.b(aVar);
    }

    public void h() {
        if (this.m) {
            this.l = this.b.d;
            int l = l(this.i) * this.l;
            if (this.n.length != l) {
                this.n = new byte[l];
            }
            int l2 = l(this.j) * this.l;
            this.r = l2;
            if (this.o.length != l2) {
                this.o = new byte[l2];
            }
        }
        this.p = 0;
        this.t = 0L;
        this.q = 0;
        this.s = false;
    }

    public void i() {
        int i = this.q;
        if (i > 0) {
            q(this.n, i);
        }
        if (this.s) {
            return;
        }
        this.t += this.r / this.l;
    }

    public boolean isActive() {
        return this.m;
    }

    public void j() {
        this.m = false;
        this.r = 0;
        byte[] bArr = d4.k0.f;
        this.n = bArr;
        this.o = bArr;
    }

    public final int l(long j) {
        return (int) ((j * this.b.a) / 1000000);
    }

    public final int m(ByteBuffer byteBuffer) {
        int limit = byteBuffer.limit();
        do {
            limit -= 2;
            if (limit < byteBuffer.position()) {
                return byteBuffer.position();
            }
        } while (Math.abs(byteBuffer.getShort(limit)) <= this.k);
        int i = this.l;
        return ((limit / i) * i) + i;
    }

    public final int n(ByteBuffer byteBuffer) {
        for (int position = byteBuffer.position(); position < byteBuffer.limit(); position += 2) {
            if (Math.abs(byteBuffer.getShort(position)) > this.k) {
                int i = this.l;
                return i * (position / i);
            }
        }
        return byteBuffer.limit();
    }

    public long o() {
        return this.t;
    }

    public final void p(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        k(remaining).put(byteBuffer).flip();
        if (remaining > 0) {
            this.s = true;
        }
    }

    public final void q(byte[] bArr, int i) {
        k(i).put(bArr, 0, i).flip();
        if (i > 0) {
            this.s = true;
        }
    }

    public final void r(ByteBuffer byteBuffer) {
        int limit = byteBuffer.limit();
        int n = n(byteBuffer);
        int position = n - byteBuffer.position();
        byte[] bArr = this.n;
        int length = bArr.length;
        int i = this.q;
        int i2 = length - i;
        if (n < limit && position < i2) {
            q(bArr, i);
            this.q = 0;
            this.p = 0;
            return;
        }
        int min = Math.min(position, i2);
        byteBuffer.limit(byteBuffer.position() + min);
        byteBuffer.get(this.n, this.q, min);
        int i3 = this.q + min;
        this.q = i3;
        byte[] bArr2 = this.n;
        if (i3 == bArr2.length) {
            if (this.s) {
                q(bArr2, this.r);
                this.t += (this.q - (this.r * 2)) / this.l;
            } else {
                this.t += (i3 - this.r) / this.l;
            }
            v(byteBuffer, this.n, this.q);
            this.q = 0;
            this.p = 2;
        }
        byteBuffer.limit(limit);
    }

    public final void s(ByteBuffer byteBuffer) {
        int limit = byteBuffer.limit();
        byteBuffer.limit(Math.min(limit, byteBuffer.position() + this.n.length));
        int m = m(byteBuffer);
        if (m == byteBuffer.position()) {
            this.p = 1;
        } else {
            byteBuffer.limit(m);
            p(byteBuffer);
        }
        byteBuffer.limit(limit);
    }

    public final void t(ByteBuffer byteBuffer) {
        int limit = byteBuffer.limit();
        int n = n(byteBuffer);
        byteBuffer.limit(n);
        this.t += byteBuffer.remaining() / this.l;
        v(byteBuffer, this.o, this.r);
        if (n < limit) {
            q(this.o, this.r);
            this.p = 0;
            byteBuffer.limit(limit);
        }
    }

    public void u(boolean z) {
        this.m = z;
    }

    public final void v(ByteBuffer byteBuffer, byte[] bArr, int i) {
        int min = Math.min(byteBuffer.remaining(), this.r);
        int i2 = this.r - min;
        System.arraycopy(bArr, i - i2, this.o, 0, i2);
        byteBuffer.position(byteBuffer.limit() - min);
        byteBuffer.get(this.o, i2, min);
    }

    public e0(long j, long j2, short s) {
        d4.a.a(j2 <= j);
        this.i = j;
        this.j = j2;
        this.k = s;
        byte[] bArr = d4.k0.f;
        this.n = bArr;
        this.o = bArr;
    }
}
