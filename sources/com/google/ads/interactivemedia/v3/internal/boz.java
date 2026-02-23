package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
class boz extends boy {
    private static final long serialVersionUID = 1;
    protected final byte[] a;

    public boz(byte[] bArr) {
        bArr.getClass();
        this.a = bArr;
    }

    public byte a(int i) {
        return this.a[i];
    }

    public byte b(int i) {
        return this.a[i];
    }

    public int c() {
        return 0;
    }

    public int d() {
        return this.a.length;
    }

    public void e(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.a, i, bArr, i2, i3);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof bpb) || d() != ((bpb) obj).d()) {
            return false;
        }
        if (d() == 0) {
            return true;
        }
        if (!(obj instanceof boz)) {
            return obj.equals(this);
        }
        boz bozVar = (boz) obj;
        int r = r();
        int r2 = bozVar.r();
        if (r == 0 || r2 == 0 || r == r2) {
            return g(bozVar, 0, d());
        }
        return false;
    }

    public final boolean g(bpb bpbVar, int i, int i2) {
        if (i2 > bpbVar.d()) {
            throw new IllegalArgumentException("Length too large: " + i2 + d());
        }
        int i3 = i + i2;
        if (i3 > bpbVar.d()) {
            throw new IllegalArgumentException("Ran off end of other: " + i + ", " + i2 + ", " + bpbVar.d());
        }
        if (!(bpbVar instanceof boz)) {
            return bpbVar.k(i, i3).equals(k(0, i2));
        }
        boz bozVar = (boz) bpbVar;
        byte[] bArr = this.a;
        byte[] bArr2 = bozVar.a;
        int c = c() + i2;
        int c2 = c();
        int c3 = bozVar.c() + i;
        while (c2 < c) {
            if (bArr[c2] != bArr2[c3]) {
                return false;
            }
            c2++;
            c3++;
        }
        return true;
    }

    public final int i(int i, int i2, int i3) {
        return bqu.d(i, this.a, c() + i2, i3);
    }

    public final int j(int i, int i2, int i3) {
        int c = c() + i2;
        return btj.f(i, this.a, c, i3 + c);
    }

    public final bpb k(int i, int i2) {
        int q = bpb.q(i, i2, d());
        return q == 0 ? bpb.b : new bov(this.a, c() + i, q);
    }

    public final bpg l() {
        return bpg.H(this.a, c(), d(), true);
    }

    public final String m(Charset charset) {
        return new String(this.a, c(), d(), charset);
    }

    public final ByteBuffer n() {
        return ByteBuffer.wrap(this.a, c(), d()).asReadOnlyBuffer();
    }

    public final boolean o() {
        int c = c();
        return btj.j(this.a, c, d() + c);
    }

    public final void p(bpd bpdVar) throws IOException {
        ((bpk) bpdVar).ai(this.a, c(), d());
    }
}
