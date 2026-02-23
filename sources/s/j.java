package s;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class j implements Cloneable {
    public static final Object f = new Object();
    public boolean a;
    public int[] c;
    public Object[] d;
    public int e;

    public j() {
        this(10);
    }

    public void b(int i, Object obj) {
        int i2 = this.e;
        if (i2 != 0 && i <= this.c[i2 - 1]) {
            k(i, obj);
            return;
        }
        if (this.a && i2 >= this.c.length) {
            f();
        }
        int i3 = this.e;
        if (i3 >= this.c.length) {
            int e = e.e(i3 + 1);
            int[] iArr = new int[e];
            Object[] objArr = new Object[e];
            int[] iArr2 = this.c;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr2 = this.d;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.c = iArr;
            this.d = objArr;
        }
        this.c[i3] = i;
        this.d[i3] = obj;
        this.e = i3 + 1;
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
    public j clone() {
        try {
            j jVar = (j) super.clone();
            jVar.c = (int[]) this.c.clone();
            jVar.d = (Object[]) this.d.clone();
            return jVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public final void f() {
        int i = this.e;
        int[] iArr = this.c;
        Object[] objArr = this.d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.a = false;
        this.e = i2;
    }

    public Object g(int i) {
        return h(i, null);
    }

    public Object h(int i, Object obj) {
        Object obj2;
        int a = e.a(this.c, this.e, i);
        return (a < 0 || (obj2 = this.d[a]) == f) ? obj : obj2;
    }

    public int i(Object obj) {
        if (this.a) {
            f();
        }
        for (int i = 0; i < this.e; i++) {
            if (this.d[i] == obj) {
                return i;
            }
        }
        return -1;
    }

    public int j(int i) {
        if (this.a) {
            f();
        }
        return this.c[i];
    }

    public void k(int i, Object obj) {
        int a = e.a(this.c, this.e, i);
        if (a >= 0) {
            this.d[a] = obj;
            return;
        }
        int i2 = ~a;
        int i3 = this.e;
        if (i2 < i3) {
            Object[] objArr = this.d;
            if (objArr[i2] == f) {
                this.c[i2] = i;
                objArr[i2] = obj;
                return;
            }
        }
        if (this.a && i3 >= this.c.length) {
            f();
            i2 = ~e.a(this.c, this.e, i);
        }
        int i4 = this.e;
        if (i4 >= this.c.length) {
            int e = e.e(i4 + 1);
            int[] iArr = new int[e];
            Object[] objArr2 = new Object[e];
            int[] iArr2 = this.c;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.d;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.c = iArr;
            this.d = objArr2;
        }
        int i5 = this.e;
        if (i5 - i2 != 0) {
            int[] iArr3 = this.c;
            int i6 = i2 + 1;
            System.arraycopy(iArr3, i2, iArr3, i6, i5 - i2);
            Object[] objArr4 = this.d;
            System.arraycopy(objArr4, i2, objArr4, i6, this.e - i2);
        }
        this.c[i2] = i;
        this.d[i2] = obj;
        this.e++;
    }

    public void l(int i) {
        Object[] objArr = this.d;
        Object obj = objArr[i];
        Object obj2 = f;
        if (obj != obj2) {
            objArr[i] = obj2;
            this.a = true;
        }
    }

    public int m() {
        if (this.a) {
            f();
        }
        return this.e;
    }

    public Object n(int i) {
        if (this.a) {
            f();
        }
        return this.d[i];
    }

    public String toString() {
        if (m() <= 0) {
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
            Object n = n(i);
            if (n != this) {
                sb.append(n);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public j(int i) {
        this.a = false;
        if (i == 0) {
            this.c = e.a;
            this.d = e.c;
        } else {
            int e = e.e(i);
            this.c = new int[e];
            this.d = new Object[e];
        }
    }
}
