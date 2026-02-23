package K0;

import K0.l;
import android.animation.TimeInterpolator;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class p extends l {
    public int L;
    public ArrayList J = new ArrayList();
    public boolean K = true;
    public boolean M = false;
    public int N = 0;

    public class a extends m {
        public final /* synthetic */ l a;

        public a(l lVar) {
            this.a = lVar;
        }

        public void c(l lVar) {
            this.a.U();
            lVar.Q(this);
        }
    }

    public static class b extends m {
        public p a;

        public b(p pVar) {
            this.a = pVar;
        }

        public void a(l lVar) {
            p pVar = this.a;
            if (pVar.M) {
                return;
            }
            pVar.b0();
            this.a.M = true;
        }

        public void c(l lVar) {
            p pVar = this.a;
            int i = pVar.L - 1;
            pVar.L = i;
            if (i == 0) {
                pVar.M = false;
                pVar.p();
            }
            lVar.Q(this);
        }
    }

    public void O(View view) {
        super.O(view);
        int size = this.J.size();
        for (int i = 0; i < size; i++) {
            ((l) this.J.get(i)).O(view);
        }
    }

    public void S(View view) {
        super.S(view);
        int size = this.J.size();
        for (int i = 0; i < size; i++) {
            ((l) this.J.get(i)).S(view);
        }
    }

    public void U() {
        if (this.J.isEmpty()) {
            b0();
            p();
            return;
        }
        p0();
        if (this.K) {
            Iterator it = this.J.iterator();
            while (it.hasNext()) {
                ((l) it.next()).U();
            }
            return;
        }
        for (int i = 1; i < this.J.size(); i++) {
            ((l) this.J.get(i - 1)).b(new a((l) this.J.get(i)));
        }
        l lVar = (l) this.J.get(0);
        if (lVar != null) {
            lVar.U();
        }
    }

    public void W(l.e eVar) {
        super.W(eVar);
        this.N |= 8;
        int size = this.J.size();
        for (int i = 0; i < size; i++) {
            ((l) this.J.get(i)).W(eVar);
        }
    }

    public void Y(g gVar) {
        super.Y(gVar);
        this.N |= 4;
        if (this.J != null) {
            for (int i = 0; i < this.J.size(); i++) {
                ((l) this.J.get(i)).Y(gVar);
            }
        }
    }

    public void Z(o oVar) {
        super.Z(oVar);
        this.N |= 2;
        int size = this.J.size();
        for (int i = 0; i < size; i++) {
            ((l) this.J.get(i)).Z(oVar);
        }
    }

    public String c0(String str) {
        String c0 = super.c0(str);
        for (int i = 0; i < this.J.size(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(c0);
            sb.append("\n");
            sb.append(((l) this.J.get(i)).c0(str + "  "));
            c0 = sb.toString();
        }
        return c0;
    }

    public void cancel() {
        super.cancel();
        int size = this.J.size();
        for (int i = 0; i < size; i++) {
            ((l) this.J.get(i)).cancel();
        }
    }

    /* renamed from: d0, reason: merged with bridge method [inline-methods] */
    public p b(l.f fVar) {
        return (p) super.b(fVar);
    }

    /* renamed from: e0, reason: merged with bridge method [inline-methods] */
    public p c(View view) {
        for (int i = 0; i < this.J.size(); i++) {
            ((l) this.J.get(i)).c(view);
        }
        return (p) super.c(view);
    }

    public p f0(l lVar) {
        g0(lVar);
        long j = this.d;
        if (j >= 0) {
            lVar.V(j);
        }
        if ((this.N & 1) != 0) {
            lVar.X(t());
        }
        if ((this.N & 2) != 0) {
            x();
            lVar.Z(null);
        }
        if ((this.N & 4) != 0) {
            lVar.Y(w());
        }
        if ((this.N & 8) != 0) {
            lVar.W(s());
        }
        return this;
    }

    public void g(s sVar) {
        if (H(sVar.b)) {
            Iterator it = this.J.iterator();
            while (it.hasNext()) {
                l lVar = (l) it.next();
                if (lVar.H(sVar.b)) {
                    lVar.g(sVar);
                    sVar.c.add(lVar);
                }
            }
        }
    }

    public final void g0(l lVar) {
        this.J.add(lVar);
        lVar.s = this;
    }

    public l h0(int i) {
        if (i < 0 || i >= this.J.size()) {
            return null;
        }
        return (l) this.J.get(i);
    }

    public void i(s sVar) {
        super.i(sVar);
        int size = this.J.size();
        for (int i = 0; i < size; i++) {
            ((l) this.J.get(i)).i(sVar);
        }
    }

    public int i0() {
        return this.J.size();
    }

    public void j(s sVar) {
        if (H(sVar.b)) {
            Iterator it = this.J.iterator();
            while (it.hasNext()) {
                l lVar = (l) it.next();
                if (lVar.H(sVar.b)) {
                    lVar.j(sVar);
                    sVar.c.add(lVar);
                }
            }
        }
    }

    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public p Q(l.f fVar) {
        return (p) super.Q(fVar);
    }

    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public p R(View view) {
        for (int i = 0; i < this.J.size(); i++) {
            ((l) this.J.get(i)).R(view);
        }
        return (p) super.R(view);
    }

    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public p V(long j) {
        ArrayList arrayList;
        super.V(j);
        if (this.d >= 0 && (arrayList = this.J) != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((l) this.J.get(i)).V(j);
            }
        }
        return this;
    }

    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public l clone() {
        p pVar = (p) super.clone();
        pVar.J = new ArrayList();
        int size = this.J.size();
        for (int i = 0; i < size; i++) {
            pVar.g0(((l) this.J.get(i)).clone());
        }
        return pVar;
    }

    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public p X(TimeInterpolator timeInterpolator) {
        this.N |= 1;
        ArrayList arrayList = this.J;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((l) this.J.get(i)).X(timeInterpolator);
            }
        }
        return (p) super.X(timeInterpolator);
    }

    public p n0(int i) {
        if (i == 0) {
            this.K = true;
        } else {
            if (i != 1) {
                throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + i);
            }
            this.K = false;
        }
        return this;
    }

    public void o(ViewGroup viewGroup, t tVar, t tVar2, ArrayList arrayList, ArrayList arrayList2) {
        long z = z();
        int size = this.J.size();
        for (int i = 0; i < size; i++) {
            l lVar = (l) this.J.get(i);
            if (z > 0 && (this.K || i == 0)) {
                long z2 = lVar.z();
                if (z2 > 0) {
                    lVar.a0(z2 + z);
                } else {
                    lVar.a0(z);
                }
            }
            lVar.o(viewGroup, tVar, tVar2, arrayList, arrayList2);
        }
    }

    /* renamed from: o0, reason: merged with bridge method [inline-methods] */
    public p a0(long j) {
        return (p) super.a0(j);
    }

    public final void p0() {
        b bVar = new b(this);
        Iterator it = this.J.iterator();
        while (it.hasNext()) {
            ((l) it.next()).b(bVar);
        }
        this.L = this.J.size();
    }
}
