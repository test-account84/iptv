package s;

import java.util.ConcurrentModificationException;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class i {
    public static Object[] e;
    public static int f;
    public static Object[] g;
    public static int h;
    public int[] a;
    public Object[] c;
    public int d;

    public i() {
        this.a = e.a;
        this.c = e.c;
        this.d = 0;
    }

    public static int c(int[] iArr, int i, int i2) {
        try {
            return e.a(iArr, i, i2);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public static void e(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (i.class) {
                try {
                    if (h < 10) {
                        objArr[0] = g;
                        objArr[1] = iArr;
                        for (int i2 = (i << 1) - 1; i2 >= 2; i2--) {
                            objArr[i2] = null;
                        }
                        g = objArr;
                        h++;
                    }
                } finally {
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (i.class) {
                try {
                    if (f < 10) {
                        objArr[0] = e;
                        objArr[1] = iArr;
                        for (int i3 = (i << 1) - 1; i3 >= 2; i3--) {
                            objArr[i3] = null;
                        }
                        e = objArr;
                        f++;
                    }
                } finally {
                }
            }
        }
    }

    public final void a(int i) {
        if (i == 8) {
            synchronized (i.class) {
                try {
                    Object[] objArr = g;
                    if (objArr != null) {
                        this.c = objArr;
                        g = (Object[]) objArr[0];
                        this.a = (int[]) objArr[1];
                        objArr[1] = null;
                        objArr[0] = null;
                        h--;
                        return;
                    }
                } finally {
                }
            }
        } else if (i == 4) {
            synchronized (i.class) {
                try {
                    Object[] objArr2 = e;
                    if (objArr2 != null) {
                        this.c = objArr2;
                        e = (Object[]) objArr2[0];
                        this.a = (int[]) objArr2[1];
                        objArr2[1] = null;
                        objArr2[0] = null;
                        f--;
                        return;
                    }
                } finally {
                }
            }
        }
        this.a = new int[i];
        this.c = new Object[i << 1];
    }

    public void clear() {
        int i = this.d;
        if (i > 0) {
            int[] iArr = this.a;
            Object[] objArr = this.c;
            this.a = e.a;
            this.c = e.c;
            this.d = 0;
            e(iArr, objArr, i);
        }
        if (this.d > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return g(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return i(obj) >= 0;
    }

    public void d(int i) {
        int i2 = this.d;
        int[] iArr = this.a;
        if (iArr.length < i) {
            Object[] objArr = this.c;
            a(i);
            if (this.d > 0) {
                System.arraycopy(iArr, 0, this.a, 0, i2);
                System.arraycopy(objArr, 0, this.c, 0, i2 << 1);
            }
            e(iArr, objArr, i2);
        }
        if (this.d != i2) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof i) {
            i iVar = (i) obj;
            if (size() != iVar.size()) {
                return false;
            }
            for (int i = 0; i < this.d; i++) {
                try {
                    Object j = j(i);
                    Object o = o(i);
                    Object obj2 = iVar.get(j);
                    if (o == null) {
                        if (obj2 != null || !iVar.containsKey(j)) {
                            return false;
                        }
                    } else if (!o.equals(obj2)) {
                        return false;
                    }
                } catch (NullPointerException | ClassCastException unused) {
                    return false;
                }
            }
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (size() != map.size()) {
                return false;
            }
            for (int i2 = 0; i2 < this.d; i2++) {
                try {
                    Object j2 = j(i2);
                    Object o2 = o(i2);
                    Object obj3 = map.get(j2);
                    if (o2 == null) {
                        if (obj3 != null || !map.containsKey(j2)) {
                            return false;
                        }
                    } else if (!o2.equals(obj3)) {
                        return false;
                    }
                } catch (NullPointerException | ClassCastException unused2) {
                }
            }
            return true;
        }
        return false;
    }

    public int f(Object obj, int i) {
        int i2 = this.d;
        if (i2 == 0) {
            return -1;
        }
        int c = c(this.a, i2, i);
        if (c < 0) {
            return c;
        }
        if (obj.equals(this.c[c << 1])) {
            return c;
        }
        int i3 = c + 1;
        while (i3 < i2 && this.a[i3] == i) {
            if (obj.equals(this.c[i3 << 1])) {
                return i3;
            }
            i3++;
        }
        for (int i4 = c - 1; i4 >= 0 && this.a[i4] == i; i4--) {
            if (obj.equals(this.c[i4 << 1])) {
                return i4;
            }
        }
        return ~i3;
    }

    public int g(Object obj) {
        return obj == null ? h() : f(obj, obj.hashCode());
    }

    public Object get(Object obj) {
        return getOrDefault(obj, null);
    }

    public Object getOrDefault(Object obj, Object obj2) {
        int g2 = g(obj);
        return g2 >= 0 ? this.c[(g2 << 1) + 1] : obj2;
    }

    public int h() {
        int i = this.d;
        if (i == 0) {
            return -1;
        }
        int c = c(this.a, i, 0);
        if (c < 0) {
            return c;
        }
        if (this.c[c << 1] == null) {
            return c;
        }
        int i2 = c + 1;
        while (i2 < i && this.a[i2] == 0) {
            if (this.c[i2 << 1] == null) {
                return i2;
            }
            i2++;
        }
        for (int i3 = c - 1; i3 >= 0 && this.a[i3] == 0; i3--) {
            if (this.c[i3 << 1] == null) {
                return i3;
            }
        }
        return ~i2;
    }

    public int hashCode() {
        int[] iArr = this.a;
        Object[] objArr = this.c;
        int i = this.d;
        int i2 = 1;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            Object obj = objArr[i2];
            i4 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i3];
            i3++;
            i2 += 2;
        }
        return i4;
    }

    public int i(Object obj) {
        int i = this.d * 2;
        Object[] objArr = this.c;
        if (obj == null) {
            for (int i2 = 1; i2 < i; i2 += 2) {
                if (objArr[i2] == null) {
                    return i2 >> 1;
                }
            }
            return -1;
        }
        for (int i3 = 1; i3 < i; i3 += 2) {
            if (obj.equals(objArr[i3])) {
                return i3 >> 1;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.d <= 0;
    }

    public Object j(int i) {
        return this.c[i << 1];
    }

    public void k(i iVar) {
        int i = iVar.d;
        d(this.d + i);
        if (this.d != 0) {
            for (int i2 = 0; i2 < i; i2++) {
                put(iVar.j(i2), iVar.o(i2));
            }
        } else if (i > 0) {
            System.arraycopy(iVar.a, 0, this.a, 0, i);
            System.arraycopy(iVar.c, 0, this.c, 0, i << 1);
            this.d = i;
        }
    }

    public Object m(int i) {
        Object[] objArr = this.c;
        int i2 = i << 1;
        Object obj = objArr[i2 + 1];
        int i3 = this.d;
        int i4 = 0;
        if (i3 <= 1) {
            e(this.a, objArr, i3);
            this.a = e.a;
            this.c = e.c;
        } else {
            int i5 = i3 - 1;
            int[] iArr = this.a;
            if (iArr.length <= 8 || i3 >= iArr.length / 3) {
                if (i < i5) {
                    int i6 = i + 1;
                    int i7 = i5 - i;
                    System.arraycopy(iArr, i6, iArr, i, i7);
                    Object[] objArr2 = this.c;
                    System.arraycopy(objArr2, i6 << 1, objArr2, i2, i7 << 1);
                }
                Object[] objArr3 = this.c;
                int i8 = i5 << 1;
                objArr3[i8] = null;
                objArr3[i8 + 1] = null;
            } else {
                a(i3 > 8 ? i3 + (i3 >> 1) : 8);
                if (i3 != this.d) {
                    throw new ConcurrentModificationException();
                }
                if (i > 0) {
                    System.arraycopy(iArr, 0, this.a, 0, i);
                    System.arraycopy(objArr, 0, this.c, 0, i2);
                }
                if (i < i5) {
                    int i9 = i + 1;
                    int i10 = i5 - i;
                    System.arraycopy(iArr, i9, this.a, i, i10);
                    System.arraycopy(objArr, i9 << 1, this.c, i2, i10 << 1);
                }
            }
            i4 = i5;
        }
        if (i3 != this.d) {
            throw new ConcurrentModificationException();
        }
        this.d = i4;
        return obj;
    }

    public Object n(int i, Object obj) {
        int i2 = (i << 1) + 1;
        Object[] objArr = this.c;
        Object obj2 = objArr[i2];
        objArr[i2] = obj;
        return obj2;
    }

    public Object o(int i) {
        return this.c[(i << 1) + 1];
    }

    public Object put(Object obj, Object obj2) {
        int i;
        int f2;
        int i2 = this.d;
        if (obj == null) {
            f2 = h();
            i = 0;
        } else {
            int hashCode = obj.hashCode();
            i = hashCode;
            f2 = f(obj, hashCode);
        }
        if (f2 >= 0) {
            int i3 = (f2 << 1) + 1;
            Object[] objArr = this.c;
            Object obj3 = objArr[i3];
            objArr[i3] = obj2;
            return obj3;
        }
        int i4 = ~f2;
        int[] iArr = this.a;
        if (i2 >= iArr.length) {
            int i5 = 8;
            if (i2 >= 8) {
                i5 = (i2 >> 1) + i2;
            } else if (i2 < 4) {
                i5 = 4;
            }
            Object[] objArr2 = this.c;
            a(i5);
            if (i2 != this.d) {
                throw new ConcurrentModificationException();
            }
            int[] iArr2 = this.a;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr2, 0, this.c, 0, objArr2.length);
            }
            e(iArr, objArr2, i2);
        }
        if (i4 < i2) {
            int[] iArr3 = this.a;
            int i6 = i4 + 1;
            System.arraycopy(iArr3, i4, iArr3, i6, i2 - i4);
            Object[] objArr3 = this.c;
            System.arraycopy(objArr3, i4 << 1, objArr3, i6 << 1, (this.d - i4) << 1);
        }
        int i7 = this.d;
        if (i2 == i7) {
            int[] iArr4 = this.a;
            if (i4 < iArr4.length) {
                iArr4[i4] = i;
                Object[] objArr4 = this.c;
                int i8 = i4 << 1;
                objArr4[i8] = obj;
                objArr4[i8 + 1] = obj2;
                this.d = i7 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public Object putIfAbsent(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 == null ? put(obj, obj2) : obj3;
    }

    public Object remove(Object obj) {
        int g2 = g(obj);
        if (g2 >= 0) {
            return m(g2);
        }
        return null;
    }

    public Object replace(Object obj, Object obj2) {
        int g2 = g(obj);
        if (g2 >= 0) {
            return n(g2, obj2);
        }
        return null;
    }

    public int size() {
        return this.d;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.d * 28);
        sb.append('{');
        for (int i = 0; i < this.d; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            Object j = j(i);
            if (j != this) {
                sb.append(j);
            } else {
                sb.append("(this Map)");
            }
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

    public i(int i) {
        if (i == 0) {
            this.a = e.a;
            this.c = e.c;
        } else {
            a(i);
        }
        this.d = 0;
    }

    public boolean remove(Object obj, Object obj2) {
        int g2 = g(obj);
        if (g2 < 0) {
            return false;
        }
        Object o = o(g2);
        if (obj2 != o && (obj2 == null || !obj2.equals(o))) {
            return false;
        }
        m(g2);
        return true;
    }

    public boolean replace(Object obj, Object obj2, Object obj3) {
        int g2 = g(obj);
        if (g2 < 0) {
            return false;
        }
        Object o = o(g2);
        if (o != obj2 && (obj2 == null || !obj2.equals(o))) {
            return false;
        }
        n(g2, obj3);
        return true;
    }

    public i(i iVar) {
        this();
        if (iVar != null) {
            k(iVar);
        }
    }
}
