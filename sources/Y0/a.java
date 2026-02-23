package y0;

import android.graphics.Color;
import android.util.TimingLogger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import y0.b;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class a {
    public static final Comparator g = new a();
    public final int[] a;
    public final int[] b;
    public final List c;
    public final b.c[] e;
    public final float[] f = new float[3];
    public final TimingLogger d = null;

    public static class a implements Comparator {
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(b bVar, b bVar2) {
            return bVar2.g() - bVar.g();
        }
    }

    public class b {
        public int a;
        public int b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;
        public int h;
        public int i;

        public b(int i, int i2) {
            this.a = i;
            this.b = i2;
            c();
        }

        public final boolean a() {
            return e() > 1;
        }

        public final int b() {
            int f = f();
            a aVar = a.this;
            int[] iArr = aVar.a;
            int[] iArr2 = aVar.b;
            a.e(iArr, f, this.a, this.b);
            Arrays.sort(iArr, this.a, this.b + 1);
            a.e(iArr, f, this.a, this.b);
            int i = this.c / 2;
            int i2 = this.a;
            int i3 = 0;
            while (true) {
                int i4 = this.b;
                if (i2 > i4) {
                    return this.a;
                }
                i3 += iArr2[iArr[i2]];
                if (i3 >= i) {
                    return Math.min(i4 - 1, i2);
                }
                i2++;
            }
        }

        public final void c() {
            a aVar = a.this;
            int[] iArr = aVar.a;
            int[] iArr2 = aVar.b;
            int i = Integer.MAX_VALUE;
            int i2 = Integer.MAX_VALUE;
            int i3 = Integer.MAX_VALUE;
            int i4 = Integer.MIN_VALUE;
            int i5 = Integer.MIN_VALUE;
            int i6 = Integer.MIN_VALUE;
            int i7 = 0;
            for (int i8 = this.a; i8 <= this.b; i8++) {
                int i9 = iArr[i8];
                i7 += iArr2[i9];
                int k = a.k(i9);
                int j = a.j(i9);
                int i10 = a.i(i9);
                if (k > i4) {
                    i4 = k;
                }
                if (k < i) {
                    i = k;
                }
                if (j > i5) {
                    i5 = j;
                }
                if (j < i2) {
                    i2 = j;
                }
                if (i10 > i6) {
                    i6 = i10;
                }
                if (i10 < i3) {
                    i3 = i10;
                }
            }
            this.d = i;
            this.e = i4;
            this.f = i2;
            this.g = i5;
            this.h = i3;
            this.i = i6;
            this.c = i7;
        }

        public final b.e d() {
            a aVar = a.this;
            int[] iArr = aVar.a;
            int[] iArr2 = aVar.b;
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            for (int i5 = this.a; i5 <= this.b; i5++) {
                int i6 = iArr[i5];
                int i7 = iArr2[i6];
                i2 += i7;
                i += a.k(i6) * i7;
                i3 += a.j(i6) * i7;
                i4 += i7 * a.i(i6);
            }
            float f = i2;
            return new b.e(a.b(Math.round(i / f), Math.round(i3 / f), Math.round(i4 / f)), i2);
        }

        public final int e() {
            return (this.b + 1) - this.a;
        }

        public final int f() {
            int i = this.e - this.d;
            int i2 = this.g - this.f;
            int i3 = this.i - this.h;
            if (i < i2 || i < i3) {
                return (i2 < i || i2 < i3) ? -1 : -2;
            }
            return -3;
        }

        public final int g() {
            return ((this.e - this.d) + 1) * ((this.g - this.f) + 1) * ((this.i - this.h) + 1);
        }

        public final b h() {
            if (!a()) {
                throw new IllegalStateException("Can not split a box with only 1 color");
            }
            int b = b();
            b bVar = a.this.new b(b + 1, this.b);
            this.b = b;
            c();
            return bVar;
        }
    }

    public a(int[] iArr, int i, b.c[] cVarArr) {
        this.e = cVarArr;
        int[] iArr2 = new int[32768];
        this.b = iArr2;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            int g2 = g(iArr[i2]);
            iArr[i2] = g2;
            iArr2[g2] = iArr2[g2] + 1;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < 32768; i4++) {
            if (iArr2[i4] > 0 && l(i4)) {
                iArr2[i4] = 0;
            }
            if (iArr2[i4] > 0) {
                i3++;
            }
        }
        int[] iArr3 = new int[i3];
        this.a = iArr3;
        int i5 = 0;
        for (int i6 = 0; i6 < 32768; i6++) {
            if (iArr2[i6] > 0) {
                iArr3[i5] = i6;
                i5++;
            }
        }
        if (i3 > i) {
            this.c = h(i);
            return;
        }
        this.c = new ArrayList();
        for (int i7 = 0; i7 < i3; i7++) {
            int i8 = iArr3[i7];
            this.c.add(new b.e(a(i8), iArr2[i8]));
        }
    }

    public static int a(int i) {
        return b(k(i), j(i), i(i));
    }

    public static int b(int i, int i2, int i3) {
        return Color.rgb(f(i, 5, 8), f(i2, 5, 8), f(i3, 5, 8));
    }

    public static void e(int[] iArr, int i, int i2, int i3) {
        if (i == -2) {
            while (i2 <= i3) {
                int i4 = iArr[i2];
                iArr[i2] = i(i4) | (j(i4) << 10) | (k(i4) << 5);
                i2++;
            }
            return;
        }
        if (i != -1) {
            return;
        }
        while (i2 <= i3) {
            int i5 = iArr[i2];
            iArr[i2] = k(i5) | (i(i5) << 10) | (j(i5) << 5);
            i2++;
        }
    }

    public static int f(int i, int i2, int i3) {
        return (i3 > i2 ? i << (i3 - i2) : i >> (i2 - i3)) & ((1 << i3) - 1);
    }

    public static int g(int i) {
        return f(Color.blue(i), 8, 5) | (f(Color.red(i), 8, 5) << 10) | (f(Color.green(i), 8, 5) << 5);
    }

    public static int i(int i) {
        return i & 31;
    }

    public static int j(int i) {
        return (i >> 5) & 31;
    }

    public static int k(int i) {
        return (i >> 10) & 31;
    }

    public final List c(Collection collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            b.e d = ((b) it.next()).d();
            if (!n(d)) {
                arrayList.add(d);
            }
        }
        return arrayList;
    }

    public List d() {
        return this.c;
    }

    public final List h(int i) {
        PriorityQueue priorityQueue = new PriorityQueue(i, g);
        priorityQueue.offer(new b(0, this.a.length - 1));
        o(priorityQueue, i);
        return c(priorityQueue);
    }

    public final boolean l(int i) {
        int a2 = a(i);
        G.a.g(a2, this.f);
        return m(a2, this.f);
    }

    public final boolean m(int i, float[] fArr) {
        b.c[] cVarArr = this.e;
        if (cVarArr != null && cVarArr.length > 0) {
            int length = cVarArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (!this.e[i2].a(i, fArr)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean n(b.e eVar) {
        return m(eVar.e(), eVar.c());
    }

    public final void o(PriorityQueue priorityQueue, int i) {
        b bVar;
        while (priorityQueue.size() < i && (bVar = (b) priorityQueue.poll()) != null && bVar.a()) {
            priorityQueue.offer(bVar.h());
            priorityQueue.offer(bVar);
        }
    }
}
