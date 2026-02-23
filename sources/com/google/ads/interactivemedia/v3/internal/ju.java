package com.google.ads.interactivemedia.v3.internal;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class ju implements jb {
    protected iz b;
    protected iz c;
    private iz d;
    private iz e;
    private ByteBuffer f;
    private ByteBuffer g;
    private boolean h;

    public ju() {
        ByteBuffer byteBuffer = jb.a;
        this.f = byteBuffer;
        this.g = byteBuffer;
        iz izVar = iz.a;
        this.d = izVar;
        this.e = izVar;
        this.b = izVar;
        this.c = izVar;
    }

    public final iz a(iz izVar) throws ja {
        this.d = izVar;
        this.e = i(izVar);
        return g() ? this.e : iz.a;
    }

    public ByteBuffer b() {
        ByteBuffer byteBuffer = this.g;
        this.g = jb.a;
        return byteBuffer;
    }

    public final void c() {
        this.g = jb.a;
        this.h = false;
        this.b = this.d;
        this.c = this.e;
        k();
    }

    public final void d() {
        this.h = true;
        l();
    }

    public final void f() {
        c();
        this.f = jb.a;
        iz izVar = iz.a;
        this.d = izVar;
        this.e = izVar;
        this.b = izVar;
        this.c = izVar;
        m();
    }

    public boolean g() {
        return this.e != iz.a;
    }

    public boolean h() {
        return this.h && this.g == jb.a;
    }

    public iz i(iz izVar) throws ja {
        throw null;
    }

    public final ByteBuffer j(int i) {
        if (this.f.capacity() < i) {
            this.f = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
        } else {
            this.f.clear();
        }
        ByteBuffer byteBuffer = this.f;
        this.g = byteBuffer;
        return byteBuffer;
    }

    public void k() {
    }

    public void l() {
    }

    public void m() {
    }

    public final boolean n() {
        return this.g.hasRemaining();
    }
}
