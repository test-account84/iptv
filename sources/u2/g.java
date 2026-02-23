package U2;

import O2.w0;
import O2.z0;
import java.nio.ByteBuffer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class g extends U2.a {
    public z0 a;
    public final c c;
    public ByteBuffer d;
    public boolean e;
    public long f;
    public ByteBuffer g;
    public final int h;
    public final int i;

    public static final class a extends IllegalStateException {
        public final int a;
        public final int c;

        public a(int i, int i2) {
            super("Buffer too small (" + i + " < " + i2 + ")");
            this.a = i;
            this.c = i2;
        }
    }

    static {
        w0.a("goog.exo.decoder");
    }

    public g(int i) {
        this(i, 0);
    }

    public static g l() {
        return new g(0);
    }

    public void clear() {
        super.clear();
        ByteBuffer byteBuffer = this.d;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        ByteBuffer byteBuffer2 = this.g;
        if (byteBuffer2 != null) {
            byteBuffer2.clear();
        }
        this.e = false;
    }

    public final ByteBuffer d(int i) {
        int i2 = this.h;
        if (i2 == 1) {
            return ByteBuffer.allocate(i);
        }
        if (i2 == 2) {
            return ByteBuffer.allocateDirect(i);
        }
        ByteBuffer byteBuffer = this.d;
        throw new a(byteBuffer == null ? 0 : byteBuffer.capacity(), i);
    }

    public void e(int i) {
        int i2 = i + this.i;
        ByteBuffer byteBuffer = this.d;
        if (byteBuffer == null) {
            this.d = d(i2);
            return;
        }
        int capacity = byteBuffer.capacity();
        int position = byteBuffer.position();
        int i3 = i2 + position;
        if (capacity >= i3) {
            this.d = byteBuffer;
            return;
        }
        ByteBuffer d = d(i3);
        d.order(byteBuffer.order());
        if (position > 0) {
            byteBuffer.flip();
            d.put(byteBuffer);
        }
        this.d = d;
    }

    public final void i() {
        ByteBuffer byteBuffer = this.d;
        if (byteBuffer != null) {
            byteBuffer.flip();
        }
        ByteBuffer byteBuffer2 = this.g;
        if (byteBuffer2 != null) {
            byteBuffer2.flip();
        }
    }

    public final boolean j() {
        return getFlag(1073741824);
    }

    public void n(int i) {
        ByteBuffer byteBuffer = this.g;
        if (byteBuffer == null || byteBuffer.capacity() < i) {
            this.g = ByteBuffer.allocate(i);
        } else {
            this.g.clear();
        }
    }

    public g(int i, int i2) {
        this.c = new c();
        this.h = i;
        this.i = i2;
    }
}
