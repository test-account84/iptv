package y;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import x.e;
import y.b;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class e {
    public x.f a;
    public x.f d;
    public boolean b = true;
    public boolean c = true;
    public ArrayList e = new ArrayList();
    public ArrayList f = new ArrayList();
    public b.b g = null;
    public b.a h = new b.a();
    public ArrayList i = new ArrayList();

    public e(x.f fVar) {
        this.a = fVar;
        this.d = fVar;
    }

    public final void a(f fVar, int i, int i2, f fVar2, ArrayList arrayList, k kVar) {
        m mVar = fVar.d;
        if (mVar.c == null) {
            x.f fVar3 = this.a;
            if (mVar == fVar3.e || mVar == fVar3.f) {
                return;
            }
            if (kVar == null) {
                kVar = new k(mVar, i2);
                arrayList.add(kVar);
            }
            mVar.c = kVar;
            kVar.a(mVar);
            for (d dVar : mVar.h.k) {
                if (dVar instanceof f) {
                    a((f) dVar, i, 0, fVar2, arrayList, kVar);
                }
            }
            for (d dVar2 : mVar.i.k) {
                if (dVar2 instanceof f) {
                    a((f) dVar2, i, 1, fVar2, arrayList, kVar);
                }
            }
            if (i == 1 && (mVar instanceof l)) {
                for (d dVar3 : ((l) mVar).k.k) {
                    if (dVar3 instanceof f) {
                        a((f) dVar3, i, 2, fVar2, arrayList, kVar);
                    }
                }
            }
            for (f fVar4 : mVar.h.l) {
                if (fVar4 == fVar2) {
                    kVar.b = true;
                }
                a(fVar4, i, 0, fVar2, arrayList, kVar);
            }
            for (f fVar5 : mVar.i.l) {
                if (fVar5 == fVar2) {
                    kVar.b = true;
                }
                a(fVar5, i, 1, fVar2, arrayList, kVar);
            }
            if (i == 1 && (mVar instanceof l)) {
                Iterator it = ((l) mVar).k.l.iterator();
                while (it.hasNext()) {
                    a((f) it.next(), i, 2, fVar2, arrayList, kVar);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01dd A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0008 A[ADDED_TO_REGION, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean b(x.f r17) {
        /*
            Method dump skipped, instructions count: 612
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: y.e.b(x.f):boolean");
    }

    public void c() {
        d(this.e);
        this.i.clear();
        k.h = 0;
        i(this.a.e, 0, this.i);
        i(this.a.f, 1, this.i);
        this.b = false;
    }

    public void d(ArrayList arrayList) {
        Object hVar;
        arrayList.clear();
        this.d.e.f();
        this.d.f.f();
        arrayList.add(this.d.e);
        arrayList.add(this.d.f);
        Iterator it = this.d.w0.iterator();
        HashSet hashSet = null;
        while (it.hasNext()) {
            x.e eVar = (x.e) it.next();
            if (eVar instanceof x.g) {
                hVar = new h(eVar);
            } else {
                if (eVar.T()) {
                    if (eVar.c == null) {
                        eVar.c = new c(eVar, 0);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(eVar.c);
                } else {
                    arrayList.add(eVar.e);
                }
                if (eVar.V()) {
                    if (eVar.d == null) {
                        eVar.d = new c(eVar, 1);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(eVar.d);
                } else {
                    arrayList.add(eVar.f);
                }
                if (eVar instanceof x.i) {
                    hVar = new i(eVar);
                }
            }
            arrayList.add(hVar);
        }
        if (hashSet != null) {
            arrayList.addAll(hashSet);
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            ((m) it2.next()).f();
        }
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            m mVar = (m) it3.next();
            if (mVar.b != this.d) {
                mVar.d();
            }
        }
    }

    public final int e(x.f fVar, int i) {
        int size = this.i.size();
        long j = 0;
        for (int i2 = 0; i2 < size; i2++) {
            j = Math.max(j, ((k) this.i.get(i2)).b(fVar, i));
        }
        return (int) j;
    }

    public boolean f(boolean z) {
        boolean z2;
        boolean z3 = false;
        if (this.b || this.c) {
            Iterator it = this.a.w0.iterator();
            while (it.hasNext()) {
                x.e eVar = (x.e) it.next();
                eVar.a = false;
                eVar.e.r();
                eVar.f.q();
            }
            x.f fVar = this.a;
            fVar.a = false;
            fVar.e.r();
            this.a.f.q();
            this.c = false;
        }
        if (b(this.d)) {
            return false;
        }
        this.a.B0(0);
        this.a.C0(0);
        e.b q = this.a.q(0);
        e.b q2 = this.a.q(1);
        if (this.b) {
            c();
        }
        int O = this.a.O();
        int P = this.a.P();
        this.a.e.h.d(O);
        this.a.f.h.d(P);
        m();
        e.b bVar = e.b.WRAP_CONTENT;
        if (q == bVar || q2 == bVar) {
            if (z) {
                Iterator it2 = this.e.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    if (!((m) it2.next()).m()) {
                        z = false;
                        break;
                    }
                }
            }
            if (z && q == e.b.WRAP_CONTENT) {
                this.a.i0(e.b.FIXED);
                x.f fVar2 = this.a;
                fVar2.A0(e(fVar2, 0));
                x.f fVar3 = this.a;
                fVar3.e.e.d(fVar3.N());
            }
            if (z && q2 == e.b.WRAP_CONTENT) {
                this.a.w0(e.b.FIXED);
                x.f fVar4 = this.a;
                fVar4.e0(e(fVar4, 1));
                x.f fVar5 = this.a;
                fVar5.f.e.d(fVar5.t());
            }
        }
        x.f fVar6 = this.a;
        e.b bVar2 = fVar6.M[0];
        e.b bVar3 = e.b.FIXED;
        if (bVar2 == bVar3 || bVar2 == e.b.MATCH_PARENT) {
            int N = fVar6.N() + O;
            this.a.e.i.d(N);
            this.a.e.e.d(N - O);
            m();
            x.f fVar7 = this.a;
            e.b bVar4 = fVar7.M[1];
            if (bVar4 == bVar3 || bVar4 == e.b.MATCH_PARENT) {
                int t = fVar7.t() + P;
                this.a.f.i.d(t);
                this.a.f.e.d(t - P);
            }
            m();
            z2 = true;
        } else {
            z2 = false;
        }
        Iterator it3 = this.e.iterator();
        while (it3.hasNext()) {
            m mVar = (m) it3.next();
            if (mVar.b != this.a || mVar.g) {
                mVar.e();
            }
        }
        Iterator it4 = this.e.iterator();
        while (true) {
            if (!it4.hasNext()) {
                z3 = true;
                break;
            }
            m mVar2 = (m) it4.next();
            if (z2 || mVar2.b != this.a) {
                if (!mVar2.h.j) {
                    break;
                }
                if (!mVar2.i.j) {
                    if (!(mVar2 instanceof h)) {
                        break;
                    }
                    break;
                    break;
                }
                if (!mVar2.e.j && !(mVar2 instanceof c) && !(mVar2 instanceof h)) {
                    break;
                }
            }
        }
        this.a.i0(q);
        this.a.w0(q2);
        return z3;
    }

    public boolean g(boolean z) {
        if (this.b) {
            Iterator it = this.a.w0.iterator();
            while (it.hasNext()) {
                x.e eVar = (x.e) it.next();
                eVar.a = false;
                j jVar = eVar.e;
                jVar.e.j = false;
                jVar.g = false;
                jVar.r();
                l lVar = eVar.f;
                lVar.e.j = false;
                lVar.g = false;
                lVar.q();
            }
            x.f fVar = this.a;
            fVar.a = false;
            j jVar2 = fVar.e;
            jVar2.e.j = false;
            jVar2.g = false;
            jVar2.r();
            l lVar2 = this.a.f;
            lVar2.e.j = false;
            lVar2.g = false;
            lVar2.q();
            c();
        }
        if (b(this.d)) {
            return false;
        }
        this.a.B0(0);
        this.a.C0(0);
        this.a.e.h.d(0);
        this.a.f.h.d(0);
        return true;
    }

    public boolean h(boolean z, int i) {
        boolean z2;
        e.b bVar;
        g gVar;
        int t;
        boolean z3 = false;
        e.b q = this.a.q(0);
        e.b q2 = this.a.q(1);
        int O = this.a.O();
        int P = this.a.P();
        if (z && (q == (bVar = e.b.WRAP_CONTENT) || q2 == bVar)) {
            Iterator it = this.e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                m mVar = (m) it.next();
                if (mVar.f == i && !mVar.m()) {
                    z = false;
                    break;
                }
            }
            if (i == 0) {
                if (z && q == e.b.WRAP_CONTENT) {
                    this.a.i0(e.b.FIXED);
                    x.f fVar = this.a;
                    fVar.A0(e(fVar, 0));
                    x.f fVar2 = this.a;
                    gVar = fVar2.e.e;
                    t = fVar2.N();
                    gVar.d(t);
                }
            } else if (z && q2 == e.b.WRAP_CONTENT) {
                this.a.w0(e.b.FIXED);
                x.f fVar3 = this.a;
                fVar3.e0(e(fVar3, 1));
                x.f fVar4 = this.a;
                gVar = fVar4.f.e;
                t = fVar4.t();
                gVar.d(t);
            }
        }
        x.f fVar5 = this.a;
        if (i == 0) {
            e.b bVar2 = fVar5.M[0];
            if (bVar2 == e.b.FIXED || bVar2 == e.b.MATCH_PARENT) {
                int N = fVar5.N() + O;
                this.a.e.i.d(N);
                this.a.e.e.d(N - O);
                z2 = true;
            }
            z2 = false;
        } else {
            e.b bVar3 = fVar5.M[1];
            if (bVar3 == e.b.FIXED || bVar3 == e.b.MATCH_PARENT) {
                int t2 = fVar5.t() + P;
                this.a.f.i.d(t2);
                this.a.f.e.d(t2 - P);
                z2 = true;
            }
            z2 = false;
        }
        m();
        Iterator it2 = this.e.iterator();
        while (it2.hasNext()) {
            m mVar2 = (m) it2.next();
            if (mVar2.f == i && (mVar2.b != this.a || mVar2.g)) {
                mVar2.e();
            }
        }
        Iterator it3 = this.e.iterator();
        while (true) {
            if (!it3.hasNext()) {
                z3 = true;
                break;
            }
            m mVar3 = (m) it3.next();
            if (mVar3.f == i && (z2 || mVar3.b != this.a)) {
                if (!mVar3.h.j) {
                    break;
                }
                if (!mVar3.i.j) {
                    break;
                }
                if (!(mVar3 instanceof c) && !mVar3.e.j) {
                    break;
                }
            }
        }
        this.a.i0(q);
        this.a.w0(q2);
        return z3;
    }

    public final void i(m mVar, int i, ArrayList arrayList) {
        for (d dVar : mVar.h.k) {
            if (dVar instanceof f) {
                a((f) dVar, i, 0, mVar.i, arrayList, null);
            } else if (dVar instanceof m) {
                a(((m) dVar).h, i, 0, mVar.i, arrayList, null);
            }
        }
        for (d dVar2 : mVar.i.k) {
            if (dVar2 instanceof f) {
                a((f) dVar2, i, 1, mVar.h, arrayList, null);
            } else if (dVar2 instanceof m) {
                a(((m) dVar2).i, i, 1, mVar.h, arrayList, null);
            }
        }
        if (i == 1) {
            for (d dVar3 : ((l) mVar).k.k) {
                if (dVar3 instanceof f) {
                    a((f) dVar3, i, 2, null, arrayList, null);
                }
            }
        }
    }

    public void j() {
        this.b = true;
    }

    public void k() {
        this.c = true;
    }

    public final void l(x.e eVar, e.b bVar, int i, e.b bVar2, int i2) {
        b.a aVar = this.h;
        aVar.a = bVar;
        aVar.b = bVar2;
        aVar.c = i;
        aVar.d = i2;
        this.g.b(eVar, aVar);
        eVar.A0(this.h.e);
        eVar.e0(this.h.f);
        eVar.d0(this.h.h);
        eVar.Y(this.h.g);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00b2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0008 A[ADDED_TO_REGION, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m() {
        /*
            r12 = this;
            x.f r0 = r12.a
            java.util.ArrayList r0 = r0.w0
            java.util.Iterator r0 = r0.iterator()
        L8:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto Lc1
            java.lang.Object r1 = r0.next()
            x.e r1 = (x.e) r1
            boolean r2 = r1.a
            if (r2 == 0) goto L19
            goto L8
        L19:
            x.e$b[] r2 = r1.M
            r3 = 0
            r8 = r2[r3]
            r9 = 1
            r10 = r2[r9]
            int r2 = r1.l
            int r4 = r1.m
            x.e$b r6 = x.e.b.WRAP_CONTENT
            if (r8 == r6) goto L32
            x.e$b r5 = x.e.b.MATCH_CONSTRAINT
            if (r8 != r5) goto L30
            if (r2 != r9) goto L30
            goto L32
        L30:
            r2 = 0
            goto L33
        L32:
            r2 = 1
        L33:
            if (r10 == r6) goto L3b
            x.e$b r5 = x.e.b.MATCH_CONSTRAINT
            if (r10 != r5) goto L3c
            if (r4 != r9) goto L3c
        L3b:
            r3 = 1
        L3c:
            y.j r4 = r1.e
            y.g r4 = r4.e
            boolean r5 = r4.j
            y.l r7 = r1.f
            y.g r7 = r7.e
            boolean r11 = r7.j
            if (r5 == 0) goto L5b
            if (r11 == 0) goto L5b
            x.e$b r6 = x.e.b.FIXED
            int r5 = r4.g
            int r7 = r7.g
            r2 = r12
            r3 = r1
            r4 = r6
            r2.l(r3, r4, r5, r6, r7)
        L58:
            r1.a = r9
            goto Lae
        L5b:
            if (r5 == 0) goto L87
            if (r3 == 0) goto L87
            x.e$b r5 = x.e.b.FIXED
            int r8 = r4.g
            int r7 = r7.g
            r2 = r12
            r3 = r1
            r4 = r5
            r5 = r8
            r2.l(r3, r4, r5, r6, r7)
            x.e$b r2 = x.e.b.MATCH_CONSTRAINT
            if (r10 != r2) goto L7b
            y.l r2 = r1.f
            y.g r2 = r2.e
            int r3 = r1.t()
        L78:
            r2.m = r3
            goto Lae
        L7b:
            y.l r2 = r1.f
            y.g r2 = r2.e
            int r3 = r1.t()
        L83:
            r2.d(r3)
            goto L58
        L87:
            if (r11 == 0) goto Lae
            if (r2 == 0) goto Lae
            int r5 = r4.g
            x.e$b r10 = x.e.b.FIXED
            int r7 = r7.g
            r2 = r12
            r3 = r1
            r4 = r6
            r6 = r10
            r2.l(r3, r4, r5, r6, r7)
            x.e$b r2 = x.e.b.MATCH_CONSTRAINT
            if (r8 != r2) goto La5
            y.j r2 = r1.e
            y.g r2 = r2.e
            int r3 = r1.N()
            goto L78
        La5:
            y.j r2 = r1.e
            y.g r2 = r2.e
            int r3 = r1.N()
            goto L83
        Lae:
            boolean r2 = r1.a
            if (r2 == 0) goto L8
            y.l r2 = r1.f
            y.g r2 = r2.l
            if (r2 == 0) goto L8
            int r1 = r1.l()
            r2.d(r1)
            goto L8
        Lc1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: y.e.m():void");
    }

    public void n(b.b bVar) {
        this.g = bVar;
    }
}
