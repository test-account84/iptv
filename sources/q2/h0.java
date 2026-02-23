package Q2;

import Q2.m;
import java.nio.ByteBuffer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class h0 extends G {
    public static final int i = Float.floatToIntBits(Float.NaN);

    public static void l(int i2, ByteBuffer byteBuffer) {
        int floatToIntBits = Float.floatToIntBits((float) (i2 * 4.656612875245797E-10d));
        if (floatToIntBits == i) {
            floatToIntBits = Float.floatToIntBits(0.0f);
        }
        byteBuffer.putInt(floatToIntBits);
    }

    public void b(ByteBuffer byteBuffer) {
        ByteBuffer k;
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i2 = limit - position;
        int i3 = this.b.c;
        if (i3 == 536870912) {
            k = k((i2 / 3) * 4);
            while (position < limit) {
                l(((byteBuffer.get(position) & 255) << 8) | ((byteBuffer.get(position + 1) & 255) << 16) | ((byteBuffer.get(position + 2) & 255) << 24), k);
                position += 3;
            }
        } else {
            if (i3 != 805306368) {
                throw new IllegalStateException();
            }
            k = k(i2);
            while (position < limit) {
                l((byteBuffer.get(position) & 255) | ((byteBuffer.get(position + 1) & 255) << 8) | ((byteBuffer.get(position + 2) & 255) << 16) | ((byteBuffer.get(position + 3) & 255) << 24), k);
                position += 4;
            }
        }
        byteBuffer.position(byteBuffer.limit());
        k.flip();
    }

    public m.a g(m.a aVar) {
        int i2 = aVar.c;
        if (d4.k0.C0(i2)) {
            return i2 != 4 ? new m.a(aVar.a, aVar.b, 4) : m.a.e;
        }
        throw new m.b(aVar);
    }
}
