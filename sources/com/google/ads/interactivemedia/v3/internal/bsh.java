package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bsh extends bpb {
    static final int[] a = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296, 433494437, 701408733, 1134903170, 1836311903, Integer.MAX_VALUE};
    private static final long serialVersionUID = 1;
    private final int c;
    private final bpb d;
    private final bpb e;
    private final int f;
    private final int g;

    private bsh(bpb bpbVar, bpb bpbVar2) {
        this.d = bpbVar;
        this.e = bpbVar2;
        int d = bpbVar.d();
        this.f = d;
        this.c = d + bpbVar2.d();
        this.g = Math.max(bpbVar.f(), bpbVar2.f()) + 1;
    }

    public static /* bridge */ /* synthetic */ bpb D(bsh bshVar) {
        return bshVar.e;
    }

    public static bpb E(bpb bpbVar, bpb bpbVar2) {
        if (bpbVar2.d() == 0) {
            return bpbVar;
        }
        if (bpbVar.d() == 0) {
            return bpbVar2;
        }
        int d = bpbVar.d() + bpbVar2.d();
        if (d < 128) {
            return F(bpbVar, bpbVar2);
        }
        if (bpbVar instanceof bsh) {
            bsh bshVar = (bsh) bpbVar;
            if (bshVar.e.d() + bpbVar2.d() < 128) {
                return new bsh(bshVar.d, F(bshVar.e, bpbVar2));
            }
            if (bshVar.d.f() > bshVar.e.f() && bshVar.g > bpbVar2.f()) {
                return new bsh(bshVar.d, new bsh(bshVar.e, bpbVar2));
            }
        }
        return d >= c(Math.max(bpbVar.f(), bpbVar2.f()) + 1) ? new bsh(bpbVar, bpbVar2) : bsf.a(new bsf(null), bpbVar, bpbVar2);
    }

    private static bpb F(bpb bpbVar, bpb bpbVar2) {
        int d = bpbVar.d();
        int d2 = bpbVar2.d();
        byte[] bArr = new byte[d + d2];
        bpbVar.C(bArr, 0, d);
        bpbVar2.C(bArr, d, d2);
        return bpb.x(bArr);
    }

    public static int c(int i) {
        int[] iArr = a;
        int length = iArr.length;
        if (i >= 47) {
            return Integer.MAX_VALUE;
        }
        return iArr[i];
    }

    public static /* bridge */ /* synthetic */ bpb g(bsh bshVar) {
        return bshVar.d;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("RopeByteStream instances are not to be serialized directly");
    }

    public final byte a(int i) {
        bpb.z(i, this.c);
        return b(i);
    }

    public final byte b(int i) {
        int i2 = this.f;
        return i < i2 ? this.d.b(i) : this.e.b(i - i2);
    }

    public final int d() {
        return this.c;
    }

    public final void e(byte[] bArr, int i, int i2, int i3) {
        int i4 = this.f;
        if (i + i3 <= i4) {
            this.d.e(bArr, i, i2, i3);
        } else {
            if (i >= i4) {
                this.e.e(bArr, i - i4, i2, i3);
                return;
            }
            int i5 = i4 - i;
            this.d.e(bArr, i, i2, i5);
            this.e.e(bArr, 0, i2 + i5, i3 - i5);
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof bpb)) {
            return false;
        }
        bpb bpbVar = (bpb) obj;
        if (this.c != bpbVar.d()) {
            return false;
        }
        if (this.c == 0) {
            return true;
        }
        int r = r();
        int r2 = bpbVar.r();
        if (r != 0 && r2 != 0 && r != r2) {
            return false;
        }
        bsg bsgVar = new bsg(this);
        boy next = bsgVar.next();
        bsg bsgVar2 = new bsg(bpbVar);
        boy next2 = bsgVar2.next();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int d = next.d() - i;
            int d2 = next2.d() - i2;
            int min = Math.min(d, d2);
            if (!(i == 0 ? next.g(next2, i2, min) : next2.g(next, i, min))) {
                return false;
            }
            i3 += min;
            int i4 = this.c;
            if (i3 >= i4) {
                if (i3 == i4) {
                    return true;
                }
                throw new IllegalStateException();
            }
            if (min == d) {
                i = 0;
                next = bsgVar.next();
            } else {
                i += min;
                next = next;
            }
            if (min == d2) {
                next2 = bsgVar2.next();
                i2 = 0;
            } else {
                i2 += min;
            }
        }
    }

    public final int f() {
        return this.g;
    }

    public final boolean h() {
        return this.c >= c(this.g);
    }

    public final int i(int i, int i2, int i3) {
        int i4 = this.f;
        if (i2 + i3 <= i4) {
            return this.d.i(i, i2, i3);
        }
        if (i2 >= i4) {
            return this.e.i(i, i2 - i4, i3);
        }
        int i5 = i4 - i2;
        return this.e.i(this.d.i(i, i2, i5), 0, i3 - i5);
    }

    public final /* bridge */ /* synthetic */ Iterator iterator() {
        return iterator();
    }

    public final int j(int i, int i2, int i3) {
        int i4 = this.f;
        if (i2 + i3 <= i4) {
            return this.d.j(i, i2, i3);
        }
        if (i2 >= i4) {
            return this.e.j(i, i2 - i4, i3);
        }
        int i5 = i4 - i2;
        return this.e.j(this.d.j(i, i2, i5), 0, i3 - i5);
    }

    public final bpb k(int i, int i2) {
        int q = bpb.q(i, i2, this.c);
        if (q == 0) {
            return bpb.b;
        }
        if (q == this.c) {
            return this;
        }
        int i3 = this.f;
        if (i2 <= i3) {
            return this.d.k(i, i2);
        }
        if (i >= i3) {
            return this.e.k(i - i3, i2 - i3);
        }
        bpb bpbVar = this.d;
        return new bsh(bpbVar.k(i, bpbVar.d()), this.e.k(0, i2 - this.f));
    }

    public final bpg l() {
        ArrayList<ByteBuffer> arrayList = new ArrayList();
        bsg bsgVar = new bsg(this);
        while (bsgVar.hasNext()) {
            arrayList.add(bsgVar.next().n());
        }
        int i = bpg.e;
        int i2 = 0;
        int i3 = 0;
        for (ByteBuffer byteBuffer : arrayList) {
            i3 += byteBuffer.remaining();
            i2 = byteBuffer.hasArray() ? i2 | 1 : byteBuffer.isDirect() ? i2 | 2 : i2 | 4;
        }
        return i2 == 2 ? new bpe(arrayList, i3) : new bpf(new bqx(arrayList));
    }

    public final String m(Charset charset) {
        return new String(B(), charset);
    }

    public final ByteBuffer n() {
        throw null;
    }

    public final boolean o() {
        int j = this.d.j(0, 0, this.f);
        bpb bpbVar = this.e;
        return bpbVar.j(j, 0, bpbVar.d()) == 0;
    }

    public final void p(bpd bpdVar) throws IOException {
        this.d.p(bpdVar);
        this.e.p(bpdVar);
    }

    public final box s() {
        return new bse(this);
    }

    public Object writeReplace() {
        return bpb.x(B());
    }

    public /* synthetic */ bsh(bpb bpbVar, bpb bpbVar2, byte[] bArr) {
        this(bpbVar, bpbVar2);
    }
}
