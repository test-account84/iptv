package y;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class c extends m {
    public ArrayList k;
    public int l;

    public c(x.e eVar, int i) {
        super(eVar);
        this.k = new ArrayList();
        this.f = i;
        q();
    }

    /* JADX WARN: Removed duplicated region for block: B:117:0x01d0 A[PHI: r1 r22 r23 r24
      0x01d0: PHI (r1v51 int) = (r1v49 int), (r1v57 int) binds: [B:125:0x01ce, B:114:0x01a8] A[DONT_GENERATE, DONT_INLINE]
      0x01d0: PHI (r22v1 float) = (r22v0 float), (r22v3 float) binds: [B:125:0x01ce, B:114:0x01a8] A[DONT_GENERATE, DONT_INLINE]
      0x01d0: PHI (r23v4 boolean) = (r23v3 boolean), (r23v6 boolean) binds: [B:125:0x01ce, B:114:0x01a8] A[DONT_GENERATE, DONT_INLINE]
      0x01d0: PHI (r24v4 int) = (r24v3 int), (r24v6 int) binds: [B:125:0x01ce, B:114:0x01a8] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x014f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(y.d r26) {
        /*
            Method dump skipped, instructions count: 1037
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: y.c.a(y.d):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00a5 A[PHI: r0 r1
      0x00a5: PHI (r0v13 int) = (r0v10 int), (r0v19 int) binds: [B:32:0x00a3, B:20:0x006d] A[DONT_GENERATE, DONT_INLINE]
      0x00a5: PHI (r1v3 y.f) = (r1v2 y.f), (r1v7 y.f) binds: [B:32:0x00a3, B:20:0x006d] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void d() {
        /*
            r5 = this;
            java.util.ArrayList r0 = r5.k
            java.util.Iterator r0 = r0.iterator()
        L6:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L16
            java.lang.Object r1 = r0.next()
            y.m r1 = (y.m) r1
            r1.d()
            goto L6
        L16:
            java.util.ArrayList r0 = r5.k
            int r0 = r0.size()
            r1 = 1
            if (r0 >= r1) goto L20
            return
        L20:
            java.util.ArrayList r2 = r5.k
            r3 = 0
            java.lang.Object r2 = r2.get(r3)
            y.m r2 = (y.m) r2
            x.e r2 = r2.b
            java.util.ArrayList r4 = r5.k
            int r0 = r0 - r1
            java.lang.Object r0 = r4.get(r0)
            y.m r0 = (y.m) r0
            x.e r0 = r0.b
            int r4 = r5.f
            if (r4 != 0) goto L70
            x.d r1 = r2.B
            x.d r0 = r0.D
            y.f r2 = r5.i(r1, r3)
            int r1 = r1.b()
            x.e r4 = r5.r()
            if (r4 == 0) goto L52
            x.d r1 = r4.B
            int r1 = r1.b()
        L52:
            if (r2 == 0) goto L59
            y.f r4 = r5.h
            r5.b(r4, r2, r1)
        L59:
            y.f r1 = r5.i(r0, r3)
            int r0 = r0.b()
            x.e r2 = r5.s()
            if (r2 == 0) goto L6d
            x.d r0 = r2.D
            int r0 = r0.b()
        L6d:
            if (r1 == 0) goto Lab
            goto La5
        L70:
            x.d r2 = r2.C
            x.d r0 = r0.E
            y.f r3 = r5.i(r2, r1)
            int r2 = r2.b()
            x.e r4 = r5.r()
            if (r4 == 0) goto L88
            x.d r2 = r4.C
            int r2 = r2.b()
        L88:
            if (r3 == 0) goto L8f
            y.f r4 = r5.h
            r5.b(r4, r3, r2)
        L8f:
            y.f r1 = r5.i(r0, r1)
            int r0 = r0.b()
            x.e r2 = r5.s()
            if (r2 == 0) goto La3
            x.d r0 = r2.E
            int r0 = r0.b()
        La3:
            if (r1 == 0) goto Lab
        La5:
            y.f r2 = r5.i
            int r0 = -r0
            r5.b(r2, r1, r0)
        Lab:
            y.f r0 = r5.h
            r0.a = r5
            y.f r0 = r5.i
            r0.a = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: y.c.d():void");
    }

    public void e() {
        for (int i = 0; i < this.k.size(); i++) {
            ((m) this.k.get(i)).e();
        }
    }

    public void f() {
        this.c = null;
        Iterator it = this.k.iterator();
        while (it.hasNext()) {
            ((m) it.next()).f();
        }
    }

    public long j() {
        int size = this.k.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            j = j + r4.h.f + ((m) this.k.get(i)).j() + r4.i.f;
        }
        return j;
    }

    public boolean m() {
        int size = this.k.size();
        for (int i = 0; i < size; i++) {
            if (!((m) this.k.get(i)).m()) {
                return false;
            }
        }
        return true;
    }

    public final void q() {
        x.e eVar;
        x.e eVar2 = this.b;
        do {
            eVar = eVar2;
            eVar2 = eVar2.F(this.f);
        } while (eVar2 != null);
        this.b = eVar;
        this.k.add(eVar.H(this.f));
        x.e D = eVar.D(this.f);
        while (D != null) {
            this.k.add(D.H(this.f));
            D = D.D(this.f);
        }
        Iterator it = this.k.iterator();
        while (it.hasNext()) {
            m mVar = (m) it.next();
            int i = this.f;
            if (i == 0) {
                mVar.b.c = this;
            } else if (i == 1) {
                mVar.b.d = this;
            }
        }
        if (this.f == 0 && ((x.f) this.b.E()).V0() && this.k.size() > 1) {
            ArrayList arrayList = this.k;
            this.b = ((m) arrayList.get(arrayList.size() - 1)).b;
        }
        this.l = this.f == 0 ? this.b.v() : this.b.J();
    }

    public final x.e r() {
        for (int i = 0; i < this.k.size(); i++) {
            m mVar = (m) this.k.get(i);
            if (mVar.b.M() != 8) {
                return mVar.b;
            }
        }
        return null;
    }

    public final x.e s() {
        for (int size = this.k.size() - 1; size >= 0; size--) {
            m mVar = (m) this.k.get(size);
            if (mVar.b.M() != 8) {
                return mVar.b;
            }
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ChainRun ");
        sb.append(this.f == 0 ? "horizontal : " : "vertical : ");
        String sb2 = sb.toString();
        Iterator it = this.k.iterator();
        while (it.hasNext()) {
            String str = sb2 + "<";
            sb2 = (str + ((m) it.next())) + "> ";
        }
        return sb2;
    }
}
