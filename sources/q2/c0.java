package Q2;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class c0 {
    public ByteBuffer a = m.a;
    public int c = 0;
    public int b = 2;

    public void a(U2.g gVar) {
        d4.a.e(gVar.d);
        if (gVar.d.limit() - gVar.d.position() == 0) {
            return;
        }
        this.a = b(gVar.d);
        gVar.clear();
        gVar.e(this.a.remaining());
        gVar.d.put(this.a);
        gVar.i();
    }

    public final ByteBuffer b(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i = limit - position;
        int i2 = (i + 255) / 255;
        ByteBuffer c = c(i2 + 27 + i);
        c.put((byte) 79);
        c.put((byte) 103);
        c.put((byte) 103);
        c.put((byte) 83);
        c.put((byte) 0);
        c.put((byte) 0);
        int h = this.c + d0.h(byteBuffer);
        this.c = h;
        c.putLong(h);
        c.putInt(0);
        c.putInt(this.b);
        this.b++;
        c.putInt(0);
        c.put((byte) i2);
        for (int i3 = 0; i3 < i2; i3++) {
            if (i >= 255) {
                c.put((byte) -1);
                i -= 255;
            } else {
                c.put((byte) i);
                i = 0;
            }
        }
        while (position < limit) {
            c.put(byteBuffer.get(position));
            position++;
        }
        byteBuffer.position(byteBuffer.limit());
        c.flip();
        c.putInt(22, d4.k0.u(c.array(), c.arrayOffset(), c.limit() - c.position(), 0));
        c.position(0);
        return c;
    }

    public final ByteBuffer c(int i) {
        if (this.a.capacity() < i) {
            this.a = ByteBuffer.allocate(i).order(ByteOrder.LITTLE_ENDIAN);
        } else {
            this.a.clear();
        }
        return this.a;
    }

    public void d() {
        this.a = m.a;
        this.c = 0;
        this.b = 2;
    }
}
