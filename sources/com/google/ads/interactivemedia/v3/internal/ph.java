package com.google.ads.interactivemedia.v3.internal;

import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class ph implements aae {
    private static final s a;
    private final aae c;
    private s e;
    private final aam b = new aam();
    private final s d = a;
    private byte[] f = new byte[0];
    private int g = 0;

    static {
        r rVar = new r();
        rVar.ae("application/id3");
        a = rVar.v();
        r rVar2 = new r();
        rVar2.ae("application/x-emsg");
        rVar2.v();
    }

    public ph(aae aaeVar, int i) {
        this.c = aaeVar;
    }

    private final void c(int i) {
        byte[] bArr = this.f;
        if (bArr.length < i) {
            this.f = Arrays.copyOf(bArr, i + (i >> 1));
        }
    }

    public final /* synthetic */ int a(k kVar, int i, boolean z) {
        return fz.h(this, kVar, i, z);
    }

    public final void b(s sVar) {
        this.e = sVar;
        this.c.b(this.d);
    }

    public final /* synthetic */ void e(cj cjVar, int i) {
        fz.i(this, cjVar, i);
    }

    public final void f(long j, int i, int i2, int i3, aad aadVar) {
        af.s(this.e);
        int i4 = this.g - i3;
        cj cjVar = new cj(Arrays.copyOfRange(this.f, i4 - i2, i4));
        byte[] bArr = this.f;
        System.arraycopy(bArr, i4, bArr, 0, i3);
        this.g = i3;
        if (!cq.V(this.e.l, this.d.l)) {
            if (!"application/x-emsg".equals(this.e.l)) {
                cd.e("HlsSampleStreamWrapper", "Ignoring sample for unsupported format: ".concat(String.valueOf(this.e.l)));
                return;
            }
            aal c = aam.c(cjVar);
            s b = c.b();
            if (b == null || !cq.V(this.d.l, b.l)) {
                cd.e("HlsSampleStreamWrapper", String.format("Ignoring EMSG. Expected it to contain wrapped %s but actual wrapped format: %s", new Object[]{this.d.l, c.b()}));
                return;
            }
            cjVar = new cj((byte[]) af.s(c.b() != null ? c.e : null));
        }
        int a2 = cjVar.a();
        this.c.e(cjVar, a2);
        this.c.f(j, i, a2, i3, aadVar);
    }

    public final int h(k kVar, int i, boolean z) throws IOException {
        c(this.g + i);
        int a2 = kVar.a(this.f, this.g, i);
        if (a2 != -1) {
            this.g += a2;
            return a2;
        }
        if (z) {
            return -1;
        }
        throw new EOFException();
    }

    public final void i(cj cjVar, int i) {
        c(this.g + i);
        cjVar.A(this.f, this.g, i);
        this.g += i;
    }
}
