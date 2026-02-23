package com.google.ads.interactivemedia.v3.internal;

import android.net.Uri;
import android.util.Pair;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class ow {
    private final ox a;
    private final cy b;
    private final cy c;
    private final Uri[] d;
    private final s[] e;
    private final qq f;
    private final bf g;
    private final List h;
    private final iw j;
    private boolean k;
    private IOException m;
    private Uri n;
    private boolean o;
    private we p;
    private boolean r;
    private final vk s;
    private final oq i = new oq();
    private byte[] l = cq.f;
    private long q = -9223372036854775807L;

    public ow(ox oxVar, qq qqVar, Uri[] uriArr, s[] sVarArr, oq oqVar, dw dwVar, vk vkVar, List list, iw iwVar, byte[] bArr) {
        this.a = oxVar;
        this.f = qqVar;
        this.d = uriArr;
        this.e = sVarArr;
        this.s = vkVar;
        this.h = list;
        this.j = iwVar;
        cy d = oqVar.d();
        this.b = d;
        if (dwVar != null) {
            d.f(dwVar);
        }
        this.c = oqVar.d();
        this.g = new bf("", sVarArr);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < uriArr.length; i++) {
            if ((sVarArr[i].e & 16384) == 0) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        this.p = new ou(this.g, axy.c(arrayList));
    }

    private static Uri q(qd qdVar, qb qbVar) {
        String str;
        if (qbVar == null || (str = qbVar.i) == null) {
            return null;
        }
        return af.l(qdVar.t, str);
    }

    private final Pair r(oy oyVar, boolean z, qd qdVar, long j, long j2) {
        boolean z2 = true;
        if (oyVar != null && !z) {
            if (!oyVar.g()) {
                return new Pair(Long.valueOf(oyVar.o), Integer.valueOf(oyVar.e));
            }
            Long valueOf = Long.valueOf(oyVar.e == -1 ? oyVar.s() : oyVar.o);
            int i = oyVar.e;
            return new Pair(valueOf, Integer.valueOf(i != -1 ? i + 1 : -1));
        }
        long j3 = qdVar.r + j;
        if (oyVar != null && !this.o) {
            j2 = oyVar.l;
        }
        if (!qdVar.l && j2 >= j3) {
            return new Pair(Long.valueOf(qdVar.h + qdVar.o.size()), -1);
        }
        long j4 = j2 - j;
        List list = qdVar.o;
        Long valueOf2 = Long.valueOf(j4);
        int i2 = 0;
        if (this.f.z() && oyVar != null) {
            z2 = false;
        }
        int ap = cq.ap(list, valueOf2, z2);
        long j5 = ap + qdVar.h;
        if (ap >= 0) {
            qa qaVar = (qa) qdVar.o.get(ap);
            List list2 = j4 < qaVar.g + qaVar.e ? qaVar.b : qdVar.p;
            while (true) {
                if (i2 >= list2.size()) {
                    break;
                }
                py pyVar = (py) list2.get(i2);
                if (j4 >= pyVar.g + pyVar.e) {
                    i2++;
                } else if (pyVar.a) {
                    j5 += list2 == qdVar.p ? 1L : 0L;
                    r1 = i2;
                }
            }
        }
        return new Pair(Long.valueOf(j5), Integer.valueOf(r1));
    }

    private final uu s(Uri uri, int i) {
        if (uri == null) {
            return null;
        }
        byte[] b = this.i.b(uri);
        if (b != null) {
            this.i.c(uri, b);
            return null;
        }
        db dbVar = new db();
        dbVar.i(uri);
        dbVar.b(1);
        dc a = dbVar.a();
        cy cyVar = this.c;
        s sVar = this.e[i];
        int b2 = this.p.b();
        this.p.c();
        return new or(cyVar, a, sVar, b2, this.l);
    }

    public final int a(oy oyVar) {
        if (oyVar.e == -1) {
            return 1;
        }
        qd i = this.f.i(this.d[this.g.a(oyVar.i)], false);
        af.s(i);
        int i2 = (int) (oyVar.o - i.h);
        if (i2 < 0) {
            return 1;
        }
        List list = i2 < i.o.size() ? ((qa) i.o.get(i2)).b : i.p;
        if (oyVar.e >= list.size()) {
            return 2;
        }
        py pyVar = (py) list.get(oyVar.e);
        if (pyVar.b) {
            return 0;
        }
        return cq.V(Uri.parse(af.m(i.t, pyVar.c)), oyVar.g.a) ? 1 : 2;
    }

    public final int b(long j, List list) {
        return (this.m != null || this.p.n() < 2) ? list.size() : this.p.e(j, list);
    }

    public final long c(long j, hl hlVar) {
        int a = this.p.a();
        Uri[] uriArr = this.d;
        qd qdVar = null;
        if (a < uriArr.length && a != -1) {
            qdVar = this.f.i(uriArr[this.p.k()], true);
        }
        if (qdVar == null || qdVar.o.isEmpty() || !qdVar.v) {
            return j;
        }
        long d = qdVar.e - this.f.d();
        long j2 = j - d;
        int ap = cq.ap(qdVar.o, Long.valueOf(j2), true);
        long j3 = ((qa) qdVar.o.get(ap)).g;
        return hlVar.a(j2, j3, ap != qdVar.o.size() + (-1) ? ((qa) qdVar.o.get(ap + 1)).g : j3) + d;
    }

    public final bf d() {
        return this.g;
    }

    public final we e() {
        return this.p;
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x0142  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void f(long r31, long r33, java.util.List r35, boolean r36, com.google.ads.interactivemedia.v3.internal.os r37) {
        /*
            Method dump skipped, instructions count: 614
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.ow.f(long, long, java.util.List, boolean, com.google.ads.interactivemedia.v3.internal.os):void");
    }

    public final void g() throws IOException {
        IOException iOException = this.m;
        if (iOException != null) {
            throw iOException;
        }
        Uri uri = this.n;
        if (uri == null || !this.r) {
            return;
        }
        this.f.r(uri);
    }

    public final void h(uu uuVar) {
        if (uuVar instanceof or) {
            or orVar = (or) uuVar;
            this.l = orVar.c();
            this.i.c(orVar.g.a, (byte[]) af.s(orVar.b()));
        }
    }

    public final void i() {
        this.m = null;
    }

    public final void j(boolean z) {
        this.k = z;
    }

    public final void k(we weVar) {
        this.p = weVar;
    }

    public final boolean l(uu uuVar, long j) {
        we weVar = this.p;
        return weVar.r(weVar.l(this.g.a(uuVar.i)), j);
    }

    public final boolean m(Uri uri) {
        return cq.W(this.d, uri);
    }

    public final boolean n(Uri uri, long j) {
        int l;
        int i = 0;
        while (true) {
            Uri[] uriArr = this.d;
            if (i >= uriArr.length) {
                i = -1;
                break;
            }
            if (uriArr[i].equals(uri)) {
                break;
            }
            i++;
        }
        if (i == -1 || (l = this.p.l(i)) == -1) {
            return true;
        }
        this.r |= uri.equals(this.n);
        return j == -9223372036854775807L || (this.p.r(l, j) && this.f.y(uri, j));
    }

    public final vg[] o(oy oyVar, long j) {
        List o;
        int a = oyVar == null ? -1 : this.g.a(oyVar.i);
        int n = this.p.n();
        vg[] vgVarArr = new vg[n];
        boolean z = false;
        int i = 0;
        while (i < n) {
            int j2 = this.p.j(i);
            Uri uri = this.d[j2];
            if (this.f.A(uri)) {
                qd i2 = this.f.i(uri, z);
                af.s(i2);
                long d = i2.e - this.f.d();
                Pair r = r(oyVar, j2 != a, i2, d, j);
                long longValue = ((Long) r.first).longValue();
                int intValue = ((Integer) r.second).intValue();
                int i3 = (int) (longValue - i2.h);
                if (i3 < 0 || i2.o.size() < i3) {
                    o = avo.o();
                } else {
                    ArrayList arrayList = new ArrayList();
                    if (i3 < i2.o.size()) {
                        if (intValue != -1) {
                            qa qaVar = (qa) i2.o.get(i3);
                            if (intValue == 0) {
                                arrayList.add(qaVar);
                            } else if (intValue < qaVar.b.size()) {
                                List list = qaVar.b;
                                arrayList.addAll(list.subList(intValue, list.size()));
                            }
                            i3++;
                        }
                        List list2 = i2.o;
                        arrayList.addAll(list2.subList(i3, list2.size()));
                        intValue = 0;
                    }
                    if (i2.k != -9223372036854775807L) {
                        if (intValue == -1) {
                            intValue = 0;
                        }
                        if (intValue < i2.p.size()) {
                            List list3 = i2.p;
                            arrayList.addAll(list3.subList(intValue, list3.size()));
                        }
                    }
                    o = Collections.unmodifiableList(arrayList);
                }
                vgVarArr[i] = new ot(d, o);
            } else {
                vgVarArr[i] = vg.a;
            }
            i++;
            z = false;
        }
        return vgVarArr;
    }

    public final void p(long j, uu uuVar, List list) {
        if (this.m != null) {
            return;
        }
        this.p.t();
    }
}
