package com.google.ads.interactivemedia.v3.internal;

import android.util.Pair;
import android.util.SparseArray;
import android.util.SparseIntArray;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class kx implements td, ug, uy {
    private static final Pattern b = Pattern.compile("CC([1-4])=(.+)");
    private static final Pattern c = Pattern.compile("([1-4])=lang:(\\w+)(,.+)?");
    final int a;
    private final dw d;
    private final nt e;
    private final long f;
    private final xd g;
    private final um h;
    private final kw[] i;
    private final lr j;
    private final tj l;
    private final nn m;
    private final iw n;
    private tc o;
    private lu s;
    private int t;
    private List u;
    private final wr v;
    private final ly w;
    private final aeq x;
    private final ws y;
    private final ws z;
    private uz[] p = new uz[0];
    private ln[] q = new ln[0];
    private final IdentityHashMap k = new IdentityHashMap();
    private uh r = ws.f(this.p);

    public kx(int i, lu luVar, ly lyVar, int i2, aeq aeqVar, dw dwVar, nt ntVar, nn nnVar, ws wsVar, tj tjVar, long j, xd xdVar, wr wrVar, ws wsVar2, lp lpVar, iw iwVar, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        int[][] iArr;
        int i3;
        List list;
        int i4;
        boolean[] zArr;
        int i5;
        s[] sVarArr;
        s v;
        Pattern pattern;
        lx s;
        nt ntVar2 = ntVar;
        this.a = i;
        this.s = luVar;
        this.w = lyVar;
        this.t = i2;
        this.x = aeqVar;
        this.d = dwVar;
        this.e = ntVar2;
        this.m = nnVar;
        this.y = wsVar;
        this.l = tjVar;
        this.f = j;
        this.g = xdVar;
        this.v = wrVar;
        this.z = wsVar2;
        this.n = iwVar;
        this.j = new lr(luVar, lpVar, wrVar);
        lz d = luVar.d(i2);
        List list2 = d.d;
        this.u = list2;
        List list3 = d.c;
        int size = list3.size();
        SparseIntArray sparseIntArray = new SparseIntArray(size);
        ArrayList arrayList = new ArrayList(size);
        SparseArray sparseArray = new SparseArray(size);
        for (int i6 = 0; i6 < size; i6++) {
            sparseIntArray.put(((ls) list3.get(i6)).a, i6);
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(Integer.valueOf(i6));
            arrayList.add(arrayList2);
            sparseArray.put(i6, arrayList2);
        }
        for (int i7 = 0; i7 < size; i7++) {
            ls lsVar = (ls) list3.get(i7);
            lx t = t(lsVar.e);
            t = t == null ? t(lsVar.f) : t;
            int i8 = (t == null || (i8 = sparseIntArray.get(Integer.parseInt(t.b), -1)) == -1) ? i7 : i8;
            if (i8 == i7 && (s = s(lsVar.f, "urn:mpeg:dash:adaptation-set-switching:2016")) != null) {
                for (String str : cq.ak(s.b, ",")) {
                    int i9 = sparseIntArray.get(Integer.parseInt(str), -1);
                    if (i9 != -1) {
                        i8 = Math.min(i8, i9);
                    }
                }
            }
            if (i8 != i7) {
                List list4 = (List) sparseArray.get(i7);
                List list5 = (List) sparseArray.get(i8);
                list5.addAll(list4);
                sparseArray.put(i7, list5);
                arrayList.remove(list4);
            }
        }
        int size2 = arrayList.size();
        int[][] iArr2 = new int[size2][];
        for (int i10 = 0; i10 < size2; i10++) {
            int[] c2 = axy.c((Collection) arrayList.get(i10));
            iArr2[i10] = c2;
            Arrays.sort(c2);
        }
        boolean[] zArr2 = new boolean[size2];
        s[][] sVarArr2 = new s[size2][];
        int i11 = 0;
        int i12 = 0;
        while (i11 < size2) {
            int[] iArr3 = iArr2[i11];
            int length = iArr3.length;
            int i13 = 0;
            while (true) {
                if (i13 >= length) {
                    break;
                }
                List list6 = ((ls) list3.get(iArr3[i13])).c;
                for (int i14 = 0; i14 < list6.size(); i14++) {
                    if (!((me) list6.get(i14)).e.isEmpty()) {
                        zArr2[i11] = true;
                        i12++;
                        break;
                    }
                }
                i13++;
            }
            int[] iArr4 = iArr2[i11];
            int length2 = iArr4.length;
            int i15 = 0;
            while (i15 < length2) {
                int i16 = iArr4[i15];
                ls lsVar2 = (ls) list3.get(i16);
                List list7 = ((ls) list3.get(i16)).d;
                int[] iArr5 = iArr4;
                int i17 = 0;
                while (i17 < list7.size()) {
                    lx lxVar = (lx) list7.get(i17);
                    int i18 = length2;
                    List list8 = list7;
                    if ("urn:scte:dash:cc:cea-608:2015".equals(lxVar.a)) {
                        r rVar = new r();
                        rVar.ae("application/cea-608");
                        rVar.S(lsVar2.a + ":cea608");
                        v = rVar.v();
                        pattern = b;
                    } else if ("urn:scte:dash:cc:cea-708:2015".equals(lxVar.a)) {
                        r rVar2 = new r();
                        rVar2.ae("application/cea-708");
                        rVar2.S(lsVar2.a + ":cea708");
                        v = rVar2.v();
                        pattern = c;
                    } else {
                        i17++;
                        list7 = list8;
                        length2 = i18;
                    }
                    sVarArr = u(lxVar, pattern, v);
                    i5 = 1;
                }
                i15++;
                iArr4 = iArr5;
            }
            i5 = 1;
            sVarArr = new s[0];
            sVarArr2[i11] = sVarArr;
            if (sVarArr.length != 0) {
                i12 += i5;
            }
            i11 += i5;
        }
        int size3 = i12 + size2 + list2.size();
        bf[] bfVarArr = new bf[size3];
        kw[] kwVarArr = new kw[size3];
        int i19 = 0;
        int i20 = 0;
        while (i20 < size2) {
            int[] iArr6 = iArr2[i20];
            List arrayList3 = new ArrayList();
            int length3 = iArr6.length;
            int i21 = size2;
            int i22 = 0;
            while (true) {
                iArr = iArr2;
                if (i22 >= length3) {
                    break;
                }
                arrayList3.addAll(((ls) list3.get(iArr6[i22])).c);
                i22++;
                iArr2 = iArr;
            }
            int size4 = arrayList3.size();
            s[] sVarArr3 = new s[size4];
            int i23 = 0;
            while (i23 < size4) {
                int i24 = size4;
                s sVar = ((me) arrayList3.get(i23)).b;
                sVarArr3[i23] = sVar.c(ntVar2.b(sVar));
                i23++;
                size4 = i24;
                arrayList3 = arrayList3;
            }
            ls lsVar3 = (ls) list3.get(iArr6[0]);
            int i25 = lsVar3.a;
            String num = i25 != -1 ? Integer.toString(i25) : "unset:" + i20;
            int i26 = i19 + 1;
            if (zArr2[i20]) {
                i3 = i26;
                i26 = i19 + 2;
            } else {
                i3 = -1;
            }
            if (sVarArr2[i20].length != 0) {
                i4 = i26;
                i26++;
                list = list3;
            } else {
                list = list3;
                i4 = -1;
            }
            bfVarArr[i19] = new bf(num, sVarArr3);
            int i27 = lsVar3.b;
            int i28 = i3;
            kwVarArr[i19] = kw.d(i27, iArr6, i19, i28, i4);
            int i29 = -1;
            if (i28 != -1) {
                String concat = String.valueOf(num).concat(":emsg");
                r rVar3 = new r();
                rVar3.S(concat);
                rVar3.ae("application/x-emsg");
                zArr = zArr2;
                bfVarArr[i28] = new bf(concat, rVar3.v());
                kwVarArr[i28] = kw.b(iArr6, i19);
                i29 = -1;
            } else {
                zArr = zArr2;
            }
            if (i4 != i29) {
                bfVarArr[i4] = new bf(String.valueOf(num).concat(":cc"), sVarArr2[i20]);
                kwVarArr[i4] = kw.a(iArr6, i19);
            }
            i20++;
            size2 = i21;
            ntVar2 = ntVar;
            iArr2 = iArr;
            i19 = i26;
            list3 = list;
            zArr2 = zArr;
        }
        int i30 = 0;
        while (i30 < list2.size()) {
            ly lyVar2 = (ly) list2.get(i30);
            r rVar4 = new r();
            rVar4.S(lyVar2.a());
            rVar4.ae("application/x-emsg");
            bfVarArr[i19] = new bf(lyVar2.a() + ":" + i30, rVar4.v());
            kwVarArr[i19] = kw.c(i30);
            i30++;
            i19++;
        }
        Pair create = Pair.create(new um(bfVarArr), kwVarArr);
        this.h = (um) create.first;
        this.i = (kw[]) create.second;
    }

    private final int r(int i, int[] iArr) {
        int i2 = iArr[i];
        if (i2 == -1) {
            return -1;
        }
        int i3 = this.i[i2].e;
        for (int i4 = 0; i4 < iArr.length; i4++) {
            int i5 = iArr[i4];
            if (i5 == i3 && this.i[i5].c == 0) {
                return i4;
            }
        }
        return -1;
    }

    private static lx s(List list, String str) {
        for (int i = 0; i < list.size(); i++) {
            lx lxVar = (lx) list.get(i);
            if (str.equals(lxVar.a)) {
                return lxVar;
            }
        }
        return null;
    }

    private static lx t(List list) {
        return s(list, "http://dashif.org/guidelines/trickmode");
    }

    private static s[] u(lx lxVar, Pattern pattern, s sVar) {
        String str = lxVar.b;
        if (str == null) {
            return new s[]{sVar};
        }
        CharSequence[] ak = cq.ak(str, ";");
        s[] sVarArr = new s[ak.length];
        for (int i = 0; i < ak.length; i++) {
            Matcher matcher = pattern.matcher(ak[i]);
            if (!matcher.matches()) {
                return new s[]{sVar};
            }
            int parseInt = Integer.parseInt(matcher.group(1));
            r b2 = sVar.b();
            b2.S(sVar.a + ":" + parseInt);
            b2.F(parseInt);
            b2.V(matcher.group(2));
            sVarArr[i] = b2.v();
        }
        return sVarArr;
    }

    public final long a(long j, hl hlVar) {
        for (uz uzVar : this.p) {
            if (uzVar.a == 2) {
                return uzVar.f(j, hlVar);
            }
        }
        return j;
    }

    public final void bm() throws IOException {
        this.g.a();
    }

    public final long bo() {
        return this.r.bo();
    }

    public final long c() {
        return this.r.c();
    }

    public final long d() {
        return -9223372036854775807L;
    }

    public final long e(long j) {
        for (uz uzVar : this.p) {
            uzVar.m(j);
        }
        for (ln lnVar : this.q) {
            lnVar.e(j);
        }
        return j;
    }

    /* JADX WARN: Type inference failed for: r0v9, types: [com.google.ads.interactivemedia.v3.internal.ku, com.google.ads.interactivemedia.v3.internal.va] */
    public final long f(we[] weVarArr, boolean[] zArr, uf[] ufVarArr, boolean[] zArr2, long j) {
        int i;
        boolean z;
        int[] iArr;
        int i2;
        int[] iArr2;
        uf[] ufVarArr2;
        kx kxVar;
        bf bfVar;
        int i3;
        bf bfVar2;
        int i4;
        kx kxVar2 = this;
        we[] weVarArr2 = weVarArr;
        uf[] ufVarArr3 = ufVarArr;
        int[] iArr3 = new int[weVarArr2.length];
        int i5 = 0;
        int i6 = 0;
        while (true) {
            i = -1;
            if (i6 >= weVarArr2.length) {
                break;
            }
            we weVar = weVarArr2[i6];
            if (weVar != null) {
                iArr3[i6] = kxVar2.h.a(weVar.q());
            } else {
                iArr3[i6] = -1;
            }
            i6++;
        }
        for (int i7 = 0; i7 < weVarArr2.length; i7++) {
            if (weVarArr2[i7] == null || !zArr[i7]) {
                uf ufVar = ufVarArr3[i7];
                if (ufVar instanceof uz) {
                    ((uz) ufVar).k(kxVar2);
                } else if (ufVar instanceof ux) {
                    ((ux) ufVar).c();
                }
                ufVarArr3[i7] = null;
            }
        }
        int i8 = 0;
        while (true) {
            z = true;
            if (i8 >= weVarArr2.length) {
                break;
            }
            uf ufVar2 = ufVarArr3[i8];
            if ((ufVar2 instanceof ss) || (ufVar2 instanceof ux)) {
                int r = kxVar2.r(i8, iArr3);
                if (r == -1) {
                    z = ufVarArr3[i8] instanceof ss;
                } else {
                    uf ufVar3 = ufVarArr3[i8];
                    if (!(ufVar3 instanceof ux) || ((ux) ufVar3).a != ufVarArr3[r]) {
                        z = false;
                    }
                }
                if (!z) {
                    uf ufVar4 = ufVarArr3[i8];
                    if (ufVar4 instanceof ux) {
                        ((ux) ufVar4).c();
                    }
                    ufVarArr3[i8] = null;
                }
            }
            i8++;
        }
        int i9 = 0;
        while (i9 < weVarArr2.length) {
            we weVar2 = weVarArr2[i9];
            if (weVar2 == null) {
                i2 = i9;
                iArr2 = iArr3;
                ufVarArr2 = ufVarArr3;
                kxVar = kxVar2;
            } else {
                uf ufVar5 = ufVarArr3[i9];
                if (ufVar5 == null) {
                    zArr2[i9] = z;
                    kw kwVar = kxVar2.i[iArr3[i9]];
                    int i10 = kwVar.c;
                    if (i10 == 0) {
                        int i11 = kwVar.f;
                        boolean z2 = i11 != i;
                        if (z2) {
                            bfVar = kxVar2.h.b(i11);
                            i3 = 1;
                        } else {
                            bfVar = null;
                            i3 = 0;
                        }
                        int i12 = kwVar.g;
                        boolean z3 = i12 != i;
                        if (z3) {
                            bfVar2 = kxVar2.h.b(i12);
                            i3 += bfVar2.a;
                        } else {
                            bfVar2 = null;
                        }
                        s[] sVarArr = new s[i3];
                        int[] iArr4 = new int[i3];
                        if (z2) {
                            sVarArr[i5] = bfVar.b(i5);
                            iArr4[i5] = 5;
                            i4 = 1;
                        } else {
                            i4 = 0;
                        }
                        List arrayList = new ArrayList();
                        if (z3) {
                            for (int i13 = 0; i13 < bfVar2.a; i13++) {
                                s b2 = bfVar2.b(i13);
                                sVarArr[i4] = b2;
                                iArr4[i4] = 3;
                                arrayList.add(b2);
                                i4++;
                            }
                        }
                        lq b3 = (kxVar2.s.d && z2) ? kxVar2.j.b() : null;
                        lq lqVar = b3;
                        i2 = i9;
                        iArr2 = iArr3;
                        uz uzVar = new uz(kwVar.b, iArr4, sVarArr, kxVar2.x.n(kxVar2.g, kxVar2.s, kxVar2.w, kxVar2.t, kwVar.a, weVar2, kwVar.b, kxVar2.f, z2, arrayList, b3, kxVar2.d, kxVar2.n), this, kxVar2.v, j, kxVar2.e, kxVar2.m, kxVar2.y, kxVar2.l, null, null, null);
                        kxVar = this;
                        synchronized (this) {
                            kxVar.k.put(uzVar, lqVar);
                        }
                        ufVarArr2 = ufVarArr;
                        ufVarArr2[i2] = uzVar;
                    } else {
                        i2 = i9;
                        iArr2 = iArr3;
                        ufVarArr2 = ufVarArr3;
                        kxVar = kxVar2;
                        if (i10 == 2) {
                            ufVarArr2[i2] = new ln((ly) kxVar.u.get(kwVar.d), weVar2.q().b(0), kxVar.s.d);
                        }
                    }
                } else {
                    i2 = i9;
                    iArr2 = iArr3;
                    ufVarArr2 = ufVarArr3;
                    kxVar = kxVar2;
                    if (ufVar5 instanceof uz) {
                        ((uz) ufVar5).j().b(weVar2);
                    }
                }
                i9 = i2 + 1;
                weVarArr2 = weVarArr;
                kxVar2 = kxVar;
                ufVarArr3 = ufVarArr2;
                iArr3 = iArr2;
                i = -1;
                z = true;
                i5 = 0;
            }
            i9 = i2 + 1;
            weVarArr2 = weVarArr;
            kxVar2 = kxVar;
            ufVarArr3 = ufVarArr2;
            iArr3 = iArr2;
            i = -1;
            z = true;
            i5 = 0;
        }
        int[] iArr5 = iArr3;
        uf[] ufVarArr4 = ufVarArr3;
        kx kxVar3 = kxVar2;
        int i14 = 0;
        while (i14 < weVarArr.length) {
            if (ufVarArr4[i14] != null || weVarArr[i14] == null) {
                iArr = iArr5;
            } else {
                iArr = iArr5;
                kw kwVar2 = kxVar3.i[iArr[i14]];
                if (kwVar2.c == 1) {
                    int r2 = kxVar3.r(i14, iArr);
                    if (r2 == -1) {
                        ufVarArr4[i14] = new ss();
                    } else {
                        ufVarArr4[i14] = ((uz) ufVarArr4[r2]).i(j, kwVar2.b);
                    }
                    i14++;
                    iArr5 = iArr;
                }
            }
            i14++;
            iArr5 = iArr;
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (uf ufVar6 : ufVarArr4) {
            if (ufVar6 instanceof uz) {
                arrayList2.add((uz) ufVar6);
            } else if (ufVar6 instanceof ln) {
                arrayList3.add((ln) ufVar6);
            }
        }
        uz[] uzVarArr = new uz[arrayList2.size()];
        kxVar3.p = uzVarArr;
        arrayList2.toArray(uzVarArr);
        ln[] lnVarArr = new ln[arrayList3.size()];
        kxVar3.q = lnVarArr;
        arrayList3.toArray(lnVarArr);
        kxVar3.r = ws.f(kxVar3.p);
        return j;
    }

    public final /* bridge */ /* synthetic */ void g(uh uhVar) {
        this.o.g(this);
    }

    public final um h() {
        return this.h;
    }

    public final synchronized void j(uz uzVar) {
        lq lqVar = (lq) this.k.remove(uzVar);
        if (lqVar != null) {
            lqVar.d();
        }
    }

    public final void k(tc tcVar, long j) {
        this.o = tcVar;
        tcVar.bl(this);
    }

    public final void l(long j) {
        this.r.l(j);
    }

    public final void m() {
        this.j.d();
        for (uz uzVar : this.p) {
            uzVar.k(this);
        }
        this.o = null;
    }

    /* JADX WARN: Type inference failed for: r4v2, types: [com.google.ads.interactivemedia.v3.internal.ku, com.google.ads.interactivemedia.v3.internal.va] */
    public final void n(lu luVar, int i) {
        this.s = luVar;
        this.t = i;
        this.j.e(luVar);
        uz[] uzVarArr = this.p;
        if (uzVarArr != null) {
            for (uz uzVar : uzVarArr) {
                uzVar.j().a(luVar, i);
            }
            this.o.g(this);
        }
        this.u = luVar.d(i).d;
        for (ln lnVar : this.q) {
            Iterator it = this.u.iterator();
            while (true) {
                if (it.hasNext()) {
                    ly lyVar = (ly) it.next();
                    if (lyVar.a().equals(lnVar.c())) {
                        lnVar.f(lyVar, luVar.d && i == luVar.a() + (-1));
                    }
                }
            }
        }
    }

    public final boolean o(long j) {
        return this.r.o(j);
    }

    public final boolean p() {
        return this.r.p();
    }

    public final void q(long j) {
        for (uz uzVar : this.p) {
            uzVar.u(j);
        }
    }
}
