package Q2;

import Q2.m;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class g0 implements m {
    public int b;
    public float c = 1.0f;
    public float d = 1.0f;
    public m.a e;
    public m.a f;
    public m.a g;
    public m.a h;
    public boolean i;
    public f0 j;
    public ByteBuffer k;
    public ShortBuffer l;
    public ByteBuffer m;
    public long n;
    public long o;
    public boolean p;

    public g0() {
        m.a aVar = m.a.e;
        this.e = aVar;
        this.f = aVar;
        this.g = aVar;
        this.h = aVar;
        ByteBuffer byteBuffer = m.a;
        this.k = byteBuffer;
        this.l = byteBuffer.asShortBuffer();
        this.m = byteBuffer;
        this.b = -1;
    }

    public final ByteBuffer a() {
        int k;
        f0 f0Var = this.j;
        if (f0Var != null && (k = f0Var.k()) > 0) {
            if (this.k.capacity() < k) {
                ByteBuffer order = ByteBuffer.allocateDirect(k).order(ByteOrder.nativeOrder());
                this.k = order;
                this.l = order.asShortBuffer();
            } else {
                this.k.clear();
                this.l.clear();
            }
            f0Var.j(this.l);
            this.o += k;
            this.k.limit(k);
            this.m = this.k;
        }
        ByteBuffer byteBuffer = this.m;
        this.m = m.a;
        return byteBuffer;
    }

    public final void b(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            f0 f0Var = (f0) d4.a.e(this.j);
            ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
            int remaining = byteBuffer.remaining();
            this.n += remaining;
            f0Var.t(asShortBuffer);
            byteBuffer.position(byteBuffer.position() + remaining);
        }
    }

    public final void c() {
        f0 f0Var = this.j;
        if (f0Var != null) {
            f0Var.s();
        }
        this.p = true;
    }

    public final boolean d() {
        f0 f0Var;
        return this.p && ((f0Var = this.j) == null || f0Var.k() == 0);
    }

    public final m.a e(m.a aVar) {
        if (aVar.c != 2) {
            throw new m.b(aVar);
        }
        int i = this.b;
        if (i == -1) {
            i = aVar.a;
        }
        this.e = aVar;
        m.a aVar2 = new m.a(i, aVar.b, 2);
        this.f = aVar2;
        this.i = true;
        return aVar2;
    }

    public final long f(long j) {
        if (this.o < 1024) {
            return (long) (this.c * j);
        }
        long l = this.n - ((f0) d4.a.e(this.j)).l();
        int i = this.h.a;
        int i2 = this.g.a;
        return i == i2 ? d4.k0.c1(j, l, this.o) : d4.k0.c1(j, l * i, this.o * i2);
    }

    public final void flush() {
        if (isActive()) {
            m.a aVar = this.e;
            this.g = aVar;
            m.a aVar2 = this.f;
            this.h = aVar2;
            if (this.i) {
                this.j = new f0(aVar.a, aVar.b, this.c, this.d, aVar2.a);
            } else {
                f0 f0Var = this.j;
                if (f0Var != null) {
                    f0Var.i();
                }
            }
        }
        this.m = m.a;
        this.n = 0L;
        this.o = 0L;
        this.p = false;
    }

    public final void g(float f) {
        if (this.d != f) {
            this.d = f;
            this.i = true;
        }
    }

    public final void h(float f) {
        if (this.c != f) {
            this.c = f;
            this.i = true;
        }
    }

    public final boolean isActive() {
        return this.f.a != -1 && (Math.abs(this.c - 1.0f) >= 1.0E-4f || Math.abs(this.d - 1.0f) >= 1.0E-4f || this.f.a != this.e.a);
    }

    public final void reset() {
        this.c = 1.0f;
        this.d = 1.0f;
        m.a aVar = m.a.e;
        this.e = aVar;
        this.f = aVar;
        this.g = aVar;
        this.h = aVar;
        ByteBuffer byteBuffer = m.a;
        this.k = byteBuffer;
        this.l = byteBuffer.asShortBuffer();
        this.m = byteBuffer;
        this.b = -1;
        this.i = false;
        this.j = null;
        this.n = 0L;
        this.o = 0L;
        this.p = false;
    }
}
