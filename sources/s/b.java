package s;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class b implements Collection, Set {
    public static final int[] f = new int[0];
    public static final Object[] g = new Object[0];
    public static Object[] h;
    public static int i;
    public static Object[] j;
    public static int k;
    public int[] a;
    public Object[] c;
    public int d;
    public h e;

    public class a extends h {
        public a() {
        }

        public void a() {
            b.this.clear();
        }

        public Object b(int i, int i2) {
            return b.this.c[i];
        }

        public Map c() {
            throw new UnsupportedOperationException("not a map");
        }

        public int d() {
            return b.this.d;
        }

        public int e(Object obj) {
            return b.this.indexOf(obj);
        }

        public int f(Object obj) {
            return b.this.indexOf(obj);
        }

        public void g(Object obj, Object obj2) {
            b.this.add(obj);
        }

        public void h(int i) {
            b.this.g(i);
        }

        public Object i(int i, Object obj) {
            throw new UnsupportedOperationException("not a map");
        }
    }

    public b() {
        this(0);
    }

    public static void c(int[] iArr, Object[] objArr, int i2) {
        if (iArr.length == 8) {
            synchronized (b.class) {
                try {
                    if (k < 10) {
                        objArr[0] = j;
                        objArr[1] = iArr;
                        for (int i3 = i2 - 1; i3 >= 2; i3--) {
                            objArr[i3] = null;
                        }
                        j = objArr;
                        k++;
                    }
                } finally {
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (b.class) {
                try {
                    if (i < 10) {
                        objArr[0] = h;
                        objArr[1] = iArr;
                        for (int i4 = i2 - 1; i4 >= 2; i4--) {
                            objArr[i4] = null;
                        }
                        h = objArr;
                        i++;
                    }
                } finally {
                }
            }
        }
    }

    public final void a(int i2) {
        if (i2 == 8) {
            synchronized (b.class) {
                try {
                    Object[] objArr = j;
                    if (objArr != null) {
                        this.c = objArr;
                        j = (Object[]) objArr[0];
                        this.a = (int[]) objArr[1];
                        objArr[1] = null;
                        objArr[0] = null;
                        k--;
                        return;
                    }
                } finally {
                }
            }
        } else if (i2 == 4) {
            synchronized (b.class) {
                try {
                    Object[] objArr2 = h;
                    if (objArr2 != null) {
                        this.c = objArr2;
                        h = (Object[]) objArr2[0];
                        this.a = (int[]) objArr2[1];
                        objArr2[1] = null;
                        objArr2[0] = null;
                        i--;
                        return;
                    }
                } finally {
                }
            }
        }
        this.a = new int[i2];
        this.c = new Object[i2];
    }

    public boolean add(Object obj) {
        int i2;
        int e;
        if (obj == null) {
            e = f();
            i2 = 0;
        } else {
            int hashCode = obj.hashCode();
            i2 = hashCode;
            e = e(obj, hashCode);
        }
        if (e >= 0) {
            return false;
        }
        int i3 = ~e;
        int i4 = this.d;
        int[] iArr = this.a;
        if (i4 >= iArr.length) {
            int i5 = 8;
            if (i4 >= 8) {
                i5 = (i4 >> 1) + i4;
            } else if (i4 < 4) {
                i5 = 4;
            }
            Object[] objArr = this.c;
            a(i5);
            int[] iArr2 = this.a;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.c, 0, objArr.length);
            }
            c(iArr, objArr, this.d);
        }
        int i6 = this.d;
        if (i3 < i6) {
            int[] iArr3 = this.a;
            int i7 = i3 + 1;
            System.arraycopy(iArr3, i3, iArr3, i7, i6 - i3);
            Object[] objArr2 = this.c;
            System.arraycopy(objArr2, i3, objArr2, i7, this.d - i3);
        }
        this.a[i3] = i2;
        this.c[i3] = obj;
        this.d++;
        return true;
    }

    public boolean addAll(Collection collection) {
        b(this.d + collection.size());
        Iterator it = collection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            z |= add(it.next());
        }
        return z;
    }

    public void b(int i2) {
        int[] iArr = this.a;
        if (iArr.length < i2) {
            Object[] objArr = this.c;
            a(i2);
            int i3 = this.d;
            if (i3 > 0) {
                System.arraycopy(iArr, 0, this.a, 0, i3);
                System.arraycopy(objArr, 0, this.c, 0, this.d);
            }
            c(iArr, objArr, this.d);
        }
    }

    public void clear() {
        int i2 = this.d;
        if (i2 != 0) {
            c(this.a, this.c, i2);
            this.a = f;
            this.c = g;
            this.d = 0;
        }
    }

    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    public boolean containsAll(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public final h d() {
        if (this.e == null) {
            this.e = new a();
        }
        return this.e;
    }

    public final int e(Object obj, int i2) {
        int i3 = this.d;
        if (i3 == 0) {
            return -1;
        }
        int a2 = e.a(this.a, i3, i2);
        if (a2 < 0) {
            return a2;
        }
        if (obj.equals(this.c[a2])) {
            return a2;
        }
        int i4 = a2 + 1;
        while (i4 < i3 && this.a[i4] == i2) {
            if (obj.equals(this.c[i4])) {
                return i4;
            }
            i4++;
        }
        for (int i5 = a2 - 1; i5 >= 0 && this.a[i5] == i2; i5--) {
            if (obj.equals(this.c[i5])) {
                return i5;
            }
        }
        return ~i4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (size() != set.size()) {
                return false;
            }
            for (int i2 = 0; i2 < this.d; i2++) {
                try {
                    if (!set.contains(h(i2))) {
                        return false;
                    }
                } catch (NullPointerException | ClassCastException unused) {
                }
            }
            return true;
        }
        return false;
    }

    public final int f() {
        int i2 = this.d;
        if (i2 == 0) {
            return -1;
        }
        int a2 = e.a(this.a, i2, 0);
        if (a2 < 0) {
            return a2;
        }
        if (this.c[a2] == null) {
            return a2;
        }
        int i3 = a2 + 1;
        while (i3 < i2 && this.a[i3] == 0) {
            if (this.c[i3] == null) {
                return i3;
            }
            i3++;
        }
        for (int i4 = a2 - 1; i4 >= 0 && this.a[i4] == 0; i4--) {
            if (this.c[i4] == null) {
                return i4;
            }
        }
        return ~i3;
    }

    public Object g(int i2) {
        Object[] objArr = this.c;
        Object obj = objArr[i2];
        int i3 = this.d;
        if (i3 <= 1) {
            c(this.a, objArr, i3);
            this.a = f;
            this.c = g;
            this.d = 0;
        } else {
            int[] iArr = this.a;
            if (iArr.length <= 8 || i3 >= iArr.length / 3) {
                int i4 = i3 - 1;
                this.d = i4;
                if (i2 < i4) {
                    int i5 = i2 + 1;
                    System.arraycopy(iArr, i5, iArr, i2, i4 - i2);
                    Object[] objArr2 = this.c;
                    System.arraycopy(objArr2, i5, objArr2, i2, this.d - i2);
                }
                this.c[this.d] = null;
            } else {
                a(i3 > 8 ? i3 + (i3 >> 1) : 8);
                this.d--;
                if (i2 > 0) {
                    System.arraycopy(iArr, 0, this.a, 0, i2);
                    System.arraycopy(objArr, 0, this.c, 0, i2);
                }
                int i6 = this.d;
                if (i2 < i6) {
                    int i7 = i2 + 1;
                    System.arraycopy(iArr, i7, this.a, i2, i6 - i2);
                    System.arraycopy(objArr, i7, this.c, i2, this.d - i2);
                }
            }
        }
        return obj;
    }

    public Object h(int i2) {
        return this.c[i2];
    }

    public int hashCode() {
        int[] iArr = this.a;
        int i2 = this.d;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            i3 += iArr[i4];
        }
        return i3;
    }

    public int indexOf(Object obj) {
        return obj == null ? f() : e(obj, obj.hashCode());
    }

    public boolean isEmpty() {
        return this.d <= 0;
    }

    public Iterator iterator() {
        return d().m().iterator();
    }

    public boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf < 0) {
            return false;
        }
        g(indexOf);
        return true;
    }

    public boolean removeAll(Collection collection) {
        Iterator it = collection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            z |= remove(it.next());
        }
        return z;
    }

    public boolean retainAll(Collection collection) {
        boolean z = false;
        for (int i2 = this.d - 1; i2 >= 0; i2--) {
            if (!collection.contains(this.c[i2])) {
                g(i2);
                z = true;
            }
        }
        return z;
    }

    public int size() {
        return this.d;
    }

    public Object[] toArray() {
        int i2 = this.d;
        Object[] objArr = new Object[i2];
        System.arraycopy(this.c, 0, objArr, 0, i2);
        return objArr;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.d * 14);
        sb.append('{');
        for (int i2 = 0; i2 < this.d; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            Object h2 = h(i2);
            if (h2 != this) {
                sb.append(h2);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public b(int i2) {
        if (i2 == 0) {
            this.a = f;
            this.c = g;
        } else {
            a(i2);
        }
        this.d = 0;
    }

    public Object[] toArray(Object[] objArr) {
        if (objArr.length < this.d) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), this.d);
        }
        System.arraycopy(this.c, 0, objArr, 0, this.d);
        int length = objArr.length;
        int i2 = this.d;
        if (length > i2) {
            objArr[i2] = null;
        }
        return objArr;
    }
}
