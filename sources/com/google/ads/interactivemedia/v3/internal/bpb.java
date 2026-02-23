package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class bpb implements Iterable, Serializable {
    private int c = 0;
    public static final bpb b = new boz(bqu.b);
    private static final bow a = new bpa(null);

    private static bpb c(Iterator it, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException(String.format("length (%s) must be >= 1", new Object[]{Integer.valueOf(i)}));
        }
        if (i == 1) {
            return (bpb) it.next();
        }
        int i2 = i >>> 1;
        bpb c = c(it, i2);
        bpb c2 = c(it, i - i2);
        if (Integer.MAX_VALUE - c.d() >= c2.d()) {
            return bsh.E(c, c2);
        }
        throw new IllegalArgumentException("ByteString would be too long: " + c.d() + "+" + c2.d());
    }

    public static int q(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            throw new IndexOutOfBoundsException("Beginning index: " + i + " < 0");
        }
        if (i2 < i) {
            throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i + ", " + i2);
        }
        throw new IndexOutOfBoundsException("End index: " + i2 + " >= " + i3);
    }

    public static bpb t(byte[] bArr) {
        return u(bArr, 0, bArr.length);
    }

    public static bpb u(byte[] bArr, int i, int i2) {
        q(i, i + i2, bArr.length);
        return new boz(a.a(bArr, i, i2));
    }

    public static bpb v(String str) {
        return new boz(str.getBytes(bqu.a));
    }

    public static bpb w(InputStream inputStream) throws IOException {
        ArrayList arrayList = new ArrayList();
        int i = 256;
        while (true) {
            byte[] bArr = new byte[i];
            int i2 = 0;
            while (i2 < i) {
                int read = inputStream.read(bArr, i2, i - i2);
                if (read == -1) {
                    break;
                }
                i2 += read;
            }
            bpb u = i2 == 0 ? null : u(bArr, 0, i2);
            if (u == null) {
                break;
            }
            arrayList.add(u);
            i = Math.min(i + i, 8192);
        }
        int size = arrayList.size();
        return size == 0 ? b : c(arrayList.iterator(), size);
    }

    public static bpb x(byte[] bArr) {
        return new boz(bArr);
    }

    public static void z(int i, int i2) {
        if (((i2 - (i + 1)) | i) < 0) {
            if (i < 0) {
                throw new ArrayIndexOutOfBoundsException("Index < 0: " + i);
            }
            throw new ArrayIndexOutOfBoundsException("Index > length: " + i + ", " + i2);
        }
    }

    public final boolean A() {
        return d() == 0;
    }

    public final byte[] B() {
        int d = d();
        if (d == 0) {
            return bqu.b;
        }
        byte[] bArr = new byte[d];
        e(bArr, 0, 0, d);
        return bArr;
    }

    @Deprecated
    public final void C(byte[] bArr, int i, int i2) {
        q(0, i2, d());
        q(i, i + i2, bArr.length);
        if (i2 > 0) {
            e(bArr, 0, i, i2);
        }
    }

    public abstract byte a(int i);

    public abstract byte b(int i);

    public abstract int d();

    public abstract void e(byte[] bArr, int i, int i2, int i3);

    public abstract boolean equals(Object obj);

    public abstract int f();

    public abstract boolean h();

    public final int hashCode() {
        int i = this.c;
        if (i == 0) {
            int d = d();
            i = i(d, 0, d);
            if (i == 0) {
                i = 1;
            }
            this.c = i;
        }
        return i;
    }

    public abstract int i(int i, int i2, int i3);

    public abstract int j(int i, int i2, int i3);

    public abstract bpb k(int i, int i2);

    public abstract bpg l();

    public abstract String m(Charset charset);

    public abstract ByteBuffer n();

    public abstract boolean o();

    public abstract void p(bpd bpdVar) throws IOException;

    public final int r() {
        return this.c;
    }

    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public box iterator() {
        return new bot(this);
    }

    public final String toString() {
        return String.format(Locale.ROOT, "<ByteString@%s size=%d contents=\"%s\">", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(d()), d() <= 50 ? bto.B(this) : String.valueOf(bto.B(k(0, 47))).concat("...")});
    }

    public final String y() {
        return d() == 0 ? "" : m(bqu.a);
    }
}
