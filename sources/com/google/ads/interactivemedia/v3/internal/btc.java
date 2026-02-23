package com.google.ads.interactivemedia.v3.internal;

import libcore.io.Memory;
import sun.misc.Unsafe;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class btc extends bte {
    public btc(Unsafe unsafe) {
        super(unsafe);
    }

    public final byte a(long j) {
        return Memory.peekByte((int) j);
    }

    public final double b(Object obj, long j) {
        return Double.longBitsToDouble(m(obj, j));
    }

    public final float c(Object obj, long j) {
        return Float.intBitsToFloat(l(obj, j));
    }

    public final void d(long j, byte[] bArr, long j2, long j3) {
        Memory.peekByteArray((int) j, bArr, (int) j2, (int) j3);
    }

    public final void e(Object obj, long j, boolean z) {
        if (btf.b) {
            btf.l(obj, j, z);
        } else {
            btf.m(obj, j, z);
        }
    }

    public final void f(Object obj, long j, byte b) {
        if (btf.b) {
            btf.n(obj, j, b);
        } else {
            btf.o(obj, j, b);
        }
    }

    public final void g(Object obj, long j, double d) {
        q(obj, j, Double.doubleToLongBits(d));
    }

    public final void h(Object obj, long j, float f) {
        p(obj, j, Float.floatToIntBits(f));
    }

    public final boolean i(Object obj, long j) {
        return btf.b ? btf.x(obj, j) : btf.y(obj, j);
    }
}
