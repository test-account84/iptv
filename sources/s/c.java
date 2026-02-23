package s;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class c {
    public Object[] a;
    public int b;
    public int c;
    public int d;

    public c(int i) {
        if (i < 1) {
            throw new IllegalArgumentException("capacity must be >= 1");
        }
        if (i > 1073741824) {
            throw new IllegalArgumentException("capacity must be <= 2^30");
        }
        i = Integer.bitCount(i) != 1 ? Integer.highestOneBit(i - 1) << 1 : i;
        this.d = i - 1;
        this.a = new Object[i];
    }

    public void a(Object obj) {
        int i = (this.b - 1) & this.d;
        this.b = i;
        this.a[i] = obj;
        if (i == this.c) {
            d();
        }
    }

    public void b(Object obj) {
        Object[] objArr = this.a;
        int i = this.c;
        objArr[i] = obj;
        int i2 = this.d & (i + 1);
        this.c = i2;
        if (i2 == this.b) {
            d();
        }
    }

    public void c() {
        g(h());
    }

    public final void d() {
        Object[] objArr = this.a;
        int length = objArr.length;
        int i = this.b;
        int i2 = length - i;
        int i3 = length << 1;
        if (i3 < 0) {
            throw new RuntimeException("Max array capacity exceeded");
        }
        Object[] objArr2 = new Object[i3];
        System.arraycopy(objArr, i, objArr2, 0, i2);
        System.arraycopy(this.a, 0, objArr2, i2, this.b);
        this.a = objArr2;
        this.b = 0;
        this.c = length;
        this.d = i3 - 1;
    }

    public Object e(int i) {
        if (i < 0 || i >= h()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return this.a[this.d & (this.b + i)];
    }

    public void f(int i) {
        int i2;
        if (i <= 0) {
            return;
        }
        if (i > h()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i3 = this.c;
        int i4 = i < i3 ? i3 - i : 0;
        int i5 = i4;
        while (true) {
            i2 = this.c;
            if (i5 >= i2) {
                break;
            }
            this.a[i5] = null;
            i5++;
        }
        int i6 = i2 - i4;
        int i7 = i - i6;
        this.c = i2 - i6;
        if (i7 > 0) {
            int length = this.a.length;
            this.c = length;
            int i8 = length - i7;
            for (int i9 = i8; i9 < this.c; i9++) {
                this.a[i9] = null;
            }
            this.c = i8;
        }
    }

    public void g(int i) {
        if (i <= 0) {
            return;
        }
        if (i > h()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int length = this.a.length;
        int i2 = this.b;
        if (i < length - i2) {
            length = i2 + i;
        }
        while (i2 < length) {
            this.a[i2] = null;
            i2++;
        }
        int i3 = this.b;
        int i4 = length - i3;
        int i5 = i - i4;
        this.b = this.d & (i3 + i4);
        if (i5 > 0) {
            for (int i6 = 0; i6 < i5; i6++) {
                this.a[i6] = null;
            }
            this.b = i5;
        }
    }

    public int h() {
        return (this.c - this.b) & this.d;
    }
}
