package s;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class f implements Cloneable {
    public static final Object f = new Object();
    public boolean a;
    public long[] c;
    public Object[] d;
    public int e;

    public f() {
        this(10);
    }

    public void b(long j, Object obj) {
        int i = this.e;
        if (i != 0 && j <= this.c[i - 1]) {
            k(j, obj);
            return;
        }
        if (this.a && i >= this.c.length) {
            f();
        }
        int i2 = this.e;
        if (i2 >= this.c.length) {
            int f2 = e.f(i2 + 1);
            long[] jArr = new long[f2];
            Object[] objArr = new Object[f2];
            long[] jArr2 = this.c;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr2 = this.d;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.c = jArr;
            this.d = objArr;
        }
        this.c[i2] = j;
        this.d[i2] = obj;
        this.e = i2 + 1;
    }

    public void d() {
        int i = this.e;
        Object[] objArr = this.d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.e = 0;
        this.a = false;
    }

    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public f clone() {
        try {
            f fVar = (f) super.clone();
            fVar.c = (long[]) this.c.clone();
            fVar.d = (Object[]) this.d.clone();
            return fVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public final void f() {
        int i = this.e;
        long[] jArr = this.c;
        Object[] objArr = this.d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f) {
                if (i3 != i2) {
                    jArr[i2] = jArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.a = false;
        this.e = i2;
    }

    public Object g(long j) {
        return h(j, null);
    }

    public Object h(long j, Object obj) {
        Object obj2;
        int b = e.b(this.c, this.e, j);
        return (b < 0 || (obj2 = this.d[b]) == f) ? obj : obj2;
    }

    public int i(long j) {
        if (this.a) {
            f();
        }
        return e.b(this.c, this.e, j);
    }

    public long j(int i) {
        if (this.a) {
            f();
        }
        return this.c[i];
    }

    public void k(long j, Object obj) {
        int b = e.b(this.c, this.e, j);
        if (b >= 0) {
            this.d[b] = obj;
            return;
        }
        int i = ~b;
        int i2 = this.e;
        if (i < i2) {
            Object[] objArr = this.d;
            if (objArr[i] == f) {
                this.c[i] = j;
                objArr[i] = obj;
                return;
            }
        }
        if (this.a && i2 >= this.c.length) {
            f();
            i = ~e.b(this.c, this.e, j);
        }
        int i3 = this.e;
        if (i3 >= this.c.length) {
            int f2 = e.f(i3 + 1);
            long[] jArr = new long[f2];
            Object[] objArr2 = new Object[f2];
            long[] jArr2 = this.c;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.d;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.c = jArr;
            this.d = objArr2;
        }
        int i4 = this.e;
        if (i4 - i != 0) {
            long[] jArr3 = this.c;
            int i5 = i + 1;
            System.arraycopy(jArr3, i, jArr3, i5, i4 - i);
            Object[] objArr4 = this.d;
            System.arraycopy(objArr4, i, objArr4, i5, this.e - i);
        }
        this.c[i] = j;
        this.d[i] = obj;
        this.e++;
    }

    public void l(long j) {
        int b = e.b(this.c, this.e, j);
        if (b >= 0) {
            Object[] objArr = this.d;
            Object obj = objArr[b];
            Object obj2 = f;
            if (obj != obj2) {
                objArr[b] = obj2;
                this.a = true;
            }
        }
    }

    public void m(int i) {
        Object[] objArr = this.d;
        Object obj = objArr[i];
        Object obj2 = f;
        if (obj != obj2) {
            objArr[i] = obj2;
            this.a = true;
        }
    }

    public int n() {
        if (this.a) {
            f();
        }
        return this.e;
    }

    public Object o(int i) {
        if (this.a) {
            f();
        }
        return this.d[i];
    }

    public String toString() {
        if (n() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.e * 28);
        sb.append('{');
        for (int i = 0; i < this.e; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(j(i));
            sb.append('=');
            Object o = o(i);
            if (o != this) {
                sb.append(o);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public f(int i) {
        this.a = false;
        if (i == 0) {
            this.c = e.b;
            this.d = e.c;
        } else {
            int f2 = e.f(i);
            this.c = new long[f2];
            this.d = new Object[f2];
        }
    }
}
