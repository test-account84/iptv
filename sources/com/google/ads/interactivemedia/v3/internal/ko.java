package com.google.ads.interactivemedia.v3.internal;

import java.nio.ByteBuffer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class ko extends ju {
    public final void e(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i = limit - position;
        int i2 = this.b.d;
        if (i2 == 3) {
            i += i;
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
                i += i;
            }
        }
        ByteBuffer j = j(i);
        int i3 = this.b.d;
        if (i3 == 3) {
            while (position < limit) {
                j.put((byte) 0);
                j.put((byte) ((byteBuffer.get(position) & 255) - 128));
                position++;
            }
        } else if (i3 == 4) {
            while (position < limit) {
                short a = (short) (cq.a(byteBuffer.getFloat(position), -1.0f, 1.0f) * 32767.0f);
                j.put((byte) (a & 255));
                j.put((byte) ((a >> 8) & 255));
                position += 4;
            }
        } else if (i3 == 268435456) {
            while (position < limit) {
                j.put(byteBuffer.get(position + 1));
                j.put(byteBuffer.get(position));
                position += 2;
            }
        } else if (i3 == 536870912) {
            while (position < limit) {
                j.put(byteBuffer.get(position + 1));
                j.put(byteBuffer.get(position + 2));
                position += 3;
            }
        } else {
            if (i3 != 805306368) {
                throw new IllegalStateException();
            }
            while (position < limit) {
                j.put(byteBuffer.get(position + 2));
                j.put(byteBuffer.get(position + 3));
                position += 4;
            }
        }
        byteBuffer.position(byteBuffer.limit());
        j.flip();
    }

    public final iz i(iz izVar) throws ja {
        int i = izVar.d;
        if (i != 3) {
            if (i == 2) {
                return iz.a;
            }
            if (i != 268435456 && i != 536870912 && i != 805306368 && i != 4) {
                throw new ja(izVar);
            }
        }
        return new iz(izVar.b, izVar.c, 2);
    }
}
