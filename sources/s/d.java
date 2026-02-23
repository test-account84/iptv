package s;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class d {
    public int[] a;
    public int b;
    public int c;
    public int d;

    public d() {
        this(8);
    }

    public void a(int i) {
        int[] iArr = this.a;
        int i2 = this.c;
        iArr[i2] = i;
        int i3 = this.d & (i2 + 1);
        this.c = i3;
        if (i3 == this.b) {
            c();
        }
    }

    public void b() {
        this.c = this.b;
    }

    public final void c() {
        int[] iArr = this.a;
        int length = iArr.length;
        int i = this.b;
        int i2 = length - i;
        int i3 = length << 1;
        if (i3 < 0) {
            throw new RuntimeException("Max array capacity exceeded");
        }
        int[] iArr2 = new int[i3];
        System.arraycopy(iArr, i, iArr2, 0, i2);
        System.arraycopy(this.a, 0, iArr2, i2, this.b);
        this.a = iArr2;
        this.b = 0;
        this.c = length;
        this.d = i3 - 1;
    }

    public int d(int i) {
        if (i < 0 || i >= g()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return this.a[this.d & (this.b + i)];
    }

    public int e() {
        int i = this.b;
        int i2 = this.c;
        if (i != i2) {
            return this.a[(i2 - 1) & this.d];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public int f() {
        int i = this.b;
        int i2 = this.c;
        if (i == i2) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i3 = this.d & (i2 - 1);
        int i4 = this.a[i3];
        this.c = i3;
        return i4;
    }

    public int g() {
        return (this.c - this.b) & this.d;
    }

    public d(int i) {
        if (i < 1) {
            throw new IllegalArgumentException("capacity must be >= 1");
        }
        if (i > 1073741824) {
            throw new IllegalArgumentException("capacity must be <= 2^30");
        }
        i = Integer.bitCount(i) != 1 ? Integer.highestOneBit(i - 1) << 1 : i;
        this.d = i - 1;
        this.a = new int[i];
    }
}
