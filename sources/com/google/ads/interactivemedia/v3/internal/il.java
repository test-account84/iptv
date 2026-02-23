package com.google.ads.interactivemedia.v3.internal;

import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class il {
    private final bc a;
    private avo b = avo.o();
    private avs c = avs.d();
    private te d;
    private te e;
    private te f;

    public il(bc bcVar) {
        this.a = bcVar;
    }

    public static /* bridge */ /* synthetic */ avo f(il ilVar) {
        return ilVar.b;
    }

    private static te j(az azVar, avo avoVar, te teVar, bc bcVar) {
        be o = azVar.o();
        int i = azVar.i();
        Object f = o.p() ? null : o.f(i);
        int b = (azVar.r() || o.p()) ? -1 : o.m(i, bcVar).b(cq.t(azVar.m()) - bcVar.e);
        for (int i2 = 0; i2 < avoVar.size(); i2++) {
            te teVar2 = (te) avoVar.get(i2);
            if (m(teVar2, f, azVar.r(), azVar.f(), azVar.g(), b)) {
                return teVar2;
            }
        }
        if (avoVar.isEmpty() && teVar != null) {
            if (m(teVar, f, azVar.r(), azVar.f(), azVar.g(), b)) {
                return teVar;
            }
        }
        return null;
    }

    private final void k(avq avqVar, te teVar, be beVar) {
        if (teVar == null) {
            return;
        }
        if (beVar.a(teVar.a) != -1) {
            avqVar.a(teVar, beVar);
            return;
        }
        be beVar2 = (be) this.c.get(teVar);
        if (beVar2 != null) {
            avqVar.a(teVar, beVar2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void l(com.google.ads.interactivemedia.v3.internal.be r4) {
        /*
            r3 = this;
            com.google.ads.interactivemedia.v3.internal.avq r0 = new com.google.ads.interactivemedia.v3.internal.avq
            r0.<init>()
            com.google.ads.interactivemedia.v3.internal.avo r1 = r3.b
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L3b
            com.google.ads.interactivemedia.v3.internal.te r1 = r3.e
            r3.k(r0, r1, r4)
            com.google.ads.interactivemedia.v3.internal.te r1 = r3.f
            com.google.ads.interactivemedia.v3.internal.te r2 = r3.e
            boolean r1 = com.google.ads.interactivemedia.v3.impl.data.k.c(r1, r2)
            if (r1 != 0) goto L21
            com.google.ads.interactivemedia.v3.internal.te r1 = r3.f
            r3.k(r0, r1, r4)
        L21:
            com.google.ads.interactivemedia.v3.internal.te r1 = r3.d
            com.google.ads.interactivemedia.v3.internal.te r2 = r3.e
            boolean r1 = com.google.ads.interactivemedia.v3.impl.data.k.c(r1, r2)
            if (r1 != 0) goto L5d
            com.google.ads.interactivemedia.v3.internal.te r1 = r3.d
            com.google.ads.interactivemedia.v3.internal.te r2 = r3.f
            boolean r1 = com.google.ads.interactivemedia.v3.impl.data.k.c(r1, r2)
            if (r1 != 0) goto L5d
        L35:
            com.google.ads.interactivemedia.v3.internal.te r1 = r3.d
            r3.k(r0, r1, r4)
            goto L5d
        L3b:
            r1 = 0
        L3c:
            com.google.ads.interactivemedia.v3.internal.avo r2 = r3.b
            int r2 = r2.size()
            if (r1 >= r2) goto L52
            com.google.ads.interactivemedia.v3.internal.avo r2 = r3.b
            java.lang.Object r2 = r2.get(r1)
            com.google.ads.interactivemedia.v3.internal.te r2 = (com.google.ads.interactivemedia.v3.internal.te) r2
            r3.k(r0, r2, r4)
            int r1 = r1 + 1
            goto L3c
        L52:
            com.google.ads.interactivemedia.v3.internal.avo r1 = r3.b
            com.google.ads.interactivemedia.v3.internal.te r2 = r3.d
            boolean r1 = r1.contains(r2)
            if (r1 != 0) goto L5d
            goto L35
        L5d:
            com.google.ads.interactivemedia.v3.internal.avs r4 = r0.b()
            r3.c = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.il.l(com.google.ads.interactivemedia.v3.internal.be):void");
    }

    private static boolean m(te teVar, Object obj, boolean z, int i, int i2, int i3) {
        if (!teVar.a.equals(obj)) {
            return false;
        }
        if (z) {
            if (teVar.b != i || teVar.c != i2) {
                return false;
            }
        } else if (teVar.b != -1 || teVar.e != i3) {
            return false;
        }
        return true;
    }

    public final be a(te teVar) {
        return (be) this.c.get(teVar);
    }

    public final te b() {
        return this.d;
    }

    public final te c() {
        if (this.b.isEmpty()) {
            return null;
        }
        return (te) axo.z(this.b);
    }

    public final te d() {
        return this.e;
    }

    public final te e() {
        return this.f;
    }

    public final void g(az azVar) {
        this.d = j(azVar, this.b, this.e, this.a);
    }

    public final void h(List list, te teVar, az azVar) {
        this.b = avo.m(list);
        if (!list.isEmpty()) {
            this.e = (te) list.get(0);
            af.s(teVar);
            this.f = teVar;
        }
        if (this.d == null) {
            this.d = j(azVar, this.b, this.e, this.a);
        }
        l(azVar.o());
    }

    public final void i(az azVar) {
        this.d = j(azVar, this.b, this.e, this.a);
        l(azVar.o());
    }
}
