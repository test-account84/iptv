package com.google.ads.interactivemedia.v3.internal;

import java.nio.ByteBuffer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class kk extends ju {
    private static final int d = Float.floatToIntBits(Float.NaN);

    private static void o(int i, ByteBuffer byteBuffer) {
        int floatToIntBits = Float.floatToIntBits((float) (i * 4.656612875245797E-10d));
        if (floatToIntBits == d) {
            floatToIntBits = Float.floatToIntBits(0.0f);
        }
        byteBuffer.putInt(floatToIntBits);
    }

    public final void e(ByteBuffer byteBuffer) {
        ByteBuffer j;
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i = limit - position;
        int i2 = this.b.d;
        if (i2 == 536870912) {
            j = j((i / 3) * 4);
            while (position < limit) {
                o(((byteBuffer.get(position) & 255) << 8) | ((byteBuffer.get(position + 1) & 255) << 16) | ((byteBuffer.get(position + 2) & 255) << 24), j);
                position += 3;
            }
        } else {
            if (i2 != 805306368) {
                throw new IllegalStateException();
            }
            j = j(i);
            while (position < limit) {
                o((byteBuffer.get(position) & 255) | ((byteBuffer.get(position + 1) & 255) << 8) | ((byteBuffer.get(position + 2) & 255) << 16) | ((byteBuffer.get(position + 3) & 255) << 24), j);
                position += 4;
            }
        }
        byteBuffer.position(byteBuffer.limit());
        j.flip();
    }

    public final iz i(iz izVar) throws ja {
        int i = izVar.d;
        if (cq.X(i)) {
            return i != 4 ? new iz(izVar.b, izVar.c, 4) : iz.a;
        }
        throw new ja(izVar);
    }
}
