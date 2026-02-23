package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bqx extends InputStream {
    private Iterator a;
    private ByteBuffer b;
    private int c = 0;
    private int d;
    private int e;
    private boolean f;
    private byte[] g;
    private int h;
    private long i;

    public bqx(Iterable iterable) {
        this.a = iterable.iterator();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            this.c++;
        }
        this.d = -1;
        if (b()) {
            return;
        }
        this.b = bqu.c;
        this.d = 0;
        this.e = 0;
        this.i = 0L;
    }

    private final void a(int i) {
        int i2 = this.e + i;
        this.e = i2;
        if (i2 == this.b.limit()) {
            b();
        }
    }

    private final boolean b() {
        this.d++;
        if (!this.a.hasNext()) {
            return false;
        }
        ByteBuffer byteBuffer = (ByteBuffer) this.a.next();
        this.b = byteBuffer;
        this.e = byteBuffer.position();
        if (this.b.hasArray()) {
            this.f = true;
            this.g = this.b.array();
            this.h = this.b.arrayOffset();
        } else {
            this.f = false;
            this.i = btf.e(this.b);
            this.g = null;
        }
        return true;
    }

    public final int read() throws IOException {
        byte a;
        if (this.d == this.c) {
            return -1;
        }
        if (this.f) {
            a = this.g[this.e + this.h];
        } else {
            a = btf.a(this.e + this.i);
        }
        a(1);
        return a & 255;
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.d == this.c) {
            return -1;
        }
        int limit = this.b.limit();
        int i3 = this.e;
        int i4 = limit - i3;
        if (i2 > i4) {
            i2 = i4;
        }
        if (this.f) {
            System.arraycopy(this.g, i3 + this.h, bArr, i, i2);
        } else {
            int position = this.b.position();
            this.b.position(this.e);
            this.b.get(bArr, i, i2);
            this.b.position(position);
        }
        a(i2);
        return i2;
    }
}
