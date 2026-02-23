package O2;

import O2.Q1;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class y1 extends O2.a {
    public final int j;
    public final int k;
    public final int[] l;
    public final int[] m;
    public final Q1[] n;
    public final Object[] o;
    public final HashMap p;

    public class a extends B3.s {
        public a(Q1 q1) {
            super(q1);
        }

        public Q1.b l(int i, Q1.b bVar, boolean z) {
            Q1.b l = super.l(i, bVar, z);
            l.g = true;
            return l;
        }
    }

    public y1(Collection collection, B3.a0 a0Var) {
        this(L(collection), M(collection), a0Var);
    }

    public static Q1[] L(Collection collection) {
        Q1[] q1Arr = new Q1[collection.size()];
        Iterator it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            q1Arr[i] = ((W0) it.next()).b();
            i++;
        }
        return q1Arr;
    }

    public static Object[] M(Collection collection) {
        Object[] objArr = new Object[collection.size()];
        Iterator it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            objArr[i] = ((W0) it.next()).a();
            i++;
        }
        return objArr;
    }

    public Object C(int i) {
        return this.o[i];
    }

    public int E(int i) {
        return this.l[i];
    }

    public int F(int i) {
        return this.m[i];
    }

    public Q1 I(int i) {
        return this.n[i];
    }

    public y1 J(B3.a0 a0Var) {
        Q1[] q1Arr = new Q1[this.n.length];
        int i = 0;
        while (true) {
            Q1[] q1Arr2 = this.n;
            if (i >= q1Arr2.length) {
                return new y1(q1Arr, this.o, a0Var);
            }
            q1Arr[i] = new a(q1Arr2[i]);
            i++;
        }
    }

    public List K() {
        return Arrays.asList(this.n);
    }

    public int n() {
        return this.k;
    }

    public int u() {
        return this.j;
    }

    public int x(Object obj) {
        Integer num = (Integer) this.p.get(obj);
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    public int y(int i) {
        return d4.k0.h(this.l, i + 1, false, false);
    }

    public int z(int i) {
        return d4.k0.h(this.m, i + 1, false, false);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y1(Q1[] q1Arr, Object[] objArr, B3.a0 a0Var) {
        super(false, a0Var);
        int i = 0;
        int length = q1Arr.length;
        this.n = q1Arr;
        this.l = new int[length];
        this.m = new int[length];
        this.o = objArr;
        this.p = new HashMap();
        int length2 = q1Arr.length;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i < length2) {
            Q1 q1 = q1Arr[i];
            this.n[i4] = q1;
            this.m[i4] = i2;
            this.l[i4] = i3;
            i2 += q1.u();
            i3 += this.n[i4].n();
            this.p.put(objArr[i4], Integer.valueOf(i4));
            i++;
            i4++;
        }
        this.j = i2;
        this.k = i3;
    }
}
