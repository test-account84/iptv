package com.google.ads.interactivemedia.v3.internal;

import java.nio.ByteBuffer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class jv extends ju {
    private int[] d;
    private int[] e;

    public final void e(ByteBuffer byteBuffer) {
        int[] iArr = (int[]) af.s(this.e);
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        ByteBuffer j = j(((limit - position) / this.b.e) * this.c.e);
        while (position < limit) {
            for (int i : iArr) {
                j.putShort(byteBuffer.getShort(i + i + position));
            }
            position += this.b.e;
        }
        byteBuffer.position(limit);
        j.flip();
    }

    public final iz i(iz izVar) throws ja {
        int[] iArr = this.d;
        if (iArr == null) {
            return iz.a;
        }
        if (izVar.d != 2) {
            throw new ja(izVar);
        }
        boolean z = izVar.c != iArr.length;
        int i = 0;
        while (true) {
            int length = iArr.length;
            if (i >= length) {
                return z ? new iz(izVar.b, length, 2) : iz.a;
            }
            int i2 = iArr[i];
            if (i2 >= izVar.c) {
                throw new ja(izVar);
            }
            z |= i2 != i;
            i++;
        }
    }

    public final void k() {
        this.e = this.d;
    }

    public final void m() {
        this.e = null;
        this.d = null;
    }

    public final void o(int[] iArr) {
        this.d = iArr;
    }
}
