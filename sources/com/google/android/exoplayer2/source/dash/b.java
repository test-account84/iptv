package com.google.android.exoplayer2.source.dash;

import B3.J;
import B3.Y;
import B3.Z;
import B3.g0;
import B3.i0;
import B3.r;
import B3.z;
import D3.i;
import F3.e;
import F3.g;
import F3.j;
import O2.H1;
import O2.z0;
import P2.v0;
import V2.w;
import V2.y;
import Z3.s;
import android.util.Pair;
import android.util.SparseArray;
import android.util.SparseIntArray;
import b4.F;
import b4.H;
import b4.S;
import b4.h;
import com.google.android.exoplayer2.source.dash.a;
import com.google.android.exoplayer2.source.dash.d;
import d4.k0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import w5.f;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class b implements z, Z.a, i.b {
    public final int a;
    public final a.a c;
    public final S d;
    public final y e;
    public final F f;
    public final E3.b g;
    public final long h;
    public final H i;
    public final b4.b j;
    public final i0 k;
    public final a[] l;
    public final B3.i m;
    public final d n;
    public final J.a p;
    public final w.a q;
    public final v0 r;
    public z.a s;
    public Z v;
    public F3.c w;
    public int x;
    public List y;
    public static final Pattern z = Pattern.compile("CC([1-4])=(.+)");
    public static final Pattern A = Pattern.compile("([1-4])=lang:(\\w+)(,.+)?");
    public i[] t = F(0);
    public E3.i[] u = new E3.i[0];
    public final IdentityHashMap o = new IdentityHashMap();

    public static final class a {
        public final int[] a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;
        public final int g;

        public a(int i, int i2, int[] iArr, int i3, int i4, int i5, int i6) {
            this.b = i;
            this.a = iArr;
            this.c = i2;
            this.e = i3;
            this.f = i4;
            this.g = i5;
            this.d = i6;
        }

        public static a a(int[] iArr, int i) {
            return new a(3, 1, iArr, i, -1, -1, -1);
        }

        public static a b(int[] iArr, int i) {
            return new a(5, 1, iArr, i, -1, -1, -1);
        }

        public static a c(int i) {
            return new a(5, 2, new int[0], -1, -1, -1, i);
        }

        public static a d(int i, int[] iArr, int i2, int i3, int i4) {
            return new a(i, 0, iArr, i2, i3, i4, -1);
        }
    }

    public b(int i, F3.c cVar, E3.b bVar, int i2, a.a aVar, S s, h hVar, y yVar, w.a aVar2, F f, J.a aVar3, long j, H h, b4.b bVar2, B3.i iVar, d.b bVar3, v0 v0Var) {
        this.a = i;
        this.w = cVar;
        this.g = bVar;
        this.x = i2;
        this.c = aVar;
        this.d = s;
        this.e = yVar;
        this.q = aVar2;
        this.f = f;
        this.p = aVar3;
        this.h = j;
        this.i = h;
        this.j = bVar2;
        this.m = iVar;
        this.r = v0Var;
        this.n = new d(cVar, bVar3, bVar2);
        this.v = iVar.a(this.t);
        g d = cVar.d(i2);
        List list = d.d;
        this.y = list;
        Pair t = t(yVar, d.c, list);
        this.k = (i0) t.first;
        this.l = (a[]) t.second;
    }

    public static int[][] A(List list) {
        int i;
        e w;
        int size = list.size();
        SparseIntArray sparseIntArray = new SparseIntArray(size);
        ArrayList arrayList = new ArrayList(size);
        SparseArray sparseArray = new SparseArray(size);
        for (int i2 = 0; i2 < size; i2++) {
            sparseIntArray.put(((F3.a) list.get(i2)).a, i2);
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(Integer.valueOf(i2));
            arrayList.add(arrayList2);
            sparseArray.put(i2, arrayList2);
        }
        for (int i3 = 0; i3 < size; i3++) {
            F3.a aVar = (F3.a) list.get(i3);
            e y = y(aVar.e);
            if (y == null) {
                y = y(aVar.f);
            }
            if (y == null || (i = sparseIntArray.get(Integer.parseInt(y.b), -1)) == -1) {
                i = i3;
            }
            if (i == i3 && (w = w(aVar.f)) != null) {
                for (String str : k0.i1(w.b, ",")) {
                    int i4 = sparseIntArray.get(Integer.parseInt(str), -1);
                    if (i4 != -1) {
                        i = Math.min(i, i4);
                    }
                }
            }
            if (i != i3) {
                List list2 = (List) sparseArray.get(i3);
                List list3 = (List) sparseArray.get(i);
                list3.addAll(list2);
                sparseArray.put(i3, list3);
                arrayList.remove(list2);
            }
        }
        int size2 = arrayList.size();
        int[][] iArr = new int[size2][];
        for (int i5 = 0; i5 < size2; i5++) {
            int[] l = f.l((Collection) arrayList.get(i5));
            iArr[i5] = l;
            Arrays.sort(l);
        }
        return iArr;
    }

    public static boolean D(List list, int[] iArr) {
        for (int i : iArr) {
            List list2 = ((F3.a) list.get(i)).c;
            for (int i2 = 0; i2 < list2.size(); i2++) {
                if (!((j) list2.get(i2)).e.isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int E(int i, List list, int[][] iArr, boolean[] zArr, z0[][] z0VarArr) {
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            if (D(list, iArr[i3])) {
                zArr[i3] = true;
                i2++;
            }
            z0[] z2 = z(list, iArr[i3]);
            z0VarArr[i3] = z2;
            if (z2.length != 0) {
                i2++;
            }
        }
        return i2;
    }

    public static i[] F(int i) {
        return new i[i];
    }

    public static z0[] H(e eVar, Pattern pattern, z0 z0Var) {
        String str = eVar.b;
        if (str == null) {
            return new z0[]{z0Var};
        }
        CharSequence[] i1 = k0.i1(str, ";");
        z0[] z0VarArr = new z0[i1.length];
        for (int i = 0; i < i1.length; i++) {
            Matcher matcher = pattern.matcher(i1[i]);
            if (!matcher.matches()) {
                return new z0[]{z0Var};
            }
            int parseInt = Integer.parseInt(matcher.group(1));
            z0VarArr[i] = z0Var.b().U(z0Var.a + ":" + parseInt).H(parseInt).X(matcher.group(2)).G();
        }
        return z0VarArr;
    }

    public static void o(List list, g0[] g0VarArr, a[] aVarArr, int i) {
        int i2 = 0;
        while (i2 < list.size()) {
            F3.f fVar = (F3.f) list.get(i2);
            g0VarArr[i] = new g0(fVar.a() + ":" + i2, new z0.b().U(fVar.a()).g0("application/x-emsg").G());
            aVarArr[i] = a.c(i2);
            i2++;
            i++;
        }
    }

    public static int q(y yVar, List list, int[][] iArr, int i, boolean[] zArr, z0[][] z0VarArr, g0[] g0VarArr, a[] aVarArr) {
        int i2;
        int i3;
        int i4 = 0;
        int i5 = 0;
        while (i4 < i) {
            int[] iArr2 = iArr[i4];
            ArrayList arrayList = new ArrayList();
            for (int i6 : iArr2) {
                arrayList.addAll(((F3.a) list.get(i6)).c);
            }
            int size = arrayList.size();
            z0[] z0VarArr2 = new z0[size];
            for (int i7 = 0; i7 < size; i7++) {
                z0 z0Var = ((j) arrayList.get(i7)).b;
                z0VarArr2[i7] = z0Var.c(yVar.a(z0Var));
            }
            F3.a aVar = (F3.a) list.get(iArr2[0]);
            int i8 = aVar.a;
            String num = i8 != -1 ? Integer.toString(i8) : "unset:" + i4;
            int i9 = i5 + 1;
            if (zArr[i4]) {
                i2 = i5 + 2;
            } else {
                i2 = i9;
                i9 = -1;
            }
            if (z0VarArr[i4].length != 0) {
                i3 = i2 + 1;
            } else {
                i3 = i2;
                i2 = -1;
            }
            g0VarArr[i5] = new g0(num, z0VarArr2);
            aVarArr[i5] = a.d(aVar.b, iArr2, i5, i9, i2);
            if (i9 != -1) {
                String str = num + ":emsg";
                g0VarArr[i9] = new g0(str, new z0.b().U(str).g0("application/x-emsg").G());
                aVarArr[i9] = a.b(iArr2, i5);
            }
            if (i2 != -1) {
                g0VarArr[i2] = new g0(num + ":cc", z0VarArr[i4]);
                aVarArr[i2] = a.a(iArr2, i5);
            }
            i4++;
            i5 = i3;
        }
        return i5;
    }

    public static Pair t(y yVar, List list, List list2) {
        int[][] A2 = A(list);
        int length = A2.length;
        boolean[] zArr = new boolean[length];
        z0[][] z0VarArr = new z0[length][];
        int E = E(length, list, A2, zArr, z0VarArr) + length + list2.size();
        g0[] g0VarArr = new g0[E];
        a[] aVarArr = new a[E];
        o(list2, g0VarArr, aVarArr, q(yVar, list, A2, length, zArr, z0VarArr, g0VarArr, aVarArr));
        return Pair.create(new i0(g0VarArr), aVarArr);
    }

    public static e w(List list) {
        return x(list, "urn:mpeg:dash:adaptation-set-switching:2016");
    }

    public static e x(List list, String str) {
        for (int i = 0; i < list.size(); i++) {
            e eVar = (e) list.get(i);
            if (str.equals(eVar.a)) {
                return eVar;
            }
        }
        return null;
    }

    public static e y(List list) {
        return x(list, "http://dashif.org/guidelines/trickmode");
    }

    public static z0[] z(List list, int[] iArr) {
        z0 G;
        Pattern pattern;
        for (int i : iArr) {
            F3.a aVar = (F3.a) list.get(i);
            List list2 = ((F3.a) list.get(i)).d;
            for (int i2 = 0; i2 < list2.size(); i2++) {
                e eVar = (e) list2.get(i2);
                if ("urn:scte:dash:cc:cea-608:2015".equals(eVar.a)) {
                    G = new z0.b().g0("application/cea-608").U(aVar.a + ":cea608").G();
                    pattern = z;
                } else if ("urn:scte:dash:cc:cea-708:2015".equals(eVar.a)) {
                    G = new z0.b().g0("application/cea-708").U(aVar.a + ":cea708").G();
                    pattern = A;
                }
                return H(eVar, pattern, G);
            }
        }
        return new z0[0];
    }

    public final int B(int i, int[] iArr) {
        int i2 = iArr[i];
        if (i2 == -1) {
            return -1;
        }
        int i3 = this.l[i2].e;
        for (int i4 = 0; i4 < iArr.length; i4++) {
            int i5 = iArr[i4];
            if (i5 == i3 && this.l[i5].c == 0) {
                return i4;
            }
        }
        return -1;
    }

    public final int[] C(s[] sVarArr) {
        int[] iArr = new int[sVarArr.length];
        for (int i = 0; i < sVarArr.length; i++) {
            s sVar = sVarArr[i];
            if (sVar != null) {
                iArr[i] = this.k.c(sVar.k());
            } else {
                iArr[i] = -1;
            }
        }
        return iArr;
    }

    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public void j(i iVar) {
        this.s.j(this);
    }

    public void I() {
        this.n.o();
        for (i iVar : this.t) {
            iVar.Q(this);
        }
        this.s = null;
    }

    public final void J(s[] sVarArr, boolean[] zArr, Y[] yArr) {
        for (int i = 0; i < sVarArr.length; i++) {
            if (sVarArr[i] == null || !zArr[i]) {
                Y y = yArr[i];
                if (y instanceof i) {
                    ((i) y).Q(this);
                } else if (y instanceof i.a) {
                    ((i.a) y).c();
                }
                yArr[i] = null;
            }
        }
    }

    public final void K(s[] sVarArr, Y[] yArr, int[] iArr) {
        boolean z2;
        for (int i = 0; i < sVarArr.length; i++) {
            Y y = yArr[i];
            if ((y instanceof r) || (y instanceof i.a)) {
                int B = B(i, iArr);
                if (B == -1) {
                    z2 = yArr[i] instanceof r;
                } else {
                    Y y2 = yArr[i];
                    z2 = (y2 instanceof i.a) && ((i.a) y2).a == yArr[B];
                }
                if (!z2) {
                    Y y3 = yArr[i];
                    if (y3 instanceof i.a) {
                        ((i.a) y3).c();
                    }
                    yArr[i] = null;
                }
            }
        }
    }

    public final void L(s[] sVarArr, Y[] yArr, boolean[] zArr, long j, int[] iArr) {
        for (int i = 0; i < sVarArr.length; i++) {
            s sVar = sVarArr[i];
            if (sVar != null) {
                Y y = yArr[i];
                if (y == null) {
                    zArr[i] = true;
                    a aVar = this.l[iArr[i]];
                    int i2 = aVar.c;
                    if (i2 == 0) {
                        yArr[i] = r(aVar, sVar, j);
                    } else if (i2 == 2) {
                        yArr[i] = new E3.i((F3.f) this.y.get(aVar.d), sVar.k().c(0), this.w.d);
                    }
                } else if (y instanceof i) {
                    ((com.google.android.exoplayer2.source.dash.a) ((i) y).E()).b(sVar);
                }
            }
        }
        for (int i3 = 0; i3 < sVarArr.length; i3++) {
            if (yArr[i3] == null && sVarArr[i3] != null) {
                a aVar2 = this.l[iArr[i3]];
                if (aVar2.c == 1) {
                    int B = B(i3, iArr);
                    if (B == -1) {
                        yArr[i3] = new r();
                    } else {
                        yArr[i3] = ((i) yArr[B]).T(j, aVar2.b);
                    }
                }
            }
        }
    }

    public void M(F3.c cVar, int i) {
        this.w = cVar;
        this.x = i;
        this.n.q(cVar);
        i[] iVarArr = this.t;
        if (iVarArr != null) {
            for (i iVar : iVarArr) {
                ((com.google.android.exoplayer2.source.dash.a) iVar.E()).i(cVar, i);
            }
            this.s.j(this);
        }
        this.y = cVar.d(i).d;
        for (E3.i iVar2 : this.u) {
            Iterator it = this.y.iterator();
            while (true) {
                if (it.hasNext()) {
                    F3.f fVar = (F3.f) it.next();
                    if (fVar.a().equals(iVar2.b())) {
                        iVar2.d(fVar, cVar.d && i == cVar.e() - 1);
                    }
                }
            }
        }
    }

    public synchronized void a(i iVar) {
        d.c cVar = (d.c) this.o.remove(iVar);
        if (cVar != null) {
            cVar.n();
        }
    }

    public boolean b() {
        return this.v.b();
    }

    public long c() {
        return this.v.c();
    }

    public long d(long j, H1 h1) {
        for (i iVar : this.t) {
            if (iVar.a == 2) {
                return iVar.d(j, h1);
            }
        }
        return j;
    }

    public boolean f(long j) {
        return this.v.f(j);
    }

    public long g() {
        return this.v.g();
    }

    public void h(long j) {
        this.v.h(j);
    }

    public long i(s[] sVarArr, boolean[] zArr, Y[] yArr, boolean[] zArr2, long j) {
        int[] C = C(sVarArr);
        J(sVarArr, zArr, yArr);
        K(sVarArr, yArr, C);
        L(sVarArr, yArr, zArr2, j, C);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Y y : yArr) {
            if (y instanceof i) {
                arrayList.add((i) y);
            } else if (y instanceof E3.i) {
                arrayList2.add((E3.i) y);
            }
        }
        i[] F = F(arrayList.size());
        this.t = F;
        arrayList.toArray(F);
        E3.i[] iVarArr = new E3.i[arrayList2.size()];
        this.u = iVarArr;
        arrayList2.toArray(iVarArr);
        this.v = this.m.a(this.t);
        return j;
    }

    public List k(List list) {
        List list2 = this.w.d(this.x).c;
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            s sVar = (s) it.next();
            a aVar = this.l[this.k.c(sVar.k())];
            if (aVar.c == 0) {
                int[] iArr = aVar.a;
                int length = sVar.length();
                int[] iArr2 = new int[length];
                for (int i = 0; i < sVar.length(); i++) {
                    iArr2[i] = sVar.d(i);
                }
                Arrays.sort(iArr2);
                int size = ((F3.a) list2.get(iArr[0])).c.size();
                int i2 = 0;
                int i3 = 0;
                for (int i4 = 0; i4 < length; i4++) {
                    int i5 = iArr2[i4];
                    while (true) {
                        int i6 = i3 + size;
                        if (i5 >= i6) {
                            i2++;
                            size = ((F3.a) list2.get(iArr[i2])).c.size();
                            i3 = i6;
                        }
                    }
                    arrayList.add(new z3.H(this.x, iArr[i2], i5 - i3));
                }
            }
        }
        return arrayList;
    }

    public long l(long j) {
        for (i iVar : this.t) {
            iVar.S(j);
        }
        for (E3.i iVar2 : this.u) {
            iVar2.c(j);
        }
        return j;
    }

    public long m() {
        return -9223372036854775807L;
    }

    public void p() {
        this.i.a();
    }

    public final i r(a aVar, s sVar, long j) {
        g0 g0Var;
        int i;
        g0 g0Var2;
        int i2;
        int i3 = aVar.f;
        boolean z2 = i3 != -1;
        d.c cVar = null;
        if (z2) {
            g0Var = this.k.b(i3);
            i = 1;
        } else {
            g0Var = null;
            i = 0;
        }
        int i4 = aVar.g;
        boolean z3 = i4 != -1;
        if (z3) {
            g0Var2 = this.k.b(i4);
            i += g0Var2.a;
        } else {
            g0Var2 = null;
        }
        z0[] z0VarArr = new z0[i];
        int[] iArr = new int[i];
        if (z2) {
            z0VarArr[0] = g0Var.c(0);
            iArr[0] = 5;
            i2 = 1;
        } else {
            i2 = 0;
        }
        List arrayList = new ArrayList();
        if (z3) {
            for (int i5 = 0; i5 < g0Var2.a; i5++) {
                z0 c = g0Var2.c(i5);
                z0VarArr[i2] = c;
                iArr[i2] = 3;
                arrayList.add(c);
                i2++;
            }
        }
        if (this.w.d && z2) {
            cVar = this.n.k();
        }
        d.c cVar2 = cVar;
        i iVar = new i(aVar.b, iArr, z0VarArr, this.c.a(this.i, this.w, this.g, this.x, aVar.a, sVar, aVar.b, this.h, z2, arrayList, cVar2, this.d, this.r, null), this, this.j, j, this.e, this.q, this.f, this.p);
        synchronized (this) {
            this.o.put(iVar, cVar2);
        }
        return iVar;
    }

    public void s(z.a aVar, long j) {
        this.s = aVar;
        aVar.e(this);
    }

    public i0 u() {
        return this.k;
    }

    public void v(long j, boolean z2) {
        for (i iVar : this.t) {
            iVar.v(j, z2);
        }
    }
}
