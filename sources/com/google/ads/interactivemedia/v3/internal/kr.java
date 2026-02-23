package com.google.ads.interactivemedia.v3.internal;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class kr implements jb {
    private int b;
    private float c = 1.0f;
    private float d = 1.0f;
    private iz e;
    private iz f;
    private iz g;
    private iz h;
    private boolean i;
    private kq j;
    private ByteBuffer k;
    private ShortBuffer l;
    private ByteBuffer m;
    private long n;
    private long o;
    private boolean p;

    public kr() {
        iz izVar = iz.a;
        this.e = izVar;
        this.f = izVar;
        this.g = izVar;
        this.h = izVar;
        ByteBuffer byteBuffer = jb.a;
        this.k = byteBuffer;
        this.l = byteBuffer.asShortBuffer();
        this.m = byteBuffer;
        this.b = -1;
    }

    public final iz a(iz izVar) throws ja {
        if (izVar.d != 2) {
            throw new ja(izVar);
        }
        int i = this.b;
        if (i == -1) {
            i = izVar.b;
        }
        this.e = izVar;
        iz izVar2 = new iz(i, izVar.c, 2);
        this.f = izVar2;
        this.i = true;
        return izVar2;
    }

    public final ByteBuffer b() {
        int a;
        kq kqVar = this.j;
        if (kqVar != null && (a = kqVar.a()) > 0) {
            if (this.k.capacity() < a) {
                ByteBuffer order = ByteBuffer.allocateDirect(a).order(ByteOrder.nativeOrder());
                this.k = order;
                this.l = order.asShortBuffer();
            } else {
                this.k.clear();
                this.l.clear();
            }
            kqVar.d(this.l);
            this.o += a;
            this.k.limit(a);
            this.m = this.k;
        }
        ByteBuffer byteBuffer = this.m;
        this.m = jb.a;
        return byteBuffer;
    }

    public final void c() {
        if (g()) {
            iz izVar = this.e;
            this.g = izVar;
            iz izVar2 = this.f;
            this.h = izVar2;
            if (this.i) {
                this.j = new kq(izVar.b, izVar.c, this.c, this.d, izVar2.b);
            } else {
                kq kqVar = this.j;
                if (kqVar != null) {
                    kqVar.c();
                }
            }
        }
        this.m = jb.a;
        this.n = 0L;
        this.o = 0L;
        this.p = false;
    }

    public final void d() {
        kq kqVar = this.j;
        if (kqVar != null) {
            kqVar.e();
        }
        this.p = true;
    }

    public final void e(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            kq kqVar = this.j;
            af.s(kqVar);
            ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
            int remaining = byteBuffer.remaining();
            this.n += remaining;
            kqVar.f(asShortBuffer);
            byteBuffer.position(byteBuffer.position() + remaining);
        }
    }

    public final void f() {
        this.c = 1.0f;
        this.d = 1.0f;
        iz izVar = iz.a;
        this.e = izVar;
        this.f = izVar;
        this.g = izVar;
        this.h = izVar;
        ByteBuffer byteBuffer = jb.a;
        this.k = byteBuffer;
        this.l = byteBuffer.asShortBuffer();
        this.m = byteBuffer;
        this.b = -1;
        this.i = false;
        this.j = null;
        this.n = 0L;
        this.o = 0L;
        this.p = false;
    }

    public final boolean g() {
        if (this.f.b != -1) {
            return Math.abs(this.c + (-1.0f)) >= 1.0E-4f || Math.abs(this.d + (-1.0f)) >= 1.0E-4f || this.f.b != this.e.b;
        }
        return false;
    }

    public final boolean h() {
        if (!this.p) {
            return false;
        }
        kq kqVar = this.j;
        return kqVar == null || kqVar.a() == 0;
    }

    public final long i(long j) {
        if (this.o < 1024) {
            return (long) (this.c * j);
        }
        long j2 = this.n;
        af.s(this.j);
        long b = j2 - r3.b();
        int i = this.h.b;
        int i2 = this.g.b;
        return i == i2 ? cq.w(j, b, this.o) : cq.w(j, b * i, this.o * i2);
    }

    public final void j(float f) {
        if (this.d != f) {
            this.d = f;
            this.i = true;
        }
    }

    public final void k(float f) {
        if (this.c != f) {
            this.c = f;
            this.i = true;
        }
    }
}
