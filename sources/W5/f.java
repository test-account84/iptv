package w5;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;
import r5.m;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class f extends g {

    public static class a extends AbstractList implements RandomAccess, Serializable {
        public final int[] a;
        public final int c;
        public final int d;

        public a(int[] iArr) {
            this(iArr, 0, iArr.length);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer get(int i) {
            m.i(i, size());
            return Integer.valueOf(this.a[this.c + i]);
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Integer set(int i, Integer num) {
            m.i(i, size());
            int[] iArr = this.a;
            int i2 = this.c;
            int i3 = iArr[i2 + i];
            iArr[i2 + i] = ((Integer) m.k(num)).intValue();
            return Integer.valueOf(i3);
        }

        public boolean contains(Object obj) {
            return (obj instanceof Integer) && f.a(this.a, ((Integer) obj).intValue(), this.c, this.d) != -1;
        }

        public int[] d() {
            return Arrays.copyOfRange(this.a, this.c, this.d);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return super.equals(obj);
            }
            a aVar = (a) obj;
            int size = size();
            if (aVar.size() != size) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                if (this.a[this.c + i] != aVar.a[aVar.c + i]) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            int i = 1;
            for (int i2 = this.c; i2 < this.d; i2++) {
                i = (i * 31) + f.g(this.a[i2]);
            }
            return i;
        }

        public int indexOf(Object obj) {
            int a;
            if (!(obj instanceof Integer) || (a = f.a(this.a, ((Integer) obj).intValue(), this.c, this.d)) < 0) {
                return -1;
            }
            return a - this.c;
        }

        public boolean isEmpty() {
            return false;
        }

        public int lastIndexOf(Object obj) {
            int b;
            if (!(obj instanceof Integer) || (b = f.b(this.a, ((Integer) obj).intValue(), this.c, this.d)) < 0) {
                return -1;
            }
            return b - this.c;
        }

        public int size() {
            return this.d - this.c;
        }

        public List subList(int i, int i2) {
            m.o(i, i2, size());
            if (i == i2) {
                return Collections.emptyList();
            }
            int[] iArr = this.a;
            int i3 = this.c;
            return new a(iArr, i + i3, i3 + i2);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 5);
            sb.append('[');
            sb.append(this.a[this.c]);
            int i = this.c;
            while (true) {
                i++;
                if (i >= this.d) {
                    sb.append(']');
                    return sb.toString();
                }
                sb.append(", ");
                sb.append(this.a[i]);
            }
        }

        public a(int[] iArr, int i, int i2) {
            this.a = iArr;
            this.c = i;
            this.d = i2;
        }
    }

    public static /* synthetic */ int a(int[] iArr, int i, int i2, int i3) {
        return i(iArr, i, i2, i3);
    }

    public static /* synthetic */ int b(int[] iArr, int i, int i2, int i3) {
        return j(iArr, i, i2, i3);
    }

    public static List c(int... iArr) {
        return iArr.length == 0 ? Collections.emptyList() : new a(iArr);
    }

    public static int d(long j) {
        int i = (int) j;
        m.g(((long) i) == j, "Out of range: %s", j);
        return i;
    }

    public static int e(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i > i2 ? 1 : 0;
    }

    public static int f(int i, int i2, int i3) {
        m.f(i2 <= i3, "min (%s) must be less than or equal to max (%s)", i2, i3);
        return Math.min(Math.max(i, i2), i3);
    }

    public static int h(int[] iArr, int i) {
        return i(iArr, i, 0, iArr.length);
    }

    public static int i(int[] iArr, int i, int i2, int i3) {
        while (i2 < i3) {
            if (iArr[i2] == i) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static int j(int[] iArr, int i, int i2, int i3) {
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            if (iArr[i4] == i) {
                return i4;
            }
        }
        return -1;
    }

    public static int k(long j) {
        if (j > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (j < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) j;
    }

    public static int[] l(Collection collection) {
        if (collection instanceof a) {
            return ((a) collection).d();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = ((Number) m.k(array[i])).intValue();
        }
        return iArr;
    }

    public static int g(int i) {
        return i;
    }
}
