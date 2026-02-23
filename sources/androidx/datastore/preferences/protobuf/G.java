package androidx.datastore.preferences.protobuf;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class g implements Iterable, Serializable {
    public static final g c = new i(y.c);
    public static final f d;
    public static final Comparator e;
    public int a = 0;

    public class a extends c {
        public int a = 0;
        public final int c;

        public a() {
            this.c = g.this.size();
        }

        public byte h() {
            int i = this.a;
            if (i >= this.c) {
                throw new NoSuchElementException();
            }
            this.a = i + 1;
            return g.this.h(i);
        }

        public boolean hasNext() {
            return this.a < this.c;
        }
    }

    public static class b implements Comparator {
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(g gVar, g gVar2) {
            g j = gVar.j();
            g j2 = gVar2.j();
            while (j.hasNext() && j2.hasNext()) {
                int compare = Integer.compare(g.a(j.h()), g.a(j2.h()));
                if (compare != 0) {
                    return compare;
                }
            }
            return Integer.compare(gVar.size(), gVar2.size());
        }
    }

    public static abstract class c implements g {
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Byte next() {
            return Byte.valueOf(h());
        }

        public final void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static final class d implements f {
        public d() {
        }

        public byte[] a(byte[] bArr, int i, int i2) {
            return Arrays.copyOfRange(bArr, i, i2 + i);
        }

        public /* synthetic */ d(a aVar) {
            this();
        }
    }

    public static final class e extends i {
        public final int g;
        public final int h;

        public e(byte[] bArr, int i, int i2) {
            super(bArr);
            g.d(i, i + i2, bArr.length);
            this.g = i;
            this.h = i2;
        }

        public int B() {
            return this.g;
        }

        public byte b(int i) {
            g.c(i, size());
            return this.f[this.g + i];
        }

        public byte h(int i) {
            return this.f[this.g + i];
        }

        public int size() {
            return this.h;
        }
    }

    public interface f {
        byte[] a(byte[] bArr, int i, int i2);
    }

    public interface g extends Iterator {
        byte h();
    }

    public static abstract class h extends g {
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.j();
        }
    }

    public static class i extends h {
        public final byte[] f;

        public i(byte[] bArr) {
            bArr.getClass();
            this.f = bArr;
        }

        public final boolean A(g gVar, int i, int i2) {
            if (i2 > gVar.size()) {
                throw new IllegalArgumentException("Length too large: " + i2 + size());
            }
            int i3 = i + i2;
            if (i3 > gVar.size()) {
                throw new IllegalArgumentException("Ran off end of other: " + i + ", " + i2 + ", " + gVar.size());
            }
            if (!(gVar instanceof i)) {
                return gVar.o(i, i3).equals(o(0, i2));
            }
            i iVar = (i) gVar;
            byte[] bArr = this.f;
            byte[] bArr2 = iVar.f;
            int B = B() + i2;
            int B2 = B();
            int B3 = iVar.B() + i;
            while (B2 < B) {
                if (bArr[B2] != bArr2[B3]) {
                    return false;
                }
                B2++;
                B3++;
            }
            return true;
        }

        public int B() {
            return 0;
        }

        public byte b(int i) {
            return this.f[i];
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof g) || size() != ((g) obj).size()) {
                return false;
            }
            if (size() == 0) {
                return true;
            }
            if (!(obj instanceof i)) {
                return obj.equals(this);
            }
            i iVar = (i) obj;
            int n = n();
            int n2 = iVar.n();
            if (n == 0 || n2 == 0 || n == n2) {
                return A(iVar, 0, size());
            }
            return false;
        }

        public byte h(int i) {
            return this.f[i];
        }

        public final boolean i() {
            int B = B();
            return q0.n(this.f, B, size() + B);
        }

        public final int l(int i, int i2, int i3) {
            return y.i(i, this.f, B() + i2, i3);
        }

        public final g o(int i, int i2) {
            int d = g.d(i, i2, size());
            return d == 0 ? g.c : new e(this.f, B() + i, d);
        }

        public final String r(Charset charset) {
            return new String(this.f, B(), size(), charset);
        }

        public int size() {
            return this.f.length;
        }

        public final void z(androidx.datastore.preferences.protobuf.f fVar) {
            fVar.a(this.f, B(), size());
        }
    }

    public static final class j implements f {
        public j() {
        }

        public byte[] a(byte[] bArr, int i, int i2) {
            byte[] bArr2 = new byte[i2];
            System.arraycopy(bArr, i, bArr2, 0, i2);
            return bArr2;
        }

        public /* synthetic */ j(a aVar) {
            this();
        }
    }

    static {
        d = androidx.datastore.preferences.protobuf.d.c() ? new j(null) : new d(null);
        e = new b();
    }

    public static /* synthetic */ int a(byte b2) {
        return p(b2);
    }

    public static void c(int i2, int i3) {
        if (((i3 - (i2 + 1)) | i2) < 0) {
            if (i2 < 0) {
                throw new ArrayIndexOutOfBoundsException("Index < 0: " + i2);
            }
            throw new ArrayIndexOutOfBoundsException("Index > length: " + i2 + ", " + i3);
        }
    }

    public static int d(int i2, int i3, int i4) {
        int i5 = i3 - i2;
        if ((i2 | i3 | i5 | (i4 - i3)) >= 0) {
            return i5;
        }
        if (i2 < 0) {
            throw new IndexOutOfBoundsException("Beginning index: " + i2 + " < 0");
        }
        if (i3 < i2) {
            throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i2 + ", " + i3);
        }
        throw new IndexOutOfBoundsException("End index: " + i3 + " >= " + i4);
    }

    public static g e(byte[] bArr) {
        return f(bArr, 0, bArr.length);
    }

    public static g f(byte[] bArr, int i2, int i3) {
        d(i2, i2 + i3, bArr.length);
        return new i(d.a(bArr, i2, i3));
    }

    public static g g(String str) {
        return new i(str.getBytes(y.a));
    }

    public static int p(byte b2) {
        return b2 & 255;
    }

    public static g u(byte[] bArr) {
        return new i(bArr);
    }

    public static g y(byte[] bArr, int i2, int i3) {
        return new e(bArr, i2, i3);
    }

    public abstract byte b(int i2);

    public abstract boolean equals(Object obj);

    public abstract byte h(int i2);

    public final int hashCode() {
        int i2 = this.a;
        if (i2 == 0) {
            int size = size();
            i2 = l(size, 0, size);
            if (i2 == 0) {
                i2 = 1;
            }
            this.a = i2;
        }
        return i2;
    }

    public abstract boolean i();

    public g j() {
        return new a();
    }

    public abstract int l(int i2, int i3, int i4);

    public final int n() {
        return this.a;
    }

    public abstract g o(int i2, int i3);

    public final String q(Charset charset) {
        return size() == 0 ? "" : r(charset);
    }

    public abstract String r(Charset charset);

    public final String s() {
        return q(y.a);
    }

    public abstract int size();

    public final String toString() {
        return String.format("<ByteString@%s size=%d>", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size())});
    }

    public abstract void z(androidx.datastore.preferences.protobuf.f fVar);
}
