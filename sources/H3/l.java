package H3;

import B3.J;
import B3.Z;
import B3.g0;
import B3.i0;
import B3.z;
import H3.q;
import J3.g;
import J3.k;
import O2.H1;
import O2.z0;
import P2.v0;
import V2.w;
import V2.y;
import android.net.Uri;
import android.text.TextUtils;
import b4.F;
import b4.S;
import d4.k0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import z3.H;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class l implements z, k.b {
    public Z A;
    public final h a;
    public final J3.k c;
    public final g d;
    public final S e;
    public final y f;
    public final w.a g;
    public final F h;
    public final J.a i;
    public final b4.b j;
    public final B3.i m;
    public final boolean n;
    public final int o;
    public final boolean p;
    public final v0 q;
    public final long s;
    public z.a t;
    public int u;
    public i0 v;
    public int z;
    public final q.b r = new b(this, null);
    public final IdentityHashMap k = new IdentityHashMap();
    public final t l = new t();
    public q[] w = new q[0];
    public q[] x = new q[0];
    public int[][] y = new int[0][];

    public class b implements q.b {
        public b() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void j(q qVar) {
            l.q(l.this).j(l.this);
        }

        public void n(Uri uri) {
            l.r(l.this).g(uri);
        }

        public void onPrepared() {
            if (l.j(l.this) > 0) {
                return;
            }
            int i = 0;
            for (q qVar : l.n(l.this)) {
                i += qVar.u().a;
            }
            g0[] g0VarArr = new g0[i];
            int i2 = 0;
            for (q qVar2 : l.n(l.this)) {
                int i3 = qVar2.u().a;
                int i4 = 0;
                while (i4 < i3) {
                    g0VarArr[i2] = qVar2.u().b(i4);
                    i4++;
                    i2++;
                }
            }
            l.o(l.this, new i0(g0VarArr));
            l.q(l.this).e(l.this);
        }

        public /* synthetic */ b(l lVar, a aVar) {
            this();
        }
    }

    public l(h hVar, J3.k kVar, g gVar, S s, b4.h hVar2, y yVar, w.a aVar, F f, J.a aVar2, b4.b bVar, B3.i iVar, boolean z, int i, boolean z2, v0 v0Var, long j) {
        this.a = hVar;
        this.c = kVar;
        this.d = gVar;
        this.e = s;
        this.f = yVar;
        this.g = aVar;
        this.h = f;
        this.i = aVar2;
        this.j = bVar;
        this.m = iVar;
        this.n = z;
        this.o = i;
        this.p = z2;
        this.q = v0Var;
        this.s = j;
        this.A = iVar.a(new Z[0]);
    }

    public static Map A(List list) {
        ArrayList arrayList = new ArrayList(list);
        HashMap hashMap = new HashMap();
        int i = 0;
        while (i < arrayList.size()) {
            V2.m mVar = (V2.m) list.get(i);
            String str = mVar.d;
            i++;
            int i2 = i;
            while (i2 < arrayList.size()) {
                V2.m mVar2 = (V2.m) arrayList.get(i2);
                if (TextUtils.equals(mVar2.d, str)) {
                    mVar = mVar.g(mVar2);
                    arrayList.remove(i2);
                } else {
                    i2++;
                }
            }
            hashMap.put(str, mVar);
        }
        return hashMap;
    }

    public static z0 B(z0 z0Var) {
        String N = k0.N(z0Var.j, 2);
        return new z0.b().U(z0Var.a).W(z0Var.c).M(z0Var.l).g0(d4.F.g(N)).K(N).Z(z0Var.k).I(z0Var.g).b0(z0Var.h).n0(z0Var.r).S(z0Var.s).R(z0Var.t).i0(z0Var.e).e0(z0Var.f).G();
    }

    public static /* synthetic */ int j(l lVar) {
        int i = lVar.u - 1;
        lVar.u = i;
        return i;
    }

    public static /* synthetic */ q[] n(l lVar) {
        return lVar.w;
    }

    public static /* synthetic */ i0 o(l lVar, i0 i0Var) {
        lVar.v = i0Var;
        return i0Var;
    }

    public static /* synthetic */ z.a q(l lVar) {
        return lVar.t;
    }

    public static /* synthetic */ J3.k r(l lVar) {
        return lVar.c;
    }

    public static z0 z(z0 z0Var, z0 z0Var2, boolean z) {
        String N;
        q3.a aVar;
        int i;
        String str;
        String str2;
        int i2;
        int i3;
        if (z0Var2 != null) {
            N = z0Var2.j;
            aVar = z0Var2.k;
            i2 = z0Var2.z;
            i = z0Var2.e;
            i3 = z0Var2.f;
            str = z0Var2.d;
            str2 = z0Var2.c;
        } else {
            N = k0.N(z0Var.j, 1);
            aVar = z0Var.k;
            if (z) {
                i2 = z0Var.z;
                i = z0Var.e;
                i3 = z0Var.f;
                str = z0Var.d;
                str2 = z0Var.c;
            } else {
                i = 0;
                str = null;
                str2 = null;
                i2 = -1;
                i3 = 0;
            }
        }
        return new z0.b().U(z0Var.a).W(str2).M(z0Var.l).g0(d4.F.g(N)).K(N).Z(aVar).I(z ? z0Var.g : -1).b0(z ? z0Var.h : -1).J(i2).i0(i).e0(i3).X(str).G();
    }

    public void C() {
        this.c.f(this);
        for (q qVar : this.w) {
            qVar.h0();
        }
        this.t = null;
    }

    public boolean a(Uri uri, F.c cVar, boolean z) {
        boolean z2 = true;
        for (q qVar : this.w) {
            z2 &= qVar.c0(uri, cVar, z);
        }
        this.t.j(this);
        return z2;
    }

    public boolean b() {
        return this.A.b();
    }

    public long c() {
        return this.A.c();
    }

    public long d(long j, H1 h1) {
        for (q qVar : this.x) {
            if (qVar.S()) {
                return qVar.d(j, h1);
            }
        }
        return j;
    }

    public void e() {
        for (q qVar : this.w) {
            qVar.d0();
        }
        this.t.j(this);
    }

    public boolean f(long j) {
        if (this.v != null) {
            return this.A.f(j);
        }
        for (q qVar : this.w) {
            qVar.B();
        }
        return false;
    }

    public long g() {
        return this.A.g();
    }

    public void h(long j) {
        this.A.h(j);
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x00df  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long i(Z3.s[] r22, boolean[] r23, B3.Y[] r24, boolean[] r25, long r26) {
        /*
            Method dump skipped, instructions count: 275
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: H3.l.i(Z3.s[], boolean[], B3.Y[], boolean[], long):long");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v2, types: [int] */
    /* JADX WARN: Type inference failed for: r15v7 */
    public List k(List list) {
        int[] iArr;
        i0 i0Var;
        int i;
        l lVar = this;
        J3.g gVar = (J3.g) d4.a.e(lVar.c.e());
        boolean z = !gVar.e.isEmpty();
        int length = lVar.w.length - gVar.h.size();
        int i2 = 0;
        if (z) {
            q qVar = lVar.w[0];
            iArr = lVar.y[0];
            i0Var = qVar.u();
            i = qVar.M();
        } else {
            iArr = new int[0];
            i0Var = i0.e;
            i = 0;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        boolean z2 = false;
        boolean z3 = false;
        while (it.hasNext()) {
            Z3.s sVar = (Z3.s) it.next();
            g0 k = sVar.k();
            int c = i0Var.c(k);
            if (c == -1) {
                ?? r15 = z;
                while (true) {
                    q[] qVarArr = lVar.w;
                    if (r15 >= qVarArr.length) {
                        break;
                    }
                    if (qVarArr[r15].u().c(k) != -1) {
                        int i3 = r15 < length ? 1 : 2;
                        int[] iArr2 = lVar.y[r15];
                        for (int i4 = 0; i4 < sVar.length(); i4++) {
                            arrayList.add(new H(i3, iArr2[sVar.d(i4)]));
                        }
                    } else {
                        lVar = this;
                        r15++;
                    }
                }
            } else if (c == i) {
                for (int i5 = 0; i5 < sVar.length(); i5++) {
                    arrayList.add(new H(i2, iArr[sVar.d(i5)]));
                }
                z3 = true;
            } else {
                z2 = true;
            }
            lVar = this;
            i2 = 0;
        }
        if (z2 && !z3) {
            int i6 = iArr[0];
            int i7 = ((g.b) gVar.e.get(i6)).b.i;
            for (int i8 = 1; i8 < iArr.length; i8++) {
                int i9 = ((g.b) gVar.e.get(iArr[i8])).b.i;
                if (i9 < i7) {
                    i6 = iArr[i8];
                    i7 = i9;
                }
            }
            arrayList.add(new H(0, i6));
        }
        return arrayList;
    }

    public long l(long j) {
        q[] qVarArr = this.x;
        if (qVarArr.length > 0) {
            boolean k0 = qVarArr[0].k0(j, false);
            int i = 1;
            while (true) {
                q[] qVarArr2 = this.x;
                if (i >= qVarArr2.length) {
                    break;
                }
                qVarArr2[i].k0(j, k0);
                i++;
            }
            if (k0) {
                this.l.b();
            }
        }
        return j;
    }

    public long m() {
        return -9223372036854775807L;
    }

    public void p() {
        for (q qVar : this.w) {
            qVar.p();
        }
    }

    public void s(z.a aVar, long j) {
        this.t = aVar;
        this.c.b(this);
        x(j);
    }

    public final void t(long j, List list, List list2, List list3, Map map) {
        ArrayList arrayList = new ArrayList(list.size());
        ArrayList arrayList2 = new ArrayList(list.size());
        ArrayList arrayList3 = new ArrayList(list.size());
        HashSet hashSet = new HashSet();
        for (int i = 0; i < list.size(); i++) {
            String str = ((g.a) list.get(i)).d;
            if (hashSet.add(str)) {
                arrayList.clear();
                arrayList2.clear();
                arrayList3.clear();
                boolean z = true;
                for (int i2 = 0; i2 < list.size(); i2++) {
                    if (k0.c(str, ((g.a) list.get(i2)).d)) {
                        g.a aVar = (g.a) list.get(i2);
                        arrayList3.add(Integer.valueOf(i2));
                        arrayList.add(aVar.a);
                        arrayList2.add(aVar.b);
                        z &= k0.M(aVar.b.j, 1) == 1;
                    }
                }
                String str2 = "audio:" + str;
                q y = y(str2, 1, (Uri[]) arrayList.toArray((Uri[]) k0.k(new Uri[0])), (z0[]) arrayList2.toArray(new z0[0]), null, Collections.emptyList(), map, j);
                list3.add(w5.f.l(arrayList3));
                list2.add(y);
                if (this.n && z) {
                    y.f0(new g0[]{new g0(str2, (z0[]) arrayList2.toArray(new z0[0]))}, 0, new int[0]);
                }
            }
        }
    }

    public i0 u() {
        return (i0) d4.a.e(this.v);
    }

    public void v(long j, boolean z) {
        for (q qVar : this.x) {
            qVar.v(j, z);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00ac  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void w(J3.g r21, long r22, java.util.List r24, java.util.List r25, java.util.Map r26) {
        /*
            Method dump skipped, instructions count: 442
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: H3.l.w(J3.g, long, java.util.List, java.util.List, java.util.Map):void");
    }

    public final void x(long j) {
        char c = 0;
        int i = 1;
        J3.g gVar = (J3.g) d4.a.e(this.c.e());
        Map A = this.p ? A(gVar.m) : Collections.emptyMap();
        boolean z = !gVar.e.isEmpty();
        List list = gVar.g;
        List list2 = gVar.h;
        this.u = 0;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (z) {
            w(gVar, j, arrayList, arrayList2, A);
        }
        t(j, list, arrayList, arrayList2, A);
        this.z = arrayList.size();
        int i2 = 0;
        while (i2 < list2.size()) {
            g.a aVar = (g.a) list2.get(i2);
            String str = "subtitle:" + i2 + ":" + aVar.d;
            Uri[] uriArr = new Uri[i];
            uriArr[c] = aVar.a;
            z0[] z0VarArr = new z0[i];
            z0VarArr[c] = aVar.b;
            ArrayList arrayList3 = arrayList2;
            int i3 = i2;
            q y = y(str, 3, uriArr, z0VarArr, null, Collections.emptyList(), A, j);
            arrayList3.add(new int[]{i3});
            arrayList.add(y);
            y.f0(new g0[]{new g0(str, aVar.b)}, 0, new int[0]);
            i2 = i3 + 1;
            arrayList2 = arrayList3;
            c = 0;
            i = 1;
        }
        this.w = (q[]) arrayList.toArray(new q[0]);
        this.y = (int[][]) arrayList2.toArray(new int[0][]);
        this.u = this.w.length;
        for (int i4 = 0; i4 < this.z; i4++) {
            this.w[i4].o0(true);
        }
        for (q qVar : this.w) {
            qVar.B();
        }
        this.x = this.w;
    }

    public final q y(String str, int i, Uri[] uriArr, z0[] z0VarArr, z0 z0Var, List list, Map map, long j) {
        return new q(str, i, this.r, new f(this.a, this.c, uriArr, z0VarArr, this.d, this.e, this.l, this.s, list, this.q, null), map, this.j, j, z0Var, this.f, this.g, this.h, this.i, this.o);
    }
}
