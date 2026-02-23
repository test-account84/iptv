package com.google.ads.interactivemedia.v3.internal;

import java.nio.ByteBuffer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
abstract class btg {
    public static final String f(ByteBuffer byteBuffer, int i, int i2) throws bqw {
        if ((i | i2 | ((byteBuffer.limit() - i) - i2)) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", new Object[]{Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i), Integer.valueOf(i2)}));
        }
        int i3 = i + i2;
        char[] cArr = new char[i2];
        int i4 = 0;
        while (i < i3) {
            byte b = byteBuffer.get(i);
            if (!bto.e(b)) {
                break;
            }
            i++;
            bto.b(b, cArr, i4);
            i4++;
        }
        int i5 = i4;
        while (i < i3) {
            int i6 = i + 1;
            byte b2 = byteBuffer.get(i);
            if (bto.e(b2)) {
                bto.b(b2, cArr, i5);
                i5++;
                i = i6;
                while (i < i3) {
                    byte b3 = byteBuffer.get(i);
                    if (!bto.e(b3)) {
                        break;
                    }
                    i++;
                    bto.b(b3, cArr, i5);
                    i5++;
                }
            } else if (bto.g(b2)) {
                if (i6 >= i3) {
                    throw bqw.d();
                }
                i += 2;
                bto.d(b2, byteBuffer.get(i6), cArr, i5);
                i5++;
            } else if (bto.f(b2)) {
                if (i6 >= i3 - 1) {
                    throw bqw.d();
                }
                int i7 = i + 2;
                i += 3;
                bto.c(b2, byteBuffer.get(i6), byteBuffer.get(i7), cArr, i5);
                i5++;
            } else {
                if (i6 >= i3 - 2) {
                    throw bqw.d();
                }
                int i8 = i + 2;
                int i9 = i + 3;
                i += 4;
                bto.a(b2, byteBuffer.get(i6), byteBuffer.get(i8), byteBuffer.get(i9), cArr, i5);
                i5 += 2;
            }
        }
        return new String(cArr, 0, i5);
    }

    public abstract int a(CharSequence charSequence, byte[] bArr, int i, int i2);

    public abstract int b(int i, byte[] bArr, int i2, int i3);

    public abstract String c(byte[] bArr, int i, int i2) throws bqw;

    public abstract String d(ByteBuffer byteBuffer, int i, int i2) throws bqw;

    public final boolean e(byte[] bArr, int i, int i2) {
        return b(0, bArr, i, i2) == 0;
    }
}
