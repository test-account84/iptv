package com.google.ads.interactivemedia.v3.internal;

import java.nio.ByteBuffer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class kp extends ju {
    private int d;
    private boolean e;
    private byte[] f;
    private byte[] g;
    private int h;
    private int i;
    private int j;
    private boolean k;
    private long l;

    public kp() {
        af.u(true);
        byte[] bArr = cq.f;
        this.f = bArr;
        this.g = bArr;
    }

    private final int q(long j) {
        return (int) ((j * this.b.b) / 1000000);
    }

    private final int r(ByteBuffer byteBuffer) {
        for (int position = byteBuffer.position(); position < byteBuffer.limit(); position += 2) {
            if (Math.abs(byteBuffer.getShort(position)) > 1024) {
                int i = this.d;
                return i * (position / i);
            }
        }
        return byteBuffer.limit();
    }

    private final void s(byte[] bArr, int i) {
        j(i).put(bArr, 0, i).flip();
        if (i > 0) {
            this.k = true;
        }
    }

    private final void t(ByteBuffer byteBuffer, byte[] bArr, int i) {
        int min = Math.min(byteBuffer.remaining(), this.j);
        int i2 = this.j - min;
        System.arraycopy(bArr, i - i2, this.g, 0, i2);
        byteBuffer.position(byteBuffer.limit() - min);
        byteBuffer.get(this.g, i2, min);
    }

    public final void e(ByteBuffer byteBuffer) {
        int limit;
        int position;
        while (byteBuffer.hasRemaining() && !n()) {
            int i = this.h;
            int i2 = 1;
            if (i == 0) {
                limit = byteBuffer.limit();
                byteBuffer.limit(Math.min(limit, byteBuffer.position() + this.f.length));
                int limit2 = byteBuffer.limit();
                while (true) {
                    limit2 -= 2;
                    if (limit2 < byteBuffer.position()) {
                        position = byteBuffer.position();
                        break;
                    } else if (Math.abs(byteBuffer.getShort(limit2)) > 1024) {
                        int i3 = this.d;
                        position = ((limit2 / i3) * i3) + i3;
                        break;
                    }
                }
                if (position == byteBuffer.position()) {
                    this.h = i2;
                } else {
                    byteBuffer.limit(position);
                    int remaining = byteBuffer.remaining();
                    j(remaining).put(byteBuffer).flip();
                    if (remaining > 0) {
                        this.k = true;
                    }
                }
                byteBuffer.limit(limit);
            } else if (i != 1) {
                limit = byteBuffer.limit();
                int r = r(byteBuffer);
                byteBuffer.limit(r);
                this.l += byteBuffer.remaining() / this.d;
                t(byteBuffer, this.g, this.j);
                if (r < limit) {
                    s(this.g, this.j);
                    this.h = 0;
                    byteBuffer.limit(limit);
                }
            } else {
                limit = byteBuffer.limit();
                int r2 = r(byteBuffer);
                int position2 = r2 - byteBuffer.position();
                byte[] bArr = this.f;
                int length = bArr.length;
                int i4 = this.i;
                int i5 = length - i4;
                if (r2 >= limit || position2 >= i5) {
                    int min = Math.min(position2, i5);
                    byteBuffer.limit(byteBuffer.position() + min);
                    byteBuffer.get(this.f, this.i, min);
                    int i6 = this.i + min;
                    this.i = i6;
                    byte[] bArr2 = this.f;
                    if (i6 == bArr2.length) {
                        if (this.k) {
                            s(bArr2, this.j);
                            long j = this.l;
                            int i7 = this.i;
                            int i8 = this.j;
                            this.l = j + ((i7 - (i8 + i8)) / this.d);
                            i6 = i7;
                        } else {
                            this.l += (i6 - this.j) / this.d;
                        }
                        t(byteBuffer, this.f, i6);
                        this.i = 0;
                        i2 = 2;
                        this.h = i2;
                    }
                    byteBuffer.limit(limit);
                } else {
                    s(bArr, i4);
                    this.i = 0;
                    this.h = 0;
                }
            }
        }
    }

    public final boolean g() {
        return this.e;
    }

    public final iz i(iz izVar) throws ja {
        if (izVar.d == 2) {
            return this.e ? izVar : iz.a;
        }
        throw new ja(izVar);
    }

    public final void k() {
        if (this.e) {
            this.d = this.b.e;
            int q = q(150000L) * this.d;
            if (this.f.length != q) {
                this.f = new byte[q];
            }
            int q2 = q(20000L) * this.d;
            this.j = q2;
            if (this.g.length != q2) {
                this.g = new byte[q2];
            }
        }
        this.h = 0;
        this.l = 0L;
        this.i = 0;
        this.k = false;
    }

    public final void l() {
        int i = this.i;
        if (i > 0) {
            s(this.f, i);
        }
        if (this.k) {
            return;
        }
        this.l += this.j / this.d;
    }

    public final void m() {
        this.e = false;
        this.j = 0;
        byte[] bArr = cq.f;
        this.f = bArr;
        this.g = bArr;
    }

    public final long o() {
        return this.l;
    }

    public final void p(boolean z) {
        this.e = z;
    }
}
