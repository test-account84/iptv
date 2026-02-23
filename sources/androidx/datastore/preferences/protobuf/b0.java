package androidx.datastore.preferences.protobuf;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class b0 extends c implements RandomAccess {
    public static final b0 e;
    public Object[] c;
    public int d;

    static {
        b0 b0Var = new b0(new Object[0], 0);
        e = b0Var;
        b0Var.k();
    }

    public b0(Object[] objArr, int i) {
        this.c = objArr;
        this.d = i;
    }

    public static Object[] e(int i) {
        return new Object[i];
    }

    public static b0 f() {
        return e;
    }

    public void add(int i, Object obj) {
        int i2;
        d();
        if (i < 0 || i > (i2 = this.d)) {
            throw new IndexOutOfBoundsException(h(i));
        }
        Object[] objArr = this.c;
        if (i2 < objArr.length) {
            System.arraycopy(objArr, i, objArr, i + 1, i2 - i);
        } else {
            Object[] e2 = e(((i2 * 3) / 2) + 1);
            System.arraycopy(this.c, 0, e2, 0, i);
            System.arraycopy(this.c, i, e2, i + 1, this.d - i);
            this.c = e2;
        }
        this.c[i] = obj;
        this.d++;
        ((AbstractList) this).modCount++;
    }

    public final void g(int i) {
        if (i < 0 || i >= this.d) {
            throw new IndexOutOfBoundsException(h(i));
        }
    }

    public Object get(int i) {
        g(i);
        return this.c[i];
    }

    public final String h(int i) {
        return "Index:" + i + ", Size:" + this.d;
    }

    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public b0 w(int i) {
        if (i >= this.d) {
            return new b0(Arrays.copyOf(this.c, i), this.d);
        }
        throw new IllegalArgumentException();
    }

    public Object remove(int i) {
        d();
        g(i);
        Object[] objArr = this.c;
        Object obj = objArr[i];
        if (i < this.d - 1) {
            System.arraycopy(objArr, i + 1, objArr, i, (r2 - i) - 1);
        }
        this.d--;
        ((AbstractList) this).modCount++;
        return obj;
    }

    public Object set(int i, Object obj) {
        d();
        g(i);
        Object[] objArr = this.c;
        Object obj2 = objArr[i];
        objArr[i] = obj;
        ((AbstractList) this).modCount++;
        return obj2;
    }

    public int size() {
        return this.d;
    }

    public boolean add(Object obj) {
        d();
        int i = this.d;
        Object[] objArr = this.c;
        if (i == objArr.length) {
            this.c = Arrays.copyOf(objArr, ((i * 3) / 2) + 1);
        }
        Object[] objArr2 = this.c;
        int i2 = this.d;
        this.d = i2 + 1;
        objArr2[i2] = obj;
        ((AbstractList) this).modCount++;
        return true;
    }
}
