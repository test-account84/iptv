package com.google.ads.interactivemedia.v3.internal;

import java.nio.ByteBuffer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class qz extends ef {
    private long f;
    private int g;
    private int h;

    public qz() {
        super(2);
        this.h = 32;
    }

    public final void b() {
        super.b();
        this.g = 0;
    }

    public final int l() {
        return this.g;
    }

    public final long m() {
        return this.f;
    }

    public final void n(int i) {
        af.u(true);
        this.h = i;
    }

    public final boolean o(ef efVar) {
        ByteBuffer byteBuffer;
        af.u(!efVar.k());
        af.u(!efVar.e());
        af.u(!efVar.g());
        if (p()) {
            if (this.g >= this.h || efVar.f() != f()) {
                return false;
            }
            ByteBuffer byteBuffer2 = efVar.b;
            if (byteBuffer2 != null && (byteBuffer = this.b) != null && byteBuffer.position() + byteBuffer2.remaining() > 3072000) {
                return false;
            }
        }
        int i = this.g;
        this.g = i + 1;
        if (i == 0) {
            this.d = efVar.d;
            if (efVar.h()) {
                c(1);
            }
        }
        if (efVar.f()) {
            c(Integer.MIN_VALUE);
        }
        ByteBuffer byteBuffer3 = efVar.b;
        if (byteBuffer3 != null) {
            i(byteBuffer3.remaining());
            this.b.put(byteBuffer3);
        }
        this.f = efVar.d;
        return true;
    }

    public final boolean p() {
        return this.g > 0;
    }
}
