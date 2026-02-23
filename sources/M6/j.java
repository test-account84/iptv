package M6;

import java.util.Collection;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class j extends k {
    public static final p[] b = new p[0];
    public final p[] a;

    /* JADX WARN: Removed duplicated region for block: B:12:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public j(java.util.Map r3) {
        /*
            r2 = this;
            r2.<init>()
            if (r3 != 0) goto L7
            r3 = 0
            goto Lf
        L7:
            x6.e r0 = x6.e.POSSIBLE_FORMATS
            java.lang.Object r3 = r3.get(r0)
            java.util.Collection r3 = (java.util.Collection) r3
        Lf:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            if (r3 == 0) goto L55
            x6.a r1 = x6.a.EAN_13
            boolean r1 = r3.contains(r1)
            if (r1 == 0) goto L27
            M6.e r1 = new M6.e
            r1.<init>()
        L23:
            r0.add(r1)
            goto L35
        L27:
            x6.a r1 = x6.a.UPC_A
            boolean r1 = r3.contains(r1)
            if (r1 == 0) goto L35
            M6.l r1 = new M6.l
            r1.<init>()
            goto L23
        L35:
            x6.a r1 = x6.a.EAN_8
            boolean r1 = r3.contains(r1)
            if (r1 == 0) goto L45
            M6.f r1 = new M6.f
            r1.<init>()
            r0.add(r1)
        L45:
            x6.a r1 = x6.a.UPC_E
            boolean r3 = r3.contains(r1)
            if (r3 == 0) goto L55
            M6.q r3 = new M6.q
            r3.<init>()
            r0.add(r3)
        L55:
            boolean r3 = r0.isEmpty()
            if (r3 == 0) goto L73
            M6.e r3 = new M6.e
            r3.<init>()
            r0.add(r3)
            M6.f r3 = new M6.f
            r3.<init>()
            r0.add(r3)
            M6.q r3 = new M6.q
            r3.<init>()
            r0.add(r3)
        L73:
            M6.p[] r3 = M6.j.b
            java.lang.Object[] r3 = r0.toArray(r3)
            M6.p[] r3 = (M6.p[]) r3
            r2.a = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: M6.j.<init>(java.util.Map):void");
    }

    public x6.o c(int i, D6.a aVar, Map map) {
        int[] p = p.p(aVar);
        for (p pVar : this.a) {
            try {
                x6.o m = pVar.m(i, aVar, p, map);
                boolean z = m.b() == x6.a.EAN_13 && m.f().charAt(0) == '0';
                Collection collection = map == null ? null : (Collection) map.get(x6.e.POSSIBLE_FORMATS);
                boolean z2 = collection == null || collection.contains(x6.a.UPC_A);
                if (!z || !z2) {
                    return m;
                }
                x6.o oVar = new x6.o(m.f().substring(1), m.c(), m.e(), x6.a.UPC_A);
                oVar.g(m.d());
                return oVar;
            } catch (x6.n unused) {
            }
        }
        throw x6.k.a();
    }

    public void reset() {
        for (p pVar : this.a) {
            pVar.reset();
        }
    }
}
