package Q2;

import Q2.m;
import java.nio.ByteBuffer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class j0 extends G {
    public int i;
    public int j;
    public boolean k;
    public int l;
    public byte[] m = d4.k0.f;
    public int n;
    public long o;

    public ByteBuffer a() {
        int i;
        if (super.d() && (i = this.n) > 0) {
            k(i).put(this.m, 0, this.n).flip();
            this.n = 0;
        }
        return super.a();
    }

    public void b(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i = limit - position;
        if (i == 0) {
            return;
        }
        int min = Math.min(i, this.l);
        this.o += min / this.b.d;
        this.l -= min;
        byteBuffer.position(position + min);
        if (this.l > 0) {
            return;
        }
        int i2 = i - min;
        int length = (this.n + i2) - this.m.length;
        ByteBuffer k = k(length);
        int r = d4.k0.r(length, 0, this.n);
        k.put(this.m, 0, r);
        int r2 = d4.k0.r(length - r, 0, i2);
        byteBuffer.limit(byteBuffer.position() + r2);
        k.put(byteBuffer);
        byteBuffer.limit(limit);
        int i3 = i2 - r2;
        int i4 = this.n - r;
        this.n = i4;
        byte[] bArr = this.m;
        System.arraycopy(bArr, r, bArr, 0, i4);
        byteBuffer.get(this.m, this.n, i3);
        this.n += i3;
        k.flip();
    }

    public boolean d() {
        return super.d() && this.n == 0;
    }

    public m.a g(m.a aVar) {
        if (aVar.c != 2) {
            throw new m.b(aVar);
        }
        this.k = true;
        return (this.i == 0 && this.j == 0) ? m.a.e : aVar;
    }

    public void h() {
        if (this.k) {
            this.k = false;
            int i = this.j;
            int i2 = this.b.d;
            this.m = new byte[i * i2];
            this.l = this.i * i2;
        }
        this.n = 0;
    }

    public void i() {
        if (this.k) {
            if (this.n > 0) {
                this.o += r0 / this.b.d;
            }
            this.n = 0;
        }
    }

    public void j() {
        this.m = d4.k0.f;
    }

    public long l() {
        return this.o;
    }

    public void m() {
        this.o = 0L;
    }

    public void n(int i, int i2) {
        this.i = i;
        this.j = i2;
    }
}
