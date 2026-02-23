package com.google.ads.interactivemedia.v3.internal;

import java.nio.ByteBuffer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class ef extends dz {
    public final ec a;
    public ByteBuffer b;
    public boolean c;
    public long d;
    public ByteBuffer e;
    private final int f;

    static {
        aj.b("media3.decoder");
    }

    public ef() {
        this(1);
    }

    private final ByteBuffer l(int i) {
        int i2 = this.f;
        if (i2 == 1) {
            return ByteBuffer.allocate(i);
        }
        if (i2 == 2) {
            return ByteBuffer.allocateDirect(i);
        }
        ByteBuffer byteBuffer = this.b;
        throw new ee(byteBuffer == null ? 0 : byteBuffer.capacity(), i);
    }

    public void b() {
        super.b();
        ByteBuffer byteBuffer = this.b;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        ByteBuffer byteBuffer2 = this.e;
        if (byteBuffer2 != null) {
            byteBuffer2.clear();
        }
        this.c = false;
    }

    public final void i(int i) {
        ByteBuffer byteBuffer = this.b;
        if (byteBuffer == null) {
            this.b = l(i);
            return;
        }
        int capacity = byteBuffer.capacity();
        int position = byteBuffer.position();
        int i2 = i + position;
        if (capacity >= i2) {
            this.b = byteBuffer;
            return;
        }
        ByteBuffer l = l(i2);
        l.order(byteBuffer.order());
        if (position > 0) {
            byteBuffer.flip();
            l.put(byteBuffer);
        }
        this.b = l;
    }

    public final void j() {
        ByteBuffer byteBuffer = this.b;
        if (byteBuffer != null) {
            byteBuffer.flip();
        }
        ByteBuffer byteBuffer2 = this.e;
        if (byteBuffer2 != null) {
            byteBuffer2.flip();
        }
    }

    public final boolean k() {
        return d(1073741824);
    }

    public ef(int i) {
        this.a = new ec();
        this.f = i;
    }
}
