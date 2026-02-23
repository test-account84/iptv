package p4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import p4.i;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class d0 extends i.a {
    public final /* synthetic */ d a;

    public d0(d dVar) {
        this.a = dVar;
    }

    public final void g() {
        long c = d.c(this.a);
        d dVar = this.a;
        if (c != dVar.b) {
            dVar.b = c;
            dVar.n();
            d dVar2 = this.a;
            if (dVar2.b != 0) {
                dVar2.q();
            }
        }
    }

    public final void h(int[] iArr) {
        List j = t4.a.j(iArr);
        if (this.a.d.equals(j)) {
            return;
        }
        d.k(this.a);
        this.a.f.evictAll();
        this.a.g.clear();
        d dVar = this.a;
        dVar.d = j;
        d.m(dVar);
        d.f(this.a);
        d.e(this.a);
    }

    public final void i(int[] iArr, int i) {
        int i2;
        if (i == 0) {
            i2 = this.a.d.size();
        } else {
            i2 = this.a.e.get(i, -1);
            if (i2 == -1) {
                this.a.q();
                return;
            }
        }
        int length = iArr.length;
        d.k(this.a);
        this.a.d.addAll(i2, t4.a.j(iArr));
        d.m(this.a);
        d.g(this.a, i2, length);
        d.e(this.a);
    }

    public final void j(n4.p[] pVarArr) {
        HashSet hashSet = new HashSet();
        this.a.g.clear();
        for (n4.p pVar : pVarArr) {
            int K = pVar.K();
            this.a.f.put(Integer.valueOf(K), pVar);
            int i = this.a.e.get(K, -1);
            if (i == -1) {
                this.a.q();
                return;
            }
            hashSet.add(Integer.valueOf(i));
        }
        Iterator it = this.a.g.iterator();
        while (it.hasNext()) {
            int i2 = this.a.e.get(((Integer) it.next()).intValue(), -1);
            if (i2 != -1) {
                hashSet.add(Integer.valueOf(i2));
            }
        }
        this.a.g.clear();
        ArrayList arrayList = new ArrayList(hashSet);
        Collections.sort(arrayList);
        d.k(this.a);
        d.j(this.a, t4.a.l(arrayList));
        d.e(this.a);
    }

    public final void k(int[] iArr) {
        ArrayList arrayList = new ArrayList();
        for (int i : iArr) {
            this.a.f.remove(Integer.valueOf(i));
            int i2 = this.a.e.get(i, -1);
            if (i2 == -1) {
                this.a.q();
                return;
            } else {
                this.a.e.delete(i);
                arrayList.add(Integer.valueOf(i2));
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        Collections.sort(arrayList);
        d.k(this.a);
        this.a.d.removeAll(t4.a.j(iArr));
        d.m(this.a);
        d.h(this.a, t4.a.l(arrayList));
        d.e(this.a);
    }

    public final void l(List list, List list2, int i) {
        int i2;
        ArrayList arrayList = new ArrayList();
        if (i == 0) {
            i2 = this.a.d.size();
        } else if (list2.isEmpty()) {
            d.d(this.a).f("Received a Queue Reordered message with an empty reordered items IDs list.", new Object[0]);
            i2 = -1;
        } else {
            i2 = this.a.e.get(i, -1);
            if (i2 == -1) {
                i2 = this.a.e.get(((Integer) list2.get(0)).intValue(), -1);
            }
        }
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            int i3 = this.a.e.get(((Integer) it.next()).intValue(), -1);
            if (i3 == -1) {
                this.a.q();
                return;
            }
            arrayList.add(Integer.valueOf(i3));
        }
        d.k(this.a);
        d dVar = this.a;
        dVar.d = list;
        d.m(dVar);
        d.i(this.a, arrayList, i2);
        d.e(this.a);
    }

    public final void m(int[] iArr) {
        ArrayList arrayList = new ArrayList();
        for (int i : iArr) {
            this.a.f.remove(Integer.valueOf(i));
            int i2 = this.a.e.get(i, -1);
            if (i2 == -1) {
                this.a.q();
                return;
            }
            arrayList.add(Integer.valueOf(i2));
        }
        Collections.sort(arrayList);
        d.k(this.a);
        d.j(this.a, t4.a.l(arrayList));
        d.e(this.a);
    }

    public final void n() {
        this.a.q();
    }
}
