package Q2;

import Q2.m;
import java.nio.ByteBuffer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class i0 extends G {
    public void b(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i = limit - position;
        int i2 = this.b.c;
        if (i2 == 3) {
            i *= 2;
        } else if (i2 == 4) {
            i /= 2;
        } else if (i2 != 268435456) {
            if (i2 != 536870912) {
                if (i2 != 805306368) {
                    throw new IllegalStateException();
                }
                i /= 2;
            } else {
                i /= 3;
                i *= 2;
            }
        }
        ByteBuffer k = k(i);
        int i3 = this.b.c;
        if (i3 == 3) {
            while (position < limit) {
                k.put((byte) 0);
                k.put((byte) ((byteBuffer.get(position) & 255) - 128));
                position++;
            }
        } else if (i3 == 4) {
            while (position < limit) {
                short q = (short) (d4.k0.q(byteBuffer.getFloat(position), -1.0f, 1.0f) * 32767.0f);
                k.put((byte) (q & 255));
                k.put((byte) ((q >> 8) & 255));
                position += 4;
            }
        } else if (i3 == 268435456) {
            while (position < limit) {
                k.put(byteBuffer.get(position + 1));
                k.put(byteBuffer.get(position));
                position += 2;
            }
        } else if (i3 == 536870912) {
            while (position < limit) {
                k.put(byteBuffer.get(position + 1));
                k.put(byteBuffer.get(position + 2));
                position += 3;
            }
        } else {
            if (i3 != 805306368) {
                throw new IllegalStateException();
            }
            while (position < limit) {
                k.put(byteBuffer.get(position + 2));
                k.put(byteBuffer.get(position + 3));
                position += 4;
            }
        }
        byteBuffer.position(byteBuffer.limit());
        k.flip();
    }

    public m.a g(m.a aVar) {
        int i = aVar.c;
        if (i == 3 || i == 2 || i == 268435456 || i == 536870912 || i == 805306368 || i == 4) {
            return i != 2 ? new m.a(aVar.a, aVar.b, 2) : m.a.e;
        }
        throw new m.b(aVar);
    }
}
